/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CollectorWorkArea;

import au.com.bytecode.opencsv.CSVReader;
import business.disease.DiseaseSample;
import business.enterprise.HealthcareEnterprise;
import business.organization.CollectorOrganization;
import business.useraccount.UserAccount;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zack
 */
public class CollectorWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CollectorWorkAreaJPanel
     */
    JPanel userProcessContainer;
    UserAccount account;
    CollectorOrganization organization;
    HealthcareEnterprise enterprise;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public CollectorWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, CollectorOrganization organization,HealthcareEnterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        populateTable();
    }

    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel) JTable.getModel();
        model.setRowCount(0);
        for(DiseaseSample sample : enterprise.getSampleCatalog()){
            Object[] row = new Object[2];
            row[0] = sample.getId();
            row[1] = format.format(new Date());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        JTable = new javax.swing.JTable();
        importJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Sample ID", "Import Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(JTable);
        if (JTable.getColumnModel().getColumnCount() > 0) {
            JTable.getColumnModel().getColumn(0).setResizable(false);
            JTable.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 44, 1500, 620));

        importJButton.setText("Import Data");
        importJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importJButtonActionPerformed(evt);
            }
        });
        add(importJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, -1, -1));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(46, 78, 101));
        jLabel1.setText("Data Sample Collection");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 16, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/healthcare.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 760, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/network.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-290, -260, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void importJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importJButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        int sign = fileChooser.showDialog(CollectorWorkAreaJPanel.this, "comfirm");
        if(sign == 0){
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            FileReader fReader = null;
            try {
                fReader = new FileReader(file);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CollectorWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            CSVReader csvReader = new CSVReader(fReader);
            try {
                String[] strs = csvReader.readNext();
                if(strs != null && strs.length > 0){  
                    for(String str : strs)  
                        if(null != str && !str.equals(""))  
                            continue;  
                }  
                List<String[]> list = csvReader.readAll();
                for(String[] row : list){
                    if(row.length == 25){
                        DiseaseSample sample = new DiseaseSample(row);
                        enterprise.getSampleCatalog().add(sample);
                    }
                    //System.out.println(row.length);
                    
                }
            } catch (IOException ex) {
                Logger.getLogger(CollectorWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        populateTable();
    }//GEN-LAST:event_importJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTable;
    private javax.swing.JButton importJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
