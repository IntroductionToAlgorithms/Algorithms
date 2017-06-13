package com.algorithms.sort;

import com.algorithms.util.In;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by guangoon on 6/13/17.
 */
public class Quick {
    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }


    /**
     * Rearranges the subarray a[lo..hi) in ascending order, using the natural order.
     * @param a the array to be sorted
     * @param lo left endpoint (inclusive)
     * @param hi right endpoint (exclusive)
     */
    public static void sort(Comparable[] a, int lo, int hi) {
        if(lo >= hi){
            return;
        }
        int p = partition(a,lo, hi);
        sort(a, lo, p -1);
        sort(a, p + 1, hi);
        assert SortBase.isSorted(a, lo, hi);
    }

    public static int partition(Comparable[] a, int lo, int hi){
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while(true){
            while(SortBase.less(a[++i], v))
                if(i == hi)
                    break;
            while(SortBase.less(v,a[--j]))
                if(j == lo)
                    break;
            if(i >= j)
                break;
            SortBase.exch(a, i, j);
        }
        SortBase.exch(a, lo, j);
        return j;
    }

    /**
     * Rearranges the array in ascending order, using a comparator.
     * @param a the array
     * @param comparator the comparator specifying the order
     */
    public static void sort(Object[] a, Comparator comparator) {
        assert SortBase.isSorted(a, comparator);
    }

    /**
     * Rearranges the subarray a[lo..hi) in ascending order, using a comparator.
     * @param a the array
     * @param lo left endpoint (inclusive)
     * @param hi right endpoint (exclusive)
     * @param comparator the comparator specifying the order
     */
    public static void sort(Object[] a, int lo, int hi, Comparator comparator) {
        if(lo >= hi){
            return;
        }
        int p = partition(a,lo, hi,comparator);
        sort(a, lo, p -1,comparator);
        sort(a, p + 1, hi,comparator);
        assert SortBase.isSorted(a, lo, hi, comparator);
    }

    public static int partition(Object[] a, int lo, int hi, Comparator comparator) {
        int i = lo;
        int j = hi + 1;
        Object v = a[lo];
        while(true){
            while(SortBase.less(a[++i], v,comparator))
                if(i == hi)
                    break;
            while(SortBase.less(v,a[--j],comparator))
                if(j == lo)
                    break;
            if(i >= j)
                break;
            SortBase.exch(a, i, j);
        }
        SortBase.exch(a, lo, j);
        return j;
    }

    public static void main(String[] args){
        In in = new In(new File("input/words3.txt"));
        String[] ss = in.readAllStrings();
        System.out.println(Arrays.toString(ss));
        sort(ss);
        System.out.println(SortBase.isSorted(ss));
        System.out.println(Arrays.toString(ss));
    }
}
