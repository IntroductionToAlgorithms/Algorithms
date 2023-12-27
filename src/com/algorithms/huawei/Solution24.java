package com.algorithms.huawei;

import java.util.ArrayList;

/**
 * dfs 计算是否可以24点
 *
 * @author jiangfw
 */
public class Solution24 {

    public boolean judgePoint24(int[] nums) {

        ArrayList<Double> list = new ArrayList<>();
        for (Integer num : nums) {
            list.add((double) num);
        }
        return this.dfs(list);
    }

    public boolean dfs(ArrayList<Double> nums) {
        if (nums.size() == 0) {
            return false;
        }
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) < 1e-6;
        }

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i != j) {
                    double num1 = nums.get(i);
                    double num2 = nums.get(j);
                    ArrayList<Double> list = new ArrayList<>();
                    for (int k = 0; k < nums.size(); k++) {
                        if (k != i && k != j) {
                            list.add(nums.get(k));
                        }
                    }

                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && j > i) {
                            continue;
                        }
                        if (k == 0) {
                            System.out.println("00000000000000000000000000");
                            list.add(num1 + num2);
                        } else if (k == 1) {
                            System.out.println("111111111111111111111111111");
                            list.add(num1 * num2);
                        } else if (k == 2) {
                            System.out.println("22222222222222222222222222");
                            list.add(num1 - num2);
                        } else if (k == 3 && num2 != 0) {
                            System.out.println("333333333333333333333333333");
                            list.add(num1 / num2);
                        } else {
                            System.out.println("444444444444444444444444444");
                            continue;
                        }

                        if (this.dfs(list)) {
                            System.out.println("nums is " + num1 + "," + num2);
                            System.out.println("结果：" + list);
                            return true;
                        }
                        list.remove(list.size() - 1);
                    }
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] heights = {1, 4, 5, 6};
        boolean judgePoint24 = new Solution24().judgePoint24(heights);
        System.out.println("是否可以计算24点：" + judgePoint24);
    }

}