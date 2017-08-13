package com.algorithms.string;

/**
 * Created by guangoon on 8/13/17.
 */
public class KMP {
    private String pat;
    private int[][] dfa;

    public KMP(String pat){
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        dfa = new int[R][256];
        dfa[pat.charAt(0)][0] = 1;
        for(int X = 0, j = 1; j < M; j++){
            for(int c = 0; c < R; c++){
                dfa[c][j] = dfa[c][j - 1];
            }
            dfa[pat.charAt(j)][j] = j + 1;
            X = dfa[pat.charAt(j)][X];
        }
    }

    public int search(String txt){
        int i , j, N = txt.length(), M = pat.length();
        for(i = 0, j = 0; i < N && j < M; i++){
            j = dfa[txt.charAt(i)][j];
        }

        if(j == M ) return i - M;
        else return N;
    }
}
