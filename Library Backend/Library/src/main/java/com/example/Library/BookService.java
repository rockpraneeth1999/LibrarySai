package com.example.Library;

import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service
public class BookService {

    HashMap<String,Book> books = new HashMap<>();

    public Book addBook(Book book) {
        String name = book.getName();
        if(books.containsKey(name))
            throw new BookException("Book already exists");

        books.put(name,book);
        return books.get(name);
    }

    public Book updateBook(Book book) {
        String name = book.getName();
        if(!books.containsKey(name))
            throw new BookException("Book does not exists");

        books.put(name,book);
        return books.get(name);
    }

    public Book getBook(String name) {
        if(!books.containsKey(name))
            throw new BookException("Book does not exists");

        return books.get(name);
    }

    public Book deleteBook(String name) {
        if(!books.containsKey(name))
            throw new BookException("Book does not exists");

        Book book = books.get(name);
        books.remove(name);
        return book;
    }
}
