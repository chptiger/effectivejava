package designpattern;

import org.junit.Test;

public class Factory {
	@Test
	public void test_factory() {
		ShapeFactory shapeFactory = new ShapeFactory();
		Shape circleFactory = shapeFactory.getShape("CIRCLE");
		Shape rectangleFactory = shapeFactory.getShape("RECTANGLE");
		circleFactory.draw();
		rectangleFactory.draw();
	}
}

class ShapeFactory {

	public Shape getShape(String input) {
		if (input == null || input.length() < 1) {
			return null;
		}
		switch (input) {
		case "CIRCLE":
			return new Circle();
		case "RECTANGLE":
			return new Rectangle();
		default:
			break;
		}
		return null;
	}
}

interface Shape {
	void draw();
}

class Circle implements Shape {
	public void draw() {
		System.out.println("circle factory draw circle ...");
	}
}

class Rectangle implements Shape {
	public void draw() {
		System.out.println("rectangle factory draw rectangle ...");
	}
}