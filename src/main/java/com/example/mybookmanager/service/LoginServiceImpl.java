package com.example.mybookmanager.service;

import com.example.mybookmanager.entity.ReaderEntity;
import com.example.mybookmanager.error.CustomException;
import com.example.mybookmanager.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

public class LoginServiceImpl implements LoginService{
    @Autowired
    ReaderRepository readerRepository;


    @Override
    public boolean readerLogin(long userId, String passWord) throws CustomException {
        ReaderEntity readerEntity = readerRepository.findById(userId).get();
        if(readerEntity==null){
            throw new CustomException(HttpStatus.NOT_FOUND,"Reader Not Exist");
        }
        if(readerEntity.getReaderPassword().equals(passWord)){
            return true;
        }
        return false;
    }

    @Override
    public boolean adminLogin(long userId, String passWord) throws CustomException {
        return false;
    }
}
