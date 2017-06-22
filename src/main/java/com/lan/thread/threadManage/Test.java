package com.lan.thread.threadManage;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

/**
 * Created by Administrator on 2017/6/22.
 */
public class Test {

    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        deque.add("a");
        deque.add("b");
        deque.add("c");
        deque.addFirst("d");
        deque.addLast("e");
        deque.push("f");
        deque.offer("g");
        System.out.printf(deque.toString());

    }
}
