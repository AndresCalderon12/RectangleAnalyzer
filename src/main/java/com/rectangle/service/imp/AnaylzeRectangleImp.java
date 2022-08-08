package com.rectangle.service.imp;

import java.util.HashMap;

import com.rectangle.model.Point;
import com.rectangle.model.Rectangle;
import com.rectangle.service.AnalyzeRectangle;

public class AnaylzeRectangleImp implements AnalyzeRectangle {

	@Override
	public boolean isIntersection(Point topLeft1, Point bottomRight1, Point topLeft2, Point bottomRight2) {
		Rectangle rectangle1 = organizePoints(topLeft1, bottomRight1);
		Rectangle rectangle2 = organizePoints(topLeft2, bottomRight2);

		if (rectangle1.getTopLeft().getX() > rectangle2.getBottomRight().getX() // R1 is right to R2
				|| rectangle1.getBottomRight().getX() < rectangle2.getTopLeft().getX() // R1 is left to R2
				|| rectangle1.getTopLeft().getY() < rectangle2.getBottomRight().getY() // R1 is above R2
				|| rectangle1.getBottomRight().getY() > rectangle2.getTopLeft().getY()) { // R1 is below R2
			return false;
		}
		return true;
	}

	@Override
	public boolean isContainment(Point topLeft1, Point bottomRight1, Point topLeft2, Point bottomRight2) {
		Rectangle rectangle1 = organizePoints(topLeft1, bottomRight1);
		Rectangle rectangle2 = organizePoints(topLeft2, bottomRight2);

		if (rectangle1.getTopLeft().getY() > rectangle2.getTopLeft().getY() // check if the topleft point of the first
																			// rectangle is bigger than the second
				&& rectangle1.getBottomRight().getX() > rectangle2.getBottomRight().getX()) { // check if the
																								// bottomRight point of
																								// the first rectangle
																								// is bigger than the
																								// second
			return true;
		}
		return false;

	}

	@Override
	public String checkAdjacency(Point topLeft1, Point bottomRight1, Point topLeft2, Point bottomRight2) {
		Rectangle rectangle1 = organizePoints(topLeft1, bottomRight1);
		Rectangle rectangle2 = organizePoints(topLeft2, bottomRight2);

		// generate a HashMap with all the possibilities based on true-type key-value or
		// false-type
		HashMap<Boolean, String> adjacencyMap = new HashMap<Boolean, String>();
		adjacencyMap.put(isProperAdjacentRight(rectangle1, rectangle2), "proper adjacent right");
		adjacencyMap.put(isProperAdjacentTop(rectangle1, rectangle2), "proper adjacent top");
		adjacencyMap.put(isProperAdjacentLeft(rectangle1, rectangle2), "proper adjacent left");
		adjacencyMap.put(isProperAdjacentBottom(rectangle1, rectangle2), "proper adjacent bottom");
		adjacencyMap.put(isSubLineAdjacentRight(rectangle1, rectangle2), "adjacent sub-line Rigth");
		adjacencyMap.put(isSubLineAdjacentTop(rectangle1, rectangle2), "adjacent sub-line top");
		adjacencyMap.put(isSubLineAdjacentLeft(rectangle1, rectangle2), "adjacent sub-line left");
		adjacencyMap.put(isSubLineAdjacentBottom(rectangle1, rectangle2), "adjacent sub-line bottom");
		adjacencyMap.put(isAdjacentPartialRightTop(rectangle1, rectangle2), "adjacent partial rigth-top");
		adjacencyMap.put(isAdjacentPartialRightBottom(rectangle1, rectangle2), "adjacent partial rigth-bottom");
		adjacencyMap.put(isAdjacentPartialTopRigth(rectangle1, rectangle2), "adjacent partial top-right");
		adjacencyMap.put(isAdjacentPartialTopLeft(rectangle1, rectangle2), "adjacent partial top-left");
		adjacencyMap.put(isAdjacentPartialLeftTop(rectangle1, rectangle2), "adjacent partial left-top");
		adjacencyMap.put(isAdjacentPartialLeftBottom(rectangle1, rectangle2), "adjacent partial left-bottom");
		adjacencyMap.put(isAdjacentPartialBottomLeft(rectangle1, rectangle2), "adjacent partial bottom-left");
		adjacencyMap.put(isAdjacentPartialBottomRigth(rectangle1, rectangle2), "adjacent partial bottom-right");

		// validate if exist one type of adjacency and return the type that exists in
		// the value of the hashMap
		if (adjacencyMap.containsKey(true)) {
			return adjacencyMap.get(true);

		}

		return "no adjacent";
	}

	private boolean isProperAdjacentRight(Rectangle rectangle1, Rectangle rectangle2) {
		if (rectangle1.getTopLeft().getY() == rectangle2.getTopLeft().getY()
				&& rectangle1.getBottomRight().getY() == rectangle2.getBottomRight().getY()
				&& rectangle1.getBottomRight().getX() == rectangle2.getTopLeft().getX()) {
			return true;

		}
		return false;

	}

	private boolean isProperAdjacentTop(Rectangle rectangle1, Rectangle rectangle2) {
		if (rectangle1.getTopLeft().getY() == rectangle2.getBottomRight().getY()
				&& rectangle1.getBottomRight().getX() == rectangle2.getBottomRight().getX()
				&& rectangle1.getTopLeft().getX() == rectangle2.getTopLeft().getX()) {
			return true;

		}
		return false;

	}

	private boolean isProperAdjacentLeft(Rectangle rectangle1, Rectangle rectangle2) {
		if (rectangle1.getTopLeft().getY() == rectangle2.getTopLeft().getY()
				&& rectangle1.getTopLeft().getX() == rectangle2.getBottomRight().getX()
				&& rectangle1.getBottomRight().getY() == rectangle2.getBottomRight().getY()) {
			return true;

		}
		return false;

	}

	private boolean isProperAdjacentBottom(Rectangle rectangle1, Rectangle rectangle2) {
		if (rectangle1.getBottomRight().getY() == rectangle2.getTopLeft().getY()
				&& rectangle1.getBottomRight().getX() == rectangle2.getBottomRight().getX()
				&& rectangle1.getTopLeft().getX() == rectangle2.getTopLeft().getX()) {
			return true;

		}
		return false;

	}

	private boolean isSubLineAdjacentRight(Rectangle rectangle1, Rectangle rectangle2) {
		if (rectangle1.getTopLeft().getY() > rectangle2.getTopLeft().getY()
				&& rectangle1.getBottomRight().getY() < rectangle2.getBottomRight().getY()
				&& rectangle1.getBottomRight().getX() == rectangle2.getTopLeft().getX()) {
			return true;

		}
		return false;

	}

	private boolean isSubLineAdjacentTop(Rectangle rectangle1, Rectangle rectangle2) {
		if (rectangle1.getTopLeft().getX() < rectangle2.getTopLeft().getX()
				&& rectangle1.getBottomRight().getX() > rectangle2.getBottomRight().getX()
				&& rectangle1.getTopLeft().getY() == rectangle2.getBottomRight().getY()) {
			return true;

		}
		return false;

	}

	private boolean isSubLineAdjacentLeft(Rectangle rectangle1, Rectangle rectangle2) {
		if (rectangle1.getTopLeft().getY() > rectangle2.getTopLeft().getY()
				&& rectangle1.getBottomRight().getY() < rectangle2.getBottomRight().getY()
				&& rectangle1.getTopLeft().getX() == rectangle2.getBottomRight().getX()) {
			return true;

		}
		return false;

	}

	private boolean isSubLineAdjacentBottom(Rectangle rectangle1, Rectangle rectangle2) {
		if (rectangle1.getTopLeft().getX() < rectangle2.getTopLeft().getX()
				&& rectangle1.getBottomRight().getX() > rectangle2.getBottomRight().getX()
				&& rectangle1.getBottomRight().getY() == rectangle2.getTopLeft().getY()) {
			return true;

		}
		return false;

	}

	private boolean isAdjacentPartialRightTop(Rectangle rectangle1, Rectangle rectangle2) {
		if (rectangle1.getBottomRight().getY() < rectangle2.getBottomRight().getY()
				&& rectangle1.getTopLeft().getY() > rectangle2.getBottomRight().getY()
				&& rectangle1.getTopLeft().getY() < rectangle2.getTopLeft().getY()
				&& rectangle1.getBottomRight().getX() == rectangle2.getTopLeft().getX()) {
			return true;

		}
		return false;

	}

	private boolean isAdjacentPartialRightBottom(Rectangle rectangle1, Rectangle rectangle2) {
		if (rectangle1.getTopLeft().getY() > rectangle2.getTopLeft().getY()
				&& rectangle1.getBottomRight().getY() < rectangle2.getTopLeft().getY()
				&& rectangle1.getBottomRight().getY() > rectangle2.getBottomRight().getY()
				&& rectangle1.getBottomRight().getX() == rectangle2.getTopLeft().getX()) {
			return true;

		}
		return false;

	}

	private boolean isAdjacentPartialTopRigth(Rectangle rectangle1, Rectangle rectangle2) {
		if (rectangle1.getTopLeft().getX() < rectangle2.getTopLeft().getX()
				&& rectangle1.getBottomRight().getX() > rectangle2.getTopLeft().getX()
				&& rectangle1.getBottomRight().getX() < rectangle2.getBottomRight().getX()
				&& rectangle1.getTopLeft().getY() == rectangle2.getBottomRight().getY()) {
			return true;

		}
		return false;

	}

	private boolean isAdjacentPartialTopLeft(Rectangle rectangle1, Rectangle rectangle2) {
		if (rectangle1.getBottomRight().getX() > rectangle2.getBottomRight().getX()
				&& rectangle1.getTopLeft().getX() < rectangle2.getBottomRight().getX()
				&& rectangle1.getTopLeft().getX() > rectangle2.getTopLeft().getX()
				&& rectangle1.getTopLeft().getY() == rectangle2.getBottomRight().getY()) {
			return true;

		}
		return false;

	}

	private boolean isAdjacentPartialLeftTop(Rectangle rectangle1, Rectangle rectangle2) {
		if (rectangle1.getTopLeft().getY() > rectangle2.getBottomRight().getY()
				&& rectangle1.getBottomRight().getY() < rectangle2.getBottomRight().getY()
				&& rectangle1.getTopLeft().getY() < rectangle2.getTopLeft().getY()
				&& rectangle1.getTopLeft().getX() == rectangle2.getBottomRight().getX()) {
			return true;

		}
		return false;

	}

	private boolean isAdjacentPartialLeftBottom(Rectangle rectangle1, Rectangle rectangle2) {
		if (rectangle1.getTopLeft().getY() > rectangle2.getTopLeft().getY()
				&& rectangle1.getBottomRight().getY() < rectangle2.getTopLeft().getY()
				&& rectangle1.getBottomRight().getY() > rectangle2.getBottomRight().getY()
				&& rectangle1.getTopLeft().getX() == rectangle2.getBottomRight().getX()) {
			return true;

		}
		return false;

	}

	private boolean isAdjacentPartialBottomLeft(Rectangle rectangle1, Rectangle rectangle2) {
		if (rectangle1.getTopLeft().getX() < rectangle2.getBottomRight().getX()
				&& rectangle1.getBottomRight().getX() > rectangle2.getBottomRight().getX()
				&& rectangle1.getTopLeft().getX() > rectangle2.getTopLeft().getX()
				&& rectangle1.getBottomRight().getY() == rectangle2.getTopLeft().getY()) {
			return true;

		}
		return false;

	}

	private boolean isAdjacentPartialBottomRigth(Rectangle rectangle1, Rectangle rectangle2) {
		if (rectangle1.getTopLeft().getX() < rectangle2.getTopLeft().getX()
				&& rectangle1.getBottomRight().getX() > rectangle2.getTopLeft().getX()
				&& rectangle1.getBottomRight().getX() < rectangle2.getBottomRight().getX()
				&& rectangle1.getBottomRight().getY() == rectangle2.getTopLeft().getY()) {
			return true;

		}
		return false;

	}

	private static Rectangle organizePoints(Point topLeft, Point bottomRight) {

		// Check if the points are correctly topLeft and BottomRight otherwise
		// changed to match topLeft and BottomRight
		if (topLeft.getY() < bottomRight.getY()) {
			Point auxL = new Point(topLeft.getX(), bottomRight.getY());
			Point auxR = new Point(bottomRight.getX(), topLeft.getY());
			topLeft = auxL;
			bottomRight = auxR;

		}
		Rectangle rectangle = new Rectangle(topLeft, bottomRight);
		return rectangle;

	}

}
