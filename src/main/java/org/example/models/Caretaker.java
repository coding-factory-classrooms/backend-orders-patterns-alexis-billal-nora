package org.example.models;

import java.util.ArrayList;

public class Caretaker {
    ArrayList<Memento> savedCommands = new ArrayList<Memento>();

    public void addMemento(Memento memento){
        savedCommands.add(memento);
    }

    public Memento getMemento(int index){
        return savedCommands.get(index);
    }
}
