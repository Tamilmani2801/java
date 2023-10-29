package classes;

public class Tyre 
{
    private String brand;

    public Tyre(String brand) 
    {
        this.brand = brand;
    }

    public String getBrand() 
    {
        return brand;
    }

    @Override
    public String toString() 
    {
        return "Tyre [brand=" + brand + "]";
    }

}
