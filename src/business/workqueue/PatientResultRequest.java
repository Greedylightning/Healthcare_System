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
public class PatientResultRequest extends WorkRequest{
    
    private String patientResult;
    private String doctorName;
    private String checkDate;

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    
    
    public String getPatientResult() {
        return patientResult;
    }

    public void setPatientResult(String patientResult) {
        this.patientResult = patientResult;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

   
    
    
}
