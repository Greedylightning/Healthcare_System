/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.useraccount;

import business.employee.Employee;
import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author zack
 */
public class UserAccountCatalog {
    
    private ArrayList<UserAccount> userAccountCatalog;
    
    public UserAccountCatalog() {
        userAccountCatalog = new ArrayList();
    }

    public ArrayList<UserAccount> getUserAccountCatalog() {
        return userAccountCatalog;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountCatalog)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public UserAccount createUserAccount(String username, String password, Employee employee, Role role){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        userAccountCatalog.add(userAccount);
        return userAccount;
    }
}
