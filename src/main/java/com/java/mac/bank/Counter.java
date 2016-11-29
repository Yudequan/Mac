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

    public Counter()
    {
        
    }

    public Counter(Bank bank)
    {
        this.bank = bank;
    }

    public void run()
    {
        this.busniessHistory.add(this.bank.business());
    }
}
