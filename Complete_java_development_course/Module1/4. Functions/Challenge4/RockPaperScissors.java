import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Let's play Rock Paper Scissors.");
        System.out.println("When I say 'shoot', Choose: rock, paper, or scissors.\n");
        System.out.println("Are you ready? Write 'yes' if you are.");
        String ready = sc.nextLine();

        if (ready.equals("yes")) {
            System.out.println("\nGreat!");
            System.out.println("rock - paper - scissors, shoot!");
            String userChoice=sc.next();
            String computerChoice=computerChoice();
            String result=result(userChoice, computerChoice);
            printResult(userChoice, computerChoice, result);
        }
        else{
            System.out.println("Darn, some other time...");
        }
        sc.close();
    }


    /**
     * Function name: computerChoice - picks a randomly between rock paper and scissors
     * @return
     * Inside the function:
     *   1. Picks a random number between 0 and 2.
     *   2. if 0: returns the choice 'rock'
     *      if 1: returns the choice 'paper'
     *      if 2: returns the choice 'scissors' 
     */
    public static String computerChoice() {
        double randomNumber = Math.random() * 3;
        int integer = (int) randomNumber;

        switch (integer) {
            case 0: return "rock";
            case 1: return "paper";
            case 2: return "scissors";
            default: return "";  //default case not possible.

        }
    }

        /**
     * Function name: result - It returns the result of the game.
     *  @param yourChoice (String)
     *  @param computerChoice (String) 
     *  @return result (String) 
     * 
     * Inside the function:
     *   1. result is "You win" if:
     * 
     *       You: "rock"      Computer: "scissors"
     *       You: "paper"     Computer: "rock"
     *       You: "scissors"  Computer: "paper"
     * 
     *   2. result is "You lose" if:
     * 
     *       Computer: "rock"      You: "scissors"
     *       Computer: "paper"     You: "rock"
     *       Computer: "scissors"  You: "paper"
     * 
     *   3. result is "It's a tie" if:
     * 
     *       your choice equals computer choice.
     *   
     *   4. Otherwise, print "ERROR" and exit the program.
     */

        public static String result(String yourChoice, String computerChoice) {
            String result = "";
            
            if (yourChoice.equals("rock") && computerChoice.equals("scissors")) {
                result = "You win!";
            } else if (yourChoice.equals("rock") && computerChoice.equals("paper")) {
                result = "You lose!";
            } else if (yourChoice.equals("paper") && computerChoice.equals("rock")) {
                result = "You win!";
            } else if (yourChoice.equals("paper") && computerChoice.equals("scissors")) {
                result = "You lose!";
            } else if (yourChoice.equals("scissors") && computerChoice.equals("paper")) {
                result = "You win!";
            } else if (yourChoice.equals("scissors") && computerChoice.equals("rock")) {
                result = "You lose!";
            } else if (yourChoice.equals(computerChoice)) {
                result = "It's a tie!";
            } else {
                System.out.println("INVALID CHOICE");
                System.exit(0);
            }
            return result;
        }


            /**
     * Name: printResult - It prints everything (your choice, computer choice, result)
     * @param yourChoice (String)
     * @param computerChoice (String)
     * @param result (String)
     * 
     * Inside the function:
     *  1. prints everything:
     *      – prints: You chose: (tab of space) <your choice>
     *      – prints: The computer chose: (tab of space) <computer choice>
     *      – prints: <result>
     */

     public static void printResult(String userChoice, String computerChoice, String result) {
        System.out.println("\nYou chose:\t" + userChoice);
        System.out.println("The computer chose:\t" + computerChoice);
        System.out.println(result);
    }
}
