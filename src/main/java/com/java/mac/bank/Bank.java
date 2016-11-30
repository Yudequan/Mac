package com.java.mac.bank;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by yudequan on 16/11/29.
 */
public class Bank
{
    private volatile BlockingQueue<Customer> queue = new LinkedBlockingQueue<Customer>();

    public synchronized void register(Customer customer)
    {
        System.out.println("==============公告栏开始==================");
        System.out.println("当前排队人数：" + this.queue.size());
        // queue.offer(customer);
        try
        {
            queue.put(customer);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("[" + customer.getQueuingNumber() + "]" + "挂号成功！" + "业务类型是：" + customer.getBusinessType()
                .getBusinessName());
        System.out.println("##############公告栏结束##################");
        System.out.println();
        this.notifyAll();
    }

    public synchronized BlockingQueue<Customer> getQueue()
    {
        while (this.queue.isEmpty())
        {
            System.err.println("当前排队人数为0，柜台[" + Thread.currentThread().getName() + "]处于空闲状态！");
            try
            {
                this.wait();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }


        return this.queue;
    }


}
