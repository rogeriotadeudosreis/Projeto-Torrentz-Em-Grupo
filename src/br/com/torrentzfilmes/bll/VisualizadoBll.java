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

import br.com.torrentzfilmes.dal.visualizadoDal;
import br.com.torrentzfilmes.model.Visualizado;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author roger
 */
public class VisualizadoBll {

    private static final long serialVersionUID = 1L;
    private visualizadoDal visDal;

    public VisualizadoBll() {
        visDal = new visualizadoDal();
    }

    public void adicionarVisualizado(Visualizado visual) throws Exception {
        validarVisualizado(visual);
        visDal.addVisualizado(visual);
    }
    
    public void adicionarTodos(List<Visualizado> visualizados) throws Exception {
        visDal.addAll(visualizados);
    }    

    public void excluirVisualizado(int id) throws Exception {
        try {
            visDal.deleteVisualizado(id);
        } catch (Exception erro) {
            String mensagem = erro.getMessage();
            if (mensagem.toLowerCase().contains("violates foreign")) {
                throw new Exception("Este registro não pode ser excluído"
                        + " porque existe outros registros vinculados a ele\n");
            }
        }
    }

    public List<Visualizado> getConsultaVisualizados() throws Exception {
        return visDal.getAllVisualizados();
    }

    public Visualizado getVisualizadoPorId(int id) throws Exception {
        return visDal.getVisualizadoById(id);
    }

    public ArrayList pesquisarVisualizado(String dados) throws Exception {
        return visDal.sourceVisualizado(dados);
    }

    public void validarVisualizado(Visualizado objeto) throws Exception {

        if (objeto.getDataVisualizacao().before(new Date())) {
            throw new Exception("A data da visualização está incorreta!\n");
        }
       
    }
    
    public void alterarVisualizado(Visualizado visual) throws Exception {
        visDal.updateByFilmeAndUsuario(visual);
    }    

    public Visualizado buscarPorFilmeEUsuario(Visualizado visualizado) throws Exception {
       return visDal.getVisualizadoByFilmeAndUsuario(visualizado);
    }
}
