package com.algorithms.base.base1.solution1;

public class Solution1_1_03 {

	public static void main(String[] args) {
		equalsTInteger(1, 2, 3);
		equalsTInteger(1, 1, 3);
		equalsTInteger(1, 2, 1);
		equalsTInteger(1, 2, 1);
		equalsTInteger(1, 1, 1);
	}

	public static void equalsTInteger(int a, int b, int c) {
		if (a == b && b == c) {
			System.out.println("equals");
		} else {
			System.out.println("not equals");
		}
	}

}
