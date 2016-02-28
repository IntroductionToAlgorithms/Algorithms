package com.algorithms.sort;

import java.util.Comparator;

public class SortBase {
	public boolean isSorted(Comparable[] a) {
		return isSorted(a, 0, a.length - 1);
	}

	public boolean isSorted(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++) {
			if (less(a[i - 1], a[i]))
				return false;
		}
		return true;
	}

	public boolean isSOrted(Object[] a, Comparator c) {
		return isSorted(a, c, 0, a.length - 1);
	}

	public boolean isSorted(Object[] a, Comparator c, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++) {
			if (less(a[i - 1], a[i], c))
				return false;
		}
		return true;
	}

	public boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	public boolean less(Object a, Object b, Comparator c) {
		return c.compare(a, b) < 0;
	}

	public void exch(Object[] a, int i, int j) {
		Object tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public void exch(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
