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

package br.com.torrentzfilmes.model;

/**
 *
 * @author roger
 */
public class Categoria {

    private int id;
    private String descricao;

    public Categoria() {
    }

    public Categoria(String descricao) {
        this.descricao = descricao;
    }
    
    public Categoria(int id,String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    
    public void splitCategoria(String combo)throws Exception{
        String[] str = combo.split(" - ");
        this.id = Integer.parseInt(str[0]);
        this.descricao = str[1];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return id + descricao;
    }

}
