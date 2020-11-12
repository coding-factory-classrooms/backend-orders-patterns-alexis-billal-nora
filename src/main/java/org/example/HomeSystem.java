package org.example;

import org.example.models.Command;

import java.util.ArrayList;
import java.util.List;

public class HomeSystem {
    private static HomeSystem instance;

    public static HomeSystem getInstance() {
        if (instance == null) {
            instance = new HomeSystem();
        }
        return instance;
    }

    private final List<Command> commands;

    private HomeSystem() {
        this.commands = new ArrayList<>();
    }

    public boolean addCommand(Command command) {
        return commands.add(command);
    }

    public List<Command> getCommands() {
        return commands;
    }
}
