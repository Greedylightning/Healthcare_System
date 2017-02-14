/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workqueue;

import business.employee.Employee;
import java.util.ArrayList;

/**
 *
 * @author zack
 */
public class WorkQueue {
    
    private ArrayList<WorkRequest> workRequestCatalog;
   

   
    
    
    
    public WorkQueue() {
        workRequestCatalog = new ArrayList();
        
    }

    public ArrayList<WorkRequest> getWorkRequestCatalog() {
        return workRequestCatalog;
    }
    
  
}
