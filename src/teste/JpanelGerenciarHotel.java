/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import br.com.hotel.apresentacao.TelaEditarItensConsumo;
import br.com.hotel.apresentacao.TelaEditarTipoAcomodacao;
import br.com.hotel.apresentacao.TelaItensConsumo;
import br.com.hotel.apresentacao.TelaTipoAcomodacao;
import br.com.hotel.dao.ConnectionFactory;
import br.com.hotel.dao.ItemConsumoDao;
import br.com.hotel.dao.TipoAcomodacaoDao;
import br.com.hotel.modelo.ItemConsumo;
import br.com.hotel.modelo.TipoAcomodacao;
import br.com.hotel.tabela.TableModelItensConsumo;
import br.com.hotel.tabela.TableModelTipoAcomodacao;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author daylton
 */
public final class JpanelGerenciarHotel extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    
    TableModelItensConsumo modeloItensConsumo;
    TableModelTipoAcomodacao modeloAcomodacao;
    
    public JpanelGerenciarHotel() {
        initComponents();
        preencherTabelaItensConsumo();
        preencherTabelaTipoAcomodacao();
    }
    
    public void preencherMsg(String s, Color c){
        lbMsg.setText(s);
        lbMsg.setForeground(c);               
    }
    
    public void preencherTabelaItensConsumo(){
        ItemConsumoDao dao = new ItemConsumoDao(new ConnectionFactory().getConnection());      
        modeloItensConsumo = new TableModelItensConsumo();
        modeloItensConsumo.preencherLista(dao.listarItensConsumo());
        tbItensConsumo.setModel(modeloItensConsumo); 
               
        tbItensConsumo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tbItensConsumo.getColumnModel().getColumn(0).setPreferredWidth(205);
        tbItensConsumo.getColumnModel().getColumn(1).setPreferredWidth(125);
        tbItensConsumo.getColumnModel().getColumn(2).setPreferredWidth(79);
                
        tbItensConsumo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    public void preencherTabelaTipoAcomodacao(){
        TipoAcomodacaoDao dao = new TipoAcomodacaoDao(new ConnectionFactory().getConnection());      
        modeloAcomodacao = new TableModelTipoAcomodacao();
        modeloAcomodacao.preencherLista(dao.listarTipoAcomodacao());
        tbAcomodacoes.setModel(modeloAcomodacao); 
               
        tbAcomodacoes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tbAcomodacoes.getColumnModel().getColumn(0).setPreferredWidth(192);
        tbAcomodacoes.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbAcomodacoes.getColumnModel().getColumn(2).setPreferredWidth(95);
        tbAcomodacoes.getColumnModel().getColumn(3).setPreferredWidth(70);
        tbAcomodacoes.getColumnModel().getColumn(4).setPreferredWidth(70);
        
        DefaultTableCellRenderer rigthRender = new DefaultTableCellRenderer();
        rigthRender.setHorizontalAlignment(JLabel.CENTER);
        tbAcomodacoes.getColumnModel().getColumn(1).setCellRenderer(rigthRender);
        tbAcomodacoes.getColumnModel().getColumn(2).setCellRenderer(rigthRender);
        tbAcomodacoes.getColumnModel().getColumn(3).setCellRenderer(rigthRender);
        tbAcomodacoes.getColumnModel().getColumn(4).setCellRenderer(rigthRender);
                
        tbAcomodacoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbItensConsumo = new javax.swing.JTable();
        btnAdicionarItem = new javax.swing.JButton();
        btnEditarItem = new javax.swing.JButton();
        btnExcluirItem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAcomodacoes = new javax.swing.JTable();
        btnAdicionarAcomodacao = new javax.swing.JButton();
        btnEditarAcomodacao = new javax.swing.JButton();
        btnExcluirAcomodacao = new javax.swing.JButton();
        lbMsg = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tbItensConsumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Descrição", "Categoria", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbItensConsumo);

        btnAdicionarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/add.png"))); // NOI18N
        btnAdicionarItem.setText("Adicionar Item");
        btnAdicionarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarItemActionPerformed(evt);
            }
        });

        btnEditarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/edit.png"))); // NOI18N
        btnEditarItem.setText("Editar");
        btnEditarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarItemActionPerformed(evt);
            }
        });

        btnExcluirItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/delete.png"))); // NOI18N
        btnExcluirItem.setText("Excluir");
        btnExcluirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdicionarItem)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAdicionarItem)
                        .addComponent(btnEditarItem))
                    .addComponent(btnExcluirItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbAcomodacoes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbAcomodacoes);

        btnAdicionarAcomodacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/add.png"))); // NOI18N
        btnAdicionarAcomodacao.setText("Adicionar Acomodação");
        btnAdicionarAcomodacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarAcomodacaoActionPerformed(evt);
            }
        });

        btnEditarAcomodacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/edit.png"))); // NOI18N
        btnEditarAcomodacao.setText("Editar");
        btnEditarAcomodacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAcomodacaoActionPerformed(evt);
            }
        });

        btnExcluirAcomodacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/delete.png"))); // NOI18N
        btnExcluirAcomodacao.setText("Excluir Acomodação");
        btnExcluirAcomodacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirAcomodacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAdicionarAcomodacao)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarAcomodacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirAcomodacao)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarAcomodacao)
                    .addComponent(btnExcluirAcomodacao)
                    .addComponent(btnEditarAcomodacao))
                .addContainerGap())
        );

        lbMsg.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        lbMsg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(lbMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarItemActionPerformed
        TelaItensConsumo form1 = new TelaItensConsumo(this);
        form1.setAlwaysOnTop(true);
        form1.setVisible(true);
        form1.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAdicionarItemActionPerformed

    private void btnEditarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarItemActionPerformed
        if(tbItensConsumo.getSelectedRow() >= 0){
            ItemConsumo ic = modeloItensConsumo.retornarObjetoSelecionado(tbItensConsumo.getSelectedRow());

            TelaEditarItensConsumo form2 = new TelaEditarItensConsumo(ic, this);
            form2.setAlwaysOnTop(true);
            form2.setVisible(true);
            form2.setLocationRelativeTo(null);  
        }else{
            preencherMsg("Nenhuma Acomodação Selecionada", Color.RED);
        }
    }//GEN-LAST:event_btnEditarItemActionPerformed

    private void btnExcluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirItemActionPerformed
        if(tbAcomodacoes.getSelectedRow() >= 0){
            ItemConsumoDao dao = new ItemConsumoDao(new ConnectionFactory().getConnection());
            ItemConsumo ic = modeloItensConsumo.retornarObjetoSelecionado(tbItensConsumo.getSelectedRow());
            
            int r = JOptionPane.showConfirmDialog(this, "Voce tem certeza disso?");
            
            if(r == 0){
                    dao.excluirItemConsumo(ic.getCategoriaId());
                    preencherMsg("Acomodação Excluida!", Color.red);
            }
            
            preencherTabelaItensConsumo();
        }else{
            preencherMsg("Nenhuma Acomodação Selecionada", Color.RED);
        }
    }//GEN-LAST:event_btnExcluirItemActionPerformed

    private void btnAdicionarAcomodacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarAcomodacaoActionPerformed
        TelaTipoAcomodacao form3 = new TelaTipoAcomodacao(this);
        form3.setAlwaysOnTop(true);
        form3.setVisible(true);
        form3.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAdicionarAcomodacaoActionPerformed

    private void btnEditarAcomodacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAcomodacaoActionPerformed
        if(tbAcomodacoes.getSelectedRow() >= 0){
            TipoAcomodacao tpa = modeloAcomodacao.retornarObjetoSelecionado(tbAcomodacoes.getSelectedRow());

            TelaEditarTipoAcomodacao form4 = new TelaEditarTipoAcomodacao(tpa, this);
            form4.setAlwaysOnTop(true);
            form4.setVisible(true);
            form4.setLocationRelativeTo(null);  
        }else{
            preencherMsg("Nenhuma Acomodação Selecionada", Color.RED);
        }
    }//GEN-LAST:event_btnEditarAcomodacaoActionPerformed

    private void btnExcluirAcomodacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirAcomodacaoActionPerformed
        if(tbAcomodacoes.getSelectedRow() >= 0){
            TipoAcomodacaoDao dao = new TipoAcomodacaoDao(new ConnectionFactory().getConnection());
            TipoAcomodacao tpa = modeloAcomodacao.retornarObjetoSelecionado(tbAcomodacoes.getSelectedRow());
            
            int r = JOptionPane.showConfirmDialog(this, "Voce tem certeza disso?");
            
            if(r == 0){
                    dao.excluirTipoAcomodacao(tpa.getTipoAcomodacaoId());
                    preencherMsg("Acomodação Excluida!", Color.red);
            }
            
            preencherTabelaTipoAcomodacao();
        }else{
            preencherMsg("Nenhuma Acomodação Selecionada", Color.RED);
        }
    }//GEN-LAST:event_btnExcluirAcomodacaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarAcomodacao;
    private javax.swing.JButton btnAdicionarItem;
    private javax.swing.JButton btnEditarAcomodacao;
    private javax.swing.JButton btnEditarItem;
    private javax.swing.JButton btnExcluirAcomodacao;
    private javax.swing.JButton btnExcluirItem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbMsg;
    private javax.swing.JTable tbAcomodacoes;
    private javax.swing.JTable tbItensConsumo;
    // End of variables declaration//GEN-END:variables
}
