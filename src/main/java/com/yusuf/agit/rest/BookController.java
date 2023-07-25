package com.yusuf.agit.rest;

import com.yusuf.agit.dto.BookDto;
import com.yusuf.agit.entities.Book;
import com.yusuf.agit.entities.StatusBuku;
import com.yusuf.agit.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@Slf4j
public class BookController {

    @Autowired
    BookService bookService;


    @GetMapping(value = "/getData")
    public ResponseEntity<List<BookDto>> getData(@RequestParam(value = "status" , required = false) Integer status) {
        return new ResponseEntity<>(bookService.getAllData(status), HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<BookDto> register(@RequestBody BookDto bookDto) {
        bookDto = bookService.save(bookDto);
        return new ResponseEntity<>(bookDto, HttpStatus.CREATED);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Object> update(@RequestBody Book book) {
        return bookService.update(book);
    }

    @PostMapping(value = "/updateStatusBuku")
    public ResponseEntity<Object> updateStatusBuku(@RequestBody StatusBuku statusBuku) {
        return bookService.updateStatusBuku(statusBuku);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Object> delete(@RequestParam String bookId) {
        try {
           return bookService.deleteBook(bookId);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>("Error Delete Buku : " + e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
