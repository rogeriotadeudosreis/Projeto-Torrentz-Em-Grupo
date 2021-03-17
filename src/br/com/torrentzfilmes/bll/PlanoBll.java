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

import br.com.torrentzfilmes.dal.PlanoDal;
import br.com.torrentzfilmes.model.Plano;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author roger
 */
public class PlanoBll {

    private static final long serialVersionUID = 1L;
    private PlanoDal planoDal;

    public PlanoBll() {
        super();
        planoDal = new PlanoDal();
    }

    public void adicionarPlano(Plano plano) throws Exception {
        validarPlano(plano);
        planoDal.addPlano(plano);
    }

    public void excluirPlano(Plano plano) throws Exception {
        try {
            planoDal.deletePlano(plano.getId());
        } catch (Exception erro) {
            String mensagem = erro.getMessage();
            if (mensagem.toLowerCase().contains("violates foreign")) {
                throw new Exception("Este registro não pode ser excluído"
                        + " porque existe outros registros vinculados a ele\n");
            }
        }
    }

    public void alterarPlano(Plano plano) throws Exception {
        validarPlanoAlterado(plano);
        try {
            planoDal.updatePlano(plano);
        } catch (Exception erro) {
            String mensagem = erro.getMessage();
            if (mensagem.toLowerCase().contains("descricao_unica")) {
                throw new Exception("A descrição informada já existe nos "
                        + "registros de planos\n");
            }
        }
    }

    public List<Plano> getConsultaPlanos() throws Exception {
        return planoDal.getAllPlanos();
    }

    public Plano getConsultaPorId(int id) throws Exception {
        return planoDal.getPlanoById(id);
    }

    public ArrayList pesquisarPlano(String dados) throws Exception {
        return planoDal.sourcePlanos(dados);
    }

    public ResultSet buscaInteligente(String nome) throws Exception {
        return planoDal.sourceInteligente(nome);
    }

    public void validarPlano(Plano objeto) throws Exception {
        String nome = objeto.getDescricao().trim().toLowerCase();
        String invalidos = "!@#$%¨&*()+={[}]/?><;:";
        for (int i = 0; i < invalidos.length(); i++) {
            if (nome.contains("" + invalidos.charAt(i))) {
                throw new Exception("Descrição inválida para esta categoria!\n");
            }
        }
        if (nome.equals("")) {
            throw new Exception("Informe a descrição do plano\n");
        }
        if (nome.length() < 3) {
            throw new Exception("A descrição do plano deve ter no mínimo 3 letras!\n");
        }
        if (objeto.getAcessoSimultaneo() <= 0) {
            throw new Exception("O acesso simultâneo deve ser maior que zero\n");
        }
        if (objeto.getPreco().equals(0)) {
            throw new Exception("O preço do plano não pode ser negativo\nVerifique\n");
        }

        List<Plano> lista = planoDal.getAllPlanos();
        for (int pos = 0; pos < lista.size(); pos++) {
            Plano plano = lista.get(pos);
            if (nome.equalsIgnoreCase(plano.getDescricao())) {
                throw new Exception("A descrição informada já existe no cadastro"
                        + "de categorias\n");
            }
        }
    }

    public void validarPlanoAlterado(Plano objeto) throws Exception {
        String nome = objeto.getDescricao().trim().toLowerCase();
        String invalidos = "!@#$%¨&*()+={[}]/?><;:";
        for (int i = 0; i < invalidos.length(); i++) {
            if (nome.contains("" + invalidos.charAt(i))) {
                throw new Exception("Descrição inválida para esta categoria!\n");
            }
        }
        if (nome.equals("")) {
            throw new Exception("Informe a descrição do plano\n");
        }
        if (nome.length() < 3) {
            throw new Exception("A descrição do plano deve ter no mínimo 3 letras!\n");
        }
        if (objeto.getAcessoSimultaneo() <= 0) {
            throw new Exception("O acesso simultâneo deve ser maior que zero\n");
        }
        if (objeto.getPreco().equals(0)) {
            throw new Exception("O preço do plano não pode ser negativo\nVerifique\n");
        }

        List<Plano> lista = planoDal.getAllPlanos();
        for (int pos = 0; pos < lista.size(); pos++) {
            Plano plano = lista.get(pos);
            if (nome.equalsIgnoreCase(plano.getDescricao())
                    && objeto.getPreco().equals(plano.getPreco())) {
                throw new Exception("A descrição informada já existe no cadastro\n"
                        + "de categorias\n");
            }
        }
    }

    public void ordenaListaPlanos(List<Plano> lista) throws Exception {
        for (int i = 0; i < lista.size(); i++) {
            for (int j = i; j < lista.size(); j++) {
                if (lista.get(i).getDescricao().compareToIgnoreCase(lista.get(j).getDescricao()) >= 0) {
                    Plano temp = lista.get(j);
                    lista.set(j, lista.get(i));
                    lista.set(i, temp);
                }
            }
        }
        // retorna o array ordenado por nome
    }

}
