/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.medicine;

/**
 *
 * @author zack
 */
public class MedicineStock {
    
    private int id;
    private int amount;
    private Medicine medicine;
    
    private int count = 1;
    
    public MedicineStock(){
        id = count++;
        medicine = new Medicine();
    }
    
    public MedicineStock(String name,int amount){
        id = count++;
        this.amount = amount;
        medicine = new Medicine(name);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
    
    @Override
    public String toString(){ 
        return medicine.getName();
    }
}
