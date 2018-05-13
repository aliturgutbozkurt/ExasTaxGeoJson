package com.exastax.assignment.domain;

import java.util.HashMap;
import java.util.Map;

public class Geometry {

	private String type;

	private Object coordinates = null;

	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Object coordinates) {
		this.coordinates = coordinates;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
}
