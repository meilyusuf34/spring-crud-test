# SPRING-CRUD-TEST

## Preconfig

Untuk Menjalankan aplikasi ini dibutuhkan sebagai berikut :
- Java Development Kit (JDK) 8 
- Apache Maven
- PostgreSQL

  ### Step 1. Execute Query DDL

  jalankan Postgresql query ddl di folder /assets/import.sql

    ### Step 2. Configure Database
  
  SPRING-CRUD-TEST ini connection memerlukan database postgres, pastikan untuk mengonfigurasi properti koneksi database di berkas application.properties
  sesuaikan  host , database , schema , username dan password dengan postgres yang sudah tersedia.

  ### Step 3. Build and RUN  

Build Spring Boot project dengan Maven : 

```bash
  mvn package
```
Run Spring Boot Project dengan Maven :

```bash
  mvn spring-boot:run
```
atau atau Spring Boot Project dengan Java -jar command :
```bash
  java -jar target/spring-simple-crud-test-0.0.1-SNAPSHOT.jar
```
Aplikasi akan berjalan, dan  bisa mengaksesnya dengan alamat http://localhost:8081/. dan pastikan untuk cek api health check untuk memastikan
aplikasi sudah berjalan dengan normal dengan hit http://localhost:8081/health/check-db.

dan bisa cek collection API di file /assets/test agit.postman_collection dan environment nya local.postman_environment
  


