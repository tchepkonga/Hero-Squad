import static spark.Spark.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;


public class App {
    public static void main(String[] args) {
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
//            createHeroes();
//            ArrayList<Hero> heroes = Hero.getAll();
//            model.put("heroes", heroes);
           return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
        get("/heroes", (request, response) -> {
            Map <String, Object> model = new HashMap<>();
            Hero.createHeroes();
            ArrayList<Hero> heroes = Hero.getAll();
//            System.out.println(heroes);
//            Hero hero1 = new Hero("Superman", 30,  "Strength","love", "https://www.superherodb.com/pictures2/portraits/10/100/1496.jpg");
            request.session().attribute("heroes",heroes);
            model.put("heroes", request.session().attribute("heroes"));
            return new ModelAndView(model, "heroes.hbs");
        }, new HandlebarsTemplateEngine());
    }

}
