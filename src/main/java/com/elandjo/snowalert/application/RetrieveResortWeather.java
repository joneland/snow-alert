package com.elandjo.snowalert.application;

import com.elandjo.snowalert.domain.model.resort.Resort;
import com.elandjo.snowalert.domain.model.resort.ResortId;
import com.elandjo.snowalert.domain.model.resort.ResortRepository;
import com.elandjo.snowalert.domain.model.weather.Weather;
import com.elandjo.snowalert.domain.service.WeatherLookupService;

public class RetrieveResortWeather {
	private final ResortRepository resortRepository;
	private final WeatherLookupService weatherLookupService;

	public RetrieveResortWeather(final ResortRepository resortRepository, final WeatherLookupService weatherLookupService) {
		this.resortRepository = resortRepository;
		this.weatherLookupService = weatherLookupService;
	}

	public Weather atResort(ResortId resortId) {
		Resort resort = resortRepository.find(resortId);

		if (Resort.UNKNOWN.equals(resort)) {
			return Weather.UNKNOWN;
		}

		return weatherLookupService.findWeatherConditionsAt(resort);
	}
}