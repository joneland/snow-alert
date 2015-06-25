package com.elandjo.snowalert.domain.model.resort;

import java.util.List;

public interface Resorts {
	Resort find(ResortId resortId);

	List<Resort> findAll();
}