package client_stuff;

import models.GoodsTableModel;
import Client.Client;
import entities.Goods;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GoodsManagerForm extends javax.swing.JFrame {
    Client client;
    ArrayList<Goods> goods = null;
    int selected=-2;
        
    public GoodsManagerForm(Client client) throws RemoteException {
        initComponents();
        this.client=client;
        refresh();
        jTableGoods.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTableGoods.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTableGoods.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTableGoods.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTableGoods.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTableGoods.getColumnModel().getColumn(5).setPreferredWidth(50);
        jTableGoods.getColumnModel().getColumn(6).setPreferredWidth(50);
        jLabelMessage.setText("");
        jTableGoods.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                selected = jTableGoods.getSelectedRow();
                if (selected<goods.size() && selected>=0){
                    jTextName.setText(goods.get(selected).getName());
                    jTextClass.setText(goods.get(selected).getClass_num().toString());
                    jTextFirm.setText(goods.get(selected).getFirm_name());
                    jTextTara.setText(goods.get(selected).getTara());
                    jTextPrise.setText(goods.get(selected).getPrice().toString());
                    jTextQuantity.setText(goods.get(selected).getCount().toString());
                }
            }
        });
    }
    
    public void refresh() throws RemoteException{
        selected = -1;
        goods = client.refreshGoods();
        jTableGoods.setModel(new GoodsTableModel(goods));
        jTableGoods.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTableGoods.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTableGoods.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTableGoods.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTableGoods.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTableGoods.getColumnModel().getColumn(5).setPreferredWidth(50);
        jTableGoods.getColumnModel().getColumn(6).setPreferredWidth(50);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonGoodsAdd = new javax.swing.JButton();
        jButtonGoodsEdit = new javax.swing.JButton();
        jButtonGoodsDel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButtonGoodsRefresh = new javax.swing.JButton();
        jTextName = new javax.swing.JTextField();
        jTextClass = new javax.swing.JTextField();
        jTextTara = new javax.swing.JTextField();
        jTextFirm = new javax.swing.JTextField();
        jTextQuantity = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableGoods = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jTextPrise = new javax.swing.JTextField();
        jLabelMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Boreey Товаровед");
        setResizable(false);

        jButtonGoodsAdd.setText("Добавить");
        jButtonGoodsAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoodsAddActionPerformed(evt);
            }
        });

        jButtonGoodsEdit.setText("Редактировать");
        jButtonGoodsEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoodsEditActionPerformed(evt);
            }
        });

        jButtonGoodsDel.setText("Удалить");
        jButtonGoodsDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoodsDelActionPerformed(evt);
            }
        });

        jLabel1.setText("Название: ");

        jLabel2.setText("Сертификат: ");

        jLabel3.setText("Упаковка: ");

        jLabel4.setText("Фирма-производитель:");

        jLabel5.setText("Количество на складе:");

        jButtonGoodsRefresh.setText("Обновить");
        jButtonGoodsRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoodsRefreshActionPerformed(evt);
            }
        });

        jTableGoods.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jTableGoods.setAutoscrolls(false);
        jTableGoods.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane2.setViewportView(jTableGoods);

        jLabel6.setText("Цена:");

        jLabelMessage.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelMessage.setText("NYa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextClass)
                                .addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextTara, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addComponent(jTextFirm)
                                .addComponent(jTextQuantity)
                                .addComponent(jTextPrise))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButtonGoodsDel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonGoodsAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonGoodsEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                    .addComponent(jButtonGoodsRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabelMessage))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextTara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextPrise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelMessage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonGoodsDel)
                            .addComponent(jButtonGoodsRefresh))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonGoodsAdd)
                            .addComponent(jButtonGoodsEdit)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGoodsRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoodsRefreshActionPerformed
        try {
            refresh();
        } catch (RemoteException ex) {}
    }//GEN-LAST:event_jButtonGoodsRefreshActionPerformed

    private void jButtonGoodsAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoodsAddActionPerformed
        Goods newGood = new Goods();
        try{
            newGood.setName(jTextName.getText());
            newGood.setClass_num(Integer.parseInt(jTextClass.getText()));
            newGood.setFirm_name(jTextFirm.getText());
            newGood.setTara(jTextTara.getText());
            newGood.setPrice(Integer.parseInt(jTextPrise.getText()));
            newGood.setCount(Integer.parseInt(jTextQuantity.getText()));
            
            //TODO Убрать потом
            int max=0;
            for (int i=0; i<goods.size();i++){
                if (goods.get(i).getId()>max){
                max=goods.get(i).getId();
                }
            }
            newGood.setId(max+1);
            
            
            if(client.addGoods(newGood)==1){
                jLabelMessage.setText("Добавление OK");
                refresh();
            }
            else{
                jLabelMessage.setText("Добавление Error");
            }
        }
        catch(Exception e){
            this.jLabelMessage.setText("Добавление: ошибка. ПРоверьте исходные даные.");
        }
    }//GEN-LAST:event_jButtonGoodsAddActionPerformed

    private void jButtonGoodsEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoodsEditActionPerformed
        Goods newGood = new Goods();
        try{
            newGood.setName(jTextName.getText());
            newGood.setClass_num(Integer.parseInt(jTextClass.getText()));
            newGood.setFirm_name(jTextFirm.getText());
            newGood.setTara(jTextTara.getText());
            newGood.setPrice(Integer.parseInt(jTextPrise.getText()));
            newGood.setCount(Integer.parseInt(jTextQuantity.getText()));
            newGood.setId(goods.get(selected).getId());
            if (client.editGoods(newGood)==1){
                jLabelMessage.setText("Редактирование OK");
                refresh();
            }
            else{
                jLabelMessage.setText("Редактирование Error");
            }
        }
        catch(Exception e){
            System.out.println("Error:="+e);
            this.jLabelMessage.setText("Редактирование: ошибка. ПРоверьте исходные даные.");
        }
    }//GEN-LAST:event_jButtonGoodsEditActionPerformed

    private void jButtonGoodsDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoodsDelActionPerformed
        try{
            if (selected>=0){
                if (client.delGoods(goods.get(selected))==1){
                    jLabelMessage.setText("Удаление OK");
                    refresh();
                }
                else{
                    jLabelMessage.setText("Удаление Error");
                }
            }
        }
        catch(Exception e){
            System.out.println("Error:="+e);
            this.jLabelMessage.setText("Удаление: ошибка.");            
        }
    }//GEN-LAST:event_jButtonGoodsDelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGoodsAdd;
    private javax.swing.JButton jButtonGoodsDel;
    private javax.swing.JButton jButtonGoodsEdit;
    private javax.swing.JButton jButtonGoodsRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableGoods;
    private javax.swing.JTextField jTextClass;
    private javax.swing.JTextField jTextFirm;
    private javax.swing.JTextField jTextName;
    private javax.swing.JTextField jTextPrise;
    private javax.swing.JTextField jTextQuantity;
    private javax.swing.JTextField jTextTara;
    // End of variables declaration//GEN-END:variables
}
