import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;

public class Client {
    private Scanner in;
    private OutputStream outStream;
    private ObjectOutputStream out;
    private int mess_id  = 0;
    private Socket socket;

    public Client(){
        try{
            InetAddress addr = InetAddress.getByName("localhost");
            this.socket = new Socket(addr, 4040);
            this.in = new Scanner(System.in);
            this.outStream = socket.getOutputStream();
            this.out = new ObjectOutputStream(outStream);
            sendMessage();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void incID(){
        this.mess_id+=1;
    }
    public void sendMessage() throws IOException {
        String line = "";
        System.out.println("Wprowadz operacje: {Typ, liczba a, liczba b, akcja do wykonania{+,-,*,/}");
        while(!line.equals("#")){
            char type = '.';
            float a = 0;
            float b = 0;
            char action = '+';
            Message mess = new Message(type,mess_id,a,b,action);
            incID();
            out.writeObject(mess);
        }
        close();
    }
    public void close() throws IOException {
        in.close();
        out.close();
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        new Client();
    }
}