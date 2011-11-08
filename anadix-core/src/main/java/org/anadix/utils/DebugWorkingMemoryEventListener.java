package org.anadix.utils;

import org.drools.event.rule.DefaultWorkingMemoryEventListener;
import org.drools.event.rule.ObjectInsertedEvent;
import org.drools.event.rule.ObjectRetractedEvent;
import org.drools.event.rule.ObjectUpdatedEvent;
import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

/**
 * My implementation of WorkingMemoryEventListener from Drools. It is used to log the information to given logger.
 *
 * @author tomason
 * @version $Id: $
 * @since 0.4.0
 */
public class DebugWorkingMemoryEventListener extends DefaultWorkingMemoryEventListener {
	private final Logger logger;
	private final Level level;

	/**
	 * Constructor
	 *
	 * @param logger - logger to log to
	 */
	public DebugWorkingMemoryEventListener(Logger logger) {
		this(logger, Level.DEBUG);
	}

	/**
	 * Constructor
	 *
	 * @param logger - logger to log to
	 * @param level - level to log messages with
	 */
	public DebugWorkingMemoryEventListener(Logger logger, Level level) {
		this.logger = logger;
		this.level = level;
	}

	/** {@inheritDoc} */
	@Override
	public void objectInserted(ObjectInsertedEvent event) {
		logger.log(level, event);
	}

	/** {@inheritDoc} */
	@Override
	public void objectUpdated(ObjectUpdatedEvent event) {
		logger.log(level, event);
	}

	/** {@inheritDoc} */
	@Override
	public void objectRetracted(ObjectRetractedEvent event) {
		logger.log(level, event);
	}

}
