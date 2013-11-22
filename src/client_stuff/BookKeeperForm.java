package client_stuff;

import Client.Client;
import entities.Bank;
import entities.Currency;
import entities.ExchangeRate;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import models.BankTableModel;
import models.CurrencyTableModel;
import models.ExRateTableModel;

public class BookKeeperForm extends javax.swing.JFrame {
    Client client = null;
    int selected = -1;
    ListSelectionListener selectListen;
    ArrayList<Currency> currency = null;
    ArrayList<ExchangeRate> exRate = null;
    ArrayList<Bank> bank = null;
    
    public BookKeeperForm() {
        initComponents();
    }

    public BookKeeperForm(Client client){
        super();
        initComponents();
        this.client = client;
    }
    
    public void currRefresh() throws RemoteException{
        currency = client.refreshCurrency();
        jTable1.setModel(new CurrencyTableModel(currency));
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
    }
    
    public void exRateRefresh() throws RemoteException{
        exRate = client.exRateRefresh();
        jTable1.setModel(new ExRateTableModel(exRate));
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
        currency = client.refreshCurrency();
        jComboBoxExRateCurr2.removeAllItems();
        for (int i = 0; i < currency.size(); i++){
            jComboBoxExRateCurr2.addItem(currency.get(i));
        }
    }
    
    public void bankRefresh() throws RemoteException{
        bank = client.bankRefresh();
        jTable1.setModel(new BankTableModel(bank));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextFirmName = new javax.swing.JTextField();
        jTextFirmCountry = new javax.swing.JTextField();
        jTextFirmAdress = new javax.swing.JTextField();
        jTextFirmLicense = new javax.swing.JTextField();
        jTextFirmType = new javax.swing.JTextField();
        jButtonFirmAdd = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxAccFirm = new javax.swing.JComboBox();
        jComboBoxAccCurrency = new javax.swing.JComboBox();
        jComboBoxAccBank = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldAccType = new javax.swing.JTextField();
        jPanelBank = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextBankName = new javax.swing.JTextField();
        jTextBankAdress = new javax.swing.JTextField();
        jTextBankCountry = new javax.swing.JTextField();
        jTextBankLicense = new javax.swing.JTextField();
        jLabelBankError = new javax.swing.JLabel();
        jButtonBankAdd = new javax.swing.JButton();
        jButtonBankEdit = new javax.swing.JButton();
        jButtonBankDel = new javax.swing.JButton();
        jButtonBankRefresh = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanelExchangeRate = new javax.swing.JPanel();
        jComboBoxExRateCurr2 = new javax.swing.JComboBox();
        jButtonExRateAdd = new javax.swing.JButton();
        jComboBoxRub = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextExRateCurr1 = new javax.swing.JTextField();
        jTextExRateCurr2 = new javax.swing.JTextField();
        jLabelExRateError = new javax.swing.JLabel();
        jButtonExRateDel = new javax.swing.JButton();
        jPanelCurrency = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextCurrName = new javax.swing.JTextField();
        jTextCurrCountry = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextCurrDescr = new javax.swing.JTextArea();
        jButtonCurrAdd = new javax.swing.JButton();
        jButtonCurrRefresh = new javax.swing.JButton();
        jButtonCurrEdit = new javax.swing.JButton();
        jButtonCurrDel = new javax.swing.JButton();
        jLabelCurrError = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Boreey Бухгалтер");

        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jScrollPane1.setViewportView(jTable1);

        jLabel14.setText("Название фирмы");

        jLabel15.setText("Страна");

        jLabel16.setText("Адрес");
        jLabel16.setToolTipText("");

        jLabel17.setText("№ лицензии");

        jLabel18.setText("Тип");

        jButtonFirmAdd.setText("Добавить");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFirmName)
                            .addComponent(jTextFirmCountry)
                            .addComponent(jTextFirmAdress)
                            .addComponent(jTextFirmLicense)
                            .addComponent(jTextFirmType, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))
                    .addComponent(jButtonFirmAdd))
                .addContainerGap(273, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextFirmName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextFirmCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextFirmAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextFirmLicense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextFirmType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonFirmAdd)
                .addContainerGap(206, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Клиенты", jPanel1);

        jLabel10.setText("Фирма");

        jLabel11.setText("Валюта");

        jLabel12.setText("Банк");

        jLabel13.setText("Тип");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(68, 68, 68)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldAccType)
                    .addComponent(jComboBoxAccBank, 0, 120, Short.MAX_VALUE)
                    .addComponent(jComboBoxAccCurrency, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxAccFirm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(324, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBoxAccFirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBoxAccCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxAccBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldAccType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(258, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Банк.Счета", jPanel3);

        jPanelBank.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanelBankComponentShown(evt);
            }
        });

        jLabel6.setText("Название банка:");

        jLabel7.setText("Адресс банка:");
        jLabel7.setToolTipText("");

        jLabel8.setText("Страна:");

        jLabel9.setText("Номер лицензии:");
        jLabel9.setToolTipText("");

        jLabelBankError.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelBankError.setText("Nya");

        jButtonBankAdd.setText("Добавить");
        jButtonBankAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBankAddActionPerformed(evt);
            }
        });

        jButtonBankEdit.setText("Редакитровать");
        jButtonBankEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBankEditActionPerformed(evt);
            }
        });

        jButtonBankDel.setText("Удалить");
        jButtonBankDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBankDelActionPerformed(evt);
            }
        });

        jButtonBankRefresh.setText("Обновить");
        jButtonBankRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBankRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBankLayout = new javax.swing.GroupLayout(jPanelBank);
        jPanelBank.setLayout(jPanelBankLayout);
        jPanelBankLayout.setHorizontalGroup(
            jPanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBankLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelBankError)
                    .addGroup(jPanelBankLayout.createSequentialGroup()
                        .addGroup(jPanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonBankDel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonBankAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonBankEdit)
                            .addComponent(jButtonBankRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextBankCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelBankLayout.createSequentialGroup()
                            .addGroup(jPanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelBankLayout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(jTextBankLicense, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBankLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextBankAdress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextBankName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBankLayout.setVerticalGroup(
            jPanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBankLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextBankName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextBankAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextBankCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextBankLicense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelBankError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBankAdd)
                    .addComponent(jButtonBankEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBankDel)
                    .addComponent(jButtonBankRefresh))
                .addContainerGap(180, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Банки", jPanelBank);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 382, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Вх.Платежные поручения", jPanel4);

        jPanelExchangeRate.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanelExchangeRateComponentShown(evt);
            }
        });

        jButtonExRateAdd.setText("Добавить");
        jButtonExRateAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExRateAddActionPerformed(evt);
            }
        });

        jComboBoxRub.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Рубли" }));
        jComboBoxRub.setEnabled(false);

        jLabel4.setText("Валюта 1:");

        jLabel5.setText("Валюта 2:");

        jLabelExRateError.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelExRateError.setText("NYa");

        jButtonExRateDel.setText("Удалить");
        jButtonExRateDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExRateDelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelExchangeRateLayout = new javax.swing.GroupLayout(jPanelExchangeRate);
        jPanelExchangeRate.setLayout(jPanelExchangeRateLayout);
        jPanelExchangeRateLayout.setHorizontalGroup(
            jPanelExchangeRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelExchangeRateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelExchangeRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelExchangeRateLayout.createSequentialGroup()
                        .addGroup(jPanelExchangeRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelExchangeRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelExchangeRateLayout.createSequentialGroup()
                                .addComponent(jComboBoxExRateCurr2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextExRateCurr2, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                            .addGroup(jPanelExchangeRateLayout.createSequentialGroup()
                                .addComponent(jComboBoxRub, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextExRateCurr1))))
                    .addGroup(jPanelExchangeRateLayout.createSequentialGroup()
                        .addGroup(jPanelExchangeRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelExRateError)
                            .addGroup(jPanelExchangeRateLayout.createSequentialGroup()
                                .addComponent(jButtonExRateAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonExRateDel)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelExchangeRateLayout.setVerticalGroup(
            jPanelExchangeRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelExchangeRateLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanelExchangeRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxRub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextExRateCurr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelExchangeRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxExRateCurr2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextExRateCurr2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelExRateError)
                .addGap(35, 35, 35)
                .addGroup(jPanelExchangeRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExRateAdd)
                    .addComponent(jButtonExRateDel))
                .addContainerGap(222, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Курсы", jPanelExchangeRate);

        jPanelCurrency.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanelCurrencyComponentShown(evt);
            }
        });

        jLabel1.setText("Название");

        jLabel2.setText("Страна");

        jLabel3.setText("Описание");

        jTextCurrDescr.setColumns(20);
        jTextCurrDescr.setRows(5);
        jScrollPane2.setViewportView(jTextCurrDescr);

        jButtonCurrAdd.setText("Добавить");
        jButtonCurrAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCurrAddActionPerformed(evt);
            }
        });

        jButtonCurrRefresh.setText("Обновить");
        jButtonCurrRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCurrRefreshActionPerformed(evt);
            }
        });

        jButtonCurrEdit.setText("Редактировать");
        jButtonCurrEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCurrEditActionPerformed(evt);
            }
        });

        jButtonCurrDel.setText("Удалить");
        jButtonCurrDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCurrDelActionPerformed(evt);
            }
        });

        jLabelCurrError.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelCurrError.setText("Nya");

        javax.swing.GroupLayout jPanelCurrencyLayout = new javax.swing.GroupLayout(jPanelCurrency);
        jPanelCurrency.setLayout(jPanelCurrencyLayout);
        jPanelCurrencyLayout.setHorizontalGroup(
            jPanelCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCurrencyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanelCurrencyLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextCurrCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButtonCurrDel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonCurrAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonCurrEdit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonCurrRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabelCurrError)
                            .addGroup(jPanelCurrencyLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextCurrName, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        jPanelCurrencyLayout.setVerticalGroup(
            jPanelCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCurrencyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextCurrName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextCurrCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabelCurrError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCurrEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCurrAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCurrDel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCurrRefresh)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Валюты", jPanelCurrency);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelCurrencyComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanelCurrencyComponentShown
        selected = -1;
        selectListen = null;
        jTextCurrCountry.setText("");
        jTextCurrDescr.setText("");
        jTextCurrName.setText("");
        jLabelCurrError.setText("");
        try {
            currRefresh();
            jTable1.getSelectionModel().addListSelectionListener(selectListen = new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    selected = jTable1.getSelectedRow();
                    if (selected < currency.size() && selected >=0){
                        jTextCurrName.setText(currency.get(selected).getName());
                        jTextCurrCountry.setText(currency.get(selected).getCountry());
                        jTextCurrDescr.setText(currency.get(selected).getDesc());
                    }
                }
            });
        } catch (RemoteException ex) {}
    }//GEN-LAST:event_jPanelCurrencyComponentShown

    private void jButtonCurrDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCurrDelActionPerformed
        try{
            if (selected>=0){
                if (currency.get(selected).getId()==0){
                    jLabelCurrError.setText("Нельзя удалить рубли");
                }
                else{
                    if (client.delCurrency(currency.get(selected))==1){
                        jLabelCurrError.setText("Удаление OK");
                        currRefresh();
                    }
                    else{
                        jLabelCurrError.setText("Удаление Error");
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("Error:="+e);
            this.jLabelCurrError.setText("Удаление: ошибка.");
        }
    }//GEN-LAST:event_jButtonCurrDelActionPerformed

    private void jButtonCurrEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCurrEditActionPerformed
        Currency edCurr = new Currency();
        try{
            edCurr.setName(jTextCurrName.getText());
            edCurr.setCountry(jTextCurrCountry.getText());
            edCurr.setDesc(jTextCurrDescr.getText());
            edCurr.setId(currency.get(selected).getId());
            if (client.editCurrency(edCurr)==1){
                jLabelCurrError.setText("Редактирование OK");
                currRefresh();
            }
            else{
                jLabelCurrError.setText("Редактирование Error");
            }
        }
        catch(Exception e){
            System.out.println("Error:="+e);
            this.jLabelCurrError.setText("Редактирование: ошибка. ПРоверьте исходные даные.");
        }
    }//GEN-LAST:event_jButtonCurrEditActionPerformed

    private void jButtonCurrRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCurrRefreshActionPerformed
        try {
            currRefresh();
        } catch (RemoteException ex) {}
    }//GEN-LAST:event_jButtonCurrRefreshActionPerformed

    private void jButtonCurrAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCurrAddActionPerformed
        Currency newCurr = new Currency();
        try{
            newCurr.setName(jTextCurrName.getText());
            newCurr.setCountry(jTextCurrCountry.getText());
            newCurr.setDesc(jTextCurrDescr.getText());
            if (currency.isEmpty()){
                newCurr.setId(0);
            }
            else{
                int max=0;
                for (int i=0; i<currency.size();i++){
                    if (currency.get(i).getId()>max){
                        max=currency.get(i).getId();
                    }
                }
                newCurr.setId(max+1);
            }

            if(client.addCurrency(newCurr)==1){
                jLabelCurrError.setText("Добавление OK");
                currRefresh();
            }
            else{
                jLabelCurrError.setText("Добавление Error");
            }
        }
        catch(Exception e){
            this.jLabelCurrError.setText("Добавление: ошибка. Проверьте исходные даные.");
        }
    }//GEN-LAST:event_jButtonCurrAddActionPerformed

    private void jPanelExchangeRateComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanelExchangeRateComponentShown
        selected = -1;
        selectListen = null;
        jTextExRateCurr1.setText("");
        jTextExRateCurr2.setText("");
        jLabelExRateError.setText("");
        try {
            exRateRefresh();
            jTable1.getSelectionModel().addListSelectionListener(selectListen = new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    selected = jTable1.getSelectedRow();
                    if (selected >=0 && exRate.size()>selected){
                        if (selected < currency.size() && selected >=0){
                            int c = exRate.get(selected).getCurrency_id_2();
                            boolean nya = true;
                            int d=-1;
                            for (int i=0; i<currency.size() && nya; i++){
                                if (c == currency.get(i).getId()){
                                    d=i;
                                    nya=false;
                                }
                            }
                            jComboBoxExRateCurr2.setSelectedIndex(d);
                            jTextExRateCurr1.setText("1");
                            float rate = exRate.get(selected).getRatio();
                            float cur;
                            cur=1/rate;
                            jTextExRateCurr2.setText(new Float(cur).toString());
                        }
                    }
                }
            });
        } catch (RemoteException ex) {
            System.out.println("ExRate_show: "+ex);
        }
    }//GEN-LAST:event_jPanelExchangeRateComponentShown

    private void jButtonExRateDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExRateDelActionPerformed
        try{
            if (selected>=0){
                if (client.delExRate(exRate.get(selected))==1){
                    jLabelExRateError.setText("Удаление OK");
                    exRateRefresh();
                }
                else{
                    jLabelExRateError.setText("Удаление Error");
                }
            }
        }
        catch(Exception e){
            System.out.println("Error:="+e);
            this.jLabelCurrError.setText("Удаление: ошибка.");
        }
    }//GEN-LAST:event_jButtonExRateDelActionPerformed

    private void jButtonExRateAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExRateAddActionPerformed
        ExchangeRate newRate = new ExchangeRate();
        try{
            newRate.setCurrency_id_1(0);
            newRate.setCurrency_id_2(currency.get(jComboBoxExRateCurr2.getSelectedIndex()).getId());
            if (newRate.getCurrency_id_2()==0){
                throw new Exception("Нельзя");
            }
            float rate, cur1, cur2;
            cur1 = new Float(jTextExRateCurr1.getText());
            cur2 = new Float(jTextExRateCurr2.getText());
            rate=cur1/cur2;
            newRate.setRatio(rate);
            newRate.setDate(new SimpleDateFormat("dd.MM.yyyy").format(new Date()));
            if (exRate.isEmpty()){
                newRate.setId(0);
            }
            else{
                int max=0;
                for (int i=0; i<exRate.size();i++){
                    if (exRate.get(i).getId()>max){
                        max=exRate.get(i).getId();
                    }
                }
                newRate.setId(max+1);
            }

            if(client.addExRate(newRate)==1){
                jLabelCurrError.setText("Добавление OK");
                exRateRefresh();
            }
            else{
                jLabelCurrError.setText("Добавление Error");
            }

        }
        catch(Exception e){
            System.out.println("ExRateAdd_1: "+e);
            if (e.getMessage().equals("Нельзя")){
                this.jLabelExRateError.setText("Нельзя установить курс к одной и той же валюте");
            }
            else
            this.jLabelExRateError.setText("Добавление: ошибка. ПРоверьте исходные даные.");
        }

    }//GEN-LAST:event_jButtonExRateAddActionPerformed

    private void jPanelBankComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanelBankComponentShown
        selected = -1;
        selectListen = null;
        jTextBankAdress.setText("");
        jTextBankCountry.setText("");
        jTextBankLicense.setText("");
        jTextBankName.setText("");
        jLabelBankError.setText("");
        try {
            bankRefresh();
            jTable1.getSelectionModel().addListSelectionListener(selectListen = new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    selected = jTable1.getSelectedRow();
                    if (selected >=0 && bank.size()>selected){
                        jTextBankName.setText(bank.get(selected).getName());
                        jTextBankAdress.setText(bank.get(selected).getAddress());
                        jTextBankCountry.setText(bank.get(selected).getLocation());
                        jTextBankLicense.setText(bank.get(selected).getLicense_num().toString());
                    }
                }
            });

        } catch (Exception ex) {
            System.out.println("Bank show_1: "+ex);
        }
    }//GEN-LAST:event_jPanelBankComponentShown

    private void jButtonBankRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBankRefreshActionPerformed
        try {
            bankRefresh();
        } catch (RemoteException ex){}
    }//GEN-LAST:event_jButtonBankRefreshActionPerformed

    private void jButtonBankDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBankDelActionPerformed
        try{
            if (selected>=0){
                if (client.delBank(bank.get(selected))==1){
                    jLabelBankError.setText("Удаление ОК");
                    bankRefresh();
                }
                else{
                    jLabelBankError.setText("Удаление: ошибка.");
                }
            }
            else{
                jLabelBankError.setText("Удаление ошибка");
            }
        }
        catch(Exception e){
            System.out.println("Error bank_del :"+e);
            this.jLabelBankError.setText("Удаление: ошибка.");
        }
    }//GEN-LAST:event_jButtonBankDelActionPerformed

    private void jButtonBankEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBankEditActionPerformed
        Bank newBank = new Bank();
        try{
            newBank.setName(jTextBankName.getText());
            newBank.setAddress(jTextBankAdress.getText());
            newBank.setLocation(jTextBankCountry.getText());
            newBank.setLicense_num(new Integer(jTextBankLicense.getText()));
            newBank.setId(bank.get(selected).getId());
            if (client.editBank(newBank)==1){
                jLabelBankError.setText("Редактирование OK");
                bankRefresh();
            }
            else{
                jLabelBankError.setText("Редактирование Error");
            }
        }
        catch(Exception e){
            System.out.println("Error:="+e);
            this.jLabelBankError.setText("Редактирование: ошибка. ПРоверьте исходные даные.");
        }
    }//GEN-LAST:event_jButtonBankEditActionPerformed

    private void jButtonBankAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBankAddActionPerformed
        Bank newBank = new Bank();
        try{
            newBank.setName(jTextBankName.getText());
            newBank.setAddress(jTextBankAdress.getText());
            newBank.setLocation(jTextBankCountry.getText());
            newBank.setLicense_num(new Integer(jTextBankLicense.getText()));
            if (bank.isEmpty()){
                newBank.setId(0);
            }
            else{
                int max = 0;
                for (int i=0; i<bank.size();i++){
                    if (bank.get(i).getId()>max){
                        max=bank.get(i).getId();
                    }
                }
                newBank.setId(max+1);
            }
            if (client.addBank(newBank) == 1){
                jLabelBankError.setText("Добавление успешно");
                bankRefresh();
            }
            else{
                jLabelBankError.setText("Добавление ошибка");
            }
        }
        catch(Exception e){
            System.out.println("Bank_add: "+e);
            jLabelBankError.setText("Добавление: ошибка. Проверьте данные.");
        }

    }//GEN-LAST:event_jButtonBankAddActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBankAdd;
    private javax.swing.JButton jButtonBankDel;
    private javax.swing.JButton jButtonBankEdit;
    private javax.swing.JButton jButtonBankRefresh;
    private javax.swing.JButton jButtonCurrAdd;
    private javax.swing.JButton jButtonCurrDel;
    private javax.swing.JButton jButtonCurrEdit;
    private javax.swing.JButton jButtonCurrRefresh;
    private javax.swing.JButton jButtonExRateAdd;
    private javax.swing.JButton jButtonExRateDel;
    private javax.swing.JButton jButtonFirmAdd;
    private javax.swing.JComboBox jComboBoxAccBank;
    private javax.swing.JComboBox jComboBoxAccCurrency;
    private javax.swing.JComboBox jComboBoxAccFirm;
    private javax.swing.JComboBox jComboBoxExRateCurr2;
    private javax.swing.JComboBox jComboBoxRub;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelBankError;
    private javax.swing.JLabel jLabelCurrError;
    private javax.swing.JLabel jLabelExRateError;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelBank;
    private javax.swing.JPanel jPanelCurrency;
    private javax.swing.JPanel jPanelExchangeRate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextBankAdress;
    private javax.swing.JTextField jTextBankCountry;
    private javax.swing.JTextField jTextBankLicense;
    private javax.swing.JTextField jTextBankName;
    private javax.swing.JTextField jTextCurrCountry;
    private javax.swing.JTextArea jTextCurrDescr;
    private javax.swing.JTextField jTextCurrName;
    private javax.swing.JTextField jTextExRateCurr1;
    private javax.swing.JTextField jTextExRateCurr2;
    private javax.swing.JTextField jTextFieldAccType;
    private javax.swing.JTextField jTextFirmAdress;
    private javax.swing.JTextField jTextFirmCountry;
    private javax.swing.JTextField jTextFirmLicense;
    private javax.swing.JTextField jTextFirmName;
    private javax.swing.JTextField jTextFirmType;
    // End of variables declaration//GEN-END:variables
}
