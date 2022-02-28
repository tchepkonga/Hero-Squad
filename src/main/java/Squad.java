import java.util.ArrayList;

public class Squad {
    private String name;
    private int maxSize;
    private String cause;
    private static final ArrayList<Squad> instances = new ArrayList<>();

    public Squad(String name, String cause){
        this.maxSize = 5;
        this.name = name;
        this.cause = cause;
    }
}