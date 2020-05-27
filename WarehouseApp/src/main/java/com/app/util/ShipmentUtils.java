package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class ShipmentUtils {
	
	public void generatePieChart(String path,List<Object[]> list) {
		//1.create dataset
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] ob:list) {
			dataset.setValue(ob[0].toString(),new Double(ob[1].toString()) );
		}
		//2.create JFreeChart object
		JFreeChart chart=ChartFactory.createPieChart3D("SHIPMENT TYPE PIE CHART", dataset);
		
		//3.SAVE CHART AS IMAGE
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/shipmentPie.jpg"), chart, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	//2.Bar Chart
	public void generateBarChart(String path,List<Object[]> list) {
		
		//create Dataset
		DefaultCategoryDataset dataset =new  DefaultCategoryDataset();
		for(Object[] ob:list) {
			dataset.setValue(new Double(ob[1].toString()), ob[0].toString(),"");
		}
		//create JFreeChart object
		JFreeChart chart=ChartFactory.createBarChart("SHIPMENT TYPE BAR CHART", "SHIPMENT TYPE", "COUNT", dataset);
		//save chart as image
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/shipmentBar.jpg"), chart, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
