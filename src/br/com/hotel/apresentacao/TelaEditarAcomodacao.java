/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.apresentacao;

import br.com.hotel.dao.AcomodacaoDao;
import br.com.hotel.dao.CategoriaDao;
import br.com.hotel.dao.ConnectionFactory;
import br.com.hotel.dao.ItemConsumoDao;
import br.com.hotel.dao.TipoAcomodacaoDao;
import br.com.hotel.modelo.Acomodacao;
import br.com.hotel.modelo.Categoria;
import br.com.hotel.modelo.TipoAcomodacao;
import br.com.hotel.painel.PainelGerenciarHotel;
import java.awt.Color;

/**
 *
 * @author daylton
 */
public class TelaEditarAcomodacao extends javax.swing.JFrame {
    private PainelGerenciarHotel pnGerenciarHotel;
    
    /**
     * Creates new form TelaEditarAcomodacao
     */
    
    Acomodacao ac;
    
    public TelaEditarAcomodacao() {
        initComponents();
    }
    
    public TelaEditarAcomodacao(Acomodacao acomodacao, javax.swing.JPanel panel){
        this();
        pnGerenciarHotel = (PainelGerenciarHotel) panel; 
        
        ac = acomodacao;
        
        tfAndarAcomodacao.setText(String.valueOf(ac.getAndar()));
        tfNumeroAcomodacao.setText(String.valueOf(ac.getNumAcomodacao()));
        preencherComboTipoAcomodacoes();
          
        cbTipoAcomodacao.setSelectedIndex(ac.getTipoAcomodacaoId());        
    }
    
    public void preencherComboTipoAcomodacoes(){
        TipoAcomodacaoDao tad = new TipoAcomodacaoDao(new ConnectionFactory().getConnection());
        cbTipoAcomodacao.removeAllItems();
        for(TipoAcomodacao ta: tad.listarTipoAcomodacao()){
            cbTipoAcomodacao.addItem(ta.getDescricao());
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbTipoAcomodacao = new javax.swing.JComboBox<String>();
        jLabel2 = new javax.swing.JLabel();
        tfNumeroAcomodacao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfAndarAcomodacao = new javax.swing.JTextField();
        lbMsg = new javax.swing.JLabel();
        btnAtualizarAcomodacao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        jLabel1.setText("Tipo de Acomodação");

        cbTipoAcomodacao.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        cbTipoAcomodacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Selecione --" }));

        jLabel2.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        jLabel2.setText("Número da Acomodação");

        jLabel3.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        jLabel3.setText("Andar da Acomodação");

        tfAndarAcomodacao.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N

        lbMsg.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        lbMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnAtualizarAcomodacao.setFont(new java.awt.Font("Hotel Oriental", 0, 24)); // NOI18N
        btnAtualizarAcomodacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/edit.png"))); // NOI18N
        btnAtualizarAcomodacao.setText("Editar Acomodação");
        btnAtualizarAcomodacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarAcomodacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(28, 28, 28)
                                .addComponent(tfAndarAcomodacao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAtualizarAcomodacao))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(cbTipoAcomodacao, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(tfNumeroAcomodacao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbTipoAcomodacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfNumeroAcomodacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizarAcomodacao)
                    .addComponent(jLabel3)
                    .addComponent(tfAndarAcomodacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(lbMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarAcomodacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarAcomodacaoActionPerformed
        try{
            if(!"".equals(tfAndarAcomodacao.getText())){
                if(!"".equals(tfNumeroAcomodacao.getText())){
                    if(cbTipoAcomodacao.getSelectedIndex() > 0){
                        TipoAcomodacao tpa = (TipoAcomodacao) cbTipoAcomodacao.getSelectedItem();
                        
                        ac.setNumAcomodacao(Integer.valueOf(tfNumeroAcomodacao.getText()));
                        ac.setAndar(Integer.valueOf(tfAndarAcomodacao.getText()));
                        ac.setTipoAcomodacaoId(tpa.getTipoAcomodacaoId());
                        AcomodacaoDao dao = new AcomodacaoDao(new ConnectionFactory().getConnection());
                        int numeroAcomodacoesDisponiveis = tpa.getQtdeAcomodacoes() - (dao.listarAcomodacoesPorTipo(tpa.getTipoAcomodacaoId()).size());
                        if(numeroAcomodacoesDisponiveis > 0){  
                            dao = new AcomodacaoDao(new ConnectionFactory().getConnection());
                            dao.atualizarAcomodacao(ac);
                            
                            this.dispose();
                            pnGerenciarHotel.preencherMsg("Acomodação Atualizado", Color.GREEN);
                            pnGerenciarHotel.preecherTabelaAcomodacoes();
                        }else{
                            lbMsg.setText("Número limite atingido para esse tipo de acomodação!");
                            lbMsg.setForeground(Color.RED);
                        }                        
                    }else{
                        lbMsg.setText("Erro: Tipo Inválido!");
                        lbMsg.setForeground(Color.RED);
                    }
                }else{
                    lbMsg.setText("Erro: Numero Inválido!");
                    lbMsg.setForeground(Color.RED);
                }
            }else{
                lbMsg.setText("Erro: Andar Inválido!");
                lbMsg.setForeground(Color.RED);
            }
        }catch(Exception e){
            lbMsg.setText("Erro: " + e.getMessage());
            lbMsg.setForeground(Color.RED);
        }        
    }//GEN-LAST:event_btnAtualizarAcomodacaoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaEditarAcomodacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEditarAcomodacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEditarAcomodacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEditarAcomodacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEditarAcomodacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizarAcomodacao;
    private javax.swing.JComboBox<String> cbTipoAcomodacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbMsg;
    private javax.swing.JTextField tfAndarAcomodacao;
    private javax.swing.JTextField tfNumeroAcomodacao;
    // End of variables declaration//GEN-END:variables
}
