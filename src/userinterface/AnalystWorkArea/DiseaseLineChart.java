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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;

public class DiseaseLineChart {
	ChartPanel frame;
        String para;
        ArrayList<DiseaseSample> sampleCatalog;
        
	public DiseaseLineChart(String para,ArrayList<DiseaseSample> sampleCatalog){
                this.para = para;
                this.sampleCatalog = sampleCatalog;
		XYDataset xydataset = createDataset(sampleCatalog);
		JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Disease Line Chart", "Year", "Count",xydataset, true, true, true);
		XYPlot xyplot = (XYPlot) jfreechart.getPlot();
		DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();
                dateaxis.setDateFormatOverride(new SimpleDateFormat("yyyy"));
                frame = new ChartPanel(jfreechart,true);
//        dateaxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题
//        dateaxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
//        ValueAxis rangeAxis=xyplot.getRangeAxis();//获取柱状
//        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
//        jfreechart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
//        jfreechart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体

	} 
        
//        public DiseaseLineChart(String c1,String c2,ArrayList<DiseaseSample> sampleCatalog){
//                //this.para = para;
//                this.sampleCatalog = sampleCatalog;
//		//XYDataset xydataset = createDataset(c1,c2);
//		JFreeChart jfreechart = ChartFactory.createTimeSeriesChart(c1+" vs "+c2, "Year", "Count",xydataset, true, true, true);
//		XYPlot xyplot = (XYPlot) jfreechart.getPlot();
//		DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();
//                dateaxis.setDateFormatOverride(new SimpleDateFormat("yyyy"));
//                frame = new ChartPanel(jfreechart,true);
////        dateaxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题
////        dateaxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
////        ValueAxis rangeAxis=xyplot.getRangeAxis();//获取柱状
////        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
////        jfreechart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
////        jfreechart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
//
//	} 
//        
       public DiseaseLineChart(String name,ArrayList<DiseaseSample> sampleCatalog,String flag){
                //this.para = para;
                this.sampleCatalog = sampleCatalog;
		XYDataset xydataset = createMyCountryDataset(name);
		JFreeChart jfreechart = ChartFactory.createTimeSeriesChart(name+" Year Disease Line Chart", "Year", "Count",xydataset, true, true, true);
		XYPlot xyplot = (XYPlot) jfreechart.getPlot();
		DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();
                dateaxis.setDateFormatOverride(new SimpleDateFormat("yyyy"));
                frame = new ChartPanel(jfreechart,true);
//        dateaxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题
//        dateaxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
//        ValueAxis rangeAxis=xyplot.getRangeAxis();//获取柱状
//        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
//        jfreechart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
//        jfreechart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体

	} 
        
       private XYDataset createMyCountryDataset(String c){
            TimeSeries timeseries = new TimeSeries(c+" Year Disease Line Chart",
	                org.jfree.data.time.Year.class);
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
                 if(s.getReferenceDate().length() == 4){
                    if(map.containsKey(s.getReferenceDate())){
                        map.put(s.getReferenceDate(),map.get(s.getReferenceDate())+1);
                    }
                    else{
                        map.put(s.getReferenceDate(),1);
                    }
                 }
            }
            Iterator<String> p2 = map.keySet().iterator();
            while(p2.hasNext()){
                String name = p2.next();
                int year = Integer.parseInt(name);
                int number = map.get(name);
                timeseries.add(new Year(year),number);
            }
            TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
	    timeseriescollection.addSeries(timeseries);
	    return timeseriescollection;
       }
        
	 private static XYDataset createDataset(ArrayList<DiseaseSample> sampleCatalog) {  
	        TimeSeries timeseries = new TimeSeries("Disease Line Chart",
	                org.jfree.data.time.Year.class);
	        Map<String,Integer> map = new HashMap<>();
                for(DiseaseSample sample : sampleCatalog){
                    if(sample.getReferenceDate().length() == 4){
                        if(map.containsKey(sample.getReferenceDate())){
                            map.put(sample.getReferenceDate(), map.get(sample.getReferenceDate())+1);
                        }
                        else{
                            map.put(sample.getReferenceDate(),1);
                        }
                    }
                }
                Iterator<String> p = map.keySet().iterator();
                while(p.hasNext()){
                    String name = p.next();
                    int year = Integer.parseInt(name);
                    int number = map.get(name);
                    timeseries.add(new Year(year),number);
                }
	        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
	        timeseriescollection.addSeries(timeseries);
	        return timeseriescollection;
	    }
	  public ChartPanel getChartPanel(){
	    	return frame;
	    	
	    }
}
