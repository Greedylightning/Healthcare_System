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
public class Medicine {
    
    private int id;
    private String name;
    private String formula;
    private String uses;
    private String description;
    private String indication;
    
    private int count = 1;
    
    public Medicine(String name){
        this.name = name;
        this.id = count++;
    }

    public Medicine(){
        this.id = count++;
    }
    
    public Medicine(String name,String description,String formula,String uses){
        this.name = name;
        this.description = description;
        this.formula = formula;
        this.uses = uses;
        this.id = count++;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getUses() {
        return uses;
    }

    public void setUses(String uses) {
        this.uses = uses;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    
    
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString(){
        return name;
    }
}
