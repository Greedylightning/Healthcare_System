/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.EcoSystem;
import business.enterprise.Enterprise;
import business.enterprise.HealthcareEnterprise;
import business.network.Network;
import business.organization.CollectorOrganization;
import business.organization.Organization;
import business.useraccount.UserAccount;
import javax.swing.JPanel;
import userinterface.CollectorWorkArea.CollectorWorkAreaJPanel;

/**
 *
 * @author zack
 */
public class CollectorRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        return new CollectorWorkAreaJPanel(userProcessContainer, account, (CollectorOrganization)organization,(HealthcareEnterprise)enterprise);
    }
    
}
