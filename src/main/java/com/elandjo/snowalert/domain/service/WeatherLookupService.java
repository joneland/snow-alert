package com.elandjo.snowalert.domain.service;

import com.elandjo.snowalert.domain.model.resort.Resort;
import com.elandjo.snowalert.domain.model.weather.Weather;

public interface WeatherLookupService {
	Weather findWeatherConditionsAt(Resort resort);
}