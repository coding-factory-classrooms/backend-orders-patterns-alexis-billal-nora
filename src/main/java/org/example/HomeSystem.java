package org.example;

import org.example.models.Command;
import org.example.models.Item;

import java.util.ArrayList;
import java.util.List;

public class HomeSystem {

    // Singleton pattern
    private static HomeSystem instance;

    public static HomeSystem getInstance() {
        if (instance == null) {
            instance = new HomeSystem();
        }
        return instance;
    }

    // Liste des "Command" & "Item"
    private final List<Command> commands;
    private final List<Item> items;

    // Constructor
    private HomeSystem() {
        this.commands = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    // Setter
    public boolean addCommand(Command command) {
        return commands.add(command);
    }
    public boolean addItem(Item item) {
        return items.add(item);
    }

    // Getter
    public List<Command> getCommands() {
        return commands;
    }
    public List<Item> getItems() {
        return items;
    }
}
