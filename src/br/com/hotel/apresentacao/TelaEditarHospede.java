/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.apresentacao;

import br.com.hotel.dao.ConnectionFactory;
import br.com.hotel.dao.HospedeDao;
import br.com.hotel.modelo.Hospede;
import br.com.hotel.painel.PainelCadastroHospede;
import br.com.hotel.painel.PainelCadastroHospede12;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author guilherme
 */
public class TelaEditarHospede extends javax.swing.JFrame {

    /**
     * Creates new form TelaEditarHospede
     */
    private Hospede h;
    private PainelCadastroHospede12 pnCadastroHospede12;
    
    public TelaEditarHospede() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
    }
    
    public TelaEditarHospede(Hospede h, javax.swing.JPanel p){
        this();
        this.h = h;
        this.pnCadastroHospede12 = (PainelCadastroHospede12) p;
        
        tfNome.setText(h.getNome());
        ftCpf.setText(h.getCpf());
        tfEmail.setText(h.getEmail());
        ftTelefone.setText(h.getTelefone());
        dcDataNascimento.setDate(h.getDataNascimento());
        tfEndereco.setText(h.getEndereco());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ftCpf = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        ftTelefone = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        tfEndereco = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        dcDataNascimento = new com.toedter.calendar.JDateChooser();
        lbMsg = new javax.swing.JLabel();
        btnAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar Hospede", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Hotel Oriental", 0, 24))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        jLabel7.setText("Nome");

        tfNome.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        jLabel8.setText("CPF");

        try {
            ftCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftCpf.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        jLabel9.setText("Telefone");

        try {
            ftTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftTelefone.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        jLabel10.setText("Endereço");

        tfEndereco.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        jLabel11.setText("Email");

        tfEmail.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        jLabel12.setText("Data de Nascimento");

        dcDataNascimento.setFont(new java.awt.Font("Hotel Motel", 0, 18)); // NOI18N

        lbMsg.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N

        btnAtualizar.setFont(new java.awt.Font("Hotel Oriental", 0, 20)); // NOI18N
        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/edit.png"))); // NOI18N
        btnAtualizar.setText("Atualizar Hospede");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfEmail))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfEndereco))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfNome))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ftCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ftTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dcDataNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(12, 12, 12))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(ftCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(dcDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAtualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        try{
            int id = h.getHospedeId();
            if(!tfNome.getText().equals("")){
                if(!ftCpf.getText().equals("")){
                    if(!tfEndereco.getText().equals("")){
                        if(!tfEmail.getText().equals("")){
                            if(!ftTelefone.getText().equals("")){
                                if(!dcDataNascimento.getDateFormatString().equals("")){
                                    
                                    HospedeDao hd = new HospedeDao(new ConnectionFactory().getConnection());
                                    Hospede h = hd.buscarHospede(id);
                                    h.setCpf(ftCpf.getText());
                                    h.setNome(tfNome.getText());
                                    h.setEndereco(tfNome.getText());
                                    h.setEmail(tfEmail.getText());
                                    h.setTelefone(ftTelefone.getText());
                                    h.setDataNascimento(dcDataNascimento.getDate());
                                    HospedeDao hd2 = new HospedeDao(new ConnectionFactory().getConnection());
                                    hd2.atualizarHospede(h);
                                    this.pnCadastroHospede12.preencherMsg("Hospede Atualizado!", Color.GREEN);
                                    this.pnCadastroHospede12.preencherTabelaHospedes();
                                    this.dispose();
                                    
                                }else{
                                    lbMsg.setText("Erro: digite data");
                                    lbMsg.setForeground(Color.RED);
                                }
                            }else{
                                lbMsg.setText("Erro: digite telefone!");  
                                lbMsg.setForeground(Color.RED);
                            }
                        }else{
                            lbMsg.setText("Erro: digite email!");
                            lbMsg.setForeground(Color.RED);
                        }
                    }else{
                        lbMsg.setText("Erro: digite endereço!");
                        lbMsg.setForeground(Color.RED);
                    }
                }else{
                    lbMsg.setText("Erro: digite CPF!");
                    lbMsg.setForeground(Color.RED);
                }
            }else{
                lbMsg.setText("Erro: digite nome!");
                lbMsg.setForeground(Color.RED);
            }
        }catch(Exception erro){;
            lbMsg.setText("Erro: " + erro.getMessage());
            lbMsg.setForeground(Color.RED);
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaEditarHospede.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEditarHospede.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEditarHospede.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEditarHospede.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEditarHospede().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private com.toedter.calendar.JDateChooser dcDataNascimento;
    private javax.swing.JFormattedTextField ftCpf;
    private javax.swing.JFormattedTextField ftTelefone;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbMsg;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}
