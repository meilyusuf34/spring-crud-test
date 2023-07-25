package com.yusuf.agit.repositories;

import com.yusuf.agit.dto.BookDto;
import com.yusuf.agit.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    Book findByBookId(String bookId);

    @Query(value = "select new com.yusuf.agit.dto.BookDto(b.bookId, b.judul , " +
            "b.pengarang, b.penerbit , b.tanggalTerbit , b.tebalBuku, " +
            "sb.status , sb.peminjam , sb.tanggalPinjam, sb.tanggalKembali) " +
            "from Book b " +
            "left join StatusBuku sb on b.bookId = sb.bookId " +
            "where sb.status = :status or :status is null")
    List<BookDto> getAllData(@Param("status") Integer status);

    @Query(value = "SELECT nextval('book_id_seq')", nativeQuery = true)
    Long getNextBookIdSequenceValue();
     void deleteByBookId(String bookId);

    @Query(value = "SELECT CURRENT_TIMESTAMP", nativeQuery = true)
    String dBServerTime();

}
