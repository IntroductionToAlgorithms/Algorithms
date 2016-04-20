package com.algorithms.string;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.algorithms.util.StdOut;

public class LSD {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("input/words3.txt"));
		String[] a = new String[35];
		int count = 0;
		while (sc.hasNext()) {
			a[count++] = sc.next();
		}

		int N = a.length;

		// check that strings have fixed length
		int W = a[0].length();
		for (int i = 0; i < N; i++)
			assert a[i].length() == W : "Strings must have fixed length";

		// sort the strings
		sort(a, W);

		// print results
		for (int i = 0; i < N; i++)
			StdOut.println(a[i]);
		sc.close();
	}

	public static void sort(String[] a, int W) {
		int N = a.length;
		int R = 256;
		String[] aux = new String[N];
		for (int i = W - 1; i >= 0; i--) {
			int[] count = new int[R + 1];

			for (int j = 0; j < N; j++) {
				count[a[j].charAt(i) + 1]++;
			}
			
			for (int j = 0; j < R; j++) {
				count[j + 1] += count[j];
			}
			
			for (int j = 0; j < N; j++) {
				aux[count[a[j].charAt(i)]++] = a[j];
			}
		}

		for (int j = 0; j < N; j++) {
			a[j] = aux[j];
		}
	}

}
