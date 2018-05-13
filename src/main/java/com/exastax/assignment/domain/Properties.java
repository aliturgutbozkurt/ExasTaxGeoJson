package com.exastax.assignment.domain;

import java.util.HashMap;
import java.util.Map;

public class Properties {

	private String prop0;

	private Prop1 prop1;

	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String getProp0() {
		return prop0;
	}

	public void setProp0(String prop0) {
		this.prop0 = prop0;
	}

	public Prop1 getProp1() {
		return prop1;
	}

	public void setProp1(Prop1 prop1) {
		this.prop1 = prop1;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
}
