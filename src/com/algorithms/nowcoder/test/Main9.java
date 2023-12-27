package com.algorithms.nowcoder.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * news.qq.com
 * news.sina.com.cn
 * news.qq.com
 * news.qq.com
 * game.163.com
 * game.163.com
 * www.huawei.com
 * www.cctv.com
 * www.huawel.com
 * www.cctv.com
 * www.huawei.com
 * www.cctv.com
 * www.huawei.com
 * www.cctv.com
 * www.huawei.com
 * www.cctv.com
 * www.huawei.com
 * 3
 */
public class Main9 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();

        while (sc.hasNext()) {

            String str = sc.nextLine();
            if (!str.contains(".")) {
                int n = Integer.parseInt(str);
                if (n > map.size()) {
                    break;
                }

                List<Map.Entry<String, Integer>> list = new ArrayList<>(
                        map.entrySet());

                List<Entry<String, Integer>> collect = map.entrySet().stream()
                        .sorted((o1, o2) -> o1.getValue() > o2.getValue() ? -1 : 1).collect(
                                Collectors.toList());
                String res = "";
                list.sort((a, b) -> {
                    if (b.getValue() < a.getValue()) {
                        return -1;
                    }
                    return 1;
                });

                for (int i = 0; i < n; i++) {
                    res += list.get(i).getKey();
                    if (i != n - 1) {
                        res += ",";
                    }
                }

                System.out.println(res);
            } else {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
    }


}
