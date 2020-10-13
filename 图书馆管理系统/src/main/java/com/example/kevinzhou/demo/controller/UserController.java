package com.example.kevinzhou.demo.controller;

import com.example.kevinzhou.demo.Component.PermissionFilter;
import com.example.kevinzhou.demo.constant.PermissionList;
import com.example.kevinzhou.demo.model.ResetPsdRequest;
import com.example.kevinzhou.demo.model.ResponseBase;
import com.example.kevinzhou.demo.service.UserService;
import com.example.kevinzhou.demo.user.User;
import com.example.kevinzhou.demo.user.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private PermissionFilter perFilter;

    @PostMapping("register")
    public Object register(@RequestBody User user){
       boolean flag=userService.register(user);
        if(flag){
            return ResponseBase.success();
        }
        return ResponseBase.error(507,"用户注册失败");
    }

    @GetMapping("login")
    public Object login(@RequestParam String userName,@RequestParam String userPsd){
        boolean flag=userService.login(userName,userPsd);
        if(flag){
            return ResponseBase.success();
        }
        return ResponseBase.error(208,"用户登陆失败");
    }

    /*@GetMapping("reset/psd")
    public Object test1(@RequestParam String userName,@RequestParam String psd,@RequestParam String newPsd){
        User user=new User();
        if(!StringUtils.isEmpty(userName) && userName.equals(user.user) && !StringUtils.isEmpty(psd) && psd.equals(user.psd)){
            user.setPsd(newPsd);
            return ResponseBase.success();
        }
        return ResponseBase.error(301,"重置密码失败");
    }*/

    @PostMapping("reset/psd")
    public Object reset(@RequestBody ResetPsdRequest resetPsdRequest){
        boolean flag=userService.reset(resetPsdRequest);
        if(flag){
            return ResponseBase.success();
        }
        return ResponseBase.error(307,"密码更改失败");
    }

    @GetMapping("delete")//@RequestParam String userId token是当前用户，先判断token对应的用户的权限
    public Object delete(@RequestParam String token){
        //todo 判断权限
        perFilter.checkStatus(token, Arrays.asList(PermissionList.ADMIN,PermissionList.SENIORADMIN));
        boolean flag=userService.delete(token);
        if(flag){
            return ResponseBase.success();
        }
        return ResponseBase.error(303,"用户删除失败");

    }

    @GetMapping("getNumOfBorrowed")
    public Object getNumOfBorrowed(@RequestParam String token){
        int number= userService.getNumOfBorrowed(token);
        for(User user:UserList.list){
            if(user.getToken().equals(token)){
                user.setBorrowCount(number);
            }
        }
        return ResponseBase.success(number);
    }

    @GetMapping("returnAllUsers")
    public Object returnAllUsers(){
        return ResponseBase.success(UserList.list);

    }

    @GetMapping("updateUserPermission")
    public Object updateUserPermission(@RequestParam String userId, @RequestParam String newPermission){

        for(User user:UserList.list){
            if(user.getUserId().equals(userId)){
                perFilter.checkStatus(user.getToken(), Arrays.asList(PermissionList.ADMIN,PermissionList.SENIORADMIN));
            }
        }

        boolean flag=userService.updateUserPermission(userId,newPermission);
        if(flag)
            return ResponseBase.success();
        return ResponseBase.error(809,"权限更新失败");

    }





}
