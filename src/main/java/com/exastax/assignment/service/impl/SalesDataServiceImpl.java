package com.exastax.assignment.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.stereotype.Service;

import com.exastax.assignment.domain.GeoData;
import com.exastax.assignment.domain.RawGeoData;
import com.exastax.assignment.domain.SalesData;
import com.exastax.assignment.repository.SalesDataRepository;
import com.exastax.assignment.service.SalesDataService;
import com.exastax.assignment.service.mapper.GeoDataMapper;

@Service
public class SalesDataServiceImpl implements SalesDataService {
	
	private final GeoDataMapper geoDataMapper;
	
	private final SalesDataRepository salesDataRepository;
	
	public SalesDataServiceImpl(GeoDataMapper geoDataMapper,SalesDataRepository salesDataRepository) {
	
		this.geoDataMapper = geoDataMapper;
		
		this.salesDataRepository = salesDataRepository;
	}
	
	@Override
	public Set<SalesData> findByPolygon(RawGeoData rawGeoData) {
		
		GeoData geoData = geoDataMapper.rawGeoDataToGeoData(rawGeoData);
		
		Set<SalesData> salesDataSet=new HashSet<>();
		
		for(Polygon polygon : geoData.getPolygons()) {
		
			for(SalesData salesData:salesDataRepository.findAllByLocationWithin(polygon)) {
				salesDataSet.add(salesData);
			}
		}		
		return salesDataSet;
	}
	
	@Override
	public Set<SalesData> findByPoint(RawGeoData rawGeoData, Double dist) {
		
		GeoData geoData = geoDataMapper.rawGeoDataToGeoData(rawGeoData);
		
		Set<SalesData> salesDataSet=new HashSet<>();
		
		Distance distance= new Distance(Double.valueOf(dist), Metrics.KILOMETERS);
		
		for(Point point : geoData.getPoints()) {
		
			for(SalesData salesData:salesDataRepository.findByLocationNear(point,distance )) {
				salesDataSet.add(salesData);
		  }
		}
		
		return salesDataSet;
	}

}
