package com.sogou.sb.demos.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestFutureTask {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final ExecutorService exec = Executors.newFixedThreadPool(5);
        Callable call = new Callable() {
            public String call() throws Exception {
                Thread.sleep(1000 * 5);
                return "Other less important but longtime things.";
            }
        };
        Future task = exec.submit(call);
// ��Ҫ������  
        Thread.sleep(1000 * 3);
        System.out.println("Let��s do important things.");
// ��������Ҫ������  
        String obj = (String) task.get();
        System.out.println(obj);
// �ر��̳߳�  
        exec.shutdown();
    }
}  