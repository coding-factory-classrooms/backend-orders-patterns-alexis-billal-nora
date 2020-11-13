package org.example.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Command {

    public enum State {
        NEW,
        IN_PROGRESS,
        FINISHED,
        CANCELLED
    }

    private int number;
    protected State state = State.NEW;
    private Item item;
    private LocalDateTime dateTimeCommand;
    private List<Command> commands;
    // private OnChangedCommandListener onChangedCommandListener;

   //Instance de memento
    public Memento storeInMemento(java.awt.List listCommand){
        System.out.println("From Command: Saving to Memento");
        return new Memento(commands);
    }

    public List<Command> restoreFromMemento(Memento memento){
        commands = memento.getCommandList();
        System.out.println("From Command: Previous list saved in  Memento");
        return commands;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }

    public LocalDateTime getDateTimeCommand() {
        return dateTimeCommand;
    }

    public void setDateTimeCommand(LocalDateTime dateTimeCommand) {
        this.dateTimeCommand = dateTimeCommand;
    }
}

