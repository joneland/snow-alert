package com.elandjo.snowalert.infrastructure.resource;

import com.elandjo.snowalert.infrastructure.converter.testdoubles.JSONConvertersStub;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResortConditionsResourceTest {
	public static final String JSON_FORMATTED_RESORT_CONDITIONS = "{ \"weather\": \"SNOWING\" }";
	private JSONConvertersStub jsonConvertersStub;

	private ResortConditionsResource resource;

	@Before public void
	initialise() {
		jsonConvertersStub = new JSONConvertersStub();
		resource = new ResortConditionsResource(jsonConvertersStub);
	}

	@Test public void
	retrievesResortConditions_UsingResortId() {
		jsonConvertersStub.setStubbedJSONResponse(JSON_FORMATTED_RESORT_CONDITIONS);

		String resortConditions = resource.conditionsAtResort("123");

		assertThat(resortConditions).isEqualTo(JSON_FORMATTED_RESORT_CONDITIONS);
	}
}