package com.algorithms.nowcoder.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * <p>
 * 一个工厂有m条流水线，来并行完成n个独立的作业，该工厂设置了一个调度系统，在安排作业时，总是优先执行处理时间最短的作业。
 * <p>
 * 现给定流水线个数m，需要完成的作业数n, 每个作业的处理时间分别为t1,t2…tn。请你编程计算处理完所有作业的耗时为多少？
 * <p>
 * 当n>m时，首先处理时间短的m个作业进入流水线，其他的等待，当某个作业完成时，依次从剩余作业中取处理时间最短的进入处理。
 * <p>
 * 输入描述:
 * <p>
 * 第一行为2个整数(采用空格分隔)，分别表示流水线个数m和作业数n;
 * <p>
 * 第二行输入n个整数(采用空格分隔)，表示每个作业的处理时长t1.t2...tn。
 * <p>
 * 0< m.n<100，0<t1.t2...tn<100.注: 保证输入都是合法的 输出描述: 输出处理完所有作业的总时长
 */
public class Main4 {

    public static void main(String[] args) {
        method2();
    }

    public static void method1() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int dp[] = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dp[i] = sc.nextInt();
            list.add(dp[i]);
        }

        Arrays.sort(dp);
        if (m >= n) {
            System.out.println(dp[n - 1]);
            return;
        }
        Collections.sort(list);
        int res = 0;
        for (int i = 0; i < m; i++) {
            int time = 0;
            for (int j = i; j < list.size(); j += m) {
                time += list.get(j);
            }
            res = Math.max(res, time);
        }
        System.out.println(res);


    }

    public static void method2() {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int round = n / m;
        int index = n % m == 0 ? m : n % m;
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            int time = sc.nextInt();
            data[i] = time;
        }
        Arrays.sort(data);
        int base = 0;
        for (int j = 0; j <= round && j * m + index - 1 < n; j++) {
            base += data[j * m + index - 1];
        }
        System.out.println(base);
    }

}
