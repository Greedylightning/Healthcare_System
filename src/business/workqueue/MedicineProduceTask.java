/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workqueue;

/**
 *
 * @author zack
 */
public class MedicineProduceTask extends MedicineTestWorkRequest{
    
    private int id;
    private int amount;
    private int remaining;
    
    private int count = 1;
    
    public MedicineProduceTask(){
        id = count++;
    }

    public MedicineProduceTask(String name,int amount){
        id = count++;
        this.getMedicine().setName(name);
        this.amount = amount;
        this.remaining = amount;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }
    
    @Override
    public String toString(){
        return this.getMedicine().getName();
    }
}
