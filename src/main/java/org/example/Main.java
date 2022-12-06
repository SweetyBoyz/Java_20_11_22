package org.example;// Java program to implement
// a Simple Registration Form
// using Java Swing

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

import java.util.Objects;
import java.util.Scanner;

class MyFrame extends JFrame implements ActionListener {

    private Container c;

    private JLabel title;

    private JLabel name;
    private JTextField tname;
    private JLabel pass;
    private JPasswordField pass_wr;
    private JLabel gender;
    private JRadioButton adm;
    private JRadioButton edit;
    private JRadioButton user;

    private ButtonGroup gengp;

    private JButton sub;
    ArrayList<String> names_for_user = new ArrayList<>();
    ArrayList<String> passwords_for_user = new ArrayList<>();
    ArrayList<String> names_for_edit = new ArrayList<>();
    ArrayList<String> passwords_for_edit = new ArrayList<>();
    ArrayList<String> names_for_adm = new ArrayList<>();
    ArrayList<String> passwords_for_adm = new ArrayList<>();
    public MyFrame()
    {
        setTitle("Registration Form");
        setBounds(300, 90, 900, 600);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        title = new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 25));
        name.setSize(100, 20);
        name.setLocation(300, 150);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(370, 150);
        c.add(tname);

        pass = new JLabel("Password");
        pass.setFont(new Font("Arial", Font.PLAIN, 20));
        pass.setSize(100, 20);
        pass.setLocation(300, 220);
        c.add(pass);

        pass_wr = new JPasswordField();
        pass_wr.setFont(new Font("Arial", Font.PLAIN, 15));
        pass_wr.setSize(150, 20);
        pass_wr.setLocation(400, 220);
        c.add(pass_wr);

        gender = new JLabel("User Type");
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        gender.setSize(100, 20);
        gender.setLocation(200, 300);
        c.add(gender);

        adm = new JRadioButton("Administrator");
        adm.setFont(new Font("Arial", Font.PLAIN, 15));
        adm.setSelected(false);
        adm.setSize(125, 20);
        adm.setLocation(300, 300);
        c.add(adm);

        user = new JRadioButton("User");
        user.setFont(new Font("Arial", Font.PLAIN, 15));
        user.setSelected(false);
        user.setSize(80, 20);
        user.setLocation(425, 300);
        c.add(user);

        edit = new JRadioButton("Editor");
        edit.setFont(new Font("Arial", Font.PLAIN, 15));
        edit.setSelected(false);
        edit.setSize(80, 20);
        edit.setLocation(510, 300);
        c.add(edit);

        gengp = new ButtonGroup();
        gengp.add(adm);
        gengp.add(user);
        gengp.add(edit);

        sub = new JButton("Log in");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(380, 450);
        sub.addActionListener(this);
        c.add(sub);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e)

    {
        names_for_user.add("John");
        passwords_for_user.add("123");
        names_for_adm.add("Boo");
        passwords_for_adm.add("1234");
        names_for_edit.add("Max");
        passwords_for_edit.add("321");
            if (e.getSource() == sub) {
                if (user.isSelected() == true) {
                    if (names_for_user.contains(tname.getText()) & passwords_for_user.contains(pass_wr.getText())) {
                        form2 form2 = new form2();
                        form2.setVisible(true);
                    }
                } else if (adm.isSelected() == true) {
                    if (names_for_adm.contains(tname.getText()) & passwords_for_adm.contains(pass_wr.getText())) {
                        dispose();
                        form6 form6 = new form6();
                        form6.setVisible(true);
                    }

                }else if (edit.isSelected() == true) {
                    if (names_for_edit.contains(tname.getText()) & passwords_for_edit.contains(pass_wr.getText())) {
                        dispose();
                        form7 form7 = new form7();
                        form7.setVisible(true);

                    }

                }

            }
}}

class Main {

    public static void main(String[] args) throws Exception
    {
        MyFrame f = new MyFrame();

    }
}
