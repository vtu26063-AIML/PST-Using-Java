import java.util.*;

class Vehicle {
    int vehicleId;
    String modelName;
    double baseRent;

    Vehicle(int vehicleId, String modelName, double baseRent) {
        this.vehicleId = vehicleId;
        this.modelName = modelName;
        this.baseRent = baseRent;
    }

    double calculateRent() {
        return baseRent;
    }
}

class Car extends Vehicle {
    int seats;

    Car(int vehicleId, String modelName, double baseRent, int seats) {
        super(vehicleId, modelName, baseRent);
        this.seats = seats;
    }

    double calculateRent() {
        return baseRent + (seats * 100);
    }
}

class Bike extends Vehicle {
    int engineCapacity;

    Bike(int vehicleId, String modelName, double baseRent, int engineCapacity) {
        super(vehicleId, modelName, baseRent);
        this.engineCapacity = engineCapacity;
    }

    double calculateRent() {
        return baseRent + (engineCapacity * 2);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Vehicle> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            char type = sc.next().charAt(0);
            int id = sc.nextInt();
            String model = sc.next();
            double base = sc.nextDouble();

            if(type == 'C') {
                int seats = sc.nextInt();
                list.add(new Car(id, model, base, seats));
            }
            else if(type == 'B') {
                int engine = sc.nextInt();
                list.add(new Bike(id, model, base, engine));
            }
        }

        for(Vehicle v : list) {
            System.out.println("Vehicle ID: " + v.vehicleId +
                    ", Model: " + v.modelName +
                    ", Total Rent: " + v.calculateRent());
        }

        sc.close();
    }
}