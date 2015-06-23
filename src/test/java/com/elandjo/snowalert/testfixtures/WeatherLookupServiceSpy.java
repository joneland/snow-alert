package com.elandjo.snowalert.testfixtures;

import com.elandjo.snowalert.domain.model.resort.Resort;
import com.elandjo.snowalert.domain.model.weather.Weather;

public class WeatherLookupServiceSpy extends WeatherLookupServiceStub {
	private Resort resort;

	@Override
	public Weather findWeatherConditionsAt(Resort resort) {
		this.resort = resort;
		return super.findWeatherConditionsAt(resort);
	}

	public boolean wasCalledWith(Resort expectedResort) {
		return expectedResort.equals(resort);
	}
}