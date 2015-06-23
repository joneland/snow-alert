package com.elandjo.snowalert.application;

import com.elandjo.snowalert.domain.model.resort.Resort;
import com.elandjo.snowalert.domain.model.weather.Weather;
import com.elandjo.snowalert.domain.service.WeatherLookupService;

public class RetrieveWeather implements WeatherRetriever {
	private WeatherLookupService weatherLookupService;

	public RetrieveWeather(WeatherLookupService weatherLookupService) {
		this.weatherLookupService = weatherLookupService;
	}

	@Override
	public Weather atResort(Resort resort) {
		return weatherLookupService.findWeatherConditionsAt(resort);
	}
}