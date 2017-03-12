package com.algorithms.base.base1.solution1;

public class Solution1_1_14 {

	public static void main(String[] args) {
		System.out.println(lg(1));
		System.out.println(lg(2));
		System.out.println(lg(3));
		System.out.println(lg(4));
		System.out.println(lg(5));
	}

	public static int lg(int N) {
		int sum = 1;
		int pow = 0;
		while ((sum = sum * 2) <= N) {
			pow++;
		}
		return pow;
	}

}
