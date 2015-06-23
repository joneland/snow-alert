package com.elandjo.snowalert.testfixtures;

import com.elandjo.snowalert.domain.model.resort.Resort;
import com.elandjo.snowalert.domain.model.resort.ResortId;
import com.elandjo.snowalert.domain.model.resort.ResortRepository;

public class ResortRepositoryStub implements ResortRepository {
	private Resort resort;

	@Override
	public Resort find(ResortId resortId) {
		return resort;
	}

	public void returnsResort(Resort resort) {
		this.resort = resort;
	}
}