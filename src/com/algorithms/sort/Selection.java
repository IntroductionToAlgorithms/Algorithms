package com.algorithms.sort;

import java.util.Comparator;

import com.algorithms.util.StdOut;

public class Selection extends SortBase {
	public void sort(Comparable[] a) {
		//StdOut.printf("Selection sort start\n");
		for (int i = 0; i < a.length; i++) {
			Comparable min = a[i];
			for (int j = i + 1; j < a.length; j++) {
				if (less(a[j], min)) {
					min = a[j];
				}
			}
			a[i] = min;
		}
		assert isSorted(a);
		//StdOut.printf("Selection sort end\n");
	}

	public void sort(Object[] a, Comparator c) {
		for (int i = 0; i < a.length; i++) {
			Object min = a[i];
			for (int j = i + 1; j < a.length; j++) {
				if (less(a[j], min, c)) {
					min = a[j];
				}
			}
			a[i] = min;
		}
		assert isSOrted(a, c);
	}
	
	public void sort(int[] a){
		for(int i = 0; i < a.length; i++){
			int min = a[i];
			for(int j = i + 1; j < a.length; j++){
				if(a[j] < min)
					min = a[j];
			}
			a[i] = min;
		}
	}
	
	public static void main(String[] args) {
		
	}
}
