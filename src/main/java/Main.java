import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        GroceryList groceries = new GroceryList();
        groceries.addItem("milk", 1);
        groceries.addItem("butter", 1);
        groceries.addItem("cereals", 1);
        groceries.removeItem()
        groceries.printList();
    }
    
    public static int menuSelection() {
        
        Scanner s = new Scanner(System.in);
        for(int selection;;) {
            try {
                System.out.println("""
                        0 - shutdown
                        1 - add item(s)
                        2 - remove item(s)""");
                selection = Integer.parseInt(s.nextLine());
                if (selection >= 0 && selection <= 2)
                    return selection;
            } catch (Exception e) {   }
        }
    }   
}