package com.exastax.assignment.service;

import java.util.Set;

import com.exastax.assignment.domain.RawGeoData;
import com.exastax.assignment.domain.SalesData;

public interface SalesDataService {

	Set<SalesData> findByPolygon(RawGeoData rawGeoData);

	Set<SalesData> findByPoint(RawGeoData rawGeoData, Double dist);
}
