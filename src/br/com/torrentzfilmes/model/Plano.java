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

import java.math.BigDecimal;

/**
 *
 * @author roger
 */
public class Plano {

    private int id;
    private int acessoSimultaneo;
    private String descricao;
    private BigDecimal preco;
    private boolean selecionado;

    public Plano() {
        selecionado = false;
    }

    public Plano(int id, int acessoSimultaneo, String descricao, BigDecimal preco) {
        this.id = id;
        this.acessoSimultaneo = acessoSimultaneo;
        this.descricao = descricao;
        this.preco = preco;
    }
    
    public Plano(int acessoSimultaneo, String descricao, BigDecimal preco) {
        this.acessoSimultaneo = acessoSimultaneo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAcessoSimultaneo() {
        return acessoSimultaneo;
    }

    public void setAcessoSimultaneo(int acessoSimultaneo) {
        this.acessoSimultaneo = acessoSimultaneo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }

    @Override
    public String toString() {
        return "Plano{" + "id=" + id + ", acessoSimultaneo=" + acessoSimultaneo + ", descricao=" + descricao + ", preco=" + preco + ", selecionado=" + selecionado + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Plano other = (Plano) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
 

}
