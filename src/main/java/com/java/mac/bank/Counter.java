package com.java.mac.bank;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Created by yudequan on 16/11/29.
 */
public class Counter implements Runnable
{

    private static final String REPORT_FILE_PATH = "/Users/yudequan/";

    private Bank bank;

    OutputStream os;

    PrintWriter pw;

    public Counter(Bank bank)
    {
        this.bank = bank;
    }

    public void run()
    {
        String file = REPORT_FILE_PATH + Thread.currentThread().getName() + ".log";
        try
        {
            os = new FileOutputStream(file, true);
            pw = new PrintWriter(os, true);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        while (true)
        {
            pw.println(this.business());
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
