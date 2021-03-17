/*
 * Senai Fatesg Faculdade de Tecnologia
 * ADS - Análise e Desenvolvimento de Sistemas
 * Projeto Torrentz Filmes
 * Atividade integrando as disciplinas:
 * Arquitetura e Projeto de Software;
 * Gestão de Projetos;
 * Modelagem de Banco de Dados
 * Alunos: Aires Ribeiro, Gabriel Cunha, Lucas França e Rogério Reis
 */
package br.com.torrentzfilmes.dal;

import br.com.torrentzfilmes.enumeration.EnumStatus;
import br.com.torrentzfilmes.model.Contrato;
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
public class ContratoDal {

    private Connection conexao;

    public ContratoDal() {
        conexao = Conexao.getConexao();
    }

    public void addContrato(Contrato cont) throws Exception {

        String sql = "INSERT INTO tb_contratos(con_status,"
                + "con_inicio,"
                + "con_fim,"
                + "con_usu_iden,"
                + "con_pla_iden) VALUES (?,?,?,?,?)";
        try {

            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setString(1, cont.getStatus().name());
            preparedStatement.setDate(2, new java.sql.Date(cont.getInicio().getTime()));
            preparedStatement.setDate(3, new java.sql.Date(cont.getFim().getTime()));
            preparedStatement.setInt(4, cont.getUsuario().getId());
            preparedStatement.setInt(5, cont.getPlano().getId());

            preparedStatement.executeUpdate();

        } catch (SQLException erro) {
            throw new Exception("Ocorreu um erro ao adicionar este registro\n"
                    + erro.getMessage());
        }
    }

    public void deleteContrato(int id) throws Exception {
        String sql = "DELETE FROM tb_contratos WHERE con_iden=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException erro) {
            throw new Exception("Ocorreu um erro ao deletar este registro!\n"
                    + erro.getMessage());
        }
    }

    public void updateContrato(Contrato cont) throws Exception {
        String sql = "UPDATE tb_contratos SET con_status=?,"
                + "con_inicio=?,"
                + "con_fim=?,"
                + "con_usu_iden=?,"
                + "con_pla_iden=? WHERE con_iden=?";
        try {
            PreparedStatement preparedStatement
                    = conexao.prepareStatement(sql);

            preparedStatement.setString(1, cont.getStatus().name());
            preparedStatement.setDate(2, new java.sql.Date(cont.getInicio().getTime()));
            preparedStatement.setDate(3, new java.sql.Date(cont.getFim().getTime()));
            preparedStatement.setInt(4, cont.getUsuario().getId());
            preparedStatement.setInt(5, cont.getPlano().getId());
            preparedStatement.executeUpdate();

        } catch (Exception erro) {
            throw new Exception("Ocorreu um erro ao alterar este registro\n"
                    + erro.getMessage());
        }
    }

    public List<Contrato> getAllContratos() throws Exception {
        List<Contrato> listaContratos = new ArrayList<Contrato>();
        String sql = "SELECT * FROM tb_contratos";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Contrato cont = new Contrato();
                cont.setId(rs.getInt("con_iden"));
                cont.setStatus(EnumStatus.valueOf(rs.getString("con_status")));
                cont.setInicio(rs.getDate("con_inicio"));
                cont.setFim(rs.getDate("con_fim"));
                UsuarioDal usu = new UsuarioDal();
                cont.setUsuario(usu.getUsuarioById(rs.getInt("con_usu_iden")));
                PlanoDal plano = new PlanoDal();
                cont.setPlano(plano.getPlanoById(rs.getInt("con_pla_iden")));

                listaContratos.add(cont);
            }
        } catch (Exception erro) {
            throw new Exception("Ocorreu um erro ao consultar "
                    + "os registros de contratos\n"
                    + erro.getMessage());
        }
        return listaContratos;
    }

    public Contrato getContratosById(int id) throws Exception {
        Contrato cont = new Contrato();
        String sql = "SELECT * FROM tb_contratos WHERE con_iden=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                cont.setId(rs.getInt("con_iden"));
                cont.setStatus(EnumStatus.valueOf(rs.getString("con_status")));
                cont.setInicio(rs.getDate("con_inicio"));
                cont.setFim(rs.getDate("con_fim"));
                UsuarioDal usu = new UsuarioDal();
                cont.setUsuario(usu.getUsuarioById(rs.getInt("con_usu_iden")));
                PlanoDal plano = new PlanoDal();
                cont.setPlano(plano.getPlanoById(rs.getInt("con_pla_iden")));

            }
        } catch (Exception erro) {
            throw new Exception("Ocorreu um erro ao buscar este registro de contratos\n"
                    + erro.getMessage());
        }
        return cont;
    }

    public ArrayList sourceContratos(String dados) throws Exception {
        String textoDigitado = dados;
        ArrayList<Contrato> resultadoDaPesquisa = new ArrayList<>();
        boolean vdd = false;
        for (Contrato cont : getAllContratos()) {
            
            if (cont.getStatus().name().toLowerCase().trim().contains(textoDigitado)
                    || cont.getUsuario().getNome().toLowerCase().trim().contains(textoDigitado)
                    || (cont.getPlano().getDescricao().toLowerCase().trim().contains(textoDigitado))) {
                
                resultadoDaPesquisa.add(cont);
                
                vdd = true;
            }
        }
        if (!vdd) {
            throw new Exception("Registro não encontrado!\n");
        }
        return resultadoDaPesquisa;
    }

}
