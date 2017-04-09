package com.algorithms.base.base5;

import com.algorithms.util.StdIn;
import com.algorithms.util.StdOut;
import com.algorithms.util.In;

import java.io.File;

/**
 * Created by guangoon on 17-4-8.
 */
public class QuickFindUF {
    private int count;
    private int[] id;

    public QuickFindUF(int N){
        count = N;
        id = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    public int count(){
        return count;
    }

    public int find(int p){
        return id[p];
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public void union(int p, int q){
        int rp = find(p);
        int rq = find(q);

        if(rp == rq)
            return;

        for(int i = 0; i < id.length; i++){
            if(id[i] == rp)
                id[i] = rq;
        }
        count--;
    }
    public static void main(String[] args){
        In in = new In(new File("input/tinyUF.txt"));
        int n = in.readInt();
        QuickFindUF uf = new QuickFindUF(n);
        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
