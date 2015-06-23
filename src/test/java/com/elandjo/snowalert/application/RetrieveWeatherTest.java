package com.elandjo.snowalert.application;

import com.elandjo.snowalert.domain.model.resort.Resort;
import com.elandjo.snowalert.domain.model.weather.Weather;
import com.elandjo.snowalert.testfixtures.WeatherLookupServiceSpy;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RetrieveWeatherTest {
	private static final Resort FRANCE_MORZINE = new Resort();
	private static final Resort FRANCE_TIGNES = new Resort();
	private static final Weather SNOWING = new Weather();
	private static final Weather SUNNY = new Weather();

	private RetrieveWeather retrieveWeather;
	private WeatherLookupServiceSpy weatherLookupServiceSpy;

	@Before
	public void
	initialise() {
		weatherLookupServiceSpy = new WeatherLookupServiceSpy();
		retrieveWeather = new RetrieveWeather(weatherLookupServiceSpy);
	}

	@Test public void
	weatherIsSnowing_AtMorzineResort() {
		weatherLookupServiceSpy.withWeatherResponse(SNOWING);

		Weather weather = retrieveWeather.atResort(FRANCE_MORZINE);

		assertThat(weatherLookupServiceSpy.wasCalledWith(FRANCE_MORZINE)).isTrue();
		assertThat(weather).isEqualTo(SNOWING);
	}

	@Test public void
	weatherIsSunny_AtTignesResort() {
		weatherLookupServiceSpy.withWeatherResponse(SUNNY);

		Weather weather = retrieveWeather.atResort(FRANCE_TIGNES);

		assertThat(weatherLookupServiceSpy.wasCalledWith(FRANCE_TIGNES)).isTrue();
		assertThat(weather).isEqualTo(SUNNY);
	}
}