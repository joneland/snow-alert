package com.elandjo.snowalert.application;

import com.elandjo.snowalert.domain.model.resort.Resort;
import com.elandjo.snowalert.domain.model.weather.Weather;
import com.elandjo.snowalert.testfixtures.WeatherLookupServiceSpy;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RetrieveWeatherTest {
	private RetrieveWeather retrieveWeather;
	private WeatherLookupServiceSpy weatherLookupServiceSpy;

	@Before public void
	initialise() {
		weatherLookupServiceSpy = new WeatherLookupServiceSpy();
		retrieveWeather = new RetrieveWeather(weatherLookupServiceSpy);
	}

	@Test public void
	weatherIsSnowing_AtMorzineResort() {
		weatherLookupServiceSpy.withWeatherResponse(Weather.SNOWING);

		Weather weather = retrieveWeather.atResort(Resort.FRANCE_MORZINE);

		assertThat(weatherLookupServiceSpy.wasCalledWith(Resort.FRANCE_MORZINE)).isTrue();
		assertThat(weather).isEqualTo(Weather.SNOWING);
	}

	@Test public void
	weatherIsSunny_AtTignesResort() {
		weatherLookupServiceSpy.withWeatherResponse(Weather.SUNNY);

		Weather weather = retrieveWeather.atResort(Resort.FRANCE_TIGNES);

		assertThat(weatherLookupServiceSpy.wasCalledWith(Resort.FRANCE_TIGNES)).isTrue();
		assertThat(weather).isEqualTo(Weather.SUNNY);
	}
}