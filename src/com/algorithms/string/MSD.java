package com.algorithms.string;

/**
 * Created by guangoon on 8/6/17.
 */
public class MSD {
    private static final int M = 15;
    private static final int R = 256;
    private static String[] aux;
    public static boolean less(String v, String w, int d){
        for(int i = d; i < Math.min(v.length(), w.length()); i++){
            if(v.charAt(i) < w.charAt(i))
                return true;
            if(v.charAt(i) > w.charAt(i))
                return false;
        }
        return v.length() < w.length();
    }

    public static void exch(String[] a, int i, int j){
        String tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void insertion(String[] a, int lo, int hi, int d){
        for(int i = lo; i <= hi; i++){
            for(int j = i; j > lo && less(a[j],a[j - 1],d); j--){
                exch(a, j, j -1);
            }
        }
    }

    public static void insertion2(String[] a, int lo, int hi, int d){
        for(int i = lo + 1; i <= hi; i++){
            String v = a[i];
            int j = i - 1;
            while(j >= 0 && less(v, a[j], d)){
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = v;
        }
    }

    private static int charAt(String s, int d){
        if(d < s.length())
            return s.charAt(d);
        else
            return -1;
    }

    public static void sort(String[] a, int lo, int hi, int d){
        if(hi <= lo + M)
            insertion(a, lo, hi,d);
        int[] count = new int[R + 2];
        for(int i = lo; i <= hi; i++){
            count[charAt(a[i],d) + 2]++;
        }

        for(int i = 0; i < R + 1; i++){
            count[i + 1] += count[i];
        }

        for(int i = lo; i <= hi; i++){
            aux[count[charAt(a[i],d) + 1]++] = a[i];
        }

        for(int i = lo; i <= hi; i++){
            a[i] = aux[i - lo];
        }

        for(int r = 0; r < R; r++){
            sort(a, lo + count[r], lo + count[r + 1] - d, d + 1);
        }
    }

    public static void sort(String[] a){
        int N = a.length;
        aux = new String[N];
        sort(a,0, N - 1, 0);
    }


    public static void main(String[] args){
        
    }


}
