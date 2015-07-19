package com.elandjo.snowalert.infrastructure.converter;

import com.elandjo.snowalert.domain.model.resort.ResortConditions;

public class JSONConverters {
	public String convert(final Object target) {
		if (target instanceof ResortConditions) {
			return ResortConditionsToJSON.convert((ResortConditions) target);
		}

		throw new IllegalStateException("No converters found for " + target);
	}
}