/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.EcoSystem;
import business.enterprise.Enterprise;
import business.network.Network;
import business.organization.NurseOrganization;
import business.organization.Organization;
import business.useraccount.UserAccount;
import java.util.ArrayList;
import javax.swing.JPanel;
import userinterface.NurseWorkArea.NurseWorkAreaJPanel;

/**
 *
 * @author zack
 */
public class NurseRole extends Role{

    
    private ArrayList<UserAccount> myCareCatalog;
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        return new NurseWorkAreaJPanel(userProcessContainer, account, (NurseOrganization)organization,enterprise);
    }

    public NurseRole(){
        myCareCatalog = new ArrayList<>();
    }
    
    public ArrayList<UserAccount> getMyCareCatalog() {
        return myCareCatalog;
    }

    public void setMyCareCatalog(ArrayList<UserAccount> myCareCatalog) {
        this.myCareCatalog = myCareCatalog;
    }
    
    
}
