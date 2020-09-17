package com.test.hackerrant;

public class SampleThreadDemo  {
    public static void main(String[] args) {
        SampleThread a = new SampleThread("A");
        SampleThread b = new SampleThread("B");

        b.start();
        a.start();

    }
}

class SampleThread implements Runnable {

    private Thread t;
    private String threadName;

    public SampleThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        while (true)
            System.out.println(threadName);
    }

    public void start(){
        if(t == null){
            t = new Thread(this, threadName);
            t.start();
        }
    }


}
