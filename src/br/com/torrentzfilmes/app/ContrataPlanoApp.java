
package br.com.torrentzfilmes.app;

import br.com.torrentzfilmes.bll.PlanoBll;
import br.com.torrentzfilmes.components.PlanoTableModel;
import br.com.torrentzfilmes.components.ViewAbstractTableModel;
import br.com.torrentzfilmes.model.NovaConta;
import br.com.torrentzfilmes.model.Plano;
import br.com.torrentzfilmes.util.UtilTabela;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class ContrataPlanoApp extends javax.swing.JFrame {
    
    private List<Plano> planosJTable;
    
    private PlanoBll planoBll;
    
    private Plano planoSelecionado;
    
    private NovaConta novaConta;

    
    public ContrataPlanoApp(NovaConta novaConta) {
        initComponents();
        
        inicializarComponentes();

        this.novaConta = novaConta;        
        
    }
    
    public void inicializarComponentes() {
        
        planosJTable = new ArrayList<>();
        
        planoBll = new PlanoBll();
        
        inicializarJTablePlanos();
        
        jTablePlanosAddListSelectionListener();
        
        jButtonConfirmar.setEnabled(false);
        
    }    
    
    private void inicializarJTablePlanos() {
        try {
            
            planosJTable = planoBll.getConsultaPlanos();
            
            ViewAbstractTableModel planoTableModel = new PlanoTableModel(this.planosJTable);
            
            UtilTabela.inicializarTabela(jTablePlanos, planoTableModel);
        
        } catch (Exception ex) {
            Logger.getLogger(ContrataPlanoApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    private void jTablePlanosAddListSelectionListener() {
        jTablePlanos.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            try {
                ViewAbstractTableModel clienteTableModel = new PlanoTableModel(this.planosJTable);

                planoSelecionado = (Plano) clienteTableModel.getValorDaLinha(jTablePlanos.getSelectedRow());
                
                planoSelecionado.setSelecionado(true);
                
                int qtdSelecionados = 0;
                
                for (Plano p : planosJTable) {
                    
                    if (!p.equals(planoSelecionado)) {
                       p.setSelecionado(false);
                    }
    
                    if (p.isSelecionado() || planoSelecionado.isSelecionado()) {
                        qtdSelecionados++;
                    }                    
                }
                
                if (qtdSelecionados == 0) {
                   jButtonConfirmar.setEnabled(false); 
                } else {
                  jButtonConfirmar.setEnabled(true);  
                }
                
                clienteTableModel.fireTableDataChanged();
                
            } catch (Exception ex) {
                Logger.getLogger(ContrataPlanoApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    } 
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePlanos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButtonConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTablePlanos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTablePlanos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTablePlanos);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Selecione o Plano");

        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(jLabel1)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonConfirmar)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        
        if (planoSelecionado != null && planoSelecionado.isSelecionado()) {
            
            novaConta.setPlano(planoSelecionado);
            
            new NovaContaApp(novaConta).setVisible(true);
            
            this.dispose();
        }
        
        
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

//    public static void main(String args[]) {
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new ContrataPlanoApp(new NovaConta()).setVisible(true);
//                } catch (Exception ex) {
//                    Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePlanos;
    // End of variables declaration//GEN-END:variables


}
