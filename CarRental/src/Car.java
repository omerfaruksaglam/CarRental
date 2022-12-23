//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
// Gui.java                                                                        Author: Omer Faruk/Saglam ID: 21996472
//                                                                                      e-mail : omersaglam2001@gmail.com
// Definition of the Car class.
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
public class Car {
    private String plate;
    private String marka;
    private String fuel;
    private String number_of_door;
    private String gear;
    private Double price;
    private String smoker;

    public Car() {

    }

    public Car(String plate, String marka, String model, String number_of_door, Double price, String gear, String smoker) {
        this.plate = plate;
        this.marka = marka;
        this.fuel = model;
        this.number_of_door = number_of_door;
        this.price = price;
        this.gear = gear;
        this.smoker = smoker;
    }
    public Car(String seperator) {
        String[] arrOfStr = seperator.split(",");
        this.plate = arrOfStr[0];
        this.marka = arrOfStr[1];
        this.fuel = arrOfStr[2];
        this.number_of_door = arrOfStr[3];
        this.gear = arrOfStr[4];
        this.price = Double.valueOf(arrOfStr[5]);
        this.smoker = arrOfStr[6];
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String model) {this.fuel = model; }

    public String getNumber_of_door() {
        return number_of_door;
    }

    public void setNumber_of_door(String number_of_door) {
        this.number_of_door = number_of_door;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public String getSmoker() {
        return smoker;
    }

    public void setSmoker(String smoker) {
        this.smoker = smoker;
    }

    @Override
    public String toString() {
        return this.plate + ", " + this.marka + ", " + this.fuel + ", " + this.number_of_door + ", " + this.gear + ", " + this.price +"₺";
    }
}
