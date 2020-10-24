package com.cwg.service;

import com.cwg.dao.BookMapper;
import com.cwg.pogo.Books;

import java.util.List;

public class BookServiceImpl implements BookService{
    //业务层调用dao层，组合dao
    private BookMapper bookMapper;
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }


    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBooks(Books books) {
        return bookMapper.updateBooks(books);
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }
}
