package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

class form6 extends JFrame implements ActionListener {

    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel mno;
    private JLabel gender;
    private JLabel sl;
    private JLabel sur;


    public JRadioButton delet;
    public JRadioButton add;
    public JRadioButton edit1;

    private ButtonGroup gengp;
    private JTextField tid;

    private JButton sub;

    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydb";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";
    static final String QUERY = "SELECT * FROM people";
    long end = System.currentTimeMillis()+15000;
    public form6()
    {
        setTitle("Admin Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("What are u want to do?");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(600, 30);
        title.setLocation(300, 30);
        c.add(title);

        gender = new JLabel("Choose:");
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        gender.setSize(100, 20);
        gender.setLocation(270, 300);
        c.add(gender);

        delet = new JRadioButton("Delete");
        delet.setFont(new Font("Arial", Font.PLAIN, 15));
        delet.setSelected(false);
        delet.setSize(125, 20);
        delet.setLocation(370, 300);
        c.add(delet);

        edit1 = new JRadioButton("Edit");
        edit1.setFont(new Font("Arial", Font.PLAIN, 15));
        edit1.setSelected(false);
        edit1.setSize(80, 20);
        edit1.setLocation(490, 300);
        c.add(edit1);

        add = new JRadioButton("Add");
        add.setFont(new Font("Arial", Font.PLAIN, 15));
        add.setSelected(false);
        add.setSize(80, 20);
        add.setLocation(580, 300);
        c.add(add);

        gengp = new ButtonGroup();
        gengp.add(add);
        gengp.add(delet);
        gengp.add(edit1);

        sub = new JButton("OK");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(420, 450);
        sub.addActionListener(this);
        c.add(sub);



    }
    public void actionPerformed(ActionEvent e) {
        if ((edit1.isSelected() == true)&& (System.currentTimeMillis() < end)) {
            dispose();
            form4 form4 = new form4();
            form4.setVisible(true);
        }else if ((add.isSelected() == true)&& (System.currentTimeMillis() < end)){
            dispose();
            form3 form3 = new form3();
            form3.setVisible(true);
        }else if ((delet.isSelected() == true)&& (System.currentTimeMillis() < end)){
            dispose();
            form5 form5 = new form5();
            form5.setVisible(true);
        }
        else if (System.currentTimeMillis() >  end){
            dispose();
            MyFrame f = new MyFrame();
        }




        }
    }