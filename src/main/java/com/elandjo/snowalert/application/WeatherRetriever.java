package com.elandjo.snowalert.application;

import com.elandjo.snowalert.domain.resort.Resort;
import com.elandjo.snowalert.domain.weather.Weather;

interface WeatherRetriever {
	Weather atResort(Resort resort);
}