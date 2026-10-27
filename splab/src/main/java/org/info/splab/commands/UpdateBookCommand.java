package org.info.splab.commands;

import org.info.splab.models.Book;
import org.info.splab.services.BooksService;

public class UpdateBookCommand implements Command<Book> {
    private final BooksService booksService;
    private final Long id;
    private final Book book;

    public UpdateBookCommand(BooksService booksService, Long id, Book book) {
        this.booksService = booksService;
        this.id = id;
        this.book = book;
    }

    @Override
    public Book execute() {
        return booksService.update(id, book);
    }
}
