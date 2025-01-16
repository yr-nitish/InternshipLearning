import java.util.Scanner;

public class Grocer {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] store = {"apples", "bananas", "candy", "chocolate", "coffee", "tea"};

        System.out.println("\nWelcome to Java Grocers. ");
        System.out.println("What can I help you find?\n");
        String reply = sc.nextLine();
        for (int i = 0; i < store.length; i++) 
        {
            if (store[i].equals(reply)) {
                System.out.println("\nWe have that in aisle: " + i);
                break;
            }
        }
        sc.close();
    }
    
}
