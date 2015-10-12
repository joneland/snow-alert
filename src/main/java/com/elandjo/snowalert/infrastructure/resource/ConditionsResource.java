package com.elandjo.snowalert.infrastructure.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("conditions")
public class ConditionsResource {
	@GET
	@Path("{resortId}")
		public String conditionsForResort(@PathParam("resortId") String resortId) {
		return "{" +
					"\"weather\": \"Snowing\"" +
				"}";
	}
}