package pro.sky.skyprospringdemo.Kollekcii;

import pro.sky.skyprospringdemo.Kollekcii.Driver;
import pro.sky.skyprospringdemo.Kollekcii.TruckDriver;

public class PolymorphismExample {
    public static void main(String[] args) {
        Driver driver = new TruckDriver("Макс", "Рокатански", "123", "2456", 1);
        driver.setDriverLicenseNumber("1234");
        System.out.println("driver.getDriverLicenseNumber()= "+ driver.getDriverLicenseNumber());
    }
}
