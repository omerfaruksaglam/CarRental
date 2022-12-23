//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
// Gui.java                                                                        Author: Omer Faruk/Saglam ID: 21996472
//                                                                                      e-mail : omersaglam2001@gmail.com
// Definition of the Client class.
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
public class Client {
    private int client_id;
    private String name, surname, city, business;
    private int birth_year;

    public Client(){

    }

    public Client(int client_id, String name, String surname, String city, String business, int birth_year) {
        this.client_id = client_id;
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.business = business;
        this.birth_year = birth_year;
    }
    public Client(String seperator){
        String[] arr  = seperator.split(",");
        this.client_id = Integer.parseInt(arr[0]);
        this.name = arr[1];
        this.surname = arr[2];
        this.city = arr[3];
        this.business = arr[4];
        this.birth_year = Integer.parseInt(arr[5]);
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }

    @Override
    public String toString() {
        return  "id=" + String.valueOf(client_id)+
                ", " + name +
                ", " + surname +
                ", " + city +
                ", " + business +
                ", " + birth_year ;
    }
}
