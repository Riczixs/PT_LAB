import java.util.Optional;

public class Controler {

    private Repository repo;

    public Controler(Repository repo) {
        this.repo = repo;
    }

    public String save(Book book){
        try{
            repo.addBook(book);
            return "done";
        }catch(IllegalArgumentException e){
            return "bad request";
        }
    }

    public String remove(int id){
        try{
            repo.removeBook(id);
            return "done";
        }catch(IllegalArgumentException e){
            return "not found";
        }
    }

    public Optional<Book> getBook(int id) {
        return repo.getBook(id);
    }

}
