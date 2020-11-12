package org.example;

import org.example.core.Template;
import org.example.models.Command;
import org.example.models.Item;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
Gestion du dashboard - Commande en cours et historique des commandes
 */
public class DashboardController {
    public String current(Request request, Response response) {
        HomeSystem homeSystem = HomeSystem.getInstance();

        // Liste des commandes actuelles & des items
        List<Command> commandsActual = homeSystem.getCommands();



        Map<String, Object> model = new HashMap<>();

        // Ajout des variables pour la view HMTL
        model.put("commands", homeSystem.getCommands());


        return Template.render("dashboard.html", model);
    }
}
