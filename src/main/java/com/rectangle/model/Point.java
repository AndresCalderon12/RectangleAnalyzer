package com.rectangle.model;

import lombok.Data;

@Data
public class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		super();
		this.setX(x);
		this.setY(y);
	}


}
