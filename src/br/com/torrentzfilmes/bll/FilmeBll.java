/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.torrentzfilmes.bll;

import br.com.torrentzfilmes.dal.FilmeDal;
import br.com.torrentzfilmes.model.Filme;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author roger
 */
public class FilmeBll {

    private static final long serialVersionUID = 1L;
    private FilmeDal filmeDal;

    public FilmeBll() {
        filmeDal = new FilmeDal();
    }

    public void adicionarFilme(Filme filme) throws Exception {
        validarFilme(filme);
        try {
            filmeDal.addFilme(filme);
        } catch (Exception erro) {
            String msg = erro.getMessage();
            if (msg.toLowerCase().contains("ano_validado")) {
                throw new Exception("O ano de lançamento do filme é inválido"
                        + "\nVerfique!\n");
            }
        }
    }
    
    public void excluirFilme(Filme filme) throws Exception {
        try {
            filmeDal.deleteFilme(filme.getId());
        } catch (Exception erro) {
            String mensagem = erro.getMessage();
            if (mensagem.toLowerCase().contains("violates foreign")) {
                throw new Exception(" Este registro não pode ser excluído"
                        + " porque existe outros registros vinculados a ele\n");
            }
        }
    }

    public void alterarFilme(Filme filme) throws Exception {
        try {
            filmeDal.updateFilme(filme);
        } catch (Exception erro) {
            String msg = erro.getMessage();
            if (msg.toLowerCase().contains("titulo_unico")) {
                throw new Exception("O título deste filme já existe"
                        + " nos registros de filmes!\n");
            }
            if (msg.toLowerCase().contains("path_unico")) {
                throw new Exception("O caminho do arquivo informado pertence"
                        + " ao registro de outro filme já existente!\n");
            }
            if (msg.toLowerCase().contains("sinopse_unica")) {
                throw new Exception("A sinopse informada pertence "
                        + "ao registro de outro filme já existente!\n");
            }
        }
        if (filme.getAno() < 1895) {
            throw new Exception(" Ano de lançamento do filme inválido\n"
                    + "A primeira exibição cinematográfica foi em "
                    + "dezembro de 1895\nVerifique\n");
        }
        if (filme.getAno() > 2020) {
            throw new Exception(" O ano de lançamento do filme deve estar no "
                    + " intervalo de 1895 a 2020!\nVerifique!\n");
        }
    }

    public List<Filme> getConsultaFilmes() throws Exception {
        return filmeDal.getAllFilmes();
    }

    public Filme getConsultaFilmePorId(int id) throws Exception {
        return filmeDal.getFilmesById(id);
    }

    public ArrayList pesquisarFilme(String nome) throws Exception {
        return filmeDal.sourceFilmes(nome);
    }

    public void validarFilme(Filme objeto) throws Exception {
        String nome = objeto.getTitulo().trim().toLowerCase();
        String invalidos = "!@#$%¨&*()+={[}]/?><;:";
        for (int i = 0; i < invalidos.length(); i++) {
            if (nome.contains("" + invalidos.charAt(i))) {
                throw new Exception(" Título inválido para este filme!\n");
            }
        }
        if (nome.equals("")) {
            throw new Exception("Informe o título do filme\n");
        }
        if (nome.length() < 2) {
            throw new Exception("O título do flme deve ter no mínimo 2 letras!\n");
        }
        if (objeto.getAno() < 1895) {
            throw new Exception(" Ano de lançamento do filme inválido\n"
                    + "A primeira exibição cinematográfica foi em "
                    + "dezembro de 1895\nVerifique\n");
        }
        if (objeto.getAno() > 2020) {
            throw new Exception(" O ano de lançamento do filme deve estar no "
                    + " intervalo de 1895 a 2020!\nVerifique!\n");
        }

        List<Filme> lista = filmeDal.getAllFilmes();
        for (int pos = 0; pos < lista.size(); pos++) {
            Filme fil = lista.get(pos);
            if (nome.equalsIgnoreCase(fil.getTitulo())) {
                throw new Exception(" O título do filme já existe no cadastro\n");
            }
        }
    }

    public void ordenaListaDeFilmes(List<Filme> lista) throws Exception {
        for (int i = 0; i < lista.size(); i++) {
            for (int j = i; j < lista.size(); j++) {
                if (lista.get(i).getTitulo().compareToIgnoreCase(lista.get(j).getTitulo()) >= 0) {
                    Filme temp = lista.get(j);
                    lista.set(j, lista.get(i));
                    lista.set(i, temp);
                }
            }
        }
        // retorna o array ordenado por nome
    }

}
