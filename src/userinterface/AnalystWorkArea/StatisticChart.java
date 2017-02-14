/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AnalystWorkArea;

import business.disease.DiseaseSample;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import static java.lang.Math.sqrt;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.about.AboutPanel;
import org.netbeans.lib.awtextra.AbsoluteLayout;
/**
 *
 * @author dongqi
 */
public class StatisticChart {
	JPanel frame;
        ArrayList<DiseaseSample> sampleCatalog;
	public  StatisticChart(String name,ArrayList<DiseaseSample> sampleCatalog){
            this.sampleCatalog = sampleCatalog;
            frame = new JPanel();
            calculateData(name,frame);
           
            frame.setVisible(true);
	}
        
	private void calculateData(String c,JPanel frame) {
            double total = 0;
            double mytotal = 0;
            DecimalFormat df = new DecimalFormat("######0.0000");
            HashSet<DiseaseSample> set = new HashSet();
            for(DiseaseSample sample : sampleCatalog){
                total++;
                if(sample.getCountryCode().equals(c)){
                    set.add(sample);
                    mytotal++;
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
//            JLabel CountryName = new JLabel("Country Code: "+c);
//            JLabel SampleCount = new JLabel("Sample Count: "+(int)mytotal);
//            JLabel SamplePercentage = new JLabel("Sample Percentage: "+ df.format(mytotal/total));
//            frame.add(CountryName);
//            frame.add(SampleCount);
//            frame.add(SamplePercentage);
            Iterator<String> p2 = map.keySet().iterator();
            Iterator<String> p3 = map.keySet().iterator();
            double keyCount = 1;
            while(p2.hasNext()){
                keyCount++;
                String year = p2.next();
                //JLabel YearCount = new JLabel("Year: "+year+" Count: "+map.get(year));
                //frame.add(YearCount);
           }
           double mean = mytotal/keyCount;
           double sum = 0;
           //JLabel MeanCount = new JLabel("Year Mean Count: "+df.format(mean));
           //frame.add(MeanCount);
           while(p3.hasNext()){
               String year = p3.next();
               sum = sum + (map.get(year)-mean)*(map.get(year)-mean);
           }
           //JLabel Variance = new JLabel("Variance: "+df.format(sum/mytotal));
           //frame.add(Variance);
           JLabel label = new JLabel();
           label.setText("<html>Country Code: "+c+"<br>Sample Count: "+(int)mytotal+"<br>Sample Percentage: "+df.format(mytotal/total)+"<br>Year Mean Count: "+df.format(mean)+"<br>Variance: "+df.format(sum/mytotal)+"<br>STD Variance: "+df.format(sqrt(sum/mytotal))+"</html>");
           frame.add(label);
        }
        
        public JPanel getChartPanel(){
            return frame;	
        }
}
