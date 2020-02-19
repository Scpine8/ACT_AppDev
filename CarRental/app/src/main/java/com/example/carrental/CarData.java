package com.example.carrental;

import java.util.ArrayList;

public class CarData {

    public static ArrayList<Car> cars = new ArrayList<>();

    public static void getData() {
        // car1
        Car lambo = new Car("Lamborghini", R.drawable.lambo, 300, "This car is super fast and is italian");
        // car2
        Car bugatti = new Car("Bugatti", R.drawable.bugatti, 450, "This car is in GTA5");
        // car3
        Car fiat = new Car("Fiat", R.drawable.fiat, 80, "This car seats 2 and is not as cool as the other two cars");
        cars.clear();
        // cars.add(car1)
        cars.add(lambo);
        // cars.add(car2)
        cars.add(bugatti);
        // cars.add(car3)
        cars.add(fiat);
    }
}
