package Employee.management.system;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RectangularShape;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{
    JTextField tUsername;
    JPasswordField tPassword;
    JButton login,back;
    Login(){
        JLabel userName = new JLabel("USERNAME ");
        userName.setBounds(40,20,100,30);
        add(userName);

        tUsername = new JTextField();
        tUsername.setBounds(150,20,150,30);
        add(tUsername);

        JLabel password = new JLabel("PASSWORD ");
        password.setBounds(40,70,100,30);
        add(password);

        tPassword = new JPasswordField();
        tPassword.setBounds(150,70,150,30);
        add(tPassword);

        login = new JButton("LOGIN ");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        back = new JButton("BACK ");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("Icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(350,10,600,400);
        add(imgg);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,600,300);
        add(img);


        setSize(600,300);
        setLocation(450,200);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
            if(e.getSource()== login){
                try {
                    String username = tUsername.getText();
                    String password = tPassword.getText();

                    Conn conn = new Conn();
                    String query = "select *from login where username ='"+ username +"' and password = '"+ password +"'";
                    ResultSet resultSet = conn.statement.executeQuery(query);
                    if(resultSet.next()){
                        setVisible(false);
                        new Main_Class();

                    }else {
                        JOptionPane.showMessageDialog(null,"Invalid username or password");
                    }

                }catch (Exception E){
                    E.printStackTrace();
                }
            } else if (e.getSource()== back) {
                System.exit(90);
            }
    }
    public static void main(String[] args) {
        new Login();
    }

}
