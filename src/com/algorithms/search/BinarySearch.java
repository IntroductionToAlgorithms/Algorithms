package com.algorithms.search;

import com.algorithms.base.base3.Queue;

import java.util.NoSuchElementException;

/**
 * Created by guangoon on 6/25/17.
 */
public class BinarySearch<Key extends Comparable, Value>  implements ST<Key, Value>{
    private static final int INIT_CAPACITY = 2;
    private Key[] keys;
    private Value[] values;
    private int N;

    public BinarySearch(){
        keys = (Key[])new Comparable[INIT_CAPACITY];
        values = (Value[])new Object[INIT_CAPACITY];
        N = 0;
    }
    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  value the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    @Override
    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("argument to put() is null");
        if (value == null)
            delete(key);
        int k = rank(key);
        if(k < N && key.compareTo(keys[k]) == 0) {
            values[k] = value;
            return;
        }
        if(N == keys.length){
            resize(2 * N);
        }

        for(int i = k; i < N; i++){
            keys[i + 1] = keys[i];
            values[i + 1] = values[i];
        }

        keys[k] = key;
        values[k] = value;
        N++;
    }

    private void resize(int capacity){
        assert capacity >= N;

        Key[] tmpKeys = (Key[])new Comparable[capacity];
        Value[] tmpValues = (Value[])new Object[capacity];

        for(int i = 0; i < N; i++){
            tmpKeys[i] = keys[i];
            tmpValues[i] = values[i];
        }
        keys = tmpKeys;
        values = tmpValues;
    }
    /**
     * Returns the value associated with the given key in this symbol table.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    @Override
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int k = rank(key);
        if(k < N && key.compareTo(keys[k]) == 0) {
            return values[k];
        }
        return null;
    }
    /**
     * Removes the specified key and associated value from this symbol table
     * (if the key is in the symbol table).
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    @Override
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        int k = rank(key);
        if(k >= N)
            return;
        if(k <  N && key.compareTo(keys[k]) != 0)
            return;
        for(int i = k; i < N - 1; i++){
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
        N--;
        if(N == keys.length / 4){
            resize(keys.length / 2);
        }
    }
    /**
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }
    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return N == 0;
    }
    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    @Override
    public int size() {
        return N;
    }
    /**
     * Returns the smallest key in this symbol table.
     *
     * @return the smallest key in this symbol table
     * @throws NoSuchElementException if this symbol table is empty
     */
    @Override
    public Key min() {
        if(isEmpty())
            throw new NoSuchElementException();
        return keys[0];
    }
    /**
     * Returns the largest key in this symbol table.
     *
     * @return the largest key in this symbol table
     * @throws NoSuchElementException if this symbol table is empty
     */
    @Override
    public Key max() {
        if(isEmpty())
            throw new NoSuchElementException();
        return keys[N - 1];
    }
    /**
     * Returns the largest key in this symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in this symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    @Override
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        int k = rank(key);
        if(k < N && key.compareTo(keys[k]) == 0){
            return keys[k];
        }
        if(k == 0)
            return null;
        else
            return keys[k - 1];
    }
    /**
     * Returns the smallest key in this symbol table greater than or equal to {@code key}.
     *
     * @param  key the key
     * @return the smallest key in this symbol table greater than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    @Override
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        int k = rank(key);
        if(k < N && key.compareTo(keys[k]) == 0){
            return keys[k];
        }
        if(k == N - 1)
            return null;
        else
            return keys[k + 1];
    }
    /**
     * Returns the number of keys in this symbol table strictly less than {@code key}.
     *
     * @param  key the key
     * @return the number of keys in the symbol table strictly less than {@code key}
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    @Override
    public int rank(Key key) {
        int lo = 0;
        int hi = N - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp == 0){
                return mid;
            } else if(cmp < 0){
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    /**
     * Return the kth smallest key in this symbol table.
     *
     * @param  k the order statistic
     * @return the {@code k}th smallest key in this symbol table
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>n</em>–1
     */
    @Override
    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("called select() with invalid argument: " + k);
        }
        return keys[k];
    }
    /**
     * Removes the smallest key and associated value from this symbol table.
     *
     * @throws NoSuchElementException if the symbol table is empty
     */
    @Override
    public void deleteMin() {
        if (isEmpty())
            throw new NoSuchElementException("Symbol table underflow error");
        delete(min());
    }
    /**
     * Removes the largest key and associated value from this symbol table.
     *
     * @throws NoSuchElementException if the symbol table is empty
     */
    @Override
    public void deleteMax() {
        if (isEmpty())
            throw new NoSuchElementException("Symbol table underflow error");
        delete(max());
    }
    /**
     * Returns the number of keys in this symbol table in the specified range.
     *
     * @param lo minimum endpoint
     * @param hi maximum endpoint
     * @return the number of keys in this symbol table between {@code lo}
     *         (inclusive) and {@code hi} (inclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *         is {@code null}
     */
    @Override
    public int size(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to size() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to size() is null");

        if (lo.compareTo(hi) > 0) return 0;
        if (contains(hi)) return rank(hi) - rank(lo) + 1;
        else              return rank(hi) - rank(lo);
    }
    /**
     * Returns all keys in this symbol table in the given range,
     * as an {@code Iterable}.
     *
     * @param lo minimum endpoint
     * @param hi maximum endpoint
     * @return all keys in this symbol table between {@code lo}
     *         (inclusive) and {@code hi} (inclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *         is {@code null}
     */
    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

        Queue<Key> queue = new Queue<Key>();
        if (lo.compareTo(hi) > 0) return queue;
        for (int i = rank(lo); i < rank(hi); i++)
            queue.enqueue(keys[i]);
        if (contains(hi)) queue.enqueue(keys[rank(hi)]);
        return queue;
    }
    /**
     * Returns all keys in this symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     *
     * @return all keys in this symbol table
     */
    @Override
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    /***************************************************************************
     *  Check internal invariants.
     ***************************************************************************/

    private boolean check() {
        return isSorted() && rankCheck();
    }

    // are the items in the array in ascending order?
    private boolean isSorted() {
        for (int i = 1; i < size(); i++)
            if (keys[i].compareTo(keys[i-1]) < 0) return false;
        return true;
    }

    // check that rank(select(i)) = i
    private boolean rankCheck() {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i))) return false;
        for (int i = 0; i < size(); i++)
            if (keys[i].compareTo(select(rank(keys[i]))) != 0) return false;
        return true;
    }
}
