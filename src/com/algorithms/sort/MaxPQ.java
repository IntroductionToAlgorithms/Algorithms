package com.algorithms.sort;

/**
 * Created by guangoon on 6/13/17.
 */
public class MaxPQ {
    private Comparable[] pq;
    private int N = 0;

    public MaxPQ(int maxN){
        pq = new Comparable[maxN + 1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void insert(Comparable a){
        pq[++N] = a;
        swim(N);
    }

    public Comparable deleteMax(){
        Comparable max = pq[1];
        SortBase.exch(pq, 1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    public int left(int k){
        return 2 * k;
    }

    public int right(int k){
        return 2 * k + 1;
    }



    public int root(int k){
        return k / 2;
    }

    public void sink(int k){
        while(2 * k <= N){
            int l = 2 * k;
            if(l < N && SortBase.less(pq[l], pq[l + 1]))
                l++;
            if(!SortBase.less(pq[k],pq[l]))
                break;
            SortBase.exch(pq, k, l);
            k = l;
        }
    }

    public void swim(int k){
        while(root(k) > 0 && SortBase.less(pq[root(k)],pq[k])){
            SortBase.exch(pq, k, root(k));
            k = root(k);
        }
    }
}
