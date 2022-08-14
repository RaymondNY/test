package com.example.kafka.thread;

import java.util.HashMap;

public class WorkThread implements Runnable{
    private HashMap hashMap;
    public WorkThread(HashMap hashMap) {
        this.hashMap=hashMap;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(hashMap.size());
    }
}
