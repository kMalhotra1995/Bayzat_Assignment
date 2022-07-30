package com.curr.Currencytracker.enums;

public enum UnsupportedCurrency {
    ETH, LTC, ZKN, MRD, LPR, GBZ;

    public static UnsupportedCurrency findByName(String name) {
        UnsupportedCurrency result = null;
        for (UnsupportedCurrency currency : values()) {
            if (currency.name().equalsIgnoreCase(name)) {
                result = currency;
                break;
            }
        }
        return result;
    }
}
