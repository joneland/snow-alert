package com.elandjo.snowalert.testdoubles;

import com.elandjo.snowalert.domain.model.resort.ResortId;
import com.elandjo.snowalert.domain.model.resort.Resort;

public class ResortsSpy extends ResortsStub {
	private ResortId resortId;

	public ResortId findInvokedWith() {
		return resortId;
	}

	@Override
	public Resort find(ResortId resortId) {
		this.resortId = resortId;
		return super.find(resortId);
	}
}