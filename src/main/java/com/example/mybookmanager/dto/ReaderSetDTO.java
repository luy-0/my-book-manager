package com.example.mybookmanager.dto;

import com.example.mybookmanager.entity.BookItemEntity;
import com.example.mybookmanager.entity.ReaderEntity;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class ReaderSetDTO {
    private long readerId;
    private String readerName;
    private String readerPassword;

    public static ReaderEntity toEntity(ReaderSetDTO readerSetDTO){
        ReaderEntity readerEntity = new ReaderEntity();
        readerEntity.setReaderId(readerSetDTO.getReaderId());
        readerEntity.setReaderName(readerSetDTO.getReaderName());
        readerEntity.setReaderPassword(readerSetDTO.getReaderPassword());

        return readerEntity;
    }

    public long getReaderId() {
        return readerId;
    }

    public void setReaderId(long readerId) {
        this.readerId = readerId;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getReaderPassword() {
        return readerPassword;
    }

    public void setReaderPassword(String readerPassword) {
        this.readerPassword = readerPassword;
    }
}
