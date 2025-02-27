package com.example.mybookmanager.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "reader")
public class ReaderEntity {
    @Id
    @Column(name = "reader_id", unique = true)
    private long readerId;

    private String readerName;
    private String readerPassword;

    @OneToMany(mappedBy = "bookItemLoader", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<BookItemEntity> loadBookItemSet;

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

    public Set<BookItemEntity> getLoadBookItemSet() {
        return loadBookItemSet;
    }

    public void setLoadBookItemSet(Set<BookItemEntity> loadBookItemSet) {
        this.loadBookItemSet = loadBookItemSet;
    }
}


