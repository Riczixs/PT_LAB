import java.io.Serializable;

public class Message implements Serializable {
    private final char type;
    private final int id;
    private final float a;
    private final float b;
    private final char action;

    public Message(char type, int id, float a, float b, char action){
        this.type = type;
        this.id = id;
        this.a = a;
        this.b = b;
        this.action = action;
    }

    public char getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    public char getAction() {
        return action;
    }
}
