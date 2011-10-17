package org.anadix.utils;

import org.drools.runtime.rule.Activation;
import org.drools.runtime.rule.AgendaFilter;

public class PackageAgendaFilter implements AgendaFilter {
	private final String acceptedPackage;

	public PackageAgendaFilter(String acceptedPackage) {
		if (acceptedPackage == null) {
			throw new NullPointerException("acceptedPackage must not be null");
		}
		this.acceptedPackage = acceptedPackage.toLowerCase();
	}

	public boolean accept(Activation activation) {
		//activation.getRule().getClass().getPackage().toString().toLowerCase();
		String activationPackage = activation.getRule().getPackageName().toLowerCase();

		return (activationPackage.startsWith(acceptedPackage));
	}

}
