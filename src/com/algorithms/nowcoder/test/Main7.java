package com.algorithms.nowcoder.test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 字符串拼接成最大的数
 * <p>
 * 9999,4589,41425,101 -> 9999458941425101
 * <p>
 * 4589,101,41425,9999 -> 9999458941425101
 * <p>
 * 4589,201,45891,9999 -> 9999458945891201
 * <p>
 * 4589,201,45895,9999 -> 9999458954589201
 */
public class Main7 {

    public static void main(String[] args) {
        method2();
    }

    public static void method1() {

        Scanner sc = new Scanner(System.in);

        String[] str = sc.nextLine().split(",");
        int len = str.length;

        /**
         * 经典排序算法
         */
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (Integer.parseInt(str[i] + str[j]) < Integer.parseInt(str[j] + str[i])) {
                    String temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }

        String res = "";
        for (int i = 0; i < len; i++) {
            res += str[i];
        }

        System.out.println(res);


    }

    /**
     * 采用动态规划
     */
    public static void method2() {
        Scanner sc = new Scanner(System.in);

        String[] str = sc.nextLine().split(",");
        int len = str.length;
        String[] dp = dp(str);
        String res = "";
        for (int i = 0; i < len; i++) {
            res += dp[i];
        }

        System.out.println(res);
    }

    public static String[] dp(String[] a) {
        String[] result;

        if (a.length == 2) {
            if (Integer.parseInt(a[0] + a[1]) < Integer.parseInt(a[1] + a[0])) {
                String temp = a[0];
                a[0] = a[1];
                a[1] = temp;
            }
            return a;
        }
        String[] temp = dp(Arrays.copyOf(a, a.length - 1));
        int index = a.length - 1;
        String last = a[index];
        for (int j = 0; j < temp.length; j++) {
            if (Integer.parseInt(temp[j] + last) < Integer.parseInt(last + temp[j])) {
                index = j;
                break;
            }
        }
        String[] firstPart = Arrays.copyOfRange(temp, 0, index);
        String[] secondPart = Arrays.copyOfRange(temp, index, temp.length);
        result = Stream.concat(Arrays.stream(firstPart),
                Stream.concat(Stream.of(last), Arrays.stream(secondPart)))
                .toArray(String[]::new);
//                result = (String[]) newArray;
        return result;
    }

}
