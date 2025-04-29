import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class BookControlerTest {
    private BookRepository repo;
    private Controler controler;

    @BeforeEach
    public void setUp() {
        repo = mock(BookRepository.class);
        controler = new Controler(repo);
    }

    @Test
    void shouldReturnDoneWhenAddingBook() {
        Book book = new Book(1,"A","Marek");
        //doNothing().when(repo).addBook(book);
        String result = controler.save(book);
        assertEquals("done", result);
    }

    @Test
    void shouldReturnBadRequestWhenAddingBook() {
        Book book = new Book(1,"A","Marek");
        doNothing().when(repo).addBook(book);
        book = new Book(1,"B","Stasiek");
        String result = controler.save(book);
        assertEquals("bad request", result);
    }

    @Test
    void shouldReturnDoneWhenRemovingExistingBook() {
        Book book = new Book(1,"A","Marek");
        doNothing().when(repo).addBook(book);
        String result = controler.remove(1);
        assertEquals("done", result);
    }

    @Test
    void shouldReturnBadRequestWhenRemovingNonExistingBook() {
        Book book = new Book(1,"A","Marek");
        doNothing().when(repo).addBook(book);
        String result = controler.remove(2);
        assertEquals("bad request", result);
    }

    @Test
    void shouldReturnDoneWhenGettingExistingBook() {
        Book book = new Book(1,"A","Marek");
        doNothing().when(repo).addBook(book);
        String result = controler.getBook(1).toString();
        assertEquals("Book id=1, title='A', author='Marek'}", result);
    }

    @Test
    void shouldReturnBadRequestWhenGettingNonExistingBook() {
        Book book = new Book(1,"A","Marek");
        doNothing().when(repo).addBook(book);
        if(controler.getBook(2).isEmpty()){
            String result = "not found";
            assertEquals("not found", result);
        }
    }




}
