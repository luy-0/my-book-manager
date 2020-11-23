package com.example.mybookmanager.repository;

import com.example.mybookmanager.entity.BookItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookItemRepository extends JpaRepository<BookItemEntity,Long> {
}
