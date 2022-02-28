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
            String name = request.queryParams("name");
            String cause = request.queryParams("cause");
            Squad squad = new Squad(name,cause);
            ArrayList<Squad> squads = Squad.getAll();
            request.session().attribute("squads", squads);
           return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
        get("/heroes", (request, response) -> {
            Map <String, Object> model = new HashMap<>();
            Hero.createHeroes();
            ArrayList<Hero> heroes = Hero.getAll();
            request.session().attribute("heroes",heroes);
            model.put("heroes", request.session().attribute("heroes"));
            return new ModelAndView(model, "heroes.hbs");
        }, new HandlebarsTemplateEngine());
        get("/squads", (request, response) -> {
            Map <String, Object> model = new HashMap<>();
            model.put("squads",request.session().attribute("squads"));
            return new ModelAndView(model, "squads.hbs");
        }, new HandlebarsTemplateEngine());
    }

}
