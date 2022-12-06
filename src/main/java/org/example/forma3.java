package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

class form3 extends JFrame implements ActionListener {

    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel mno;
    private JLabel brt;
    private JLabel sl;
    private JLabel sur;

    private JTextField tmno;
    private JTextField tbrt;
    private JTextField tsl;
    private JTextField tsur;

    private JLabel id;
    private JTextField tid;

    private JButton sub;
    private JLabel res;
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydb";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";
    static final String QUERY = "SELECT * FROM people";
    long end = System.currentTimeMillis()+15000;
    public form3()
    {
        setTitle("Add user");
        setBounds(300, 90, 900, 600);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Add user");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(170, 30);
        title.setLocation(300, 30);
        c.add(title);

        name = new JLabel("Write to name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(170, 20);
        name.setLocation(250, 100);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(400, 100);
        c.add(tname);

        mno = new JLabel("Write to adress");
        mno.setFont(new Font("Arial", Font.PLAIN, 20));
        mno.setSize(150, 20);
        mno.setLocation(250, 170);
        c.add(mno);

        tmno = new JTextField();
        tmno.setFont(new Font("Arial", Font.PLAIN, 15));
        tmno.setSize(150, 20);
        tmno.setLocation(400, 170);
        c.add(tmno);

        sub = new JButton("Add");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(350, 480);
        sub.addActionListener(this);
        c.add(sub);

        id = new JLabel("Write to birthday");
        id.setFont(new Font("Arial", Font.PLAIN, 20));
        id.setSize(150, 20);
        id.setLocation(250, 240);
        c.add(id);

        tid = new JTextField();
        tid.setFont(new Font("Arial", Font.PLAIN, 15));
        tid.setSize(150, 20);
        tid.setLocation(400, 240);
        c.add(tid);

        brt = new JLabel("Write to salary");
        brt.setFont(new Font("Arial", Font.PLAIN, 20));
        brt.setSize(150, 20);
        brt.setLocation(250, 310);
        c.add(brt);

        tbrt = new JTextField();
        tbrt.setFont(new Font("Arial", Font.PLAIN, 15));
        tbrt.setSize(150, 20);
        tbrt.setLocation(400, 310);
        c.add(tbrt);

        sl = new JLabel("Write to f.status");
        sl.setFont(new Font("Arial", Font.PLAIN, 20));
        sl.setSize(150, 20);
        sl.setLocation(250, 380);
        c.add(sl);

        tsl = new JTextField();
        tsl.setFont(new Font("Arial", Font.PLAIN, 15));
        tsl.setSize(150, 20);
        tsl.setLocation(400, 380);
        c.add(tsl);

        sur = new JLabel("Write to surname");
        sur.setFont(new Font("Arial", Font.PLAIN, 20));
        sur.setSize(150, 20);
        sur.setLocation(250, 450);
        c.add(sur);

        tsur = new JTextField();
        tsur.setFont(new Font("Arial", Font.PLAIN, 15));
        tsur.setSize(150, 20);
        tsur.setLocation(400, 450);
        c.add(tsur);

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
            int sal = Integer.parseInt(tbrt.getText());
            String a = tname.getText();
            String stts = tsl.getText();
            String adr = tmno.getText();
            String surn = tsur.getText();
            if ((e.getSource() == sub)&& (System.currentTimeMillis() < end)) {


                String data = String.format("INSERT INTO People(firstname,surname,address,birth,salary,famaly)" +
                                "VALUES ('%s','%s','%s','%d','%d','%s')",
                        a, surn, adr, brth, sal, stts);
                stmt.executeUpdate(data);
                        res.setText("Registration Successfully..");
                dispose();
                form6 form6 = new form6();
                form6.setVisible(true);
            }
            else if ((e.getSource() == sub)&& (System.currentTimeMillis() > end)){
                dispose();
                MyFrame f = new MyFrame();
            }
            dispose();




        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}