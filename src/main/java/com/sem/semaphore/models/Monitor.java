package com.sem.semaphore.models;

public class Monitor {
    private final Semaphore semaphore;

    public Monitor(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    public void setRed(){
        semaphore.setState(1);
    }

    public void setYellow(){
        semaphore.setState(2);
    }

    public void setGreen () {
        semaphore.setState(3);
    }

}
