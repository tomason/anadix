/*
 * Copyright 2011 Tomas Schlosser
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.anadix.utils;

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
 * @version $Id: $
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
	 * Gets the resource represented by this instance
	 *
	 * @return resource
	 */
	public Resource getResource() {
		return resource;
	}

	/**
	 * Gets the type of resource represented by this instance
	 *
	 * @return type of resource
	 */
	public ResourceType getType() {
		return type;
	}

	/**
	 * Gets the configuration of resource represented by this instance
	 *
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
