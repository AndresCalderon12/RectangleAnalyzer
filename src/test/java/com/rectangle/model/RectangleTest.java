package com.rectangle.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.rectangle.service.imp.AnaylzeRectangleImp;

public class RectangleTest {

	private AnaylzeRectangleImp analyzeRectangle;

	@Before
	public void setup() {
		analyzeRectangle = new AnaylzeRectangleImp();
	}

	@Test
	public void validateIntersection() {
		Point l1 = new Point(4, 4);
		Point r1 = new Point(7, 1);
		Point l2 = new Point(6, 3);
		Point r2 = new Point(8, 2);

		Boolean intersection = analyzeRectangle.isIntersection(l1, r1, l2, r2);
		assertTrue(intersection);
	}

	@Test
	public void validateNotIntersection() {
		Point l1 = new Point(4, 4);
		Point r1 = new Point(7, 1);
		Point l2 = new Point(8, 3);
		Point r2 = new Point(10, 2);

		Boolean intersection = analyzeRectangle.isIntersection(l1, r1, l2, r2);
		assertFalse(intersection);
	}

	@Test
	public void validateContaiment() {
		Point l1 = new Point(4, 4);
		Point r1 = new Point(7, 1);
		Point l2 = new Point(5, 3);
		Point r2 = new Point(6, 2);

		Boolean contaiment = analyzeRectangle.isContainment(l1, r1, l2, r2);
		assertTrue(contaiment);
	}

	@Test
	public void validateNotContaiment() {
		Point l1 = new Point(4, 4);
		Point r1 = new Point(7, 1);
		Point l2 = new Point(9, 5);
		Point r2 = new Point(11, 3);
		Boolean contaiment = analyzeRectangle.isContainment(l1, r1, l2, r2);
		assertFalse(contaiment);
	}

	@Test
	public void validateIntersectionAndNotContaiment() {
		Point l1 = new Point(4, 6);
		Point r1 = new Point(7, 3);
		Point l2 = new Point(6, 5);
		Point r2 = new Point(8, 4);

		Boolean contaiment = analyzeRectangle.isContainment(l1, r1, l2, r2);
		Boolean intersection = analyzeRectangle.isIntersection(l1, r1, l2, r2);
		assertTrue(intersection);
		assertFalse(contaiment);
	}

	@Test
	public void validateProperAdjacenteRight() {
		Point l1 = new Point(4, 4);
		Point r1 = new Point(7, 1);
		Point l2 = new Point(7, 4);
		Point r2 = new Point(10, 1);

		String adjacent = analyzeRectangle.checkAdjacency(l1, r1, l2, r2);
		assertEquals("proper adjacent right", adjacent);
	}

	@Test
	public void validateProperAdjacenteTop() {
		Point l1 = new Point(4, 4);
		Point r1 = new Point(7, 1);
		Point l2 = new Point(4, 7);
		Point r2 = new Point(7, 4);
		String adjacent = analyzeRectangle.checkAdjacency(l1, r1, l2, r2);
		assertEquals("proper adjacent top", adjacent);
	}

	@Test
	public void validateProperAdjacenteLeft() {
		Point l1 = new Point(4, 4);
		Point r1 = new Point(7, 1);
		Point l2 = new Point(0, 4);
		Point r2 = new Point(4, 1);

		String adjacent = analyzeRectangle.checkAdjacency(l1, r1, l2, r2);
		assertEquals("proper adjacent left", adjacent);
	}

	@Test
	public void validateProperAdjacenteBottom() {
		Point l1 = new Point(4, 7);
		Point r1 = new Point(7, 5);
		Point l2 = new Point(4, 5);
		Point r2 = new Point(7, 3);

		String adjacent = analyzeRectangle.checkAdjacency(l1, r1, l2, r2);
		assertEquals("proper adjacent bottom", adjacent);
	}

	@Test
	public void validateAdjacentSubLineRight() {
		Point l1 = new Point(4, 6);
		Point r1 = new Point(7, 3);
		Point l2 = new Point(7, 5);
		Point r2 = new Point(8, 4);

		String adjacent = analyzeRectangle.checkAdjacency(l1, r1, l2, r2);
		assertEquals("adjacent sub-line Rigth", adjacent);
	}

	@Test
	public void validateAdjacentSubLineTop() {
		Point l1 = new Point(4, 6);
		Point r1 = new Point(7, 3);
		Point l2 = new Point(5, 8);
		Point r2 = new Point(6, 6);

		String adjacent = analyzeRectangle.checkAdjacency(l1, r1, l2, r2);
		assertEquals("adjacent sub-line top", adjacent);
	}

	@Test
	public void validateAdjacentSubLineLeft() {
		Point l1 = new Point(4, 6);
		Point r1 = new Point(7, 3);
		Point l2 = new Point(2, 5);
		Point r2 = new Point(4, 4);

		String adjacent = analyzeRectangle.checkAdjacency(l1, r1, l2, r2);
		assertEquals("adjacent sub-line left", adjacent);
	}

	@Test
	public void validateAdjacentSubLineBottom() {
		Point l1 = new Point(4, 6);
		Point r1 = new Point(7, 3);
		Point l2 = new Point(5, 3);
		Point r2 = new Point(6, 2);

		String adjacent = analyzeRectangle.checkAdjacency(l1, r1, l2, r2);
		assertEquals("adjacent sub-line bottom", adjacent);
	}

	@Test
	public void validatePartialAdjacentRightTop() {
		Point l1 = new Point(4, 6);
		Point r1 = new Point(7, 3);
		Point l2 = new Point(7, 7);
		Point r2 = new Point(8, 5);

		String adjacent = analyzeRectangle.checkAdjacency(l1, r1, l2, r2);
		assertEquals("adjacent partial rigth-top", adjacent);
	}

	@Test
	public void validatePartialAdjacentRightBottom() {
		Point l1 = new Point(4, 6);
		Point r1 = new Point(7, 3);
		Point l2 = new Point(7, 4);
		Point r2 = new Point(8, 2);
		String adjacent = analyzeRectangle.checkAdjacency(l1, r1, l2, r2);
		assertEquals("adjacent partial rigth-bottom", adjacent);
	}

	@Test
	public void validatePartialAdjacentTopRight() {
		Point l1 = new Point(4, 6);
		Point r1 = new Point(7, 3);
		Point l2 = new Point(6, 8);
		Point r2 = new Point(8, 6);

		String adjacent = analyzeRectangle.checkAdjacency(l1, r1, l2, r2);
		assertEquals("adjacent partial top-right", adjacent);
	}

	@Test
	public void validatePartialAdjacentTopLeft() {
		Point l1 = new Point(4, 6);
		Point r1 = new Point(7, 3);
		Point l2 = new Point(3, 8);
		Point r2 = new Point(5, 6);

		String adjacent = analyzeRectangle.checkAdjacency(l1, r1, l2, r2);
		assertEquals("adjacent partial top-left", adjacent);
	}

	@Test
	public void validatePartialAdjacentLeftTop() {
		Point l1 = new Point(4, 6);
		Point r1 = new Point(7, 3);
		Point l2 = new Point(2, 7);
		Point r2 = new Point(4, 5);

		String adjacent = analyzeRectangle.checkAdjacency(l1, r1, l2, r2);
		assertEquals("adjacent partial left-top", adjacent);
	}

	@Test
	public void validatePartialAdjacentLeftBottom() {
		Point l1 = new Point(4, 6);
		Point r1 = new Point(7, 3);
		Point l2 = new Point(3, 4);
		Point r2 = new Point(4, 2);

		String adjacent = analyzeRectangle.checkAdjacency(l1, r1, l2, r2);
		assertEquals("adjacent partial left-bottom", adjacent);
	}

	@Test
	public void validatePartialAdjacentBottomLeft() {
		Point l1 = new Point(4, 6);
		Point r1 = new Point(7, 3);
		Point l2 = new Point(3, 3);
		Point r2 = new Point(5, 2);

		String adjacent = analyzeRectangle.checkAdjacency(l1, r1, l2, r2);
		assertEquals("adjacent partial bottom-left", adjacent);
	}

	@Test
	public void validatePartialAdjacentBottomRight() {
		Point l1 = new Point(4, 6);
		Point r1 = new Point(7, 3);
		Point l2 = new Point(6, 3);
		Point r2 = new Point(8, 2);

		String adjacent = analyzeRectangle.checkAdjacency(l1, r1, l2, r2);
		assertEquals("adjacent partial bottom-right", adjacent);
	}

	@Test
	public void validateNotAdjacency() {
		Point l1 = new Point(4, 6);
		Point r1 = new Point(7, 3);
		Point l2 = new Point(9, 5);
		Point r2 = new Point(10, 3);
		String adjacent = analyzeRectangle.checkAdjacency(l1, r1, l2, r2);
		assertEquals("no adjacent", adjacent);
	}

}
