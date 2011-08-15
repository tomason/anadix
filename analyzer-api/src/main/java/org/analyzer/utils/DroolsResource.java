package org.analyzer.utils;

import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.ResourceConfiguration;
import org.drools.builder.ResourceType;
import org.drools.io.Resource;

public class DroolsResource {
	private final Resource resource;
	private final ResourceType type;
	private final ResourceConfiguration configuration;

	public DroolsResource(Resource resource, ResourceType type) {
		this(resource, type, null);
	}

	public DroolsResource(Resource resource, ResourceType type, ResourceConfiguration configuration) {
		if (resource == null) {
			throw new NullPointerException("Resource can't be null");
		}
		if (type == null) {
			throw new NullPointerException("Type can't be null");
		}

		this.resource = resource;
		this.type = type;
		this.configuration = configuration;
	}

	public Resource getResource() {
		return resource;
	}

	public ResourceType getType() {
		return type;
	}

	public ResourceConfiguration getConfiguration() {
		return configuration;
	}

	public void insertInto(KnowledgeBuilder kbuilder) {
		if (configuration == null) {
			kbuilder.add(getResource(), getType());
		} else {
			kbuilder.add(getResource(), getType(), getConfiguration());
		}
	}
}
