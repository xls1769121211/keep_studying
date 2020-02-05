package com.xls.Service;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class UserQueue {

    public static ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();

    public static void add(DeferredResult<String> deferredResult){
        queue.add(deferredResult);
    }

    public static DeferredResult<String> get(){
        return ( DeferredResult<String>)queue.poll();
    }
}
