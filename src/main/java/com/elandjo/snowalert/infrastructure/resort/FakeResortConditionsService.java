package com.elandjo.snowalert.infrastructure.resort;

import com.elandjo.snowalert.domain.model.resort.ResortConditions;
import com.elandjo.snowalert.domain.model.resort.ResortId;
import com.elandjo.snowalert.domain.service.resort.ResortConditionsService;

import static com.elandjo.snowalert.domain.model.resort.Weather.SNOWING;

public class FakeResortConditionsService implements ResortConditionsService {
	@Override
	public ResortConditions atResort(ResortId resortId) {
		return new ResortConditions().withWeather(SNOWING);
	}
}
