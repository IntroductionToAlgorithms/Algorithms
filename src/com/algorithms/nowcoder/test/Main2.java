package com.algorithms.nowcoder.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: jiangfw
 * @Date: 2023/09/10
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = 0;
        if (sc.hasNextLine()) {
            num = Integer.parseInt(sc.nextLine());

        }
        //初始化的最小子数组个数是数组本身的个数
        int leastSubArrayCount = num;
        if (sc.hasNextLine()) {
            String numString = sc.nextLine();
            String[] dataArray = numString.split(" ");
            int[] intDataArray = new int[dataArray.length];
            for (int i = 0; i < dataArray.length; i++) {
                intDataArray[i] = Integer.parseInt(dataArray[i]);
            }

            //判断子数组从1开始判断,最多判断到一半的长度即可
            for (int i = 1; i <= num / 2; i++) {
                //符合子数组的分段，即可继续往下判断
                if (num % i == 0) {
                    if (isOK(intDataArray, i)) {
                        leastSubArrayCount = i;
                        break;
                    }
                }
            }
            int[] subArray = Arrays.copyOfRange(intDataArray, 0, leastSubArrayCount);
            for (int i = 0; i < subArray.length; i++) {
                if (i == subArray.length - 1) {
                    System.out.println(subArray[i]);
                } else {
                    System.out.print(subArray[i] + " ");
                }
            }
        }


    }

    public static boolean isOK(int[] nums, int subNum) {
        int start = 0;
        while (start + subNum < nums.length) {
            int[] firstArray = Arrays.copyOfRange(nums, start, start + subNum);
            int[] nextArray = Arrays.copyOfRange(nums, start += subNum, start + subNum);
            if (!valueEquals(firstArray, nextArray)) {
                return false;
            }
        }

        return true;
    }

    public static boolean valueEquals(int[] a, int[] a2) {

        int length = a.length;
        if (a2.length != length) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (a[i] != a2[i]) {
                return false;
            }
        }

        return true;
    }


}
