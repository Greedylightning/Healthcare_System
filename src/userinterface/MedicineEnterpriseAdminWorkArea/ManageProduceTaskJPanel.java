/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.MedicineEnterpriseAdminWorkArea;

import business.enterprise.Enterprise;
import business.enterprise.HospitalEnterprise;
import business.enterprise.MedicineEnterprise;
import business.medicine.Medicine;
import business.medicine.MedicineStock;
import business.network.Network;
import business.organization.Organization;
import business.useraccount.UserAccount;
import business.workqueue.MedicineProduceRequest;
import business.workqueue.MedicineProduceTask;
import business.workqueue.MedicineTestWorkRequest;
import business.workqueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zack
 */
public class ManageProduceTaskJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageProduceTaskJPanel
     */
    
    JPanel userProcessContainer;
    MedicineEnterprise enterprise;
    Network network;
    UserAccount account;
    public ManageProduceTaskJPanel(JPanel userProcessContainer,MedicineEnterprise enterprise,Network network,UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.network = network;
        populateRequest();
        populateMedicineTable();
        populateTestTable();
        populateTaskTable();
        populateStockTable();
        //populateRequest();
    }

    public void populateMedicineTable(){
        DefaultTableModel model = (DefaultTableModel) medicineJTable.getModel();
        model.setRowCount(0);
        for(Medicine medicine : enterprise.getMedicineCatalog()){
            Object[] row = new Object[2];
            row[0] = medicine.getId();
            row[1] = medicine;
            model.addRow(row);
        }
        
        
    }
    
    public void populateRequest(){
        
        for(Enterprise e : network.getEnterpriseCatalog().getEnterpriseCatalog()){
            if(e.getEnterpriseType().equals(Enterprise.EnterpriseType.Hospital)){
                ((HospitalEnterprise) e).getRequestCatalog();
                for(MedicineProduceRequest r : ((HospitalEnterprise) e).getRequestCatalog()){
                    if(!r.getStatus().equals("Completed") && r.getComment().equals("New")){
                         MedicineProduceTask task = new MedicineProduceTask();
                    task.setId(r.getId());
                    task.setMedicine(r.getMedicine());
                    task.setAmount(r.getAmount());
                    task.setRemaining(r.getAmount());
                    task.setStatus("Producing");
                    task.setReceiver(account);
                    task.setSender(r.getSender());
                    task.setRequestDate(r.getRequestDate());                  
                    enterprise.getTaskCatalog().add(task);
                    r.setComment("Old");
                    }
                   
                }
            }
        }
    }
    
    public void populateTestTable(){
        DefaultTableModel model = (DefaultTableModel) testJTable.getModel();
        model.setRowCount(0);
        for(Organization organization : enterprise.getOrganizationCatalog().getOrganizationCatalog()){
            if(organization.getMedicineOrganizationType().equals(Enterprise.MedicineOrganizationType.Tester)){
                for(WorkRequest request : organization.getWorkQueue().getWorkRequestCatalog()){
                    if(request.getStatus().equals("Complete")){
                        Object[] row = new Object[3];
                        row[0] = ((MedicineTestWorkRequest) request).getMedicine().getId();
                        row[1] = ((MedicineTestWorkRequest) request).getMedicine();
                        row[2] = ((MedicineTestWorkRequest) request).getResult();
                        model.addRow(row);
                    }
                }
            }
        }
    }
    
    public void populateTaskTable(){
        DefaultTableModel model = (DefaultTableModel) taskJTable.getModel();
        model.setRowCount(0);
//        for(Enterprise e : network.getEnterpriseCatalog().getEnterpriseCatalog()){
//            if(e.getEnterpriseType().equals(Enterprise.EnterpriseType.Hospital)){
//                ((HospitalEnterprise) e).getRequestCatalog();
//                for(MedicineProduceRequest r : ((HospitalEnterprise) e).getRequestCatalog()){
//                    if(!r.getStatus().equals("Completed")){
//                         MedicineProduceTask task = new MedicineProduceTask();
//                    task.setId(r.getId());
//                    task.setMedicine(r.getMedicine());
//                    task.setAmount(r.getAmount());
//                    task.setRemaining(r.getAmount());
//                    task.setStatus("Producing");
//                    task.setReceiver(account);
//                    task.setSender(r.getSender());
//                    task.setRequestDate(r.getRequestDate());
//                    enterprise.getTaskCatalog().add(task);
//                    }
//                   
//                }
//            }
//        }
        for(MedicineProduceTask task : enterprise.getTaskCatalog()){
            Object[] row = new Object[3];
            //row[0] = task.getId();
            row[0] = task;
            row[1] = task.getAmount();
            if(task.getRemaining() == 0){
                task.setStatus("Completed");
                row[2] = task.getStatus();
            }
            else{
                task.setStatus("Producing");
                row[2] = task.getStatus();
            }
            
            model.addRow(row);
        }
    }
    
    public void populateStockTable(){
        DefaultTableModel model = (DefaultTableModel) stockJTable.getModel();
        model.setRowCount(0);
        for(MedicineStock stock : enterprise.getStockCatalog()){
            Object[] row = new Object[2];
            row[0] = stock;
            row[1] = stock.getAmount();
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
        medicineJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        medicinenameJTextField = new javax.swing.JTextField();
        addJButton = new javax.swing.JButton();
        removemedicineJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        taskJTable = new javax.swing.JTable();
        removetaskJButton = new javax.swing.JButton();
        assignJButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        testJTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        stockJTable = new javax.swing.JTable();
        deliverJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        medicinenameJTextField1 = new javax.swing.JTextField();
        medicineamountJTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        deliverAmountJTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 46));

        medicineJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine ID", "Medicine Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(medicineJTable);
        if (medicineJTable.getColumnModel().getColumnCount() > 0) {
            medicineJTable.getColumnModel().getColumn(0).setResizable(false);
            medicineJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 203));

        jLabel1.setText("Medicine");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 311, -1, -1));
        add(medicinenameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 306, 115, -1));

        addJButton.setText("Add");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        add(addJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 341, 98, -1));

        removemedicineJButton.setText("Remove");
        removemedicineJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removemedicineJButtonActionPerformed(evt);
            }
        });
        add(removemedicineJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 306, 88, -1));

        taskJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine Name", "Amount", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(taskJTable);
        if (taskJTable.getColumnModel().getColumnCount() > 0) {
            taskJTable.getColumnModel().getColumn(0).setResizable(false);
            taskJTable.getColumnModel().getColumn(1).setResizable(false);
            taskJTable.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 90, -1, 203));

        removetaskJButton.setText("Remove");
        removetaskJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removetaskJButtonActionPerformed(evt);
            }
        });
        add(removetaskJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(892, 300, 88, -1));

        assignJButton.setText("Assign");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });
        add(assignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 363, 88, -1));

        testJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine ID", "Medicine Name", "Clinical Test"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(testJTable);
        if (testJTable.getColumnModel().getColumnCount() > 0) {
            testJTable.getColumnModel().getColumn(0).setResizable(false);
            testJTable.getColumnModel().getColumn(1).setResizable(false);
            testJTable.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, -1, 203));

        stockJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock Name", "Stock Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(stockJTable);
        if (stockJTable.getColumnModel().getColumnCount() > 0) {
            stockJTable.getColumnModel().getColumn(0).setResizable(false);
            stockJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 540, -1, 203));

        deliverJButton.setText("Deliver");
        deliverJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliverJButtonActionPerformed(evt);
            }
        });
        add(deliverJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 750, -1, -1));

        jLabel2.setText("Medicine Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 305, -1, -1));
        add(medicinenameJTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 299, 115, -1));
        add(medicineamountJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 333, 115, -1));

        jLabel3.setText("Medicine Amount");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 339, -1, -1));

        jLabel4.setText("Amount");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 760, -1, -1));
        add(deliverAmountJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 750, 99, -1));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(231, 81, 86));
        jLabel5.setText("Available Produce Medicine ");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 68, -1, -1));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(231, 81, 86));
        jLabel6.setText("Clinical Test Result");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, -1, -1));

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(231, 81, 86));
        jLabel7.setText("Produce Task");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 68, -1, -1));

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(231, 81, 86));
        jLabel8.setText("Company Stock");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 520, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/flask.png"))); // NOI18N
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 420, 450, 460));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/pills-3.png"))); // NOI18N
        jLabel10.setText("jLabel10");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 470, 410));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/list.png"))); // NOI18N
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 570, 390));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/packing.png"))); // NOI18N
        jLabel12.setText("jLabel12");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 440, 510, 440));
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

    private void removemedicineJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removemedicineJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = medicineJTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Medicine medicine = (Medicine) medicineJTable.getValueAt(selectedRow, 1);
        enterprise.getMedicineCatalog().remove(medicine);
        populateMedicineTable();
    }//GEN-LAST:event_removemedicineJButtonActionPerformed

    private void removetaskJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removetaskJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = taskJTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        MedicineProduceTask task = (MedicineProduceTask) taskJTable.getValueAt(selectedRow, 0);
        enterprise.getTaskCatalog().remove(task);
        populateTaskTable();
    }//GEN-LAST:event_removetaskJButtonActionPerformed

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed
        // TODO add your handling code here:
        
        String medicineName = medicinenameJTextField1.getText();
        int amount = Integer.parseInt(medicineamountJTextField.getText());
        
        if(!medicineName.matches("[a-zA-Z]+")){
            JOptionPane.showMessageDialog(null, "Invalid medicine name!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if(amount <= 0){
            JOptionPane.showMessageDialog(null, "Invalid amount!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        MedicineProduceTask task = new MedicineProduceTask(medicineName,amount);
        task.setStatus("Pending");
        task.setRequestDate(new Date());
        enterprise.getTaskCatalog().add(task);
        populateTaskTable();
        medicinenameJTextField1.setText("");
        medicineamountJTextField.setText("");
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void deliverJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliverJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = stockJTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int amount = Integer.parseInt(deliverAmountJTextField.getText());
        
        if(amount <= 0){
            JOptionPane.showMessageDialog(null, "Invalid amount!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        MedicineStock stock = (MedicineStock) stockJTable.getValueAt(selectedRow, 0);
        MedicineStock destock = new MedicineStock();
        destock.setMedicine(stock.getMedicine());
        destock.setAmount(amount);
        if(stock.getAmount() - amount < 0){
            JOptionPane.showMessageDialog(null, "Stock is Not Enough!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        for(Enterprise e : network.getEnterpriseCatalog().getEnterpriseCatalog()){
            if(e.getEnterpriseType().equals(Enterprise.EnterpriseType.Hospital)){
                //destock.setAmount(amount);
               for(MedicineStock s : ((HospitalEnterprise) e).getStockCatalog()){
                   if(destock.getMedicine().getName().equals(s.getMedicine().getName())){
                       s.setAmount(s.getAmount()+amount);
                       stock.setAmount(stock.getAmount() - amount);
                       deliverAmountJTextField.setText("");
                       populateStockTable();
                       return;
                   }
               }
               ((HospitalEnterprise) e).getStockCatalog().add(destock);
            }
            
        }
        stock.setAmount(stock.getAmount() - amount);
        deliverAmountJTextField.setText("");
        populateStockTable();
    }//GEN-LAST:event_deliverJButtonActionPerformed

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        // TODO add your handling code here:
        String name = medicinenameJTextField.getText().trim();
        for(Organization organization : enterprise.getOrganizationCatalog().getOrganizationCatalog()){
            if(organization.getMedicineOrganizationType().equals(Enterprise.MedicineOrganizationType.Tester)){
                for(WorkRequest request : organization.getWorkQueue().getWorkRequestCatalog()){
                    if(((MedicineTestWorkRequest) request).getMedicine().getName().equals(name)){
                        Medicine medicine = new Medicine(name);
                        enterprise.getMedicineCatalog().add(medicine);
                        populateMedicineTable();
                        medicinenameJTextField.setText("");
                        return;
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, "no Such Medicine!!", "Warning", JOptionPane.WARNING_MESSAGE);
        populateMedicineTable();
        medicinenameJTextField.setText("");
        return;
    }//GEN-LAST:event_addJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton assignJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField deliverAmountJTextField;
    private javax.swing.JButton deliverJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable medicineJTable;
    private javax.swing.JTextField medicineamountJTextField;
    private javax.swing.JTextField medicinenameJTextField;
    private javax.swing.JTextField medicinenameJTextField1;
    private javax.swing.JButton removemedicineJButton;
    private javax.swing.JButton removetaskJButton;
    private javax.swing.JTable stockJTable;
    private javax.swing.JTable taskJTable;
    private javax.swing.JTable testJTable;
    // End of variables declaration//GEN-END:variables
}
