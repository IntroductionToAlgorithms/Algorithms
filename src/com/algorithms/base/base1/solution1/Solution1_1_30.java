package com.algorithms.base.base1.solution1;

public class Solution1_1_30 {

	public static void main(String[] args) {
		boolean[][] bArr = new boolean[20][20];
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (i > 0 && j > 0) {
					if (isGcd(i, j))
						bArr[i][j] = true;
					else
						bArr[i][j] = false;
				} else {
					bArr[i][j] = false;
				}
			}
		}
	}

	public static boolean isGcd(int m, int n) {
		return gcd(m, n) == 1;
	}

	public static int gcd(int m, int n) {
		if (m % n == 0)
			return n;
		else
			return gcd(n, m % n);
	}

}
