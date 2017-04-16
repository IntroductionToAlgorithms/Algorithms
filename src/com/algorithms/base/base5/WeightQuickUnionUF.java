package com.algorithms.base.base5;

import com.algorithms.util.In;
import com.algorithms.util.StdOut;

import java.io.File;

/**
 * Created by guangoon on 17-4-16.
 */
public class WeightQuickUnionUF {
    private int[] id;
    private int[] sz;
    private int count;

    public WeightQuickUnionUF(int N){
        id = new int[N];
        sz = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = i;
        }
        for(int i = 0; i < N; i++){
            sz[i] = 1;
        }
        count = N;
    }

    public int find(int p){
        while(p != id[p])
            p = id[p];
        return p;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int count(){
        return count;
    }

    public void union(int p, int q){
        int rootp = find(p);
        int rootq = find(q);

        if(rootp == rootq)
            return;

        if(sz[rootp] > sz[rootq]){
            id[rootq] = rootp;
            sz[rootp] += sz[rootq];
        }else{
            id[rootp] = rootq;
            sz[rootq] += sz[rootp];
        }

        count--;
    }

    public static void main(String[] args){
        In in = new In(new File("input/tinyUF.txt"));
        int n = in.readInt();
        WeightQuickUnionUF uf = new WeightQuickUnionUF(n);
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
