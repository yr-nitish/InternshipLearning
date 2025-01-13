import java.util.Scanner;

public class Chatbot {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Hello. What is your name?");
        String name = sc.nextLine();

        System.out.println("\nHi "+name+"! I'm Javabot. Where are you from?");
        String home = sc.nextLine();

        System.out.println("\nI hear it's beautiful at "+home+"! I'm from a place called Oracle");
        System.out.println("How old are you?");
        int age = sc.nextInt();

        System.out.println("\nSo you're " + age + ", cool! I'm 400 years old.");
        System.out.println("This means I'm " + 400/age + " times older than you.");
        System.out.println("Enough about me. What's your favourite language? (just don't say Python)");
        sc.nextLine();
        String language = sc.nextLine();

        System.out.println("\n" + language + ", that's great! Nice chatting with you " + name + ". I have to log off now. See ya!");
        sc.close();
    }
}
