import java.util.ArrayList;
import java.util.Collections;
import java.lang.Comparable;
import java.util.Scanner;

public class GroceryList {
    private final int WIDTH = 20;
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
    private void addItem() {
            int quantity;
        boolean duplicate = false;

        String name = getString("(name): ");
        System.out.println();
        do { quantity = getInt("(quantity): "); }
        while (quantity <= 0);
        
        // search for duplicate entry and
        // add quantity to duplicate's quantity
        for (GroceryItem item : groceryItems) {
            if (name.equals(item.getName())) {
                item.setQuantity(item.getQuantity() + quantity);
                duplicate = true;
            }
        // when no duplicate is found, add new item and sort
        } if (!duplicate) {
            addItem(name, quantity);
            Collections.sort(groceryItems);
        }
    }
    
    // add item with quantity to the list
    private void addItem(String name, int quantity) {
        groceryItems.add(new GroceryItem(name, quantity));
    }

    // remove item from the list
    private void removeItem() {
        int index;
        
        do{ index = getInt("# "); }
        while (index < 0 || index > groceryItems.size());
        if (index > 0) {
            groceryItems.remove(--index);
            Collections.sort(groceryItems);
        }
    }

    // print enumerated list of groceries
    private void printList() {
        int enumerate = 1;
        
        for (GroceryItem item : groceryItems) {
            System.out.println("[ " + (enumerate++) + ". " + item.getString());
        }
    }

    // main menu method to operate 
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
           
            do { index = getInt("# "); }
            while (index < 0 || index > 2);
            System.out.println();
           
            switch (index) {
                case 0 -> { // Terminate program
                    repeat = false;
                }
                case 1 -> { // Add item
                    System.out.println("=".repeat(WIDTH));
                    System.out.println("[Add item]");
                    System.out.println("-".repeat(WIDTH));
                    System.out.println();
                    addItem();
                }
                case 2 -> { // Remove item
                    if (groceryItems.isEmpty()) {
                        System.out.println("[Empty]");
                    } else {
                        System.out.println("=".repeat(WIDTH));
                        System.out.println("[Remove item]");
                        System.out.println("-".repeat(WIDTH));
                        printList();
                        System.out.println("[ 0. cancel");
                        System.out.println("-".repeat(WIDTH));
                        removeItem();
                    }
                }
            } System.out.println();
        } while (repeat);
    }

    public static int getInt(String prompt) {
        var s = new Scanner(System.in);

        for (;;) {
            System.out.print(prompt);
            try { return Integer.parseInt(s.nextLine()); }
            catch (Exception e) {   }
        }
    }

    public static String getString(String prompt) {
        var s = new Scanner(System.in);

        System.out.print(prompt);
        return s.nextLine();
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
