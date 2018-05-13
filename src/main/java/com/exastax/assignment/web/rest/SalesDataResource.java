package com.exastax.assignment.web.rest;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exastax.assignment.domain.RawGeoData;
import com.exastax.assignment.domain.SalesData;
import com.exastax.assignment.service.SalesDataService;

@RestController
public class SalesDataResource {
	
	private final SalesDataService salesDataService;

	public SalesDataResource(SalesDataService salesDataService) {
		this.salesDataService = salesDataService;
	}

	@RequestMapping(value = "/sales-data/findByPolygon", method = RequestMethod.POST)
	public ResponseEntity<Set<SalesData>> findSalesDataByPolygon(@RequestBody RawGeoData rawGeoData) {

		return ResponseEntity.status(HttpStatus.OK).body(salesDataService.findByPolygon(rawGeoData));
	}
	
	@RequestMapping(value = "/sales-data/findByPoint", method = RequestMethod.POST)
	public ResponseEntity<Set<SalesData>> findSalesDataByPoint(@RequestBody RawGeoData rawGeoData,
			@RequestParam(value = "dist", required = false, defaultValue="0") Double dist) {

		return ResponseEntity.status(HttpStatus.OK).body(salesDataService.findByPoint(rawGeoData,dist));
	}
}
