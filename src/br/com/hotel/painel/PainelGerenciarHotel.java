/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.painel;

import br.com.hotel.apresentacao.TelaAdicionarAcomodacao;
import br.com.hotel.apresentacao.TelaEditarAcomodacao;
import br.com.hotel.apresentacao.TelaEditarItensConsumo;
import br.com.hotel.apresentacao.TelaEditarTipoAcomodacao;
import br.com.hotel.apresentacao.TelaAdicionarItensConsumo;
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
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author daylton
 */
public class PainelGerenciarHotel extends javax.swing.JPanel {

    /**
     * Creates new form PainelGerenciarHotel
     */
    
    private TableModelItensConsumo modeloItensConsumo;
    private TableModelTipoAcomodacao modeloTipoAcomodacao;
    private TableModelAcomodacoes modeloAcomodacao;
    
    public PainelGerenciarHotel() {
        initComponents();
        preencherTabelaItensConsumo();
        preencherTabelaTipoAcomodacao();
        TipoAcomodacaoDao tad = new TipoAcomodacaoDao(new ConnectionFactory().getConnection());
        if(tad.listarTipoAcomodacao().isEmpty()){
            preecherTabelaAcomodacoes();
            preencherMsg("Não existem acomodações cadastradas!", Color.red);
        }else{
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
               
//        tbItensConsumo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        tbItensConsumo.getColumnModel().getColumn(0).setPreferredWidth(205);
//        tbItensConsumo.getColumnModel().getColumn(1).setPreferredWidth(125);
//        tbItensConsumo.getColumnModel().getColumn(2).setPreferredWidth(79);
//                
        DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
        centerRender.setHorizontalAlignment(JLabel.CENTER);
        tbItensConsumo.getColumnModel().getColumn(0).setCellRenderer(centerRender);
        tbItensConsumo.getColumnModel().getColumn(1).setCellRenderer(centerRender);
        tbItensConsumo.getColumnModel().getColumn(2).setCellRenderer(centerRender);        
        tbItensConsumo.getTableHeader().setFont(new Font("Hotel Oriental", 1, 18));                
        ((DefaultTableCellRenderer) tbItensConsumo.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(CENTER);
        tbItensConsumo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    public void preencherTabelaTipoAcomodacao(){
        TipoAcomodacaoDao dao = new TipoAcomodacaoDao(new ConnectionFactory().getConnection());      
        modeloTipoAcomodacao = new TableModelTipoAcomodacao();
        modeloTipoAcomodacao.preencherLista(dao.listarTipoAcomodacao());
        tbTipoAcomodacoes.setModel(modeloTipoAcomodacao); 
               
//        tbAcomodacoes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        tbAcomodacoes.getColumnModel().getColumn(0).setPreferredWidth(192);
//        tbAcomodacoes.getColumnModel().getColumn(1).setPreferredWidth(100);
//        tbAcomodacoes.getColumnModel().getColumn(2).setPreferredWidth(95);
//        tbAcomodacoes.getColumnModel().getColumn(3).setPreferredWidth(70);
//        tbAcomodacoes.getColumnModel().getColumn(4).setPreferredWidth(70);
        
        DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
        centerRender.setHorizontalAlignment(JLabel.CENTER);
        tbTipoAcomodacoes.getColumnModel().getColumn(0).setCellRenderer(centerRender);
        tbTipoAcomodacoes.getColumnModel().getColumn(1).setCellRenderer(centerRender);
        tbTipoAcomodacoes.getColumnModel().getColumn(2).setCellRenderer(centerRender);
        tbTipoAcomodacoes.getColumnModel().getColumn(3).setCellRenderer(centerRender);
        tbTipoAcomodacoes.getColumnModel().getColumn(4).setCellRenderer(centerRender);        
        tbTipoAcomodacoes.getTableHeader().setFont(new Font("Hotel Oriental", 1, 18));        
        ((DefaultTableCellRenderer) tbTipoAcomodacoes.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(CENTER);        
        tbTipoAcomodacoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    public void preecherTabelaAcomodacoes(){
        AcomodacaoDao ad = new AcomodacaoDao(new ConnectionFactory().getConnection());
        modeloAcomodacao = new TableModelAcomodacoes();
        modeloAcomodacao.preencherLista(ad.listarAcomodacoes());
        tbAcomodacoes.setModel(modeloAcomodacao);
        tbAcomodacoes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbAcomodacoes.getTableHeader().setFont(new Font("Hotel Oriental", 1, 18));
        ((DefaultTableCellRenderer) tbAcomodacoes.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(CENTER);        
        tbAcomodacoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbTipoAcomodacoes = new javax.swing.JTable();
        btnAdicionarAcomodacao = new javax.swing.JButton();
        btnEditarAcomodacao = new javax.swing.JButton();
        btnExcluirAcomodacao = new javax.swing.JButton();
        lbMsg1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnInserirAcomodacao = new javax.swing.JButton();
        lbMsg2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbAcomodacoes = new javax.swing.JTable();
        btnApagarAcomodacao = new javax.swing.JButton();
        btnAtualizarAcomodacao = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        jTabbedPane1.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N

        tbItensConsumo.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
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

        btnAdicionarItem.setFont(new java.awt.Font("Hotel Oriental", 0, 20)); // NOI18N
        btnAdicionarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/add.png"))); // NOI18N
        btnAdicionarItem.setText("Adicionar Item de Consumo");
        btnAdicionarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarItemActionPerformed(evt);
            }
        });

        btnEditarItem.setFont(new java.awt.Font("Hotel Oriental", 0, 20)); // NOI18N
        btnEditarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/edit.png"))); // NOI18N
        btnEditarItem.setText("Editar Item de Consumo");
        btnEditarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarItemActionPerformed(evt);
            }
        });

        btnExcluirItem.setFont(new java.awt.Font("Hotel Oriental", 0, 20)); // NOI18N
        btnExcluirItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/delete.png"))); // NOI18N
        btnExcluirItem.setText("Excluir Item de Consumo");
        btnExcluirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirItemActionPerformed(evt);
            }
        });

        lbMsg.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        lbMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(lbMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAdicionarItem, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirItem, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarItem)
                    .addComponent(btnEditarItem)
                    .addComponent(btnExcluirItem))
                .addGap(18, 18, 18)
                .addComponent(lbMsg, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/city.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Gerenciar Itens de Consumo", jPanel1);

        tbTipoAcomodacoes.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        tbTipoAcomodacoes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbTipoAcomodacoes);

        btnAdicionarAcomodacao.setFont(new java.awt.Font("Hotel Oriental", 0, 20)); // NOI18N
        btnAdicionarAcomodacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/add.png"))); // NOI18N
        btnAdicionarAcomodacao.setText("Adicionar Tipo de Acomodação");
        btnAdicionarAcomodacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarAcomodacaoActionPerformed(evt);
            }
        });

        btnEditarAcomodacao.setFont(new java.awt.Font("Hotel Oriental", 0, 20)); // NOI18N
        btnEditarAcomodacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/edit.png"))); // NOI18N
        btnEditarAcomodacao.setText("Editar Tipo de Acomodação");
        btnEditarAcomodacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAcomodacaoActionPerformed(evt);
            }
        });

        btnExcluirAcomodacao.setFont(new java.awt.Font("Hotel Oriental", 0, 20)); // NOI18N
        btnExcluirAcomodacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/delete.png"))); // NOI18N
        btnExcluirAcomodacao.setText("Excluir Tipo de Acomodação");
        btnExcluirAcomodacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirAcomodacaoActionPerformed(evt);
            }
        });

        lbMsg1.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        lbMsg1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbMsg1, javax.swing.GroupLayout.PREFERRED_SIZE, 1011, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnAdicionarAcomodacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditarAcomodacao, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(303, 303, 303)))
                        .addGap(0, 45, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExcluirAcomodacao, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarAcomodacao)
                    .addComponent(btnExcluirAcomodacao)
                    .addComponent(btnEditarAcomodacao))
                .addGap(18, 18, 18)
                .addComponent(lbMsg1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/city.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Gerenciar Tipos de Acomodação", jPanel2);

        btnInserirAcomodacao.setFont(new java.awt.Font("Hotel Oriental", 0, 20)); // NOI18N
        btnInserirAcomodacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/add.png"))); // NOI18N
        btnInserirAcomodacao.setText("Adicionar Acomodação");
        btnInserirAcomodacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirAcomodacaoActionPerformed(evt);
            }
        });

        lbMsg2.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        lbMsg2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        tbAcomodacoes.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
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
        jScrollPane3.setViewportView(tbAcomodacoes);

        btnApagarAcomodacao.setFont(new java.awt.Font("Hotel Oriental", 0, 20)); // NOI18N
        btnApagarAcomodacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/delete.png"))); // NOI18N
        btnApagarAcomodacao.setText("Excluir Acomodação");
        btnApagarAcomodacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarAcomodacaoActionPerformed(evt);
            }
        });

        btnAtualizarAcomodacao.setFont(new java.awt.Font("Hotel Oriental", 0, 20)); // NOI18N
        btnAtualizarAcomodacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/edit.png"))); // NOI18N
        btnAtualizarAcomodacao.setText("Editar Acomodação");
        btnAtualizarAcomodacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarAcomodacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMsg2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnInserirAcomodacao, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAtualizarAcomodacao, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnApagarAcomodacao, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApagarAcomodacao)
                    .addComponent(btnAtualizarAcomodacao)
                    .addComponent(btnInserirAcomodacao))
                .addGap(18, 18, 18)
                .addComponent(lbMsg2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/city.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Gerenciar Acomodações", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarItemActionPerformed
        TelaAdicionarItensConsumo t1 = new TelaAdicionarItensConsumo(this);
        t1.setAlwaysOnTop(true);
        t1.setVisible(true);
        t1.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAdicionarItemActionPerformed

    private void btnEditarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarItemActionPerformed
        if(tbItensConsumo.getSelectedRow() >= 0){
            ItemConsumo ic = modeloItensConsumo.retornarObjetoSelecionado(tbItensConsumo.getSelectedRow());

            TelaEditarItensConsumo t2 = new TelaEditarItensConsumo(ic, this);
            t2.setAlwaysOnTop(true);
            t2.setVisible(true);
            t2.setLocationRelativeTo(null);
        }else{
            preencherMsg("Nenhumo Item Selecionado", Color.RED);
        }
    }//GEN-LAST:event_btnEditarItemActionPerformed

    private void btnExcluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirItemActionPerformed
        if(tbTipoAcomodacoes.getSelectedRow() >= 0){
            ItemConsumoDao dao = new ItemConsumoDao(new ConnectionFactory().getConnection());
            ItemConsumo ic = modeloItensConsumo.retornarObjetoSelecionado(tbItensConsumo.getSelectedRow());

            int r = JOptionPane.showConfirmDialog(this, "Voce tem certeza disso?");

            if(r == 0){
                dao.excluirItemConsumo(ic.getCategoriaId());
                preencherMsg("Item Excluido!", Color.red);
            }

            preencherTabelaItensConsumo();
        }else{
            preencherMsg("Nenhumo Item Selecionado", Color.RED);
        }
    }//GEN-LAST:event_btnExcluirItemActionPerformed

    private void btnAdicionarAcomodacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarAcomodacaoActionPerformed
        TelaTipoAcomodacao t3 = new TelaTipoAcomodacao(this);
        t3.setAlwaysOnTop(true);
        t3.setVisible(true);
        t3.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAdicionarAcomodacaoActionPerformed

    private void btnEditarAcomodacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAcomodacaoActionPerformed
        if(tbTipoAcomodacoes.getSelectedRow() >= 0){
            TipoAcomodacao tpa = modeloTipoAcomodacao.retornarObjetoSelecionado(tbTipoAcomodacoes.getSelectedRow());

            TelaEditarTipoAcomodacao t4 = new TelaEditarTipoAcomodacao(tpa, this);
            t4.setAlwaysOnTop(true);
            t4.setVisible(true);
            t4.setLocationRelativeTo(null);
        }else{
            preencherMsg("Nenhuma Acomodação Selecionada", Color.RED);
        }
    }//GEN-LAST:event_btnEditarAcomodacaoActionPerformed

    private void btnExcluirAcomodacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirAcomodacaoActionPerformed
        if(tbTipoAcomodacoes.getSelectedRow() >= 0){
            TipoAcomodacaoDao dao = new TipoAcomodacaoDao(new ConnectionFactory().getConnection());
            TipoAcomodacao tpa = modeloTipoAcomodacao.retornarObjetoSelecionado(tbTipoAcomodacoes.getSelectedRow());

            int r = JOptionPane.showConfirmDialog(this, "Voce tem certeza disso?? Acomodações deste tipo também serão excluidas!");

            if(r == 0){
                dao.excluirTipoAcomodacao(tpa.getTipoAcomodacaoId());
                preencherMsg("Tipo de Acomodação Excluido!", Color.red);
            }

            preencherTabelaTipoAcomodacao();
            preecherTabelaAcomodacoes();
        }else{
            preencherMsg("Nenhuma Acomodação Selecionada", Color.RED);
        }
    }//GEN-LAST:event_btnExcluirAcomodacaoActionPerformed

    private void btnInserirAcomodacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirAcomodacaoActionPerformed
        TelaAdicionarAcomodacao t5 = new TelaAdicionarAcomodacao(this);
        t5.setAlwaysOnTop(true);
        t5.setVisible(true);
        t5.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnInserirAcomodacaoActionPerformed

    private void btnApagarAcomodacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarAcomodacaoActionPerformed
        if(tbAcomodacoes.getSelectedRow() >= 0){
            AcomodacaoDao dao = new AcomodacaoDao(new ConnectionFactory().getConnection());
            Acomodacao a = modeloAcomodacao.retornarObjetoSelecionado(tbAcomodacoes.getSelectedRow());

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

    private void btnAtualizarAcomodacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarAcomodacaoActionPerformed
        if(tbAcomodacoes.getSelectedRow() >= 0){
            Acomodacao ac = modeloAcomodacao.retornarObjetoSelecionado(tbTipoAcomodacoes.getSelectedRow());
            
            TelaEditarAcomodacao t5 = new TelaEditarAcomodacao();
            t5.setAlwaysOnTop(true);
            t5.setVisible(true);
            t5.setLocationRelativeTo(null);
        }else{
            preencherMsg("Nenhuma Acomodação Selecionada", Color.RED);
        }
    }//GEN-LAST:event_btnAtualizarAcomodacaoActionPerformed


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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbMsg;
    private javax.swing.JLabel lbMsg1;
    private javax.swing.JLabel lbMsg2;
    private javax.swing.JTable tbAcomodacoes;
    private javax.swing.JTable tbItensConsumo;
    private javax.swing.JTable tbTipoAcomodacoes;
    // End of variables declaration//GEN-END:variables
}
