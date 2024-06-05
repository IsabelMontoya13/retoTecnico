package retoTecnico.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import retoTecnico.Repository.BookRepository;
import retoTecnico.Entity.Book;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    Book book1 = new Book(1l,"Cien años de soledad", "Gabriel García Márquez", LocalDate.of(1967, 5, 30), "978-0307474728");
    Book book2 = new Book( 2l,"Don Quijote de la Mancha", "Miguel de Cervantes", LocalDate.of(1605, 1, 16), "978-0060934347");

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void getBooks() {

        when(bookRepository.findAll()).thenReturn(Arrays.asList(book1, book2));
        List<Book> books = bookService.getBooks();
        assertEquals(2, books.size());
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    void getBook() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book1));

        Optional<Book> result = bookService.getBook(1L);
        assertTrue(result.isPresent());
        assertEquals("Cien años de soledad", result.get().getTitulo());
    }

    @Test
    void add() {
        when(bookRepository.save(any(Book.class))).thenReturn(book1);
        Book result=bookService.add(book1);
        assertEquals("Cien años de soledad",result.getTitulo());
        assertEquals("Gabriel García Márquez",result.getAutor());

    }

    @Test
    void update() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book1));
        when(bookRepository.save(any(Book.class))).thenReturn(book2);

        Book result = bookService.update(1L, book2);
        assertEquals("Don Quijote de la Mancha", result.getTitulo());
        assertEquals("Miguel de Cervantes", result.getAutor());
    }

    @Test
    void delete() {

        bookService.delete(1l);
        verify(bookRepository, times(1)).deleteById(1L);
    }

    @Test
    void searchBooks() {
        when(bookRepository.findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase("text", "text"))
                .thenReturn(Arrays.asList(book1, book2));

        List<Book> books = bookService.searchBooks("text");
        assertEquals(2, books.size());
        verify(bookRepository, times(1))
                .findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase("text", "text");
    }
}