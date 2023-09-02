package com.algorithms.sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Selection extends SortBase {
	public void sort(Comparable[] a) {
		//StdOut.printf("Selection sort start\n");
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			exch(a, min, i);
		}
		assert isSorted(a);
		//StdOut.printf("Selection sort end\n");
	}

	public void sort(Object[] a, Comparator c) {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (less(a[j], a[min], c)) {
					min = j;
				}
			}
			exch(a, min, i);
		}
		assert isSorted(a, c);
	}
	
	public void sort(int[] a){
		for(int i = 0; i < a.length; i++){
			int min = i;
			for(int j = i + 1; j < a.length; j++){
				if(a[j] < a[min])
					min = j;
			}
			exch(a, i, min);
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
			 new Selection().sort(arr);
			 System.out.println(Arrays.toString(arr));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			sc.close();
		}
	}
}
