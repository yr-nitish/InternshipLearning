import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
 
        person.name = "Nitish Gupta";
        person.nationality = "Indian";
        person.dateOfBirth = "01/01/2011";
        person.passport = new String[]{person.name, person.nationality, person.dateOfBirth};
        person.seatNumber = 15;
        
        System.out.println(person.name);
        System.out.println(person.nationality);
        System.out.println(person.dateOfBirth);
        System.out.println(Arrays.toString(person.passport));
        System.out.println(person.seatNumber);
    }
}
