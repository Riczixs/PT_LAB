import org.junit.Test;
import java.util.Optional;

import static org.junit.Assert.*;

public class BookRepositoryTest {
    @Test
    public void shouldSaveBook() {
        Repository repo = new BookRepository();
        Book book = new Book(1,"A","Marek");
        repo.addBook(book);
        Book book2 = new Book(1,"B","Andżej");
        assertThrows(IllegalArgumentException.class, () -> repo.addBook(book2));
    }

    @Test
    public void shouldThrownInDeleteBook() {
        Repository repo = new BookRepository();
        Book book = new Book(1,"A","Marek");
        repo.addBook(book);
        assertThrows(IllegalArgumentException.class, () -> repo.removeBook(2));
    }

    @Test
    public void shouldReturnEmptyOptional() {
        Repository repo = new BookRepository();
        assertEquals(Optional.empty(), repo.getBook(1));
    }

    @Test
    public void shouldReturnOptionalExistingBook() {
        Repository repo = new BookRepository();
        Book book = new Book(1,"A","Marek");
        repo.addBook(book);
        assertEquals(Optional.of(book), repo.getBook(1));
    }

}
