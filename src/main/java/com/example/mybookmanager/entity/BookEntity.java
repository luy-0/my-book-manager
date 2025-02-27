package com.example.mybookmanager.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id",unique = true)
    //图书编号
    private long bookId;

    @OneToMany(mappedBy = "parentBook", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<BookItemEntity> bookItemEntities;

    private String bookName;
    private String bookIsbn;
    private BookType bookType;
    private String bookAuthor;

    private String bookDescription;
    private String bookImgUrl;
    private Integer bookTotalNum;
    private Integer bookInLoadNum;

    public long getBookId() {
        return bookId;
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

    public Set<BookItemEntity> getBookItemEntities() {
        return bookItemEntities;
    }

    public void setBookItemEntities(Set<BookItemEntity> bookItemEntities) {
        this.bookItemEntities = bookItemEntities;
    }


}
