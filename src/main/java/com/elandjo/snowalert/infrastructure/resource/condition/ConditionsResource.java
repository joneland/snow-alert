package com.elandjo.snowalert.infrastructure.resource.condition;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("conditions")
public class ConditionsResource {
	@GET
	@Path("{resortId}")
		public Response conditionsForResort(@PathParam("resortId") String resortId) {
			return Response.ok(new Conditions("Snowing"), MediaType.APPLICATION_JSON).build();
	}
}