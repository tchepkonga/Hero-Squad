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
           return new ModelAndView(model, "heroes.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
