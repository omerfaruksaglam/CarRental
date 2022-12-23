//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
// Gui.java                                                                        Author: Omer Faruk/Saglam ID: 21996472
//                                                                                      e-mail : omersaglam2001@gmail.com
// All file operations and array creation are making this class.
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

import java.io.*;
import java.util.ArrayList;

public class Model {

    public Model() {
    }
    public ArrayList<Car> getCars() {
        ArrayList<Car> cars = new ArrayList<>();
        try {
            File file = new File("/Users/omersaglam/Documents/IntelliJ Idea/CarRental/src/Cars.txt");
            String value;
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((value = bufferedReader.readLine()) != null) {
                Car car = new Car(value);     // Ozel constructor cagiriyor.
                cars.add(car);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }

    public ArrayList<Client> getClients() {
    ArrayList<Client> clients = new ArrayList<>();
    try {
        File file = new File("/Users/omersaglam/Documents/IntelliJ Idea/CarRental/src/Client.txt");
        String value;
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while((value = bufferedReader.readLine()) != null){
            Client client = new Client(value);
            clients.add(client);
        }
        bufferedReader.close();
    }
    catch (Exception e){
        throw new RuntimeException(e);
    }
    return clients;
    }

    public void setRezervation(String clientid, String plate, String pu_date, String re_date,String pu_loc,String re_loc,
    Boolean cb1,Boolean cb2,Boolean cb3, Boolean cb4, Boolean cb5, String price){
        try {
            File file = new File("/Users/omersaglam/Documents/IntelliJ Idea/CarRental/src/Reservations.txt");
            FileWriter fileWriter = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter out = new PrintWriter(bufferedWriter);
            out.println(clientid+","+plate+","+pu_date+","+re_date+","+pu_loc+"," +re_loc+","+cb1+","+cb2+","+cb3+","+cb4+","+cb5+","+price);
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Reservation> getRezervations(){
        ArrayList<Reservation> reservations = new ArrayList<Reservation>();
        String value;
        try {
            File file = new File("/Users/omersaglam/Documents/IntelliJ Idea/CarRental/src/Reservations.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((value = bufferedReader.readLine()) != null){
                Reservation reservation = new Reservation(value);
                reservations.add(reservation);
                System.out.println("Test    " +reservation.getPlate());
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
        return reservations;
    }

}

