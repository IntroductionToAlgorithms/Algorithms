package com.algorithms.string;

import com.algorithms.util.StdIn;
import com.algorithms.util.StdOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by guangoon on 8/20/17.
 */
public class TrieST {
    private static final int R = 256;
    private Node root;

    private static class Node {
        int count;
        Node[] next;

        Node() {
            count = 0;
            next = new Node[R];
        }
    }

    public void put(String word) {
        //System.out.println(word);
        root = put(root, word, 0);
    }

    private Node put(Node x, String word, int d) {
        //System.out.println("word == " + word + ", d == " + d);
        if (x == null)
            x = new Node();
        if (word.length() == d) {
            x.count++;
            return x;
        }
        int c = word.charAt(d);
        x.next[c] = put(x.next[c], word, d + 1);
        return x;
    }

    public int get(String word) {
        Node x = get(root, word, 0);
        if (x == null)
            return 0;
        else
            return x.count;
    }

    private Node get(Node x, String word, int d) {
        if (x == null)
            return null;
        if (word.length() == d)
            return x;

        return get(x.next[word.charAt(d)], word, d + 1);
    }

    public void delete(String word) {
        root = delete(root, word, 0);
    }

    private Node delete(Node x, String word, int d) {
        if (x == null)
            return null;
        if (d == word.length()) {
            x.count = 0;
        } else {
            x.next[word.charAt(d)] = delete(x.next[word.charAt(d)], word, d + 1);
        }
        if (x.count > 0)
            return x;
        for (int c = 0; c < R; c++) {
            if (x.next[c] != null)
                return x;
        }
        return null;
    }

    public void statisticsWords(){
        statisticsWords(root,"");
    }

    private void statisticsWords(Node x, String pat){
        if(x == null)
            return;
        if(x.count > 0){
            StdOut.println(pat + " : " + x.count);
        }

        for(int i = 0; i < R; i++){
            statisticsWords(x.next[i],pat + (char)i);
        }
    }

    public static void main(String[] args){
        try {
            System.setIn(new FileInputStream("input/magna-carta.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);
        TrieST trieST = new TrieST();
        while(sc.hasNext()){
            trieST.put(sc.next());
        }
        trieST.statisticsWords();
        sc.close();
    }

}
