package com.example.mybookmanager.controller;


import com.example.mybookmanager.dto.ReaderGetDTO;
import com.example.mybookmanager.dto.ReaderSetDTO;
import com.example.mybookmanager.entity.ReaderEntity;
import com.example.mybookmanager.error.CustomException;
import com.example.mybookmanager.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reader")
public class ReaderController {
    @Autowired
    private final ReaderRepository readerRepository;

    public ReaderController(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }


    @GetMapping("/all")
    public @ResponseBody
    Iterable<ReaderEntity> getAllBooks() {
        return readerRepository.findAll();
    }

    @PostMapping("/addReader")
    public ReaderGetDTO addReader(@RequestBody ReaderSetDTO readerSetDTO) throws CustomException {
        return null;
    }

}
