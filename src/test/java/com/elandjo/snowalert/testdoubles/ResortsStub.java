package com.elandjo.snowalert.testdoubles;

import com.elandjo.snowalert.application.resort.ResortId;
import com.elandjo.snowalert.domain.model.resort.Resort;
import com.elandjo.snowalert.domain.model.resort.Resorts;

import java.util.List;

public class ResortsStub implements Resorts {
	private List<Resort> stubbedResorts;
	private Resort stubbedResort;

	public void setResort(Resort stubbedResort) {
		this.stubbedResort = stubbedResort;
	}

	public void setResorts(List<Resort> stubbedResorts) {
		this.stubbedResorts = stubbedResorts;
	}

	@Override
	public Resort find(ResortId resortId) {
		return stubbedResort;
	}

	@Override
	public List<Resort> findAll() {
		return stubbedResorts;
	}
}