import java.util.ArrayList;
import java.util.Collections;
import java.lang.Comparable;

public class GroceryList {

    // a list to store grocery items
    private ArrayList<GroceryItem> groceryItems = new ArrayList<>();

    // Constructor
    public GroceryList() {   }
    public GroceryList(boolean debug) {
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
                }_""");
        String name = Main.getName();
        for (int quantity;;) {
            System.out.print("""
                (quantity)
                }_""");
            quantity = Main.getInt();
            if (quantity >= 0) {
                addItem(name, quantity);
                Collections.sort(groceryItems);
                break;
            }
            System.out.println("""
                [Invalid number]
                }_""");
        }
    }
    
    // add item with quantity to the list
    public void addItem(String name, int quantity) {

        groceryItems.add(new GroceryItem(name, quantity));
    }

    // remove item from the list
    public void removeItem() {

        for (int index;;) {
            if (groceryItems.isEmpty()) {
                System.out.println("[Empty]");
                break; 
            }
            System.out.println("""
                    [===========]
                    [Remove item]
                    [-----------]""");
            printList();
            System.out.println("} 0. cancel");
            index = Main.getInt();
            if (index >= 0 && index <= groceryItems.size()) {
                if (index == 0) { break; }
                groceryItems.remove(--index);
                break;
            }
            System.out.println("""
                    [Invalid number]
                    }_""");
        }
    }

    // print enumerated list of groceries
    public void printList() {

        int enumerate = 1;
        for (GroceryItem item : groceryItems) {
            System.out.println("[ " + enumerate++ + ". " + item.getString());
        }
    }

    public static int promptSelection(String prompt, int max) {

        for(int selection;;) {
            System.out.println(prompt);
            selection = Main.getInt();
            if (selection >= 0 && selection <= max) { return selection; }
        }
    }
}

class GroceryItem implements Comparable<GroceryItem> {

    // a class to store data about grocery tiems and their quantities
    private String name;
    private int quantity;

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
                    [ 1 - add item
                    [ 2 - remove item
                    [ 0 - shutdown
                    }_""");
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
