/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.painel;

import br.com.hotel.apresentacao.TelaEditarItensConsumo;
import br.com.hotel.apresentacao.TelaEditarTipoAcomodacao;
import br.com.hotel.apresentacao.TelaItensConsumo;
import br.com.hotel.apresentacao.TelaTipoAcomodacao;
import br.com.hotel.dao.AcomodacaoDao;
import br.com.hotel.dao.ConnectionFactory;
import br.com.hotel.dao.ItemConsumoDao;
import br.com.hotel.dao.TipoAcomodacaoDao;
import br.com.hotel.modelo.Acomodacao;
import br.com.hotel.modelo.ItemConsumo;
import br.com.hotel.modelo.TipoAcomodacao;
import br.com.hotel.tabela.TableModelAcomodacoes;
import br.com.hotel.tabela.TableModelItensConsumo;
import br.com.hotel.tabela.TableModelTipoAcomodacao;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author guilherme
 */
public class PainelGerenciarHotel extends javax.swing.JPanel {

    /**
     * Creates new form PainelGerenciarHotel
     */
    TableModelItensConsumo modeloItensConsumo;
    TableModelTipoAcomodacao modeloAcomodacao;
    private TableModelAcomodacoes tma;
    public PainelGerenciarHotel() {
        initComponents();
        preencherTabelaItensConsumo();
        preencherTabelaTipoAcomodacao();
        TipoAcomodacaoDao tad = new TipoAcomodacaoDao(new ConnectionFactory().getConnection());
        if(tad.listarTipoAcomodacao().isEmpty()){
            JOptionPane.showMessageDialog(null, "Não existem acomodações cadastradas!");
        }else{
            preencherComboTipoAcomodacoes();
            preecherTabelaAcomodacoes();
        }
    }

    public void preencherMsg(String s, Color c){
        lbMsg.setText(s);
        lbMsg.setForeground(c);      
        lbMsg1.setText(s);
        lbMsg1.setForeground(c);
        lbMsg2.setText(s);
        lbMsg2.setForeground(c);
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
                
        DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
        centerRender.setHorizontalAlignment(JLabel.CENTER);
        tbItensConsumo.getColumnModel().getColumn(0).setCellRenderer(centerRender);
        tbItensConsumo.getColumnModel().getColumn(1).setCellRenderer(centerRender);
        tbItensConsumo.getColumnModel().getColumn(2).setCellRenderer(centerRender);
        
        ((DefaultTableCellRenderer) tbItensConsumo.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(CENTER);
        
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
        
        DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
        centerRender.setHorizontalAlignment(JLabel.CENTER);
        tbAcomodacoes.getColumnModel().getColumn(0).setCellRenderer(centerRender);
        tbAcomodacoes.getColumnModel().getColumn(1).setCellRenderer(centerRender);
        tbAcomodacoes.getColumnModel().getColumn(2).setCellRenderer(centerRender);
        tbAcomodacoes.getColumnModel().getColumn(3).setCellRenderer(centerRender);
        tbAcomodacoes.getColumnModel().getColumn(4).setCellRenderer(centerRender);
        
        ((DefaultTableCellRenderer) tbAcomodacoes.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(CENTER);
                
        tbAcomodacoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    public void preencherComboTipoAcomodacoes(){
        TipoAcomodacaoDao tad = new TipoAcomodacaoDao(new ConnectionFactory().getConnection());
        cbTipoAcomodacao.removeAllItems();
        for(TipoAcomodacao ta: tad.listarTipoAcomodacao()){
            cbTipoAcomodacao.addItem(ta.getDescricao());
        }
    }
    
    public void preecherTabelaAcomodacoes(){
        AcomodacaoDao ad = new AcomodacaoDao(new ConnectionFactory().getConnection());
        tma = new TableModelAcomodacoes();
        tma.preencherLista(ad.listarAcomodacoes());
        tabelaAcomodacoes.setModel(tma);
        tabelaAcomodacoes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabelaAcomodacoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbItensConsumo = new javax.swing.JTable();
        btnAdicionarItem = new javax.swing.JButton();
        btnEditarItem = new javax.swing.JButton();
        btnExcluirItem = new javax.swing.JButton();
        lbMsg = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAcomodacoes = new javax.swing.JTable();
        btnAdicionarAcomodacao = new javax.swing.JButton();
        btnEditarAcomodacao = new javax.swing.JButton();
        btnExcluirAcomodacao = new javax.swing.JButton();
        lbMsg1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaAcomodacoes = new javax.swing.JTable();
        cbTipoAcomodacao = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfNumeroAcomodacao = new javax.swing.JTextField();
        tfAndarAcomodacao = new javax.swing.JTextField();
        btnInserirAcomodacao = new javax.swing.JButton();
        btnApagarAcomodacao = new javax.swing.JButton();
        btnAtualizarAcomodacao = new javax.swing.JButton();
        lbMsg2 = new javax.swing.JLabel();

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAdicionarItem)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAdicionarItem)
                        .addComponent(btnEditarItem))
                    .addComponent(btnExcluirItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(lbMsg, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(609, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Gerenciar Itens de Consumo", jPanel1);

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
        btnAdicionarAcomodacao.setText("Adicionar Tipo de Acomodação");
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
        btnExcluirAcomodacao.setText("Excluir Tipo de Acomodação");
        btnExcluirAcomodacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirAcomodacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnAdicionarAcomodacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditarAcomodacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirAcomodacao)
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarAcomodacao)
                    .addComponent(btnExcluirAcomodacao)
                    .addComponent(btnEditarAcomodacao))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbMsg1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(398, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMsg1, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Gerenciar Tipos de Acomodação", jPanel2);

        tabelaAcomodacoes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tabelaAcomodacoes);

        cbTipoAcomodacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Tipo de Acomodação:");

        jLabel2.setText("Número da Acomodação:");

        jLabel3.setText("Andar da Acomodação:");

        btnInserirAcomodacao.setText("Adicionar Acomodação");
        btnInserirAcomodacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirAcomodacaoActionPerformed(evt);
            }
        });

        btnApagarAcomodacao.setText("Excluir Acomodação");
        btnApagarAcomodacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarAcomodacaoActionPerformed(evt);
            }
        });

        btnAtualizarAcomodacao.setText("Editar Acomodação");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(cbTipoAcomodacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfNumeroAcomodacao)
                            .addComponent(tfAndarAcomodacao)
                            .addComponent(btnInserirAcomodacao, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnApagarAcomodacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAtualizarAcomodacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lbMsg2, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTipoAcomodacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNumeroAcomodacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfAndarAcomodacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInserirAcomodacao))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnApagarAcomodacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAtualizarAcomodacao))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addComponent(lbMsg2, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );

        jTabbedPane1.addTab("Gerenciar Acomodações", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
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

    private void btnInserirAcomodacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirAcomodacaoActionPerformed
        String tipoAcomodacao = (String)cbTipoAcomodacao.getSelectedItem();
        TipoAcomodacaoDao tad = new TipoAcomodacaoDao(new ConnectionFactory().getConnection());
        TipoAcomodacao ta = tad.buscarTipoAcomodacao(tipoAcomodacao);
        if(ta != null){
            if(!tfNumeroAcomodacao.getText().equals("")){
                if(!tfAndarAcomodacao.getText().equals("")){
                    try{
                        Acomodacao a = new Acomodacao();
                        a.setNumAcomodacao(Integer.valueOf(tfNumeroAcomodacao.getText()));
                        a.setAndar(Integer.valueOf(tfAndarAcomodacao.getText()));
                        a.setReservado(false);
                        a.setTipoAcomodacaoId(ta.getTipoAcomodacaoId());
                        AcomodacaoDao ad = new AcomodacaoDao(new ConnectionFactory().getConnection());
                        ad.inserirAcomodacao(a);
                        JOptionPane.showMessageDialog(null, "Acomodacao Adicionada!");
                        preecherTabelaAcomodacoes();
                    }catch(Exception erro){
                        JOptionPane.showMessageDialog(null, "Não foi possível adicionar acomodação");
                    }
                }
            }
        }
    }//GEN-LAST:event_btnInserirAcomodacaoActionPerformed

    private void btnApagarAcomodacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarAcomodacaoActionPerformed
        if(tabelaAcomodacoes.getSelectedRow() >= 0){
            AcomodacaoDao dao = new AcomodacaoDao(new ConnectionFactory().getConnection());
            Acomodacao a = tma.retornarObjetoSelecionado(tabelaAcomodacoes.getSelectedRow());

            int r = JOptionPane.showConfirmDialog(this, "Voce tem certeza disso?");

            if(r == 0){
                dao.excluirAcomodacao(a.getAcomodacaoId());
                preencherMsg("Acomodação Excluida!", Color.red);
            }

            preecherTabelaAcomodacoes();
        }else{
            preencherMsg("Nenhuma Acomodação Selecionada", Color.RED);
        }
    }//GEN-LAST:event_btnApagarAcomodacaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarAcomodacao;
    private javax.swing.JButton btnAdicionarItem;
    private javax.swing.JButton btnApagarAcomodacao;
    private javax.swing.JButton btnAtualizarAcomodacao;
    private javax.swing.JButton btnEditarAcomodacao;
    private javax.swing.JButton btnEditarItem;
    private javax.swing.JButton btnExcluirAcomodacao;
    private javax.swing.JButton btnExcluirItem;
    private javax.swing.JButton btnInserirAcomodacao;
    private javax.swing.JComboBox<String> cbTipoAcomodacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbMsg;
    private javax.swing.JLabel lbMsg1;
    private javax.swing.JLabel lbMsg2;
    private javax.swing.JTable tabelaAcomodacoes;
    private javax.swing.JTable tbAcomodacoes;
    private javax.swing.JTable tbItensConsumo;
    private javax.swing.JTextField tfAndarAcomodacao;
    private javax.swing.JTextField tfNumeroAcomodacao;
    // End of variables declaration//GEN-END:variables
}
