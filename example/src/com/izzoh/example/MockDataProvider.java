package com.izzoh.example;

import java.util.Random;

public class MockDataProvider {
	
	public static Vehicle getRandomVehicle(String name) {
        Vehicle vehicle = null;
        Random random = new Random();
        int type = random.nextInt(3);
        switch (type) {
            case 0:
                vehicle = new Car(name);
                break;
            case 1:
                vehicle = new Bus(name);
                break;
            case 2:
                vehicle = new Bike(name);
                break;
        }
        return vehicle;
    }

}
