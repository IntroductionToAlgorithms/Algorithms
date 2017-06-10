package com.algorithms.sort;

import com.algorithms.util.In;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;



/**
 * Created by guangoon on 17-6-10.
 */
public class Merge {
    private static Comparable[] aux;
    private static Object[] oaux;
    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
        assert SortBase.isSorted(a);
    }


    /**
     * Rearranges the subarray a[lo..hi) in ascending order, using the natural order.
     * @param a the array to be sorted
     * @param lo left endpoint (inclusive)
     * @param hi right endpoint (exclusive)
     */
    public static void sort(Comparable[] a, int lo, int hi) {
        if(lo >= hi)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
        assert SortBase.isSorted(a, lo, hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi){
        int i = lo;
        int j = mid + 1;
        for(int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }

        for(int k = lo; k <= hi; k++){
            if(i > mid)
                a[k] = aux[j++];
            else if(j > hi)
                a[k] = aux[i++];
            else if(SortBase.less(aux[i],aux[j]))
                a[k] = aux[i++];
            else
                a[k] = aux[j++];
        }
    }

    /**
     * Rearranges the array in ascending order, using a comparator.
     * @param a the array
     * @param comparator the comparator specifying the order
     */
    public static void sort(Object[] a, Comparator comparator) {
        oaux = new Object[a.length];
        sort(a, 0, a.length - 1, comparator);
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

        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid, comparator);
        sort(a, mid + 1, hi, comparator);
        assert SortBase.isSorted(a, lo, hi, comparator);
    }

    public static void merge(Object[] a, int lo, int mid, int hi, Comparator comparator) {
        int i = lo;
        int j = mid + 1;

        for(int k = lo; k <= hi; k++){
            oaux[k] = a[k];
        }

        for(int k = lo; k <= hi; k++){
            if(i > mid)
                a[k] = oaux[j++];
            else if(j > hi)
                a[k] = oaux[i++];
            else if(SortBase.less(oaux[i],oaux[j],comparator))
                a[k] = oaux[i++];
            else
                a[k] = oaux[j++];
        }
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
