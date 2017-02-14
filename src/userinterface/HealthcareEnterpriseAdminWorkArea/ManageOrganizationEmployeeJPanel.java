/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.HealthcareEnterpriseAdminWorkArea;

import business.employee.Employee;
import business.enterprise.Enterprise;
import business.enterprise.HealthcareEnterprise;
import business.organization.Organization;
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
public class ManageOrganizationEmployeeJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageOrganizationEmployeeJPanel
     */
    JPanel userProcessContainer;
    HealthcareEnterprise enterprise;
    
    public ManageOrganizationEmployeeJPanel(JPanel userProcessContainer,HealthcareEnterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        populateTable();
    }

    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel) JTable.getModel();
        model.setRowCount(0);
        for(Organization organization : enterprise.getOrganizationCatalog().getOrganizationCatalog()){
            for(UserAccount userAccount : organization.getUserAccountCatalog().getUserAccountCatalog()){
                Object[] row = new Object[3];
                row[0] = organization.getName();
                row[1] = userAccount.getEmployee().getName();
                row[2] = userAccount.getRole();
                model.addRow(row);
            }
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
        JTable = new javax.swing.JTable();
        removeJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        genderJComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        birthdayJTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        phonenumberJTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        emailJTextField = new javax.swing.JTextField();
        submitJButton = new javax.swing.JButton();

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Organization Name", "Employee Name", "Role"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(JTable);

        removeJButton.setText("Remove");
        removeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeJButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Gender");

        genderJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "male", "female" }));

        jLabel2.setText("Birthday");

        jLabel3.setText("Phonenumber");

        jLabel4.setText("Email");

        submitJButton.setText("Submit");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backJButton)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(removeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(submitJButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel1))
                                    .addComponent(jLabel3))
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(phonenumberJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(54, 54, 54)
                                        .addComponent(jLabel4)
                                        .addGap(6, 6, 6)
                                        .addComponent(emailJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(genderJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(birthdayJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(239, 239, 239))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(genderJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(birthdayJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(phonenumberJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(emailJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(submitJButton)
                .addContainerGap())
        );
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

    private void removeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = JTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String employeeName = (String) JTable.getValueAt(selectedRow, 1);
        String organizationName = (String) JTable.getValueAt(selectedRow, 0);
        UserAccount ua = null;
        for(Organization organization : enterprise.getOrganizationCatalog().getOrganizationCatalog()){
            if(organization.getName().equals(organizationName)){
                for(UserAccount useraccount : organization.getUserAccountCatalog().getUserAccountCatalog()){
                    if(useraccount.getEmployee().getName().equals(employeeName)){
                        ua = useraccount;
                        break;
                    }
                }
            }
            if(ua != null){
                break;
            }
        }
        for(Organization organization : enterprise.getOrganizationCatalog().getOrganizationCatalog()){
            if(organization.getName().equals(organizationName)){
                organization.getEmployeeCatalog().getEmployeeCatalog().remove(ua.getEmployee());
                organization.getUserAccountCatalog().getUserAccountCatalog().remove(ua);
                break;
            }
        }
        populateTable();
    }//GEN-LAST:event_removeJButtonActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = JTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String name = (String) JTable.getValueAt(selectedRow, 1);
        String gender =  (String) genderJComboBox.getSelectedItem();
        String birthday = birthdayJTextField.getText();
        String phonenumber = phonenumberJTextField.getText();
        String email = emailJTextField.getText();
        
        if(phonenumber.length() != 10){
            JOptionPane.showMessageDialog(null, "Invalid phone number!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(!email.contains("@")){
            JOptionPane.showMessageDialog(null, "Invalid email!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        for(Organization organization : enterprise.getOrganizationCatalog().getOrganizationCatalog()){
            for(Employee employee : organization.getEmployeeCatalog().getEmployeeCatalog()){
                if(employee.getName().equals(name)){
                    employee.setGender(gender);
                    employee.setBirthday(birthday);
                    employee.setPhonenumber(phonenumber);
                    employee.setEmail(email);
                    JOptionPane.showMessageDialog(null, "Change Saved!!", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        birthdayJTextField.setText("");
        phonenumberJTextField.setText("");
        emailJTextField.setText("");
    }//GEN-LAST:event_submitJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTable;
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField birthdayJTextField;
    private javax.swing.JTextField emailJTextField;
    private javax.swing.JComboBox genderJComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField phonenumberJTextField;
    private javax.swing.JButton removeJButton;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}
