package br.com.torrentzfilmes.app;

import br.com.torrentzfilmes.bll.FilmeBll;
import br.com.torrentzfilmes.bll.VisualizadoBll;
import br.com.torrentzfilmes.components.FilmesTableModel;
import br.com.torrentzfilmes.components.ViewAbstractTableModel;
import br.com.torrentzfilmes.model.Filme;
import br.com.torrentzfilmes.model.Usuario;
import br.com.torrentzfilmes.model.Visualizado;
import br.com.torrentzfilmes.util.UtilObjetos;
import br.com.torrentzfilmes.util.UtilTabela;
import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author roger
 */
public class VisualizarFilmesApp1 extends javax.swing.JFrame {

    private VisualizadoBll visualizadoBll;
    private List<Filme> filmesJTable;
    private FilmeBll filmeBll;
    private Usuario usuario;
    private Filme filmeSelecionado;

    public VisualizarFilmesApp1() {
    }

    public VisualizarFilmesApp1(Usuario usuario) {

        initComponents();

        inicializarComponentes();

        this.usuario = usuario;
    }

    public void inicializarComponentes() {

        filmeBll = new FilmeBll();

        filmesJTable = new ArrayList<>();

        visualizadoBll = new VisualizadoBll();

        inicializarJTableFilmes();

        jTablePlanosAddListSelectionListener();

        jTextAreaSinopse.setLineWrap(true);
    }

    private void inicializarJTableFilmes() {
        try {

            filmesJTable = filmeBll.getConsultaFilmes();

            filmeBll.ordenaListaDeFilmes(filmesJTable);

            ViewAbstractTableModel planoTableModel = new FilmesTableModel(this.filmesJTable);

            UtilTabela.inicializarTabela(jTableFilmes, planoTableModel);

        } catch (Exception ex) {
            Logger.getLogger(ContrataPlanoApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jTablePlanosAddListSelectionListener() {
        jTableFilmes.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            try {
                ViewAbstractTableModel filmesTableModel = new FilmesTableModel(this.filmesJTable);

                filmeSelecionado = (Filme) filmesTableModel.getValorDaLinha(jTableFilmes.getSelectedRow());

                filmeSelecionado.setSelecionado(true);

                jTextAreaSinopse.setText(filmeSelecionado.getSinopse());

                int qtdSelecionados = 0;

                for (Filme filme : filmesJTable) {

                    if (!filme.equals(filmeSelecionado)) {
                        filme.setSelecionado(false);
                    }

                    if (filme.isSelecionado() || filmeSelecionado.isSelecionado()) {
                        qtdSelecionados++;
                    }
                }

                filmesTableModel.fireTableDataChanged();

            } catch (Exception ex) {
                Logger.getLogger(ContrataPlanoApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPaneVisualizadorDeFilmes = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jButtonEscolherFilme = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButtonPesquisar = new javax.swing.JButton();
        jTextFieldPesquisarFilme = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFilmes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaSinopse = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jButtonSairDaTelaDeFilme = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonAssistido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Visualizar Filmes - Torrentz Filmes");
        setResizable(false);

        jDesktopPaneVisualizadorDeFilmes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jDesktopPaneVisualizadorDeFilmes.setForeground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bem-Vindo à Torrentz Filmes");

        jButtonEscolherFilme.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonEscolherFilme.setText("Escolha Seu Filme Aqui !");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jTableFilmes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableFilmes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableFilmesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFilmes);

        jTextAreaSinopse.setColumns(20);
        jTextAreaSinopse.setRows(5);
        jScrollPane2.setViewportView(jTextAreaSinopse);

        jLabel3.setText("Sinopse");

        jButtonSairDaTelaDeFilme.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jButtonSairDaTelaDeFilme.setText("Sair");
        jButtonSairDaTelaDeFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairDaTelaDeFilmeActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Play");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonAssistido.setText("Assitido");
        jButtonAssistido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAssistidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonPesquisar)
                        .addGap(28, 28, 28)
                        .addComponent(jTextFieldPesquisarFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAssistido)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSairDaTelaDeFilme)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPesquisar)
                    .addComponent(jTextFieldPesquisarFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSairDaTelaDeFilme)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonAssistido))
                .addContainerGap())
        );

        jDesktopPaneVisualizadorDeFilmes.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneVisualizadorDeFilmes.setLayer(jButtonEscolherFilme, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneVisualizadorDeFilmes.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneVisualizadorDeFilmesLayout = new javax.swing.GroupLayout(jDesktopPaneVisualizadorDeFilmes);
        jDesktopPaneVisualizadorDeFilmes.setLayout(jDesktopPaneVisualizadorDeFilmesLayout);
        jDesktopPaneVisualizadorDeFilmesLayout.setHorizontalGroup(
            jDesktopPaneVisualizadorDeFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneVisualizadorDeFilmesLayout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addGroup(jDesktopPaneVisualizadorDeFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneVisualizadorDeFilmesLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneVisualizadorDeFilmesLayout.createSequentialGroup()
                        .addComponent(jButtonEscolherFilme)
                        .addGap(343, 343, 343))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneVisualizadorDeFilmesLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(243, 243, 243))))
        );
        jDesktopPaneVisualizadorDeFilmesLayout.setVerticalGroup(
            jDesktopPaneVisualizadorDeFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneVisualizadorDeFilmesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButtonEscolherFilme)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPaneVisualizadorDeFilmes)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPaneVisualizadorDeFilmes)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSairDaTelaDeFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairDaTelaDeFilmeActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButtonSairDaTelaDeFilmeActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        try {
//            imprimirFilmes(filmeBll.pesquisarFilme(jTextFieldPesquisarFilme.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jTableFilmesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFilmesMouseReleased
//        try {
//            ViewAbstractTableModel filmesTableModel = new FilmesTableModel(this.filmesJTable);
//
//            Filme filmeSelecionado = (Filme) filmesTableModel.getValorDaLinha(jTableFilmes.getSelectedRow());
//
//            filme = filmeBll.getConsultaFilmePorId(filmeSelecionado.getId());
//
//
//
//            filmesTableModel.fireTableDataChanged();
//
//        } catch (Exception ex) {
//            Logger.getLogger(ContrataPlanoApp.class.getName()).log(Level.SEVERE, null, ex);
//        }            
    }//GEN-LAST:event_jTableFilmesMouseReleased

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        try {
            String HOME_USUARIO = System.getProperty("user.home");

            String path = filmeSelecionado.getCaminho();

            int index = filmeSelecionado.getCaminho().lastIndexOf("\\");

            String nomeArquivo = path.substring(index + 1, path.length());

            Desktop.getDesktop().open(new File(HOME_USUARIO + File.separator + nomeArquivo));

            Visualizado visualizado = new Visualizado();
            visualizado.setCompleto(false);
            visualizado.setFilme(filmeSelecionado);
            visualizado.setDataVisualizacao(new Date());
            visualizado.setUsuario(this.usuario);
            visualizadoBll.adicionarVisualizado(visualizado);

        } catch (Exception ex) {
            Logger.getLogger(VisualizarFilmesApp1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonAssistidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAssistidoActionPerformed
        try {
            Visualizado visualizado = new Visualizado();
            visualizado.setFilme(filmeSelecionado);
            visualizado.setUsuario(this.usuario);

            Visualizado visualizadoBanco = visualizadoBll.buscarPorFilmeEUsuario(visualizado);

            if (!UtilObjetos.ehNuloOuVazio(visualizadoBanco)) {
                visualizadoBanco.setCompleto(true);
                visualizadoBll.alterarVisualizado(visualizadoBanco);
                JOptionPane.showMessageDialog(null, "Você concluiu a visualização deste filme!");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi iniciado o filme!");
            }

        } catch (Exception ex) {
            Logger.getLogger(VisualizarFilmesApp1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAssistidoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualizarFilmesApp1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAssistido;
    private javax.swing.JButton jButtonEscolherFilme;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSairDaTelaDeFilme;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JDesktopPane jDesktopPaneVisualizadorDeFilmes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableFilmes;
    private javax.swing.JTextArea jTextAreaSinopse;
    private javax.swing.JTextField jTextFieldPesquisarFilme;
    // End of variables declaration//GEN-END:variables
}
