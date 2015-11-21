/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.apresentacao;

import br.com.hotel.dao.ConnectionFactory;
import br.com.hotel.dao.TipoAcomodacaoDao;
import br.com.hotel.modelo.TipoAcomodacao;
import br.com.hotel.tabela.TableModelTipoAcomodacao;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author daylton
 */
public final class TelaAcomodacao extends javax.swing.JFrame {

    /**
     * Creates new form TelaAcomodação
     */
    
    TableModelTipoAcomodacao modelo;
    
    public TelaAcomodacao() {
        initComponents();        
        preencherTabela();
    }
    
    public void preencherTabela(){
        TipoAcomodacaoDao dao = new TipoAcomodacaoDao(new ConnectionFactory().getConnection());      
        modelo = new TableModelTipoAcomodacao();
        modelo.preencherLista(dao.listarTipoAcomodacao());
        tbTipoAcomodacao.setModel(modelo); 
               
        tbTipoAcomodacao.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tbTipoAcomodacao.getColumnModel().getColumn(0).setPreferredWidth(204);
        tbTipoAcomodacao.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbTipoAcomodacao.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbTipoAcomodacao.getColumnModel().getColumn(3).setPreferredWidth(70);
        tbTipoAcomodacao.getColumnModel().getColumn(4).setPreferredWidth(70);
        
        DefaultTableCellRenderer rigthRender = new DefaultTableCellRenderer();
        rigthRender.setHorizontalAlignment(JLabel.CENTER);
        tbTipoAcomodacao.getColumnModel().getColumn(1).setCellRenderer(rigthRender);
        tbTipoAcomodacao.getColumnModel().getColumn(2).setCellRenderer(rigthRender);
        tbTipoAcomodacao.getColumnModel().getColumn(3).setCellRenderer(rigthRender);
        tbTipoAcomodacao.getColumnModel().getColumn(4).setCellRenderer(rigthRender);
        
        tbTipoAcomodacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    public void preecherMsg(String t, Color c){
        lbMsg.setText(t);
        lbMsg.setForeground(c);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbTipoAcomodacao = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        lbMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbTipoAcomodacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Descricao", "Quantidade", "Valor Diaria", "Num Adulto", "Num Criança"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbTipoAcomodacao);

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/add.png"))); // NOI18N
        btnAdicionar.setText("Adicionar ");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/delete.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        lbMsg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnEditar)
                                .addGap(18, 18, 18)
                                .addComponent(btnAdicionar)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir)
                                .addGap(18, 18, 18)
                                .addComponent(btnSair))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnExcluir)
                    .addComponent(btnSair)
                    .addComponent(btnEditar))
                .addGap(18, 18, 18)
                .addComponent(lbMsg, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(tbTipoAcomodacao.getSelectedRow() >= 0){
            TipoAcomodacao tpa = modelo.retornarObjetoSelecionado(tbTipoAcomodacao.getSelectedRow());

            TelaEditarTipoAcomodacao form1 = new TelaEditarTipoAcomodacao(tpa, this);
            form1.setAlwaysOnTop(true);
            form1.setVisible(true);
            form1.setLocationRelativeTo(null);  
        }else{
            preecherMsg("Nenhuma Acomodação Selecionada", Color.RED);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        TelaTipoAcomodacao form2 = new TelaTipoAcomodacao(this);
        form2.setAlwaysOnTop(true);
        form2.setVisible(true);
        form2.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if(tbTipoAcomodacao.getSelectedRow() >= 0){
            TipoAcomodacaoDao dao = new TipoAcomodacaoDao(new ConnectionFactory().getConnection());
            TipoAcomodacao tpa = modelo.retornarObjetoSelecionado(tbTipoAcomodacao.getSelectedRow());
            
            int r = JOptionPane.showConfirmDialog(this, "Voce tem certeza disso?");
            
            if(r == 0){
                    dao.excluirTipoAcomodacao(tpa.getTipoAcomodacaoId());
                    preecherMsg("Acomodação Excluida!", Color.red);
            }
            
            preencherTabela();
        }else{
            preecherMsg("Nenhuma Acomodação Selecionada", Color.RED);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

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
            java.util.logging.Logger.getLogger(TelaAcomodacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAcomodacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAcomodacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAcomodacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAcomodacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbMsg;
    private javax.swing.JTable tbTipoAcomodacao;
    // End of variables declaration//GEN-END:variables
}
