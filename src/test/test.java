/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import business.role.SystemAdminRole;
import java.awt.GridLayout;
import java.util.Date;
import javax.swing.JFrame;
import userinterface.AnalystWorkArea.BarChart;

/**
 *
 * @author zack
 */
public class test {
    
    public static void main(String[] args){
        
        JFrame frame=new JFrame("Java数据统计图");
	frame.setLayout(new GridLayout(2,2,10,10));
	frame.add(new BarChart().getChartPanel());           //添加柱形图
	//frame.add(new BarChart1().getChartPanel());          //添加柱形图的另一种效果
	//frame.add(new PieChart().getChartPanel());           //添加饼状图
	//frame.add(new TimeSeriesChart().getChartPanel());    //添加折线图
	frame.setBounds(50, 50, 800, 600);
	frame.setVisible(true);
    }
}
