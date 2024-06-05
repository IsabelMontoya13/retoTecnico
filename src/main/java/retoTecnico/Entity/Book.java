package retoTecnico.Entity;
import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="libro")
@Entity
public class Book {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="titulo")
    private String titulo;
    @Column(name="autor")
    private String autor;
    @Column(name="fecha_de_publicacion")
    private LocalDate fechaDePublicacion;
    @Column(name="isbn", unique=true)
    private String isbn;

    public Book() {
    }

    public Book(Long id, String titulo, String autor, LocalDate fechaDePublicacion, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaDePublicacion = fechaDePublicacion;
        this.isbn = isbn;
    }
}
