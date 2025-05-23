package com.flux.flux_ex.Repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.flux.flux_ex.Entity.Book;

@Repository
public interface BookRepository extends R2dbcRepository<Book,Integer>  {
    
}
