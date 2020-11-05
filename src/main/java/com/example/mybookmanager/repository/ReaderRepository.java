package com.example.mybookmanager.repository;

import com.example.mybookmanager.entity.ReaderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<ReaderEntity,long> {
}
