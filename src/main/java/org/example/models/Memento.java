package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Memento {

    private final List<Command> commandList;


    public Memento(List<Command> commandList) {
        this.commandList = new ArrayList<>();
    }

    public List<Command> getCommandList() {
        return commandList;
    }
}
