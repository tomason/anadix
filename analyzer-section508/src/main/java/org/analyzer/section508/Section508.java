package org.analyzer.section508;

import java.util.ArrayList;
import java.util.Collection;

import org.analyzer.ConditionSet;
import org.analyzer.ElementFactory;
import org.analyzer.html.HTMLElementFactory;
import org.analyzer.utils.DroolsResource;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;


public class Section508 implements ConditionSet {
	private static final String classpath = "org/analyzer/section508";

	@Override
	public String getName() {
		return "Section 508";
	}

	@Override
	public Collection<DroolsResource> getDroolsResources() {
		Collection<DroolsResource> result = new ArrayList<DroolsResource>();

		result.add(new DroolsResource(
				ResourceFactory.newClassPathResource(classpath + "/paragraph-a.drl"),
				ResourceType.DRL));

		result.add(new DroolsResource(
				ResourceFactory.newClassPathResource(classpath + "/paragraph-i.drl"),
				ResourceType.DRL));

		return result;
	}

	@Override
	public Class<? extends ElementFactory> getElementFactoryUsed() {
		return HTMLElementFactory.class;
	}
}
