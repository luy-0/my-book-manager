package com.example.mybookmanager.service;

import com.example.mybookmanager.dto.BookItemInAccountGetDTO;
import com.example.mybookmanager.entity.ReaderEntity;
import com.example.mybookmanager.error.CustomException;
import com.example.mybookmanager.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Autowired
    private ReaderRepository readerRepository;

    @Override
    public List<BookItemInAccountGetDTO> findAllBookItemInAccount(long readerId) {
        return null;
    }

    @Override
    public ReaderEntity addReader(ReaderEntity readerEntity) throws CustomException{
        if(readerRepository.existsById(readerEntity.getReaderId())){
            throw new CustomException(HttpStatus.NOT_FOUND,"Reader Has Existed");
        }
        readerRepository.saveAndFlush(readerEntity);
        return readerRepository.findById(readerEntity.getReaderId()).get();
    }
}
