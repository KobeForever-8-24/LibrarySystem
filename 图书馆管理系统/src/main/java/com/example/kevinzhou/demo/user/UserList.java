package com.example.kevinzhou.demo.user;

import com.example.kevinzhou.demo.constant.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserList {
    public static List<User> list=new ArrayList<User>();
    static  {
        list.add(new User("1","Jack","123456","15978112345", UUID.randomUUID().toString(),"admin",5));
        list.add(new User("2","Joe","654321","15978154321", UUID.randomUUID().toString(),"visitor",6));
        list.add(new User("3","Kevin","234567","15978123456", UUID.randomUUID().toString(),"seniorAdmin",7));
        list.add(new User("4","Philip","765432","15978165432", UUID.randomUUID().toString(),"user",8));
        list.add(new User("5","Bob","345678","15978134567", UUID.randomUUID().toString(),"user",9));
        list.add(new User("6","Jimmy","876543","15978176543", UUID.randomUUID().toString(),"admin",10));
    }
}
