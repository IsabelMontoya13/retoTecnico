package retoTecnico.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import retoTecnico.Entity.Book;
import retoTecnico.Service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/libro")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.getBook(id).orElse(null);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.add(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookData){
        return bookService.update(id, bookData);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.delete(id);
    }

    @GetMapping("/text")
    public List<Book> searchBooks(@RequestParam String text){
        return bookService.searchBooks(text);
    }

}
