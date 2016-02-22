package com.algorithms.base.solution1;

public class Solution1_1_13 {

	public static void main(String[] args) {
		int[][] arr = new int[3][3];
		int num = 1;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				System.out.print(num);
				arr[i][j] = num++;	
			}
			System.out.println();
		}
		printReverseArr(arr, 3, 3);
	}
	
	public static void printReverseArr(int[][] arr, int M, int N){
		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++){
				System.out.print(arr[j][i]);
			}
			System.out.println();
		}
	}

}
