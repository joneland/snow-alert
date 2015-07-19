package com.elandjo.snowalert.infrastructure.converter;

import com.elandjo.snowalert.domain.model.resort.ResortConditions;

class ResortConditionsToJSON {
	static String convert(ResortConditions resortConditions) {
		return "{ \"weather\": \"SNOWING\" }";
	}
}