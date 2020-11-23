package com.example.mybookmanager.dto;

import com.example.mybookmanager.entity.BookEntity;
import com.example.mybookmanager.entity.BookItemEntity;

import java.util.ArrayList;
import java.util.List;

public class BookItemGetDTO {
    private long bookItemId;
    private boolean isLoad;
    private BookGetDTO parentBook;

    public static BookItemGetDTO fromEntity(BookItemEntity bookItemEntity){
        BookItemGetDTO bookItemGetDTO = new BookItemGetDTO();

        bookItemGetDTO.setBookItemId(bookItemEntity.getBookItemId());
        bookItemGetDTO.setLoad(bookItemEntity.isLoad());
        bookItemGetDTO.setParentBook(BookGetDTO.fromEntity(bookItemEntity.getParentBook()));
        return bookItemGetDTO;
    }

    public static List<BookItemGetDTO> fromEntityList(List<BookItemEntity> bookItemEntityList) {
        List<BookItemGetDTO> bookItemGetDTOList = new ArrayList<>();
        for (BookItemEntity iter : bookItemEntityList
        ) {
            bookItemGetDTOList.add(fromEntity(iter));
        }
        return bookItemGetDTOList;
    }

    public long getBookItemId() {
        return bookItemId;
    }

    public void setBookItemId(long bookItemId) {
        this.bookItemId = bookItemId;
    }

    public boolean isLoad() {
        return isLoad;
    }

    public void setLoad(boolean load) {
        isLoad = load;
    }

    public void setParentBook(BookGetDTO parentBook) {
        this.parentBook = parentBook;
    }

    public BookGetDTO getParentBook() {
        return parentBook;
    }
}
