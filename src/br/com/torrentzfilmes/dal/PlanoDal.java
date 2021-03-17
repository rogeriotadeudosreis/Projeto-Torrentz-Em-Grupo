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

import br.com.torrentzfilmes.model.Plano;
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
public class PlanoDal {

    private Connection conexao;

    public PlanoDal() {
        conexao = Conexao.getConexao();
    }

    public void addPlano(Plano plano) throws Exception {
        String sql = "INSERT INTO tb_planos (pla_acesso_simultaneo,pla_descricao,"
                + "pla_preco) VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            
            preparedStatement.setInt(1, plano.getAcessoSimultaneo());
            preparedStatement.setString(2, plano.getDescricao().trim());
            preparedStatement.setBigDecimal(3, plano.getPreco());
            preparedStatement.executeUpdate();

        } catch (SQLException erro) {
            throw erro;
        }
    }

    public void deletePlano(int id) throws Exception {
        String sql = "DELETE FROM tb_planos WHERE pla_iden=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception erro) {
            throw erro;
        }
    }

    public void updatePlano(Plano plano) throws Exception {
        String sql = "UPDATE tb_planos SET pla_acesso_simultaneo=?, pla_descricao=?,"
                + "pla_preco=? WHERE pla_iden=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, plano.getAcessoSimultaneo());
            preparedStatement.setString(2, plano.getDescricao().trim());
            preparedStatement.setBigDecimal(3, plano.getPreco());
            preparedStatement.setInt(4, plano.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException erro) {
            throw erro;
        }
    }

    public List<Plano> getAllPlanos() throws Exception {
        List<Plano> listaPlanos = new ArrayList<>();
        String sql = "SELECT * FROM tb_planos";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Plano plano = new Plano();
                plano.setId(rs.getInt("pla_iden"));
                plano.setAcessoSimultaneo(rs.getInt("pla_acesso_simultaneo"));
                plano.setDescricao(rs.getString("pla_descricao"));
                plano.setPreco(rs.getBigDecimal("pla_preco"));

                listaPlanos.add(plano);
            }
        } catch (Exception erro) {
            throw erro;
        }
        return listaPlanos;
    }

    public Plano getPlanoById(int id) throws Exception {
        Plano plano = new Plano();
        String sql = "SELECT * FROM tb_planos WHERE pla_iden=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                plano.setId(rs.getInt("pla_iden"));
                plano.setAcessoSimultaneo(rs.getInt("pla_acesso_simultaneo"));
                plano.setDescricao(rs.getString("pla_descricao"));
                plano.setPreco(rs.getBigDecimal("pla_preco"));
            }
        } catch (Exception erro) {
            throw erro;
        }
        return plano;
    }

    public ArrayList sourcePlanos(String dados) throws Exception {
        String textoDigitado = dados;
        ArrayList<Plano> resultado = new ArrayList<>();
        boolean existe = false;
        for (Plano plano : getAllPlanos()) {
            if (plano.getDescricao().toLowerCase().trim().contains(textoDigitado)) {
                resultado.add(plano);
                existe = true;
            }
        }
        if (!existe) {
            throw new Exception("Registro não encontrado!\n");
        }
        return resultado;
    }

    public ResultSet sourceInteligente(String nome) {
        ResultSet rs = null;

        String sql = "SELECT * FROM tb_planos where pla_descricao like ?";
        PreparedStatement pst;

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nome + "%");
            rs = pst.executeQuery();

        } catch (Exception e) {
        }
        return rs;
    }

}
