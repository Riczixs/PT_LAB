import java.io.Serializable;

public class Message implements Serializable {
    private final String type;
    private final int id;
    private final float a;
    private final float b;
    private final String action;

    public Message(String type, int id, float a, float b, String action){
        this.type = type;
        this.id = id;
        this.a = a;
        this.b = b;
        this.action = action;
    }

    public String getType() {
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

    public String getAction() {
        return action;
    }
}
