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
