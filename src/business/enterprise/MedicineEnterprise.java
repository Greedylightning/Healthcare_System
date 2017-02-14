/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.medicine.Medicine;
import business.medicine.MedicineStock;
import business.workqueue.MedicineProduceTask;
import java.util.ArrayList;

/**
 *
 * @author zack
 */
public class MedicineEnterprise extends Enterprise{
    
    private ArrayList<Medicine> medicineCatalog;
    private ArrayList<MedicineProduceTask> taskCatalog;
    private ArrayList<MedicineStock> stockCatalog;

    public ArrayList<MedicineStock> getStockCatalog() {
        return stockCatalog;
    }

    public void setStockCatalog(ArrayList<MedicineStock> stockCatalog) {
        this.stockCatalog = stockCatalog;
    }
    
    
    
    public MedicineEnterprise(String name){
        super(name,EnterpriseType.Medicine_Company);
        medicineCatalog = new ArrayList<>();
        taskCatalog = new ArrayList<>();
        stockCatalog = new ArrayList<>();
    }

    public ArrayList<MedicineProduceTask> getTaskCatalog() {
        return taskCatalog;
    }

    public void setTaskCatalog(ArrayList<MedicineProduceTask> taskCatalog) {
        this.taskCatalog = taskCatalog;
    }

    
    
    public ArrayList<Medicine> getMedicineCatalog() {
        return medicineCatalog;
    }

    public void setMedicineCatalog(ArrayList<Medicine> medicineCatalog) {
        this.medicineCatalog = medicineCatalog;
    }
    
    public void addStock(MedicineStock stock){
        for(MedicineStock s : stockCatalog){
            if(s.getMedicine().getName().equals(stock.getMedicine().getName())){
                s.setAmount(s.getAmount() + stock.getAmount());
                return;
            }
        }
        stockCatalog.add(stock);
    }
}
