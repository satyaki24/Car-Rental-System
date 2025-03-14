import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
    private List<Car> carList;
    private List<Customer> customerList;
    private List<Rental> rentalList;

    public CarRentalSystem(){
        carList=new ArrayList<>();
        customerList=new ArrayList<>();
        rentalList=new ArrayList<>();
    }

    public void addCar(Car car){
        carList.add(car);
    }

    public void addCustomer(Customer customer){
        customerList.add(customer);
    }

    public void rentCar(Car car, Customer customer, int days){
        if(car.isAvailable()){
            car.rentCar();
            rentalList.add(new Rental(car,customer,days));
        }
        else{
            System.out.println("Car is not available for rent");
        }
    }

    public void returnCar(Car car){
        car.returnCar();
        Rental carToReturn=null;

        for(Rental rental:rentalList){
            if(rental.getCar()==car){
                carToReturn=rental;
                break;
            }
        }
        if(carToReturn!=null){
            rentalList.remove(carToReturn);
//            System.out.println("Car returned successfully");
        }
        else{
            System.out.println("Car was not rented");
        }
    }

    public void menu(){
        Scanner sc=new Scanner(System.in);

        while(true) {
            System.out.println("==== Car Rental System ====");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");

            int choice = sc.nextInt();

            if(choice==1){
                System.out.println("\n === Rent a Car === \n");
                System.out.println("Enter your name: ");
                sc.nextLine();
                String customerName=sc.nextLine();

                System.out.println("Available Cars: ");
                for(Car car:carList){
                    if(car.isAvailable()){
                        System.out.println(car.getCarId() + " - " + car.getBrand() + " - " + car.getModel());
                    }
                }
                System.out.println("Enter the Car ID you want to rent: ");
                String carId=sc.nextLine();

                System.out.println("Enter the number of days you want to rent the car: ");
                int days=sc.nextInt();
                sc.nextLine(); //Consume new line

                Customer newCustomer=new Customer(customerName,"CUS"+ (customerList.size()+1));
                addCustomer(newCustomer);

                Car selectedCar=null;

                for(Car car:carList){
                    if(car.getCarId().equals(carId) && car.isAvailable()){
                        selectedCar=car;
                        break;
                    }
                }

                if(selectedCar!=null){
                    double totalPrice=selectedCar.getRentPerDay(days);
                    System.out.println("\n=== Rental Information ===\n");
                    System.out.println("Customer ID: " + newCustomer.getCustId());
                    System.out.println("Customer Name: " + newCustomer.getCustName());
                    System.out.println("Car: " + selectedCar.getBrand() + " - " + selectedCar.getModel());
                    System.out.println("Rental Days: " + days);
                    System.out.printf("Total Price: $%.2f%n" , totalPrice);

                    System.out.println("Confirm Rental (Y/N): ");
                    String confirm=sc.nextLine();

                    if(confirm.equalsIgnoreCase("Y")){
                        rentCar(selectedCar,newCustomer,days);
                        System.out.println("\nCar rented successfully\n");
                    }
                    else {
                        System.out.println("Renting failed");
                    }
                }
                else{
                    System.out.println("\nInvalid car selection or car not available for rent");
                }
            }
            else if (choice==2) {
                System.out.println("\n=== Return Car ===\n");
                System.out.println("Enter the Car ID of car you want to return");
                sc.nextLine();
                String carId=sc.nextLine();

                Car carToReturn=null;
                for(Car car:carList){
                    if(car.getCarId().equals(carId) && !car.isAvailable()){
                        carToReturn=car;
                        break;
                    }
                }
                if(carToReturn!=null){
                    Customer customer=null;
                    for(Rental rental:rentalList){
                        if(rental.getCar()==carToReturn){
                            customer=rental.getCustomer();
                            break;
                        }
                    }

                    if(customer!=null){
                        returnCar(carToReturn);
                        System.out.println("Car Return Successfully by "+ customer.getCustName());
                    }
                    else{
                        System.out.println("Car was not rented or rental info is missing");
                    }
                }
                else{
                    System.out.println("Invalid Car ID or Car is not rented");
                }
            }
            else if(choice==3){
                break;
            }
            else{
                System.out.println("Invalid choice. Enter a valid choice");
            }
        }
        System.out.println("\n Thank you for using CAR RENTAL SYSTEM\n");
    }
}
