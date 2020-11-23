package com.example.mybookmanager.utils;

//import com.example.mybookmanager.repository.AdminRepository;
import com.example.mybookmanager.repository.BookItemRepository;
import com.example.mybookmanager.repository.BookRepository;
import com.example.mybookmanager.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryUtils {
//    private static AdminRepository adminRepository;
    private static BookItemRepository bookItemRepository;
    private static BookRepository bookRepository;
    private static ReaderRepository readerRepository;

    @Autowired
    public RepositoryUtils( BookItemRepository bookItemRepository, BookRepository bookRepository, ReaderRepository readerRepository) {
//        RepositoryUtils.adminRepository = adminRepository;
        RepositoryUtils.bookItemRepository = bookItemRepository;
        RepositoryUtils.bookRepository = bookRepository;
        RepositoryUtils.readerRepository = readerRepository;
    }

//    public static AdminRepository getAdminRepository() {
//        return adminRepository;
//    }

    public static BookItemRepository getBookItemRepository() {
        return bookItemRepository;
    }

    public static BookRepository getBookRepository() {
        return bookRepository;
    }

    public static ReaderRepository getReaderRepository() {
        return readerRepository;
    }
}
