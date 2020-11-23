package com.example.mybookmanager.service;

import com.example.mybookmanager.dto.BookGetDTO;
import com.example.mybookmanager.dto.BookItemGetDTO;
import com.example.mybookmanager.entity.BookEntity;
import com.example.mybookmanager.entity.BookItemEntity;
import com.example.mybookmanager.entity.BookType;
import com.example.mybookmanager.error.CustomException;
import com.example.mybookmanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<BookEntity> findBookByIsbn(String isbn) {
        return bookRepository.findAllByBookIsbn(isbn);
    }

    @Override
    public List<BookEntity> findBookByName(String name) {
        return bookRepository.findAllByBookName(name);
    }

    @Override
    public List<BookEntity> findBookByBookId(long bookId) {
        return bookRepository.findAllByBookId(bookId);
    }

    @Override
    public List<BookEntity> findBookByType(String type) {
        return bookRepository.findAllByBookType(type);
    }

    @Override
    public List<BookEntity> findBookByAuthor(String author) {
        return bookRepository.findAllByBookAuthor(author);
    }


    @Override
    public BookEntity addNewBook(BookEntity bookEntity) throws CustomException {
        if(bookRepository.existsById(bookEntity.getBookId())){
            throw new CustomException(HttpStatus.NOT_FOUND,"Book Has Existed");
        }
        return bookRepository.save(bookEntity);
    }


}
