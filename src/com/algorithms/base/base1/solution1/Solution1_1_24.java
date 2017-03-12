package com.algorithms.base.base1.solution1;

public class Solution1_1_24 {
	
	public static int gcd(int m, int n){
		if(m % n == 0)
			return n;
		else
			return gcd(n, m % n);
	}
	
	public static void main(String[] args) {
		System.out.println(gcd(3,15));
	}
}
