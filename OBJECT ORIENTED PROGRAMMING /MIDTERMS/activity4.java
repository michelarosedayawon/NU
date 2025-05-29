import java.util.Scanner;

class Vehicle {
    private String brand;
    private String model;
    private double distance;

    public Vehicle(String brand, String model, double distance) {
        this.brand = brand;
        this.model = model;
        this.distance = distance;
    }

    public String getTatak(){return brand; }
    public String getMowdeeeewl(){return model;}
    public double getKM() {return distance;}
    public double kalkyulateFUELEfficienZ(){ return 0;}

    public void displayInfo() {
        System.out.printf("Vehicle: %s %s\n", brand, model);
        System.out.printf("Distance Traveled: %.1f km\n", distance);
    }
}

class Car extends Vehicle {
    private double fuelNaaaaGinaaaamit;

    public Car(String brand, String model, double distance, double fuel_used) {
        super(brand, model, distance); this.fuelNaaaaGinaaaamit = fuel_used;
    }

    @Override
    public double kalkyulateFUELEfficienZ() {
        return getKM() / fuelNaaaaGinaaaamit;
    }
}

class Bike extends Vehicle {
    private final double motorbikefuelNaGinamit = 3.5;

    public Bike(String brand, String model, double distance) {
        super(brand, model, distance);
    }

    @Override
    public double kalkyulateFUELEfficienZ() {
        return getKM() / motorbikefuelNaGinamit;
    }
}

class Truck extends Vehicle {
    private double fuelNaaaaGinaaaamit;

    public Truck(String brand, String model, double distance, double fuelUsed) {
        super(brand, model, distance); this.fuelNaaaaGinaaaamit = fuelUsed;
}

    @Override
    public double kalkyulateFUELEfficienZ() {
        return getKM() / fuelNaaaaGinaaaamit;
    }
}

public class activity4 {

    public static double ayokoNaNgInvalid(Scanner mosh, String prompt) {
        double input;
        while (true) {
            System.out.print(prompt);
            if (mosh.hasNextDouble()) {
                input = mosh.nextDouble();
                if (input >= 0) {
                    break;
                } else {
                    System.out.println("Invalid besh");
                }
            } else {
                System.out.println("Invalid besh. Please enter again.");
                mosh.next();
            }
        }
        return input;
    }

    public static void displayVEHicleInfooo(Vehicle car, Vehicle bike, Vehicle truck) {
        System.out.println("");
        System.out.println("---------------------------------");
        System.out.println("======== Vehicle Summary ========");
        System.out.println("");

        car.displayInfo();
        System.out.printf("Fuel Efficiency: %.2f km/l\n\n", car.kalkyulateFUELEfficienZ());

        bike.displayInfo();
        System.out.printf("Fuel Efficiency: %.2f km/l\n\n", bike.kalkyulateFUELEfficienZ());

        truck.displayInfo();
        System.out.printf("Fuel Efficiency: %.2f km/l\n", truck.kalkyulateFUELEfficienZ());
        System.out.println("---------------------------------");
    }
    public static void main(String[] args) {
        Scanner mosh = new Scanner(System.in);

        System.out.println("Enter details for a Car");
        System.out.print("Brand: ");
        String carBrand = mosh.nextLine();
        
        System.out.print("Model: ");
        String carModel = mosh.nextLine();
        
        double carDistance = ayokoNaNgInvalid(mosh, "Distance Travelled (km): ");
        double carFuel = ayokoNaNgInvalid(mosh, "Fuel Used (liters): ");
        mosh.nextLine();
        
        Car broombroom = new Car(carBrand, carModel, carDistance, carFuel);

        System.out.println("");
        System.out.println("Enter details for a Bike");
        System.out.print("Brand: ");
        String bikeBrand = mosh.nextLine();
        
        System.out.print("Model: ");
        String bikeModel = mosh.nextLine();
        
        double bikeDistance = ayokoNaNgInvalid(mosh, "Distance Travelled (km): ");
        mosh.nextLine();
        
        Bike bike = new Bike(bikeBrand, bikeModel, bikeDistance);

        System.out.println("");
        System.out.println("Enter details for a Truck");
        System.out.print("Brand: ");
        String truckBrand = mosh.nextLine();
        
        System.out.print("Model: ");
        String truckModel = mosh.nextLine();
        
        double truckDistance = ayokoNaNgInvalid(mosh, "Distance Travelled (km): ");
        double truckFuel = ayokoNaNgInvalid(mosh, "Fuel Used (liters): ");
        
        Truck truck = new Truck(truckBrand, truckModel, truckDistance, truckFuel);

        displayVEHicleInfooo(broombroom, bike, truck);
    }
}