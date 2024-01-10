/*
  Prototype Design Pattern : Creational Pattern
    Intent :
       Specify the kinds of objects to create using a prototypical instance,
       and create new objects by copying this prototype.
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


abstract class Vehicle {

    private final String brand;
    private final String model;
    private final String color;

    public Vehicle(String brand, String model, String color) {
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    protected Vehicle(Vehicle vehicle) {
        this.brand = vehicle.brand;
        this.model = vehicle.model;
        this.color = vehicle.color;
    }

    public abstract Vehicle clone();

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

}
 class VehicleCache {

    private final Map<String, Vehicle> cache = new HashMap<>();

    public VehicleCache() {
        Car car = new Car("Bugatti", "Chiron", "Blue", 261);
        Bus bus = new Bus("Mercedes", "Setra", "White", 48);

        cache.put("Bugatti Chiron", car);
        cache.put("Mercedes Setra", bus);
    }

    public Vehicle get(String key) {
        return cache.get(key).clone();
    }

    public void put(List<Vehicle> vehicles) {
        vehicles.forEach(vehicle -> cache.put(vehicle.getBrand() + " " + vehicle.getModel(), vehicle));
    }

}

class Car extends Vehicle {

    private final int maxSpeed;

    public Car(String brand, String model, String color, int maxSpeed) {
        super(brand, model, color);
        this.maxSpeed = maxSpeed;
    }

    protected Car(Car car) {
        super(car);
        this.maxSpeed = car.maxSpeed;
    }

    @Override
    public Vehicle clone() {
        return new Car(this);
    }



}

class Bus extends Vehicle {

    private final int capacity;

    public Bus(String brand, String model, String color, int capacity) {
        super(brand, model, color);
        this.capacity = capacity;
    }

    protected Bus(Bus bus) {
        super(bus);
        this.capacity = bus.capacity;
    }

    @Override
    public Vehicle clone() {
        return new Bus(this);
    }

}



public class Exam {
    public static void main(String[] args) {
        List<Vehicle> vehicles = List.of(
                new Car("car_brand", "car_model", "car_color", 300),
                new Bus("bus_brand", "bus_model", "bus_color", 8)
        );

        List<Vehicle> copyList = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            copyList.add(vehicle.clone());
        }

        copyList.forEach(System.out::println);

        System.out.println("==========================================");

        VehicleCache registry = new VehicleCache();
        registry.put(vehicles);
        System.out.println(registry.get("car_brand car_model"));
    }
}
