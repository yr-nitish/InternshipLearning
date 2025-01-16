import java.util.Scanner;
public class Javapedia {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("\n********Javapedia********");
        System.out.println("How many historical figures will you register?");
        int people = sc.nextInt();
        sc.nextLine();
        String[][] db = new String[people][3];

        for (int i = 0; i < db.length; i++) 
        {
            System.out.println("\n\tFigure " + (i+1));
            System.out.print("\t - Name: ");
            db[i][0] = sc.nextLine();
            System.out.print("\t - Date of birth: ");
            db[i][1] = sc.nextLine();
            System.out.print("\t - Occupation: ");
            db[i][2] = sc.nextLine();
            System.out.print("\n");
        }
        System.out.println("These are the values you stored:"); 
        print2DArray(db);

        System.out.print("\nWho do you want information on? "); 
        String name = sc.nextLine();
        
        for (int i = 0; i < db.length; i++) {
            if (db[i][0].equals(name)) {
                System.out.println("\tName: " + db[i][0]);
                System.out.println("\tDate of birth: " + db[i][1]);
                System.out.println("\tOccupation: " + db[i][2]);
            }
        }
        sc.close();
    }

    public static void print2DArray(String[][] array) 
    {
        for (int i = 0; i < array.length; i++) {
            System.out.print("\t");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " "); 
            }
            System.out.print("\n");
        }
    }   
}
