package com.java.mac.bank;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by yudequan on 16/11/29.
 */
public class Bank
{
    private  Queue<Customer> queue = new LinkedBlockingDeque<Customer>();

    public synchronized  void register(Customer customer)
    {
        queue.offer(customer);

        this.notifyAll();
    }

    public synchronized  Customer business()
    {
        if(queue.isEmpty())
        {
            try
            {
                this.wait();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        Customer peek = queue.peek();

        try
        {
            Thread.sleep(peek.getBusinessType().getTimeConsuming());
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        this.notifyAll();

        return peek;
    }
}
