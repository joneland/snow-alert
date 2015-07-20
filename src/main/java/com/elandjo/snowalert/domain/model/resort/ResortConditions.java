package com.elandjo.snowalert.domain.model.resort;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;

public class ResortConditions {
	public static final ResortConditions UNKNOWN = new ResortConditions().withWeather(Weather.UNKNOWN);

	private Weather weather;

	public ResortConditions withWeather(Weather weather) {
		this.weather = weather;
		return this;
	}

	@Override
	public String toString() {
		return String.format("{weather:%s}", weather);
	}

	@Override
	public boolean equals(Object obj) {
		return reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return reflectionHashCode(this);
	}
}