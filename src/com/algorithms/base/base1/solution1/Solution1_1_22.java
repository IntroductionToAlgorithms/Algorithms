package com.algorithms.base.base1.solution1;

public class Solution1_1_22 {

    public static void main(String[] args) {

    }

    public static int rank(int k, int[] array, int lo, int hi, int indent) {
		if (lo > hi) {
			return -1;
		}

        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
        System.out.println("lo = " + lo + " hi = " + hi);
        indent++;
        int mid = lo + (hi - lo) / 2;
		if (k > array[mid]) {
			return rank(k, array, mid + 1, hi, indent);
		} else if (k < array[mid]) {
			return rank(k, array, lo, mid - 1, indent);
		} else {
			return mid;
		}

    }

}
