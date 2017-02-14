/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workqueue;

import business.medicine.Medicine;

/**
 *
 * @author zack
 */
public class MedicineTestWorkRequest extends WorkRequest{
    
    private Medicine medicine;
    private String result;
    private String comment;

    public MedicineTestWorkRequest(){
        medicine = new Medicine();
    }
    
    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
    
    public String toString(){
        return medicine.getName();
    }
}
