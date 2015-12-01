/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.painel;

import br.com.hotel.apresentacao.TelaAdicionarAcompanhante;
import br.com.hotel.apresentacao.TelaAdicionarCartao;
import br.com.hotel.apresentacao.TelaSelecionarAcomodacao;
import br.com.hotel.dao.AcomodacaoDao;
import br.com.hotel.dao.AcompanhanteDao;
import br.com.hotel.dao.CartaoDao;
import br.com.hotel.dao.ConnectionFactory;
import br.com.hotel.dao.ConsumoDao;
import br.com.hotel.dao.EntradaDao;
import br.com.hotel.dao.HospedeDao;
import br.com.hotel.dao.ItemConsumoDao;
import br.com.hotel.dao.ReservaDao;
import br.com.hotel.dao.SaidaDao;
import br.com.hotel.dao.TipoAcomodacaoDao;
import br.com.hotel.dao.TipoPagamentoDao;
import br.com.hotel.modelo.Acomodacao;
import br.com.hotel.modelo.Acompanhante;
import br.com.hotel.modelo.Cartao;
import br.com.hotel.modelo.Consumo;
import br.com.hotel.modelo.Entrada;
import br.com.hotel.modelo.Hospede;
import br.com.hotel.modelo.ItemConsumo;
import br.com.hotel.modelo.Reserva;
import br.com.hotel.modelo.Saida;
import br.com.hotel.modelo.TipoAcomodacao;
import br.com.hotel.modelo.TipoPagamento;
import br.com.hotel.tabela.TableModelAcomodacoes;
import br.com.hotel.tabela.TableModelAcompanhantes;
import br.com.hotel.tabela.TableModelHospedes;
import br.com.hotel.tabela.TableModelItensConsumo;
import br.com.hotel.tabela.TableModelReservas;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
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
    public int na;
    public int nc;
    public PainelCadastroReservas() {
        initComponents();
        this.acompanhantes = new ArrayList<>();
        this.c = new Cartao();
        this.na = 1;
        this.nc = 0;
        this.preencherTabelaHospedes();
        this.preencherTabelaReservas();
        this.preencherTabelaReservasDoHospede(null);
        this.preencherTabelaAcompanhantes(null);
        this.preencherTabelaItensConsumo();
        this.preecherTabelaAcomodacoes();
        this.preencherTabelaReservasSaida();
        this.preencherComboTipoPagamento();
    }
    
    public void preencherComboTipoPagamento(){
        TipoPagamentoDao tpd = new TipoPagamentoDao(new ConnectionFactory().getConnection());
        cbTipoPagamentos.removeAllItems();
        for(TipoPagamento tp : tpd.listarTiposPagamento()){
            cbTipoPagamentos.addItem(tp.getTipo());
        }
    }
    
    
    public void preencherTabelaHospedes(){
        HospedeDao hd = new HospedeDao(new ConnectionFactory().getConnection());
        tableModelHospedes = new TableModelHospedes();
        tableModelHospedes.preencherLista(hd.listarHospedes());
        tabelaHospedes.setModel(tableModelHospedes);
        tabelaHospedes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabelaHospedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaHospedes.getColumnModel().getColumn(0).setPreferredWidth(30);
        tabelaHospedes.getColumnModel().getColumn(1).setPreferredWidth(50);
        tabelaHospedes.getColumnModel().getColumn(3).setPreferredWidth(20);
    }

    public void preencherTabelaReservas(){
        ReservaDao rd = new ReservaDao(new ConnectionFactory().getConnection());
        
        tableModelReservas = new TableModelReservas();
        tableModelReservas.preencherLista(rd.listarReservas());
        tabelaReservas.setModel(tableModelReservas);
        tabelaReservas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabelaReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    public void preencherTabelaReservasSaida(){
        ReservaDao rd = new ReservaDao(new ConnectionFactory().getConnection());
        
        tableModelReservas3 = new TableModelReservas();
        tableModelReservas3.preencherLista(rd.listarReservas());
        tabelaReservasSaida.setModel(tableModelReservas3);
        tabelaReservasSaida.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabelaReservasSaida.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
    }
    
    public void preencherTabelaItensConsumo(){
        ItemConsumoDao dao = new ItemConsumoDao(new ConnectionFactory().getConnection());      
        tmic = new TableModelItensConsumo();
        tmic.preencherLista(dao.listarItensConsumo());
        tabelaAdicionarItemConsumo.setModel(tmic); 
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
        tabelaSelecionarAcomodacaoConsumo.getTableHeader().setFont(new Font("Hotel Oriental", 1, 18));
        ((DefaultTableCellRenderer) tabelaSelecionarAcomodacaoConsumo.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(CENTER);        
        tabelaSelecionarAcomodacaoConsumo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    public void setAcomodacao(Acomodacao acomodacaoEscolhida){
        this.acomodacaoEscolhida = acomodacaoEscolhida;
    }
    
    public void setValorDiaria(double valor){
        tfValorDiaria.setText(String.valueOf(valor));
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
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfValorDiaria = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfMulta = new javax.swing.JTextField();
        btnAdicionarAcompanhante = new javax.swing.JButton();
        btnAdicionarDadosCartao = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaHospedes = new javax.swing.JTable();
        btnEscolherAcomodacao = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tfDesconto = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        dataChegada = new com.toedter.calendar.JDateChooser();
        dataSaida = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaReservas = new javax.swing.JTable();
        btnExcluirReserva = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        dataEntradaNoHotel = new com.toedter.calendar.JDateChooser();
        dataPrevistaSaidaDoHotel = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaBuscarReservaHospedes = new javax.swing.JTable();
        tfNomeBuscarHospede = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaAcompanhantes = new javax.swing.JTable();
        btnRegistrarEntrada = new javax.swing.JButton();
        btnBuscarHospede = new javax.swing.JButton();
        btnVisualizarAcompanhantes = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelaAdicionarItemConsumo = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabelaSelecionarAcomodacaoConsumo = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        tfQuantidadeConsumida = new javax.swing.JTextField();
        btnAdicionarItemConsumo = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        dataConsumo = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tfNumeroDoQuartoSaida = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        dataSaidaTelaSaidas = new com.toedter.calendar.JDateChooser();
        btnCalcularDiarias = new javax.swing.JButton();
        tfValorDiariasSaida = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        tfValorDiariaIndividualSaida = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        tfDescontoTelaSaida = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabelaReservasSaida = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        tfValorItensConsumidos = new javax.swing.JTextField();
        btnSelecionarReservaSaida = new javax.swing.JButton();
        btnRegistrarSaida = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        tfValorMultaSaida = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        lblDias = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        cbTipoPagamentos = new javax.swing.JComboBox<>();

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

        jButton1.setText("Selecionar Hóspede Para Reserva");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Data Chegada: ");

        jLabel2.setText("Data Saída:");

        jLabel3.setText("Selecionar Acomodação:");

        jLabel4.setText("Valor da Diária:");

        tfValorDiaria.setEditable(false);

        jLabel5.setText("Taxa de Multa:");

        btnAdicionarAcompanhante.setText("Adicionar Acompanhante");
        btnAdicionarAcompanhante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarAcompanhanteActionPerformed(evt);
            }
        });

        btnAdicionarDadosCartao.setText("Adicionar Dados Cartão de Crédito");
        btnAdicionarDadosCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarDadosCartaoActionPerformed(evt);
            }
        });

        jLabel6.setText("Nome:");

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

        btnEscolherAcomodacao.setText("Escolher");
        btnEscolherAcomodacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscolherAcomodacaoActionPerformed(evt);
            }
        });

        jLabel7.setText("Desconto: ");

        jButton2.setText("Realizar Reserva");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAdicionarDadosCartao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                            .addComponent(btnAdicionarAcompanhante, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfMulta, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfValorDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnEscolherAcomodacao, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                    .addGap(30, 30, 30)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dataChegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addComponent(jButton2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jLabel6)
                            .addComponent(lbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(dataChegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(dataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(btnEscolherAcomodacao))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfValorDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfMulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAdicionarAcompanhante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAdicionarDadosCartao)
                        .addGap(23, 23, 23)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(268, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cadastrar Reserva", jPanel1);

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

        btnExcluirReserva.setText("Excluir Reserva");
        btnExcluirReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirReservaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluirReserva, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExcluirReserva)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(257, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Visualizar Reservas", jPanel2);

        jLabel8.setText("Data Entrada:");

        jLabel9.setText("Data Prevista Saída:");

        jLabel10.setText("Buscar Hospede:");

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

        jLabel11.setText("Acompanhantes:");

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

        btnRegistrarEntrada.setText("Registrar Entrada");
        btnRegistrarEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEntradaActionPerformed(evt);
            }
        });

        btnBuscarHospede.setText("Buscar");
        btnBuscarHospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarHospedeActionPerformed(evt);
            }
        });

        btnVisualizarAcompanhantes.setText("Visualizar Acompanhantes");
        btnVisualizarAcompanhantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarAcompanhantesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(825, 825, 825)
                        .addComponent(btnVisualizarAcompanhantes)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataPrevistaSaidaDoHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRegistrarEntrada))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNomeBuscarHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(50, 50, 50)
                                .addComponent(dataEntradaNoHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVisualizarAcompanhantes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tfNomeBuscarHospede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarHospede))
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataEntradaNoHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9)
                                .addComponent(dataPrevistaSaidaDoHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnRegistrarEntrada))))
                .addGap(203, 423, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Gerenciar entradas no Hotel", jPanel3);

        jLabel12.setText("Itens de Consumo");

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

        jLabel13.setText("Selecione o Quarto:");

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

        jLabel14.setText("Digite a quantidade Consumida desse Item:");

        btnAdicionarItemConsumo.setText("Adicionar Item de Consumo ao Quarto");
        btnAdicionarItemConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarItemConsumoActionPerformed(evt);
            }
        });

        jLabel15.setText("Selecione a Data do Consumo:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(tfQuantidadeConsumida, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarItemConsumo)
                    .addComponent(jLabel15)
                    .addComponent(dataConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(tfQuantidadeConsumida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnAdicionarItemConsumo)))
                .addContainerGap(222, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Adicionar Consumo no Quarto", jPanel5);

        jLabel16.setText("Registrar a Saída do Hóspede");

        jLabel17.setText("Número do Quarto do Hóspede:");

        tfNumeroDoQuartoSaida.setEditable(false);
        tfNumeroDoQuartoSaida.setEnabled(false);

        jLabel18.setText("Data saída:");

        btnCalcularDiarias.setText("Calcular Diárias");
        btnCalcularDiarias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularDiariasActionPerformed(evt);
            }
        });

        tfValorDiariasSaida.setEditable(false);
        tfValorDiariasSaida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfValorDiariasSaida.setEnabled(false);

        jLabel19.setText("Valor da diária:");

        tfValorDiariaIndividualSaida.setEditable(false);
        tfValorDiariaIndividualSaida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfValorDiariaIndividualSaida.setEnabled(false);

        jLabel20.setText("Desconto:");

        tfDescontoTelaSaida.setEditable(false);
        tfDescontoTelaSaida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfDescontoTelaSaida.setEnabled(false);

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

        jLabel21.setText("Valor dos Itens Consumidos:");

        tfValorItensConsumidos.setEditable(false);
        tfValorItensConsumidos.setEnabled(false);

        btnSelecionarReservaSaida.setText("Selecionar Reserva");
        btnSelecionarReservaSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarReservaSaidaActionPerformed(evt);
            }
        });

        btnRegistrarSaida.setText("Registrar Saída do Hotel");
        btnRegistrarSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarSaidaActionPerformed(evt);
            }
        });

        jLabel22.setText("Multa por Sair antes do Término da Reserva:");

        tfValorMultaSaida.setEditable(false);
        tfValorMultaSaida.setEnabled(false);

        jLabel23.setText("DIAS NO HOTEL: ");

        lblDias.setText("________");

        jLabel24.setText("Selecionar Tipo de Pagamento:");

        cbTipoPagamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRegistrarSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnSelecionarReservaSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17)
                                    .addComponent(tfNumeroDoQuartoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel20)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tfDescontoTelaSaida))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel19)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tfValorDiariaIndividualSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dataSaidaTelaSaidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel18))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel23)
                                            .addComponent(btnCalcularDiarias, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfValorDiariasSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDias)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfValorItensConsumidos, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfValorMultaSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbTipoPagamentos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNumeroDoQuartoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel23)
                            .addComponent(lblDias))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataSaidaTelaSaidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnCalcularDiarias)
                                .addComponent(tfValorDiariasSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(tfValorDiariaIndividualSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(tfDescontoTelaSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(tfValorMultaSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(tfValorItensConsumidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(cbTipoPagamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSelecionarReservaSaida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistrarSaida)
                .addContainerGap(192, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Gerenciar Saídas no Hotel", jPanel4);

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            if(h!=null && acomodacaoEscolhida!= null && c!= null){
                Calendar chegada = dataChegada.getCalendar();
                Calendar saida = dataSaida.getCalendar();
                //System.out.println(chegada.getTime() + "    "+ saida.getTime());
                double diaria = Double.valueOf(tfValorDiaria.getText());
                double multa = Double.valueOf(tfMulta.getText());
                double desconto = Double.valueOf(tfDesconto.getText());
                
                CartaoDao cd = new CartaoDao(new ConnectionFactory().getConnection());
                cd.inserirCartao(c);
                cd = new CartaoDao(new ConnectionFactory().getConnection());
                Cartao c2 = cd.buscarCartoesPorNumero(c.getNumeroCartao());
                Reserva r = new Reserva();
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTimeInMillis(chegada.getTimeInMillis());
                r.setDataChegada(gc);
                GregorianCalendar gc2 = new GregorianCalendar();
                gc2.setTimeInMillis(saida.getTimeInMillis());
                r.setDataSaida(gc2);
                r.setHospedeId(h.getHospedeId());
                r.setCartaoId(c2.getCartaoId());
                r.setDesconto(desconto);
                r.setTaxaMulta(multa);
                r.setValorDiaria(diaria);
                r.setAcomodacaoId(acomodacaoEscolhida.getAcomodacaoId());
                ReservaDao rd = new ReservaDao(new ConnectionFactory().getConnection());
                rd.inserirReserva(r);
                rd = new ReservaDao(new ConnectionFactory().getConnection());
                r = rd.buscarReservaPorHospede(h.getHospedeId());
                for(Acompanhante a : acompanhantes){
                    AcompanhanteDao ad = new AcompanhanteDao(new ConnectionFactory().getConnection());
                    a.setReservaId(r.getReservaId());
                    ad.inserirAcompanhante(a);
                }
                acomodacaoEscolhida.setReservado(true);
                AcomodacaoDao ad = new AcomodacaoDao(new ConnectionFactory().getConnection());
                ad.atualizarAcomodacao(acomodacaoEscolhida);
                JOptionPane.showMessageDialog(null, "Reserva Concluída!");
                this.h = null;
                this.acomodacaoEscolhida = null;
                this.c = new Cartao();
                this.na = 1;
                this.nc = 0;
                lbNome.setText("");
                this.preencherTabelaReservas();
                
            }else{
                JOptionPane.showMessageDialog(null, "Dados incompletos.");
            }
            
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Erro ao realizar reserva. Dados incompletos! \n Tente novamente.\n");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnEscolherAcomodacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscolherAcomodacaoActionPerformed
       try{
           if(dataChegada.getDate()!= null && dataSaida.getDate()!= null){
                TelaSelecionarAcomodacao tsa = new TelaSelecionarAcomodacao(this, dataChegada.getDate(), dataSaida.getDate());
                tsa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           }else{
               JOptionPane.showMessageDialog(null, "Data de chegada e saída devem ser escolhidas!");
           }
       }catch(Exception erro){
           JOptionPane.showMessageDialog(null, "Data de chegada e saída devem ser escolhidas!");
       }
    }//GEN-LAST:event_btnEscolherAcomodacaoActionPerformed

    private void btnAdicionarDadosCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarDadosCartaoActionPerformed
        if(this.h != null){
            TelaAdicionarCartao tac = new TelaAdicionarCartao(this.h, this.c);

        }else{
            JOptionPane.showMessageDialog(null, "Nenhum hóspede foi selecionado!");
        }
    }//GEN-LAST:event_btnAdicionarDadosCartaoActionPerformed

    private void btnAdicionarAcompanhanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarAcompanhanteActionPerformed
        if(acomodacaoEscolhida!= null){
            TipoAcomodacaoDao tad = new TipoAcomodacaoDao(new ConnectionFactory().getConnection());
            TipoAcomodacao tipo = tad.buscarTipoAcomodacao(acomodacaoEscolhida.getTipoAcomodacaoId());
            TelaAdicionarAcompanhante taa = new TelaAdicionarAcompanhante(acompanhantes, tipo, this);
        }else{
            JOptionPane.showMessageDialog(null, "Deve ser escolhida uma acomodação.");
        }
    }//GEN-LAST:event_btnAdicionarAcompanhanteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(tabelaHospedes.getSelectedRow() >= 0){
            Hospede hospede = tableModelHospedes.retornarObjetoSelecionado(tabelaHospedes.getSelectedRow());

            this.h = hospede;
            JOptionPane.showMessageDialog(null, "Hóspede Selecionado \n" + hospede);
            lbNome.setText(h.getNome());

        }else{
            JOptionPane.showMessageDialog(null, "Nenhum hóspede selecionado!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void btnVisualizarAcompanhantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarAcompanhantesActionPerformed
    if(tabelaBuscarReservaHospedes.getSelectedRow() >= 0){
            Reserva r = tableModelReservas2.retornarObjetoSelecionado(tabelaBuscarReservaHospedes.getSelectedRow());

            preencherTabelaAcompanhantes(r);
        }else{
            JOptionPane.showMessageDialog(null, "Nenhuma reserva selecionada!");
        }
    }//GEN-LAST:event_btnVisualizarAcompanhantesActionPerformed

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
            int res = JOptionPane.showConfirmDialog(this, "Voce tem certeza disso?");

            if(res == 0){
                rd.excluirReserva(r.getReservaId());
                JOptionPane.showMessageDialog(null, "Reserva excluida.");
                preencherTabelaReservas();
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Nenhuma reserva selecionada!");
        }
    }//GEN-LAST:event_btnExcluirReservaActionPerformed

    private void btnSelecionarReservaSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarReservaSaidaActionPerformed
        if(tabelaReservasSaida.getSelectedRow() >= 0){
            Reserva r = tableModelReservas.retornarObjetoSelecionado(tabelaReservasSaida.getSelectedRow());
            AcomodacaoDao ad = new AcomodacaoDao(new ConnectionFactory().getConnection());
            Acomodacao a = ad.buscarAcomodacao(r.getAcomodacaoId());
            ConsumoDao cd = new ConsumoDao(new ConnectionFactory().getConnection());
            ArrayList<Consumo> consumosDoQuarto = cd.listarConsumoPorAcomodacao(a.getNumAcomodacao());
            Date inicioEstadia = r.getDataChegada().getTime();
            Date fimEstadia = r.getDataSaida().getTime();
            ArrayList<Consumo> consumosHospede = new ArrayList<>();
            for(Consumo c : consumosDoQuarto){
                Date dataConsumo = c.getDataConsumo();
                if((dataConsumo.equals(inicioEstadia) || dataConsumo.equals(fimEstadia)) || (dataConsumo.after(inicioEstadia) && dataConsumo.before(fimEstadia))  ){
                    consumosHospede.add(c);
                }
            }
            double valorTotalItens = 0;
            
            for(Consumo c: consumosHospede){
                ItemConsumoDao icd = new ItemConsumoDao(new ConnectionFactory().getConnection());
                ItemConsumo ic = icd.buscarItemConsumo(c.getItemId());
                valorTotalItens += (ic.getValor() * c.getQtdeConsumida());
            }
            
            tfNumeroDoQuartoSaida.setText(String.valueOf(a.getNumAcomodacao()));
            tfValorItensConsumidos.setText(String.valueOf(valorTotalItens));
            tfValorDiariaIndividualSaida.setText(String.valueOf(r.getValorDiaria()));
            tfDescontoTelaSaida.setText(String.valueOf(r.getDesconto()));
            
        }else{
            JOptionPane.showMessageDialog(null, "Nenhuma reserva selecionada!");
        }
    }//GEN-LAST:event_btnSelecionarReservaSaidaActionPerformed

    private void btnCalcularDiariasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularDiariasActionPerformed
        if(tabelaReservasSaida.getSelectedRow() >= 0){
            Reserva r = tableModelReservas.retornarObjetoSelecionado(tabelaReservasSaida.getSelectedRow());
            Date inicioEstadia = r.getDataChegada().getTime();
            Date fimEstadia = r.getDataSaida().getTime();

            Calendar dataEscolhidaSaida = dataSaidaTelaSaidas.getCalendar();
            dataEscolhidaSaida.set(Calendar.HOUR_OF_DAY, 0);
            dataEscolhidaSaida.set(Calendar.MINUTE, 0);
            dataEscolhidaSaida.set(Calendar.MILLISECOND, 0);
            dataEscolhidaSaida.set(Calendar.SECOND, 0);
            Date dataSaida2 = dataEscolhidaSaida.getTime();
            if(!(dataSaida2.before(inicioEstadia)||dataSaida2.after(fimEstadia))){
                long dias = (dataSaida2.getTime() - inicioEstadia.getTime()) / 86400000L;
                lblDias.setText(String.valueOf(dias));
                tfValorDiariasSaida.setText(String.valueOf(dias * r.getValorDiaria()));
                if(dataSaida2.before(fimEstadia)){
                    tfValorMultaSaida.setText(String.valueOf(r.getTaxaMulta()));
                }else{
                    tfValorMultaSaida.setText("Sem multa.");
                } 
            }else{
                JOptionPane.showMessageDialog(null, "Data de Saída está fora do período da reserva.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Nenhuma reserva selecionada!");
        }
    }//GEN-LAST:event_btnCalcularDiariasActionPerformed

    private void btnRegistrarSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarSaidaActionPerformed
        if(tabelaReservasSaida.getSelectedRow() >= 0){
            Reserva r = tableModelReservas.retornarObjetoSelecionado(tabelaReservasSaida.getSelectedRow());
            AcomodacaoDao ad = new AcomodacaoDao(new ConnectionFactory().getConnection());
            Acomodacao a = ad.buscarAcomodacao(r.getAcomodacaoId());
            ConsumoDao cd = new ConsumoDao(new ConnectionFactory().getConnection());
            ArrayList<Consumo> consumosDoQuarto = cd.listarConsumoPorAcomodacao(a.getNumAcomodacao());
            Date inicioEstadia = r.getDataChegada().getTime();
            Date fimEstadia = r.getDataSaida().getTime();
            ArrayList<Consumo> consumosHospede = new ArrayList<>();
            for(Consumo c : consumosDoQuarto){
                Date dataConsumo = c.getDataConsumo();
                if((dataConsumo.equals(inicioEstadia) || dataConsumo.equals(fimEstadia)) || (dataConsumo.after(inicioEstadia) && dataConsumo.before(fimEstadia))  ){
                    consumosHospede.add(c);
                }
            }
            double valorTotalItens = 0;
            
            for(Consumo c: consumosHospede){
                ItemConsumoDao icd = new ItemConsumoDao(new ConnectionFactory().getConnection());
                ItemConsumo ic = icd.buscarItemConsumo(c.getItemId());
                valorTotalItens += (ic.getValor() * c.getQtdeConsumida());
            }
            
            tfNumeroDoQuartoSaida.setText(String.valueOf(a.getNumAcomodacao()));
            tfValorItensConsumidos.setText(String.valueOf(valorTotalItens));
            tfValorDiariaIndividualSaida.setText(String.valueOf(r.getValorDiaria()));
            tfDescontoTelaSaida.setText(String.valueOf(r.getDesconto()));
            Calendar dataEscolhidaSaida = dataSaidaTelaSaidas.getCalendar();
            dataEscolhidaSaida.set(Calendar.HOUR_OF_DAY, 0);
            dataEscolhidaSaida.set(Calendar.MINUTE, 0);
            dataEscolhidaSaida.set(Calendar.MILLISECOND, 0);
            dataEscolhidaSaida.set(Calendar.SECOND, 0);
            Date dataSaida2 = dataEscolhidaSaida.getTime();
            long dias = (dataSaida2.getTime() - inicioEstadia.getTime()) / 86400000L;
            SaidaDao sd = new SaidaDao(new ConnectionFactory().getConnection());
            Saida s = new Saida();
            s.setReservaId(r.getReservaId());
            s.setValorServicos(valorTotalItens);
            s.setNumAcomodacao(a.getNumAcomodacao());
            s.setNumDiarias((int)dias);
            s.setDesconto(r.getDesconto());
            s.setEstadiaPaga(true);
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(dataSaida2);
            s.setDataSaida(gc);
            TipoPagamentoDao tpd = new TipoPagamentoDao(new ConnectionFactory().getConnection());
            TipoPagamento tp = tpd.buscarTipoPagamentoPorNome((String)cbTipoPagamentos.getSelectedItem());
            s.setTipoPagamentoId(tp.getTipoPagamentoId());
            sd.inserirSaida(s);
            
            ReservaDao rd = new ReservaDao(new ConnectionFactory().getConnection());
            rd.excluirReserva(r.getReservaId());
            JOptionPane.showMessageDialog(null, "Saída do Hotel Concluida");
            preencherTabelaReservasSaida();
            
            
        }else{
            JOptionPane.showMessageDialog(null, "Nenhuma reserva selecionada!");
        }
    }//GEN-LAST:event_btnRegistrarSaidaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarAcompanhante;
    private javax.swing.JButton btnAdicionarDadosCartao;
    private javax.swing.JButton btnAdicionarItemConsumo;
    private javax.swing.JButton btnBuscarHospede;
    private javax.swing.JButton btnCalcularDiarias;
    private javax.swing.JButton btnEscolherAcomodacao;
    private javax.swing.JButton btnExcluirReserva;
    private javax.swing.JButton btnRegistrarEntrada;
    private javax.swing.JButton btnRegistrarSaida;
    private javax.swing.JButton btnSelecionarReservaSaida;
    private javax.swing.JButton btnVisualizarAcompanhantes;
    private javax.swing.JComboBox<String> cbTipoPagamentos;
    private com.toedter.calendar.JDateChooser dataChegada;
    private com.toedter.calendar.JDateChooser dataConsumo;
    private com.toedter.calendar.JDateChooser dataEntradaNoHotel;
    private com.toedter.calendar.JDateChooser dataPrevistaSaidaDoHotel;
    private com.toedter.calendar.JDateChooser dataSaida;
    private com.toedter.calendar.JDateChooser dataSaidaTelaSaidas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
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
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lblDias;
    private javax.swing.JTable tabelaAcompanhantes;
    private javax.swing.JTable tabelaAdicionarItemConsumo;
    private javax.swing.JTable tabelaBuscarReservaHospedes;
    private javax.swing.JTable tabelaHospedes;
    private javax.swing.JTable tabelaReservas;
    private javax.swing.JTable tabelaReservasSaida;
    private javax.swing.JTable tabelaSelecionarAcomodacaoConsumo;
    private javax.swing.JTextField tfDesconto;
    private javax.swing.JTextField tfDescontoTelaSaida;
    private javax.swing.JTextField tfMulta;
    private javax.swing.JTextField tfNomeBuscarHospede;
    private javax.swing.JTextField tfNumeroDoQuartoSaida;
    private javax.swing.JTextField tfQuantidadeConsumida;
    private javax.swing.JTextField tfValorDiaria;
    private javax.swing.JTextField tfValorDiariaIndividualSaida;
    private javax.swing.JTextField tfValorDiariasSaida;
    private javax.swing.JTextField tfValorItensConsumidos;
    private javax.swing.JTextField tfValorMultaSaida;
    // End of variables declaration//GEN-END:variables
}
