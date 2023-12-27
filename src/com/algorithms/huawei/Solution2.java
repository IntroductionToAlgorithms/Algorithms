package com.algorithms.huawei;

/**
 * 太阳能板最大面积
 *
 * @author jiangfw
 */
public class Solution2 {

    public static long getMaxArea(int[] heights) {
        int n = heights.length;
        long maxArea = 0;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int minHeight = Math.min(heights[left], heights[right]);
            long currentArea = (long) minHeight * (right - left);
            maxArea = Math.max(maxArea, currentArea);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
//        int[] heights = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] heights = {10, 100, 8, 7, 11, 9};
        long maxArea = getMaxArea(heights);
        System.out.println("最大太阳能板面积为：" + maxArea);
    }

}