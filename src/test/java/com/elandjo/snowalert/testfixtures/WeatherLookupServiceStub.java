package com.elandjo.snowalert.testfixtures;

import com.elandjo.snowalert.domain.service.WeatherLookupService;
import com.elandjo.snowalert.domain.model.resort.ResortId;
import com.elandjo.snowalert.domain.model.weather.Weather;

public class WeatherLookupServiceStub implements WeatherLookupService {
	private Weather weatherResponse;

	@Override
	public Weather findWeatherConditionsAt(ResortId resort) {
		return weatherResponse;
	}

	public void withWeatherResponse(Weather weather) {
		this.weatherResponse = weather;
	}
}