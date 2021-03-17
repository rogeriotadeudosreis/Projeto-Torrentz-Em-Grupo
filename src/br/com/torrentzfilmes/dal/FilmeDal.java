/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.torrentzfilmes.dal;

import br.com.torrentzfilmes.model.Filme;
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
public class FilmeDal {

    private Connection conexao;

    public FilmeDal() {
        conexao = Conexao.getConexao();
    }

    public void addFilme(Filme filme) throws Exception {

        String sql = "INSERT INTO tb_filmes(fil_sinopse, fil_titulo,"
                + "fil_ano, fil_cat_iden, fil_path) VALUES (?,?,?,?,?)";
        try {

            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setString(1, filme.getSinopse().trim());
            preparedStatement.setString(2, filme.getTitulo().trim());
            preparedStatement.setInt(3, filme.getAno());
            preparedStatement.setInt(4, filme.getCategoria().getId());
            preparedStatement.setString(5, filme.getCaminho().trim());

            preparedStatement.executeUpdate();

        } catch (SQLException erro) {
            throw new Exception("Ocorreu um erro ao adicionar este registro\n"
                    + erro.getMessage());
        }
    }
    
   

    public void deleteFilme(int id) throws Exception {
        String sql = "DELETE FROM tb_filmes WHERE fil_iden=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException erro) {
            throw erro;
        }
    }

    public void updateFilme(Filme filme) throws Exception {
        String sql = "UPDATE tb_filmes SET fil_sinopse=?,"
                + "fil_titulo=?, fil_ano=?, fil_cat_iden=?, "
                + "fil_path=? WHERE fil_iden=?";
        try {
            PreparedStatement preparedStatement
                    = conexao.prepareStatement(sql);

            preparedStatement.setString(1, filme.getSinopse().trim());
            preparedStatement.setString(2, filme.getTitulo().trim());
            preparedStatement.setInt(3, filme.getAno());
            preparedStatement.setInt(4, filme.getCategoria().getId());
            preparedStatement.setString(5, filme.getCaminho().trim());
            preparedStatement.setInt(6, filme.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException erro) {
            throw erro;
        }
    }

    public List<Filme> getAllFilmes() throws Exception {
        List<Filme> listaFilmes = new ArrayList<Filme>();
        String sql = "SELECT * FROM tb_filmes";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Filme filme = new Filme();
                filme.setId(rs.getInt("fil_iden"));
                filme.setSinopse(rs.getString("fil_sinopse"));
                filme.setTitulo(rs.getString("fil_titulo"));
                filme.setAno(rs.getInt("fil_ano"));
                CategoriaDal catDal = new CategoriaDal();
                filme.setCategoria(catDal.getCategoriaById(rs.getInt("fil_cat_iden")));
                filme.setCaminho(rs.getString("fil_path"));

                listaFilmes.add(filme);
            }
        } catch (Exception erro) {
            throw new Exception("Ocorreu um erro ao consultar "
                    + "os registros de filmes\n"
                    + erro.getMessage());
        }
        return listaFilmes;
    }

    public Filme getFilmesById(int id) throws Exception {
        Filme filme = new Filme();
        String sql = "SELECT * FROM tb_filmes WHERE fil_iden=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                filme.setId(rs.getInt("fil_iden"));
                filme.setSinopse(rs.getString("fil_sinopse"));
                filme.setTitulo(rs.getString("fil_titulo"));
                filme.setAno(rs.getInt("fil_ano"));
                CategoriaDal catDal = new CategoriaDal();
                filme.setCategoria(catDal.getCategoriaById(rs.getInt("fil_cat_iden")));
                filme.setCaminho(rs.getString("fil_path"));

            }
        } catch (Exception erro) {
            throw new Exception("Ocorreu um erro ao buscar este registro de filmes\n"
                    + erro.getMessage());
        }
        return filme;
    }

    public ArrayList sourceFilmes(String dados) throws Exception {
        String textoDigitado = dados.trim().toLowerCase();
        ArrayList<Filme> resultadoDaPesquisa = new ArrayList<>();
        boolean vdd = false;
        for (Filme filme : getAllFilmes()) {
            if (filme.getTitulo().toLowerCase().trim().contains(textoDigitado)
                    || filme.getCategoria().getDescricao().toLowerCase().trim().contains(textoDigitado)
                    || (filme.getSinopse().toLowerCase().trim().contains(textoDigitado))) {
                resultadoDaPesquisa.add(filme);
                vdd = true;
            }
        }
        if (!vdd) {
            throw new Exception("Registro não encontrado!\n");
        }
        return resultadoDaPesquisa;
    }

}
