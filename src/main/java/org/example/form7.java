package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

class form7 extends JFrame implements ActionListener {

    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel mno;
    private JTextField tmno;
    private JLabel id;
    private JTextField tid;
    private JButton sub;
    private JLabel res;
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydb";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";
    static final String QUERY = "SELECT * FROM people";
    long end = System.currentTimeMillis()+15000;
    public form7()
    {
        setTitle("Editor Form");
        setBounds(300, 90, 900, 600);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Edit data");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(170, 30);
        title.setLocation(300, 30);
        c.add(title);

        name = new JLabel("Write where change");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(170, 20);
        name.setLocation(250, 100);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(400, 100);
        c.add(tname);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mno = new JLabel("Write what change");
        mno.setFont(new Font("Arial", Font.PLAIN, 20));
        mno.setSize(150, 20);
        mno.setLocation(250, 170);
        c.add(mno);

        tmno = new JTextField();
        tmno.setFont(new Font("Arial", Font.PLAIN, 15));
        tmno.setSize(150, 20);
        tmno.setLocation(400, 170);
        c.add(tmno);

        sub = new JButton("OK");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(350, 480);
        sub.addActionListener(this);
        c.add(sub);

        id = new JLabel("Write id");
        id.setFont(new Font("Arial", Font.PLAIN, 20));
        id.setSize(150, 20);
        id.setLocation(250, 240);
        c.add(id);

        tid = new JTextField();
        tid.setFont(new Font("Arial", Font.PLAIN, 15));
        tid.setSize(150, 20);
        tid.setLocation(400, 240);
        c.add(tid);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);

    }
    public void actionPerformed(ActionEvent e) {


        try (

                Connection conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(QUERY);) {

            int brth = Integer.parseInt(tid.getText());
            String a = tname.getText();
            String adr = tmno.getText();
            if ((e.getSource() == sub)&& (System.currentTimeMillis() < end)) {


                String string2 = String.format("UPDATE mydb.people SET %s = '%s' WHERE id = %d", a, adr, brth);
                stmt.executeUpdate(string2);

                res.setText("Registration Successfully..");
                end = System.currentTimeMillis()+15000;
        }
            else if ((e.getSource() == sub)&& (System.currentTimeMillis() > end)){
            dispose();
            MyFrame f = new MyFrame();
        }




        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }}