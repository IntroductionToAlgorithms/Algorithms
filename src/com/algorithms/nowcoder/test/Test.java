package com.algorithms.nowcoder.test;

import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: jiangfw
 * @Date: 2023/09/11
 */
public class Test {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new SynAddRunnable(1, 2)).start();
            new Thread(new SynAddRunnable(2, 1)).start();
        }
        Integer a = Integer.valueOf(1);
        Integer b = Integer.valueOf(1);
        Integer c = new Integer(1000);
        Integer d = new Integer(1000);
        Queue<Record> queue = new PriorityQueue<>(new RecordComparator());
        queue.add(new Record(9, 3));
        queue.add(new Record(8, 5));
        queue.add(new Record(4, 3));
        queue.add(new Record(0, 3));
        queue.add(new Record(7, 1));

        String joined = queue.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "#", "$"));
        Set<Entry<Integer, List<String>>> entries = queue.stream().map(Objects::toString)
                .collect(Collectors.groupingBy(String::length)).entrySet();
        System.out.println(joined);
        queue.forEach(System.out::println);
//        while (!queue.isEmpty()) {
//            System.out.println(queue.nex());
//        }
        Record poll = queue.poll();

        System.out.println(".............................");
        queue.forEach(System.out::println);
        poll.times = 2;

        queue.add(poll);
        System.out.println(".............................");
        queue.forEach(System.out::println);

        System.out.println(".............................");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    public static class Record {

        public int number;
        public int times;

        public Record(int number, int times) {
            this.number = number;
            this.times = times;
        }

        @Override
        public String toString() {
            return this.number + ":" + this.times;
        }
    }

    public static class RecordComparator implements Comparator<Record> {

        @Override
        public int compare(Record o1, Record o2) {
            if (o1.times == o2.times) {
                return o2.number - o1.number;
            }
            return o2.times - o1.times;
        }
    }

    static class SynAddRunnable implements Runnable {

        int a, b;

        public SynAddRunnable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        //死锁的原因是Integer常量池，-128~127之间Integer不会新建新对象,实参1 2 在 -128~127之间，
        //所以100次循环（即200个线程）中只有两个对象   new Integer(1)    new Integer(2)
        //要执行一次run()方法，必须同时掌握这两个仅有的对象，
        //即任何一个线程，要么同时掌握  new Integer(1)    new Integer(2)两个对象，要么不掌握任何一个对象
        //如果仅掌握一个对象（即另外一个对象掌握在其他线程手里），马上就会死锁，200个线程太容易出现这种情况而死锁了
        @Override
        public void run() {
            synchronized (Integer.valueOf(this.a)) {
                synchronized (Integer.valueOf(this.b)) {
                    System.out.println(this.a + this.b);
                }
            }
        }
    }
}
