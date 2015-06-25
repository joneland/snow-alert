package com.elandjo.snowalert.domain.service.resort.testdoubles;

import com.elandjo.snowalert.domain.model.resort.ResortConditions;
import com.elandjo.snowalert.domain.model.resort.ResortId;

public class ResortConditionsServiceSpy extends ResortConditionsServiceStub {
	private ResortId resortId;

	@Override
	public ResortConditions atResort(ResortId resortId) {
		this.resortId = resortId;
		return super.atResort(resortId);
	}

	public ResortId invokedWith() {
		return resortId;
	}
}