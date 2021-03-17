package br.com.torrentzfilmes.dal;

import br.com.torrentzfilmes.model.Visualizado;
import br.com.torrentzfilmes.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author roger
 */
public class visualizadoDal {

    private Connection conexao;

    public visualizadoDal() {
        conexao = Conexao.getConexao();
    }
    
    public void addAll(List<Visualizado> visualizados) throws Exception {

        StringBuilder sql = new StringBuilder();

        sql.append("UPDATE tb_visualizados "
                + "SET vis_completo = true "
                + "FROM tb_visualizados v "
                + "JOIN tb_usuarios u on u.usu_iden = v.vis_usu_iden " 
                + "JOIN tb_filmes f on f.fil_iden   = v.vis_fil_iden "
                + "WHERE u.usu_iden = ? "
                + "AND vis_fil_iden IN (");
        
        try {
            
            for (Visualizado visualizdo : visualizados) {
                sql.append(visualizdo.getFilme().getId());
                sql.append(",");
            }
            
            sql.append(")");

            PreparedStatement preparedStatement = conexao.prepareStatement(sql.toString());

            preparedStatement.setString(1, String.valueOf(visualizados.get(0).getUsuario().getId()));

            preparedStatement.executeUpdate();

        } catch (SQLException erro) {
            throw new Exception("Ocorreu um erro ao adicionar este registro\n"
                    + erro.getMessage());
        }
    }     

    public void addVisualizado(Visualizado visual) throws Exception {

        String sql = "INSERT INTO tb_visualizados (vis_completo,"
                    + "vis_data_visualizacao,"
                    + "vis_usu_iden,"
                    + "vis_fil_iden) VALUES (?,?,?,?)";
        try {

            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setBoolean(1, visual.isCompleto());
            preparedStatement.setDate(2, new java.sql.Date(visual.getDataVisualizacao().getTime()));
            preparedStatement.setInt(3, visual.getUsuario().getId());
            preparedStatement.setInt(4, visual.getFilme().getId());

            preparedStatement.executeUpdate();

        } catch (SQLException erro) {
           throw erro;
        }
    }

    public void deleteVisualizado(int id) throws Exception {
        String sql = "DELETE FROM tb_visualizados WHERE vis_iden=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException erro) {
            throw erro;
        }
    }

    public void updateVisualizado(Visualizado visual) throws Exception {
        String sql = "UPDATE tb_visualizados SET vis_completo=?,"
                + "vis_data_visualizacao=?,"
                + "vis_usu_iden=?,"
                + "vis_fil_iden=? WHERE vis_iden=?";
        try {
            PreparedStatement preparedStatement
                    = conexao.prepareStatement(sql);

            preparedStatement.setBoolean(1, visual.isCompleto());
            preparedStatement.setDate(2, new java.sql.Date(visual.getDataVisualizacao().getTime()));
            preparedStatement.setInt(3, visual.getUsuario().getId());
            preparedStatement.setInt(4, visual.getFilme().getId());
            preparedStatement.setInt(5, visual.getId());
            preparedStatement.executeUpdate();

        } catch (Exception erro) {
            throw erro;
        }
    }

    public List<Visualizado> getAllVisualizados() throws Exception {
        List<Visualizado> listaVisualizados = new ArrayList<Visualizado>();
        String sql = "SELECT * FROM tb_visualizados";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Visualizado visual = new Visualizado();
                visual.setId(rs.getInt("vis_iden"));
                visual.setCompleto(rs.getBoolean("vis_completo"));
                visual.setDataVisualizacao(rs.getDate("vis_data_visualizacao"));
                UsuarioDal usu = new UsuarioDal();
                visual.setUsuario(usu.getUsuarioById(rs.getInt("vis_usu_iden")));
                FilmeDal fil = new FilmeDal();
                visual.setFilme(fil.getFilmesById(rs.getInt("vis_fil_iden")));

                listaVisualizados.add(visual);
            }
        } catch (Exception erro) {
            throw new Exception("Ocorreu um erro ao consultar "
                    + "os registros de visualizados\n"
                    + erro.getMessage());
        }
        return listaVisualizados;
    }

    public Visualizado getVisualizadoById(int id) throws Exception {
        Visualizado visual = new Visualizado();
        String sql = "SELECT * FROM tb_visualizados WHERE vis_iden=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                visual.setId(rs.getInt("vis_iden"));
                visual.setCompleto(rs.getBoolean("vis_completo"));
                visual.setDataVisualizacao(rs.getDate("vis_data_visualizacao"));
                UsuarioDal usu = new UsuarioDal();
                visual.setUsuario(usu.getUsuarioById(rs.getInt("vis_usu_iden")));
                FilmeDal fil = new FilmeDal();
                visual.setFilme(fil.getFilmesById(rs.getInt("vis_fil_iden")));

            }
        } catch (Exception erro) {
            throw new Exception("Ocorreu um erro ao buscar este registro de miniaturas\n"
                    + erro.getMessage());
        }
        return visual;
    }

    public ArrayList sourceVisualizado(String dados) throws Exception {
        String textoDigitado = dados;
        ArrayList<Visualizado> resultadoDaPesquisa = new ArrayList<>();
        boolean vdd = false;
        for (Visualizado visual : getAllVisualizados()) {
            if (visual.getFilme().getTitulo().toLowerCase().trim().contains(textoDigitado)
                    || visual.getUsuario().getNome().toLowerCase().trim().contains(textoDigitado)) {
                resultadoDaPesquisa.add(visual);
                vdd = true;
            }
        }
        if (!vdd) {
            throw new Exception("Registro não encontrado!\n");
        }
        return resultadoDaPesquisa;
    }

    public void updateByFilmeAndUsuario(Visualizado visualizado) throws Exception {

        String sql = "UPDATE tb_visualizados "
                + "SET vis_completo = ? "
                + "FROM tb_visualizados v "
                + "JOIN tb_usuarios u on u.usu_iden = v.vis_usu_iden " 
                + "JOIN tb_filmes f on f.fil_iden   = v.vis_fil_iden "
                + "WHERE v.vis_iden = ? ";
//                + "AND   v.vis_fil_iden = ?";
        try {
        
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setBoolean(1, visualizado.isCompleto());
            preparedStatement.setInt(2, visualizado.getId());

            preparedStatement.executeUpdate();

        } catch (Exception erro) {
            throw new Exception(erro);
        }        
    }
    
    public Visualizado getVisualizadoByFilmeAndUsuario(Visualizado visualizado) throws Exception {
        Visualizado visual = null;
       
        String sql = "select *from tb_visualizados v "
                + "join tb_usuarios u on u.usu_iden = v.vis_usu_iden "
                + "join tb_filmes f on f.fil_iden = v.vis_fil_iden "
                + "where v.vis_usu_iden = ? "
                + "and   v.vis_fil_iden = ? ";
        
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, visualizado.getUsuario().getId());
            preparedStatement.setInt(2, visualizado.getFilme().getId());
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                visual = new Visualizado();
                visual.setId(rs.getInt("vis_iden"));
                visual.setCompleto(rs.getBoolean("vis_completo"));
                visual.setDataVisualizacao(rs.getDate("vis_data_visualizacao"));
                
                UsuarioDal usu = new UsuarioDal();
                visual.setUsuario(usu.getUsuarioById(rs.getInt("vis_usu_iden")));
                
                FilmeDal fil = new FilmeDal();
                visual.setFilme(fil.getFilmesById(rs.getInt("vis_fil_iden")));

            }
        } catch (Exception erro) {
            throw new Exception("Ocorreu um erro ao buscar este registro de miniaturas\n"
                    + erro.getMessage());
        }
        return visual;
    }    

}
