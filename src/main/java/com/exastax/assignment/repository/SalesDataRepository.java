package com.exastax.assignment.repository;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.exastax.assignment.domain.SalesData;

@Repository
public interface SalesDataRepository extends MongoRepository<SalesData, String> {
	
	List<SalesData> findAllByLocationWithin(Polygon polygon);
	
	List<SalesData> findByLocationNear(Point p, Distance d);
}
