package com.algorithms.base.solution1;

public class Solution1_1_05 {

	public static void main(String[] args) {
		System.out.println(vauleBetween(0, 0));;
		System.out.println(vauleBetween(0, 0.5));
		System.out.println(vauleBetween(0, 1));
		System.out.println(vauleBetween(0.5, 0));
		System.out.println(vauleBetween(0.5, 0.5));
		System.out.println(vauleBetween(0.5, 1));
		System.out.println(vauleBetween(1, 0));
		System.out.println(vauleBetween(1, 0.5));
		System.out.println(vauleBetween(1, 1));
	}
	
	public static boolean vauleBetween(double a, double b){
		if(a > 0 && a < 1 && b > 0 && b < 1)
			return true;
		else
			return false;
	}

}
