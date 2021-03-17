package br.com.torrentzfilmes.app;

import br.com.torrentzfilmes.bll.UsuarioBll;
import br.com.torrentzfilmes.enumeration.EnumPerfil;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import br.com.torrentzfilmes.model.Usuario;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Aires Ribeiro
 */
public class LoginApp extends javax.swing.JFrame {

    private Usuario usuario;
    
    private UsuarioBll usuBll = new UsuarioBll();
    
    private boolean debug = true;

    public static String convertDate(Date dtConsulta) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));
            return formato.format(dtConsulta);
        } catch (Exception erro) {
            erro.printStackTrace();
            return null;
        }
    }

    public LoginApp() throws Exception {
        
        initComponents();
        
        usuario = new Usuario();
        
        Random rd = new Random();

        this.criarUsuarioAdmin();
        
        if (debug) {
          
            this.jTextFieldEmail.setText("Usuario_admin2@gmail.com");
            
            this.jPasswordFieldSenha.setText("123456");
            
//            this.jButtonEntrar.doClick();
//            
//            this.dispose();
            
//        this.executarScriptsConfiguracoes();
        }

    }

    private void criarUsuarioAdmin() {
        try {
            Usuario usuarioBanco = usuBll.getUsuarioByEmail("usuario_admin@gmail.com");

            boolean existeUsuarioAdmin = usuarioBanco != null
                    && usuarioBanco.getEmail() != null
                    && usuarioBanco.getEmail().equals("usuario_admin@gmail.com");

            if (!existeUsuarioAdmin) {
                usuario.setNome("Super usuario");
                usuario.setCpf("50794334008");
                usuario.setEmail("usuario_admin@gmail.com");
                usuario.setSenha("123456");
                usuario.setPercCupom(0);

                Date dataCupom = new Date();
                usuario.setDataCupom(dataCupom);
                usuario.setPerfil(EnumPerfil.ADMINISTRADOR);
                usuBll.adicionarUsuario(usuario);
            }

        } catch (Exception erro) {
            Logger.getLogger(LoginApp.class.getName()).log(Level.SEVERE, null, erro);

            JOptionPane.showMessageDialog(null, "Não foi possível criar usuário admin. Entre em contato com suporte.");

            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jButtonEntrar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jButtonCreateNewAccount = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setText("E-mail");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(220, 90, 40, 25);

        jLabel2.setText("Senha:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(220, 130, 50, 25);
        getContentPane().add(jTextFieldEmail);
        jTextFieldEmail.setBounds(270, 90, 210, 25);

        jPasswordFieldSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldSenhaKeyPressed(evt);
            }
        });
        getContentPane().add(jPasswordFieldSenha);
        jPasswordFieldSenha.setBounds(270, 130, 210, 25);

        jButtonEntrar.setText("Entrar");
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEntrar);
        jButtonEntrar.setBounds(290, 220, 70, 30);

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair);
        jButtonSair.setBounds(380, 220, 70, 30);

        jButtonCreateNewAccount.setText("Criar nova Conta");
        jButtonCreateNewAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateNewAccountActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCreateNewAccount);
        jButtonCreateNewAccount.setBounds(133, 220, 130, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/torrentzfilmes/util/TorrentzCinema.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 70, 140, 130);

        jLabel4.setFont(new java.awt.Font("Edwardian Script ITC", 0, 36)); // NOI18N
        jLabel4.setText("Torrentz Filmes");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(150, 20, 180, 40);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel5.setText("Autenticação de Usuário");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(100, 0, 290, 30);
        getContentPane().add(jLabelFundo);
        jLabelFundo.setBounds(0, 0, 510, 270);

        setSize(new java.awt.Dimension(528, 306));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed

        try {
            String email = jTextFieldEmail.getText();
            String senha = String.valueOf(jPasswordFieldSenha.getPassword());

            Usuario usuarioBanco = usuBll.getUsuarioByEmail(email);

            boolean ehUsuarioValido = usuarioBanco != null
                                    && usuarioBanco.getEmail() != null
                                    && !usuarioBanco.getEmail().equals("")
                                    && usuarioBanco.getSenha() != null
                                    && !usuarioBanco.getSenha().equals("");

            if (ehUsuarioValido) {
                
                boolean ehAutorizado = email.equals(usuarioBanco.getEmail()) 
                                       && senha.equals(usuarioBanco.getSenha());

                if (ehAutorizado && usuarioBanco.getPerfil().equals(EnumPerfil.ADMINISTRADOR)) {

                    MenuPrincipalApp tela = new MenuPrincipalApp();   //Chamar a tela
                    tela.setVisible(true);                      //Tornar a tela visivel
                    dispose();                                  //Fechar a tela de login e abrir apenas a tela principal

                } else if (ehAutorizado && usuarioBanco.getPerfil().equals(EnumPerfil.CLIENTE)) {
                    
                    VisualizarFilmesApp1 tela = new VisualizarFilmesApp1(usuarioBanco);
                    tela.setVisible(true);
                    dispose();
                    
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Acesso Negado!");
                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "Usuário não encontrado!");
            }

        } catch (Exception erro) {

            Logger.getLogger(LoginApp.class.getName()).log(Level.SEVERE, null, erro);

            JOptionPane.showMessageDialog(null, "Erro ao efetuar o login.\nEntre em contato com suporte.");
        }
    }//GEN-LAST:event_jButtonEntrarActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed

        System.exit(0);                                 //Sai do sistema fechando a tela
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jPasswordFieldSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldSenhaKeyPressed
        // TODO add your handling code here:
        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if (jTextFieldEmail.getText().equals("Admin") && jPasswordFieldSenha.getText().equals("Admin")) {
                    MenuPrincipalApp tela = new MenuPrincipalApp();   //Chamar a tela
                    tela.setVisible(true);                      //Tornar a tela visivel
                    dispose();                                  //Fechar a tela de login e abrir apenas a tela principal
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Acesso Negado!");
                }
            }
        } catch (Exception erro) {
            throw erro;
        }
    }//GEN-LAST:event_jPasswordFieldSenhaKeyPressed

    private void jButtonCreateNewAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateNewAccountActionPerformed
        // TODO add your handling code here:
        try {
            new NovaContaApp().setVisible(true);
            this.setVisible(true);
            this.dispose();

        } catch (Exception e) {

        }
    }//GEN-LAST:event_jButtonCreateNewAccountActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new LoginApp().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(LoginApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreateNewAccount;
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JTextField jTextFieldEmail;
    // End of variables declaration//GEN-END:variables

}
