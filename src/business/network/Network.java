/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.network;

import business.enterprise.EnterpriseCatalog;

/**
 *
 * @author zack
 */
public class Network extends business.organization.Organization{
    
    private int countryID;
    private String countryName;
    private static int count = 1;
    private EnterpriseCatalog enterpriseCatalog;
    
    public Network(String name){
        super(name);
        countryID = count++;
        countryName = name;
        enterpriseCatalog = new EnterpriseCatalog();
    }
    
    

    public int getCountryID() {
        return countryID;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public EnterpriseCatalog getEnterpriseCatalog() {
        return enterpriseCatalog;
    }

    @Override
    public String toString(){
        return countryName;
    }
    
    
}
