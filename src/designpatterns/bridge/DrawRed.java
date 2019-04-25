package designpatterns.bridge;

public class DrawRed implements DrawAPI {

	public void draw(int radius, int x, int y) {
		System.out.println("Draw Red Circle with radius " + radius + " in the point of (" + x + ", " + y + ")");

	}
}
