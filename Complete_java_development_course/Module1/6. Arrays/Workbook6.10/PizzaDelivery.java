import java.util.Scanner;

public class PizzaDelivery {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("How many pizza toppings do you want?");
        int numToppings = sc.nextInt(); 
        sc.nextLine();
        String[] toppings = new String[numToppings];

        System.out.println("Great, enter each topping!");
        for (int i = 0; i < toppings.length; i++) {
            System.out.print(i + ". ");
            toppings[i] = sc.nextLine();
        }

        System.out.println("\nThank you! Here are the toppings you ordered");
        for (int i = 0; i < toppings.length; i++) {
            System.out.println(i + ". " + toppings[i]);        
        }
        System.out.println("\nPress anything to confirm your order.");
        sc.nextLine();
        System.out.println("Great, a driver is on the way!");
        sc.close();
    }
}
