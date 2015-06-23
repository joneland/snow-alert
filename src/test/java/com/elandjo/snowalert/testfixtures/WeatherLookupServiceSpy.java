package com.elandjo.snowalert.testfixtures;

import com.elandjo.snowalert.domain.model.resort.ResortId;
import com.elandjo.snowalert.domain.model.weather.Weather;

public class WeatherLookupServiceSpy extends WeatherLookupServiceStub {
	private ResortId resort;

	@Override
	public Weather findWeatherConditionsAt(ResortId resort) {
		this.resort = resort;
		return super.findWeatherConditionsAt(resort);
	}

	public boolean wasCalledWith(ResortId expectedResort) {
		return expectedResort.equals(resort);
	}
}