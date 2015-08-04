package com.elandjo.snowalert.infrastructure.converter;

import com.elandjo.snowalert.domain.model.resort.ResortConditions;
import org.junit.Test;

import static com.elandjo.snowalert.domain.model.resort.Weather.SNOWING;
import static org.assertj.core.api.Assertions.assertThat;

public class ResortConditionsToJSONTest {
	private ResortConditionsToJSON jsonConverters = new ResortConditionsToJSON();

	@Test public void
	convertsResortConditions_toJSON() {
		ResortConditions resortConditions = new ResortConditions().withWeather(SNOWING);

		String json = jsonConverters.convert(resortConditions);

		assertThat(json).isEqualTo("{\"weather\":\"SNOWING\"}");
	}
}