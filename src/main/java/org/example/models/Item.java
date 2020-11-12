package org.example.models;

public abstract class Item {

    protected String name = "";

    public String getName() {
        return name;
    }

    public abstract String getTypeName();

    public void setName(String name) {
        this.name = name;
    }
}
