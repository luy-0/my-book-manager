package com.example.mybookmanager.dto;

import com.example.mybookmanager.entity.BookEntity;
import com.example.mybookmanager.entity.BookType;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

public class BookSetDTO {

    private String bookName;
    private String bookIsbn;
    private Integer bookTotalNum;

    public static BookEntity toEntity(BookSetDTO bookSetDTO){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookName(bookSetDTO.getBookName());
        bookEntity.setBookIsbn(bookSetDTO.getBookIsbn());
        bookEntity.setBookTotalNum(bookSetDTO.getBookTotalNum());
        bookEntity.setBookInLoadNum(0);
        return bookEntity;
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



    public Integer getBookTotalNum() {
        return bookTotalNum;
    }

    public void setBookTotalNum(Integer bookTotalNum) {
        this.bookTotalNum = bookTotalNum;
    }

}
