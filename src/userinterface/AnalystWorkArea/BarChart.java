/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AnalystWorkArea;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author zack
 */
public class BarChart {
	ChartPanel frame1;
	public  BarChart(){
		CategoryDataset dataset = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D(
       		                 "水果", // 图表标题
                            "水果种类", // 目录轴的显示标签
                            "数量", // 数值轴的显示标签
                            dataset, // 数据集
                            PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                            true,           // 是否显示图例(对于简单的柱状图必须是false)
                            false,          // 是否生成工具
                            false           // 是否生成URL链接
                            );
          
         frame1=new ChartPanel(chart,true);        //这里也可以用chartFrame,可以直接生成一个独立的Frame
         frame1.setVisible(true);
	}
	   private static CategoryDataset getDataSet() {
           DefaultCategoryDataset dataset = new DefaultCategoryDataset();
           dataset.addValue(100, "北京", "苹果");
           dataset.addValue(100, "上海", "苹果");
           dataset.addValue(100, "广州", "苹果");
           dataset.addValue(200, "北京", "梨子");
           dataset.addValue(200, "上海", "梨子");
           dataset.addValue(200, "广州", "梨子");
           dataset.addValue(300, "北京", "葡萄");
           dataset.addValue(300, "上海", "葡萄");
           dataset.addValue(300, "广州", "葡萄");
           dataset.addValue(400, "北京", "香蕉");
           dataset.addValue(400, "上海", "香蕉");
           dataset.addValue(400, "广州", "香蕉");
           dataset.addValue(500, "北京", "荔枝");
           dataset.addValue(500, "上海", "荔枝");
           dataset.addValue(500, "广州", "荔枝");
           return dataset;
}
public ChartPanel getChartPanel(){
	return frame1;
	
}
}