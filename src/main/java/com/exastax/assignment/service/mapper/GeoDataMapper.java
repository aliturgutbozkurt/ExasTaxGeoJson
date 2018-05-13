package com.exastax.assignment.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.stereotype.Component;

import com.exastax.assignment.domain.Feature;
import com.exastax.assignment.domain.GeoData;
import com.exastax.assignment.domain.RawGeoData;

@Component
public class GeoDataMapper {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static final String POLYGON = "Polygon";
	
	private static final String POINT = "Point";
	
	private static final String LINE_STRING = "LineString";

	public GeoData rawGeoDataToGeoData(RawGeoData rawGeoData) {

		GeoData geoData = new GeoData();

		for (Feature feature : rawGeoData.getFeatures()) {
			if (feature.getGeometry().getType().equals(POLYGON)){

				List<Point> points = new ArrayList<>();

				@SuppressWarnings("unchecked")
				List<List<List<Double>>> coordinates = (List<List<List<Double>>>) feature.getGeometry()
						.getCoordinates();

				for (List<List<Double>> pointDatas : coordinates) {

					for (List<Double> pointData : pointDatas) {

						points.add(createPoint(pointData));
					}

				}
				geoData.getPolygons().add(createPolygon(points));

			} else if (feature.getGeometry().getType().equals(POINT)) {

				@SuppressWarnings("unchecked")
				List<Double> pointData = (List<Double>) feature.getGeometry().getCoordinates();

				geoData.getPoints().add(createPoint(pointData));

			} else if (feature.getGeometry().getType().equals(LINE_STRING)) {
				// TO DO - Spring Data does not support LineString yet.
			} else {
				logger.info("Unknown geometry type -> {}", feature.getGeometry().getType());
			}
		}

		return geoData;
	}

	private Polygon createPolygon(List<Point> points) {
		Polygon polygon = new Polygon(points);
		return polygon;
	}

	private Point createPoint(List<Double> pointData) {
		Double x = pointData.get(0);
		Double y = pointData.get(1);

		Point point = new Point(x, y);
		return point;
	}

}
