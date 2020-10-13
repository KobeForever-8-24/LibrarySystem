package com.example.kevinzhou.demo.service;

import com.example.kevinzhou.demo.constant.Book;
import com.example.kevinzhou.demo.constant.BookList;
import com.example.kevinzhou.demo.constant.BorrowedList;
import com.example.kevinzhou.demo.model.ResetPsdRequest;
import com.example.kevinzhou.demo.model.ResponseBase;
import com.example.kevinzhou.demo.user.User;
import com.example.kevinzhou.demo.user.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//@Component
@Service
public class UserService {

    @Autowired
    private BookService bookService;

    public String getUserIdByToken(String token){
        String userId = null;
        if(StringUtils.isEmpty(token)){
            System.out.println("用户的token值不可为空");
        }
        for(User user:UserList.list){
            if(user.getToken().equals(token)){
                userId = user.getUserId();
            }
        }
        if (userId == null){
            System.out.println("UserId is null");
        }
        return userId;
    }

    public int getNumOfBorrowed(String token){
        int count=0;
        for(Book book: BorrowedList.borrowedList){
            if(book.getUserId().equals(token)){
                count++;
            }
        }
        return count;
    }


    public boolean register(@RequestBody User user){
        if(!StringUtils.isEmpty(user.getUser()) || !StringUtils.isEmpty(user.getPhone())){
            for(User user1:UserList.list){
                if(user.getUser().equals(user1.getUser())){
                    System.out.println("用户名已存在请重新输入");
                    return false;
                }
            }
            user.setUserId(String.valueOf(UserList.list.size()+1));
            user.setToken(UUID.randomUUID().toString());
            user.setPermission("user");
        }

        UserList.list.add(user);
        return true;
    }

    public boolean updateUserPermission(String userId,String newPermission){
        for(User user:UserList.list) {
            if (user.getUserId().equals(userId)) {
                if (StringUtils.isEmpty(user.getUser())) {
                    return false;
                }
                if (StringUtils.isEmpty(user.getPermission())) {
                    return false;
                }
                if (StringUtils.isEmpty(user.getToken())) {
                    return false;
                }
                user.setPermission(newPermission);

            }
        }
        return true;
    }

    public boolean login(@RequestParam String userName, @RequestParam String userPsd) {

        for (User user : UserList.list) {
            if (!StringUtils.isEmpty(userName) && userName.equals(user.user) && !StringUtils.isEmpty(userPsd) && userPsd.equals(user.psd)) {
                String token = UUID.randomUUID().toString();
                user.setToken(token);
                return true;
            }
        }
        return false;
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

    public boolean reset(@RequestBody ResetPsdRequest resetPsdRequest){
        User user=new User();
        if(!StringUtils.isEmpty(resetPsdRequest.getUserName()) && resetPsdRequest.getUserName().equals(user.user) && !StringUtils.isEmpty(resetPsdRequest.getUserPsd()) && resetPsdRequest.getUserPsd().equals(user.psd)){
            user.setPsd(resetPsdRequest.getUserNewPsd());
            return true;
        }
        return false;
    }

    public boolean delete(@RequestParam String token){
        for(User user:UserList.list){
            if(user.getToken().equals(token)){
                UserList.list.remove(user);
                return true;
            }
        }
        return false;
    }
}
