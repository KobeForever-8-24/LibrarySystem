package com.example.kevinzhou.demo.Component;

import com.example.kevinzhou.demo.constant.PermissionList;
import com.example.kevinzhou.demo.service.UserService;
import com.example.kevinzhou.demo.user.User;
import com.example.kevinzhou.demo.user.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PermissionFilter {

    public boolean checkStatus(String token, List<String> permissionList){
        for(User user:UserList.list){
            if(user.getToken().equals(token)){
                return permissionList.contains(user.getPermission());
            }
        }
        return false;
    }

}
