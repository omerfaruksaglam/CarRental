//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
// Gui.java                                                                        Author: Omer Faruk/Saglam ID: 21996472
//                                                                                      e-mail : omersaglam2001@gmail.com
// Main page gui class.
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ActionListener {

    private JLabel rental = new JLabel("Car Rental");
    private JButton make_rezervation_button, search_client_button,
            search_palte_button, exit_button;
    private JTextField textField;

    public Gui() {
        make_rezervation_button = new JButton("                    Make Rezervation                    ");

        search_client_button = new JButton("                     Search client                     ");
        search_palte_button = new JButton("                     Search Plate                     ");
        exit_button = new JButton("                     EXIT                     ");
        textField = new JTextField("....");

        JFrame frame = new JFrame();
        frame.setTitle("Car Rental");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setSize(600,300);
        frame.setVisible(true);

        Container c = frame.getContentPane();
        //c.add(rental);
        c.add(make_rezervation_button);
        c.add(search_client_button);
        c.add(search_palte_button);
        c.add(exit_button);
        c.setLayout(new FlowLayout());

        make_rezervation_button.addActionListener(this);
        exit_button.addActionListener(this);
        search_palte_button.addActionListener(this);
        search_client_button.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit_button) {
            System.exit(0);
        }
        if (e.getSource() == make_rezervation_button) {
            MakeReservation_Form mk = new MakeReservation_Form();
        }
        if(e.getSource() == search_palte_button){
            Search_by_plate_Form sp = new Search_by_plate_Form();
        }
        if(e.getSource() == search_client_button) {
            Search_by_id_Form si = new Search_by_id_Form();
        }
    }
}

