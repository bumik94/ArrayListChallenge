import java.util.ArrayList;
import java.util.Collections;
import java.lang.Comparable;

public class GroceryList {
    private int WIDTH = 20;
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
            int quantity;
        boolean duplicate = false;

        System.out.println("=".repeat(WIDTH));
        System.out.println("[Add item]\n");
        String name = Main.getString("(name): ");
        System.out.println();
        do { quantity = Main.getInt("(quantity): "); }
        while (quantity <= 0);
        
        // search for duplicate entry and
        // add quantity to duplicate's quantity
        for (GroceryItem item : groceryItems) {
            if (name.equals(item.getName())) {
                item.setQuantity(item.getQuantity() + quantity);
                duplicate = true;
            }
        }
        // when no duplicate is found, add new item and sort
        if (!duplicate) {
            addItem(name, quantity);
            Collections.sort(groceryItems);
        }
    }
    
    // add item with quantity to the list
    public void addItem(String name, int quantity) {
        groceryItems.add(new GroceryItem(name, quantity));
    }

    // remove item from the list
    public void removeItem() {
        
        if (groceryItems.isEmpty()) {
            System.out.println("\n[Empty]\n");
        } else {
            System.out.println("=".repeat(WIDTH));
            System.out.println("[Remove item]");
            System.out.println("-".repeat(WIDTH));
            printList();
            System.out.println("[ 0. cancel");
            System.out.println("-".repeat(WIDTH));
            
            for (int index;;) {
                index = Main.getInt("# ");
                if (index >= 0 && index <= groceryItems.size()) {
                    if (index == 0) { break; }
                    groceryItems.remove(--index);
                    Collections.sort(groceryItems);
                    break;
                }
            }
        }
    }

    // print enumerated list of groceries
    public void printList() {
        int enumerate = 1;
        
        for (GroceryItem item : groceryItems) {
            System.out.println("[ " + (enumerate++) + ". " + item.getString());
        }
    }
    
    public void menu() {
        boolean repeat = true;
            int index;
        
        do{ System.out.println("=".repeat(WIDTH));
            System.out.println("[Grocery list]");
            System.out.println("-".repeat(WIDTH));
            printList();
            System.out.println("-".repeat(WIDTH));
            System.out.println("""
                    [ 1. add item
                    [ 2. remove item
                    [ 0. shutdown""");
            System.out.println("-".repeat(WIDTH));
           
            do { index = Main.getInt("# "); }
            while (index < 0 || index > 2);

            switch (index) {
                case 0 -> repeat = false;
                case 1 -> addItem();
                case 2 -> removeItem();
            }
        } while (repeat);
    }
}

class GroceryItem implements Comparable<GroceryItem> {
    // a class to store data about grocery items and their quantities
    private String name;
    private int quantity;

    // method override used by Comparable class 
    // to compare specified field of the class 
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
