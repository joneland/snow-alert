package com.elandjo.snowalert.infrastructure.converter;

import com.elandjo.snowalert.domain.model.resort.ResortConditions;
import org.junit.Test;

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
		String json = jsonConverters.convert(new ResortConditions());

		assertThat(json).isEqualTo("{ \"weather\": \"SNOWING\" }");
	}

	class UnsupportedObject {
		public String toString() {
			return "Unsupported Object";
		}
	}
}