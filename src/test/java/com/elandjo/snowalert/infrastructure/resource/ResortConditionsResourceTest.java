package com.elandjo.snowalert.infrastructure.resource;

import com.elandjo.snowalert.application.resort.testdoubles.GatherResortConditionsStub;
import com.elandjo.snowalert.domain.model.resort.ResortConditions;
import com.elandjo.snowalert.domain.model.resort.ResortId;
import com.elandjo.snowalert.domain.service.resort.ResortConditionsService;
import com.elandjo.snowalert.infrastructure.converter.testdoubles.JSONConvertersStub;
import org.junit.Before;
import org.junit.Test;

import static com.elandjo.snowalert.domain.model.resort.Weather.SNOWING;
import static org.assertj.core.api.Assertions.assertThat;

public class ResortConditionsResourceTest {
	private static final String JSON_FORMATTED_RESORT_CONDITIONS = "{ \"weather\": \"SNOWING\" }";
	private static final ResortConditions RESORT_CONDITIONS = new ResortConditions().withWeather(SNOWING);
	private static final ResortConditionsService UNIMPORTANT = null;

	private GatherResortConditionsStub gatherResortConditionsStub;
	private JSONConvertersStub jsonConvertersStub;

	private ResortConditionsResource resource;

	@Before public void
	initialise() {
		gatherResortConditionsStub = new GatherResortConditionsStub(UNIMPORTANT);
		jsonConvertersStub = new JSONConvertersStub();
		resource = new ResortConditionsResource(gatherResortConditionsStub, jsonConvertersStub);
	}

	@Test public void
	retrievesResortConditions_UsingResortId() {
		gatherResortConditionsStub.setStubbedResortConditions(RESORT_CONDITIONS);
		jsonConvertersStub.setStubbedJSONResponse(JSON_FORMATTED_RESORT_CONDITIONS);

		String resortConditions = resource.conditionsAtResort("123");

		assertThat(gatherResortConditionsStub.atResortInvokedWith()).isEqualTo(new ResortId("123"));
		assertThat(jsonConvertersStub.convertInvokedWith()).isEqualTo(RESORT_CONDITIONS);
		assertThat(resortConditions).isEqualTo(JSON_FORMATTED_RESORT_CONDITIONS);
	}
}