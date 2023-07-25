package com.yusuf.agit.service;

import com.yusuf.agit.common.BuildResponseUtil;
import com.yusuf.agit.dto.BookDto;
import com.yusuf.agit.entities.Book;
import com.yusuf.agit.entities.StatusBuku;
import com.yusuf.agit.repositories.BookRepository;
import com.yusuf.agit.repositories.StatusBukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    StatusBukuRepository statusBukuRepository;

    public List<BookDto> getAllData(Integer status) {
        return bookRepository.getAllData(status);
    }

    public BookDto save(BookDto bookDto) {
        Book book = new Book();
        String sequenceString = "A" + String.format("%04d",bookRepository.getNextBookIdSequenceValue());
        book.setBookId(sequenceString);
        mappingBook(bookDto, book);
        Book savedBook = bookRepository.save(book);
        StatusBuku statusBuku = new StatusBuku();
        statusBuku.setBookId(savedBook.getBookId());
        statusBuku.setStatus(bookDto.getStatus());
        statusBukuRepository.save(statusBuku);
        bookDto.setBookId(savedBook.getBookId());
        return bookDto;

    }

    private void mappingBook(BookDto bookDto, Book book) {
        book.setPenerbit(bookDto.getPenerbit());
        book.setJudul(bookDto.getJudul());
        book.setPengarang(bookDto.getPengarang());
        book.setTanggalTerbit(bookDto.getTanggalTerbit());
        book.setTebalBuku(bookDto.getTebalBuku());
    }

    public ResponseEntity<Object> update(Book book) {
        Book existBook = bookRepository.findByBookId(book.getBookId());
        if(null != existBook) {
            book.setBookId(existBook.getBookId());
        } else {
            return new ResponseEntity<>(BuildResponseUtil.error("Book ID not Found."), HttpStatus.BAD_REQUEST);
        }
        book = bookRepository.save(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    public ResponseEntity<Object> updateStatusBuku(StatusBuku statusBuku) {

        if(statusBukuRepository.existsByBookId(statusBuku.getBookId())) {
            statusBuku = statusBukuRepository.save(statusBuku);
        } else {
            return new ResponseEntity<>(BuildResponseUtil.error("Book ID not Found."), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(statusBuku, HttpStatus.OK);
    }

    public ResponseEntity<Object> deleteBook(String bookId) {
        statusBukuRepository.deleteById(bookId);
        bookRepository.deleteById(bookId);
        return new ResponseEntity<>(BuildResponseUtil.success("Success delete Book "), HttpStatus.OK);
    }
}
