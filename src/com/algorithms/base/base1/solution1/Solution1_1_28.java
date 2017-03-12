package com.algorithms.base.base1.solution1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1_1_28 {

	public static void main(String[] args) {
		int[] arr = {1,1,1,1,1,1,2,3,3,3,4,4,5};
		int[] arr1 = {1};
		int[] arr2 = {1,2};
		System.out.println(Arrays.toString(removeDuplicates(arr)));
		System.out.println(Arrays.toString(removeDuplicates(arr1)));
		System.out.println(Arrays.toString(removeDuplicates(arr2)));
	}
	
	public static int[] removeDuplicates(int[] arr){
		if(arr == null || arr.length <= 1)
			return arr;
		List<Integer> resList = new ArrayList<Integer>();
		resList.add(arr[0]);
		for(int i = 1; i < arr.length; i++){
			if(arr[i - 1] != arr[i])
				resList.add(arr[i]);
		}
		int[] result = new int[resList.size()];
		for(int j = 0; j < resList.size(); j++){
			result[j] = resList.get(j);
		}
		return result;
	}

}
