package com.jatin.code.practice.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PassByValueTest {
	public static void main(String[] args) {
		Point p = new Point(1, 1);
		Point p2 = new Point(2, 2);
		p = p2;
		System.out.println(p);
	}

	private static void changeValue1(Point p) {
		p.setX(3);
		p.setY(4);
	}

	private static void changeValue2(Point p) {
		p = new Point(5,6);
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + "]";
		}

	}
}
