import java.util.ArrayList;

public class Hero {
    private int mId= 0;
    private String name;
    private static final ArrayList<Hero> instances = new ArrayList<>();
    private int age;
    private String specialPowers;
    private String weaknesses;


    public Hero(String name, int age, String specialPowers, String weaknesses) {
        this.name = name;
        this.age = age;
        this.specialPowers = specialPowers;
        this.weaknesses = weaknesses;
        instances.add(this);
        mId = instances.size();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpecialPowers() {
        return specialPowers;
    }

    public String getWeaknesses() {
        return weaknesses;
    }

    public static ArrayList<Hero> getAll(){
        return instances;
    }

    public static void  clear(){instances.clear();}

    public static Hero findHero(int id){return instances.get(id-1);}
}