package com.elandjo.snowalert.application.resort.testdoubles;

import com.elandjo.snowalert.application.resort.GatherResortConditions;
import com.elandjo.snowalert.domain.model.resort.ResortConditions;
import com.elandjo.snowalert.domain.model.resort.ResortId;
import com.elandjo.snowalert.domain.service.resort.ResortConditionsService;

public class GatherResortConditionsStub extends GatherResortConditions {
	private ResortConditions stubbedResortConditions;
	private ResortId resortId;

	public GatherResortConditionsStub(ResortConditionsService resortConditionsService) {
		super(resortConditionsService);
	}

	public ResortConditions atResort(ResortId resortId) {
		this.resortId = resortId;
		return stubbedResortConditions;
	}

	public void setStubbedResortConditions(ResortConditions stubbedResortConditions) {
		this.stubbedResortConditions = stubbedResortConditions;
	}

	public ResortId atResortInvokedWith() {
		return resortId;
	}
}