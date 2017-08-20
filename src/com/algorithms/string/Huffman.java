package com.algorithms.string;

import com.algorithms.sort.MaxPQ;
import com.algorithms.sort.MinPQ;
import com.algorithms.util.BinaryStdIn;
import com.algorithms.util.BinaryStdOut;

import java.io.*;

/**
 * Created by guangoon on 8/20/17.
 */
public class Huffman {
    private static final int R = 256;

    private static class Node implements Comparable<Node> {
        @Override
        public int compareTo(Node node) {
            return freq - node.freq;
        }

        char ch;
        int freq;
        Node left;
        Node right;

        public Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }
    }

    public static void compress() {
        String s = BinaryStdIn.readString();
        //System.out.println(s);
        char[] charArray = s.toCharArray();
        int[] count = new int[R];
        for (int i = 0; i < charArray.length; i++) {
            count[charArray[i]]++;
        }
        Node root = buildHuffmanTree(count);

        String[] st = new String[R];
        buildCode(st, root, "");
        writeTrie(root);
        BinaryStdOut.write(s.length());
        for (int i = 0; i < s.length(); i++) {
            String code = st[s.charAt(i)];
            for (int j = 0; j < code.length(); j++) {
                if (code.charAt(j) == '0')
                    BinaryStdOut.write(false);
                if (code.charAt(j) == '1')
                    BinaryStdOut.write(true);
            }
        }
    }

    public static Node buildHuffmanTree(int[] freq) {
        MinPQ<Node> pq = new MinPQ<>();
        for (char c = 0; c < R; c++) {
            if (freq[c] > 0)
                pq.insert(new Node((char) c, freq[c], null, null));
        }

        while (pq.size() > 1) {
            Node left = pq.delMin();
            Node right = pq.delMin();
            pq.insert(new Node('\0', left.freq + right.freq, left, right));
        }

        return pq.delMin();
    }

    public static void buildCode(String[] st, Node x, String code) {
        if (!x.isLeaf()) {
            buildCode(st, x.left, code + '0');
            buildCode(st, x.right, code + '1');
        } else {
            st[x.ch] = code;
        }
    }

    public static void writeTrie(Node x) {
        if (x.isLeaf()) {
            BinaryStdOut.write(true);
            BinaryStdOut.write(x.ch, 8);
            return;
        }

        BinaryStdOut.write(false);
        writeTrie(x.left);
        writeTrie(x.right);
    }

    public static void expand() {

    }

    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("input/abra.txt"));
            System.setOut(new PrintStream(new FileOutputStream("input/huffmanabra.txt")));
            compress();
            BinaryStdOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
