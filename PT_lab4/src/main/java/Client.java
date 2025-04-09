import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;

public class Client {
    private Scanner in;
    private DataOutputStream out;
    private Socket socket;

    public Client(){
        try{
            InetAddress addr = InetAddress.getByName("localhost");
            this.socket = new Socket(addr, 4040);
            this.in = new Scanner(System.in);
            this.out = new DataOutputStream(socket.getOutputStream());
            sendMessage();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessage() throws IOException {
        String line = "";
        while(!line.equals("#")){
            line = in.nextLine();
            out.writeUTF(line);
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
