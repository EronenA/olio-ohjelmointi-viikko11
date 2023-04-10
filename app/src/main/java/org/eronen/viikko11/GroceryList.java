package org.eronen.viikko11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GroceryList {

    private ArrayList<Grocery> groceries = new ArrayList<>();

    private static GroceryList grocerylist = null;

    private GroceryList(){

    }

    public static GroceryList getInstance() {
        if (grocerylist == null) {
            grocerylist = new GroceryList();
        }
        return grocerylist;
    }

    public void addGrocery(Grocery grocery) {
        groceries.add(grocery);
    }

    public void removeGroceries(int id) {
        groceries.remove(id);
    }

    public ArrayList<Grocery> getGroceries() {
        return groceries;
    }

    public Grocery getGroceryById(int id) {
        return groceries.get(id);
    }

    public void sortByAlphabet() {
        Collections.sort(groceries, new Comparator<Grocery>() {
            @Override
            public int compare(Grocery lhs, Grocery rhs) {
                return lhs.getName().compareTo(rhs.getName());
            }
        });
    }

    public void sortById() {
        Collections.sort(groceries, new Comparator<Grocery>() {
            @Override
            public int compare(Grocery lhs, Grocery rhs) {
                return lhs.getId().compareTo(rhs.getId());
            }
        });
    }

}
