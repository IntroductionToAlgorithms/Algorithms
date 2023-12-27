package com.algorithms.nowcoder.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * [0,3]和[1,3]的公共区间为[1,3]
 * <p>
 * [0,3]和[3,5]的公共区间为[3,3]
 * <p>
 * [0,3]和[3,6]的公共区间为[3,3]
 * <p>
 * [1,3]和[3,5]的公共区间为[3,3]
 * <p>
 * [1,3]和[3,6]的公共区间为[3,3]
 * <p>
 * [3,5]和[3,6]的公共区间为[3,5]
 * <p>
 * 公共区间列表为[[1,3],[3,3],[3,5]]；[1,3],[3,3],[3,5]存在交集，须合并为[1,5]。
 */
public class Main8 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a, b;
        List<Node> nodeList = new ArrayList<>();
        List<Node> nodeList2 = new ArrayList<>();
        while (sc.hasNextLine()) {
            String nextLine = sc.nextLine();
            if (nextLine.length() == 0) {
                break;
            }
//            a = sc.nextInt();
//            if (a == -1) {
//                break;
//            }
//            b = sc.nextInt();
            String[] s = nextLine.split(" ");
            Node node = new Node(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
            nodeList.add(node);
        }
        Collections.sort(nodeList);    //对集合进行排序
        for (int i = 0; i < nodeList.size(); i++) {
            for (int j = i + 1; j < nodeList.size(); j++) {
                if (nodeList.get(j).l <= nodeList.get(i).r) {
                    a = Math.max(nodeList.get(i).l, nodeList.get(j).l);
                    b = Math.min(nodeList.get(i).r, nodeList.get(j).r);
                    nodeList2.add(new Node(a, b));
                }
            }
        }
        if (nodeList2.isEmpty()) {
            System.out.println("None");
            return;
        }
        Collections.sort(nodeList2);
        int l = nodeList2.get(0).l;
        int r = nodeList2.get(0).r;
        for (int i = 1; i < nodeList2.size(); i++) {
            Node node = nodeList2.get(i);
            if (node.l > r) {
                System.out.println(l + " " + r);
                l = node.l;
                r = node.r;
            } else {
                l = Math.min(l, node.l);
                r = Math.max(r, node.r);
            }

        }
        System.out.print(l + " " + r);
    }

    static class Node implements Comparable<Node> {

        private int l;
        private int r;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }

        /**
         * 排序规则
         */
        @Override
        public int compareTo(Node o) {
            if (this.l == o.l) {
                return this.r - o.r;
            }
            return this.l - o.l;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "l=" + this.l +
                    ", r=" + this.r +
                    '}';
        }
    }

}
