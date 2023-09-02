package com.algorithms.sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Shell extends SortBase {

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
			 new Shell().sort(arr);
			 System.out.println(Arrays.toString(arr));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			sc.close();
		}
	}

	public void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		while (h < N / 3)
			h = 3 * h + 1;
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
					exch(a, j, j - h);
				}
			}
			h /= 3;
		}
		assert isSorted(a);
	}

	public void sort(Comparator c, Object[] a) {
		int N = a.length;
		int h = 1;
		while (h < N / 3)
			h = 3 * h + 1;
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && less(a[j], a[j - h], c); j -= h) {
					exch(a, j, j - h);
				}
			}
			h /= 3;
		}
		assert isSorted(a, c);
	}

	public void sort(int[] arr) {
		int N = arr.length;
		int h = 1;
		while (h < N / 3)
			h = 3 * h + 1;
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && less(arr[j], arr[j - h]); j -= h) {
					exch(arr, j, j - h);
				}
			}
			h /= 3;
		}
	}
}
