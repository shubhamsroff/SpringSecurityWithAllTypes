package com.flux.flux_ex.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.flux.flux_ex.Entity.Book;
import com.flux.flux_ex.Service.BookService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {
   
    @Autowired
    private BookService bookService;

    @PostMapping
    public Mono<Book> createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @GetMapping("/{id}")
    public Mono<Book> findById(@PathVariable int id) {
        return bookService.findById(id);
    }
    @GetMapping
    public Flux<Book>  findAll() throws InterruptedException{
        return bookService.findAll();
    }

    @PutMapping("/{id}")
    public Mono<Book> updateData(@RequestBody Book book, @PathVariable int id){
        return bookService.update(book, id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable int id){
        return bookService.deleteById(id);
    }
}
