package org.info.splab.commands;

import org.info.splab.models.Book;
import org.info.splab.services.BooksService;

public class CreateBookCommand implements Command<Book> {
    private final BooksService booksService;
    private final Book book;

    public CreateBookCommand(BooksService booksService, Book book) {
        this.booksService = booksService;
        this.book = book;
    }

    @Override
    public Book execute() {
        return booksService.create(book);
    }
}
