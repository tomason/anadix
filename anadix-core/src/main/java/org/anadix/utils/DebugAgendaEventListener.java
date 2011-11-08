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

/**
 * My implementation of AgendaEventListener from Drools. It is used to log the information to given logger.
 *
 * @author tomason
 * @version $Id: $
 * @since 0.4.0
 */
public class DebugAgendaEventListener extends DefaultAgendaEventListener {
	private final Logger logger;
	private final Level level;

	/**
	 * Constructor
	 *
	 * @param logger - logger to log to
	 */
	public DebugAgendaEventListener(Logger logger) {
		this(logger, Level.DEBUG);
	}

	/**
	 * Constructor
	 *
	 * @param logger - logger to log to
	 * @param level - level to log messages with
	 */
	public DebugAgendaEventListener(Logger logger, Level level) {
		this.logger = logger;
		this.level = level;
	}

	/** {@inheritDoc} */
	@Override
	public void activationCreated(ActivationCreatedEvent event) {
		logger.log(level, event);
	}

	/** {@inheritDoc} */
	@Override
	public void activationCancelled(ActivationCancelledEvent event) {
		logger.log(level, event);
	}

	/** {@inheritDoc} */
	@Override
	public void beforeActivationFired(BeforeActivationFiredEvent event) {
		logger.log(level, event);
	}

	/** {@inheritDoc} */
	@Override
	public void afterActivationFired(AfterActivationFiredEvent event) {
		logger.log(level, event);
	}

	/** {@inheritDoc} */
	@Override
	public void agendaGroupPushed(AgendaGroupPushedEvent event) {
		logger.log(level, event);
	}

	/** {@inheritDoc} */
	@Override
	public void agendaGroupPopped(AgendaGroupPoppedEvent event) {
		logger.log(level, event);
	}

}
