package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

class form2 extends JFrame implements ActionListener {

    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel mno;
    private JLabel lb_sl;
    private JTextField tmno;
    private JLabel id;
    private JTextField tid;
    private JButton gt;
    private JButton sub;
    private JButton sl_bt;
    private JButton reset;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydb";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";
    static final String QUERY = "SELECT * FROM people";
    long end = System.currentTimeMillis()+15000;
    public form2()
    {
        setTitle("User Form");
        setBounds(300, 90, 900, 600);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("User Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        name = new JLabel("Get data on Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(170, 20);
        name.setLocation(25, 100);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(220, 100);
        c.add(tname);

        mno = new JLabel("Get data on birth");
        mno.setFont(new Font("Arial", Font.PLAIN, 20));
        mno.setSize(150, 20);
        mno.setLocation(50, 170);
        c.add(mno);

        tmno = new JTextField();
        tmno.setFont(new Font("Arial", Font.PLAIN, 15));
        tmno.setSize(150, 20);
        tmno.setLocation(200, 170);
        c.add(tmno);

        sub = new JButton("Get");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 130);
        sub.addActionListener(this);
        c.add(sub);

        id = new JLabel("Get data on id");
        id.setFont(new Font("Arial", Font.PLAIN, 20));
        id.setSize(150, 20);
        id.setLocation(50, 240);
        c.add(id);

        tid = new JTextField();
        tid.setFont(new Font("Arial", Font.PLAIN, 15));
        tid.setSize(150, 20);
        tid.setLocation(200, 240);
        c.add(tid);

        gt = new JButton("Get");
        gt.setFont(new Font("Arial", Font.PLAIN, 15));
        gt.setSize(100, 20);
        gt.setLocation(150, 270);
        gt.addActionListener(this);
        c.add(gt);

        reset = new JButton("Get");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(150, 200);
        reset.addActionListener(this);
        c.add(reset);

        lb_sl = new JLabel("Get all salary");
        lb_sl.setFont(new Font("Arial", Font.PLAIN, 20));
        lb_sl.setSize(150, 20);
        lb_sl.setLocation(135, 310);
        c.add(lb_sl);

        sl_bt = new JButton("Get");
        sl_bt.setFont(new Font("Arial", Font.PLAIN, 15));
        sl_bt.setSize(100, 20);
        sl_bt.setLocation(150, 340);
        sl_bt.addActionListener(this);
        c.add(sl_bt);

        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);

        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);}
    public void actionPerformed(ActionEvent e) {
        try (
                Connection conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(QUERY);) {
            int b = Integer.parseInt(tmno.getText());
            int v = Integer.parseInt(tid.getText());
            if ((e.getSource() == sub) && (System.currentTimeMillis() < end)) {
                String a = tname.getText();
                while (rs.next()) {
                    if (Objects.equals(rs.getString("firstname"), a)) {
                        int id = rs.getInt(1);
                        String name = rs.getString(2);
                        String surname = rs.getString(3);
                        String address = rs.getString(4);
                        int birth = rs.getInt(5);
                        int salary = rs.getInt(6);
                        String family = rs.getString(7);
                        String data
                                = String.format(" id: %d,\n name: %s,\n surname: %s,\n address: %s,\n birth: %d,\n salary: %d,\n family: %s",

                                id, name, surname, address, birth, salary, family);


                        tout.setText(data);
                        tout.setEditable(false);
                        res.setText("Registration Successfully..");
                    }
                }end = System.currentTimeMillis()+15000;
            } else if ((e.getSource() == reset) && (System.currentTimeMillis() < end)) {
                while (rs.next()) {
                    if (rs.getInt("birth") == b) {
                        int id = rs.getInt(1);
                        String name = rs.getString(2);
                        String surname = rs.getString(3);
                        String address = rs.getString(4);
                        int birth = rs.getInt(5);
                        int salary = rs.getInt(6);
                        String family = rs.getString(7);
                        String data
                                = String.format(" id: %d,\n name: %s,\n surname: %s,\n address: %s,\n birth: %d,\n salary: %d,\n family: %s",

                                id, name, surname, address, birth, salary, family);


                        tout.setText(data);
                        tout.setEditable(false);
                        res.setText("Registration Successfully..");

                    }
                }
                end = System.currentTimeMillis()+15000;
            } else if ((e.getSource() == gt)&& (System.currentTimeMillis() < end)) {
                while (rs.next()) {
                    if (rs.getInt("id") == v) {
                        int id = rs.getInt(1);
                        String name = rs.getString(2);
                        String surname = rs.getString(3);
                        String address = rs.getString(4);
                        int birth = rs.getInt(5);
                        int salary = rs.getInt(6);
                        String family = rs.getString(7);
                        String data
                                = String.format(" id: %d,\n name: %s,\n surname: %s,\n address: %s,\n birth: %d,\n salary: %d,\n family: %s",

                                id, name, surname, address, birth, salary, family);


                        tout.setText(data);
                        tout.setEditable(false);
                        res.setText("Registration Successfully..");
                    }
                }
                end = System.currentTimeMillis()+15000;
            } else if ((e.getSource() == sl_bt)&& (System.currentTimeMillis() < end)) {

                int sum = 0;
                while (rs.next()) {
                    int salary = rs.getInt(6);
                    sum = sum + salary;
                }
                String data = String.valueOf(sum);
                tout.setText(data);
                tout.setEditable(false);
                res.setText("Registration Successfully..");
                end = System.currentTimeMillis()+15000;
            }
            else if (System.currentTimeMillis() > end){
                dispose();
                MyFrame f = new MyFrame();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}