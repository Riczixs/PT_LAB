import java.io.IOException;
import java.net.*;
import java.util.*;

public class Server {
    private ServerSocket server;
    private final int port = 4040;
    private int id = 0;

    public Server(){
        try{
            server = new ServerSocket(port);
            while(true) initConnection();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void initConnection() throws IOException{
        Socket Clientsocket = server.accept();
        if(Clientsocket.isConnected()){
            new Thread(()->{
                id++;
                ConnectedClient conClient = new ConnectedClient(Clientsocket,id);
                conClient.readMessage();
                try {
                    conClient.sendBack();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                conClient.close();
            }).start();
        }
    }
    public static void main(String[] args) throws IOException {
        new Server();
    }



}