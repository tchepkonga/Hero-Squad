import java.util.ArrayList;

public class Hero {
    private static int heroId= 0;
    private String name;
    private String image;
    private static final ArrayList<Hero> instances = new ArrayList<>();
    private int age;
    private String specialPowers;
    private String weaknesses;

    public Hero(String name, int age, String specialPowers, String weaknesses, String image) {
        this.name = name;
        this.age = age;
        this.specialPowers = specialPowers;
        this.weaknesses = weaknesses;
        this.image = image;
        instances.add(this);
        heroId++;
    }
    public static ArrayList<Hero> createHeroes(){
        Hero hero1 = new Hero("Superman", 30,  "Strength","love", "https://www.superherodb.com/pictures2/portraits/10/100/1496.jpg");
        Hero hero2= new Hero("Superman2", 30,  "Strength","love", "https://www.superherodb.com/pictures2/portraits/10/100/1496.jpg");
        Hero hero3 = new Hero("Superman3", 30,  "Strength","love", "https://www.superherodb.com/pictures2/portraits/10/100/1496.jpg");
        Hero hero4 = new Hero("Superman4", 30,  "Strength","love", "https://www.superherodb.com/pictures2/portraits/10/100/1496.jpg");
        Hero hero5 = new Hero("Superman5", 30,  "Strength","love", "https://www.superherodb.com/pictures2/portraits/10/100/1496.jpg");
        Hero hero6 = new Hero("Superman6", 30,  "Strength","love", "https://www.superherodb.com/pictures2/portraits/10/100/1496.jpg");
        return Hero.getAll();
    }

    public static int getHeroId() {
        return heroId;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
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
}