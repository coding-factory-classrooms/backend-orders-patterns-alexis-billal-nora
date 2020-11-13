package org.example;

import org.example.core.Template;
import org.example.models.Command;
import org.example.models.Item;
import spark.Request;
import spark.Response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
Commande client - Point de départ -
Menu et choix items
 */
public class HomeSystemController {
    public String list(Request request, Response response) {
        HomeSystem homeSystem = HomeSystem.getInstance();

        // Récupération du param "action" dans l'url
        String action = request.queryParamOrDefault("action", "");

        // Si on est en mode "Ajout"
        if(action.equals("new")) {

            // Liste des commandes actuelles & des items
            List<Command> commandsActual = homeSystem.getCommands();
            List<Item> items = homeSystem.getItems();

            // Récupération de "Item" sélectionné par l'utilisateur
            String itemChosed = request.queryParamOrDefault("items", "");

            // Génération automatique du prochain numéro de commande
            Integer newCommandNumber = commandsActual.size() + 1;

            // On récupère le bon item par rapport a l'index - 1
            Item item = items.get(Integer.parseInt(itemChosed) - 1);

            // Création de la "Command"
            Command command = new Command();
            LocalDateTime dateTime = LocalDateTime.now();
            command.setDateTimeCommand(dateTime);
            command.setNumber(newCommandNumber);
            command.setItem(item);

            // Ajout dans la liste des "Command"
            homeSystem.addCommand(command);

            response.redirect("/command/" + command.getNumber());
        }

        Map<String, Object> model = new HashMap<>();

        // Ajout des variables pour la view HMTL
        model.put("commands", homeSystem.getCommands());
        model.put("items", homeSystem.getItems());

        return Template.render("home.html", model);
    }
}
