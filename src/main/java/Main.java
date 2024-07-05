import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        var groceries = new GroceryList(true);
        
        groceries.menu();
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
