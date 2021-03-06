/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import business.EcoSystem;
import business.employee.Employee;
import business.network.Network;
import business.role.CountrySystemAdminRole;
import business.useraccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zack
 */
public class ManageCountryAdminJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageCountryAdminJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem system;
    
    public ManageCountryAdminJPanel(JPanel userProcessContainer,EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        populateTable();
        populateCountryComoBox();
    }

    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) JTable.getModel();
        model.setRowCount(0);
        for(Network network : system.getNetworkCatalog()){
            for(UserAccount userAccount : network.getUserAccountCatalog().getUserAccountCatalog()){
                Object[] row = new Object[2];
                row[0] = network.getCountryName();
                row[1] = userAccount.getUsername();
                model.addRow(row);
            }
        }
    }
    
    private void populateCountryComoBox(){
        countryJComboBox.removeAllItems();
        for(Network network : system.getNetworkCatalog()){
            countryJComboBox.addItem(network);
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
        countryJLabel = new javax.swing.JLabel();
        usernameJLabel = new javax.swing.JLabel();
        usernameJTextField = new javax.swing.JTextField();
        passwordJLabel = new javax.swing.JLabel();
        passwordJPasswordField = new javax.swing.JPasswordField();
        countryJComboBox = new javax.swing.JComboBox();
        submitJButton = new javax.swing.JButton();
        resetJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, -1, 46));

        countryJLabel.setText("Country");
        add(countryJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, -1, -1));

        usernameJLabel.setText("Username");
        add(usernameJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, -1, -1));
        add(usernameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, 136, -1));

        passwordJLabel.setText("Password");
        add(passwordJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, -1, -1));
        add(passwordJPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, 136, -1));

        countryJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        countryJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryJComboBoxActionPerformed(evt);
            }
        });
        add(countryJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, 136, -1));

        submitJButton.setText("Submit");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        add(submitJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, -1, -1));

        resetJButton.setText("Reset");
        resetJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetJButtonActionPerformed(evt);
            }
        });
        add(resetJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 460, 88, -1));

        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Country", "Username"
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 437, 150));

        jLabel1.setText("Employee Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, -1, -1));
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, 136, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        // TODO add your handling code here:
        Network network = (Network) countryJComboBox.getSelectedItem();

        String name = nameJTextField.getText().trim();
        String username = usernameJTextField.getText();
        String password = String.valueOf(passwordJPasswordField.getPassword());
        
        if(!name.matches("[a-zA-Z]+")){
            JOptionPane.showMessageDialog(null, "Invalid employee name!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Employee employee = network.getEmployeeCatalog().createEmployee(name);
        UserAccount account = network.getUserAccountCatalog().createUserAccount(username, password, employee, new CountrySystemAdminRole());

        populateTable();
        nameJTextField.setText("");
        usernameJTextField.setText("");
        passwordJPasswordField.setText("");

    }//GEN-LAST:event_submitJButtonActionPerformed

    private void resetJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetJButtonActionPerformed
        // TODO add your handling code here:
        nameJTextField.setText("");
        usernameJTextField.setText("");
        passwordJPasswordField.setText("");
    }//GEN-LAST:event_resetJButtonActionPerformed

    private void countryJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryJComboBoxActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_countryJComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTable;
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox countryJComboBox;
    private javax.swing.JLabel countryJLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JLabel passwordJLabel;
    private javax.swing.JPasswordField passwordJPasswordField;
    private javax.swing.JButton resetJButton;
    private javax.swing.JButton submitJButton;
    private javax.swing.JLabel usernameJLabel;
    private javax.swing.JTextField usernameJTextField;
    // End of variables declaration//GEN-END:variables
}
