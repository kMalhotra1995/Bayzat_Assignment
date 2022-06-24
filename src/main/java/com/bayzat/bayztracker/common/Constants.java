package com.bayzat.bayztracker.common;

public class Constants {
    public static final String DB_BASE_USER_USERNAME_MSG = "username should have at least 5 characters";
    public static final String CURRENCY_UNSUPPORTED_EXCEPTION = "Currency Not Supported";
    public static final String ALERT_NOT_FOUND_EXCEPTION = "Alert not found";
    public static final String NOT_AN_ADMIN_USER = "Not an admin user";
    public static final String CANCEL_NOT_DONE_EXCEPTION = "Could not cancel the alert (maybe its already triggered)";
    public static final String INVALID_ALERT_EXCEPTION = "Invalid Alert data";
    public static final String ALERT_TRIGGERED = "An alert has been triggered";
    public static final String QUERY_ALERT_TRIGGER = "SELECT * FROM Alert WHERE status=0";
}
