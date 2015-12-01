/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.painel;

import br.com.hotel.apresentacao.TelaAdicionarHospede;
import br.com.hotel.apresentacao.TelaEditarHospede;
import br.com.hotel.dao.ConnectionFactory;
import br.com.hotel.dao.HospedeDao;
import br.com.hotel.modelo.Hospede;
import br.com.hotel.tabela.TableModelHospedes;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author guilherme
 */
public class PainelCadastroHospede extends javax.swing.JPanel {

    /**
     * Creates new form PainelCadastroHospede
     */
    TableModelHospedes tableModelHospedes;
    
    public PainelCadastroHospede() {
        initComponents();
         preencherTabelaHospedes();
    }
    
     public void preencherMsg(String s, Color c){
        lbMsg.setText(s);
        lbMsg.setForeground(c); 
    }
    
    public void preencherTabelaHospedes(){
        HospedeDao hd = new HospedeDao(new ConnectionFactory().getConnection());
        tableModelHospedes = new TableModelHospedes();
        tableModelHospedes.preencherLista(hd.listarHospedes());
        tabelaHospedes.setModel(tableModelHospedes);
        
        DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
        centerRender.setHorizontalAlignment(JLabel.CENTER);
        tabelaHospedes.getColumnModel().getColumn(0).setCellRenderer(centerRender);
        tabelaHospedes.getColumnModel().getColumn(1).setCellRenderer(centerRender);
        tabelaHospedes.getColumnModel().getColumn(2).setCellRenderer(centerRender);        
        tabelaHospedes.getTableHeader().setFont(new Font("Hotel Oriental", 1, 18));                
        ((DefaultTableCellRenderer) tabelaHospedes.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(CENTER);
        
        tabelaHospedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        lbMsg = new javax.swing.JLabel();
        btnAdicionarHospede = new javax.swing.JButton();
        btnEditarHospede = new javax.swing.JButton();
        btnExcluirHospede = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaHospedes = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        lbMsg.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        lbMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnAdicionarHospede.setFont(new java.awt.Font("Hotel Oriental", 0, 20)); // NOI18N
        btnAdicionarHospede.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/add.png"))); // NOI18N
        btnAdicionarHospede.setText("Adicionar Hospede");
        btnAdicionarHospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarHospedeActionPerformed(evt);
            }
        });

        btnEditarHospede.setFont(new java.awt.Font("Hotel Oriental", 0, 20)); // NOI18N
        btnEditarHospede.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/edit.png"))); // NOI18N
        btnEditarHospede.setText("Editar Hospede");
        btnEditarHospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarHospedeActionPerformed(evt);
            }
        });

        btnExcluirHospede.setFont(new java.awt.Font("Hotel Oriental", 0, 20)); // NOI18N
        btnExcluirHospede.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/delete.png"))); // NOI18N
        btnExcluirHospede.setText("Excluir Hospede");
        btnExcluirHospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirHospedeActionPerformed(evt);
            }
        });

        tabelaHospedes.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        tabelaHospedes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaHospedes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdicionarHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirHospede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarHospede)
                    .addComponent(btnEditarHospede)
                    .addComponent(btnExcluirHospede))
                .addGap(18, 18, 18)
                .addComponent(lbMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/city.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarHospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarHospedeActionPerformed
        TelaAdicionarHospede t1 = new TelaAdicionarHospede();
        t1.setAlwaysOnTop(true);
        t1.setVisible(true);
        t1.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAdicionarHospedeActionPerformed

    private void btnEditarHospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarHospedeActionPerformed
        if(tabelaHospedes.getSelectedRow() >= 0){
            Hospede h = tableModelHospedes.retornarObjetoSelecionado(tabelaHospedes.getSelectedRow());

            TelaEditarHospede t2 = new TelaEditarHospede(h, this);
            t2.setAlwaysOnTop(true);
            t2.setVisible(true);
            t2.setLocationRelativeTo(null);

        }else{
            preencherMsg("Nenhum hospede Selecionado!", Color.red);
        }
    }//GEN-LAST:event_btnEditarHospedeActionPerformed

    private void btnExcluirHospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirHospedeActionPerformed
        if(tabelaHospedes.getSelectedRow() >= 0){
            Hospede h = tableModelHospedes.retornarObjetoSelecionado(tabelaHospedes.getSelectedRow());
            JLabel msg = new JLabel();
            msg.setFont(new Font("Hotel Oriental", 1, 18));
            msg.setForeground(Color.RED);
            msg.setText("Voce tem certeza disso?");
            
            int r = JOptionPane.showConfirmDialog(this, msg, "ATENÇÃO",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon());

            if(r == 0){
                HospedeDao hd = new HospedeDao(new ConnectionFactory().getConnection());
                hd.excluirHospede(h.getHospedeId());
                preencherMsg("Nenhum hospede Selecionado!", Color.red);
            }
            this.preencherTabelaHospedes();
        }else{
            preencherMsg("Nenhum hospede Selecionado!", Color.red);
        }
    }//GEN-LAST:event_btnExcluirHospedeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarHospede;
    private javax.swing.JButton btnEditarHospede;
    private javax.swing.JButton btnExcluirHospede;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbMsg;
    private javax.swing.JTable tabelaHospedes;
    // End of variables declaration//GEN-END:variables
}
