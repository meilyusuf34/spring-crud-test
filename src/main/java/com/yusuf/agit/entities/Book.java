package com.yusuf.agit.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="book")
public class Book {

    @Id
    @Column(name="book_id")
    private String bookId;
    @Column(name="judul")
    private String judul;
    @Column(name="pengarang")
    private String pengarang;
    @Column(name="penerbit")
    private String penerbit;
    @Column(name="tanggal_terbit")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Jakarta")
    private Date tanggalTerbit;
    @Column(name="tebal_buku")
    private String tebalBuku;

}
