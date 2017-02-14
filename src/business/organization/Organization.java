/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.employee.EmployeeCatalog;
import business.useraccount.UserAccountCatalog;
import business.workqueue.WorkQueue;

/**
 *
 * @author zack
 */
public class Organization {
    
    private int organizationID;
    private String name;
    private EmployeeCatalog employeeCatalog;
    private UserAccountCatalog userAccountCatalog;
    private WorkQueue workQueue;
    private HospitalOrganizationType hospitalOrganizationType;
    private MedicineOrganizationType MedicineOrganizationType;
    private HealthcareOrganizationType healthcareOrganizationType;
    private String organizationChief;

    public MedicineOrganizationType getMedicineOrganizationType() {
        return MedicineOrganizationType;
    }

    public void setMedicineOrganizationType(MedicineOrganizationType MedicineOrganizationType) {
        this.MedicineOrganizationType = MedicineOrganizationType;
    }

    
    
    public HospitalOrganizationType getHospitalOrganizationType() {
        return hospitalOrganizationType;
    }

    public void setHospitalOrganizationType(HospitalOrganizationType hospitalOrganizationType) {
        this.hospitalOrganizationType = hospitalOrganizationType;
    }

    
    public String getOrganizationChief() {
        return organizationChief;
    }

    public void setOrganizationChief(String organizationChief) {
        this.organizationChief = organizationChief;
    }

    public HealthcareOrganizationType getHealthcareOrganizationType() {
        return healthcareOrganizationType;
    }

    public void setHealthcareOrganizationType(HealthcareOrganizationType healthcareOrganizationType) {
        this.healthcareOrganizationType = healthcareOrganizationType;
    }
    
    
    
    public enum HealthcareOrganizationType{
        
        Collector("Collector Organization"),
        Analyst("Analyst Organization"),
        Manager("Admin Organization");
        
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
        
        private HealthcareOrganizationType(String value){
            this.value = value;
        }
        
        @Override
        public String toString(){
            return value;
        }
    }
    
    public enum HospitalOrganizationType{
        
        Doctor("Doctor Organization"),
        Assistant("Lab Assistant Lab"),
        Nurse("Nurse Organization"),
        Patient("Patient Organization");
        //Manager("Admin Organization");
        
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
        
        private HospitalOrganizationType(String value){
            this.value = value;
        }
        
        @Override
        public String toString(){
            return value;
        }
    }
    
    public enum MedicineOrganizationType{
        
        Researcher("Researcher Organization"),
        Worker("Worker Organization"),
        Tester("Tester Organization"),
        Manager("Admin Organization");
        //Manager("Admin Organization");
        
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
        
        private MedicineOrganizationType(String value){
            this.value = value;
        }
        
        @Override
        public String toString(){
            return value;
        }
    }
    
    private static int count = 1;
    
    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        employeeCatalog = new EmployeeCatalog();
        userAccountCatalog = new UserAccountCatalog();
        organizationID = count++;
    }
    
    public Organization(String name,HospitalOrganizationType type) {
        this.name = name;
        this.hospitalOrganizationType = type;
        workQueue = new WorkQueue();
        employeeCatalog = new EmployeeCatalog();
        userAccountCatalog = new UserAccountCatalog();
        organizationID = count++;
    }
    
    public Organization(String name,MedicineOrganizationType type) {
        this.name = name;
        this.MedicineOrganizationType = type;
        workQueue = new WorkQueue();
        employeeCatalog = new EmployeeCatalog();
        userAccountCatalog = new UserAccountCatalog();
        organizationID = count++;
    }
    
    public Organization(String name,HealthcareOrganizationType type) {
        this.name = name;
        this.healthcareOrganizationType = type;
        workQueue = new WorkQueue();
        employeeCatalog = new EmployeeCatalog();
        userAccountCatalog = new UserAccountCatalog();
        organizationID = count++;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeCatalog getEmployeeCatalog() {
        return employeeCatalog;
    }

    public UserAccountCatalog getUserAccountCatalog() {
        return userAccountCatalog;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }
    
    @Override
    public String toString(){
        return name;
    }
}
