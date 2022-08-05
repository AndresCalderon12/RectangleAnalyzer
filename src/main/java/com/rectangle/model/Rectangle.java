package com.rectangle.model;

import lombok.Data;

@Data
public class Rectangle {
	private Point topLeft;
	private Point bottomRight;

	public Rectangle(Point topLeft, Point bottomRight) {
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;
	}

}
