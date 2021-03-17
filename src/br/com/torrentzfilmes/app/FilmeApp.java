/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.torrentzfilmes.app;

import br.com.torrentzfilmes.bll.CategoriaBll;
import br.com.torrentzfilmes.bll.FilmeBll;
import br.com.torrentzfilmes.model.Categoria;
import br.com.torrentzfilmes.model.Filme;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author roger
 */
public class FilmeApp extends javax.swing.JDialog {

    Categoria categoria = new Categoria();
    CategoriaBll catBll = new CategoriaBll();
    FilmeBll filmeBll = new FilmeBll();
    Filme filme;

    /**
     * Creates new form FilmeApp
     */
    public FilmeApp(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        jTextAreaSinopse.setLineWrap(true);
        jButtonExcluir.setEnabled(false);

        List<Categoria> listaDeCategoria = new ArrayList<>();
        listaDeCategoria = catBll.getConsultaCategorias();
        catBll.ordenaListaCategorias(listaDeCategoria);
        jComboBoxCategorias.removeAllItems();
        jComboBoxCategorias.addItem("< Selecione a categoria do filme >");
        for (int pos = 0; pos < listaDeCategoria.size(); pos++) {
            Categoria aux = listaDeCategoria.get(pos);
            jComboBoxCategorias.addItem("" + aux.getId() + " - " 
                    + aux.getDescricao().toUpperCase());
        }
    }

    private void imprimirFilmes(List<Filme> listaDeFilmes) throws Exception {
        DefaultTableModel model = (DefaultTableModel) jTableFilmes.getModel();
        model.setNumRows(0);
        filmeBll.ordenaListaDeFilmes(listaDeFilmes);
        for (int pos = 0; pos < listaDeFilmes.size(); pos++) {
            String[] linha = new String[5];
            Filme aux = listaDeFilmes.get(pos);
            linha[0] = "" + aux.getId();
            linha[1] = aux.getTitulo().toUpperCase();
            linha[2] = "" + aux.getAno();
            linha[3] = aux.getCategoria().getDescricao().toUpperCase();
            model.addRow(linha);
        }
        jTextFieldQuantRegistros.setText(listaDeFilmes.size() + "");
    }

    private void limpaCampos() {
        jTextFieldCodigo.setText("");
        jTextFieldTitulo.setText("");
        jTextFieldAnoDoFilme.setText("");
        jComboBoxCategorias.setSelectedIndex(0);
        jTextFieldCaminhoDoArquivo.setText("");
        jTextAreaSinopse.setText("");
        jTextFieldQuantRegistros.setText("");
        jButtonExcluir.setEnabled(false);
        jButtonSalvar.setLabel("Salvar");
        jTextFieldTitulo.requestFocus();

    }

    private void preencherCampos(int id) {
        try {
            if (id > 0) {
                filme = filmeBll.getConsultaFilmePorId(id);
                jTextFieldCodigo.setText(id + "");
                jTextFieldTitulo.setText(filme.getTitulo());
                jTextFieldAnoDoFilme.setText(filme.getAno() + "");
                jComboBoxCategorias.setSelectedItem(filme.getCategoria().getId() + 
                        " - " + filme.getCategoria().getDescricao().toUpperCase());
                jTextFieldCaminhoDoArquivo.setText(filme.getCaminho());
                jTextAreaSinopse.setText(filme.getSinopse());
                jButtonSalvar.setLabel("Editar");
                jButtonExcluir.setEnabled(true);
                jTextFieldTitulo.requestFocus();
            } else {
                jButtonSalvar.setLabel("Salvar");
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCadFilmes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldAnoDoFilme = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxCategorias = new javax.swing.JComboBox<>();
        jTextFieldCaminhoDoArquivo = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonConsultar = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFilmes = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaSinopse = new javax.swing.JTextArea();
        jButtonCaminho = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldQuantRegistros = new javax.swing.JTextField();
        jButtonFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manutenção de cadastro de filmes");
        setResizable(false);

        jPanelCadFilmes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Código:");

        jTextFieldCodigo.setEditable(false);

        jLabel2.setText("Título:");

        jLabel3.setText("Ano de Lançamento:");

        jLabel4.setText("Categoria do Filme:");

        jComboBoxCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonConsultar.setText("Consultar");
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });

        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jTableFilmes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Título ", "Ano de Lanç.", "Categoria"
            }
        ));
        jTableFilmes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableFilmesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFilmes);
        if (jTableFilmes.getColumnModel().getColumnCount() > 0) {
            jTableFilmes.getColumnModel().getColumn(0).setMinWidth(50);
            jTableFilmes.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableFilmes.getColumnModel().getColumn(0).setMaxWidth(50);
            jTableFilmes.getColumnModel().getColumn(1).setMinWidth(250);
            jTableFilmes.getColumnModel().getColumn(1).setPreferredWidth(250);
            jTableFilmes.getColumnModel().getColumn(1).setMaxWidth(250);
            jTableFilmes.getColumnModel().getColumn(2).setMinWidth(100);
            jTableFilmes.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTableFilmes.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        jLabel6.setText("Sinopse:");

        jTextAreaSinopse.setColumns(20);
        jTextAreaSinopse.setRows(5);
        jScrollPane2.setViewportView(jTextAreaSinopse);

        jButtonCaminho.setText("Selecione o caminho do arquivo:");
        jButtonCaminho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCaminhoActionPerformed(evt);
            }
        });

        jLabel7.setText("Quant. de Registros:");

        jButtonFechar.setText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCadFilmesLayout = new javax.swing.GroupLayout(jPanelCadFilmes);
        jPanelCadFilmes.setLayout(jPanelCadFilmesLayout);
        jPanelCadFilmesLayout.setHorizontalGroup(
            jPanelCadFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadFilmesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanelCadFilmesLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTitulo))
                    .addGroup(jPanelCadFilmesLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAnoDoFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxCategorias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelCadFilmesLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadFilmesLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldQuantRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                        .addComponent(jButtonNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonConsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonFechar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadFilmesLayout.createSequentialGroup()
                        .addComponent(jButtonCaminho)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCaminhoDoArquivo)))
                .addContainerGap())
        );
        jPanelCadFilmesLayout.setVerticalGroup(
            jPanelCadFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadFilmesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCadFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldAnoDoFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCadFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCaminhoDoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCaminho))
                .addGap(18, 18, 18)
                .addGroup(jPanelCadFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelCadFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonExcluir)
                    .addComponent(jButtonConsultar)
                    .addComponent(jButtonNovo)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldQuantRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFechar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCadFilmes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCadFilmes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:
        if (jTextFieldTitulo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O título do filme deve ser preenchido!\n");
        } else if (jTextFieldAnoDoFilme.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O ano do filme deve ser preenchido!\n");
        } else if (jComboBoxCategorias.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "A categoria do filme deve ser selecionada\n");
        } else if (jTextFieldCaminhoDoArquivo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O caminho do arquivo deve ser informado\n");
        } else if (jTextAreaSinopse.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "A sinopse do filme deve ser descrita!\n");
        } else {
            try {
                String titulo = jTextFieldTitulo.getText();
                int ano = Integer.parseInt(jTextFieldAnoDoFilme.getText());
                Categoria categoria = new Categoria();
                categoria.splitCategoria(jComboBoxCategorias.getSelectedItem().toString());
                String caminho = jTextFieldCaminhoDoArquivo.getText();
                String sinopse = jTextAreaSinopse.getText();

                if (jButtonSalvar.getLabel().equalsIgnoreCase("Salvar")) {
                    filme = new Filme(sinopse, titulo, ano, categoria, caminho);
                    filmeBll.adicionarFilme(filme);
                } else {
                    int id = Integer.parseInt(jTextFieldCodigo.getText());
                    filme = new Filme(id, sinopse, titulo, ano, categoria, caminho);
                    filmeBll.alterarFilme(filme);
                }
                imprimirFilmes(filmeBll.getConsultaFilmes());
                limpaCampos();

            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "Atenção!!!\n" + erro.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
        try {
            filmeBll.excluirFilme(filmeBll.getConsultaFilmePorId(filme.getId()));
            imprimirFilmes(filmeBll.getConsultaFilmes());
            limpaCampos();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Atenção!!!\n" + erro.getMessage());
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed
        // TODO add your handling code here:
        try {
            imprimirFilmes(filmeBll.pesquisarFilme(jTextFieldTitulo.getText()));

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Atenção!!!\n" + erro.getMessage());
        }
    }//GEN-LAST:event_jButtonConsultarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTableFilmes.getModel();
        model.setNumRows(0);
        try {
            limpaCampos();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Atenção!!!\n" + erro.getMessage());
        }
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonCaminhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCaminhoActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser chooser = new JFileChooser();
            File f;
            chooser.showOpenDialog(null);
            f = chooser.getSelectedFile();
            String caminho = f.getAbsolutePath();
            jTextFieldCaminhoDoArquivo.setText(caminho);

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Atenção!!!" + erro.getMessage());
        }
    }//GEN-LAST:event_jButtonCaminhoActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jTableFilmesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFilmesMouseReleased
        // TODO add your handling code here:
        try {
            int linha = jTableFilmes.getSelectedRow();
            Integer codigo = Integer.parseInt(jTableFilmes.getValueAt(linha, 0).toString());
            preencherCampos(codigo);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }//GEN-LAST:event_jTableFilmesMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FilmeApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FilmeApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FilmeApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FilmeApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FilmeApp dialog = null;
                try {
                    dialog = new FilmeApp(new javax.swing.JFrame(), true);
                } catch (Exception ex) {
                    Logger.getLogger(FilmeApp.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCaminho;
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxCategorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanelCadFilmes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableFilmes;
    private javax.swing.JTextArea jTextAreaSinopse;
    private javax.swing.JTextField jTextFieldAnoDoFilme;
    private javax.swing.JTextField jTextFieldCaminhoDoArquivo;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldQuantRegistros;
    private javax.swing.JTextField jTextFieldTitulo;
    // End of variables declaration//GEN-END:variables
}