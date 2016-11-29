package com.java.mac.bank;

/**
 * Created by yudequan on 16/11/29.
 */
public enum BusinessType
{
    OPEN_CARD(15 * 1000),

    SAVE_MONEY(5 * 1000),

    TRANSFER_MONEY(10 * 1000);

    int timeConsuming;

    public int getTimeConsuming()
    {
        return this.timeConsuming;
    }

    BusinessType(int timeConsuming)
    {
        this.timeConsuming = timeConsuming;
    }


}
