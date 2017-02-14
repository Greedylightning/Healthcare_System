/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import java.util.ArrayList;

/**
 *
 * @author zack
 */
public class EnterpriseCatalog {
    
    private ArrayList<Enterprise> enterpriseCatalog;
    
    public EnterpriseCatalog(){
        enterpriseCatalog = new ArrayList<Enterprise>();
    }

    public ArrayList<Enterprise> getEnterpriseCatalog() {
        return enterpriseCatalog;
    }

    public void setEnterpriseCatalog(ArrayList<Enterprise> enterpriseCatalog) {
        this.enterpriseCatalog = enterpriseCatalog;
    }
    
    public Enterprise createEnterprise(String name,Enterprise.EnterpriseType type){
        Enterprise enterprise = null;
        if(type == Enterprise.EnterpriseType.Hospital){
            enterprise = new HospitalEnterprise(name);
            enterpriseCatalog.add(enterprise);
        }
        else if(type == Enterprise.EnterpriseType.Medicine_Company){
            enterprise = new MedicineEnterprise(name);
            enterpriseCatalog.add(enterprise);
        }
        else if(type == Enterprise.EnterpriseType.Healthcare_Community){
            enterprise = new HealthcareEnterprise(name);
            enterpriseCatalog.add(enterprise);
        }
        else{
        ;}
        return enterprise;
    }
}
