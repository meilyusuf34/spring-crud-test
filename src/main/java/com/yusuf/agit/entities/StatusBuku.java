package com.yusuf.agit.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="status_buku")
public class StatusBuku {

    @Id
    @Column(name="book_id")
    private String bookId;
    @Column(name="status")
    private int status;
    @Column(name="peminjam")
    private String peminjam;
    @Column(name="tanggalPinjam")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Jakarta")
    private Date tanggalPinjam;
    @Column(name="tanggal_kembali")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Jakarta")
    private Date tanggalKembali;
}
