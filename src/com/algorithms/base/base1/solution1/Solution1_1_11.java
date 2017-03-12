package com.algorithms.base.base1.solution1;

public class Solution1_1_11 {
	public static void main(String[] args) {
		boolean[][] arr = new boolean[4][6];
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 6; j++){
				arr[i][j] = true;
			}
		}
		printBooleanArray(arr, 4, 6);
	}
	
	public static void printBooleanArray(boolean[][] arr, int m, int n){
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(arr[i][j])
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
