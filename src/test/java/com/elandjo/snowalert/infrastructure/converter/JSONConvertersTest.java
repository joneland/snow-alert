package com.elandjo.snowalert.infrastructure.converter;

import com.elandjo.snowalert.domain.model.resort.ResortConditions;
import org.junit.Test;

import static com.elandjo.snowalert.domain.model.resort.Weather.SNOWING;
import static org.assertj.core.api.Assertions.assertThat;

public class JSONConvertersTest {
	private JSONConverters jsonConverters = new JSONConverters();

	@Test public void
	throwsException_WhenConverterDoesNotExist() {
		try {
			jsonConverters.convert(new UnsupportedObject());
		} catch (IllegalStateException e) {
			assertThat(e).hasMessage("No converters found for Unsupported Object");
		}
	}

	@Test public void
	convertsResortConditions_toJSON() {
		ResortConditions resortConditions = new ResortConditions().withWeather(SNOWING);

		String json = jsonConverters.convert(resortConditions);

		assertThat(json).isEqualTo("{\"weather\":\"SNOWING\"}");
	}

	class UnsupportedObject {
		public String toString() {
			return "Unsupported Object";
		}
	}
}