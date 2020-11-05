package com.example.mybookmanager.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", unique = true)
    //图书编号
    private long bookId;

    //图书ISBN编码
    private String bookIsbn;

    //分类
    private BookType bookType;

    //图书作者
    private String bookAuthor;

    //图书简介
    private String bookDescription;

    //馆藏量
    private Integer bookTotalNum;

    //已借出
    private Integer bookInLoadNum;

    //单册
    @OneToMany(mappedBy = "bookEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<BookItemEntity> bookItemEntities;

    public BookEntity() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookEntity that = (BookEntity) o;

        if (bookId != that.bookId) return false;
        if (bookInLoadNum != that.bookInLoadNum) return false;
        if (bookIsbn != null ? !bookIsbn.equals(that.bookIsbn) : that.bookIsbn != null) return false;
        if (bookAuthor != null ? !bookAuthor.equals(that.bookAuthor) : that.bookAuthor != null) return false;
        if (bookDescription != null ? !bookDescription.equals(that.bookDescription) : that.bookDescription != null)
            return false;
        if (bootTotalNum != null ? !bootTotalNum.equals(that.bootTotalNum) : that.bootTotalNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (bookId ^ (bookId >>> 32));
        result = 31 * result + (bookIsbn != null ? bookIsbn.hashCode() : 0);
        result = 31 * result + (bookAuthor != null ? bookAuthor.hashCode() : 0);
        result = 31 * result + (bookDescription != null ? bookDescription.hashCode() : 0);
        result = 31 * result + (bootTotalNum != null ? bootTotalNum.hashCode() : 0);
        result = 31 * result + bookInLoadNum;
        return result;
    }
}
