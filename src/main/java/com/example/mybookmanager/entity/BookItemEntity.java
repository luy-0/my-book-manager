package com.example.mybookmanager.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

public class BookItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookItemId;

    @ManyToOne(targetEntity = BookEntity.class)
    private BookEntity parentBook;

    private boolean isLoad;

    private ReaderEntity bookItemLoader;

    public BookEntity getParentBook() {
        return parentBook;
    }

    public void setParentBook(BookEntity parentBook) {
        this.parentBook = parentBook;
    }

    public boolean isLoad() {
        return isLoad;
    }

    public void setLoad(boolean load) {
        isLoad = load;
    }

    public ReaderEntity getBookItemLoader() {
        return bookItemLoader;
    }

    public void setBookItemLoader(ReaderEntity bookItemLoader) {
        this.bookItemLoader = bookItemLoader;
    }
}
