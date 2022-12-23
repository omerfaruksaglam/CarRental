//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
// Gui.java                                                                        Author: Omer Faruk/Saglam ID: 21996472
//                                                                                      e-mail : omersaglam2001@gmail.com
// Search plates and calculate which car is how many rented
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Search_by_plate_Form extends JFrame implements ActionListener {

    JFrame jframe;
    JTextField index;
    JButton buton;
    JTextArea area;
    Model model = new Model();

   public Search_by_plate_Form() {
       jframe = new JFrame(" Search_By_Plate ");
       jframe.setSize(1200,600);
       jframe.setLocationRelativeTo(null);
       jframe.setVisible(true);

       index = new JTextField("Enter plate");
       area = new JTextArea();
       buton = new JButton("Search");
       area.setBounds(100,100,1200,500);

       Container c = jframe.getContentPane();
       c.setLayout(new FlowLayout());
       c.add(index);
       c.add(buton);
       c.add(area);
       index.addActionListener(this);
       buton.addActionListener(this);
   }

    @Override
    public void actionPerformed(ActionEvent e) {
       int sum =0;
       int count =0;
        if (e.getSource() == buton){
            for (Car car : model.getCars()){
                if(car.getPlate().equals(index.getText()))
                    area.append("Car informations \n"+car.toString()+"\n\n");
            }
            for(Reservation reservation : model.getRezervations()){
                if(reservation.getPlate().equals(index.getText())){
                    area.append(reservation.toString() +"\n" );
                    sum += reservation.getPrice();
                    count++;
                }
            }
            area.append("\n Total money brought of this car : " +sum);
            area.append("\n This car rented " +count + "times .");
        }
    }
}
