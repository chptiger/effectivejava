package designpatterns.bridge;

public class DrawGreen implements DrawAPI {

	@Override
	public void draw(int radius, int x, int y) {
		System.out.println("Draw Green Circle with radius " + radius + " in the point of (" + x + ", " + y + ")");
	}

}
