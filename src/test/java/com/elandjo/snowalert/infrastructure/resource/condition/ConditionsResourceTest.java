package com.elandjo.snowalert.infrastructure.resource.condition;

import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.OK;
import static org.assertj.core.api.Assertions.assertThat;

public class ConditionsResourceTest {
	private ConditionsResource conditionsResource;

	@Before public void
	initialise() {
		conditionsResource = new ConditionsResource();
	}

	@Test public void
	weatherConditions_ForGivenResortId() {
		Conditions expectedConditions = new Conditions("Snowing");

		Response conditionsResponse = conditionsResource.conditionsForResort("123");

		assertThat(conditionsResponse.getEntity()).isEqualTo(expectedConditions);
		assertThat(conditionsResponse.getStatus()).isEqualTo(OK.getStatusCode());
	}
}