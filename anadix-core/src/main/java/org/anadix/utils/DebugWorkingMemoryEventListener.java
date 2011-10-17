package org.anadix.utils;

import org.drools.event.rule.DefaultWorkingMemoryEventListener;
import org.drools.event.rule.ObjectInsertedEvent;
import org.drools.event.rule.ObjectRetractedEvent;
import org.drools.event.rule.ObjectUpdatedEvent;
import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

public class DebugWorkingMemoryEventListener extends DefaultWorkingMemoryEventListener {
	private final Logger logger;
	private final Level level;

	public DebugWorkingMemoryEventListener(Logger logger) {
		this(logger, Level.DEBUG);
	}

	public DebugWorkingMemoryEventListener(Logger logger, Level level) {
		this.logger = logger;
		this.level = level;
	}

	@Override
	public void objectInserted(ObjectInsertedEvent event) {
		logger.log(level, event);
	}

	@Override
	public void objectUpdated(ObjectUpdatedEvent event) {
		logger.log(level, event);
	}

	@Override
	public void objectRetracted(ObjectRetractedEvent event) {
		logger.log(level, event);
	}

}
