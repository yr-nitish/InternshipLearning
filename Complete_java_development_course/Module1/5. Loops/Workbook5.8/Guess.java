import java.util.Scanner;

public class Guess {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int number = 4;
        System.out.print("I chose a number between 1 and 5. Try to guess it: ");
        int guess = sc.nextInt();

        while (guess != number) {
            System.out.print("Guess again: ");
            guess = sc.nextInt();
        }

        System.out.println("You got it!");
        sc.close();
    }
}
