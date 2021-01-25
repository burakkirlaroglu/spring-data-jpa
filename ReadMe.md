# Spring data jpa kullanarak veritabanı işlemleri

![design](src/main/resources/book_store_design.png)

Yukardaki veritabanı tasarımına uygun şekilde Entity tasarımını yapınız ve birkaç kitap, yazar, kullanıcı ve sipariş yaratınız.
JPA anotasyonlarını cascade ve fecth stratejilerini uygun şekilde kullanınız. Veritabanı olarak H2 kullanabilirsiniz.
Ayrıca kitap ismine göre ve yazar ismine göre arama, kullanıcının sipariş bilgilerini gösterme gibi temel sorgular eklenmelidir.

Odev deadline : 24.01.2021 saat 00:00

###YAPILANLAR

* İlişkiler Kuruldu
    * user, categories ve book güncellendi.
    * ManyToMany -> books & authors
    * OneToMany -> users & orders
    * ManyToMany -> orders & books
    
---
* Servisler Eklendi
    * user, categories ve book güncellendi.
    * orderService
    * bookService
    * authoService
    
---
* Repositories Eklendi
    * user, categories ve book güncellendi.
    * orderRepo
    * bookRepo
    * authorRepo
    
---
* Sorgular eklendi.
    * Tüm repolara eklendi.
    * Var olanlar güncellendi.