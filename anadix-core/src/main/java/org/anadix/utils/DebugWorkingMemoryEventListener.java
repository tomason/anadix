package org.anadix.utils;

import org.drools.event.rule.DefaultWorkingMemoryEventListener;
import org.drools.event.rule.ObjectInsertedEvent;
import org.drools.event.rule.ObjectRetractedEvent;
import org.drools.event.rule.ObjectUpdatedEvent;
import org.slf4j.Logger;

/**
 * My implementation of WorkingMemoryEventListener from Drools. It is used to log the information to given logger.
 *
 * @author tomason
 * @version $Id: $
 * @since 0.4.0
 */
public class DebugWorkingMemoryEventListener extends DefaultWorkingMemoryEventListener {
	private final Logger logger;

	/**
	 * Constructor
	 *
	 * @param logger - logger to log to
	 */
	public DebugWorkingMemoryEventListener(Logger logger) {
	    this.logger = logger;
	}

	/** {@inheritDoc} */
	@Override
	public void objectInserted(ObjectInsertedEvent event) {
		logger.debug("{}", event);
	}

	/** {@inheritDoc} */
	@Override
	public void objectUpdated(ObjectUpdatedEvent event) {
		logger.debug("{}", event);
	}

	/** {@inheritDoc} */
	@Override
	public void objectRetracted(ObjectRetractedEvent event) {
		logger.debug("{}", event);
	}

}
