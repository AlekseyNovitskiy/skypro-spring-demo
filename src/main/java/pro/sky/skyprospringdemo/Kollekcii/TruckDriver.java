package pro.sky.skyprospringdemo.Kollekcii;

public class TruckDriver extends Driver {


    public TruckDriver(String name, String surname, String passport, String driverLicenseNumber, int professionNumber) {
        super(name, surname, passport, driverLicenseNumber, professionNumber);
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        // номер водительского удостоверения должен начинаться на двойку
        if (driverLicenseNumber != null && driverLicenseNumber.startsWith("2")) {
            // вызываем сеттер из класса Driver
            super.setDriverLicenseNumber(driverLicenseNumber);
        }
    }
}
