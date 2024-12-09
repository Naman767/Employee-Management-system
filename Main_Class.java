package Employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Class extends JFrame {

    public Main_Class(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/home.jpg"));  //set Image of home screen on frame.
        Image i2 = i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,1120,630);
        add(img);

        JLabel heading = new JLabel("Employee Management System ");             //JLabel of Employee Management.
        heading.setBounds(340,155,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        img.add(heading);

        JButton add = new JButton("Add Employee");                  //Add Employee button.
        add.setBounds(335,270,150,40);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.black);
        add.addActionListener(new ActionListener() {                    //Action performed in action listener.
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployee();
                setVisible(false);
            }
        });
        img.add(add);


        JButton view = new JButton("View Employee");                //View employee button.
        view.setBounds(565,270,150,40);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.black);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new View_Employee();
                setVisible(false);
            }
        });
        img.add(view);


        JButton rem = new JButton("Remove Employee");                   //Remove employee button.
        rem.setBounds(440,370,150,40);
        rem.setForeground(Color.WHITE);
        rem.setBackground(Color.black);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   new RemoveEmployee();
            }
        });
        img.add(rem);

        setSize(1120,630);                  //set frame size.
        setLocation(250,100);                     //set frame location.
        setLayout(null);                                //set frame Layout.
        setVisible(true);                               // show frame on display screen.
    }
    public static void main(String[] args) {
        new Main_Class();
    }               //main class obj.
}
