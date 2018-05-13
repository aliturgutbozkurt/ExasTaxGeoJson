package com.exastax.assignment.domain;

import java.util.HashMap;
import java.util.Map;

public class Prop1 {

	private String key;

	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
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
