package com.rectangle.main;

import java.util.Scanner;

import com.rectangle.model.Point;
import com.rectangle.service.imp.AnaylzeRectangleImp;

public class RectangleAnalyzer {
	/**
	 * this program is created to analyze rectangles and features that exist among
	 * rectangles more specifically intersection, containment and adjacency
	 * 
	 * @param args
	 * 
	 **/

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("enter the fist rectangle X and Y coordenate for the topLeft Point separeted by comma");
			String input1 = sc.nextLine();
			System.out.println("enter the first rectangle X and Y coordenate for the bottom Point separeted by comma");
			String input2 = sc.nextLine();
			System.out
					.println("enter the second rectangle X and Y coordenate for the topLeft Point separeted by comma");
			String input3 = sc.nextLine();
			System.out.println("enter the second rectangle X and Y coordenate for the bottom Point separeted by comma");
			String input4 = sc.nextLine();

			String[] topLeft1 = input1.split(",");
			int topLeftX1 = Integer.valueOf(topLeft1[0]);
			int topLeftY1 = Integer.valueOf(topLeft1[1]);

			String[] bottomRight1 = input2.split(",");
			int bottomRgihtX1 = Integer.valueOf(bottomRight1[0]);
			int bottomRgihty1 = Integer.valueOf(bottomRight1[1]);

			String[] topLeft2 = input3.split(",");
			int topLeftX2 = Integer.valueOf(topLeft2[0]);
			int topLeftY2 = Integer.valueOf(topLeft2[1]);

			String[] bottomRight2 = input4.split(",");
			int bottomRgihtX2 = Integer.valueOf(bottomRight2[0]);
			int bottomRgihty2 = Integer.valueOf(bottomRight2[1]);

			Point l1 = new Point(topLeftX1, topLeftY1);
			Point r1 = new Point(bottomRgihtX1, bottomRgihty1);
			Point l2 = new Point(topLeftX2, topLeftY2);
			Point r2 = new Point(bottomRgihtX2, bottomRgihty2);

			getReport(l1, r1, l2, r2);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void getReport(Point l1, Point r1, Point l2, Point r2) {
		// Appendix 1
		AnaylzeRectangleImp analyzeRectangle = new AnaylzeRectangleImp();

		if (analyzeRectangle.isIntersection(l1, r1, l2, r2)) {
			System.out.println("the two rectangles are intersecting with each other");
		} else {
			System.out.println("the two rectangles are not intersecting with each other");

		}

		// Appendix 2
		if (analyzeRectangle.isContainment(l1, r1, l2, r2)) {
			System.out.println("the second rectangle is contained in first one");

		} else if (analyzeRectangle.isContainment(l2, r2, l1, r1)) {
			System.out.println("the first rectangle is contained in second one");

		} else {
			System.out.println("the rectangles are not contained with each other");

		}

		if (analyzeRectangle.isIntersection(l2, r2, l1, r1) && !(analyzeRectangle.isContainment(l1, r1, l2, r2)
				|| analyzeRectangle.isContainment(l2, r2, l1, r1))) {
			System.out.println("the rectangles are intersecting but not contained with each other");

		}

		// Appendix 3
		System.out.println("the reactangles are :" + " " + analyzeRectangle.checkAdjacency(l1, r1, l2, r2));

	}

}
