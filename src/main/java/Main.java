import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        GroceryList groceries = new GroceryList();
        Menu menu = new Menu(groceries);
        menu.menu();
    }

    public static int getInt() {
        Scanner s = new Scanner(System.in);
        for (;;) {
            try { return Integer.parseInt(s.nextLine()); }
            catch (Exception e) { System.out.print("""
                    [Invalid input]
                    }""" + " ");
            }
        }
    }

    public static String getString() {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

}