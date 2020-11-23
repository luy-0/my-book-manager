package com.example.mybookmanager.repository;

import com.example.mybookmanager.entity.BookEntity;
import com.example.mybookmanager.entity.BookItemEntity;
import com.example.mybookmanager.entity.BookType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<BookEntity,Long> {
    List<BookEntity> findAllByBookId(long id);
    List<BookEntity> findAllByBookIsbn(String isbn);
    List<BookEntity> findAllByBookName(String name);
    List<BookEntity> findAllByBookType(String name);
    List<BookEntity> findAllByBookAuthor(String author);

}
