/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.organization.Organization;
import static business.organization.Organization.HospitalOrganizationType.Patient;
import business.organization.OrganizationCatalog;
import static business.role.Role.HospitalRoleType.Patient;
import business.useraccount.UserAccount;

/**
 *
 * @author zack
 */
public class Enterprise extends business.organization.Organization{
    
    private String name;
    private EnterpriseType enterpriseType;
    private OrganizationCatalog organizationCatalog;
    
    public Enterprise(String name,EnterpriseType type){
        super(name);
        this.name = name;
        this.enterpriseType = type;
        organizationCatalog = new OrganizationCatalog();
    }
    
    public enum EnterpriseType{
        
        Hospital("Hospital"),
        Medicine_Company("Medicine Company"),
        Healthcare_Community("Healthcare Community");
        
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
        
        private EnterpriseType(String value){
            this.value = value;
        }
        
        @Override
        public String toString(){
            return value;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public OrganizationCatalog getOrganizationCatalog() {
        return organizationCatalog;
    }
    
    public Organization getSelectedOrganization(String name){
        for(Organization o : organizationCatalog.getOrganizationCatalog()){
            if(o.getName().equals(name)) return o;
        }
        return null;
    }
    
    public UserAccount getSelectedPatient(String name){
        for(Organization organization : organizationCatalog.getOrganizationCatalog()){
            if(organization.getHospitalOrganizationType().equals(Organization.HospitalOrganizationType.Patient)){
                for(UserAccount useraccount : organization.getUserAccountCatalog().getUserAccountCatalog()){
                    if(useraccount.getEmployee().getName().equals(name)) return useraccount;
                }
            }
        }
        return null;
    }
    
    
    @Override
    public String toString(){
        return name;
    }
}
