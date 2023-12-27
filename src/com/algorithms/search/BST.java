package com.algorithms.search;

public class BST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {

    private Node root;

    private class Node {

        Key key;
        Value val;
        Node left;
        Node right;
        int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.val = value;
            this.N = N;
        }
    }

    @Override
    public void put(Key key, Value val) {
		this.root = this.put(this.root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
		if (x == null) {
			return new Node(key, val, 0);
		}
        int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = this.put(x.left, key, val);
		} else if (cmp > 0) {
			x.right = this.put(x.right, key, val);
		} else {
			x.val = val;
		}
        x.N = this.size(x.left) + this.size(x.right) + 1;
        return x;
    }

    @Override
    public Value get(Key key) {
        return this.get(this.root, key);
    }

    private Value get(Node x, Key key) {
		if (key == null) {
			return null;
		}
        int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			return this.get(x.left, key);
		} else if (cmp > 0) {
			return this.get(x.right, key);
		} else {
			return x.val;
		}
    }

    @Override
	public void delete(Key key) {
		this.root = this.delete(this.root, key);
    }

    private Node delete(Node x, Key key) {
		if (x == null) {
			return null;
		}
        int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = this.delete(x.left, key);
		} else if (cmp > 0) {
			x.right = this.delete(x.right, key);
		} else {
			if (x.left == null) {
				return x.right;
			}
			if (x.right == null) {
				return x.left;
			}
			Node t = x;
			x = this.min(t.right);
			x.right = this.deleteMin(t.right);
			x.left = t.left;
		}
        x.N = this.size(x.left) + this.size(x.right) + 1;
        return x;
    }

    @Override
    public boolean contains(Key key) {
        return this.get(key) == null;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int size() {
        return this.size(this.root);
    }

    private int size(Node x) {
		if (x == null) {
			return 0;
		}
        return x.N;
    }

    @Override
    public Key min() {
        return this.min(this.root).key;
    }

    private Node min(Node x) {
		if (x.left == null) {
			return x;
		}
        return this.min(x.left);
    }

    @Override
    public Key max() {
        return this.max(this.root).key;
    }

    private Node max(Node x) {
		if (x.right == null) {
			return x;
		}
        return this.max(x.right);
    }

    @Override
    public Key floor(Key key) {
        return this.floor(this.root, key).key;
    }

    private Node floor(Node x, Key key) {
		if (x == null) {
			return null;
		}
        int cmp = key.compareTo(x.key);
		if (cmp == 0) {
			return x;
		}
		if (cmp < 0) {
			return this.floor(x.left, key);
		}
        Node t = this.floor(x.right, key);
		if (t != null) {
			return t;
		} else {
			return x;
		}

    }

    @Override
    public Key ceiling(Key key) {
        return this.ceiling(this.root, key).key;
    }

    private Node ceiling(Node x, Key key) {
		if (x == null) {
			return null;
		}
        int cmp = key.compareTo(x.key);
		if (cmp == 0) {
			return x;
		}
		if (cmp > 0) {
			return this.ceiling(x.right, key);
		}
        Node t = this.ceiling(x.left, key);
		if (t != null) {
			return t;
		} else {
			return x;
		}

    }

    @Override
    public int rank(Key key) {
        return this.rank(this.root, key);
    }

    private int rank(Node x, Key key) {
		if (x == null) {
			return 0;
		}
        int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			return this.rank(x.left, key);
		} else if (cmp > 0) {
			return this.size(x.left) + 1 + this.rank(x.right, key);
		} else {
			return this.size(x.left);
		}
    }


    @Override
    public Key select(int k) {
        return this.select(this.root, k).key;
    }

    private Node select(Node x, int k) {
		if (x == null) {
			return null;
		}
        int t = this.size(x.left);
		if (t > k) {
			return this.select(x.left, k);
		} else if (t < k) {
			return this.select(x.right, k - t - 1);
		} else {
			return x;
		}
    }

    @Override
    public void deleteMin() {
		this.root = this.deleteMin(this.root);
    }

    private Node deleteMin(Node x) {
		if (x.left == null) {
			return x.right;
		}
        x.left = this.deleteMin(x.left);
        x.N = this.size(x.left) + this.size(x.right) + 1;
        return x;
    }

    @Override
    public void deleteMax() {
		this.root = this.deleteMax(this.root);
    }

    private Node deleteMax(Node x) {
		if (x.right == null) {
			return x.left;
		}
        x.right = this.deleteMax(x.right);
        x.N = this.size(x.left) + this.size(x.right) + 1;
        return x;
    }

    @Override
    public int size(Key lo, Key hi) {
        return 0;
    }

}
