package com.elandjo.snowalert.infrastructure.resource;

import com.codahale.metrics.annotation.Timed;
import com.elandjo.snowalert.domain.model.resort.ResortConditions;
import com.elandjo.snowalert.infrastructure.converter.JSONConverters;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/conditions")
public class ResortConditionsResource {
	private JSONConverters converters;

	public ResortConditionsResource(JSONConverters converters) {
		this.converters = converters;
	}

	@GET
	@Timed
	public String conditionsAtResort(@QueryParam("resortId") String resortId) {
		return converters.convert(new ResortConditions());
	}
}