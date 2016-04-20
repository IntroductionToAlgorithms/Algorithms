package com.algorithms.string;

public class MSD {
	private static final int R = 256;

	public static void main(String[] args) {

	}

	public static void sort(String[] a) {
		int N = a.length;
		String[] aux = new String[N];
		sort(a, 0, N - 1, 0, aux);
	}

	public static int charAt(String a, int d) {
		if (a.length() <= d) {
			return -1;
		}

		return a.charAt(d);
	}

	public static void sort(String[] a, int lo, int hi, int d, String[] aux) {
		if (lo >= hi) {
			return;
		}

		int[] count = new int[R + 2];
		for (int i = lo; i <= hi; i++) {
			count[charAt(a[i], d) + 2]++;
		}

		for (int i = 0; i < R + 1; i++) {
			count[i + 1] += count[i];
		}

		for (int i = lo; i <= hi; i++) {
			aux[count[charAt(a[i], d) + 1]++] = a[i];
		}
		
		for(int i = lo; i <= hi; i++){
			a[i] = aux[i - lo];
		}
		
		for(int r = 0; r < R ; r++){
			sort(a, lo + count[r], lo + count[r+1] - 1, d+1, aux);
		}
	}

}
