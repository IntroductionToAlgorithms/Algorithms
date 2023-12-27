package com.algorithms.nowcoder.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Author: jiangfw
 * @Date: 2023/09/10
 */
public class Main {

    public static void main(String[] args) {
//        method1();
        method2();
    }

    public static void method1() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            String string = sc.nextLine();
            String[] twoPart = string.split("@");
            if (twoPart.length != 2) {
                return;
            }
            String all = twoPart[0];
            String used = twoPart[1];
            String[] oneOfAllArray = all.split(",");
            if (oneOfAllArray.length == 0) {
                return;
            }
            String[] oneOfUsedArray = used.split(",");
            if (oneOfUsedArray.length == 0) {
                return;
            }
            Map<Character, Integer> allMap = new LinkedHashMap<>();
            for (String oneOfAll : oneOfAllArray) {
                String[] one = oneOfAll.split(":");
                if (one.length != 2) {
                    return;
                }
                Character c = one[0].charAt(0);

                if ((c <= 'Z' && c >= 'A') || (c <= 'z' && c >= 'a')) {
                    int allNum = Integer.parseInt(one[1]);
                    if (allNum < 0 || allNum > 100) {
                        return;
                    }
                    allMap.put(c, allNum);
                } else {
                    return;
                }

            }

            for (String oneOfUsed : oneOfUsedArray) {
                String[] one = oneOfUsed.split(":");
                Character c = one[0].charAt(0);
                Integer usedNum = allMap.get(c);
                if (usedNum == null) {
                    return;
                }
                Integer num = Integer.parseInt(one[1]);
                allMap.put(c, allMap.get(c) - num);
            }

            List<String> collect = allMap.entrySet().stream().filter(entry -> entry.getValue() > 0)
                    .map(entry -> entry.getKey() + ":" + entry.getValue())
                    .collect(Collectors.toList());
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < collect.size(); i++) {
                if (i == collect.size() - 1) {
                    result.append(collect.get(i));
                } else {
                    result.append(collect.get(i)).append(",");
                }
            }
            System.out.println(result);
        }
    }

    public static void method2() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split("@");

        HashMap<String, Integer> last = new HashMap<>();
        LinkedList<String> strings = new LinkedList<>();
        String[] all = split[0].split(",");
        if (split.length == 1) {
            for (int i = 0; i < all.length; i++) {
                String[] spl = all[i].split(":");
                last.put(spl[0], Integer.valueOf(spl[1]));
                strings.add(spl[0]);
            }
            String o1 = "";
            for (int i = 0; i < strings.size(); i++) {
                Integer integer = last.get(strings.get(i));
                o1 = o1 + strings.get(i) + ":" + integer + ",";
            }
            String substring = o1.substring(0, o1.length() - 1);
            System.out.println(substring);
            return;
        }
        for (int i = 0; i < all.length; i++) {
            String[] spl = all[i].split(":");
            last.put(spl[0], Integer.valueOf(spl[1]));
            strings.add(spl[0]);

        }
        String[] bb = split[1].split(",");
        for (int i = 0; i < bb.length; i++) {
            String[] spl = bb[i].split(":");
            Integer integer = last.get(spl[0]);
            if (integer != null) {
                int i1 = last.get(spl[0]) - Integer.valueOf(spl[1]);
                if (i1 > 0) {
                    last.put(spl[0], i1);
                } else {
                    last.remove(spl[0]);
                    strings.remove(spl[0]);
                }

            }
        }
        String o = "";
        for (int i = 0; i < strings.size(); i++) {
            Integer integer = last.get(strings.get(i));
            o = o + strings.get(i) + ":" + integer + ",";
        }
        String substring = o.substring(0, o.length() - 1);
        System.out.println(substring);
    }

}
