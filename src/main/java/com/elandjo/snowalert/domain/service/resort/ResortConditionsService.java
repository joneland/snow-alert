package com.elandjo.snowalert.domain.service.resort;

import com.elandjo.snowalert.domain.model.resort.ResortConditions;
import com.elandjo.snowalert.domain.model.resort.ResortId;

public interface ResortConditionsService {
	ResortConditions atResort(ResortId resortId);
}