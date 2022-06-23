package com.bayzat.bayztracker.common;

public class ApiConstants {
    public static final String BASE_URL = "/api/v1";
    public static final String BASE_CURRENCY_URL = BASE_URL + "/currency";
    public static final String BASE_USER_URL = BASE_URL + "/user";
    public static final String BASE_ALERT_URL = BASE_URL + "/alert";

    public static final String ADD_CURRENCY = "/add";
    public static final String DELETE_CURRENCY = "/delete/{currency-id}";
    public static final String ADD_ADMIN = "/add/admin";
    public static final String ADD_USER = "/add/user";
    public static final String ADD_ALERT = "/add";
    public static final String UPDATE_ALERT = "/update/{alert-id}";
    public static final String DELETE_ALERT = "/delete/{alert-id}";
    public static final String CANCEL_ALERT = "/cancel/{alert-id}";
}
