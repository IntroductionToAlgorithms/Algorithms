package com.algorithms.nowcoder.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 加密字符串
 */
public class Main6 {

    public static void main(String[] args) {
        method1();
    }

    public static void method1() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int len = s.length();
        List<String> list = new ArrayList<>();

        String temp = "";
        Boolean yh = false; //是否有引号
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != '_') {
                if (s.charAt(i) == '\"') {
                    yh = !yh;
                }
                temp += s.charAt(i);  //非下划线直接拼接字符
                if (i == len - 1) {
                    list.add(temp); //最后一位直接push
                }
            } else {
                if (temp == "") {
                    continue;   //字符串为空则进入下个循环
                }
                if (yh) {
                    temp += s.charAt(i);  //引号内的下划线直接拼接字符串
                } else {
                    list.add(temp); //push字符串
                    temp = "";  //置空为下次使用
                }
            }
        }
        int count = list.size();
        if (n >= count) {
            System.out.println("ERROR");
        } else {
            String res = "";
            for (int i = 0; i < count; i++) {
                if (i == n) {
                    res += "******";  //对应下标的字符串进行加密
                } else {
                    res += list.get(i);   //拼接字符串
                }
                if (i != list.size() - 1) {
                    res += "_";   //非最后一个后面需要加下划线
                }
            }
            System.out.println(res);
        }

    }

}
