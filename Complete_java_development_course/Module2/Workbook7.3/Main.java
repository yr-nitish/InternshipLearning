public class Main {
    public static void main(String[] args) {
        
        Person person = new Person("Nitish", "Indian","01/01/2011",10);
        System.out.println("Before setting different value: \n");
        System.out.println("Name: " +person.getName() + "\n" + "Nationality: " + person.getNationality()+ "\n" + "Date of Birth: " + person.getDob() + "\n" + "Seat number: "+ person.getSeatNumber());
        System.out.println("\nAfter caling setter of Dob: \n");
        person.setSeatNumber(12);
        System.out.println("Name: " +person.getName() + "\n" + "Nationality: " + person.getNationality()+ "\n" + "Date of Birth: " + person.getDob() + "\n" + "Seat number: "+ person.getSeatNumber());
    }
}
