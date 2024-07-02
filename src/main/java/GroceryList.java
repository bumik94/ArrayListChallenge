import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GroceryList {

    // a list to store grocery items
    private ArrayList<GroceryItem> groceryItems = new ArrayList<>();
    Scanner s = new Scanner(System.in);

    public GroceryList() {  }

    // add item to the list
    public void addItem(String name) {

        groceryItems.add(new GroceryItem(name));
    }

    public void addItem() {

        System.out.println("[Add item]");
        System.out.print("[name: ");
        String name = getName();
        System.out.print("[quantity: ");
        int quantity = getInt();
        addItem(name, quantity);
    }
    
    // add item with quantity to the list
    public void addItem(String name, int quantity) {

        groceryItems.add(new GroceryItem(name, quantity));
    }

    // remove item from the list
    public void removeItem() {

        System.out.println("[Delete item]");
        printList();
        
        for (int index;;) {
            index = getInt();
            if (index >= 0 && index <= groceryItems.size()) {
                if (index == 0) {
                     break;
                groceryItems.remove(--index);
            }
        }
    }

    // print enumerated list of groceries
    public void printList() {

        int enumerate = 1;
        for (GroceryItem item : groceryItems) {
            System.out.println(enumerate++ + ". " + item.getString());
        }
    }

    public static int getInt() {
        Scanner s = new Scanner(System.in);
        for (;;) {
            try {
                return Integer.parseInt(s.nextLine());
            } catch (Exception e) {  }
        }
    }

    public static String getName() {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    public static int promptSelection(String prompt, int max) {

        for(int selection;;) {
            System.out.println(prompt);
            selection = getInt();
            if (selection >= 0 && selection <= max) { return selection; }
        }
    }
}

class GroceryItem {

    // a class to store data about grocery tiems and their quantities
    private String item;
    private int quantity;

    public GroceryItem(String item) {
        
        this.item = item;
        this.quantity = 1;
    }

    public GroceryItem(String item, int quantity) {
        
        this.item = item;
        this.quantity = quantity;
    }

    public String getString() {
        
        return item + " [" + quantity + "]";
    }
}      
