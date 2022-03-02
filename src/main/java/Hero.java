import java.util.ArrayList;

public class Hero {
    private int mId= 0;
    private String name;
    private static final ArrayList<Hero> instances = new ArrayList<>();
    private int age;
    private String specialPower;
    private String weakness;


    public Hero(String name, int age, String specialPower, String weakness) {
        this.name = name;
        this.age = age;
        this.specialPower = specialPower;
        this.weakness = weakness;
        instances.add(this);
        mId = instances.size();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public int getId() {
        return mId;
    }

    public String getSpecialPowers() {
        return specialPower;
    }

    public String getWeakness() {
        return weakness;
    }

    public static ArrayList<Hero> getAll(){
        return instances;
    }

    public static void  clear(){instances.clear();}

    public static Hero findHero(int id){return instances.get(id-1);}
}