package ru.edu.springdata.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.edu.springdata.dto.BookDTO;
import ru.edu.springdata.dto.FiltersRequest;
import ru.edu.springdata.entity.Book;
import ru.edu.springdata.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {

    public final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.findAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findBookById(id));
    }

    @GetMapping("/getByLanguageAndCategory")
    public ResponseEntity<List<Book>> getBooksByLanguageAndCategory(@RequestBody FiltersRequest request) {
        return ResponseEntity.ok(bookService.findBookByLanguageAndCategory(request));
    }

    @PostMapping
    public ResponseEntity<Book> saveOrUpdateBook(@RequestBody BookDTO book) {
        return ResponseEntity.ok(bookService.saveOrUpdateBook(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return ResponseEntity.ok("Book deleted");
    }
}
