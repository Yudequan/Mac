package com.java.mac;

/**
 * Created by yudequan on 16/11/29.
 */
public class TestJoin
{

    public static void main(String[] args)
    {
        Thread t1 = new Thread(new MyThread1());
        Thread t = new Thread(new MyThread(t1));
        t1.setName("t1");
        t.setName("t");
        t.start();
        t1.start();
    }
}

class MyThread implements Runnable
{
    private Thread t1;

    public MyThread(Thread t1)
    {
        this.t1 = t1;
    }

    public void run()
    {
        try
        {
            t1.join();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread());
    }
}

class MyThread1 implements Runnable
{
    public void run()
    {
        System.out.println(Thread.currentThread());
    }
}
