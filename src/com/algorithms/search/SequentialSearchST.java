package com.algorithms.search;

public class SequentialSearchST<Key extends Comparable<Key>, Value>  implements ST<Key, Value>{
	private Node first;
	private int N;
	private  class Node{
		Key key;
		Value val;
		Node next;
		public Node(Key key, Value value){
			this.key = key;
			this.val = value;
			next = null;
		}
	}
	@Override
	public void put(Key key, Value val) {
		if (key == null) throw new NullPointerException("argument to get() is null");
		if(val == null)
			delete(key);
		for(Node x = first; x != null; x = x.next){
			if(key.equals(x.key)){
				x.val = val;
				return;
			}
		}
		Node oldFirst = first;
		first = new Node(key,val);
		first.next = oldFirst;
		N++;
	}

	@Override
	public Value get(Key key) {
		if (key == null) throw new NullPointerException("argument to get() is null");
		for(Node k = first; k != null; k = k.next){
			if(key.equals(k.key))
				return k.val;
		}
		return null;
	}
	

	@Override
	public void delete(Key key) {
		if (key == null) throw new NullPointerException("argument to get() is null");
		delete(first,key);
	}
	private Node delete(Node x, Key key){
		if(x == null)
			return null;
		if(x.key.equals(key)){
			N--;
			return delete(x.next, key);
		}
		x.next = delete(x.next, key);
		return x;
	}

	@Override
	public boolean contains(Key key) {
		return  get(key) != null;
	}

	@Override
	public boolean isEmpty() {
		return N == 0;
	}

	@Override
	public int size() {
		return N;
	}

	@Override
	public Key min() {
		return null;
	}

	@Override
	public Key max() {
		return null;
	}

	@Override
	public Key floor(Key key) {
		return null;
	}

	@Override
	public Key ceiling(Key key) {
		return null;
	}

	@Override
	public int rank(Key key) {
		return 0;
	}

	@Override
	public Key select(int k) {
		return null;
	}

	@Override
	public void deleteMin() {
		
	}

	@Override
	public void deleteMax() {
		
	}

	@Override
	public int size(Key lo, Key hi) {
		return 0;
	}



}
