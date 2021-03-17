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

import java.util.Date;

/**
 *
 * @author roger
 */
public class Visualizado {

    private int id;
    private boolean completo;
    private Date dataVisualizacao;
    private Usuario usuario;
    private Filme filme;

    public Visualizado() {
    }

    public Visualizado(int id, boolean completo, Date dataVisualizacao, Usuario usuario, Filme filme) {
        this.id = id;
        this.completo = completo;
        this.dataVisualizacao = dataVisualizacao;
        this.usuario = usuario;
        this.filme = filme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCompleto() {
        return completo;
    }

    public void setCompleto(boolean completo) {
        this.completo = completo;
    }

    public Date getDataVisualizacao() {
        return dataVisualizacao;
    }

    public void setDataVisualizacao(Date dataVisualizacao) {
        this.dataVisualizacao = dataVisualizacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    @Override
    public String toString() {
        return "" + id + completo + dataVisualizacao + usuario + filme;
    }
}
