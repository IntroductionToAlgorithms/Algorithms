package com.algorithms.string;

import com.algorithms.sort.SortBase;
import com.algorithms.util.In;
import java.io.File;
import java.util.Arrays;

/**
 * Created by guangoon on 8/1/17.
 */
public class LSD {
    private static void sort(String[]  a, int w){
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];
        for(int d =w - 1; d >= 0; d--){
            int[] count = new int[R + 1];
            for(int i = 0; i < N; i++){
                count[a[i].charAt(d) + 1]++;
            }

            for(int i = 1; i < count.length; i++){
                count[i] += count[i - 1];
            }

            for(int i = 0; i < N; i++){
                aux[count[a[i].charAt(d)]++] = a[i];
            }

            for(int i = 0; i < N; i++){
                a[i] = aux[i];
            }
        }
    }

    public static void main(String[] args){
        In in = new In(new File("input/words3.txt"));
        String[] ss = in.readAllStrings();
        System.out.println(Arrays.toString(ss));
        sort(ss,3);
        System.out.println(SortBase.isSorted(ss));
        System.out.println(Arrays.toString(ss));
    }
}
