import java.util.ArrayList;
import java.util.List;

public class GroceryList {

    // a list to store grocery items
    private ArrayList<GroceryItem> groceryItems = new ArrayList<>();

    public GroceryList() {  }

    // add item
    public void addItem(String name) {

        groceryItems.add(new GroceryItem(name));
    }

    public void addItem(String name, int quantity) {

        groceryItems.add(new GroceryItem(name, quantity));
    }

    public void printList() {

        for (GroceryItem item : groceryItems) {
            System.out.println(item.getString());
        }
    }


    // remove item


    // print list
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

