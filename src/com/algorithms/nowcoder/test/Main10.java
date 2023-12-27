package com.algorithms.nowcoder.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 篮球(5V5)比赛中，每个球员拥有一个战斗力，每个队伍的所有球员战斗力之和为该队伍的总体战斗力。
 * 现有10个球员准备分为两队进行训练赛，教练希望2个队伍的战斗力差值能够尽可能的小，
 * 以达到最佳训练效果。给出10个球员的战斗力，如果你是教练，你该如何分队，才能达到最佳训练效果?
 * 请输出该分队方案下的最小战斗力差值。
 * <p>
 * 输入描述:
 * 10个篮球队员的战斗力(整数，范围[1,10000]) ，战斗力之间用空格分隔，如: 10 9 8 7 6 5 4 3 2 1不需要考虑异常输入的场景。
 * 输出描述:
 * 最小的战斗力差值，如: 1
 * <p>
 * 说明：
 * 1 2 5 9 10分为一队，3 4 6 7 8分为一队，两队战斗力之差最小，输出差值1。备注：球员分队方案不唯一，但最小战斗力差值固定是1
 * <p>
 * 结题思路：
 * 因为题目确定了是10个队员分两队，也就是每个队5个人，我们可以先固定前四个队员，
 * 接着遍历剩下的六名选择其中一个队员为一队，剩下5人为二队，计算两队战力并求差。
 * 然后固定前三个队员+第五位队员，接着遍历后面的五位队员选择其中一个队员为一队，
 * 剩下5人为二队，计算两队战力并求差。。。。最后求差值的最小值
 */
public class Main10 {

    private static List<Integer> nums = new ArrayList<>();
    private static List<List<Integer>> dataCombine = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] data = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        method1(data);
    }

    /**
     * 全排列，将10人分成两组共有 10*9*8*7*6/(5*4*3*2)种
     */
    public static void method1(int[] data) {

        int total = Arrays.stream(data).sum();
        combine(data, 5, new ArrayList<Integer>(), 0);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            min = Math.min(min, Math.abs(total - 2 * nums.get(i)));
        }
        System.out.println(min);
    }

    /**
     * 从data数组中选取i个数组的组合
     *
     * @param data  数组
     * @param n     需要的队员个数
     * @param list  加入的队员
     * @param index 队员下标
     */
    private static void combine(int[] data, int n, ArrayList<Integer> list, int index) {
//        if (n == 0) {
//            int res = 0;
//            for (int i = 0; i < list.size(); i++) {
//                res += list.get(i);
//            }
//            int total = Arrays.stream(data).sum();
//            nums.add(res);
//        } else {
//            for (int i = index; i < data.length; i++) {
//                list.add(data[i]);
//                combine(data, n - 1, list, i + 1);
//                list.remove(list.size() - 1);
//            }
//        }

        //已经做好了组合，统计业务数据：比如计算组合的和
        if (n == 0) {
            Integer sum = list.stream().reduce(Integer::sum)
                    .get();
            List<Integer> dest = new ArrayList<>(Collections.nCopies(list.size(), 0));
            List<Integer> dest2 = Collections.nCopies(list.size(), 0);
            Collections.copy(dest, list);
            dataCombine.add(dest);
            nums.add(sum);
        } else {
            for (int i = index; i < data.length; i++) {
                list.add(data[i]);
                combine(data, n - 1, list, i + 1);
                list.remove(list.size() - 1);
            }
        }


    }

}
