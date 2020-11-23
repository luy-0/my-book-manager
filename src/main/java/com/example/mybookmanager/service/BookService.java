package com.example.mybookmanager.service;

import com.example.mybookmanager.dto.BookGetDTO;
import com.example.mybookmanager.dto.BookItemGetDTO;
import com.example.mybookmanager.entity.BookEntity;
import com.example.mybookmanager.entity.BookItemEntity;
import com.example.mybookmanager.entity.BookType;
import com.example.mybookmanager.error.CustomException;

import java.util.List;
import java.util.Set;

public interface BookService {

    List<BookEntity> findAll();

    List<BookEntity> findBookByIsbn(String isbn);

    List<BookEntity> findBookByName(String name);

    List<BookEntity> findBookByBookId(long bookId);

    List<BookEntity> findBookByType(String type);

    List<BookEntity> findBookByAuthor(String author);

    BookEntity addNewBook(BookEntity bookEntity) throws CustomException;
}
