//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
// Gui.java                                                                        Author: Omer Faruk/Saglam ID: 21996472
//                                                                                      e-mail : omersaglam2001@gmail.com
// Search clients and calculate which client is how many rent a car.
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Search_by_id_Form extends JFrame implements ActionListener {

    JFrame jframe;
    JTextField index;
    JButton buton;
    JTextArea area;
    Model model = new Model();

    public Search_by_id_Form() {
        jframe = new JFrame(" Search_By_ID ");
        jframe.setSize(1200,600);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);

        index = new JTextField("Enter client_id");
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
            for (Client client : model.getClients()){
                if (index.getText().equals(String.valueOf(client.getClient_id())))
                    area.append("Client informations \n"+client.toString()+"\n\n");
            }
            for(Reservation reservation : model.getRezervations()){
                if(reservation.getClient_id().equals(index.getText())){
                    area.append(reservation.toString() +"\n" );
                    sum += reservation.getPrice();
                    count++;
                }
            }
            area.append("\n Total money brought of this client : " +sum);
            area.append("\n This client rented a car " +count + "times .");
        }
    }
}
