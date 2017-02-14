/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.employee;

import java.util.ArrayList;

/**
 *
 * @author zack
 */
public class EmployeeCatalog {
    
    private ArrayList<Employee> employeeCatalog;
    
    public EmployeeCatalog() {
        employeeCatalog = new ArrayList();
    }

    public ArrayList<Employee> getEmployeeCatalog() {
        return employeeCatalog;
    }
    
    public Employee createEmployee(String name){
        Employee employee = new Employee();
        employee.setName(name);
        employeeCatalog.add(employee);
        return employee;
    }
}
