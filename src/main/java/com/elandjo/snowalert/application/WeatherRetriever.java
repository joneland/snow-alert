package com.elandjo.snowalert.application;

import com.elandjo.snowalert.domain.model.resort.ResortId;
import com.elandjo.snowalert.domain.model.weather.Weather;

interface WeatherRetriever {
	Weather atResort(ResortId resort);
}