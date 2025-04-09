import java.io.*;
import java.net.Socket;

public class ConnectedClient {
    private Socket clientsocket;
    private InputStream inStream;
    private ObjectInputStream in;

    private OutputStream outStream;

    private ObjectOutputStream out;
    private int id;
    private int mess_id = 0;

    public ConnectedClient(Socket clientsocket, int id) {
        this.clientsocket = clientsocket;
        this.id = id;
        try{
            System.out.println("Client: " + this.id + " has been connected!");
            this.inStream = clientsocket.getInputStream();
            this.in = new ObjectInputStream(inStream);
            this.outStream = clientsocket.getOutputStream();
            this.out = new ObjectOutputStream(outStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void readMessage(){
        String line = "";
        while(!(line.equals("#"))){
            Message mess;
            try{
                mess = (Message) this.in.readObject();
                if(mess != null){
                    System.out.println(toString(mess));
                }
            }catch(IOException e){
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Client: " + this.id + " has been connected!");
        close();
    }
    private float calculate(Message mes) {
        if (mes.getAction().equals("+")) {
            return mes.getA() + mes.getB();
        } else if (mes.getAction().equals("-")) {
            return mes.getA() - mes.getB();
        } else if (mes.getAction().equals("*")) {
            return mes.getA() * mes.getB();
        } else if (mes.getAction().equals("/")) {
            return mes.getA() / mes.getB();
        }
        return -1;
    }

    public void sendBack() throws IOException {
        Message mess = new Message("",0,0,0,"",0);
        mess.setAns(calculate(mess));
        System.out.println("Calculated operation: " + mess.getAnswer());
        out.writeObject(mess);
        out.flush();
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
        return "Message\n: type: "+mess.getType() +" \nID: "+ mess.getId()+" \na= " + mess.getA() + "\nb = " + mess.getB() + "\naction - " + mess.getAction();
    }
}