package com.example.kevinzhou.demo.service;

import com.example.kevinzhou.demo.Component.PermissionFilter;
import com.example.kevinzhou.demo.constant.*;
import com.example.kevinzhou.demo.user.User;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.adapter.AbstractReactiveWebInitializer;

import javax.jnlp.ClipboardService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionFilter permissionFilter;

    public boolean borrowBook(String token,String bookId){
        String userId = userService.getUserIdByToken(token);
        if(StringUtils.isEmpty(userId)){
            return false;
        }
        Book book = this.findBookById(bookId);//解偶
        if(book == null || book.isBorrow()){
            return false;
        }
        book.setUserId(userId);
        book.setBorrow(true);
        BorrowedList.borrowedList.add(book);
        return true;

    }

    public boolean returnBook(String token, String bookId){
        String userId=userService.getUserIdByToken(token);
        if(StringUtils.isEmpty(userId)){
            return false;
        }
        Book book=this.findBookById(bookId);
        if(book == null || !book.isBorrow()){
            return false;
        }
        book.setUserId("");
        book.setBorrow(false);
        BorrowedList.borrowedList.remove(book);
        ReturnedList.returnedList.add(book);
        return true;
    }


    public Book findBookById(String bookId){
        if(StringUtils.isEmpty(bookId)){
            System.out.println("输入的课本Id不可为空，请重新输入!");
        }
        int count=0;
        for(Book book: BookList.list){
            if(book.getBookId().equals(bookId)){
                count++;
   /*             System.out.println("查询成功!\n你要查询的书本信息如下："+
                        "\n"+"书本Id："+book.getBookId()+
                        "  书名："+book.getName()+
                        "  作者："+book.getAuthor()+
                        "  价格："+book.getPrice()+
                        "  书本类型："+book.getType()+
                        "  出版社："+book.getPublishing()+
                        "  是否借出： "+book.isBorrow());*/
                return book;
            }
        }
        if(count == 0) {
            System.out.println("无法通过此ID查询到书籍");
        }
        return null;
    }


    public boolean add(Book book){
        boolean flag = this.check(book);
        if(!flag){
            return false;
        }
        book.setBookId(String.valueOf(BookList.list.size()+1));
        book.setBorrow(false);
        BookList.list.add(book);
        return true;
    }

    public List<Book> listAll(){
        return BookList.list;
    }

    public List<Book> listAllBorrowed(){
        return BorrowedList.borrowedList;
    }

    public Book findBookByName(String name) {
        if (StringUtils.isEmpty(name)) {
            System.out.println("输入的书名不可为空，请重新输入！");
        }
        for (Book book : BookList.list) {
            if (book.getName().contains(name)) {
                /*System.out.println("查询成功！您成功查找到一本有关书籍,信息如下： \n");
                System.out.println("书本Id：" + book.getBookId() +
                        "  书名：" + book.getName() +
                        "  作者：" + book.getAuthor() +
                        "  价格：" + book.getPrice() +
                        "  书本类型：" + book.getType() +
                        "  出版社：" + book.getPublishing() +
                        "  是否借出： " + book.isBorrow());*/

                return book;
            }
        }
        return null;
    }

    public boolean delete(String bookId){
        boolean flag = this.check(bookId);
        //BookList.list = BookList.list.stream().filter(x ->x.getPrice() < 60).collect(Collectors.toList());
        if(flag){
            for(Book book:BookList.list){
                if(book.getBookId().equals(bookId)){
                    BookList.list.remove(book);
                    return true;
                }


            }

        }
        return false;
    }



    private boolean check(String bookId) {
        for(Book book:BookList.list){
            if(book.getBookId().equals(bookId)){
                if(StringUtils.isEmpty(book.getAuthor())){
                    return false;
                }
                if(StringUtils.isEmpty(book.getName())){
                    return false;
                }
                if(book.getPrice()==0){
                    return false;
                }
                if(StringUtils.isEmpty(book.getType())){
                    return false;
                }
                if(StringUtils.isEmpty(book.getPublishing())){
                    return false;
                }
            }

        }
        return true;
    }

    private boolean check(Book book) {
        if(StringUtils.isEmpty(book.getAuthor())){
            return false;
        }
        if(StringUtils.isEmpty(book.getName())){
            return false;
        }
        if(book.getPrice()==0){
            return false;
        }
        if(StringUtils.isEmpty(book.getType())){
            return false;
        }
        if(StringUtils.isEmpty(book.getPublishing())){
            return false;
        }
        return true;
    }


    public boolean updateBookPrice(String bookId, double price){
        boolean flag=this.check(bookId);
        if(!flag)
            return false;
        for(Book book1:BookList.list){
            if(book1.getBookId().equals(bookId)){
                book1.setPrice(price);
                System.out.println("此书籍价格已更新");
            }
        }
        return true;
    }

    public boolean updateBookStatus(String bookId, String userId, boolean isBorrow){
        boolean flag=this.check(bookId);
        if(!flag)
            return false;
        for(Book book1:BookList.list){
            if(book1.getBookId().equals(bookId)){
                book1.setUserId(userId);
                book1.setBorrow(isBorrow);
                System.out.println("此书籍信息已更新");
            }
        }
        return true;
    }

}
