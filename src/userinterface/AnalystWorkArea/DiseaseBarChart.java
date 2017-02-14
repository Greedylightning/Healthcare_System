/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AnalystWorkArea;

import business.disease.DiseaseSample;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author zack
 */
public class DiseaseBarChart {
    
    ChartPanel frame;
    String xaxis;
    ArrayList<DiseaseSample> sampleCatalog;
    public  DiseaseBarChart(String xaxis,ArrayList<DiseaseSample> sampleCatalog){
        this.xaxis = xaxis;
        this.sampleCatalog = sampleCatalog;
	CategoryDataset dataset = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D(
       		            "Disease Bar Chart", // 图表标题
                            xaxis, // 目录轴的显示标签
                            "Count", // 数值轴的显示标签
                            dataset, // 数据集
                            PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                            true,           // 是否显示图例(对于简单的柱状图必须是false)
                            false,          // 是否生成工具
                            false           // 是否生成URL链接
                            );
          
         frame = new ChartPanel(chart,true);        //这里也可以用chartFrame,可以直接生成一个独立的Frame
         frame.setVisible(true);
	}

    public  DiseaseBarChart(String c1,String c2,ArrayList<DiseaseSample> sampleCatalog){
        this.xaxis = "country";
        this.sampleCatalog = sampleCatalog;
	CategoryDataset dataset = getCompareDataSet(c1,c2);
        JFreeChart chart = ChartFactory.createBarChart3D(
       		            c1+" vs "+c2, // 图表标题
                            xaxis, // 目录轴的显示标签
                            "Count", // 数值轴的显示标签
                            dataset, // 数据集
                            PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                            true,           // 是否显示图例(对于简单的柱状图必须是false)
                            false,          // 是否生成工具
                            false           // 是否生成URL链接
                            );
          
         frame = new ChartPanel(chart,true);        //这里也可以用chartFrame,可以直接生成一个独立的Frame
         frame.setVisible(true);
	}
    
     public  DiseaseBarChart(String name,ArrayList<DiseaseSample> sampleCatalog,String flag){
        //this.xaxis = xaxis;
        this.sampleCatalog = sampleCatalog;
	CategoryDataset dataset = getMyCountryDataSet(name);
        JFreeChart chart = ChartFactory.createBarChart3D(
       		            name+" Disease Bar Chart", // 图表标题
                            xaxis, // 目录轴的显示标签
                            "Count", // 数值轴的显示标签
                            dataset, // 数据集
                            PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                            true,           // 是否显示图例(对于简单的柱状图必须是false)
                            false,          // 是否生成工具
                            false           // 是否生成URL链接
                            );
          
         frame = new ChartPanel(chart,true);        //这里也可以用chartFrame,可以直接生成一个独立的Frame
         frame.setVisible(true);
	}
    
    private CategoryDataset getMyCountryDataSet(String c){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        HashSet<DiseaseSample> set = new HashSet();
        for(DiseaseSample sample : sampleCatalog){
            if(sample.getCountryCode().equals(c)){
                set.add(sample);
            }
        }
        Iterator<DiseaseSample> p = set.iterator();
        Map<String,Integer> map = new HashMap<>();
        while(p.hasNext()){
            DiseaseSample s = p.next();
            
                if(map.containsKey(s.getVirusType())){
                    map.put(s.getVirusType(),map.get(s.getVirusType())+1);
                }
                else{
                    map.put(s.getVirusType(),1);
                }
            
            
        }
        Iterator<String> p2 = map.keySet().iterator();
        while(p2.hasNext()){
            String name = p2.next();
            int number = map.get(name);
            dataset.addValue(number,name,"sample");
        }
        return dataset;
    }
    
    private CategoryDataset getCompareDataSet(String c1,String c2){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Map<String,Integer> map = new HashMap<>();
        map.put(c1, 0);
        map.put(c2, 0);
        for(DiseaseSample sample : sampleCatalog){
            if(sample.getCountryCode().equals(c1)){
                map.put(c1,map.get(c1)+1);
            }
            else if(sample.getCountryCode().equals(c2)){
                map.put(c2, map.get(c2)+1);
            }
        }
        Iterator<String> p = map.keySet().iterator();
        while(p.hasNext()){
            String name = p.next();
            int number = map.get(name);
            dataset.addValue(number,name,"sample");
        }
        return dataset;
    }
    
    private CategoryDataset getDataSet() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Map<String,Integer> map = new HashMap<>();
        if(xaxis.equals("CountryCode")){
            for(DiseaseSample sample : sampleCatalog){
                if(map.containsKey(sample.getCountryCode())){
                    map.put(sample.getCountryCode(), map.get(sample.getCountryCode())+1);
                }
                else{
                    map.put(sample.getCountryCode(),1);
                }
            }
        }
//        else if(xaxis.equals("GeographicArea")){
//            for(DiseaseSample sample : sampleCatalog){
//                if(map.containsKey(sample.getGeographicArea())){
//                    map.put(sample.getGeographicArea(), map.get(sample.getGeographicArea())+1);
//                }
//                else{
//                    map.put(sample.getGeographicArea(),1);
//                }
//            }
//        }
        else if(xaxis.equals("Sex")){
            for(DiseaseSample sample : sampleCatalog){
                if(map.containsKey(sample.getSex())){
                    map.put(sample.getSex(), map.get(sample.getSex())+1);
                }
                else{
                    map.put(sample.getSex(),1);
                }
            }
        }
        else if(xaxis.equals("Age")){
            for(DiseaseSample sample : sampleCatalog){
                if(map.containsKey(sample.getAge())){
                    map.put(sample.getAge(), map.get(sample.getAge())+1);
                }
                else{
                    map.put(sample.getAge(),1);
                }
            }
        }
        else if(xaxis.equals("VirusType")){
            for(DiseaseSample sample : sampleCatalog){
                if(map.containsKey(sample.getVirusType())){
                    map.put(sample.getVirusType(), map.get(sample.getVirusType())+1);
                }
                else{
                    map.put(sample.getVirusType(),1);
                }
            }
        }
        else{
            ;
        }
        Iterator<String> p = map.keySet().iterator();
        while(p.hasNext()){
            String name = p.next();
            int number = map.get(name);
            dataset.addValue(number,name,"sample");
        }        
        return dataset;
    }
    
    public ChartPanel getChartPanel(){
	return frame;
	
}
}
