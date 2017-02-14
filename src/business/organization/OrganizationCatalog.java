/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import java.util.ArrayList;

/**
 *
 * @author zack
 */
public class OrganizationCatalog {
    
    private ArrayList<Organization> organizationCatalog;
    
    public OrganizationCatalog() {
        organizationCatalog = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationCatalog() {
        return organizationCatalog;
    }
    
    public void addOrganization(String name,Organization.HospitalOrganizationType type){
        Organization organization = null;
        if(type == Organization.HospitalOrganizationType.Doctor){
            organization = new DoctorOrganization(name,type);
            organizationCatalog.add(organization);
        }
        else if(type == Organization.HospitalOrganizationType.Assistant){
            organization = new AssistantOrganization(name,type);
            organizationCatalog.add(organization);
        }
        else if(type == Organization.HospitalOrganizationType.Nurse){
            organization = new NurseOrganization(name,type);
            organizationCatalog.add(organization);
        }
        else if(type == Organization.HospitalOrganizationType.Patient){
            organization = new PatientOrganization(name,type);
            organizationCatalog.add(organization);
        }
//        else if(type == Organization.HospitalOrganizationType.Manager){
//            organization = new ManagerOrganization(name,chief);
//            organizationCatalog.add(organization);
//        }
    }
    
    public void addOrganization(String name,Organization.MedicineOrganizationType type){
        Organization organization = null;
        if(type == Organization.MedicineOrganizationType.Researcher){
            organization = new ResearcherOrganization(name,type);
            organizationCatalog.add(organization);
        }
        else if(type == Organization.MedicineOrganizationType.Worker){
            organization = new WorkerOrganization(name,type);
            organizationCatalog.add(organization);
        }
        else if(type == Organization.MedicineOrganizationType.Tester){
            organization = new TesterOrganization(name,type);
            organizationCatalog.add(organization);
        }
        else{
            ;
        }
    }
    
    public void addOrganization(String name,Organization.HealthcareOrganizationType type){
        Organization organization = null;
        if(type == Organization.HealthcareOrganizationType.Collector){
            organization = new CollectorOrganization(name, type);
            organizationCatalog.add(organization);
        }
        else if(type == Organization.HealthcareOrganizationType.Analyst){
            organization = new AnalystOrganization(name, type);
            organizationCatalog.add(organization);
        }
        else{
            ;
        }
    }
}
