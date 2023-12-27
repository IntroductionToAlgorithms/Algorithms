package com.algorithms.huawei;

/**
 * 最长公共后缀
 *
 * @author jiangfw
 */
public class Solution1 {

    public static void main(String[] args) {
        String[] a = new String[]{"abc", "bbc", "c"};
//        String[] a = new String[]{"aa","bb","cc"};
//        String[] a = new String[]{"ajiangfw", "jiangfengwei", "jiangffff"};
        System.out.println(new Solution1().longestCommonPostfix(a));
        System.out.println(new Solution1().longestCommonPostfix(new String[]{"aa", "bb", "cc"}));
        System.out.println(new Solution1().longestCommonPostfix(
                new String[]{"ajiangfwwei", "jiangfengwei", "zhangwei"}));
    }

    /**
     * 求最长公共后缀
     *
     * @param strs string字符串一维数组 字符串数组
     * @return string字符串
     */
    public String longestCommonPostfix(String[] strs) {
        // write code here
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            pre = getSubfix(pre, strs[i]);
            if (pre.equals("@Zero")) {
                return pre;
            }
        }
        return pre;
    }


    /**
     *
     */
    public static String getSubfix(String s1, String s2) {

        int l1 = s1.length();
        int l2 = s2.length();
        int i = 1;
        while (i <= l1 && i <= l2) {
            char c1 = s1.charAt(l1 - i);
            char c2 = s2.charAt(l2 - i);
            if (c1 != c2) {
                break;
            }
            i++;
        }
        if (i == 1) {
            return "@Zero";
        }

        return s1.substring(l1 - i + 1, l1);
//        int length1 = s1.length();
//
//        int length2 = s2.length();
//
//        int i = 1;
//        while (length1 - i >= 0 && length2 - i >= 0 && s1.charAt(length1 - i) == s2
//                .charAt(length2 - i)) {
//            i++;
//        }
//
//        if (i == 1) {
//            return "@Zero";
//        }
//
//        return s1.subSequence(length1 - i + 1, length1).toString();
    }
}