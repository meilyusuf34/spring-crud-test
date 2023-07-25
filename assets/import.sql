CREATE SCHEMA agitv1;

CREATE TABLE book (
    book_id VARCHAR(100) PRIMARY key not null,
    judul VARCHAR(255) not null,
    pengarang VARCHAR(50) NULL ,
    penerbit VARCHAR(50) null,
    tanggal_terbit Date null,
    tebal_buku VARCHAR(50) null
);

CREATE sequence book_id_seq INCREMENT BY 1 MINVALUE 1 MAXVALUE 99999999 START 1 CACHE 1 NO CYCLE;

CREATE TABLE status_buku (
    book_id VARCHAR(100) primary key not null,
    status int not null,
    peminjam VARCHAR(50) NULL ,
    tanggal_pinjam Date null,
    tanggal_kembali Date null,
    FOREIGN KEY (book_id) REFERENCES book(book_id)
);




