package org.example;

import org.example.core.Template;
import org.example.models.Command;
import org.example.models.Item;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandController {
    public String detail(Request request, Response response) {

        // Récupération du paramètre ID dans la request
        String idParam = request.params(":id");
        int id = Integer.parseInt(idParam);
        int index = id - 1;

        //Récupération des commandes
        List<Command> commands = HomeSystem.getInstance().getCommands();

        //Récupération d'une commande spécifique par rapport a l'index
        Command command = commands.get(index);

        Map<String, Object> model = new HashMap<>();

        // Ajout des variables pour la view HMTL
        model.put("id", id);
        model.put("command", command);
        model.put("states", Command.State.values());

        return Template.render("suivi_client.html", model);
    }

    public String edit(Request request, Response response) {

        // Récupération du param "action" dans l'url
        String action = request.queryParamOrDefault("action", "");

        // Récupération du nouveau "State"
        String state = request.queryParamOrDefault("state", "");

        // Récupération du paramètre ID dans la request
        String idParam = request.params(":id");
        int id = Integer.parseInt(idParam);
        int index = id - 1;

        //Récupération des commandes
        List<Command> commands = HomeSystem.getInstance().getCommands();

        //Récupération d'une commande spécifique par rapport a l'index
        Command command = commands.get(index);

        // Si on est en mode "Edition"
        if(action.equals("edit")) {
            System.out.println(state);
        }

        Map<String, Object> model = new HashMap<>();

        // Ajout des variables pour la view HMTL
        model.put("id", id);
        model.put("command", command);
        model.put("states", Command.State.values());

        return Template.render("command_detail.html", model);
    }
}
