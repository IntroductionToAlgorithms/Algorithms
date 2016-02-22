package com.algorithms.base.solution1;

import java.util.Arrays;

public class Solution1_1_15 {

	public static void main(String[] args) {
		int[] arr = {1,1,1,1,1,1,2,3,4,5,7,9};
		System.out.println(Arrays.toString(histogram(arr, 10)));
	}
	
	public static int[] histogram(int[] a, int M){
		int[] result = new int[M];
		for(int i = 0; i < a.length; i++){
			result[a[i]]++;
		}
		return result;
	}

}
