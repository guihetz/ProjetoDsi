/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.apresentacao;

import br.com.hotel.dao.ConnectionFactory;
import br.com.hotel.dao.TipoAcomodacaoDao;
import br.com.hotel.modelo.TipoAcomodacao;
import br.com.hotel.painel.JpanelGerenciarHotel;
import java.awt.Color;

/**
 *
 * @author daylton
 */
public class TelaEditarTipoAcomodacao extends javax.swing.JFrame {
    private JpanelGerenciarHotel jpGerenciarHotel;

    /**
     * Creates new form TelaEditarTipoAcomodacao
     */
    TipoAcomodacao tpa;
    
    public TelaEditarTipoAcomodacao() {
        initComponents();        
    }
    
    public TelaEditarTipoAcomodacao(TipoAcomodacao tipoAcomodacao, javax.swing.JPanel panel){
        this();
        jpGerenciarHotel = (JpanelGerenciarHotel) panel;
        tpa = tipoAcomodacao;
        
        tfDescricao.setText(tpa.getDescricao());
        tfQuantidade.setText("" + tpa.getQtdeAcomodacoes());
        tfValorDiaria.setText(""+ tpa.getValorDiaria());
        tfNumAdulto.setText("" + tpa.getNumAdultos());
        tfNunCrianca.setText("" + tpa.getNumCriancas());        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btnCadastrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfValorDiaria = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfNumAdulto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfNunCrianca = new javax.swing.JTextField();
        tfQuantidade = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lbMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de Acomodação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Hotel Oriental", 0, 36))); // NOI18N

        btnCadastrar.setFont(new java.awt.Font("Hotel Oriental", 0, 26)); // NOI18N
        btnCadastrar.setText("Salvar Alteração");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Hotel Oriental", 0, 24)); // NOI18N
        jLabel1.setText("Descrição");

        tfDescricao.setFont(new java.awt.Font("Hotel Oriental", 0, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Hotel Oriental", 0, 24)); // NOI18N
        jLabel3.setText("Valor Diaria");

        tfValorDiaria.setFont(new java.awt.Font("Hotel Oriental", 0, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Hotel Oriental", 0, 24)); // NOI18N
        jLabel4.setText("Num Aduto");

        tfNumAdulto.setFont(new java.awt.Font("Hotel Oriental", 0, 24)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Hotel Oriental", 0, 24)); // NOI18N
        jLabel5.setText("Num Criança");

        tfNunCrianca.setFont(new java.awt.Font("Hotel Oriental", 0, 24)); // NOI18N

        tfQuantidade.setFont(new java.awt.Font("Hotel Oriental", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Hotel Oriental", 0, 24)); // NOI18N
        jLabel2.setText("Quantidade");

        lbMsg.setFont(new java.awt.Font("Hotel Oriental", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(tfValorDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNumAdulto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(tfNunCrianca, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnCadastrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfNunCrianca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(tfValorDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfNumAdulto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastrar)
                    .addComponent(lbMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        try{
            if(!"".equals(tfDescricao.getText())){
                if(!"".equals(tfQuantidade.getText()) && Integer.valueOf(tfQuantidade.getText()) > 0){
                    if(!"".equals(tfValorDiaria.getText()) && Double.valueOf(tfValorDiaria.getText()) > 0){
                        if(!"".equals(tfNumAdulto.getText()) && Integer.valueOf(tfNumAdulto.getText()) > 0){
                            if(!"".equals(tfNunCrianca.getText()) && Integer.valueOf(tfNunCrianca.getText()) > 0){
                                
                                tpa.setDescricao(tfDescricao.getText());
                                tpa.setQtdeAcomodacoes(Integer.valueOf(tfQuantidade.getText()));
                                tpa.setValorDiaria(Double.valueOf(tfValorDiaria.getText()));
                                tpa.setNumAdultos(Integer.valueOf(tfNumAdulto.getText()));
                                tpa.setNumAdultos(Integer.valueOf(tfNumAdulto.getText()));

                                TipoAcomodacaoDao dao = new TipoAcomodacaoDao(new ConnectionFactory().getConnection());
                                dao.atualizarTipoAcomodacao(tpa, tpa.getTipoAcomodacaoId());

                                System.out.println("Tipo de acomodação Atualizado");
                                jpGerenciarHotel.preencherTabelaTipoAcomodacao();

                                this.dispose();

                            }else{
                                lbMsg.setText("Numero de Criança Invalido!");
                                lbMsg.setForeground(Color.red);
                            }
                        }else{
                            lbMsg.setText("Numero de Adulto Invalido!");
                            lbMsg.setForeground(Color.red);
                        }
                    }else{
                        lbMsg.setText("Valor da Diaria Invalido!");
                        lbMsg.setForeground(Color.red);
                    }
                }else{
                    lbMsg.setText("Quantidade Invalida!");
                    lbMsg.setForeground(Color.red);
                }
            }else{
                lbMsg.setText("Descrição Invalida!");
                lbMsg.setForeground(Color.red);
            }
        }catch(Exception e){
            lbMsg.setText("Erro: " + e.getMessage());
            lbMsg.setForeground(Color.red);
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaEditarTipoAcomodacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEditarTipoAcomodacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEditarTipoAcomodacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEditarTipoAcomodacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEditarTipoAcomodacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbMsg;
    private javax.swing.JTextField tfDescricao;
    private javax.swing.JTextField tfNumAdulto;
    private javax.swing.JTextField tfNunCrianca;
    private javax.swing.JTextField tfQuantidade;
    private javax.swing.JTextField tfValorDiaria;
    // End of variables declaration//GEN-END:variables
}
