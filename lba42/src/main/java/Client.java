import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;

public class Client {
    private Scanner s;
    private OutputStream outStream;
    private ObjectOutputStream out;
    private InputStream inStream;
    private ObjectInputStream in;

    private int mess_id  = 0;
    private Socket socket;

    public Client(){
        try{
            InetAddress addr = InetAddress.getByName("localhost");
            this.socket = new Socket(addr, 4040);
            this.s = new Scanner(System.in);
            this.outStream = socket.getOutputStream();
            this.out = new ObjectOutputStream(outStream);
            this.inStream = socket.getInputStream();
            this.in = new ObjectInputStream(inStream);
            int pon = 1;
            while(true){
                if(pon ==1){
                    sendMessage();
                    pon = 0;
                }
                else if (pon == 0) {
                    receiveMessage();
                    pon = 1;
                }
            }
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
            System.out.println("Wprowadz operacje: {Typ, liczba a, liczba b, akcja do wykonania{+,-,*,/}");
            String type = s.nextLine();
            String action = s.nextLine();
            float a = s.nextFloat();
            float b = s.nextFloat();
            Message mess = new Message(type,mess_id,a,b,action,0);
            incID();
            out.writeObject(mess);
            //out.flush();
    }

    public boolean receiveMessage(){
            Message ans;
            try{
                ans = (Message) this.in.readObject();
                System.out.println("Otrzymano opdowiedz\n");
                if(ans != null){
                    System.out.println(ans.getAnswer());
                }
            }catch(IOException e){
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            return true;
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