package com.example.kevinzhou.demo.controller;

import com.example.kevinzhou.demo.constant.Book;
import com.example.kevinzhou.demo.constant.BookList;
import com.example.kevinzhou.demo.constant.BorrowedList;
import com.example.kevinzhou.demo.constant.ReturnedList;
import com.example.kevinzhou.demo.model.ResponseBase;
import com.example.kevinzhou.demo.service.BookService;
import com.example.kevinzhou.demo.user.User;
import com.example.kevinzhou.demo.user.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("add")
    public Object add(@RequestBody Book book){
        boolean flag = bookService.add(book);
        if(flag)
            return ResponseBase.success();
        return ResponseBase.error(911,"书籍添加失败");
    }

    @GetMapping("borrowBook")
    public Object borrowBook(@RequestParam String token, @RequestParam String bookId){
        //todo 判断权限
        boolean flag = bookService.borrowBook(token,bookId);
        if(flag)
            return ResponseBase.success();
        return ResponseBase.error("租借失败");

    }

    @GetMapping("returnBook")
    public Object returnBook(@RequestParam String token, @RequestParam String bookId){
        boolean flag=bookService.returnBook(token,bookId);
        if (flag)
            return ResponseBase.success();
        return ResponseBase.error("归还失败");
    }

    @GetMapping("findBookById")
    public Object findBookById(@RequestParam String bookId){
        Book book=bookService.findBookById(bookId);
        if(book!=null)
            return ResponseBase.success(book);
        return ResponseBase.error("无法通过此ID查询书籍");
    }

    @GetMapping("findBookByName")
    public Object findBookByName(@RequestParam String name){
        Book book=bookService.findBookByName(name);
        if(book!=null)
            return ResponseBase.success(book);
        return ResponseBase.error("无法通过此书名查询书籍");
    }

    @GetMapping("listAll")
    public Object listAll(){
        return ResponseBase.success(BookList.list);

    }

    @GetMapping("listAllBorrowed")
    public Object listAllBorrowed(){
        return ResponseBase.success(BorrowedList.borrowedList);
    }

    @GetMapping("listAllReturned")
    public Object listAllReturned(){
        return ResponseBase.success(ReturnedList.returnedList);
    }

    @GetMapping("delete")
    public Object delete(@RequestParam String bookId){
        boolean flag = bookService.delete(bookId);
        if(flag)
            return ResponseBase.success();
        return ResponseBase.error(811,"书籍删除失败");
    }

    @GetMapping("updateBookPrice")
    public Object updateBookPrice(@RequestParam String bookId, @RequestParam double price){
        boolean flag=bookService.updateBookPrice(bookId,price);
        if(flag)
            return ResponseBase.success();
        return ResponseBase.error(704,"书籍更新失败");
    }

    @GetMapping("updateBookStatus")
    public Object updateBookStatus(@RequestParam String bookId, @RequestParam String userId, @RequestParam boolean isBorrow){
        boolean flag=bookService.updateBookStatus(bookId,userId,isBorrow);
        if(flag)
            return ResponseBase.success();
        return ResponseBase.error(704,"书籍更新失败");
    }
}
