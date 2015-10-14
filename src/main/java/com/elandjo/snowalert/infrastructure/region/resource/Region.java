package com.elandjo.snowalert.infrastructure.region.resource;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class Region {
	private String name;
	private URI baseUri;
	private List<Resort> resorts = new ArrayList<Resort>();

	public Region(String name, URI baseUri) {
		this.name = name;
		this.baseUri = baseUri;
	}

	public void withResort(String id, String name) {
		resorts.add(new Resort(id, name));
	}

	@JsonProperty
	public String getName() {
		return name;
	}

	@JsonProperty
	public List<Resort> getResorts() {
		return resorts;
	}

	class Resort {
		private final String name;
		private final String link;

		public Resort(String id, String name) {
			this.name = name;
			this.link = baseUri + "resort/" + id;
		}

		@JsonProperty
		public String getName() {
			return name;
		}

		@JsonProperty
		public String getLink() {
			return link;
		}
	}
}
