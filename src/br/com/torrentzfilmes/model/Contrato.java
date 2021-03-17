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

import br.com.torrentzfilmes.enumeration.EnumStatus;
import java.util.Date;

/**
 *
 * @author roger
 */
public class Contrato {

    private int id;
    private EnumStatus status;
    private Date inicio;
    private Date fim;
    private Usuario usuario;
    private Plano plano;

    public Contrato() {
    }

    public Contrato(int id, EnumStatus status, Date inicio, Date fim, Usuario usuario, Plano plano) {
        this.id = id;
        this.status = status;
        this.inicio = inicio;
        this.fim = fim;
        this.usuario = usuario;
        this.plano = plano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    @Override
    public String toString() {
        return "Contrato{" + "id=" + id + ", status=" + status + ", inicio=" + inicio + ", fim=" + fim + ", usuario=" + usuario + ", plano=" + plano + '}';
    }
}
