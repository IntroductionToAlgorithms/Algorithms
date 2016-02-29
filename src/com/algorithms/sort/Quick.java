package com.algorithms.sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Quick extends SortBase {

	public static void main(String[] args) {
		Scanner sc = null;
		ArrayList<String> inputList = new ArrayList<String>();
		try {
			sc = new Scanner(new File("input/tiny.txt"));
			while (sc.hasNext()) {
				inputList.add(sc.next());
			}
			String[] arr = new String[inputList.size()];
			inputList.toArray(arr);
			System.out.println(Arrays.toString(arr));
			new Quick().sort(arr);
			System.out.println(Arrays.toString(arr));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

	public void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
		assert isSorted(a);
	}

	public void sort(Comparable[] a, int lo, int hi) {
		if (lo >= hi)
			return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	public int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];
		while (true) {
			while (less(a[++i], v))
				if (i == hi)
					break;
			while (less(v, a[--j]))
				if (j == lo)
					break;
			if (i >= j)
				break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}

	public void sort(Comparator c, Object[] a) {
		sort(c, a, 0, a.length - 1);
	}

	public void sort(Comparator c, Object[] a, int lo, int hi) {
		if (lo >= hi)
			return;
		int j = partition(c, a, lo, hi);
		sort(c, a, lo, j - 1);
		sort(c, a, j + 1, hi);
	}

	public int partition(Comparator c, Object[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		Object v = a[lo];
		while (true) {
			while (less(a[++i], v, c))
				if (i == hi)
					break;
			while (less(v, a[--j], c))
				if (j == lo)
					break;
			if (i >= j)
				break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}

}
