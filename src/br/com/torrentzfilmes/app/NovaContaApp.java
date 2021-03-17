/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.torrentzfilmes.app;

import br.com.torrentzfilmes.bll.UsuarioBll;
import br.com.torrentzfilmes.enumeration.EnumPerfil;
import br.com.torrentzfilmes.model.NovaConta;
import br.com.torrentzfilmes.model.Usuario;
import br.com.torrentzfilmes.util.UtilComponentes;
import br.com.torrentzfilmes.util.UtilObjetos;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author roger
 */
public class NovaContaApp extends javax.swing.JDialog {
    
    private NovaConta novaConta;
    
    private UsuarioBll usuarioBll;
    
    private boolean debug = true;
    
    public NovaContaApp() {
        
        initComponents();
        
        inicializarComponentes();
    }
    
    public NovaContaApp(NovaConta novaConta) {
        this();
        
        this.novaConta = novaConta;
        
        preencherFormulario(novaConta);
    }    
    

    private void inicializarComponentes() {
        usuarioBll = new UsuarioBll();
        
        jLabelNomePlanoContratado.setText("");
        
        jLabelPlanoKey.setVisible(false);
        
        if (debug) {
            jPasswordFieldConfirmaSenha.setText("123456");
            jPasswordFieldSenha.setText("123456");
            jTextFieldCpf.setText("20860026027");
            jTextFieldEmail.setText("teste@gmail.com");
            jTextFieldNome.setText("Fulano Sauro");            
        }
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelNovaConta = new javax.swing.JPanel();
        jPanelUsuarios = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPasswordFieldConfirmaSenha = new javax.swing.JPasswordField();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCpf = new javax.swing.JTextField();
        jButtonSelecionarPlano = new javax.swing.JButton();
        jTextFieldCadastrar = new javax.swing.JButton();
        jLabelNomePlanoContratado = new javax.swing.JLabel();
        jLabelPlanoKey = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Criar Nova Conta");
        setResizable(false);

        jPanelUsuarios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setText("E-mail");

        jLabel5.setText("Senha");

        jLabel8.setText("Confirme sua senha");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setText("Novo Cadastro de Usuário");

        jLabel7.setFont(new java.awt.Font("Edwardian Script ITC", 0, 36)); // NOI18N
        jLabel7.setText("Torrentz Filmes");

        jLabel1.setText("Nome");

        jLabel2.setText("Cpf");

        jButtonSelecionarPlano.setText("Selecione seu Plano");
        jButtonSelecionarPlano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarPlanoActionPerformed(evt);
            }
        });

        jTextFieldCadastrar.setText("Continuar");
        jTextFieldCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCadastrarActionPerformed(evt);
            }
        });

        jLabelNomePlanoContratado.setText("Nome Plano Contratado");

        jLabelPlanoKey.setText("Plano Contratado:");

        javax.swing.GroupLayout jPanelUsuariosLayout = new javax.swing.GroupLayout(jPanelUsuarios);
        jPanelUsuarios.setLayout(jPanelUsuariosLayout);
        jPanelUsuariosLayout.setHorizontalGroup(
            jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsuariosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsuariosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
            .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addGroup(jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                        .addGroup(jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                        .addComponent(jTextFieldCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                        .addGroup(jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordFieldConfirmaSenha)
                            .addComponent(jPasswordFieldSenha)
                            .addComponent(jTextFieldEmail)
                            .addComponent(jTextFieldCpf)
                            .addComponent(jTextFieldNome)
                            .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabelPlanoKey)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelNomePlanoContratado)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jButtonSelecionarPlano, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(144, 144, 144))))
        );
        jPanelUsuariosLayout.setVerticalGroup(
            jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButtonSelecionarPlano)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomePlanoContratado)
                    .addComponent(jLabelPlanoKey))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jTextFieldCadastrar)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanelNovaContaLayout = new javax.swing.GroupLayout(jPanelNovaConta);
        jPanelNovaConta.setLayout(jPanelNovaContaLayout);
        jPanelNovaContaLayout.setHorizontalGroup(
            jPanelNovaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNovaContaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelNovaContaLayout.setVerticalGroup(
            jPanelNovaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNovaContaLayout.createSequentialGroup()
                .addComponent(jPanelUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelNovaConta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelNovaConta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSelecionarPlanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarPlanoActionPerformed
        try {
            NovaConta novaConta = new NovaConta();
            
            Usuario usuario = new Usuario();
            
            novaConta.setUsuario(usuario);
            
            novaConta.getUsuario().setNome(jTextFieldNome.getText());
            novaConta.getUsuario().setCpf(jTextFieldCpf.getText());
            novaConta.getUsuario().setEmail(jTextFieldEmail.getText());
            novaConta.getUsuario().setSenha(String.valueOf(jPasswordFieldSenha.getPassword()));
            novaConta.setConfirmaSenha(String.valueOf(jPasswordFieldConfirmaSenha.getPassword()));
            
            ContrataPlanoApp contrataPlano = new ContrataPlanoApp(novaConta);
            
            contrataPlano.setVisible(true);

            this.dispose();

        } catch (Exception e) {
            Logger.getLogger(NovaContaApp.class.getName()).log(Level.SEVERE, null, e);
            
            JOptionPane.showMessageDialog(null, "Não foi possível criar usuário admin. Entre em contato com suporte.");
        }
    }//GEN-LAST:event_jButtonSelecionarPlanoActionPerformed

    private void jTextFieldCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCadastrarActionPerformed
            
        try {
            
            boolean ehValido = validarFormulario();
            
            boolean senhaConfirmada =  Arrays.equals(jPasswordFieldSenha.getPassword(), jPasswordFieldConfirmaSenha.getPassword());
            
            if (ehValido) {
                
                if (senhaConfirmada) {
                    
                    Usuario usuarioBanco = usuarioBll.getUsuarioByEmail(jTextFieldEmail.getText());

                    if (UtilObjetos.ehNuloOuVazio(usuarioBanco)) {
                        
                        setPercentualDesconto();  

                        novaConta.getUsuario().setDataCupom(new Date());

                        novaConta.getUsuario().setPerfil(EnumPerfil.CLIENTE);

                        ContratoTermosAceitacaoApp contratoTermos = new ContratoTermosAceitacaoApp(novaConta);   

                        contratoTermos.setVisible(true);                

                        dispose();  

                    } else {
                        JOptionPane.showMessageDialog(null, "Ja existe um usuario cadastrado com esse email.");                    
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Senhas não conferem"); 
                }
            } else {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos do formulário.");
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(NovaContaApp.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }//GEN-LAST:event_jTextFieldCadastrarActionPerformed

    private void setPercentualDesconto() {
        int desc;
        Random rd = new Random();
        
        for (int i = 0; i < 1; i++) {
            desc = rd.nextInt(60) + 1;
            novaConta.getUsuario().setPercCupom(desc);
        }
    }

    /**
     * @param args the command line arguments
     */
        public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new NovaContaApp().setVisible(true);
                    
                } catch (Exception ex) {
                    Logger.getLogger(LoginApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSelecionarPlano;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelNomePlanoContratado;
    private javax.swing.JLabel jLabelPlanoKey;
    private javax.swing.JPanel jPanelNovaConta;
    private javax.swing.JPanel jPanelUsuarios;
    private javax.swing.JPasswordField jPasswordFieldConfirmaSenha;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JButton jTextFieldCadastrar;
    private javax.swing.JTextField jTextFieldCpf;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables

    private void preencherFormulario(NovaConta novaConta) {
        if (novaConta != null) {
            jTextFieldNome.setText(novaConta.getUsuario().getNome());
            jTextFieldCpf.setText(novaConta.getUsuario().getCpf());
            jTextFieldEmail.setText(novaConta.getUsuario().getEmail());
            jPasswordFieldSenha.setText(novaConta.getUsuario().getSenha());
            jPasswordFieldConfirmaSenha.setText(novaConta.getConfirmaSenha());
            jLabelPlanoKey.setVisible(true);
            jLabelNomePlanoContratado.setText(novaConta.getPlano().getDescricao());
            jButtonSelecionarPlano.setText("Alterar Plano");
        }
    }

    private boolean validarFormulario() {
        boolean temCamposVazios = UtilComponentes.ehCampoVazio(jTextFieldNome,
                                                                jTextFieldCpf,
                                                                jTextFieldEmail);
        
        
        boolean ehFormularioValido = !temCamposVazios
                                     && !jPasswordFieldSenha.getPassword().equals("")
                                     && !jPasswordFieldConfirmaSenha.equals("")
                                     && novaConta != null
                                     && novaConta.getPlano() != null;
        
        return ehFormularioValido;
    }
    
}
