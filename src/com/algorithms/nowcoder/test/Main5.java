package com.algorithms.nowcoder.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述:
 * <p>
 * 有若干个文件，使用刻录光盘的方式进行备份，假设每张光盘的容量是500MB，
 * <p>
 * 求使用光盘最少的文所有文件的大小都是整数的MB，且不超过500MB;文件不能分割、分卷打包
 * <p>
 * 示例1
 * <p>
 * 输入: 100,500,300,200,400
 * <p>
 * 输出: 说明: (100.400),(200.300),(500) 3张光盘即可。 输入和输出内容都不含空格。
 */
public class Main5 {

    public static int[] files;

    public static void main(String[] args) {
        method1();
    }

    public static void method1() {
        Scanner sc = new Scanner(System.in);

        files = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(files);

        int min = 0;
        int max = files.length + 1;
        int result = files.length;
        while (min < max) {

            int mid = (min + max) / 2;
            if (mid == 0) {
                break;
            }
            if (check(mid)) {
                max = mid;
                result = mid;
            } else {
                min = mid + 1;
            }

        }

        System.out.println(result);

    }

    public static boolean check(int mid) {

        int[] ints = new int[mid];
        for (int i = 0; i < mid; i++) {
            ints[i] = 500;
        }

        for (int i = files.length - 1; i >= 0; i--) {
            int f = files[i];
            Arrays.sort(ints);
            if (ints[mid - 1] >= f) {
                ints[mid - 1] -= f;
            } else {
                return false;
            }
        }

        return true;
    }

}
