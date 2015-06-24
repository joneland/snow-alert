package com.elandjo.snowalert.application;

import com.elandjo.snowalert.domain.model.resort.Resort;
import com.elandjo.snowalert.domain.model.resort.ResortId;
import com.elandjo.snowalert.domain.model.weather.Weather;
import com.elandjo.snowalert.testfixtures.ResortRepositorySpy;
import com.elandjo.snowalert.testfixtures.WeatherLookupServiceSpy;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GatherResortWeatherTest {
	private static final ResortId RESORT_ID = new ResortId(000);
	private static final Resort FRENCH_RESORT = new Resort("Morzine, France");

	private GatherResortWeather gatherResortWeather;
	private ResortRepositorySpy resortRepository;
	private WeatherLookupServiceSpy weatherLookupService;

	@Before
	public void
	initialise() {
		resortRepository = new ResortRepositorySpy();
		weatherLookupService = new WeatherLookupServiceSpy();
		gatherResortWeather = new GatherResortWeather(resortRepository, weatherLookupService);
	}

	@Test public void
	unknownWeatherConditions_WhenResortDoesNotExistForGivenId() {
		resortRepository.returnsResort(Resort.UNKNOWN);

		Weather weather = gatherResortWeather.atResort(RESORT_ID);

		assertThat(resortRepository.wasCalledWith(RESORT_ID)).isTrue();
		assertThat(weather).isEqualTo(Weather.UNKNOWN);
	}

	@Test public void
	weatherConditionsAreRetrieved_WhenResortExistsForGivenId() {
		resortRepository.returnsResort(FRENCH_RESORT);
		weatherLookupService.returnsWeatherResponse(Weather.SNOWY);

		Weather weather = gatherResortWeather.atResort(RESORT_ID);

		assertThat(resortRepository.wasCalledWith(RESORT_ID)).isTrue();
		assertThat(weatherLookupService.wasCalledWith(FRENCH_RESORT)).isTrue();
		assertThat(weather).isEqualTo(Weather.SNOWY);
	}
}