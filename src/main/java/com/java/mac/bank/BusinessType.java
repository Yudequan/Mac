package com.java.mac.bank;

/**
 * Created by yudequan on 16/11/29.
 */
public enum BusinessType
{
    OPEN_CARD(15 * 1000, "开户"),

    SAVE_MONEY(5 * 1000, "存款"),

    TRANSFER_MONEY(10 * 1000, "转账"),

    WITHDRAW_MONEY(5 * 1000, "取款");

    int timeConsuming;

    String businessName;

    public int getTimeConsuming()
    {
        return this.timeConsuming;
    }

    public String getBusinessName()
    {
        return businessName;
    }

    BusinessType(int timeConsuming, String businessName)
    {
        this.timeConsuming = timeConsuming;
        this.businessName = businessName;
    }


}
