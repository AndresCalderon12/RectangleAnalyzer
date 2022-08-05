package com.rectangle.service.imp;

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

		// check proper Adjacent in the four possible positions
		if (isProperAdjacentRight(rectangle1, rectangle2)) {

			return "proper adjacent right";

		} else if (isProperAdjacentTop(rectangle1, rectangle2)) {

			return "proper adjacent top";

		} else if (isProperAdjacentLeft(rectangle1, rectangle2)) {
			return "proper adjacent left";

		} else if (isProperAdjacentBottom(rectangle1, rectangle2)) {
			return "proper adjacent bottom";

		}
		// check sub line Adjacent in the four possible positions

		if (isSubLineAdjacentRight(rectangle1, rectangle2)) {
			return "adjacent sub-line Rigth";

		} else if (isSubLineAdjacentTop(rectangle1, rectangle2)) {
			return "adjacent sub-line top";

		} else if (isSubLineAdjacentLeft(rectangle1, rectangle2)) {
			return "adjacent sub-line left";

		} else if (isSubLineAdjacentBottom(rectangle1, rectangle2)) {
			return "adjacent sub-line bottom";

		}
		// check partial Adjacent in the eight possible positions

		if (isAdjacentPartialRightTop(rectangle1, rectangle2)) {
			return "adjacent partial rigth-top";

		} else if (isAdjacentPartialRightBottom(rectangle1, rectangle2)) {
			return "adjacent partial rigth-bottom";

		} else if (isAdjacentPartialTopRigth(rectangle1, rectangle2)) {
			return "adjacent partial top-right";

		} else if (isAdjacentPartialTopLeft(rectangle1, rectangle2)) {
			return "adjacent partial top-left";

		} else if (isAdjacentPartialLeftTop(rectangle1, rectangle2)) {
			return "adjacent partial left-top";

		} else if (isAdjacentPartialLeftBottom(rectangle1, rectangle2)) {
			return "adjacent partial left-bottom";

		} else if (isAdjacentPartialBottomLeft(rectangle1, rectangle2)) {
			return "adjacent partial bottom-left";

		} else if (isAdjacentPartialBottomRigth(rectangle1, rectangle2)) {
			return "adjacent partial bottom-right";

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
