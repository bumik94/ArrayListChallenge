import java.util.Scanner;
import java.util.Collections;

public class Main {
    
    public static void main(String[] args) {

        GroceryList groceries = new GroceryList(true);
        Menu menu = new Menu(groceries);
        menu.menu();
    }

    public static int getInt() {
        Scanner s = new Scanner(System.in);
        for (;;) {
            try { return Integer.parseInt(s.nextLine()); }
            catch (Exception e) { System.out.print("""
                    [Invalid input]
                    }_""");
            }
        }
    }

    public static String getName() {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

}