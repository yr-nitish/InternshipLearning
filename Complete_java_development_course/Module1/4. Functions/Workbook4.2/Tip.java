public class Tip {
    public static void main(String[] args) {
        double bill=53.5;
        System.out.println("Waiter: I hope you enjoyed your meal!");
        System.out.println("Thank you!");

        tipTheWaiter(bill);
    }

    /**
     * Function name:tipTheWaiter - calculates the tip and prints it.
     * 
     * @param bill
     * 
     * Inside the function:
     * 1. Calculates a top that is 15 percent of the bill.
     * Prints: your service was winderful! Pease, accept thus tip: $<tip>
     */

    public static void tipTheWaiter(double bill)
    {
        double tip=bill*0.15;
        System.out.println("Your Service was Wonderful! Please, accept this tip: $" + tip);
    }
}
