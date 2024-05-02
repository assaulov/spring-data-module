package ru.edu.springdata.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.edu.springdata.dto.BookDTO;
import ru.edu.springdata.dto.FiltersRequest;
import ru.edu.springdata.entity.Author;
import ru.edu.springdata.entity.Book;
import ru.edu.springdata.exceptions.BookException;
import ru.edu.springdata.repository.AuthorRepository;
import ru.edu.springdata.repository.BookRepository;
import ru.edu.springdata.repository.CategoryRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;

    @Transactional
    public Book saveOrUpdateBook(BookDTO bookDTO) {
        Book book = new Book();
        if(bookDTO.id() != null) {
            book= bookRepository.findById(bookDTO.id()).orElse(new Book());
        }
        book.setTitle(bookDTO.title());
        book.setLanguage(bookDTO.language());
        book.setActive(bookDTO.active());
        book.setCategory(categoryRepository.findById(bookDTO.categoryId()).get());
        List<Author> authors = authorRepository.findAllById((bookDTO.authorsIds()));
        book.getAuthors().addAll(authors);

        return bookRepository.save(book);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookException("Book don't found."));
    }

    public void deleteBookById(Long id) {
        Book book = findBookById(id);
        bookRepository.delete(book);
    }

    public List<Book> findBookByLanguageAndCategory(FiltersRequest filtersRequest) {
        return bookRepository.findBookByLanguageAndCategoryName(filtersRequest.language(), filtersRequest.categoryName());
    }
}
