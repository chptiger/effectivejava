package designpatterns.flyweight;

import java.awt.Color;

/**
 * Interface for a vehicle
 * @author xinxu
 *
 */
public interface Vehicle {
	public void start();
	public void stop();
	public Color getColor();
}
