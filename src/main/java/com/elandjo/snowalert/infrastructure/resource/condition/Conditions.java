package com.elandjo.snowalert.infrastructure.resource.condition;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

class Conditions {
	private String weather;

	Conditions(String weather) {
		this.weather = weather;
	}

	@JsonProperty
	String getWeather() {
		return weather;
	}

	@Override
	public boolean equals(Object other) {
		return EqualsBuilder.reflectionEquals(this, other);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}