package com.example.mybookmanager.entity;

import com.example.mybookmanager.entity.BookEntity;
import com.example.mybookmanager.entity.ReaderEntity;

import javax.persistence.*;

@Entity
@Table(name = "bootitem")
public class BookItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_item_id", unique = true)
    private long bookItemId;
    private boolean isLoad;

    @ManyToOne(targetEntity = BookEntity.class)
    @JoinColumn(name = "parent_book_id", referencedColumnName = "book_id", foreignKey = @ForeignKey(name = "fk_item_parent"))
    private BookEntity parentBook;

    @ManyToOne(targetEntity = ReaderEntity.class)
    @JoinColumn(name = "loader_id", referencedColumnName = "reader_id", foreignKey = @ForeignKey(name = "fk_item_loader"))
    private ReaderEntity bookItemLoader;

    public long getBookItemId() {
        return bookItemId;
    }

    public void setBookItemId(long bookItemId) {
        this.bookItemId = bookItemId;
    }

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
