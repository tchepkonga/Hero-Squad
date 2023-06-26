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
            request.session().attribute("squads", Squad.getAll());
            model.put("squads",request.session().attribute("squads"));
            return new ModelAndView(model, "squads.hbs");
        },new HandlebarsTemplateEngine());
        post("/success", (request, response) -> {
            Map <String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String cause = request.queryParams("cause");
            Squad squad = new Squad(name,cause);
            ArrayList<Squad> squadArr= request.session().attribute("squads");
            squadArr.add(squad);
            request.session().attribute("squads",squadArr);
            model.put("name",name);
            model.put("cause", cause);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
    }

}
