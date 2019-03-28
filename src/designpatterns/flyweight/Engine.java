package designpatterns.flyweight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Engine for a vehicle
 * @author xinxu
 *
 */
public class Engine {
	/**
	 * logger
	 */
	private final static Logger LOG = LoggerFactory.getLogger(Engine.class);
	
	public void start() {
		LOG.info("Engine is starting ...");
	}
	
	public void stop() {
		LOG.info("Engine is stopping!");
	}
}
