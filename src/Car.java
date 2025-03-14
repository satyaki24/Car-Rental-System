class Car{
    private String carId;
    private String brand;
    private String model;
    private double rentPerDay;
    private boolean isAvailable;

    public Car(String carId, String brand, String model, double rentPerDay){
        this.carId=carId;
        this.brand=brand;
        this.model=model;
        this.rentPerDay=rentPerDay;
        this.isAvailable=true;
    }

    public String getCarId(){
        return carId;
    }

    public String getBrand(){
        return brand;
    }

    public String getModel(){
        return model;
    }

    public double getRentPerDay(int rentalDays) {
        return rentPerDay * rentalDays;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public void rentCar(){
        isAvailable=false;
    }

    public void returnCar(){
        isAvailable=true;
    }
}