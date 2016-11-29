package com.java.mac.bank;

/**
 * Created by yudequan on 16/11/29.
 */
public class Customer implements  Runnable
{
    private int queuingNumber;

    private BusinessType businessType;

    private Bank bank;

    public Customer(int queuingNumber, BusinessType businessType, Bank bank)
    {
        this.queuingNumber = queuingNumber;
        this.businessType = businessType;
        this.bank = bank;
    }

    public int getQueuingNumber()
    {
        return queuingNumber;
    }

    public BusinessType getBusinessType()
    {
        return businessType;
    }

    public void run()
    {
        this.bank.register(this);

    }
}
