package org.info.splab.commands;

import org.info.splab.models.Book;
import org.info.splab.services.BooksService;

import java.util.Optional;

public class GetBookByIdCommand implements Command<Optional<Book>> {
    private final BooksService booksService;
    private final String id;

    public GetBookByIdCommand(BooksService booksService, String id) {
        this.booksService = booksService;
        this.id = id;
    }

    @Override
    public Optional<Book> execute() {
        return booksService.getById(id);
    }
}
