package com.example.mybookmanager.dto;

import com.example.mybookmanager.entity.BookEntity;
import com.example.mybookmanager.entity.BookType;

import java.util.ArrayList;
import java.util.List;

public class BookGetDTO {
    private long bookId;

    private String bookName;
    private String bookIsbn;
    private BookType bookType;
    private String bookAuthor;
    private String bookDescription;
    private String bookImgUrl;

    private Integer bookTotalNum;
    private Integer bookInLoadNum;

    public static BookGetDTO fromEntity(BookEntity bookEntity) {
        BookGetDTO bookGetDTO = new BookGetDTO();

        bookGetDTO.setBookId(bookEntity.getBookId());
        bookGetDTO.setBookName(bookEntity.getBookName());
        bookGetDTO.setBookIsbn(bookEntity.getBookIsbn());
        bookGetDTO.setBookType(bookEntity.getBookType());
        bookGetDTO.setBookAuthor(bookEntity.getBookAuthor());
        bookGetDTO.setBookDescription(bookEntity.getBookDescription());
        bookGetDTO.setBookImgUrl(bookEntity.getBookImgUrl());
        bookGetDTO.setBookTotalNum(bookEntity.getBookTotalNum());
        bookGetDTO.setBookInLoadNum(bookEntity.getBookInLoadNum());
        return bookGetDTO;
    }

    public static List<BookGetDTO> fromEntityList(List<BookEntity> bookEntityList) {
        List<BookGetDTO> bookGetDTOList = new ArrayList<>();
        for (BookEntity iter : bookEntityList
        ) {
            bookGetDTOList.add(fromEntity(iter));
        }
        return bookGetDTOList;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getBookImgUrl() {
        return bookImgUrl;
    }

    public void setBookImgUrl(String bookImgUrl) {
        this.bookImgUrl = bookImgUrl;
    }

    public Integer getBookTotalNum() {
        return bookTotalNum;
    }

    public void setBookTotalNum(Integer bookTotalNum) {
        this.bookTotalNum = bookTotalNum;
    }

    public Integer getBookInLoadNum() {
        return bookInLoadNum;
    }

    public void setBookInLoadNum(Integer bookInLoadNum) {
        this.bookInLoadNum = bookInLoadNum;
    }
}
