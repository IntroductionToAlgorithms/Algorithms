package com.algorithms.nowcoder.test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 */
public class Main11 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int i = lengthOfLongestSubstring(string);
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                Character character = s.charAt(j);
                if (set.contains(character)) {
                    break;
                }
                set.add(character);
            }
            count = Math.max(count, set.size());
        }

        return count;
    }
}
