import java.util.ArrayList;

public class Hero {
    private static int heroID;
    private String name;
    private String image;
    private static final ArrayList<Hero> instances = new ArrayList<>();
    private int age;
    private String specialPowers;
    private String weaknesses;

    public Hero(int heroID,String name, int age, String specialPowers, String weaknesses, String image) {
        this.name = name;
        this.age = age;
        this.specialPowers = specialPowers;
        this.weaknesses = weaknesses;
        this.image = image;
        instances.add(this);
    }
}