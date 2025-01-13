public class Championship {
    public static void main(String[] args) {
        int gryffindor = 850;
        int ravenclaw = 500;

        int pointsMargin = gryffindor-ravenclaw;
        
        if (pointsMargin >= 300) 
        {
            System.out.println("Gryffindor takes the house cup!");
        } 
        else if (pointsMargin >= 0) 
        {
            System.out.println("Gryffindor is in second place");
        } 
        else if (pointsMargin >= -100) 
        {
            System.out.println("Gryffindor is in third place");
        } 
        else 
        {
            System.out.println("Gryffindor is in fourth place");
        }
    }
}
