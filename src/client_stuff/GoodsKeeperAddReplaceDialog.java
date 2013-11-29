
package client_stuff;

import entities.Goods;
import entities.Replaces;
import java.util.ArrayList;

public class GoodsKeeperAddReplaceDialog extends javax.swing.JDialog {
    private GoodsManagerForm manager = null;
    private ArrayList<Goods> goods = null;
    
    public GoodsKeeperAddReplaceDialog(java.awt.Frame parent, boolean modal, GoodsManagerForm manager, ArrayList<Goods> goods) {
        super(parent, modal);
        initComponents();
        this.manager = manager;
        this.goods = goods;
        jComboBoxRep1.removeAllItems();
        jComboBoxRep2.removeAllItems();
        for (int i=0; i<goods.size(); i++){
            jComboBoxRep1.addItem(goods.get(i).getName());
            jComboBoxRep2.addItem(goods.get(i).getName());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxRep1 = new javax.swing.JComboBox();
        jComboBoxRep2 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jComboBoxRep1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxRep2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Добавить");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxRep1, 0, 238, Short.MAX_VALUE)
                            .addComponent(jComboBoxRep2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jButton1)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jComboBoxRep1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxRep2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton1)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Replaces newRep = new Replaces();
        newRep.setGood_id(goods.get(jComboBoxRep1.getSelectedIndex()).getId());
        newRep.setReplace_good_id(goods.get(jComboBoxRep2.getSelectedIndex()).getId());
        manager.addReplace(newRep);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBoxRep1;
    private javax.swing.JComboBox jComboBoxRep2;
    // End of variables declaration//GEN-END:variables
}
