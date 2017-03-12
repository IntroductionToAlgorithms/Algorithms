package com.algorithms.base.base1.solution1;

public class Solution1_1_20 {

	public static void main(String[] args) {

	}

	public static double lnN(int N) {
		if (N == 0)
			return 0;
		else
			return Math.log10(N) + lnN(N - 1);
	}
}
