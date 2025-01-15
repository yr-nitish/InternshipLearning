import java.util.Scanner;

public class SignIn {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String username = "Samantha";
        String password = "Java <3";

        System.out.println("\nWelcome to Javagram! Sign in below\n");
        System.out.print("- Username: ");
        String usernameEntry = sc.nextLine();
        System.out.print("- Password: ");
        String passwordEntry = sc.nextLine();

        while (!usernameEntry.equals(username) || !passwordEntry.equals(password)) {
            System.out.println("\nIncorrect, please try again!\n");
            System.out.print("- Username: ");
            usernameEntry = sc.nextLine();
            System.out.print("- Password: ");
            passwordEntry = sc.nextLine();
        }

        System.out.println("\nSign in successful. Welcome!");

        sc.close();
    }
}
