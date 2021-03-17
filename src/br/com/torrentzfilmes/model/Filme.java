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
public class Filme {

    private int id;
    private String sinopse;
    private String titulo;
    private int ano;
    private Categoria categoria;
    private String caminho;
    private boolean selecionado;

    public Filme() {
        this.selecionado = false;
    }

    public Filme(String sinopse, String titulo, int ano, Categoria categoria, String caminho) {
        this.sinopse = sinopse;
        this.titulo = titulo;
        this.ano = ano;
        this.categoria = categoria;
        this.caminho = caminho;
    }
    
    public Filme(int id, String sinopse, String titulo, int ano, Categoria categoria, String caminho) {
        this.id = id;
        this.sinopse = sinopse;
        this.titulo = titulo;
        this.ano = ano;
        this.categoria = categoria;
        this.caminho = caminho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }

    @Override
    public String toString() {
        return "Filme{" + "id=" + id + ", sinopse=" + sinopse + ", titulo=" + titulo + ", ano=" + ano + ", categoria=" + categoria + ", caminho=" + caminho + ", selecionado=" + selecionado + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Filme other = (Filme) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    


}
