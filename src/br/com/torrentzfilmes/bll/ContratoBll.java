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
package br.com.torrentzfilmes.bll;

import br.com.torrentzfilmes.dal.ContratoDal;
import br.com.torrentzfilmes.model.Contrato;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author roger
 */
public class ContratoBll {

    private ContratoDal contDal;

    public ContratoBll() {
        contDal = new ContratoDal();
    }

    public void adicionarContrato(Contrato contrato) throws Exception {
        validarContrato(contrato);
        contDal.addContrato(contrato);
    }

    public void excluirContrato(int id) throws Exception {
        try {
            contDal.deleteContrato(id);
        } catch (Exception erro) {
            String mensagem = erro.getMessage();
            if (mensagem.toLowerCase().contains("violates foreign")) {
                throw new Exception("Este registro não pode ser excluído"
                        + " porque existe outros registros vinculados a ele\n");
            }
        }
    }

    public void alterarContrato(Contrato contrato) throws Exception {
        contDal.updateContrato(contrato);
    }

    public List<Contrato> getConsultaContratos() throws Exception {
        return contDal.getAllContratos();
    }

    public Contrato getContratoPorId(int id) throws Exception {
        return contDal.getContratosById(id);
    }

    public ArrayList pesquisarContrato(String dados) throws Exception {
        return contDal.sourceContratos(dados);
    }

    public void validarContrato(Contrato objeto) throws Exception {
        if (objeto.getInicio().after(objeto.getFim())) {
            throw new Exception("A data final deve ser posterior à"
                    + " data inicial do contrato\nVerifique\n");
        }
        if (objeto.getFim().equals("")) {
            throw new Exception("A data final do contrato deve ser informada\n");
        }
        if (objeto.getInicio().equals("")) {
            throw new Exception("A data inicial do contrato deve ser informada\n");
        }
        if (objeto.getUsuario().getNome().equals("")) {
            throw new Exception("O usuário deve ser informado para este contrato\n");
        }
        if (objeto.getPlano().getDescricao().equals("")) {
            throw new Exception("A descrição do plano deve ser informada\n");
        }

    }
    
     public void ordenaListaContratos(List<Contrato> lista) throws Exception {
        for (int i = 0; i < lista.size(); i++) {
            for (int j = i; j < lista.size(); j++) {
                if (lista.get(i).getUsuario().getNome().compareToIgnoreCase(lista.get(j).getUsuario().getNome()) >= 0) {
                    Contrato temp = lista.get(j);
                    lista.set(j, lista.get(i));
                    lista.set(i, temp);
                }
            }
        }
    }

}
