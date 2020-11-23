package com.example.mybookmanager.service;

import com.example.mybookmanager.dto.BookItemGetDTO;
import com.example.mybookmanager.entity.BookEntity;
import com.example.mybookmanager.entity.BookItemEntity;
import com.example.mybookmanager.entity.ReaderEntity;
import com.example.mybookmanager.error.CustomException;
import com.example.mybookmanager.repository.BookItemRepository;
import com.example.mybookmanager.utils.RepositoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class BookItemServiceImpl implements BookItemService {
    @Autowired
    private final BookItemRepository bookItemRepository;

    public BookItemServiceImpl(BookItemRepository bookItemRepository) {
        this.bookItemRepository = bookItemRepository;
    }

    @Override
    public BookItemEntity returnBook(Long bookItemId) throws CustomException {
        BookItemEntity bookItemEntity = bookItemRepository.findById(bookItemId).get();
        if (bookItemEntity == null) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Book Item No Found");
        }
        if (bookItemEntity.isLoad() == false) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Book Item is Not Loaded");
        }
        ReaderEntity readerEntity = bookItemEntity.getBookItemLoader();

        Set<BookItemEntity> loadBookItemSet = readerEntity.getLoadBookItemSet();
        loadBookItemSet.remove(bookItemEntity);
        readerEntity.setLoadBookItemSet(loadBookItemSet);
        RepositoryUtils.getReaderRepository().saveAndFlush(readerEntity);

        bookItemEntity.setLoad(false);
        bookItemEntity.setBookItemLoader(null);
        bookItemRepository.saveAndFlush(bookItemEntity);
        return bookItemRepository.findById(bookItemEntity.getBookItemId()).get();
    }

    @Override
    public BookItemEntity loadBook(Long bookItemId, Long readerId) throws CustomException {
        ReaderEntity readerEntity = RepositoryUtils.getReaderRepository().findById(readerId).get();
        if(readerEntity == null){
            throw new CustomException(HttpStatus.NOT_FOUND,"Reader No Found");
        }
        BookItemEntity bookItemEntity = bookItemRepository.findById(bookItemId).get();
        if(bookItemEntity == null){
            throw new CustomException(HttpStatus.NOT_FOUND,"BookItem No Found");
        }
        if(bookItemEntity.isLoad() == true){
            throw new CustomException(HttpStatus.NOT_FOUND,"BookItem Has Loaded");
        }

        Set<BookItemEntity> loadBookItemSet = readerEntity.getLoadBookItemSet();
        loadBookItemSet.add(bookItemEntity);
        readerEntity.setLoadBookItemSet(loadBookItemSet);
        RepositoryUtils.getReaderRepository().saveAndFlush(readerEntity);

        bookItemEntity.setLoad(true);
        bookItemEntity.setBookItemLoader(readerEntity);
        bookItemRepository.saveAndFlush(bookItemEntity);
        return bookItemRepository.findById(bookItemEntity.getBookItemId()).get();
    }

    @Override
    public boolean isLoaded(Long bookItemId) throws CustomException{
        BookItemEntity bookItemEntity = bookItemRepository.findById(bookItemId).get();
        if(bookItemEntity == null){
            throw new CustomException(HttpStatus.NOT_FOUND,"BookItem No Found");
        }
        return bookItemEntity.isLoad();
    }

    @Override
    public ReaderEntity getLoader(Long bookItemId) throws CustomException {
        BookItemEntity bookItemEntity = bookItemRepository.findById(bookItemId).get();
        if (bookItemEntity == null) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Book Item No Found");
        }
        if (bookItemEntity.isLoad() == false) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Book Item is Not Loaded");
        }
        return bookItemEntity.getBookItemLoader();
    }

    @Override
    public BookItemEntity findById(Long bookItemId) {
        BookItemEntity bookItemEntity = bookItemRepository.findById(bookItemId).get();
        return bookItemRepository.findById(bookItemId).get();
    }


    @Override
    public List<BookItemEntity> findAll() {
        return bookItemRepository.findAll();
    }

    @Override
    public List<BookItemEntity> getAllItems(Long parentBookId) throws CustomException {
        BookEntity parentBook = RepositoryUtils.getBookRepository().getOne(parentBookId);
        if(parentBook==null){
            throw new CustomException(HttpStatus.NOT_FOUND,"Book No Found");
        }

        Set<BookItemEntity> bookItemEntitySet = parentBook.getBookItemEntities();

        List<BookItemEntity> bookItemEntityList = new ArrayList<>(bookItemEntitySet);
        return bookItemEntityList;
    }

    @Override
    public List<BookItemEntity> addNewItem(Long parentBookId, Integer addItemNum) throws CustomException {
        BookEntity parentBook = RepositoryUtils.getBookRepository().findById(parentBookId).get();
        if(parentBook == null){
            throw new CustomException(HttpStatus.NOT_FOUND,"Book No Found");
        }

        List<BookItemEntity> bookItemEntityList = new ArrayList<>();
        for (int i = 0; i < addItemNum; i++) {
            BookItemEntity bookItemEntity = new BookItemEntity();
            bookItemEntity.setParentBook(parentBook);
            bookItemEntity.setLoad(false);

            bookItemRepository.saveAndFlush(bookItemEntity);
            bookItemEntityList.add(bookItemRepository.findById(bookItemEntity.getBookItemId()).get());
        }

        return bookItemEntityList;
    }
}
