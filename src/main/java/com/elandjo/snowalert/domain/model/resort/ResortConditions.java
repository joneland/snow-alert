package com.elandjo.snowalert.domain.model.resort;

public class ResortConditions {
	private Weather weather;

	public ResortConditions withWeather(Weather weather) {
		this.weather = weather;
		return this;
	}

	@Override
	public String toString() {
		return String.format("{weather:%s}", weather);
	}
}