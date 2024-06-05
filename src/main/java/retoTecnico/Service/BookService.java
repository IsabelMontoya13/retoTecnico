package retoTecnico.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retoTecnico.Entity.Book;
import retoTecnico.Repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getBooks() { return bookRepository.findAll();}

    public Optional<Book> getBook(Long id) { return bookRepository.findById(id);}

    public Book add (Book book) {
        return bookRepository.save(book);
    }

    public Book update (Long id, Book bookData){
        Book book=bookRepository.findById(id).get();
        book.setTitulo(bookData.getTitulo());
        book.setAutor(bookData.getAutor());
        book.setFechaDePublicacion(bookData.getFechaDePublicacion());
        book.setIsbn(bookData.getIsbn());
        bookRepository.save(book);
        return book;
    }

    public void delete (Long id){
        bookRepository.deleteById(id);
    }

    public List<Book> searchBooks(String text) {
        return bookRepository.findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(text, text);
    }
}

