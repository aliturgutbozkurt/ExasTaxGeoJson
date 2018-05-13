package com.exastax.assignment.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;

public class GeoData {

	private List<Polygon> polygons = new ArrayList<>();

	private List<Point> points = new ArrayList<>();

	public List<Polygon> getPolygons() {
		return polygons;
	}

	public void setPolygons(List<Polygon> polygons) {
		this.polygons = polygons;

	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}
}
