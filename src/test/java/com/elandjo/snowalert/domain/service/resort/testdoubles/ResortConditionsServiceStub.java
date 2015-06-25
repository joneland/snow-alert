package com.elandjo.snowalert.domain.service.resort.testdoubles;

import com.elandjo.snowalert.domain.model.resort.ResortConditions;
import com.elandjo.snowalert.domain.model.resort.ResortId;
import com.elandjo.snowalert.domain.service.resort.ResortConditionsService;

public class ResortConditionsServiceStub implements ResortConditionsService {
	private ResortConditions stubbedResortConditions;

	public void setResortConditions(ResortConditions stubbedResortConditions) {
		this.stubbedResortConditions = stubbedResortConditions;
	}

	@Override
	public ResortConditions atResort(ResortId resortId) {
		return stubbedResortConditions;
	}
}