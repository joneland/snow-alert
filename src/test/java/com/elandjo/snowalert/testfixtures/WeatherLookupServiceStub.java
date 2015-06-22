package com.elandjo.snowalert.testfixtures;

import com.elandjo.snowalert.application.WeatherLookupService;
import com.elandjo.snowalert.domain.resort.Resort;
import com.elandjo.snowalert.domain.weather.Weather;

public class WeatherLookupServiceStub implements WeatherLookupService {
	private Weather weatherResponse;

	@Override
	public Weather findWeatherConditionsAt(Resort resort) {
		return weatherResponse;
	}

	public void withWeatherResponse(Weather weather) {
		this.weatherResponse = weather;
	}
}