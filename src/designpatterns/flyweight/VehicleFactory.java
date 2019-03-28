package designpatterns.flyweight;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://github.com/eugenp/tutorials/tree/master/patterns/design-patterns/src/main/java/com/baeldung/flyweight 

 * Factory which implements the Flyweight pattern to return an existing vehicle
 * if present or a new one otherwise.
 * 
 * https://www.baeldung.com/java-flyweight 
 * we’ll create the VehicleFactory. Building a new vehicle is a very expensive operation so the factory will only create one vehicle per color.
 * 
 * Note: 
 * 	1.To avoid java.lang.OutOfMemoryError
 * 	2.It’s very important that the flyweight objects are immutable: any operation on the state must be performed by the factory.
 *  3.Notice how the client code can only affect the extrinsic state of the object (the color of our vehicle) passing it as an argument to the createVehicle method.
 * 
 * @author xinxu
 */
public class VehicleFactory {
	
	private final static Logger LOG = LoggerFactory.getLogger(VehicleFactory.class);

	/**
	 * Stores the already created vehicles
	 */
	private static Map<Color, Vehicle> vehicleCache = new HashMap<>();
	
	private static Vehicle createVehicle(Color color) {
		/**
		 * Looks for the requested vehicle into the cache.
		 * If the vehicle doesn't exist, a new one is created and put into cache
		 */
		return vehicleCache.computeIfAbsent(color,  newColor -> {
			LOG.info("new car is created with color " + newColor.toString());
			Engine engine = new Engine();
			return new Car(engine, newColor);
		});
	}
	
//	public static final Color[] colors = { Color.black, Color.blue, Color.cyan, Color.GREEN };
	public static final Color[] colors = { Color.black, Color.blue};

	@Test
	public void test_flyweight() {
		for (int i = 0; i < 3; i++) {
			Vehicle car = createVehicle(getRandColor());
			car.start();
		}
	}
	
	private Color getRandColor() {
		Random r = new Random();
		int randInt = r.nextInt(colors.length);
		return colors[randInt];
	}
}
