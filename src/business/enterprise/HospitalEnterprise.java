/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.medicine.MedicineStock;
import business.workqueue.MedicineProduceRequest;
import java.util.ArrayList;

/**
 *
 * @author zack
 */
public class HospitalEnterprise extends Enterprise{
    
    private ArrayList<MedicineStock> stockCatalog;
    private ArrayList<MedicineProduceRequest> requestCatalog;
    
    public HospitalEnterprise(String name){
        super(name,EnterpriseType.Hospital);
        stockCatalog = new ArrayList<>();
        requestCatalog = new ArrayList<>();
    }

    public ArrayList<MedicineStock> getStockCatalog() {
        return stockCatalog;
    }

    public void setStockCatalog(ArrayList<MedicineStock> stockCatalog) {
        this.stockCatalog = stockCatalog;
    }

    public ArrayList<MedicineProduceRequest> getRequestCatalog() {
        return requestCatalog;
    }

    public void setRequestCatalog(ArrayList<MedicineProduceRequest> requestCatalog) {
        this.requestCatalog = requestCatalog;
    }
    
    
}
