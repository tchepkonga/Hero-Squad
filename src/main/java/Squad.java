import java.util.ArrayList;

public class Squad {
    private String name;
    private int mId;
    private String cause;
    private static final ArrayList<Squad> instances = new ArrayList<>();
    ArrayList<Hero> squadHeroes;


    public Squad(String name, String cause){
        this.name = name;
        this.cause = cause;
        instances.add(this);
        this.squadHeroes = new ArrayList<>();
        mId = instances.size();

    }

    public String getName() {
        return name;
    }
    public String getCause() {
        return cause;
    }
    public ArrayList<Hero> getHeroes(){
        return squadHeroes;
    }
    public static ArrayList<Squad> getAll(){
        return instances;
    }
    public static void clear(){
        instances.clear();
    }

    public int getId(){
        return mId;
    }

    public static Squad findSquad(int id){
        return instances.get(id - 1);
    }

    public void addHero(Hero hero){
        if(squadHeroes.size() < 5) {
            squadHeroes.add(hero);
        } else {

        }

    }

}