package com.algorithms.nowcoder.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 磁盘容量排序
 * <p>
 * 磁盘的容量单位常用的有M，G，T这三个等级， 它们之间的换算关系为1T = 1024G，1G = 1024M，
 * <p>
 * 现在给定n块磁盘的容量， 请对它们按从小到大的顺序进行
 */
public class Main3 {

    public static void main(String[] args) {
//        method1();
        method2();

    }

    public static void method1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int[][] num = new int[n][2];    //用来放置磁盘索引和单位转换成M之后的数值
        Map<Integer, String> map = new HashMap<>(); //用来放置磁盘索引和磁盘原数值

        for (int i = 0; i < n; i++) {
            int sum = 0;
            int index = -1;
            String str = sc.nextLine();
            map.put(i + 1, str);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'M') {
                    sum += Integer.parseInt(str.substring(index + 1, j));
                    index = j;
                } else if (str.charAt(j) == 'G') {
                    sum += Integer.parseInt(str.substring(index + 1, j)) * 1024;
                    index = j;
                } else if (str.charAt(j) == 'T') {
                    sum += Integer.parseInt(str.substring(index + 1, j)) * 1024 * 1024;
                    index = j;
                }
            }
            num[i][0] = i + 1;
            num[i][1] = sum;

        }
        Arrays.sort(num,
                (e1, e2) -> (e1[1] == e2[1] ? (e1[0] - e2[0]) : (e1[1] - e2[1])));  //对二维数组进行排序

        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.print(map.get(num[i][0]));
            } else {
                System.out.println(map.get(num[i][0]));
            }
        }


    }

    public static void method2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Queue<HardDisk> queue = new PriorityQueue<>(
                (o1, o2) -> o1.getCapacity() == o2.getCapacity() ? o1.index - o2.index
                        : o1.getCapacity() - o2.getCapacity());
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            queue.add(new HardDisk(str, i));
        }

        while (queue.peek() != null) {
            System.out.println(queue.poll().origin);
        }
    }


    public static class HardDisk {

        public String origin;
        private int index;

        public HardDisk(String origin, int index) {
            this.origin = origin;
            this.index = index;
        }

        public int getCapacity() {
            int sum = 0;
            int index = -1;
            for (int j = 0; j < this.origin.length(); j++) {
                if (this.origin.charAt(j) == 'M') {
                    sum += Integer.parseInt(this.origin.substring(index + 1, j));
                    index = j;
                } else if (this.origin.charAt(j) == 'G') {
                    sum += Integer.parseInt(this.origin.substring(index + 1, j)) * 1024;
                    index = j;
                } else if (this.origin.charAt(j) == 'T') {
                    sum += Integer.parseInt(this.origin.substring(index + 1, j)) * 1024 * 1024;
                    index = j;
                }
            }
            return sum;
        }
    }
}
