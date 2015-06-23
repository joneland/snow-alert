package com.elandjo.snowalert.domain.service;

import com.elandjo.snowalert.domain.model.resort.ResortId;
import com.elandjo.snowalert.domain.model.weather.Weather;

public interface WeatherLookupService {
	Weather findWeatherConditionsAt(ResortId resort);
}