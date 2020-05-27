package com.app.util;

import java.io.File;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;
@Component
public class WhUserTypeUtil {
	public void genPie(String path,List<Object[]> list)
	{
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] ob:list)
		{
			dataset.setValue(ob[0].toString(),new Double(ob[1].toString()));
			
			JFreeChart chart=ChartFactory.createPieChart3D("WHUSERTYPE PIE CHART", dataset);
			try {
				
				ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/whusertypepie.jpg"), chart,400,400);
			}catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
