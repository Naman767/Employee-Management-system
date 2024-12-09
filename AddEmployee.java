package Employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee  extends JFrame implements ActionListener {

        Random ran = new Random();
        int number = ran.nextInt(999999);
        JTextField tname,tfname,taddress,tphone,taadhar,temail,tsalary,tdesignation;
        JLabel tempid;
        JDateChooser    tdob;
        JComboBox boxeducation;
        JButton add,back;
    AddEmployee() {

        getContentPane().setBackground(new Color(163,255,188));

        JLabel heading = new JLabel("Add Employee Details");                //JLabels on frame.
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("Name");                                   //JLabels on frame.
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        tname = new JTextField();
        tname.setBounds(200,150,150,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);

        JLabel fname = new JLabel("Father's Name");                         //JLabels on frame.
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600,150,150,30);
        tfname.setBackground(new Color(177,252,197));
        add(tfname);

        JLabel dob = new JLabel("Date of Birth");                           //Date of Birth Label.
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(200,200,150,30);
        tdob.setBackground(new Color(177,252,197));
        add(tdob);

        JLabel salary = new JLabel("Salary");                               //Salary Label.
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600,200,150,30);
        tsalary.setBackground(new Color(177,252,197));
        add(tsalary);


        JLabel address = new JLabel("Address");                             //Address Label.
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200,250,150,30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);

        JLabel phone = new JLabel("Phone");                                 //Phone Label.
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600,250,150,30);
        tphone.setBackground(new Color(177,252,197));
        add(tphone);

        JLabel email = new JLabel("Email");                                 //email Label.
        email.setBounds(50,300,150,30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(email);

        temail = new JTextField();
        temail.setBounds(200,300,150,30);
        temail.setBackground(new Color(177,252,197));
        add(temail);


        JLabel education = new JLabel("Highest Education");             //education Label.
        education.setBounds(400,300,250,30);
        education.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(education);

        String items[] = {"BBA","B.Tech","BCA","BA","BSC","B.COM","MBA","MCA","MA","M.Tech","MSC","PHD",};
        boxeducation = new JComboBox(items);
        boxeducation.setBackground(new Color(177,252,197));
        boxeducation.setBounds(600,300,150,30);
        add(boxeducation);

        JLabel aadhar = new JLabel("Aadhar Number");                     //JLabel on frame.
        aadhar.setBounds(400,350,150,30);
        aadhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(aadhar);

        taadhar = new JTextField();
        taadhar.setBounds(600,350,150,30);
        taadhar.setBackground(new Color(177,252,197));
        add(taadhar);

        JLabel empid = new JLabel("Employee ID");                       //empId Label.
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empid);

        tempid = new JLabel("" + number);
        tempid.setBounds(200,400,150,30);
        tempid.setFont(new Font("SAN_SARIF",Font.BOLD,20));
        tempid.setForeground(Color.RED);
        add(tempid);

        JLabel designation = new JLabel("Designation");                 //designation Label.
        designation.setBounds(50,350,150,30);
        designation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200,350,150,30);
        tdesignation.setBackground(new Color(177,252,197));
        add(tdesignation);

        add = new JButton("ADD");                                       //Add button.
        add.setBounds(450,550,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");                                     //Back button.
        back.setBounds(250,550,150,40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){                        //All action performed inside of Action Event.
        if(e.getSource() == add){
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String aadhar = taadhar.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String) boxeducation.getSelectedItem();
            String designation  = tdesignation.getText();
            String empid  = tempid.getText();

            try{                                            //Inserting data into text field from database.
                Conn c = new Conn();
                String query = "insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+empid+"') ";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added successfully");
                setVisible(true);
                new Main_Class();

            }catch (Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
            new Main_Class();
        }
    }

    public static void main(String[] args) {
            new AddEmployee();
        }
    }