package com.elandjo.snowalert.infrastructure.resource;

import com.elandjo.snowalert.application.resort.testdoubles.GatherResortConditionsStub;
import com.elandjo.snowalert.domain.model.resort.ResortConditions;
import com.elandjo.snowalert.domain.model.resort.ResortId;
import com.elandjo.snowalert.domain.service.resort.ResortConditionsService;
import org.junit.Before;
import org.junit.Test;

import static com.elandjo.snowalert.domain.model.resort.Weather.SNOWING;
import static org.assertj.core.api.Assertions.assertThat;

public class ResortConditionsResourceTest {
	private static final String JSON_FORMATTED_RESORT_CONDITIONS = "{\"weather\":\"SNOWING\"}";
	private static final ResortConditions RESORT_CONDITIONS = new ResortConditions().withWeather(SNOWING);
	private static final ResortConditionsService UNIMPORTANT = null;

	private GatherResortConditionsStub gatherResortConditionsStub;

	private ResortConditionsResource resource;

	@Before public void
	initialise() {
		gatherResortConditionsStub = new GatherResortConditionsStub(UNIMPORTANT);
		resource = new ResortConditionsResource(gatherResortConditionsStub);
	}

	@Test public void
	retrievesResortConditions_UsingResortId() {
		gatherResortConditionsStub.setStubbedResortConditions(RESORT_CONDITIONS);

		String resortConditions = resource.conditionsAtResort("123");

		assertThat(gatherResortConditionsStub.atResortInvokedWith()).isEqualTo(new ResortId("123"));
		assertThat(resortConditions).isEqualTo(JSON_FORMATTED_RESORT_CONDITIONS);
	}
}