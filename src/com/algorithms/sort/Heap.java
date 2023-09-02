package com.algorithms.sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Heap {

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
			 sort(arr);
			 System.out.println(Arrays.toString(arr));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			sc.close();
		}
	}

	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = N / 2; i >= 1; i--) {
			sink(a, i, N);
		}
		while (N > 1) {
			exch(a, 1, N--);
			sink(a, 1, N);
		}
		assert isSorted(a);
	}

	public static void sink(Comparable[] a, int k, int N) {
		while (k * 2 <= N) {
			int j = 2 * k;
			if (j < N && less(a, j, j + 1))
				j++;
			if (!less(a, k, j))
				break;
			exch(a,k,j);
			k = j;
		}
	}

	public static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i - 1];
		a[i - 1] = a[j - 1];
		a[j - 1] = swap;
	}

	public static boolean less(Comparable[] a, int i, int j) {
		return a[i - 1].compareTo(a[j - 1]) < 0;
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}
}
