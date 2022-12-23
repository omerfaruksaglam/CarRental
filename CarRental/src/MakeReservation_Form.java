//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
// Gui.java                                                                        Author: Omer Faruk/Saglam ID: 21996472
//                                                                                      e-mail : omersaglam2001@gmail.com
// The class in which the reservation is make in.
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakeReservation_Form implements ActionListener {
    JFrame jframe;
    JButton search_client_button, search_car_button, confirm_button;
    JTextField client_id, puLocation,reLocation,puDate,reDate;
    JComboBox<String> gear, fuel,vehicle_group,smoking, availibleCars;
    JLabel label, offerLabel, resultLabel = new JLabel();
    JCheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;
    Model model = new Model();
    String[] _gears = {"Automatic", "Manuel"};
    String[] _fuelTypes = {"Diesel", "Benzine", "Electric"};
    String[] _vehicleGroups = {"4Doors", "2Doors"};
    String[] _smoking = {"Smoker", "Nonsmoker"};

    public MakeReservation_Form(){
        jframe = new JFrame("Make Rezervation ");
        client_id = new JTextField("Enter client_id",20);
        search_client_button = new JButton("Search");
        jframe.setSize(500,600);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
        label = new JLabel(" ");
        offerLabel = new JLabel(" special weekend rate to attract nonbusiness customers.");

        puLocation = new JTextField("Enter pick up location : ");
        reLocation = new JTextField("Enter return location : ");
        puDate = new JTextField("Enter pick up date ( dd.mm.yy ) :");
        reDate = new JTextField("Enter return date ( dd.mm.yy ) :");
        search_car_button = new JButton("Search Available Cars");

        gear = new JComboBox<>(_gears);
        fuel = new JComboBox<>(_fuelTypes);
        vehicle_group = new JComboBox<>(_vehicleGroups);
        smoking = new JComboBox<>(_smoking);
        availibleCars = new JComboBox<>();
        confirm_button = new JButton(" Confirm ");

        checkBox1 = new JCheckBox("Roof Rack ( +100 ₺ )",true);
        checkBox2 = new JCheckBox("Trailer ( +60 ₺ )",false);
        checkBox3 = new JCheckBox("Snow Chains ( +150 ₺ )",false);
        checkBox4 = new JCheckBox("Navigation ( +125 ₺ )",false);
        checkBox5 = new JCheckBox("Child Seats ( +140 ₺ )",false);

        Container c = jframe.getContentPane();
        c.setLayout(new FlowLayout());
        c.add(client_id);
        c.add(search_client_button);
        c.add(label);

        c.add(puLocation);
        c.add(reLocation);
        c.add(puDate);
        c.add(reDate);

        c.add(gear);
        c.add(fuel);
        c.add(vehicle_group);
        c.add(smoking);
        c.add(search_car_button);
        c.add(availibleCars);
        c.add(resultLabel);

        c.add(checkBox1);
        c.add(checkBox2);
        c.add(checkBox3);
        c.add(checkBox4);
        c.add(checkBox5);
        c.add(confirm_button);

        search_client_button.addActionListener(this);
        search_car_button.addActionListener(this);
        gear.addActionListener(this);
        fuel.addActionListener(this);
        smoking.addActionListener(this);
        vehicle_group.addActionListener(this);
        confirm_button.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search_client_button) {
            System.out.println(client_id.getText() + " searchbutton");
            for (Client client : model.getClients()) {
                if (client.getClient_id() == Integer.parseInt(client_id.getText())) {
                    System.out.println("Client have found succesfully !");
                    label.setText(client.toString());
                    System.out.println(client.toString());
                    break;
                }
                else{
                    System.out.println("Client is not found !");
                    label.setText("Client is not found !");
                }
            }
        }
        if(e.getSource() == search_car_button){
            int count = 0;
            for (Car car : model.getCars()){
                if(gear.getSelectedItem().equals(car.getGear()) && fuel.getSelectedItem().equals(car.getFuel())
                        && vehicle_group.getSelectedItem().equals(car.getNumber_of_door()) && smoking.getSelectedItem().equals(car.getSmoker())) {
                    System.out.println(car.toString());
                    availibleCars.addItem(car.toString());
                    count++;
                }
            }
            if(count == 0){
                System.out.println("No vehicles found for your search criteria");
                resultLabel.setText("No vehicles found for your search criteria");
            }
            System.out.println("kiraladıgınz arac " + availibleCars.getSelectedItem());
            resultLabel.setText( "Preview \nYour choice : "+ availibleCars.getSelectedItem());
        }

        if(e.getSource() == confirm_button){
            String[] s = availibleCars.getSelectedItem().toString().split(",");

            //Invoice inner class.
            class Invoice extends JFrame{
                void PrintInvoice(String clientid, String plate, String pu_date, String re_date,String pu_loc,String re_loc,
                                  Boolean cb1,Boolean cb2,Boolean cb3, Boolean cb4, Boolean cb5, String price){
                    JFrame jf = new JFrame();
                    jf.setTitle("Invoice");
                    jf.setLocationRelativeTo(null);
                    jf.pack();
                    jf.setSize(600,600);
                    jf.setVisible(true);
                    Container container = jf.getContentPane();

                    Car c = new Car();
                    for(Car car : model.getCars()){
                        if (car.getPlate().equals(plate)) {
                            c = car;
                        }
                    }
                    Client client = new Client();
                    for (Client client1 : model.getClients()){
                        if (client1.getClient_id() == Integer.parseInt(clientid)) {
                            client = client1;
                        }
                    }

                    JTextArea textArea = new JTextArea();
                    textArea.setBounds(111,111,300,350);
                    textArea.append("\t\tINVOICE\n\nPersonal informations ;\nClient ID : "+client.getClient_id()+"\nName : "+client.getName()+
                            "\nSurname : "+ client.getSurname()+"\nFrom : "+ client.getCity()+"\nBusiness : "+ client.getBusiness()+"\nBirth Year : "+ client.getBirth_year() +
                            "\n------------------------\nSelected Car informations : \nPlate : " + c.getPlate() + "\nBrand : "+ c.getMarka()+
                            "\nFuel Type : " + c.getFuel()+"\nGear : "+c.getGear()+"\nCar Type : "+c.getNumber_of_door()+"\nIs Smoking : "+ c.getSmoker()+"\nPrice per day : "+c.getPrice()+" ₺"+
                    "\n----------------"+"\nYou pick up the car from : " + pu_loc + "  -- to -->  "+re_loc + "  give car back : "+re_loc+"\nYou pick up the car on : "+pu_date +" -- give back on -->  " +re_date);

                    int total_price = (int) (c.getPrice()*findDay(pu_date.toString(),re_date));
                    textArea.append("\n----------------\n\tOrder Summary ; \n" +
                            findDay(pu_date,re_date) +" day Car rent price = " + total_price+" ₺");
                    textArea.append("\n  Your extras : \n");
                    if (cb1.equals(true)) {
                        textArea.append(" Roof Rack ( +100 ₺ ) \n");
                        total_price +=100;
                    }
                    if (cb2.equals(true)){
                        textArea.append(" Trailer ( +60 ₺ ) \n");
                        total_price += 60;
                    }
                    if (cb3.equals(true)){
                        textArea.append(" Snow Chains ( +150 ₺ ) \n");
                        total_price +=150;
                    }
                    if (cb4.equals(true)){
                        textArea.append(" Navigation ( +125 ₺ ) \n");
                        total_price +=125;
                    }
                    if (cb5.equals(true)){
                        textArea.append(" Child Seats ( +140 ₺ ) \n");
                        total_price +=140;
                    }
                    textArea.append("\n Total price is\t : " +total_price +"\n\tHAVE A NICE DAYS .. We are waiting for you again :)");
                    container.add(textArea);
                    container.setLayout(new FlowLayout());

                    model.setRezervation(client_id.getText(),s[0],puDate.getText(),reDate.getText(),puLocation.getText(),reLocation.getText(),
                            checkBox1.isSelected(),checkBox2.isSelected(), checkBox3.isSelected(),checkBox4.isSelected(),checkBox5.isSelected(), String.valueOf(total_price));
                }
                public int findDay(String dt1, String dt2){
                    // for calculate how many days have rented.
                    String[] pu_day = dt1.split("\\.");
                    String[] re_day = dt2.split("\\.");
                    int day =(( Integer.parseInt(re_day[0])) + (((Integer.parseInt(re_day[1]))-1)*30)) - ((Integer.parseInt(pu_day[0])) + (((Integer.parseInt(pu_day[1]))-1)*30 )) ;
                    return day;
                }
                // end of inner class.
            }
            Invoice invoice = new Invoice();
            invoice.PrintInvoice(client_id.getText(),s[0],puDate.getText(),reDate.getText(),puLocation.getText(),reLocation.getText(),
                   checkBox1.isSelected(),checkBox2.isSelected(),checkBox3.isSelected(), checkBox4.isSelected(),checkBox5.isSelected(),"");
        }

    }

}
