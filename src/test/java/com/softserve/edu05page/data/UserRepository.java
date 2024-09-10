package com.softserve.edu05page.data;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class UserRepository {
    private static final String TIME_TEMPLATE = "HH_mm_ss_S";

    private UserRepository() {
    }

    public static User getDefault() {
        return getValidUser();
    }

    public static User getValidUser() {
        //String password = System.getenv().get("GREENCITY_PASSWORD");
        //return new User("tyv09754@zslsz.com", password, "QwertyY");
        return new User("tyv09754@zslsz.com", "Qwerty_1", "QwertyY");
    }

    public static User getExistUser() {
        String password = System.getenv().get("GREENCITY_PASSWORD");
        return new User("tyv09754@zslsz.com", password, "QwertyY");
    }

    public static User getNewUser() {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        String newEmail = "temp" + currentTime + "@gmail.com";
        System.out.println("newEmail = " + newEmail); // TODO Log
        return new User(newEmail, "Qwerty_1", "QwertyY");
    }
}
