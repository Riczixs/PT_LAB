import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class BookRepository implements Repository {
    private List<Book> books;
    public BookRepository() {
        books = new ArrayList<Book>();
    }

    public boolean isStore(int id){
        for (Book book : books) {
            if (book.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void addBook(Book book) {
        if (isStore(book.getId())) {
            throw new IllegalArgumentException("Book already exists");
        }else{
            books.add(book);
        }
    }

    public void removeBook(int id) {
        if (!isStore(id)) {
            throw new IllegalArgumentException("Book does not exist");
        }else{
            Iterator<Book> iterator = books.iterator();
            while (iterator.hasNext()) {
                Book book = iterator.next();
                if (book.getId() == id) {
                    iterator.remove();
                }
            }
        }
    }

    public Optional<Book> getBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return Optional.of(book);  // nie Nullable, bo nie ma ryzyka null
            }
        }
        return Optional.empty();
    }

}
