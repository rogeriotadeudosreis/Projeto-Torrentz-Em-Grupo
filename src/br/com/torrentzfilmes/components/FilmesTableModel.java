package br.com.torrentzfilmes.components;
import br.com.torrentzfilmes.model.Filme;
import java.util.List;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class FilmesTableModel extends ViewAbstractTableModel<Filme> {

    public FilmesTableModel(List<Filme> linhas) {
        super(linhas);
        // Nomes das colunas do cabeçalho da tabela.
        colunas = new String[] {
            "Título", 
            "Categoria",
            "Ano",
            "Selecionar"
        };
    };

//    Recupera o valor do objeto de uma célula. 
    @Override
    public Object getValueAt(int indexLinha, int indexColuna) {
        Filme filme = linhas.get(indexLinha);
        switch(indexColuna) {
            case 0: 
                return filme.getTitulo();
            case 1: 
                return filme.getCategoria();
            case 2: 
                return filme.getAno();
            case 3: 
                return filme.isSelecionado();
            default:
                return null;
        }            
    }
    
     /**
    * JTable usa esse método para determinar o renderizador padrão editor para 
    * cada célula. Se não implementássemos esse método, a última coluna 
    * conteria texto ("true" / "false"), * em vez de uma caixa de seleção.
    * @param c
    * @return 
    */
    @Override
    public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
    }  
  
    /**
     * Defini o valor de uma célula na posição informada.
     * Esta implementação foi sobrescrita para permitir alterar o valor de 
     * uma célula somente se o tipo de dado for Boolean.
     * @param linha int - índice da linha da tabela.
     * @param coluna int - índice da coluna da tabela.
     * @param objeto Object - valor a ser inserido na linha da tabela.
    */    
    @Override
    public void setValueAt(Object objeto, int linha, int coluna) {
        
//          Pega o autor selecionado e altera o valor do selecionado   
            Filme filmeSelecionado = linhas.get(linha); 
            filmeSelecionado.setSelecionado((boolean) objeto);
            
//          Atualiza a tabela
            fireTableCellUpdated(linha, coluna);
    }   
    
      /**
     * Defini se a celula pode ser editavel.
     * Essa implementação foi sobrescrita para  permitir ser editável somente 
     * objetos que sejam do tipo Boolean.
     * @param linha - linha da tabela
     * @param coluna - coluna da tabela
     * @return booelan - informando se é permitido a edição da celula.
     */
    @Override
    public boolean isCellEditable(int linha, int coluna) {
        Object objeto = getValueAt(linha, coluna);
        return objeto instanceof Boolean;
    }       
    
}