import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ConnectedClient {
    private Socket clientsocket;
    private DataInputStream in;
    private int id;

    public ConnectedClient(Socket clientsocket, int id) {
        this.clientsocket = clientsocket;
        this.id = id;
        try{
            System.out.println("Client: " + this.id + " has been connected!");
            this.in = new DataInputStream(new BufferedInputStream(clientsocket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readMessage(){
        String line = "";
        while(!line.equals("#")){
            try{
                line = in.readUTF();
            }catch(IOException e){
                e.printStackTrace();
            }
            System.out.println("Client: " + this.id + ": " + line);
        }
        System.out.println("Client: " + this.id + " has been connected!");
        close();
    }

    public void close(){
        try{
            in.close();
            clientsocket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
