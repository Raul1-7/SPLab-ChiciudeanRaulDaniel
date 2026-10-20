package org.info.splab.commands;

import org.info.splab.models.Book;
import org.info.splab.services.BooksService;

import java.util.List;

public class GetAllBooksCommand implements Command<List<Book>> {
    private final BooksService booksService;

    public GetAllBooksCommand(BooksService booksService) {
        this.booksService = booksService;
    }

    @Override
    public List<Book> execute() {
        return booksService.getAll();
    }
}
