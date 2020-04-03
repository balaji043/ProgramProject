
import java.util.Arrays;
import java.util.Scanner;

public class VehicleSolution {

    public static void main(String[] args) {

        int sizeOfArray = 4; // let n = 4
        Scanner scanner = new Scanner(System.in);
        //array of Vehicle Objects
        Vehicle[] vehicles = new Vehicle[sizeOfArray];
        //get vehicle details from user
        for (int i = 0; i < sizeOfArray; i++)
            vehicles[i] = new Vehicle(scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextDouble(), scanner.nextInt());
        //get required fuelType
        String reqFuelType = scanner.next();
        //get Sorted vehicle list using function getVehiclesSortedByMileageAndFuelType
        Vehicle[] sortedVehicles = getVehiclesSortedByMileageAndFuelType(reqFuelType, vehicles);
        // print each vehicle object details using for loop and overridden toString function
        for (Vehicle v : sortedVehicles)
            System.out.println(v.toString());
    }

    private static Vehicle[] getVehiclesSortedByMileageAndFuelType(String reqFuelType, Vehicle[] vehicles) {
        int sizeOfSortedArray = 0; //initializing to 0

        return (Vehicle[]) Arrays.stream(vehicles).filter(e -> e.getFuelType().equals(reqFuelType)).toArray();
    }
}
