/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AnalystWorkArea;

/**
 *
 * @author zack
 */
import business.disease.DiseaseSample;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class DiseasePieChart {
	ChartPanel frame;
        String para;
        ArrayList<DiseaseSample> sampleCatalog;
        
	public DiseasePieChart(String para,ArrayList<DiseaseSample> sampleCatalog){
            this.para = para;
            this.sampleCatalog = sampleCatalog;
              DefaultPieDataset data = getDataSet(para,sampleCatalog);
	      JFreeChart chart = ChartFactory.createPieChart("Disease Pie Chart",data,true,false,false);
              
	    //设置百分比
	      PiePlot pieplot = (PiePlot) chart.getPlot();
	      DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题
	      NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象
	      StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象
	      pieplot.setLabelGenerator(sp1);//设置饼图显示百分比
	  
	  //没有数据的时候显示的内容
	      pieplot.setNoDataMessage("无数据显示");
	      pieplot.setCircular(false);
	      pieplot.setLabelGap(0.02D);
	  
	      pieplot.setIgnoreNullValues(true);//设置不显示空值
	      pieplot.setIgnoreZeroValues(true);//设置不显示负值
	      frame = new ChartPanel (chart,true);
//	      chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
//	      PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象
//	      piePlot.setLabelFont(new Font("宋体",Font.BOLD,10));//解决乱码
//	      chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,10));
	}
        
        
    	public DiseasePieChart(String c1,String c2,ArrayList<DiseaseSample> sampleCatalog){
            //this.para = para;
            this.sampleCatalog = sampleCatalog;
              DefaultPieDataset data = getCompareDataSet(c1,c2);
	      JFreeChart chart = ChartFactory.createPieChart(c1+" vs " + c2,data,true,false,false);
              
	    //设置百分比
	      PiePlot pieplot = (PiePlot) chart.getPlot();
	      DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题
	      NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象
	      StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象
	      pieplot.setLabelGenerator(sp1);//设置饼图显示百分比
	  
	  //没有数据的时候显示的内容
	      pieplot.setNoDataMessage("无数据显示");
	      pieplot.setCircular(false);
	      pieplot.setLabelGap(0.02D);
	  
	      pieplot.setIgnoreNullValues(true);//设置不显示空值
	      pieplot.setIgnoreZeroValues(true);//设置不显示负值
	      frame = new ChartPanel (chart,true);
//	      chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
//	      PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象
//	      piePlot.setLabelFont(new Font("宋体",Font.BOLD,10));//解决乱码
//	      chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,10));
	}
        
        public DiseasePieChart(String name,ArrayList<DiseaseSample> sampleCatalog,String flag){
            //this.para = para;
            this.sampleCatalog = sampleCatalog;
              DefaultPieDataset data = getMyCountryDataSet(name);
	      JFreeChart chart = ChartFactory.createPieChart(name+" Male/Female Disease Chart",data,true,false,false);
              
	    //设置百分比
	      PiePlot pieplot = (PiePlot) chart.getPlot();
	      DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题
	      NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象
	      StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象
	      pieplot.setLabelGenerator(sp1);//设置饼图显示百分比
	  
	  //没有数据的时候显示的内容
	      pieplot.setNoDataMessage("无数据显示");
	      pieplot.setCircular(false);
	      pieplot.setLabelGap(0.02D);
	  
	      pieplot.setIgnoreNullValues(true);//设置不显示空值
	      pieplot.setIgnoreZeroValues(true);//设置不显示负值
	      frame = new ChartPanel (chart,true);
//	      chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
//	      PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象
//	      piePlot.setLabelFont(new Font("宋体",Font.BOLD,10));//解决乱码
//	      chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,10));
	}
        
    private DefaultPieDataset getMyCountryDataSet(String c){
        DefaultPieDataset dataset = new DefaultPieDataset();
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
            
                if(map.containsKey(s.getSex())){
                    map.put(s.getSex(),map.get(s.getSex())+1);
                }
                else{
                    map.put(s.getSex(),1);
                }
            
            
        }
        Iterator<String> p2 = map.keySet().iterator();
        while(p2.hasNext()){
            String name = p2.next();
            int number = map.get(name);
            dataset.setValue(name,number);
        }
        return dataset;
    }  
    
    private  DefaultPieDataset getCompareDataSet(String c1,String c2){
        DefaultPieDataset dataset = new DefaultPieDataset();
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
            dataset.setValue(name, number);
        }        
        return dataset;
    }
        
        
    private static DefaultPieDataset getDataSet(String para, ArrayList<DiseaseSample> sampleCatalog) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        Map<String,Integer> map = new HashMap<>();
        
        if(para.equals("CountryCode")){
            for(DiseaseSample sample : sampleCatalog){
                if(map.containsKey(sample.getCountryCode())){
                    map.put(sample.getCountryCode(), map.get(sample.getCountryCode())+1);
                }
                else{
                    map.put(sample.getCountryCode(),1);
                }
            }
        }
        else if(para.equals("Sex")){
            for(DiseaseSample sample : sampleCatalog){
                if(map.containsKey(sample.getSex())){
                    map.put(sample.getSex(), map.get(sample.getSex())+1);
                }
                else{
                    map.put(sample.getSex(),1);
                }
            }
        }
        else if(para.equals("Age")){
            for(DiseaseSample sample : sampleCatalog){
                if(map.containsKey(sample.getAge())){
                    map.put(sample.getAge(), map.get(sample.getAge())+1);
                }
                else{
                    map.put(sample.getAge(),1);
                }
            }
        }
        else if(para.equals("Reference Date")){
            for(DiseaseSample sample : sampleCatalog){
                if(map.containsKey(sample.getReferenceDate())){
                    map.put(sample.getReferenceDate(), map.get(sample.getReferenceDate())+1);
                }
                else{
                    map.put(sample.getReferenceDate(),1);
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
            dataset.setValue(name, number);
        }        
        return dataset;
}
    public ChartPanel getChartPanel(){
    	return frame;
    	
    }
}