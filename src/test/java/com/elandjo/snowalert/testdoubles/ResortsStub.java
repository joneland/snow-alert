package com.elandjo.snowalert.testdoubles;

import com.elandjo.snowalert.domain.model.resort.Resort;
import com.elandjo.snowalert.domain.model.resort.Resorts;

import java.util.List;

public class ResortsStub implements Resorts {
	private List<Resort> stubbedResorts;

	public void setResorts(List<Resort> stubbedResorts) {
		this.stubbedResorts = stubbedResorts;
	}

	@Override
	public List<Resort> findAll() {
		return stubbedResorts;
	}


}
