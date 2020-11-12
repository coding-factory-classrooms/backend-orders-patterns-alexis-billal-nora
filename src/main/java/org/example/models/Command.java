package org.example.models;

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

}
