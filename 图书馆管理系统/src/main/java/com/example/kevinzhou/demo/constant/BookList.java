package com.example.kevinzhou.demo.constant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class BookList {

    public static List<Book> list=new ArrayList<Book>();

    static  {
        list.add(new Book("1","三国演义","罗贯中",50,"古典名著","脑残出版社",false, UUID.randomUUID().toString()));
        list.add(new Book("2","水浒传","施耐庵",65,"古典名著","蠢蛋出版社",false,UUID.randomUUID().toString()));
        list.add(new Book("3","红楼梦","曹雪芹",75,"古典名著","智障出版社",false,UUID.randomUUID().toString()));
        list.add(new Book("4","西游记","吴承恩",100,"古典名著","蠢驴出版社",false,UUID.randomUUID().toString()));
    }

}
