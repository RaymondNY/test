package com.example.kafka.thread;

import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;

public class TestThreadMain {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = MyThreadPoolUtils.getThreadPool();
        for (int i = 0; i < 10; i++) {
            HashMap map = new HashMap();
            map.put("1","1");
            WorkThread w = new WorkThread(map);
            threadPool.execute(w);
            System.out.println("完成");
        }

    }
}
