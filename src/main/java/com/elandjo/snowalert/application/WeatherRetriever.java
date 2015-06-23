package com.elandjo.snowalert.application;

import com.elandjo.snowalert.domain.model.resort.Resort;
import com.elandjo.snowalert.domain.model.weather.Weather;

interface WeatherRetriever {
	Weather atResort(Resort resort);
}