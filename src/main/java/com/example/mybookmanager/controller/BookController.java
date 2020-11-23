package com.example.mybookmanager.controller;

import com.example.mybookmanager.dto.BookGetDTO;
import com.example.mybookmanager.dto.BookSetDTO;
import com.example.mybookmanager.entity.BookEntity;
import com.example.mybookmanager.error.CustomException;
import com.example.mybookmanager.service.BookItemService;
import com.example.mybookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;
    private final BookItemService bookItemService;

    @Autowired
    public BookController(BookService bookService, BookItemService bookItemService) {
        this.bookService = bookService;
        this.bookItemService = bookItemService;
    }

    @PostMapping(path = "/addNewBook")
    public BookGetDTO addNewBook(@RequestBody BookSetDTO bookSetDTO) throws CustomException{
        BookEntity bookEntity = bookService.addNewBook(BookSetDTO.toEntity(bookSetDTO));
        bookItemService.addNewItem(bookEntity.getBookId(),bookEntity.getBookTotalNum());
        return BookGetDTO.fromEntity(bookEntity);
    }

    @GetMapping("/all")
    public @ResponseBody
    Iterable<BookGetDTO> getAllBooks() {
        return BookGetDTO.fromEntityList(bookService.findAll());
    }

    @GetMapping("/findByIsbn")
    public @ResponseBody
    Iterable<BookGetDTO> findBooksByIsbn(@RequestParam(value = "isbn") String isbn) {
        return BookGetDTO.fromEntityList(bookService.findBookByIsbn(isbn));
    }

    @GetMapping("/findByName")
    public @ResponseBody
    Iterable<BookGetDTO> findBooksByName(@RequestParam(value = "name") String name) {
        return BookGetDTO.fromEntityList(bookService.findBookByName(name));
    }

    @GetMapping("/findByID")
    public @ResponseBody
    Iterable<BookGetDTO> findBooksById(@RequestParam(value = "id") long id) {
        return BookGetDTO.fromEntityList(bookService.findBookByBookId(id));
    }

    @GetMapping("/findByType")
    public @ResponseBody
    Iterable<BookGetDTO> findBooksByType(@RequestParam(value = "type") String type) {
        return BookGetDTO.fromEntityList(bookService.findBookByType(type));
    }

    @GetMapping("/findByAuthor")
    public @ResponseBody
    Iterable<BookGetDTO> findBooksByAuthor(@RequestParam(value = "author") String author) {
        return BookGetDTO.fromEntityList(bookService.findBookByAuthor(author));
    }
}
