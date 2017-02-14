/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.network.Network;
import java.util.ArrayList;

/**
 *
 * @author zack
 */
public class EcoSystem extends business.organization.Organization{
    
    private static EcoSystem business;
    private ArrayList<Network> networkCatalog;
    
    private EcoSystem(){
        super(null);
        networkCatalog = new ArrayList<Network>();
    }
    
    public static EcoSystem getInstance(){
        if(business == null){
            business = new EcoSystem();
        }
        return business;
    }

    public ArrayList<Network> getNetworkCatalog() {
        return networkCatalog;
    }

    public void setNetworkCatalog(ArrayList<Network> networkCatalog) {
        this.networkCatalog = networkCatalog;
    }
    
    public Network addNetwork(String name){
        Network network = new Network(name);
        networkCatalog.add(network);
        return network;
    }
}
