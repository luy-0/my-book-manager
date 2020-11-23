package com.example.mybookmanager.service;

import com.example.mybookmanager.dto.BookItemInAccountGetDTO;
import com.example.mybookmanager.entity.ReaderEntity;
import com.example.mybookmanager.error.CustomException;

import java.util.List;
import java.util.concurrent.CancellationException;

public interface ReaderService {
    List<BookItemInAccountGetDTO> findAllBookItemInAccount(long readerId);
    ReaderEntity addReader(ReaderEntity readerEntity) throws CustomException;

}
