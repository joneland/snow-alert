package com.elandjo.snowalert.infrastructure.resource;

import com.codahale.metrics.annotation.Timed;
import com.elandjo.snowalert.application.resort.GatherResortConditions;
import com.elandjo.snowalert.domain.model.resort.ResortConditions;
import com.elandjo.snowalert.domain.model.resort.ResortId;
import com.elandjo.snowalert.infrastructure.converter.JSONConverters;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/conditions")
@Produces(APPLICATION_JSON)
public class ResortConditionsResource {
	private final GatherResortConditions gatherResortConditions;
	private final JSONConverters converters;

	public ResortConditionsResource(final GatherResortConditions gatherResortConditions, final JSONConverters converters) {
		this.gatherResortConditions = gatherResortConditions;
		this.converters = converters;
	}

	@GET
	@Timed
	public String conditionsAtResort(@QueryParam("resortId") final String resortId) {
		ResortConditions resortConditions = gatherResortConditions.atResort(new ResortId(resortId));
		return converters.convert(resortConditions);
	}
}