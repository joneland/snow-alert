package com.elandjo.snowalert.application.resort;

import com.elandjo.snowalert.domain.model.resort.Resort;
import com.elandjo.snowalert.testdoubles.ResortsStub;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindResortsTest {
	private ResortsStub resorts;
	private FindResorts findResorts;

	@Before public void
	initialise() {
		resorts = new ResortsStub();
		findResorts = new FindResorts(resorts);
	}

	@Test public void
	getsAllResorts() {
		List<Resort> expectedResorts = new ArrayList<Resort>();
		resorts.setResorts(expectedResorts);

		List<Resort> allResorts = findResorts.findAll();

		assertThat(allResorts).isEqualTo(expectedResorts);
	}
}