package org.example;

import org.example.core.Conf;
import org.example.core.Template;
import org.example.middlewares.LoggerMiddleware;
import org.example.models.Burger;
import org.example.models.Command;
import org.example.models.Pizza;
import spark.Spark;

public class App {
    public static void main(String[] args) {
        initialize();

        HomeSystem homeSystem  = HomeSystem.getInstance();

        // Création des "Item"
        Pizza pizza = new Pizza();
        pizza.setName("Reine");

        Pizza pizza2 = new Pizza();
        pizza2.setName("4 fromages");

        Burger burger = new Burger();
        burger.setName("CheeseBurger");

        // Création de fausses commandes
        Command command = new Command();
        command.setNumber(1);
        command.setItem(pizza);

        Command command2 = new Command();
        command2.setNumber(2);
        command2.setItem(burger);

        Command command3 = new Command();
        command3.setNumber(3);
        command3.setItem(pizza2);

        // Assignation des "Item" au homeSystem
        homeSystem.addItem(pizza);
        homeSystem.addItem(pizza2);
        homeSystem.addItem(burger);

        // Assignation des "Command" au homeSystem
        homeSystem.addCommand(command);
        homeSystem.addCommand(command2);
        homeSystem.addCommand(command3);

        HomeSystemController homeSystemController = new HomeSystemController();
        CommandController commandController = new CommandController();

        Spark.get("/", (req, res) -> homeSystemController.list(req, res));
        Spark.get("/command/:id", (req, res) -> commandController.detail(req, res));
        Spark.get("/command/edit/:id", (req, res) -> commandController.edit(req, res));
    }

    static void initialize() {
        Template.initialize();

        // Display exceptions in logs
        Spark.exception(Exception.class, (e, req, res) -> e.printStackTrace());

        // Serve static files (img/css/js)
        Spark.staticFiles.externalLocation(Conf.STATIC_DIR.getPath());

        // Configure server port
        Spark.port(Conf.HTTP_PORT);
        final LoggerMiddleware log = new LoggerMiddleware();
        Spark.before(log::process);
    }
}
