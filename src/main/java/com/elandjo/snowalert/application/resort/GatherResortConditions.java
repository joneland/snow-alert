package com.elandjo.snowalert.application.resort;

import com.elandjo.snowalert.domain.model.resort.ResortConditions;
import com.elandjo.snowalert.domain.model.resort.ResortId;
import com.elandjo.snowalert.domain.service.resort.ResortConditionsService;

public class GatherResortConditions {
	private final ResortConditionsService resortConditionsService;

	public GatherResortConditions(final ResortConditionsService resortConditionsService) {
		this.resortConditionsService = resortConditionsService;
	}

	public ResortConditions atResort(final ResortId resortId) {
		return resortConditionsService.atResort(resortId);
	}
}