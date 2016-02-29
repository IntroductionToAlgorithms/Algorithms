package com.algorithms.sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Merge extends SortBase {
	private static Comparable[] aux;
	private static Object[] oux;

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
			new Merge().sort(arr);
			System.out.println(Arrays.toString(arr));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

	public void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
		assert isSorted(a);
	}

	public void sort(Comparable[] a, int lo, int hi) {
		if (lo >= hi)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		merge(a, lo, mid, hi);
	}

	public void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[i], aux[j]))
				a[k] = aux[i++];
			else
				a[k] = aux[j++];
		}
	}

	public void sort(Comparator c, Object[] a) {
		oux = new Object[a.length];
		sort(c, a, 0, a.length - 1);
	}

	public void sort(Comparator c, Object[] a, int lo, int hi) {
		if (lo >= hi)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(c, a, lo, mid);
		sort(c, a, mid + 1, hi);
		merge(c, a, lo, mid, hi);
	}

	public void merge(Comparator c, Object[] a, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			oux[k] = a[k];
		}

		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = oux[j++];
			else if (j > hi)
				a[k] = oux[i++];
			else if (less(oux[i], oux[j], c))
				a[k] = oux[i++];
			else
				a[k] = oux[j++];
		}

	}

}
