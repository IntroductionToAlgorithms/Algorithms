package com.algorithms.huawei;

/**
 * 太阳能板最大面积
 *
 * @author jiangfw
 */
public class SolarPanelMaxArea {

    public static long getMaxArea(int[] heights) {
        int n = heights.length;
        long maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int minHeight = Math.min(heights[i], heights[j]);
                long currentArea = (long) minHeight * (j - i);
                maxArea = Math.max(maxArea, currentArea);
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

