package com.java.mac.bank;

/**
 * Created by yudequan on 16/11/29.
 */
public class Test
{
    public static void main(String[] args)
    {
        Bank bank  = new Bank();

        Thread t = new Thread(new Counter(bank));

        Thread t1 = new Thread(new Counter(bank));

        Thread t2 = new Thread(new Counter(bank));
    }
}
