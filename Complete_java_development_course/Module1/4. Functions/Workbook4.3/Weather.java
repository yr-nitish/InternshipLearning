public class Weather {
    public static void main(String[] args) {
        double noon = 77;
        double evening=61;
        double midnight=55;

        printTemperatures(noon);
        printTemperatures(evening);
        printTemperatures(midnight);
    }

    /**
     * Function name:fahrenheitToCelcius - converts fahrenheit to celcius
     * @param fahrenheit (double)
     * @return (double)
     * 
     * 
     * Inside the function:
     * 1. return the temperature in celcius. C=(F-32)*5/9.
     */
    public static double fahrenheitToCelsius(double fahrenheit)
    {
        return (fahrenheit-32)*5/9;
    }

    /**
     * function name: printTemperature- it prints the temperature in fahrenheit and celcius
     * @param fahrenheit
     * 
     * Insid ethe function:
     * 1. prints the fahrenheit value 
     * 2. calls fahrenheitToCelcius and prints the celcius value retuned by the function
     */
    public static void printTemperatures(double fahrenheit)
    {
        System.out.println("F: "+fahrenheit);
        System.out.println("C: "+fahrenheitToCelsius(fahrenheit) +"\n");
    }

    
}
