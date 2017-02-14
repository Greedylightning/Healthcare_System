/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.disease.DiseaseSample;
import java.util.ArrayList;



/**
 *
 * @author zack
 */
public class HealthcareEnterprise extends Enterprise{
    
    private ArrayList<DiseaseSample> sampleCatalog;
    
    public HealthcareEnterprise(String name){
        super(name,EnterpriseType.Healthcare_Community);
        sampleCatalog = new ArrayList<>();
    }

    public ArrayList<DiseaseSample> getSampleCatalog() {
        return sampleCatalog;
    }

    public void setSampleCatalog(ArrayList<DiseaseSample> sampleCatalog) {
        this.sampleCatalog = sampleCatalog;
    }
    
    
}
