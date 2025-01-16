public class RandomNumbers {
    public static void main(String[] args) {
        int[][] array = new int[100][10];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = randomNumber();
            }
        }
        print2DArray(array);
    }
    /**
     * Function name: randomNumber.
     * 
     * @return randomNumber (int)
     * 
     * Inside the function:
     *    1. return a random number between 0 and 99. 
     */

     public static int randomNumber() {
        double randomNumber = Math.random()*100;
        return (int)randomNumber;
    }

    /**
     * Function name: print2DArray
     * @param array ( int[][] )
     *
     * Inside the function:
     *  1. print the array such that:
     *        Each row takes up one line.
     *        There's a space between each value.
     */

    public static void print2DArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
