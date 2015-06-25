package com.elandjo.snowalert.application.resort;

import com.elandjo.snowalert.domain.model.resort.Resort;
import com.elandjo.snowalert.domain.model.resort.ResortId;
import com.elandjo.snowalert.domain.model.resort.Resorts;

import java.util.List;

public class FindResorts {
	private final Resorts resorts;

	public FindResorts(final Resorts resorts) {
		this.resorts = resorts;
	}

	public Resort find(ResortId resortId) {
		return resorts.find(resortId);
	}

	public List<Resort> findAll() {
		return resorts.findAll();
	}
}