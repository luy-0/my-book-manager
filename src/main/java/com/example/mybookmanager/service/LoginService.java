package com.example.mybookmanager.service;

import com.example.mybookmanager.error.CustomException;

public interface LoginService {
    boolean readerLogin(long userId,String passWord) throws CustomException;
    boolean adminLogin(long userId,String passWord) throws CustomException;
}
