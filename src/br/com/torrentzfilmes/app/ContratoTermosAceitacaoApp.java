/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.torrentzfilmes.app;

import br.com.torrentzfilmes.bll.ContratoBll;
import br.com.torrentzfilmes.bll.UsuarioBll;
import br.com.torrentzfilmes.enumeration.EnumStatus;
import br.com.torrentzfilmes.model.Contrato;
import br.com.torrentzfilmes.model.NovaConta;
import br.com.torrentzfilmes.model.Usuario;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author roger
 */
public class ContratoTermosAceitacaoApp extends javax.swing.JDialog {

    private NovaConta novaConta;

    private UsuarioBll usuarioBll;

    private ContratoBll contratoBll;

    public ContratoTermosAceitacaoApp() {

        initComponents();

        inicializarComponentes();
    }

    public ContratoTermosAceitacaoApp(NovaConta novaConta) {
        this();

        this.novaConta = novaConta;

    }

    private void inicializarComponentes() {

        jTextArea1.setLineWrap(true);

        usuarioBll = new UsuarioBll();

        contratoBll = new ContratoBll();

        jButtonConcluirCadastro.setEnabled(false);

        jCheckBoxAceitarTermos.setSelected(false);

        jCheckBoxAceitarTermos.addChangeListener((e) -> {
            if (jCheckBoxAceitarTermos.isSelected()) {
                jButtonConcluirCadastro.setEnabled(true);
            } else {

                jButtonConcluirCadastro.setEnabled(false);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jButtonConcluirCadastro = new javax.swing.JButton();
        jCheckBoxAceitarTermos = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Criar Nova Conta");
        setResizable(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("1. ACEITA????O\nEste ?? um contrato firmado entre voc??, de agora em diante denominado como usu??rio, e a TESTE Tecnologia\nEireli, empresa cadastrada no CNPJ sob n?? 05.999.999/0001-99 com sede no munic??pio \nde Goi??nia - GO , a Av. Teste, 1079 ??? 7?? andar, e de agora em diante denominada simplesmente de Webnow. Este\n???Termo de Uso de Aplicativo??? rege o uso de todos os aplicativos disponibilizados gratuitamente pela Webnow\nsejam para dispositivos m??veis (Android, IOS, Windows Mobile), servidores, computadores pessoais (desktops)\nou servi??os web. Se voc?? n??o concordar com estes termos n??o use este aplicativo.\nVoc?? reconhece ainda que analisou e aceitou as condi????es de uso. Leia-as atentamente pois o uso deste\naplicativo significa que voc?? aceitou todos os termos e concorda em cumpri-los. Se voc??, usu??rio, for menor de\nidade ou declarado incapaz em quaisquer aspectos, precisar?? da permiss??o de seus pais ou respons??veis que\ntamb??m dever??o concordar com estes mesmos termos e condi????es.\n2. LICEN??A LIMITADA\nVoc?? recebeu uma licen??a limitada, n??o transfer??vel, n??o exclusiva, livre de royalties e revog??vel para baixar,\ninstalar, executar e utilizar este aplicativo em seu dispositivo. Voc?? reconhece e concorda que a Webnow\nconcede ao usu??rio uma licen??a exclusiva para uso e desta forma n??o lhe transfere os direitos sobre o produto.\nO aplicativo dever?? ser utilizado por voc??, usu??rio. A venda, transfer??ncia, modifica????o, engenharia reversa ou\ndistribui????o bem como a c??pia de textos, imagens ou quaisquer partes nele contido ?? expressamente proibida.\n3. ALTERA????ES, MODIFICA????ES E RESCIS??O\nA Webnow reserva-se no direito de, a qualquer tempo, modificar estes termos seja incluindo, removendo ou\nalterando quaisquer de suas cl??usulas. Tais modifica????es ter??o efeito imediato. Ap??s publicadas tais altera????es,\nao continuar com o uso do aplicativo, voc?? ter?? aceitado e concordado em cumprir os termos modificados.\nA Webnow pode, de tempos em tempos, modificar ou descontinuar (tempor??ria ou permanentemente) a\ndistribui????o ou a atualiza????o deste aplicativo.\nA Webnow n??o ?? obrigada a fornecer nenhum servi??o de suporte para este aplicativo.\nO usu??rio n??o poder?? responsabilizar a Webnow nem seus diretores, executivos, funcion??rios, afiliados, agentes,\ncontratados ou licenciadores por quaisquer modifica????es, suspens??es ou descontinuidade do aplicativo.\nCONSENTIMENTO PARA COLETA E USO DE DADOS\nVoc?? concorda que a Webnow pode coletar e usar dados t??cnicos de seu dispositivo tais como especifica????es,\nconfigura????es, vers??es de sistema operacional, tipo de conex??o ?? internet e afins.\nISEN????O DE GARANTIAS E LIMITA????ES DE RESPONSABILIDADE\nEste aplicativo estar?? em cont??nuo desenvolvimento e pode conter erros e, por isso, o uso ?? fornecido \"no\nestado em que se encontra\" e sob risco do usu??rio final. Na extens??o m??xima permitida pela legisla????o aplic??vel\na Webnow e seus fornecedores isentam-se de quaisquer garantias e condi????es expressas ou impl??citas incluindo,\nsem limita????o, garantias de comercializa????o, adequa????o a um prop??sito espec??fico, titularidade e n??o viola????o no\nque diz respeito ao aplicativo e qualquer um de seus componentes ou ainda ?? presta????o ou n??o de servi??os de\nsuporte. A Webnow n??o garante que a opera????o deste aplicativo seja cont??nua e sem defeitos.");
        jScrollPane1.setViewportView(jTextArea1);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("Termos do Contrato");

        jButtonConcluirCadastro.setText("Concluir");
        jButtonConcluirCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConcluirCadastroActionPerformed(evt);
            }
        });

        jCheckBoxAceitarTermos.setText("Eu aceito os termos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 164, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(166, 166, 166))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBoxAceitarTermos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonConcluirCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jButtonConcluirCadastro)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxAceitarTermos)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConcluirCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConcluirCadastroActionPerformed

        try {
            usuarioBll.adicionarUsuario(novaConta.getUsuario());

            Usuario usuariobanco = usuarioBll.getUsuarioByEmail(novaConta.getUsuario().getEmail());

            Contrato contrato = new Contrato();
            contrato.setUsuario(usuariobanco);
            contrato.setPlano(novaConta.getPlano());
            contrato.setStatus(EnumStatus.ATIVO); 
            contrato.setInicio(new Date());

            LocalDate atual = LocalDate.now();
            LocalDate fim   = atual.plusYears(1);
            Date fimContrato = Date.from(fim.atStartOfDay(ZoneId.systemDefault()).toInstant());

            contrato.setFim(fimContrato);

            contratoBll.adicionarContrato(contrato);

            VisualizarFilmesApp1 tela = new VisualizarFilmesApp1(usuariobanco);
            tela.setVisible(true);
            dispose();

        } catch (Exception ex) {
            try {
                usuarioBll.excluirUsuario(novaConta.getUsuario().getId());
            } catch (Exception ex1) {
                Logger.getLogger(ContratoTermosAceitacaoApp.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ContratoTermosAceitacaoApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonConcluirCadastroActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ContratoTermosAceitacaoApp().setVisible(true);

                } catch (Exception ex) {
                    Logger.getLogger(LoginApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConcluirCadastro;
    private javax.swing.JCheckBox jCheckBoxAceitarTermos;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
