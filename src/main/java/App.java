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
        get("/squads-form", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squads-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads", (request, response) -> {
            Map <String, Object> model = new HashMap<>();
//            request.session().attribute("squads", Squad.getAll());
            model.put("squads",request.session().attribute("squads"));
            return new ModelAndView(model, "squads.hbs");
        },new HandlebarsTemplateEngine());

        post("/success", (request, response) -> {
            Map <String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String cause = request.queryParams("cause");
            Squad squad = new Squad(name,cause);
//            ArrayList<Squad> squads = Squad.getAll();
            request.session().attribute("squads", Squad.getAll());
            model.put("name",name);
            model.put("cause", cause);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
        get("squads/:id/new-hero", (request, response) -> {
            Map <String, Object> model = new HashMap<>();
            Squad squad = Squad.findSquad(Integer.parseInt(request.params(":id")));
            model.put("squad", squad);
            return new ModelAndView(model, "hero-form.hbs");
        },new HandlebarsTemplateEngine());
        post("squads/:id/new-hero-success", (request, response) -> {
            Map <String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String specialPower = request.queryParams("specialPower");
            String weakness = request.queryParams("weakness");
            int squadId = Integer.parseInt(request.params(":id"));
            Hero hero = new Hero(name,age,specialPower,weakness);
            ArrayList<Squad> squads = request.session().attribute("squads");
            Squad newSquad = squads.get(squadId-1);
            newSquad.squadHeroes.add(hero);
            squads.set(squadId-1,newSquad);
            request.session().attribute("squads", squads);
            model.put("name",name);
            return new ModelAndView(model, "hero-success.hbs");
        }, new HandlebarsTemplateEngine());
        get("/squads/:id", (request, response) -> {
            Map <String, Object> model = new HashMap<>();
            ArrayList<Squad> squads =request.session().attribute("squads");
            Squad squad = squads.get(Integer.parseInt(request.params(":id")) - 1);
            model.put("squad",squad);
            return new ModelAndView(model, "single-squad.hbs");

        },new HandlebarsTemplateEngine());
    }

}
