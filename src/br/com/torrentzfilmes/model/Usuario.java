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

import br.com.torrentzfilmes.enumeration.EnumPerfil;
import java.util.Date;

/**
 *
 * @author roger
 */
public class Usuario {

    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private int percCupom;
    private Date dataCupom;
    private EnumPerfil perfil;

    public Usuario() {
    }

    public Usuario(String nome, String cpf, String email, String senha,
            int percCupom, Date dataCupom, EnumPerfil perfil) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.percCupom = percCupom;
        this.dataCupom = dataCupom;
        this.perfil = perfil;
    }

    public Usuario(int id, String nome, String cpf, String email, String senha,
            int percCupom, Date dataCupom, EnumPerfil perfil) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.percCupom = percCupom;
        this.dataCupom = dataCupom;
        this.perfil = perfil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getPercCupom() {
        return percCupom;
    }

    public void setPercCupom(int percCupom) {
        this.percCupom = percCupom;
    }

    public Date getDataCupom() {
        return dataCupom;
    }

    public void setDataCupom(Date dataCupom) {
        this.dataCupom = dataCupom;
    }

    public EnumPerfil getPerfil() {
        return perfil;
    }

    public void setPerfil(EnumPerfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return id + nome + cpf + email + senha + percCupom + dataCupom
                + perfil;
    }
}
