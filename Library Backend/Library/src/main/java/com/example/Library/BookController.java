package com.example.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add/{name}/{author}/{pages}/{price}")
    public Book addBook(@PathVariable("name") String name,@PathVariable("author") String author, @PathVariable("pages") int pages,@PathVariable("price") int price){
        Book book = new Book(name,author,pages,price);
        try {
            Book addedBook = bookService.addBook(book);
            return addedBook;
        }
        catch (Exception exception){
            return null;
        }
    }

    @PutMapping("/update")
    public Book updateBook(@PathVariable("name") String name,@PathVariable("author") String author, @PathVariable("pages") int pages,@PathVariable("price") int price){
        Book book = new Book(name,author,pages,price);
        try {
            Book updatedBook = bookService.updateBook(book);
            return updatedBook;
        }
        catch (Exception exception){
            return null;
        }
    }

    @GetMapping("/get/{name}")
    public Book getBook(@PathVariable("name") String name){
        try{
            Book foundBook = bookService.getBook(name);
            return foundBook;
        }
        catch (Exception exception){
            return null;
        }
    }

    @DeleteMapping("/delete/{name}")
    public Book deleteBook(@PathVariable("name") String name){
        try {
            Book deletedBook = bookService.deleteBook(name);
            return deletedBook;
        }
        catch (Exception exception){
            return null;
        }
    }
}
