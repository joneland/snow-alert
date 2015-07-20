package com.elandjo.snowalert.infrastructure.resort;

import com.elandjo.snowalert.domain.model.resort.ResortConditions;
import com.elandjo.snowalert.domain.model.resort.ResortId;
import com.elandjo.snowalert.domain.model.resort.Weather;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FakeResortConditionsServiceTest {
	private FakeResortConditionsService resortConditionsService = new FakeResortConditionsService();

	@Test public void
	returnsUnknownResortConditions_WhenIdIsNotKnown() {
		ResortConditions resortConditions = resortConditionsService.atResort(new ResortId("1"));

		assertThat(resortConditions).isEqualTo(ResortConditions.UNKNOWN);
	}

	@Test public void
	returnsPopulatedResortConditions_WhenIdIs123() {
		ResortConditions resortConditions = resortConditionsService.atResort(new ResortId("123"));

		assertThat(resortConditions).isEqualTo(new ResortConditions().withWeather(Weather.SNOWING));
	}
}