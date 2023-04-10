package org.eronen.viikko11;

public class Grocery {
    private String name;
    private int Id;
    public static int groceryCounter = 0;

    public Grocery(String name, int Id) {
        this.Id = Id;
        this.name = name;
        groceryCounter++;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return Integer.toString(Id);
    }

    public void setName(String name) {
        this.name = name;
    }

}
