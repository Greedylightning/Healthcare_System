/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.EcoSystem;
import business.enterprise.Enterprise;
import business.network.Network;
import business.organization.Organization;
import business.useraccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author zack
 */
public abstract class Role {
    
    public enum HospitalRoleType{
        HospitalManager("Hospital Manager"),
        Doctor("Doctor"),
        Nurse("Nurse"),
        LabAssistant("Lab Assistant"),
        Patient("Patient");
        
        private String value;
        private HospitalRoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public enum MedicineRoleType{
        CompanyManager("Medicine Company Manager"),
        Researcher("Researcher"),
        Worker("Worker"),
        ClinicalTester("Clinical Tester");
        
        private String value;
        private MedicineRoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public enum HealthcareRoleType{
        HealthcareManager("Healthcare Community Manager"),
        Collector("Data Collector"),
        Analyst("Data Analyst");
        
        private String value;
        private HealthcareRoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
        UserAccount account, 
        Organization organization, 
        Enterprise enterprise,
        Network network,
        EcoSystem business);
    
    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
