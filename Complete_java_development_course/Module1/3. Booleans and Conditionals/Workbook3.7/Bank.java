import java.util.Scanner;

public class Bank {
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("\n****ROYAL BANK OF JAVA****");
        System.out.println("Are you here to get a mortgage? (yes or no)");
        String decision = sc.nextLine();
        if (decision.equals("yes")) {
            System.out.println("\nGreat! In one line" +
            "\nHow much money do you have in your savings?" +
            "\nAnd, how much do you owe in credit card debt?");
            double savings = sc.nextDouble();
            double debt = sc.nextDouble();
            System.out.println("\nHow many years have you worked for?");
            int numYears = sc.nextInt();
            sc.nextLine();
            System.out.println("What is your name?");
            String name = sc.nextLine();
            if (savings >= 10000 && debt < 5000 && numYears > 2) {
                System.out.println("Congratulations " + name + " you have been approved!");
            } else {
                System.out.println("Sorry, you are not eligible for a mortgage");
            }

        } else {
            System.out.println("\nOK. Have a nice day!");
        }
        sc.close();
    }
}
