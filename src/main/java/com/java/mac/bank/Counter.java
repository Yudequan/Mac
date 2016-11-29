package com.java.mac.bank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yudequan on 16/11/29.
 */
public class Counter implements Runnable
{

    private List<Customer> busniessHistory = new ArrayList<Customer>();

    private Bank bank;

    public Counter(Bank bank)
    {
        this.bank = bank;
    }

    public void run()
    {
        while (true)
        {
            this.busniessHistory.add(this.business());
        }
    }

    public Customer business()
    {
        if (bank.getQueue().isEmpty())
        {
            System.out.println("当前排队人数为0，柜台处于空闲状态！");
        }

        Customer customer = null;
        try
        {
            customer = bank.getQueue().take();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + ":" + "正在处理[" + customer.getQueuingNumber() +
                "]的[" + customer.getBusinessType().getBusinessName() + "]业务...");

        try
        {
            Thread.sleep(customer.getBusinessType().getTimeConsuming());
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":[" + customer.getQueuingNumber() + "]的[" +
                customer.getBusinessType().getBusinessName() + "]业务处理成功！");

        return customer;
    }
}
