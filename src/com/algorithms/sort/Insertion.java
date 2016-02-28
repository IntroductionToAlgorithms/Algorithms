package com.algorithms.sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Insertion extends SortBase {

	public void sort(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
		}
		assert isSorted(a);
	}

	public void sort(Object[] a, Comparator c) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1], c); j--) {
				exch(a, j, j - 1);
			}
		}
		assert isSorted(a, c);
	}

	public void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j > 0 && less(arr[j], arr[j - 1]); j--) {
				exch(arr, j, j - 1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = null;
		ArrayList<String> inputList = new ArrayList<String>();
		try {
			 sc = new Scanner(new File("input/tiny.txt"));
			 while(sc.hasNext()){
				inputList.add(sc.next());
			 }
			 
			 String[] arr =  new String[inputList.size()]; 
			 inputList.toArray(arr);
			 System.out.println(Arrays.toString(arr)); 
			 new Insertion().sort(arr);
			 System.out.println(Arrays.toString(arr));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			sc.close();
		}
	}

}
