/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.employee.Employee;
import business.role.SystemAdminRole;
import business.useraccount.UserAccount;
import business.useraccount.UserAccountCatalog;

/**
 *
 * @author zack
 */
public class ConfigureBusiness {
    
    public static EcoSystem configure(){
        EcoSystem system = EcoSystem.getInstance();
        
        Employee employee = system.getEmployeeCatalog().createEmployee("dongqi");
        UserAccountCatalog userAccountCatalog = system.getUserAccountCatalog();
        UserAccount ua = userAccountCatalog.createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        return system;
    }
}
