package com.example.kevinzhou.demo.constant;

public class Book {

    private String bookId;
    private String name;
    private String author;
    private double price;
    private String type;
    private String publishing;
    private boolean isBorrow;
    private String userId;

    public Book(String bookId, String name, String author, double price, String type, String publishing, boolean isBorrow, String userId) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
        this.publishing = publishing;
        this.isBorrow = isBorrow;
        this.userId = userId;
    }

    public Book(){

    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public boolean isBorrow() {
        return isBorrow;
    }

    public void setBorrow(boolean borrow) {
        isBorrow = borrow;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "书本id： '" + bookId + '\'' +
                ", 书名： '" + name + '\'' +
                ", 作者： '" + author + '\'' +
                ", 价格： '" + price +
                ", 书本类型：'" + type + '\'' +
                ", 出版社： '" + publishing + '\'' +
                ", 是否借出： " + isBorrow;

    }
}

