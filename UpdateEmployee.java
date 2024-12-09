package Employee.management.system;

import com.toedter.calendar.JDateChooser;
import jdk.jfr.RecordingState;

import javax.naming.ldap.ExtendedRequest;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {
    JTextField teducation,tfname,taddress,tphone,taadhar,temail,tsalary,tdesignation;
    JLabel tempid;
    JButton add,back;
    String number;
UpdateEmployee(String number){
    this.number = number;
    getContentPane().setBackground(new Color(163,255,188));

    JLabel heading = new JLabel("Add Employee Details");
    heading.setBounds(320,30,500,50);
    heading.setFont(new Font("serif",Font.BOLD,25));
    add(heading);

    JLabel name = new JLabel("Name");
    name.setBounds(50,150,150,30);
    name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
    add(name);

    JLabel tname = new JLabel();
    tname.setBounds(200,150,150,30);
    tname.setBackground(new Color(177,252,197));
    tname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
    add(tname);

    JLabel fname = new JLabel("Father's Name");                     //Father's name Label.
    fname.setBounds(400,150,150,30);
    fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
    add(fname);

    tfname = new JTextField();
    tfname.setBounds(600,150,150,30);
    tfname.setBackground(new Color(177,252,197));
    add(tfname);

    JLabel dob = new JLabel("Date of Birth");                       //Date of Birth Label.
    dob.setBounds(50,200,150,30);
    dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
    add(dob);

    JLabel tdob = new JLabel();                                         //date of birth as Label.
    tdob.setBounds(200,200,150,30);
    tdob.setFont(new Font("Tahoma",Font.BOLD,20));
    add(tdob);

    JLabel salary = new JLabel("Salary");                           //Salary Label.
    salary.setBounds(400,200,150,30);
    salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
    add(salary);

    tsalary = new JTextField();                                         //salary text field
    tsalary.setBounds(600,200,150,30);
    tsalary.setBackground(new Color(177,252,197));
    add(tsalary);


    JLabel address = new JLabel("Address");                         //Address Label.
    address.setBounds(50,250,150,30);
    address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
    add(address);

    taddress = new JTextField();                                        //address text field.
    taddress.setBounds(200,250,150,30);
    taddress.setBackground(new Color(177,252,197));
    add(taddress);

    JLabel phone = new JLabel("Phone");                             //Phone Label.
    phone.setBounds(400,250,150,30);
    phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
    add(phone);

    tphone = new JTextField();                                          //Phone number text field
    tphone.setBounds(600,250,150,30);
    tphone.setBackground(new Color(177,252,197));
    add(tphone);

    JLabel email = new JLabel("Email");                             //Email Label.
    email.setBounds(50,300,150,30);
    email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
    add(email);

    teducation = new JTextField();                                      //Education text field
    teducation.setBounds(600,300,150,30);
    teducation.setBackground(new Color(177,252,197));
    add(teducation);

    JLabel education = new JLabel("Highest Education");             //Education Label.
    education.setBounds(400,300,250,30);
    education.setFont(new Font("SAN_SERIF",Font.BOLD,20));
    add(education);

    temail = new JTextField();                                     //Email text field.
    temail.setBounds(200,300,150,30);
    temail.setBackground(new Color(177,252,197));
    add(temail);

    JLabel aadhar = new JLabel("Aadhar Number");             //Aadhar Label.
    aadhar.setBounds(400,350,150,30);
    aadhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
    add(aadhar);

   JLabel taadhar = new JLabel();
    taadhar.setBounds(600,350,150,30);
    taadhar.setBackground(new Color(177,252,197));
    taadhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
    add(taadhar);

    JLabel empid = new JLabel("Employee ID");             //employee id Label.
    empid.setBounds(50,400,150,30);
    empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
    add(empid);

    tempid = new JLabel();
    tempid.setBounds(200,400,150,30);
    tempid.setFont(new Font("SAN_SARIF",Font.BOLD,20));
    tempid.setForeground(Color.RED);
    add(tempid);

    JLabel designation = new JLabel("Designation");             //Designation Label.
    designation.setBounds(50,350,150,30);
    designation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
    add(designation);

    tdesignation = new JTextField();                            //Designation text field
    tdesignation.setBounds(200,350,150,30);
    tdesignation.setBackground(new Color(177,252,197));
    add(tdesignation);

    try{
          Conn c = new Conn();
          String query = "select *from employee where empid = '"+number+"'";
          ResultSet resultSet = c.statement.executeQuery(query);

     while (resultSet.next()){                                      //this data is show on frame when click on update button in view employee.
      tname.setText(resultSet.getString("name"));
      tfname.setText(resultSet.getString("fname"));
      tdob.setText(resultSet.getString("dob"));
      taddress.setText(resultSet.getString("address"));
      tsalary.setText(resultSet.getString("salary"));
      tphone.setText(resultSet.getString("phone"));
      temail.setText(resultSet.getString("email"));
      teducation.setText(resultSet.getString("education"));
      taadhar.setText(resultSet.getString("aadhar"));
      tempid.setText(resultSet.getString("empid"));
      tdesignation.setText(resultSet.getString("designation"));
     }
    }catch (Exception e){
      e.printStackTrace();
    }

    add = new JButton("UPDATE");                            //Update button on frame.
    add.setBounds(450,550,150,40);
    add.setBackground(Color.black);
    add.setForeground(Color.WHITE);
    add.addActionListener(this);
    add(add);

    back = new JButton("BACK");                             //Back button on frame.
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
@Override
public void actionPerformed(ActionEvent e){
        if(e.getSource() == add){
           String fname = tfname.getText();
           String salary = tsalary.getText();
           String address = taddress.getText();
           String phone = tphone.getText();
           String email = temail.getText();
           String education = teducation.getText();
           String designation = tdesignation.getText();

           try{
            Conn c = new Conn();
                String query = "update employee set fname = '"+fname+"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"',email = '"+email+"',education = '"+education+"', designation = '"+designation+"' where empid = '"+number+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details update successfully");
                setVisible(false);
                new Main_Class();

           }catch (Exception E){
            E.printStackTrace();
           }
        }else{
         setVisible(false);
         new View_Employee();
        }
}

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
