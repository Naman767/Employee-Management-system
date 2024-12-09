package Employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View_Employee extends JFrame implements ActionListener {
    JTable table;
    Choice choiceEmp;
    JButton searchBt,print,update,back;
            View_Employee(){
                    getContentPane().setBackground(new Color(255,131,122));

                    JLabel search = new JLabel("Search By Employee ID");
                    search.setBounds(20,20,150,20);
                    add(search);

                    choiceEmp = new Choice();
                    choiceEmp.setBounds(180,20,150,20);
                    add(choiceEmp);

                    try{
                            Conn c = new Conn();
                        ResultSet resultSet = c.statement.executeQuery("select *from employee");
                        while (resultSet.next()){
                            choiceEmp.add(resultSet.getString("empid"));
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                table = new JTable();
                    try{
                            Conn c = new Conn();
                            ResultSet resultSet = c.statement.executeQuery("select *from employee");
                            table.setModel(DbUtils.resultSetToTableModel(resultSet));       //Table set module for visualized.
                    }catch (Exception E){
                        E.printStackTrace();
                    }

                    JScrollPane jp = new JScrollPane(table);        //used to scrolling table for data visual.
                    jp.setBounds(0,100,900,600);
                    add(jp);

                    searchBt = new JButton("Search");               //Search button on table.
                    searchBt.setBounds(20,70,80,20);
                    searchBt.addActionListener(this);
                    add(searchBt);

                    print = new JButton("Print");                  //Print button on table.
                    print.setBounds(120,70,80,20);
                    print.addActionListener(this);
                    add(print);

                    update = new JButton("Update");             //Update button on table.
                    update.setBounds(220,70,80,20);
                    update.addActionListener(this);
                    add(update);


                    back = new JButton("Back");                 //Back button on table.
                    back.setBounds(320,70,80,20);
                    back.addActionListener(this);
                    add(back);

                    setSize(900,700);
                    setLayout(null);
                    setLocation(300,100);
                    setVisible(true);
            }
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == searchBt){            //searchBt fetching data form database to resultSet to print in table.
                    String query = "select *from employee where empid = '"+choiceEmp.getSelectedItem()+"'";
                    try{
                        Conn c = new Conn();
                        ResultSet resultSet = c.statement.executeQuery(query);
                        table.setModel(DbUtils.resultSetToTableModel(resultSet));
                    }catch (Exception E){
                        E.printStackTrace();
                    }

                } else if (e.getSource() == print) {            //condition for Print Button.
                    try{
                        table.print();
                    }catch (Exception E){
                        E.printStackTrace();
                    }

                } else if (e.getSource()== update) {            //condition for Update Button.
                    setVisible(false);
                    new UpdateEmployee(choiceEmp.getSelectedItem());

                }else {
                    setVisible(false);
                    new Main_Class();
                }
            }
    public static void main(String[] args) {
        new View_Employee();
    }
}
