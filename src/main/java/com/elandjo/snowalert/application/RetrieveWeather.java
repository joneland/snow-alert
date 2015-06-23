package com.elandjo.snowalert.application;

import com.elandjo.snowalert.domain.model.resort.Resort;
import com.elandjo.snowalert.domain.model.resort.ResortId;
import com.elandjo.snowalert.domain.model.resort.ResortRepository;
import com.elandjo.snowalert.domain.model.weather.Weather;

public class RetrieveWeather implements WeatherRetriever {
	private ResortRepository resortRepository;

	public RetrieveWeather(ResortRepository weatherLookupService) {
		this.resortRepository = weatherLookupService;
	}

	@Override
	public Weather atResort(ResortId resortId) {
		Resort resort = resortRepository.find(resortId);

		if (Resort.UNKNOWN.equals(resort)) {
			return Weather.UNKNOWN;
		}

		return Weather.SNOWY;
	}
}