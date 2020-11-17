package com.stuart.resthelloworld;

import com.stuart.resthelloworld.error.BookNotFoundException;
import com.stuart.resthelloworld.error.BookUnSupportedFieldPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
import java.util.List;
import java.util.Map;

@RestController
public class BookController {
    @Autowired
    private BookRepository repository;

    // Tìm tất cả sách trong repository
    @GetMapping("/books")
    List<Book> findAll(){
        return repository.findAll();
    }

    // Thêm sách vào repository
    // return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/books")
    Book newBook(@RequestBody Book newBook){
        return repository.save(newBook);
    }

    // Tìm sách theo id
    @GetMapping("/books/{id}")
    Book findOne(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(()->new BookNotFoundException(id));
    }

    // sửa thông tin sách theo id
    @PutMapping("/books/{id}")
    Book saveOrUpdate(@RequestBody Book newBook, @PathVariable Long id){
        return repository.findById(id)
                .map(x->{
                    x.setName(newBook.getName());
                    x.setAuthor(newBook.getAuthor());
                    x.setPrice(newBook.getPrice());
                    return  repository.save(x);
                })
                .orElseGet(()->{
                    newBook.setId(id);
                    return  repository.save(newBook);
                });
    }

    //sửa thông tin author của sách theo id
    @PatchMapping("/books/{id}")
    Book patch(@RequestBody Map<String, String> update, @PathVariable Long id){
        return repository.findById(id)
                .map(x->{
                    String author = update.get("author");
                    if (!StringUtils.isEmpty(author)){
                        x.setAuthor(author);

                        // better create a custom method to update a value = :newValue where id = :id
                        return repository.save(x);
                    }else {
                        throw new BookUnSupportedFieldPatchException(update.keySet());
                    }
                })
                .orElseGet(()->{
                    throw new BookNotFoundException(id);
                });
    }

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id){
        repository.deleteById(id);
    }

}
