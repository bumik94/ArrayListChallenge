import java.util.ArrayList;
import java.util.Collections;
import java.lang.Comparable;

public class GroceryList {

    // a list to store grocery items
    private ArrayList<GroceryItem> groceryItems = new ArrayList<>();

    // Constructor
    public GroceryList() {   }
    public GroceryList(boolean test) {
        groceryItems.add(new GroceryItem("milk"));
        groceryItems.add(new GroceryItem("butter"));
        groceryItems.add(new GroceryItem("cereals", 2));
    }

    // add item to the list
    public void addItem() {

        System.out.print("""
                [========]
                [Add item]
                (name)
                }""" + " ");
        String name = Main.getString();
        for (boolean duplicate = false;;) {
            System.out.print("""
                (quantity)
                }""" + " ");
            int quantity = Main.getInt();
            if (quantity > 0) { 
                // search for duplicate
                for (GroceryItem item : groceryItems) {
                    if (name.equals(item.getName())) {
                        item.setQuantity(item.getQuantity() + quantity);
                        duplicate = true;
                    }
                // when no duplicate is found, add new item and sort
                } if (!duplicate) {
                    addItem(name, quantity);
                    Collections.sort(groceryItems);
                    // terminate for loop after adding item
                    break; } break;
            }
            // error message for incorrect quantity
            System.out.println("""
                [Invalid number]
                }""" + " ");
        }
    }
    
    // add item with quantity to the list
    public void addItem(String name, int quantity) {

        groceryItems.add(new GroceryItem(name, quantity));
    }

    // remove item from the list
    public void removeItem() {
        
        if (groceryItems.isEmpty()) {
            System.out.println("[Empty]");
        } else {
            System.out.println("""
                    [===========]
                    [Remove item]
                    [-----------]""");
            printList();
            System.out.print("""
                    [ 0. cancel ]
                    }""" + " ");
            for (int index;;) {
                index = Main.getInt();
                if (index >= 0 && index <= groceryItems.size()) {
                    if (index == 0) { break; }
                    groceryItems.remove(--index);
                    Collections.sort(groceryItems);
                    break;
                }
                System.out.print("""
                    [Invalid number]
                    }""" + " ");
            }
        }
    }

    // print enumerated list of groceries
    public void printList() {

        int enumerate = 1;
        for (GroceryItem item : groceryItems) {
            System.out.println("[ " + enumerate++ + ". " + item.getString());
        }
    }
}

class GroceryItem implements Comparable<GroceryItem> {

    // a class to store data about grocery tiems and their quantities
    private String name;
    private int quantity;

    // method override used by Comparable class to compare specified field
    // of the class inside of ArrayList with each other
    @Override
    public int compareTo(GroceryItem item) {
        
        return name.compareTo(item.name);
    }

    public GroceryItem(String name) {
        
        this.name = name;
        this.quantity = 1;
    }

    public GroceryItem(String name, int quantity) {
        
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {

        return this.name;
    }

    public int getQuantity() {

        return this.quantity;
    }

    public void setQuantity(int quantity) {
        
        this.quantity = quantity;
    }

    public String getString() {
        
        return name + " [" + quantity + "]";
    }
}

class Menu {

    GroceryList groceryList;

    public Menu(GroceryList groceryList) {

         this.groceryList = groceryList;
    }

    public void menu() {

        for (int index;;) {
            System.out.println("""
                    [============]
                    [Grocery list]
                    [------------]""");
            groceryList.printList();
            System.out.print("""
                    [------------]
                    [ 1. add item
                    [ 2. remove item
                    [ 0. shutdown
                    }""" + " ");
            index = Main.getInt();
            if (index >= 0 && index <= 2) {
                // 0. shutdown
                if (index == 0) {
                    break;
                }
                // 1. add item
                else if (index == 1) {
                    groceryList.addItem();
                }
                // 2. remove item
                else if (index == 2) {
                    groceryList.removeItem();
                }
            }
        }
    }
}
