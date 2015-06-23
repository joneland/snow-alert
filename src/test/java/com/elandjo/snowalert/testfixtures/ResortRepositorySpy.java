package com.elandjo.snowalert.testfixtures;

import com.elandjo.snowalert.domain.model.resort.Resort;
import com.elandjo.snowalert.domain.model.resort.ResortId;

public class ResortRepositorySpy extends ResortRepositoryStub {
	private ResortId resortId;

	@Override
	public Resort find(ResortId resortId) {
		this.resortId = resortId;
		return super.find(resortId);
	}

	public boolean wasCalledWith(ResortId expectedResortId) {
		return expectedResortId.equals(resortId);
	}
}