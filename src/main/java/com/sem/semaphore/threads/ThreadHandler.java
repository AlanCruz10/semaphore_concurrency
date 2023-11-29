package com.sem.semaphore.threads;

import com.sem.semaphore.models.Monitor;

import java.util.Observable;

public class ThreadHandler extends Observable implements Runnable{

    private Monitor monitor;

    public ThreadHandler (Monitor monitor){
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (true) {
            monitor.setGreen();
            setChanged();
            notifyObservers("3");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            monitor.setYellow();
            setChanged();
            notifyObservers("2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            monitor.setRed();
            setChanged();
            notifyObservers("1");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
