/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import au.com.bytecode.opencsv.CSVReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
/**
 *
 * @author zack
 */
public class ReadCSV {  
    public static void main(String[] args) throws Exception {  
        File file = new File("/Users/zack/Downloads/HIV_02DEC16_19_13_06_75.csv");  
        FileReader fReader = new FileReader(file);  
        CSVReader csvReader = new CSVReader(fReader);  
        String[] strs = csvReader.readNext();  
        if(strs != null && strs.length > 0){  
            for(String str : strs)  
                if(null != str && !str.equals(""))  
                    System.out.print(str + " , ");  
            System.out.println("\n---------------");  
        }  
        List<String[]> list = csvReader.readAll();  
        for(String[] ss : list){  
            for(String s : ss)  
                if(null != s && !s.equals(""))  
                    System.out.print(s + " , ");  
            System.out.println();  
        }  
        csvReader.close();  
    }  
}  