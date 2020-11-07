package com.company;

import java.util.ArrayDeque;
import java.util.Deque;

public interface ThreadPool {

    void start(); // запускает потоки. Потоки бездействуют, до тех пор пока не появится новое
    // задание в очереди (см. execute)

    void execute(Runnable runnable); // складывает это задание в очередь.
    // Освободившийся поток должен выполнить это задание. Каждое задание должно быть выполнено ровно 1 раз
}

public class FixedThreadPool implements ThreadPool {
    private final Deque<String> deque = new ArrayDeque<>();
    private final int maxSize;
    int x = 0;

    public FixedThreadPool(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public void start() {
        while (true){
            synchronized (deque) {
                while (deque.size() > maxSize) {
                    try {
                        deque.wait();
                    } catch (InterruptedException ignore) {
                    }
                }
                deque.add(String.valueOf(x++));
                deque.notify();
                break;
            }

        }
    }

    @Override
    public void execute(Runnable runnable) {
        while (true){
            synchronized (deque) {
                while (!(deque.isEmpty())) {
                    try{
                        deque.wait();
                    } catch (InterruptedException ignore){}
                }
                String first = deque.removeFirst();
                deque.notify();
                System.out.println(first);
            }
        }
    }

    public static void main (String[] args){
        FixedThreadPool fixedThreadPool = new FixedThreadPool(maxSize);
        fixedThreadPool.start();
        fixedThreadPool.execute(something); //DO SMTH WITH IT
    }
}

public class ScalableThreadPool implements ThreadPool{
    private final Deque<String> deque = new ArrayDeque<>();
    private final int maxSizePool;
    private final int minSizePool;
    int x = 0;

    public ScalableThreadPool(int maxSizePool, int minSizePool) {
        this.maxSizePool = maxSizePool;
        this.minSizePool = minSizePool;
    }

    @Override
    public void start() {
        while (true){
            synchronized (deque) {
                while (deque.size() > minSizePool){
                    try {
                        deque.wait();
                    } catch (InterruptedException ignore){}
                }
                if (deque.size() == minSizePool & !(deque.isEmpty())){
                    while (deque.size() > maxSizePool) {
                        try {
                            deque.wait();
                        } catch (InterruptedException ignore) {
                        }
                    }
                }
                deque.add(String.valueOf(x++));
                deque.notify();
                break;
            }
        }
    }


    @Override
    public void execute(Runnable runnable) {
        while (true){
            synchronized (deque) {
                while (!(deque.isEmpty())) {
                    try{
                        deque.wait();
                    } catch (InterruptedException ignore){}
                }
                String first = deque.removeFirst();
                deque.notify();
                System.out.println(first);
            }
        }
    }

    public static void main (String[] args){
        ScalableThreadPool scalableThreadPool = new ScalableThreadPool(min, max);
        scalableThreadPool.start();
        scalableThreadPool.execute(smth);//stillУ 
    }
}