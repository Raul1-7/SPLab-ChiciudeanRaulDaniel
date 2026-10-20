package org.info.splab.services;

import org.info.splab.models.Book;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class BooksService {
    private final Map<String, Book> books = new ConcurrentHashMap<>();

    public BooksService() {
        // Câteva date de probă
        books.put("1", new Book("1", "Design Patterns", "Erich Gamma", "ISBN-1111"));
        books.put("2", new Book("2", "Clean Code", "Robert C. Martin", "ISBN-2222"));
    }

    public List<Book> getAll() {
        return new ArrayList<>(books.values());
    }

    public Optional<Book> getById(String id) {
        return Optional.ofNullable(books.get(id));
    }

    public Book create(Book book) {
        if (book.getId() == null || book.getId().isEmpty()) {
            book.setId(UUID.randomUUID().toString());
        }
        // Simulare apel extern pentru ISBN cu întârziere
        try {
            Thread.sleep(2000); // simulare SLA serviciu extern ISBN
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        if (book.getIsbn() == null || book.getIsbn().isEmpty()) {
            book.setIsbn("ISBN-" + UUID.randomUUID().toString().substring(0, 8));
        }
        books.put(book.getId(), book);
        return book;
    }

    public Book update(String id, Book book) {
        book.setId(id);
        books.put(id, book);
        return book;
    }

    public boolean delete(String id) {
        return books.remove(id) != null;
    }
}
