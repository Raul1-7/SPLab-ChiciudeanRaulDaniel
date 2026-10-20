package org.info.splab.controllers;

import org.info.splab.commands.*;
import org.info.splab.models.Book;
import org.info.splab.services.BooksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;
    private final CommandExecutor commandExecutor;

    public BooksController(BooksService booksService, CommandExecutor commandExecutor) {
        this.booksService = booksService;
        this.commandExecutor = commandExecutor;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        GetAllBooksCommand command = new GetAllBooksCommand(booksService);
        List<Book> books = commandExecutor.executeSync(command);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable String id) {
        GetBookByIdCommand command = new GetBookByIdCommand(booksService, id);
        Optional<Book> book = commandExecutor.executeSync(command);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createBook(@RequestBody Book book) {
        CreateBookCommand command = new CreateBookCommand(booksService, book);
        String requestId = commandExecutor.executeAsync(command);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(Map.of(
                "message", "Request accepted for asynchronous processing",
                "requestId", requestId,
                "statusUrl", "/books/requests/" + requestId
        ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody Book book) {
        UpdateBookCommand command = new UpdateBookCommand(booksService, id, book);
        Book updatedBook = commandExecutor.executeSync(command);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable String id) {
        DeleteBookCommand command = new DeleteBookCommand(booksService, id);
        boolean deleted = commandExecutor.executeSync(command);
        if (deleted) {
            return ResponseEntity.ok("Book deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
    }

    @GetMapping("/requests/{requestId}")
    public ResponseEntity<Map<String, Object>> getRequestStatus(@PathVariable String requestId) {
        String status = commandExecutor.getStatus(requestId);
        Object result = commandExecutor.getResult(requestId);

        if ("NOT_FOUND".equals(status)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Request ID not found"));
        }

        if ("COMPLETED".equals(status)) {
            return ResponseEntity.ok(Map.of("status", status, "result", result));
        }

        return ResponseEntity.ok(Map.of("status", status));
    }
}