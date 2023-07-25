package com.yusuf.agit.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BookDto {

    private String bookId;
    private String judul;
    private String pengarang;
    private String penerbit;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Jakarta")
    private Date tanggalTerbit;
    private String tebalBuku;
    private int status;
    private String peminjam;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Jakarta")
    private Date tanggalPinjam;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Jakarta")
    private Date tanggalKembali;

    public BookDto(String bookId, String judul, String pengarang, String penerbit, Date tanggalTerbit, String tebalBuku, int status, String peminjam, Date tanggalPinjam, Date tanggalKembali) {
        this.bookId = bookId;
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.tanggalTerbit = tanggalTerbit;
        this.tebalBuku = tebalBuku;
        this.status = status;
        this.peminjam = peminjam;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
    }
}
