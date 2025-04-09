import java.io.*;
import java.net.Socket;

public class ConnectedClient {
    private Socket clientsocket;
    private InputStream inStream;
    private ObjectInputStream in;
    private int id;
    private int mess_id = 0;

    public ConnectedClient(Socket clientsocket, int id) {
        this.clientsocket = clientsocket;
        this.id = id;
        try{
            System.out.println("Client: " + this.id + " has been connected!");
            this.inStream = clientsocket.getInputStream();
            this.in = new ObjectInputStream(inStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readMessage(){
        String line = "";
        while(!(line.equals("#"))){
            try{
                Message mess = (Message) this.in.readObject();
                System.out.println(toString(mess));
            }catch(IOException e){
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
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

    public String toString(Message mess) {
        return "Message: type: {"+mess.getType() +" ID: "+ mess.getId()+" a= " + mess.getA() + "b = " + mess.getB() + "action - " + mess.getAction();
    }
}