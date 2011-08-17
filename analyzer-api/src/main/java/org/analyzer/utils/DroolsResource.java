package org.analyzer.utils;

import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.ResourceConfiguration;
import org.drools.builder.ResourceType;
import org.drools.io.Resource;

/**
 * Resource for Drools engine.
 * Convinience class to group Resource, ResourceType and ResourceConfiguration
 * into one class.
 * 
 * @author tomason
 */
public class DroolsResource {
	private final Resource resource;
	private final ResourceType type;
	private final ResourceConfiguration configuration;

	/**
	 * Constructs DroolsResource without configuration
	 * 
	 * @param resource - Resource as returned by org.drools.io.ResourceFactory
	 * @param type - type of resource
	 */
	public DroolsResource(Resource resource, ResourceType type) {
		this(resource, type, null);
	}

	/**
	 * Constructs DroolsResource without configuration
	 * 
	 * @param resource - Resource as returned by org.drools.io.ResourceFactory
	 * @param type - type of resource
	 * @param configuration - configuration for the KnowledgeBuilder
	 */
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

	/**
	 * @return resource
	 */
	public Resource getResource() {
		return resource;
	}

	/**
	 * @return type of resource
	 */
	public ResourceType getType() {
		return type;
	}

	/**
	 * @return resource configuration
	 */
	public ResourceConfiguration getConfiguration() {
		return configuration;
	}

	/**
	 * Adds this resource to given KnowledgeBuilder to be compiled
	 * 
	 * @param kbuilder - KnowledgeBuilder to add this resource to
	 */
	public void insertInto(KnowledgeBuilder kbuilder) {
		if (configuration == null) {
			kbuilder.add(getResource(), getType());
		} else {
			kbuilder.add(getResource(), getType(), getConfiguration());
		}
	}
}
