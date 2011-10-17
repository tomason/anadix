package org.anadix.utils;

import org.drools.event.rule.ActivationCancelledEvent;
import org.drools.event.rule.ActivationCreatedEvent;
import org.drools.event.rule.AfterActivationFiredEvent;
import org.drools.event.rule.AgendaGroupPoppedEvent;
import org.drools.event.rule.AgendaGroupPushedEvent;
import org.drools.event.rule.BeforeActivationFiredEvent;
import org.drools.event.rule.DefaultAgendaEventListener;
import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

public class DebugAgendaEventListener extends DefaultAgendaEventListener {
	private final Logger logger;
	private final Level level;

	public DebugAgendaEventListener(Logger logger) {
		this(logger, Level.DEBUG);
	}

	public DebugAgendaEventListener(Logger logger, Level level) {
		this.logger = logger;
		this.level = level;
	}

	@Override
	public void activationCreated(ActivationCreatedEvent event) {
		logger.log(level, event);
	}

	@Override
	public void activationCancelled(ActivationCancelledEvent event) {
		logger.log(level, event);
	}

	@Override
	public void beforeActivationFired(BeforeActivationFiredEvent event) {
		logger.log(level, event);
	}

	@Override
	public void afterActivationFired(AfterActivationFiredEvent event) {
		logger.log(level, event);
	}

	@Override
	public void agendaGroupPushed(AgendaGroupPushedEvent event) {
		logger.log(level, event);
	}

	@Override
	public void agendaGroupPopped(AgendaGroupPoppedEvent event) {
		logger.log(level, event);
	}

}
