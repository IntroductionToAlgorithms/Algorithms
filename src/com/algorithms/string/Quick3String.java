package com.algorithms.string;

import java.util.Arrays;

public class Quick3String {

	public static void main(String[] args) {
		String[] arr = { "she", "sells", "seashells", "by", "the", "sea", "shore", "the", "shells", "she", "sells",
				"are", "surely", "seashells" };
		sort(arr, 0, arr.length - 1, 0);
	}

	public static int charAt(String a, int d) {
		if (a.length() <= d)
			return -1;
		return a.charAt(d);
	}

	public static void exch(String[] a, int i, int j) {
		String tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static void sort(String[] a, int lo, int hi, int d) {
		if (lo >= hi)
			return;
		int lt = lo;
		int gt = hi;
		int i = lo + 1;
		int v = charAt(a[lo], d);
		while (i <= gt) {
			int t = charAt(a[i], d);

			if (t < v) {
				exch(a, lt++, i++);
			} else if (t > v) {
				exch(a, i, gt--);
			} else {
				i++;
			}
			System.out.println("i == " + i + ",lt == " + lt + ", gt == " + gt);
			System.out.println(Arrays.toString(a));
		}

		sort(a, lo, lt - 1, d);
		if (v > 0) {
			sort(a, lt, gt, d + 1);
		}
		sort(a, gt + 1, hi, d);
	}

}
