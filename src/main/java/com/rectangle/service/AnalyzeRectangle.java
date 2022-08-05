package com.rectangle.service;

import com.rectangle.model.Point;

public interface AnalyzeRectangle {

	boolean isIntersection(Point topLeft1, Point bottomRight1, Point topLeft2, Point bottomRight2);

	boolean isContainment(Point topLeft1, Point bottomRight1, Point topLeft2, Point bottomRight2);

	String checkAdjacency(Point topLeft1, Point bottomRight1, Point topLeft2, Point bottomRight2);
}
