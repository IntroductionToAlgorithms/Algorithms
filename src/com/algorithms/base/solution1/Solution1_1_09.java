package com.algorithms.base.solution1;

public class Solution1_1_09 {

	public static void main(String[] args) {
		System.out.println(toBinaryString(0));
		System.out.println(toBinaryString(1));
		System.out.println(toBinaryString(2));
		System.out.println(toBinaryString(3));
		System.out.println(toBinaryString(4));
		System.out.println(toBinaryString(5));
	}
	
	public static String toBinaryString(int N){
		String s = "";
		for(int n = N; n > 0; n /= 2){
			s = (n % 2) + s;
		}
		return s.equals("") ? "0" : s;
	}

}
