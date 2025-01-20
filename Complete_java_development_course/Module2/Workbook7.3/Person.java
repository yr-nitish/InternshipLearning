public class Person {
    
    private String name;
    private String nationality;
    private String dob;
    private int seatNumber;

    public Person(String name, String nationality, String dob, int seatNumber)
    {
        this.name=name;
        this.nationality=nationality;
        this.dob=dob;
        this.seatNumber=seatNumber;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }

    public String getNationality()
    {
        return nationality;
    }
    public void setNationality(String nationality)
    {
        this.nationality=nationality;
    }

    public String getDob()
    {
        return dob;
    }
    public void setDob(String dob)
    {
        this.dob=dob;
    }

    public int getSeatNumber()
    {
        return seatNumber;
    }
    public void setSeatNumber(int seatNumber)
    {
        this.seatNumber=seatNumber;
    }
}
