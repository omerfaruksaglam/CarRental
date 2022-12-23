//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
// Gui.java                                                                        Author: Omer Faruk/Saglam ID: 21996472
//                                                                                      e-mail : omersaglam2001@gmail.com
// Defnition of the Reservation class).
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

public class Reservation {
private String plate, client_id, pu_loc, re_loc, pu_date, re_date ;
private Double price;

public Reservation(){

}
    public Reservation(String plate, String client_id, String pu_loc, String re_loc, String pu_date, String re_date, Double price) {
        this.plate = plate;
        this.client_id = client_id;
        this.pu_loc = pu_loc;
        this.re_loc = re_loc;
        this.pu_date = pu_date;
        this.re_date = re_date;
        this.price = price;
    }

    public Reservation(String seperator) {
        String[] arr = seperator.split(",");
        this.client_id = arr[0];
        this.plate = arr[1];
        this.pu_date = arr[2];
        this.re_date = arr[3];
        this.pu_loc = arr[4];
        this.re_loc = arr[5];
        this.price = Double.parseDouble(arr[11]);
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getPu_loc() {
        return pu_loc;
    }

    public void setPu_loc(String pu_loc) {
        this.pu_loc = pu_loc;
    }

    public String getRe_loc() {
        return re_loc;
    }

    public void setRe_loc(String re_loc) {
        this.re_loc = re_loc;
    }

    public String getPu_date() {
        return pu_date;
    }

    public void setPu_date(String pu_date) {
        this.pu_date = pu_date;
    }

    public String getRe_date() {
        return re_date;
    }

    public void setRe_date(String re_date) {
        this.re_date = re_date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "plate='" + plate + '\'' +
                ", client_id='" + client_id + '\'' +
                ", pick_up_location='" + pu_loc + '\'' +
                ", return_location='" + re_loc + '\'' +
                ", pick_up_date='" + pu_date + '\'' +
                ", return_date='" + re_date + '\'' +
                ", price=" + price;
    }
}
