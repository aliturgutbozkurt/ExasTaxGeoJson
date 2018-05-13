package com.exastax.assignment.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RawGeoData {

	private String type;

	private List<Feature> features;

	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
}
