package designpatterns.bridge;

import org.junit.Test;

/**
 * input the parameters. hidden the implementation of the method.
 */
public class test {

	@Test
	public void test_bridge() {
		Shape redCircle = new Circle(1, 2, 3, new DrawRed());
		Shape greenCircle = new Circle(4, 5, 6, new DrawGreen());
		redCircle.draw();
		greenCircle.draw();
	}
}
