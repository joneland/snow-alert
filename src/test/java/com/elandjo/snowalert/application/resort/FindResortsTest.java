package com.elandjo.snowalert.application.resort;

import com.elandjo.snowalert.domain.model.resort.Resort;
import com.elandjo.snowalert.domain.model.resort.ResortId;
import com.elandjo.snowalert.domain.model.resort.testdoubles.ResortsSpy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindResortsTest {
	private ResortsSpy resorts;
	private FindResorts findResorts;

	@Before public void
	initialise() {
		resorts = new ResortsSpy();
		findResorts = new FindResorts(resorts);
	}

	@Test public void
	findAllResorts() {
		List<Resort> expectedResorts = new ArrayList<Resort>();
		resorts.setResorts(expectedResorts);

		List<Resort> allResorts = findResorts.findAll();

		assertThat(allResorts).isEqualTo(expectedResorts);
	}

	@Test public void
	findSingleResort() {
		Resort expectedResort = new Resort();
		ResortId resortId = new ResortId("123");
		resorts.setResort(expectedResort);

		Resort singleResort = findResorts.find(resortId);

		assertThat(singleResort).isEqualTo(expectedResort);
		assertThat(resorts.findInvokedWith()).isEqualTo(resortId);
	}
}