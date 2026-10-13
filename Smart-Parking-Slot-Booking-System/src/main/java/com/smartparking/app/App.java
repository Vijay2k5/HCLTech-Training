
package com.smartparking.app;

import com.smartparking.config.ParkingRules;

public class App {
    public static void main(String[] args) {
        System.out.println("Smart Parking Slot Booking System");
        System.out.println("---------------------------------");
        System.out.println("Car hourly rate: Rs. "
                + ParkingRules.CAR_HOURLY_RATE);
        System.out.println("Bike hourly rate: Rs. "
                + ParkingRules.BIKE_HOURLY_RATE);
        System.out.println("EV hourly rate: Rs. "
                + ParkingRules.EV_HOURLY_RATE);
    }
}
