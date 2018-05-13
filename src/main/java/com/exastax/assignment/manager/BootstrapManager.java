package com.exastax.assignment.manager;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Component;

import com.exastax.assignment.domain.SalesData;
import com.exastax.assignment.repository.SalesDataRepository;

@Component
public class BootstrapManager {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${sales-data.csv.file.path}")
	private String salesDataCsvFilePath;
	
	private final CsvManager csvManager;
	
	private final SalesDataRepository salesDataRepository;
	
	public BootstrapManager(CsvManager csvManager,SalesDataRepository salesDataRepository) {
		this.csvManager=csvManager;
		this.salesDataRepository=salesDataRepository;
	}

	public void loadCsvSalesData() {
		
		salesDataRepository.deleteAll();
		
		List<SalesData> salesDatas = readCsvSalesDataFromFile(salesDataCsvFilePath);
		
		for(SalesData salesData : salesDatas) {
			if(salesData.getLatitude() != null && salesData.getLongitude() != null )
			salesData.setLocation(new GeoJsonPoint(salesData.getLongitude().doubleValue(),
					salesData.getLatitude().doubleValue()));
		}

		logger.info("{} Sales Csv Data loaded successfully" , salesDataRepository.saveAll(salesDatas).size() );		
	}
	
	public List<SalesData> readCsvSalesDataFromFile(String filename){
		return csvManager.loadObjectList(SalesData.class, filename);
	}	
}
