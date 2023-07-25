package com.yusuf.agit.repositories;

import com.yusuf.agit.entities.Book;
import com.yusuf.agit.entities.StatusBuku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusBukuRepository extends JpaRepository<StatusBuku, String> {

    boolean existsByBookId(String bookId);

    void deleteByBookId(String bookId);
}
