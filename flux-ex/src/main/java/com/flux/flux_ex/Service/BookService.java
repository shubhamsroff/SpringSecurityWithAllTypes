package com.flux.flux_ex.Service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flux.flux_ex.Entity.Book;
import com.flux.flux_ex.Repository.BookRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {

        @Autowired
        private BookRepository bookRepository;

        public Mono<Book> createBook(Book book){
            return bookRepository.save(book)
            .delayElement(Duration.ofSeconds(5));
        }

        public Mono<Book> findById(int id){
            return bookRepository.findById(id).delayElement(Duration.ofSeconds(12));
        }

        public Flux<Book> findAll(){
            return bookRepository.findAll().delayElements(Duration.ofSeconds(8)).log();
        }

        public Mono<Book> update(Book newBook,int oldBookId){
            return bookRepository.findById(oldBookId)
            .flatMap(oldBook->{
                oldBook.setAuthor(newBook.getAuthor());
                oldBook.setDescription(newBook.getDescription());
                oldBook.setName(newBook.getName());
                return bookRepository.save(oldBook);
             });
        }

        public Mono<Void> deleteById(int bookId){
            return bookRepository.deleteById(bookId);
        }
}
