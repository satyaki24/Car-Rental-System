//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        CarRentalSystem rentalSystem=new CarRentalSystem();

        Car c1=new Car("C001", "Mahindra", "Thar", 60.0);
        Car c2=new Car("C002", "Toyota", "Camary", 150.0);
        Car c3=new Car("C003", "Honda", "City", 110);

        rentalSystem.addCar(c1);
        rentalSystem.addCar(c2);
        rentalSystem.addCar(c3);

        rentalSystem.menu();
    }
}