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
        jTextArea1.setText("1. ACEITAÇÃO\nEste é um contrato firmado entre você, de agora em diante denominado como usuário, e a TESTE Tecnologia\nEireli, empresa cadastrada no CNPJ sob nº 05.999.999/0001-99 com sede no município \nde Goiânia - GO , a Av. Teste, 1079 – 7º andar, e de agora em diante denominada simplesmente de Webnow. Este\n“Termo de Uso de Aplicativo” rege o uso de todos os aplicativos disponibilizados gratuitamente pela Webnow\nsejam para dispositivos móveis (Android, IOS, Windows Mobile), servidores, computadores pessoais (desktops)\nou serviços web. Se você não concordar com estes termos não use este aplicativo.\nVocê reconhece ainda que analisou e aceitou as condições de uso. Leia-as atentamente pois o uso deste\naplicativo significa que você aceitou todos os termos e concorda em cumpri-los. Se você, usuário, for menor de\nidade ou declarado incapaz em quaisquer aspectos, precisará da permissão de seus pais ou responsáveis que\ntambém deverão concordar com estes mesmos termos e condições.\n2. LICENÇA LIMITADA\nVocê recebeu uma licença limitada, não transferível, não exclusiva, livre de royalties e revogável para baixar,\ninstalar, executar e utilizar este aplicativo em seu dispositivo. Você reconhece e concorda que a Webnow\nconcede ao usuário uma licença exclusiva para uso e desta forma não lhe transfere os direitos sobre o produto.\nO aplicativo deverá ser utilizado por você, usuário. A venda, transferência, modificação, engenharia reversa ou\ndistribuição bem como a cópia de textos, imagens ou quaisquer partes nele contido é expressamente proibida.\n3. ALTERAÇÕES, MODIFICAÇÕES E RESCISÃO\nA Webnow reserva-se no direito de, a qualquer tempo, modificar estes termos seja incluindo, removendo ou\nalterando quaisquer de suas cláusulas. Tais modificações terão efeito imediato. Após publicadas tais alterações,\nao continuar com o uso do aplicativo, você terá aceitado e concordado em cumprir os termos modificados.\nA Webnow pode, de tempos em tempos, modificar ou descontinuar (temporária ou permanentemente) a\ndistribuição ou a atualização deste aplicativo.\nA Webnow não é obrigada a fornecer nenhum serviço de suporte para este aplicativo.\nO usuário não poderá responsabilizar a Webnow nem seus diretores, executivos, funcionários, afiliados, agentes,\ncontratados ou licenciadores por quaisquer modificações, suspensões ou descontinuidade do aplicativo.\nCONSENTIMENTO PARA COLETA E USO DE DADOS\nVocê concorda que a Webnow pode coletar e usar dados técnicos de seu dispositivo tais como especificações,\nconfigurações, versões de sistema operacional, tipo de conexão à internet e afins.\nISENÇÃO DE GARANTIAS E LIMITAÇÕES DE RESPONSABILIDADE\nEste aplicativo estará em contínuo desenvolvimento e pode conter erros e, por isso, o uso é fornecido \"no\nestado em que se encontra\" e sob risco do usuário final. Na extensão máxima permitida pela legislação aplicável\na Webnow e seus fornecedores isentam-se de quaisquer garantias e condições expressas ou implícitas incluindo,\nsem limitação, garantias de comercialização, adequação a um propósito específico, titularidade e não violação no\nque diz respeito ao aplicativo e qualquer um de seus componentes ou ainda à prestação ou não de serviços de\nsuporte. A Webnow não garante que a operação deste aplicativo seja contínua e sem defeitos.");
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
