package com.algorithms.search;

public class BST <Key extends Comparable<Key>, Value>  implements ST<Key, Value> {
	private Node root;
	private class Node{
		Key key;
		Value val;
		Node left;
		Node right;
		int N;
		public Node(Key key, Value value, int N){
			this.key = key;
			this.val = value;
			this.N = N;
		}
	}
	@Override
	public void put(Key key, Value val) {
		root = put(root,key,val);
	}
	
	private Node put(Node x,Key key, Value val){
		if(x == null)
			return new Node(key,val,0);
		int cmp = key.compareTo(x.key);
		if(cmp < 0)
			 x.left = put(x.left,key,val);
		else if(cmp > 0)
			 x.right = put(x.right,key,val);
		else
			x.val = val;
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	@Override
	public Value get(Key key) {
		return get(root,key);
	}
	
	private Value get(Node x,Key key){
		if(key == null)
			return null;
		int cmp = key.compareTo(x.key);
		if(cmp < 0)
			return get(x.left,key);
		else if(cmp > 0){
			return get(x.right,key);
		}else{
			return x.val;
		}
	}

	@Override
	public void delete(Key key) {
		root = delete(root, key);
	}
	
	private Node delete(Node x, Key key){
		if(x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if(cmp < 0)
			 x.left = delete(x.left, key);
		else if(cmp > 0)
			 x.right = delete(x.right,key);
		else{
			if(x.left == null)
				return x.right;
			if(x.right == null)
				return x.left;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	@Override
	public boolean contains(Key key) {
		return get(key) == null;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return size(root);
	}
	
	private int size(Node x){
		if(x == null)
			return 0;
		return x.N;
	}

	@Override
	public Key min() {
		return min(root).key;
	}
	
	private Node min(Node x){
		if(x.left == null)
			return x;
		return min(x.left);
	}

	@Override
	public Key max() {
		return max(root).key;
	}
	
	private Node max(Node x){
		if(x.right == null)
			return x;
		return max(x.right);
	}

	@Override
	public Key floor(Key key) {
		return floor(root,key).key;
	}
	
	private Node floor(Node x, Key key){
		if(x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if(cmp == 0)
			return x;
		if(cmp < 0)
			return floor(x.left,key);
		Node t = floor(x.right,key);
		if(t != null)
			return t;
		else
			return x;
			
	}

	@Override
	public Key ceiling(Key key) {
		return ceiling(root,key).key;
	}
	
	private Node ceiling(Node x, Key key){
		if(x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if(cmp == 0)
			return x;
		if(cmp > 0)
			return ceiling(x.right,key);
		Node t = ceiling(x.left,key);
		if(t != null)
			return t;
		else
			return x;
			
	}

	@Override
	public int rank(Key key) {
		return rank(root,key);
	}
	
	private int rank(Node x, Key key){
		if(x == null)
			return 0;
		int cmp = key.compareTo(x.key);
		if(cmp < 0)
			return rank(x.left,key);
		else if(cmp > 0)
			return size(x.left) + 1 + rank(x.right,key);
		else
			return size(x.left);
	}
	
	

	@Override
	public Key select(int k) {
		return select(root,k).key;
	}
	
	private Node select(Node x, int k){
		if(x == null)
			return null;
		int t = size(x.left);
		if(t > k)
			return select(x.left, k);
		else if(t < k)
			return select(x.right, k - t - 1);
		else return x;
	}

	@Override
	public void deleteMin() {
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node x){
		if(x.left == null)
			return x.right;
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	@Override
	public void deleteMax() {
		root = deleteMax(root);
	}
	
	private Node deleteMax(Node x){
		if(x.right == null)
			return x.left;
		x.right = deleteMax(x.right);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	@Override
	public int size(Key lo, Key hi) {
		return 0;
	}

}
