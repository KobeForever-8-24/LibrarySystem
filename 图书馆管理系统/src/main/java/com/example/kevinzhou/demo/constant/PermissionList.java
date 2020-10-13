package com.example.kevinzhou.demo.constant;

import java.util.ArrayList;
import java.util.List;

public class PermissionList {

     public static List<String> permissionList=new ArrayList<String>();

     public static final String ADMIN = "admin";
     public static final String SENIORADMIN = "seniorAdmin";
     public static final String USER = "user";
     public static final String VISITOR = "visitor";

    static {
         permissionList.add("seniorAdmin");
         permissionList.add("admin");
         permissionList.add("user");
         permissionList.add("visitor");
     }
}
