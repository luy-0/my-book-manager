package com.example.mybookmanager.service;

import com.example.mybookmanager.dto.BookItemGetDTO;
import com.example.mybookmanager.entity.BookEntity;
import com.example.mybookmanager.entity.BookItemEntity;
import com.example.mybookmanager.entity.ReaderEntity;
import com.example.mybookmanager.error.CustomException;

import java.util.List;


public interface BookItemService {
    BookItemEntity returnBook(Long bookItemId)throws CustomException;

    BookItemEntity loadBook(Long bookItemId, Long readerId)throws CustomException;

    boolean isLoaded(Long bookItemId)throws CustomException;

    ReaderEntity getLoader(Long bookItemId)throws CustomException;

    BookItemEntity findById(Long bookItemId);

    List<BookItemEntity> findAll();

    List<BookItemEntity> getAllItems(Long parentBookId) throws CustomException;


    List<BookItemEntity> addNewItem(Long parentBookId,Integer addItemId)throws CustomException;

}
