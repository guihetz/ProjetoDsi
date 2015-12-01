/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.painel;

import br.com.hotel.apresentacao.TelaRegistrarReserva;
import br.com.hotel.apresentacao.TelaRegistrarSaida;
import br.com.hotel.dao.AcomodacaoDao;
import br.com.hotel.dao.AcompanhanteDao;
import br.com.hotel.dao.ConnectionFactory;
import br.com.hotel.dao.ConsumoDao;
import br.com.hotel.dao.EntradaDao;
import br.com.hotel.dao.HospedeDao;
import br.com.hotel.dao.ItemConsumoDao;
import br.com.hotel.dao.ReservaDao;
import br.com.hotel.modelo.Acomodacao;
import br.com.hotel.modelo.Acompanhante;
import br.com.hotel.modelo.Cartao;
import br.com.hotel.modelo.Consumo;
import br.com.hotel.modelo.Entrada;
import br.com.hotel.modelo.Hospede;
import br.com.hotel.modelo.ItemConsumo;
import br.com.hotel.modelo.Reserva;
import br.com.hotel.tabela.TableModelAcomodacoes;
import br.com.hotel.tabela.TableModelAcompanhantes;
import br.com.hotel.tabela.TableModelHospedes;
import br.com.hotel.tabela.TableModelItensConsumo;
import br.com.hotel.tabela.TableModelReservas;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author guilherme
 */
public class PainelCadastroReservas extends javax.swing.JPanel {

    /**
     * Creates new form PainelCadastroReservas
     */
    private TableModelHospedes tableModelHospedes;
    private TableModelReservas tableModelReservas;
    private TableModelReservas tableModelReservas2;
    private TableModelReservas tableModelReservas3;
    private TableModelAcomodacoes modeloAcomodacao;
    private TableModelItensConsumo tmic;
    private Hospede h;
    private Acomodacao acomodacaoEscolhida;
    private ArrayList<Acompanhante> acompanhantes;
    private Cartao c;
    
    public PainelCadastroReservas() {
        initComponents();
        this.acompanhantes = new ArrayList<>();
        this.c = new Cartao();
        this.preencherTabelaHospedes();
        this.preencherTabelaReservas();
        this.preencherTabelaReservasDoHospede(null);
        this.preencherTabelaAcompanhantes(null);
        this.preencherTabelaItensConsumo();
        this.preecherTabelaAcomodacoes();
        this.preencherTabelaReservasSaida();
    }
       
    public void preencherMsg(String s, Color c){
        lbMsg4.setText(s);
        lbMsg4.setForeground(c);
    }
    
    public void preencherTabelaHospedes(){
        HospedeDao hd = new HospedeDao(new ConnectionFactory().getConnection());
        tableModelHospedes = new TableModelHospedes();
        tableModelHospedes.preencherLista(hd.listarHospedes());
        tabelaHospedes.setModel(tableModelHospedes);
        tabelaHospedes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabelaHospedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
        centerRender.setHorizontalAlignment(JLabel.CENTER);
        tabelaHospedes.getColumnModel().getColumn(0).setCellRenderer(centerRender);
        tabelaHospedes.getColumnModel().getColumn(1).setCellRenderer(centerRender);
        tabelaHospedes.getColumnModel().getColumn(2).setCellRenderer(centerRender);
        tabelaHospedes.getColumnModel().getColumn(3).setCellRenderer(centerRender);
        tabelaHospedes.getColumnModel().getColumn(4).setCellRenderer(centerRender);
        tabelaHospedes.getColumnModel().getColumn(5).setCellRenderer(centerRender);
        tabelaHospedes.getTableHeader().setFont(new Font("Hotel Oriental", 1, 18));                
        ((DefaultTableCellRenderer) tabelaHospedes.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(CENTER);
    }

    public void preencherTabelaReservas(){
        ReservaDao rd = new ReservaDao(new ConnectionFactory().getConnection());
        
        tableModelReservas = new TableModelReservas();
        tableModelReservas.preencherLista(rd.listarReservas());
        tabelaReservas.setModel(tableModelReservas);
        tabelaReservas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabelaReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
        centerRender.setHorizontalAlignment(JLabel.CENTER);
        tabelaReservas.getColumnModel().getColumn(0).setCellRenderer(centerRender);
        tabelaReservas.getColumnModel().getColumn(1).setCellRenderer(centerRender);
        tabelaReservas.getColumnModel().getColumn(2).setCellRenderer(centerRender);
        tabelaReservas.getColumnModel().getColumn(3).setCellRenderer(centerRender);
        tabelaReservas.getColumnModel().getColumn(4).setCellRenderer(centerRender);
        tabelaReservas.getColumnModel().getColumn(5).setCellRenderer(centerRender);
        tabelaReservas.getColumnModel().getColumn(6).setCellRenderer(centerRender);
        tabelaReservas.getColumnModel().getColumn(7).setCellRenderer(centerRender);
        tabelaReservas.getTableHeader().setFont(new Font("Hotel Oriental", 1, 18));                
        ((DefaultTableCellRenderer) tabelaReservas.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(CENTER);
        
    }
    
    public void preencherTabelaReservasSaida(){
        ReservaDao rd = new ReservaDao(new ConnectionFactory().getConnection());
        
        tableModelReservas3 = new TableModelReservas();
        tableModelReservas3.preencherLista(rd.listarReservas());
        tabelaReservasSaida.setModel(tableModelReservas3);
        tabelaReservasSaida.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabelaReservasSaida.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
        centerRender.setHorizontalAlignment(JLabel.CENTER);
        tabelaReservasSaida.getColumnModel().getColumn(0).setCellRenderer(centerRender);
        tabelaReservasSaida.getColumnModel().getColumn(1).setCellRenderer(centerRender);
        tabelaReservasSaida.getColumnModel().getColumn(2).setCellRenderer(centerRender);
        tabelaReservasSaida.getColumnModel().getColumn(3).setCellRenderer(centerRender);
        tabelaReservasSaida.getColumnModel().getColumn(4).setCellRenderer(centerRender);
        tabelaReservasSaida.getColumnModel().getColumn(5).setCellRenderer(centerRender);
        tabelaReservasSaida.getColumnModel().getColumn(6).setCellRenderer(centerRender);
        tabelaReservasSaida.getColumnModel().getColumn(7).setCellRenderer(centerRender);
        tabelaReservasSaida.getTableHeader().setFont(new Font("Hotel Oriental", 1, 18));                
        ((DefaultTableCellRenderer) tabelaReservasSaida.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(CENTER);
    }
    
    public void preencherTabelaReservasDoHospede(Hospede h){
        ReservaDao rd = new ReservaDao(new ConnectionFactory().getConnection());
        
        tableModelReservas2 = new TableModelReservas();
        if(h != null){
            tableModelReservas2.preencherLista(rd.listarReservasPorHospede(h.getHospedeId()));
        }
        tabelaBuscarReservaHospedes.setModel(tableModelReservas2);
        tabelaBuscarReservaHospedes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabelaBuscarReservaHospedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
        centerRender.setHorizontalAlignment(JLabel.CENTER);
        tabelaBuscarReservaHospedes.getColumnModel().getColumn(0).setCellRenderer(centerRender);
        tabelaBuscarReservaHospedes.getColumnModel().getColumn(1).setCellRenderer(centerRender);
        tabelaBuscarReservaHospedes.getColumnModel().getColumn(2).setCellRenderer(centerRender);
        tabelaBuscarReservaHospedes.getColumnModel().getColumn(3).setCellRenderer(centerRender);
        tabelaBuscarReservaHospedes.getColumnModel().getColumn(4).setCellRenderer(centerRender);
        tabelaBuscarReservaHospedes.getColumnModel().getColumn(5).setCellRenderer(centerRender);
        tabelaBuscarReservaHospedes.getColumnModel().getColumn(6).setCellRenderer(centerRender);
        tabelaBuscarReservaHospedes.getColumnModel().getColumn(7).setCellRenderer(centerRender);
        tabelaBuscarReservaHospedes.getTableHeader().setFont(new Font("Hotel Oriental", 1, 18));                
        ((DefaultTableCellRenderer) tabelaBuscarReservaHospedes.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(CENTER);
    }
    
    public void preencherTabelaAcompanhantes(Reserva r){
        AcompanhanteDao ad = new AcompanhanteDao(new ConnectionFactory().getConnection());
        
        TableModelAcompanhantes tma = new TableModelAcompanhantes();
        if(r!=null){
            tma.preencherLista(ad.listarAcompanhantesPorReserva(r.getReservaId()));
        }
        tabelaAcompanhantes.setModel(tma);
        tabelaAcompanhantes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabelaAcompanhantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
        centerRender.setHorizontalAlignment(JLabel.CENTER);
        tabelaAcompanhantes.getColumnModel().getColumn(0).setCellRenderer(centerRender);
        tabelaAcompanhantes.getColumnModel().getColumn(1).setCellRenderer(centerRender);
        tabelaAcompanhantes.getTableHeader().setFont(new Font("Hotel Oriental", 1, 18));                
        ((DefaultTableCellRenderer) tabelaAcompanhantes.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(CENTER);
    }
    
    public void preencherTabelaItensConsumo(){
        ItemConsumoDao dao = new ItemConsumoDao(new ConnectionFactory().getConnection());      
        tmic = new TableModelItensConsumo();
        tmic.preencherLista(dao.listarItensConsumo());
        tabelaAdicionarItemConsumo.setModel(tmic); 
        tabelaAdicionarItemConsumo.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
        centerRender.setHorizontalAlignment(JLabel.CENTER);
        tabelaAdicionarItemConsumo.getColumnModel().getColumn(0).setCellRenderer(centerRender);
        tabelaAdicionarItemConsumo.getColumnModel().getColumn(1).setCellRenderer(centerRender);
        tabelaAdicionarItemConsumo.getColumnModel().getColumn(2).setCellRenderer(centerRender);        
        tabelaAdicionarItemConsumo.getTableHeader().setFont(new Font("Hotel Oriental", 1, 18));                
        ((DefaultTableCellRenderer) tabelaAdicionarItemConsumo.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(CENTER);
        tabelaAdicionarItemConsumo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    public void preecherTabelaAcomodacoes(){
        AcomodacaoDao ad = new AcomodacaoDao(new ConnectionFactory().getConnection());
        modeloAcomodacao = new TableModelAcomodacoes();
        modeloAcomodacao.preencherLista(ad.listarAcomodacoes());
        tabelaSelecionarAcomodacaoConsumo.setModel(modeloAcomodacao);
        tabelaSelecionarAcomodacaoConsumo.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
        centerRender.setHorizontalAlignment(JLabel.CENTER);
        tabelaSelecionarAcomodacaoConsumo.getColumnModel().getColumn(0).setCellRenderer(centerRender);
        tabelaSelecionarAcomodacaoConsumo.getColumnModel().getColumn(1).setCellRenderer(centerRender);
        tabelaSelecionarAcomodacaoConsumo.getColumnModel().getColumn(2).setCellRenderer(centerRender);        
        tabelaSelecionarAcomodacaoConsumo.getTableHeader().setFont(new Font("Hotel Oriental", 1, 18));                
        ((DefaultTableCellRenderer) tabelaSelecionarAcomodacaoConsumo.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(CENTER);
        tabelaSelecionarAcomodacaoConsumo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    public void setAcomodacao(Acomodacao acomodacaoEscolhida){
        this.acomodacaoEscolhida = acomodacaoEscolhida;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaReservas = new javax.swing.JTable();
        btnExcluirReserva = new javax.swing.JButton();
        lbMsg1 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaBuscarReservaHospedes = new javax.swing.JTable();
        btnBuscarHospede = new javax.swing.JButton();
        tfNomeBuscarHospede = new javax.swing.JTextField();
        dataEntradaNoHotel = new com.toedter.calendar.JDateChooser();
        dataPrevistaSaidaDoHotel = new com.toedter.calendar.JDateChooser();
        btnRegistrarEntrada = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaAcompanhantes = new javax.swing.JTable();
        btnVisualizarAcompanhantes = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelaAdicionarItemConsumo = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabelaSelecionarAcomodacaoConsumo = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        tfQuantidadeConsumida = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        dataConsumo = new com.toedter.calendar.JDateChooser();
        btnAdicionarItemConsumo = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabelaReservasSaida = new javax.swing.JTable();
        btnSelecionarReservaSaida = new javax.swing.JButton();
        lbMsg4 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaHospedes = new javax.swing.JTable();
        btnAdicionarReserva = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable1);

        jTabbedPane1.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N

        tabelaReservas.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        tabelaReservas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabelaReservas);

        btnExcluirReserva.setFont(new java.awt.Font("Hotel Oriental", 0, 20)); // NOI18N
        btnExcluirReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/delete.png"))); // NOI18N
        btnExcluirReserva.setText("Excluir Reserva");
        btnExcluirReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirReservaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lbMsg1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(36, 36, 36)
                        .addComponent(btnExcluirReserva))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1076, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbMsg1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluirReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/city.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Visualizar Reservas", jPanel2);

        tabelaBuscarReservaHospedes.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        tabelaBuscarReservaHospedes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tabelaBuscarReservaHospedes);

        btnBuscarHospede.setFont(new java.awt.Font("Hotel Oriental", 0, 20)); // NOI18N
        btnBuscarHospede.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/search.png"))); // NOI18N
        btnBuscarHospede.setText("Buscar");
        btnBuscarHospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarHospedeActionPerformed(evt);
            }
        });

        tfNomeBuscarHospede.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N

        btnRegistrarEntrada.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        btnRegistrarEntrada.setText("Registrar Entrada");
        btnRegistrarEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEntradaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        jLabel9.setText("Data Prevista Saída");

        jLabel8.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        jLabel8.setText("Data Entrada");

        jLabel10.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        jLabel10.setText("Buscar Hospede");

        tabelaAcompanhantes.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        tabelaAcompanhantes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tabelaAcompanhantes);

        btnVisualizarAcompanhantes.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        btnVisualizarAcompanhantes.setText("Visualizar Acompanhantes");

        jLabel11.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Acompanhantes");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNomeBuscarHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscarHospede))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(dataEntradaNoHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataPrevistaSaidaDoHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                .addComponent(btnRegistrarEntrada)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btnVisualizarAcompanhantes))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tfNomeBuscarHospede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarHospede)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dataEntradaNoHotel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(dataPrevistaSaidaDoHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRegistrarEntrada)
                        .addComponent(btnVisualizarAcompanhantes))
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/city.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Gerenciar entradas no Hotel", jPanel3);

        tabelaAdicionarItemConsumo.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        tabelaAdicionarItemConsumo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(tabelaAdicionarItemConsumo);

        jLabel12.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        jLabel12.setText("Itens de Consumo");

        jLabel13.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        jLabel13.setText("Selecione um Quarto");

        tabelaSelecionarAcomodacaoConsumo.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        tabelaSelecionarAcomodacaoConsumo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(tabelaSelecionarAcomodacaoConsumo);

        jLabel14.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        jLabel14.setText("Quantidade Consumida desse Item");

        tfQuantidadeConsumida.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        jLabel15.setText("Data do Consumo:");

        dataConsumo.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N

        btnAdicionarItemConsumo.setFont(new java.awt.Font("Hotel Oriental", 0, 20)); // NOI18N
        btnAdicionarItemConsumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/add.png"))); // NOI18N
        btnAdicionarItemConsumo.setText("Adicionar Consumo ao Quarto");
        btnAdicionarItemConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarItemConsumoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(tfQuantidadeConsumida, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(dataConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdicionarItemConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane6)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdicionarItemConsumo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dataConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(tfQuantidadeConsumida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))))
                .addContainerGap())
        );

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/city.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel27)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Adicionar Consumo no Quarto", jPanel5);

        tabelaReservasSaida.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        tabelaReservasSaida.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(tabelaReservasSaida);

        btnSelecionarReservaSaida.setFont(new java.awt.Font("Hotel Oriental", 0, 20)); // NOI18N
        btnSelecionarReservaSaida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/add.png"))); // NOI18N
        btnSelecionarReservaSaida.setText("Adicionar Saída");
        btnSelecionarReservaSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarReservaSaidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(lbMsg4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSelecionarReservaSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane8))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSelecionarReservaSaida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbMsg4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/city.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel28)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Gerenciar Saídas no Hotel", jPanel4);

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

        btnAdicionarReserva.setFont(new java.awt.Font("Hotel Oriental", 0, 20)); // NOI18N
        btnAdicionarReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/add.png"))); // NOI18N
        btnAdicionarReserva.setText("Adicionar Reserva");
        btnAdicionarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarReservaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Hotel Oriental", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdicionarReserva)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAdicionarReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hotel/imagem/city.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel29)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cadastrar Reserva", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarReservaActionPerformed
        if(tabelaHospedes.getSelectedRow() >= 0){
            Hospede hospede = tableModelHospedes.retornarObjetoSelecionado(tabelaHospedes.getSelectedRow());

            TelaRegistrarReserva t2 = new TelaRegistrarReserva(hospede, this);
            t2.setAlwaysOnTop(true);
            t2.setVisible(true);
            t2.setLocationRelativeTo(null);
            
        }else{
            lbMsg4.setText("Nenhuma reserva selecionada!");
            lbMsg4.setForeground(Color.red);
        }
    }//GEN-LAST:event_btnAdicionarReservaActionPerformed

    private void btnRegistrarEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEntradaActionPerformed
         try{
             if(tabelaBuscarReservaHospedes.getSelectedRow() >= 0){
                Reserva r = tableModelReservas2.retornarObjetoSelecionado(tabelaBuscarReservaHospedes.getSelectedRow());
  
                Calendar dataEntrada = dataEntradaNoHotel.getCalendar();
                Calendar dataSaida2 = dataPrevistaSaidaDoHotel.getCalendar();
                dataEntrada.set(Calendar.HOUR_OF_DAY, 0);
                dataEntrada.set(Calendar.MINUTE, 0);
                dataEntrada.set(Calendar.MILLISECOND, 0);
                dataEntrada.set(Calendar.SECOND, 0);
                dataSaida2.set(Calendar.HOUR_OF_DAY, 0);
                dataSaida2.set(Calendar.MINUTE, 0);
                dataSaida2.set(Calendar.MILLISECOND, 0);
                dataSaida2.set(Calendar.SECOND, 0);
                Date inicioReserva = r.getDataChegada().getTime();
                Date fimReserva = r.getDataSaida().getTime();
                Date entrada = dataEntrada.getTime();
                Date saida = dataSaida2.getTime();
                 System.out.println("entrada: "+ entrada + " inicio: " + inicioReserva + " saida: " + saida + " fim: " + fimReserva);
                if(!(entrada.before(inicioReserva) || saida.before(inicioReserva) || entrada.after(fimReserva) || saida.after(fimReserva))){
                     int reservaId = r.getReservaId();
                     EntradaDao ed = new EntradaDao(new ConnectionFactory().getConnection());
                     Entrada e = new Entrada();
                     e.setReservaId(reservaId);
                     GregorianCalendar gc1 = new GregorianCalendar();
                     GregorianCalendar gc2 = new GregorianCalendar();
                     gc1.setTimeInMillis(dataEntrada.getTimeInMillis());
                     gc2.setTimeInMillis(dataSaida2.getTimeInMillis());
                     e.setDataChegada(gc1);
                     e.setDataSaida(gc2);
                     ed.inserirEntrada(e);
                     JOptionPane.showMessageDialog(null, "Entrada de hóspede adicionada.");
                }else{
                    JOptionPane.showMessageDialog(null, "Entrada não pode ser registrada neste período.");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Nenhuma reserva selecionada!");
            }
             
         }catch(Exception erro){
             JOptionPane.showMessageDialog(null, "Não foi possível registrar entrada no Hotel.");
         }
    }//GEN-LAST:event_btnRegistrarEntradaActionPerformed

    private void btnBuscarHospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarHospedeActionPerformed
        try{
            String nome = tfNomeBuscarHospede.getText();
            HospedeDao hd = new HospedeDao(new ConnectionFactory().getConnection());
            ArrayList<Hospede> hospedes = hd.listarHospedes();
            Hospede h = null;
            for(Hospede h1 : hospedes){
                if(h1.getNome().equals(nome)){
                    h = h1;
                }
            }
            if(h==null){
                JOptionPane.showMessageDialog(null, "Nenhum hóspede encontrado com este nome.");
            }
            this.preencherTabelaReservasDoHospede(h);
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o hóspede!");
        }
    }//GEN-LAST:event_btnBuscarHospedeActionPerformed

    private void btnAdicionarItemConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarItemConsumoActionPerformed
        try{
            if(tabelaAdicionarItemConsumo.getSelectedRow() >= 0){
                if(tabelaSelecionarAcomodacaoConsumo.getSelectedRow()>=0){
                    ItemConsumo ic = tmic.retornarObjetoSelecionado(tabelaAdicionarItemConsumo.getSelectedRow());
                    Acomodacao a =modeloAcomodacao.retornarObjetoSelecionado(tabelaSelecionarAcomodacaoConsumo.getSelectedRow());
                    Calendar data = this.dataConsumo.getCalendar();
                    int quantidadeConsumida = Integer.valueOf(tfQuantidadeConsumida.getText());
                    Consumo c = new Consumo();
                    c.setItemId(ic.getItemId());
                    c.setDataConsumo(data.getTime());
                    c.setNumAcomodacao(a.getNumAcomodacao());
                    c.setQtdeConsumida(quantidadeConsumida);
                    ConsumoDao cd = new ConsumoDao(new ConnectionFactory().getConnection());
                    cd.inserirConsumo(c);
                    JTextArea area = new JTextArea();
                    area.setEditable(false);
                    area.append("Item: " + ic.getDescricao() + "\n");
                    area.append("Valor: " + ic.getValor() + "\n");
                    area.append("Quantidade: " + c.getQtdeConsumida() + "\n");
                    area.append("Num Quarto: " + a.getNumAcomodacao() + "\n");
                    area.append("Data: " + new SimpleDateFormat("dd/MM/yyyy").format(data.getTime()) + "\n");
                    JOptionPane.showMessageDialog(null, area,"Consumo Adicionado: ",JOptionPane.INFORMATION_MESSAGE);
                    this.preecherTabelaAcomodacoes();
                    this.preencherTabelaItensConsumo();
                }else{
                    JOptionPane.showMessageDialog(null, "Selecione um Quarto!");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Selecione um Item de Consumo!");
            }
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Não foi possível adicionar consumo!");
        }
    }//GEN-LAST:event_btnAdicionarItemConsumoActionPerformed

    private void btnExcluirReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirReservaActionPerformed
        if(tabelaReservas.getSelectedRow() >= 0){
            Reserva r = tableModelReservas.retornarObjetoSelecionado(tabelaReservas.getSelectedRow());
            ReservaDao rd = new ReservaDao(new ConnectionFactory().getConnection());
            
            JLabel msg = new JLabel();
            msg.setFont(new Font("Hotel Oriental", 1, 18));
            msg.setForeground(Color.RED);
            msg.setText("Voce tem certeza disso?");
            
            int res = JOptionPane.showConfirmDialog(this, msg, "ATENÇÃO",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon());

            if(res == 0){
                rd.excluirReserva(r.getReservaId());
                lbMsg1.setText("Reserva Excluida!");
                lbMsg1.setForeground(Color.red);
                preencherTabelaReservas();
            }
            
        }else{            
            lbMsg1.setText("Nenhuma reserva selecionada!");
            lbMsg1.setForeground(Color.red);
        }
    }//GEN-LAST:event_btnExcluirReservaActionPerformed

    private void btnSelecionarReservaSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarReservaSaidaActionPerformed
        if(tabelaReservasSaida.getSelectedRow() >= 0){
            Reserva r = tableModelReservas.retornarObjetoSelecionado(tabelaReservasSaida.getSelectedRow());
            
            TelaRegistrarSaida t1 = new TelaRegistrarSaida(r, this);
            t1.setAlwaysOnTop(true);
            t1.setVisible(true);
            t1.setLocationRelativeTo(null);
            
        }else{
            lbMsg4.setText("Nenhuma reserva selecionada!");
            lbMsg4.setForeground(Color.red);
        }
    }//GEN-LAST:event_btnSelecionarReservaSaidaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarItemConsumo;
    private javax.swing.JButton btnAdicionarReserva;
    private javax.swing.JButton btnBuscarHospede;
    private javax.swing.JButton btnExcluirReserva;
    private javax.swing.JButton btnRegistrarEntrada;
    private javax.swing.JButton btnSelecionarReservaSaida;
    private javax.swing.JButton btnVisualizarAcompanhantes;
    private com.toedter.calendar.JDateChooser dataConsumo;
    private com.toedter.calendar.JDateChooser dataEntradaNoHotel;
    private com.toedter.calendar.JDateChooser dataPrevistaSaidaDoHotel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbMsg1;
    private javax.swing.JLabel lbMsg4;
    private javax.swing.JTable tabelaAcompanhantes;
    private javax.swing.JTable tabelaAdicionarItemConsumo;
    private javax.swing.JTable tabelaBuscarReservaHospedes;
    private javax.swing.JTable tabelaHospedes;
    private javax.swing.JTable tabelaReservas;
    private javax.swing.JTable tabelaReservasSaida;
    private javax.swing.JTable tabelaSelecionarAcomodacaoConsumo;
    private javax.swing.JTextField tfNomeBuscarHospede;
    private javax.swing.JTextField tfQuantidadeConsumida;
    // End of variables declaration//GEN-END:variables
}
