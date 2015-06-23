package com.elandjo.snowalert.testfixtures;

import com.elandjo.snowalert.domain.model.resort.Resort;
import com.elandjo.snowalert.domain.model.weather.Weather;
import com.elandjo.snowalert.domain.service.WeatherLookupService;

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