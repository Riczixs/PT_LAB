import java.util.Optional;

public interface Repository {
    void addBook(Book book);
    void removeBook(int id);
    Optional<Book> getBook(int id);
}
