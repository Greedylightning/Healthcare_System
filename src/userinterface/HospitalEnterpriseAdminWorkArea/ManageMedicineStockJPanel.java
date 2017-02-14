/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.HospitalEnterpriseAdminWorkArea;

import business.enterprise.Enterprise;
import business.enterprise.HospitalEnterprise;
import business.medicine.MedicineStock;
import business.workqueue.MedicineProduceRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zack
 */
public class ManageMedicineStockJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageMedicineStockJPanel
     */
    JPanel userProcessContainer;
    HospitalEnterprise enterprise;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public ManageMedicineStockJPanel(JPanel userProcessContainer,HospitalEnterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        populateStockTable();
        populateRequestTable();
    }

    public void populateStockTable(){
        DefaultTableModel model = (DefaultTableModel) stockJTable.getModel();
        model.setRowCount(0);
        for(MedicineStock stock : enterprise.getStockCatalog()){
            Object[] row = new Object[2];
            //row[0] = stock.getMedicine().getId();
            row[0] = stock;
            row[1] = stock.getAmount();
            model.addRow(row);
        }
    }
    
    public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) requestJTable.getModel();
        model.setRowCount(0);
        for(MedicineProduceRequest request : enterprise.getRequestCatalog()){
            Object[] row = new Object[5];
            row[0] = format.format(request.getRequestDate());
            row[1] = request.getId();
            row[2] = request;
            row[3] = request.getAmount();
            row[4] = request.getStatus();
            model.addRow(row);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        requestJTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        stockJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        amountJTextField = new javax.swing.JTextField();
        requestJButton = new javax.swing.JButton();
        removeJButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        nameJTextField1 = new javax.swing.JTextField();
        amountJTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        removeJButton1 = new javax.swing.JButton();
        addstockJButton = new javax.swing.JButton();
        completeJButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 46));

        requestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Request Date", "Task ID", "Medicine Name", "Amount", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(requestJTable);
        if (requestJTable.getColumnModel().getColumnCount() > 0) {
            requestJTable.getColumnModel().getColumn(0).setResizable(false);
            requestJTable.getColumnModel().getColumn(1).setResizable(false);
            requestJTable.getColumnModel().getColumn(2).setResizable(false);
            requestJTable.getColumnModel().getColumn(3).setResizable(false);
            requestJTable.getColumnModel().getColumn(4).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 570, 290));

        stockJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Medicine Name", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(stockJTable);
        if (stockJTable.getColumnModel().getColumnCount() > 0) {
            stockJTable.getColumnModel().getColumn(0).setResizable(false);
            stockJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 522, 290));

        jLabel1.setText("Medicine Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, -1, -1));

        jLabel2.setText("Medicine Amount");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 440, -1, -1));
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 400, 129, -1));
        add(amountJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 430, 129, -1));

        requestJButton.setText("Request Medicine");
        requestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestJButtonActionPerformed(evt);
            }
        });
        add(requestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 470, -1, -1));

        removeJButton.setText("Remove");
        removeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeJButtonActionPerformed(evt);
            }
        });
        add(removeJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 430, 104, -1));

        jLabel3.setText("Medicine Name");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));
        add(nameJTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 129, -1));
        add(amountJTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 129, -1));

        jLabel4.setText("Medicine Amount");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        removeJButton1.setText("Remove");
        removeJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeJButton1ActionPerformed(evt);
            }
        });
        add(removeJButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 400, -1, -1));

        addstockJButton.setText("Add Stock");
        addstockJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addstockJButtonActionPerformed(evt);
            }
        });
        add(addstockJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, -1, -1));

        completeJButton.setText("Complete");
        completeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeJButtonActionPerformed(evt);
            }
        });
        add(completeJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 400, -1, -1));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(140, 227, 226));
        jLabel5.setText("Hospital Stock");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(140, 227, 226));
        jLabel6.setText("Medicine Request");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/warehouse.png"))); // NOI18N
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/clock.png"))); // NOI18N
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/hospital.png"))); // NOI18N
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 780, -1, 190));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        EnterpriseSystemAdminWorkAreaJPanel sysAdminwjp = (EnterpriseSystemAdminWorkAreaJPanel) component;
        sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void addstockJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addstockJButtonActionPerformed
        // TODO add your handling code here:
        String name = nameJTextField1.getText().trim();
        int amount = Integer.parseInt(amountJTextField1.getText().trim());
        
        if(!name.matches("[a-zA-Z]+")){
            JOptionPane.showMessageDialog(null, "Invalid medicine name!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if(amount <= 0){
            JOptionPane.showMessageDialog(null, "Invalid amount!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        for(MedicineStock stock : enterprise.getStockCatalog()){
            if(stock.getMedicine().getName().equals(name)){
                stock.setAmount(stock.getAmount() + amount);
                nameJTextField1.setText("");
                amountJTextField1.setText("");
                populateStockTable();
                return;
            }
        }
        MedicineStock stock = new MedicineStock(nameJTextField1.getText().trim(),Integer.parseInt(amountJTextField1.getText().trim()));
        enterprise.getStockCatalog().add(stock);
        nameJTextField1.setText("");
        amountJTextField1.setText("");
        populateStockTable();
    }//GEN-LAST:event_addstockJButtonActionPerformed

    private void removeJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeJButton1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = stockJTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        MedicineStock stock = (MedicineStock) stockJTable.getValueAt(selectedRow, 1);
        enterprise.getStockCatalog().remove(stock);
        populateStockTable();
    }//GEN-LAST:event_removeJButton1ActionPerformed

    private void requestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestJButtonActionPerformed
        // TODO add your handling code here:
        String name = nameJTextField.getText().trim();
        int amount = Integer.parseInt(amountJTextField.getText().trim());
        
        if(!name.matches("[a-zA-Z]+")){
            JOptionPane.showMessageDialog(null, "Invalid medicine name!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if(amount <= 0){
            JOptionPane.showMessageDialog(null, "Invalid amount!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        MedicineProduceRequest request = new MedicineProduceRequest(name,amount);
        request.setStatus("Pending");
        request.setRequestDate(new Date());
        request.setComment("New");
        enterprise.getRequestCatalog().add(request);
        nameJTextField.setText("");
        amountJTextField.setText("");
        populateRequestTable();
    }//GEN-LAST:event_requestJButtonActionPerformed

    private void removeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = requestJTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        MedicineProduceRequest request = (MedicineProduceRequest) requestJTable.getValueAt(selectedRow, 2);
        enterprise.getRequestCatalog().remove(request);
        populateRequestTable();
    }//GEN-LAST:event_removeJButtonActionPerformed

    private void completeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completeJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = requestJTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        MedicineProduceRequest request = (MedicineProduceRequest) requestJTable.getValueAt(selectedRow, 2);
        request.setStatus("Completed");
        for(MedicineStock stock : enterprise.getStockCatalog()){
            if(stock.getMedicine().getName().equals(request.getMedicine().getName())){
                stock.setAmount(stock.getAmount() + request.getAmount());
                populateRequestTable();
                populateStockTable();
                return;
            }
        }
        MedicineStock stock = new MedicineStock(request.getMedicine().getName(),request.getAmount());
        enterprise.getStockCatalog().add(stock);
        populateStockTable();
        populateRequestTable();
    }//GEN-LAST:event_completeJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addstockJButton;
    private javax.swing.JTextField amountJTextField;
    private javax.swing.JTextField amountJTextField1;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton completeJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JTextField nameJTextField1;
    private javax.swing.JButton removeJButton;
    private javax.swing.JButton removeJButton1;
    private javax.swing.JButton requestJButton;
    private javax.swing.JTable requestJTable;
    private javax.swing.JTable stockJTable;
    // End of variables declaration//GEN-END:variables
}