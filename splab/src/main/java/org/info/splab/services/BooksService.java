package org.info.splab.services;

import org.info.splab.models.Book;
import org.info.splab.persistence.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> getAll() {
        return booksRepository.findAll();
    }

    public Optional<Book> getById(Long id) {
        return booksRepository.findById(id);
    }

    public Book create(Book book) {
        return booksRepository.save(book);
    }

    public Book update(Long id, Book bookDetails) {
        return booksRepository.findById(id).map(book -> {
            book.setTitle(bookDetails.getTitle());
            return booksRepository.save(book);
        }).orElse(null);
    }

    public boolean delete(Long id) {
        if (booksRepository.existsById(id)) {
            booksRepository.deleteById(id);
            return true;
        }
        return false;
    }
}