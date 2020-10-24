package com.cwg.dao;

import com.cwg.pogo.Books;

import java.util.List;

public interface BookMapper {
    //增删改查

    //增加一本书
    int addBook(Books books);
    //删除一本书
    int deleteBookById(int id);
    //更新一本书
    int updateBooks(Books books);
    //查询一本书
    Books queryBookById(int id);
    //查询全部的书
    List<Books>  queryAllBook();
}
