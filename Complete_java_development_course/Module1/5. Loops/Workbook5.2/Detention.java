import java.util.Scanner;

public class Detention {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Hi Bart, I can write lines for you.");
        System.out.println("What do you want me to write?");
        String sentence=sc.nextLine();

        for(int i=0;i<99;i++)
        {
            System.out.println((i+1)+". "+sentence);
        }
        sc.close();
    }
}
