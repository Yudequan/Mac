package com.java.mac.bank;

import java.util.Random;

/**
 * Created by yudequan on 16/11/29.
 */
public class Test
{
    public static void main(String[] args)
    {


        Bank bank = new Bank();

        Thread t0 = new Thread(new Counter(bank), "柜台1");
        Thread t1 = new Thread(new Counter(bank), "柜台2");
        Thread t2 = new Thread(new Counter(bank), "柜台3");

        t0.start();
        t1.start();
        t2.start();

        Test.generateCustomer(bank);
    }

    public static void generateCustomer(Bank bank)
    {
        Thread customer;
        Random random = new Random();

        for (int i = 0; i < 500; i++)
        {
            try
            {
                Thread.sleep(2000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            int result = random.nextInt(3);

            switch (result)
            {
                case 1:
                {
                    customer = new Thread(new Customer(i, BusinessType.OPEN_CARD, bank));
                    break;
                }

                case 2:
                {
                    customer = new Thread(new Customer(i, BusinessType.SAVE_MONEY, bank));
                    break;
                }

                case 3:
                {
                    customer = new Thread(new Customer(i, BusinessType.TRANSFER_MONEY, bank));
                    break;
                }

                default:
                {
                    customer = new Thread(new Customer(i, BusinessType.WITHDRAW_MONEY, bank));
                    break;
                }
            }

            customer.start();

        }
    }
}
