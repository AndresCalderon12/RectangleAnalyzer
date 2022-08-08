package com.rectangle.model;

import lombok.Data;

@Data
public class Rectangle {
	private Point topLeft;
	private Point bottomRight;

	public Rectangle(Point topLeft, Point bottomRight) {

		if (topLeft.getX() == bottomRight.getX() && topLeft.getY() == bottomRight.getY()) {
			throw new IllegalArgumentException("The two points do not define a Rectangle.");
		}

		this.topLeft = topLeft;
		this.bottomRight = bottomRight;
	}

}
