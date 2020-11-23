package com.example.mybookmanager.controller;

import com.example.mybookmanager.dto.BookItemGetDTO;
import com.example.mybookmanager.entity.BookEntity;
import com.example.mybookmanager.entity.BookItemEntity;
import com.example.mybookmanager.entity.ReaderEntity;
import com.example.mybookmanager.error.CustomException;
import com.example.mybookmanager.repository.BookRepository;
import com.example.mybookmanager.service.BookItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookItem")
public class BookItemController {
    private final BookItemService bookItemService;

    @Autowired
    public BookItemController(BookItemService bookItemService) {
        this.bookItemService = bookItemService;
    }

    @GetMapping("/all")
    public @ResponseBody
    List<BookItemGetDTO> getAllBookItems() {
        return BookItemGetDTO.fromEntityList(bookItemService.findAll());
    }

    @GetMapping("/findById")
    public @ResponseBody
    BookItemGetDTO getBookItemById(@RequestParam(value = "id") long id) {
        return BookItemGetDTO.fromEntity(bookItemService.findById(id));
    }

    @GetMapping("/return")
    public @ResponseBody
    BookItemGetDTO returnBook(@RequestParam(value = "bookItemId") long bookItemId) throws CustomException {
        return BookItemGetDTO.fromEntity(bookItemService.returnBook(bookItemId));
    }

    @GetMapping("/load")
    public @ResponseBody
    BookItemGetDTO loadBook(@RequestParam(value = "bookItemId") long bookItemId,
                            @RequestParam(value = "readerId") long readerId) throws CustomException {
        return BookItemGetDTO.fromEntity(bookItemService.loadBook(bookItemId, readerId));
    }

    @GetMapping("/getLoader")
    public @ResponseBody
    ReaderEntity getLoader(@RequestParam(value = "bookItem") long bookItemId) throws CustomException {
        return bookItemService.getLoader(bookItemId);
    }

    @GetMapping("addNewItem")
    public @ResponseBody
    List<BookItemGetDTO> addNewItem(@RequestParam(value = "parentBookId") long parentBookId,
                                    @RequestParam(value = "addItemNum", defaultValue = "1") int addItemNum) throws CustomException {
        return BookItemGetDTO.fromEntityList(bookItemService.addNewItem(parentBookId, addItemNum));
    }

}
