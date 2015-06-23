package com.elandjo.snowalert.application;

import com.elandjo.snowalert.domain.model.resort.Resort;
import com.elandjo.snowalert.domain.model.resort.ResortId;
import com.elandjo.snowalert.domain.model.weather.Weather;
import com.elandjo.snowalert.testfixtures.ResortRepositorySpy;
import com.elandjo.snowalert.testfixtures.WeatherLookupServiceSpy;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RetrieveWeatherTest {
	private static final ResortId RESORT_ID = new ResortId(000);

	private RetrieveWeather retrieveWeather;
	private ResortRepositorySpy resortRepository;

	@Before
	public void
	initialise() {
		resortRepository = new ResortRepositorySpy();
		retrieveWeather = new RetrieveWeather(resortRepository);
	}

	@Test public void
	unknownWeatherConditions_WhenResortDoesNotExistForGivenId() {
		resortRepository.returnsResort(Resort.UNKNOWN);

		Weather weather = retrieveWeather.atResort(RESORT_ID);

		assertThat(resortRepository.wasCalledWith(RESORT_ID)).isTrue();
		assertThat(weather).isEqualTo(Weather.UNKNOWN);
	}

	@Test public void
	weatherConditionsAreRetrieved_WhenResortExistsForGivenId() {
		resortRepository.returnsResort(new Resort("Morzine, France"));

		Weather weather = retrieveWeather.atResort(RESORT_ID);

		assertThat(resortRepository.wasCalledWith(RESORT_ID)).isTrue();
		assertThat(weather).isEqualTo(Weather.SNOWY);
	}
}