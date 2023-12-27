package com.algorithms.sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Quick2 extends SortBase {

    public static void main(final String[] args) throws FileNotFoundException {

        List<String> a = new ArrayList<>();

        Scanner scanner = new Scanner(new File("input/tiny1.txt"));
        while (scanner.hasNext()) {
            a.add(scanner.next());
        }
        String[] origin = new String[a.size()];
        a.toArray(origin);
        System.out.println(Arrays.toString(origin));
        new Quick2().sort(origin, 0, origin.length - 1);
        System.out.println(Arrays.toString(origin));
    }

    private void sort(final Comparable[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        final int middle = this.partition(a, low, high);
        //此处的0是否可以改成1，因为经过上次的排序后,第一项一定是最小的。
        this.sort(a, 0, middle);
        this.sort(a, middle + 1, high);
    }

    private int partition(final Comparable[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        Comparable v = a[i];
        while (true) {
            while (this.less(a[++i], v)) {
                if (i == high) {
                    break;
                }
            }

            while (this.less(v, a[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            this.exch(a, i, j);
        }
        this.exch(a, low, j);
        return j;
    }

}
