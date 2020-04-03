
public class Vehicle {
    // Variables of Vehicle Class
    private int id;
    private String name;
    private String fuelType;
    private double price;
    private int mileage;

    // Best Practises Variables as private, class, constructor, getters and setters as public;
    //Public Constructor to initialize the values of an Class Object
    public Vehicle(int id, String name, String fuelType, double price, int mileage) {
        this.id = id;
        this.name = name;
        this.fuelType = fuelType;
        this.price = price;
        this.mileage = mileage;
    }

    //getters for accessing the variables of Vehicle Class
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFuelType() {
        return fuelType;
    }

    public double getPrice() {
        return price;
    }

    public int getMileage() {
        return mileage;
    }

    //toString is an Overridden function from Object Class every Class implicitly inherits the Object Class
    // We Can use this function to get the values of a class into a string
    @Override
    public String toString() {
        return id + " " + name + " " + fuelType + " " + mileage;
    }
}
