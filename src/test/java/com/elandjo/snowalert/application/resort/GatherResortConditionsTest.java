package com.elandjo.snowalert.application.resort;

import com.elandjo.snowalert.domain.model.resort.ResortConditions;
import com.elandjo.snowalert.domain.model.resort.ResortId;
import com.elandjo.snowalert.domain.service.resort.testdoubles.ResortConditionsServiceSpy;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GatherResortConditionsTest {
	private GatherResortConditions gatherResortConditions;
	private ResortConditionsServiceSpy resortConditionsService;

	@Before public void
	initialise() {
		resortConditionsService = new ResortConditionsServiceSpy();
		gatherResortConditions = new GatherResortConditions(resortConditionsService);
	}

	@Test public void
	gathersWeatherConditions_ForGivenResortId() {
		ResortConditions expectedResortConditions = new ResortConditions();
		resortConditionsService.setResortConditions(expectedResortConditions);
		ResortId resortId = new ResortId("123");

		ResortConditions resortConditions = gatherResortConditions.atResort(resortId);

		assertThat(resortConditions).isEqualTo(expectedResortConditions);
		assertThat(resortConditionsService.invokedWith()).isEqualTo(resortId);
	}
}