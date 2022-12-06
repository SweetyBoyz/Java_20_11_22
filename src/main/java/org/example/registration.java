package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.TimerTask;


// Driver Code
class Registration {
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydb";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";
    static final String QUERY = "SELECT * FROM people";

    public static void main(String[] args) throws Exception {
        class form2 extends JFrame implements ActionListener {



            private Container c;
            private JLabel title;
            private JLabel name;
            private JTextField tname;
            private JLabel mno;
            private JTextField tmno;
            private JLabel gender;
            private JRadioButton male;
            private JRadioButton female;
            private ButtonGroup gengp;
            private JLabel dob;
            private JComboBox date;
            private JComboBox month;
            private JComboBox year;
            private JLabel add;
            private JTextArea tadd;
            private JCheckBox term;
            private JButton sub;
            private JButton reset;
            private JTextArea tout;
            private JLabel res;
            private JTextArea resadd;
            public form2()
                {
                    setTitle("Registration Form");
                    setBounds(300, 90, 900, 600);
                    setDefaultCloseOperation(EXIT_ON_CLOSE);
                    setResizable(false);

                    c = getContentPane();
                    c.setLayout(null);

                    title = new JLabel("Registration Form");
                    title.setFont(new Font("Arial", Font.PLAIN, 30));
                    title.setSize(300, 30);
                    title.setLocation(300, 30);
                    c.add(title);

                    name = new JLabel("Name");
                    name.setFont(new Font("Arial", Font.PLAIN, 20));
                    name.setSize(100, 20);
                    name.setLocation(100, 100);
                    c.add(name);

                    tname = new JTextField();
                    tname.setFont(new Font("Arial", Font.PLAIN, 15));
                    tname.setSize(190, 20);
                    tname.setLocation(200, 100);
                    c.add(tname);

                    mno = new JLabel("Mobile");
                    mno.setFont(new Font("Arial", Font.PLAIN, 20));
                    mno.setSize(100, 20);
                    mno.setLocation(100, 150);
                    c.add(mno);

                    tmno = new JTextField();
                    tmno.setFont(new Font("Arial", Font.PLAIN, 15));
                    tmno.setSize(150, 20);
                    tmno.setLocation(200, 150);
                    c.add(tmno);

                    gender = new JLabel("Gender");
                    gender.setFont(new Font("Arial", Font.PLAIN, 20));
                    gender.setSize(100, 20);
                    gender.setLocation(100, 200);
                    c.add(gender);

                    male = new JRadioButton("Male");
                    male.setFont(new Font("Arial", Font.PLAIN, 15));
                    male.setSelected(true);
                    male.setSize(75, 20);
                    male.setLocation(200, 200);
                    c.add(male);

                    female = new JRadioButton("Female");
                    female.setFont(new Font("Arial", Font.PLAIN, 15));
                    female.setSelected(false);
                    female.setSize(80, 20);
                    female.setLocation(275, 200);
                    c.add(female);

                    gengp = new ButtonGroup();
                    gengp.add(male);
                    gengp.add(female);

                    dob = new JLabel("DOB");
                    dob.setFont(new Font("Arial", Font.PLAIN, 20));
                    dob.setSize(100, 20);
                    dob.setLocation(100, 250);
                    c.add(dob);



                    add = new JLabel("Address");
                    add.setFont(new Font("Arial", Font.PLAIN, 20));
                    add.setSize(100, 20);
                    add.setLocation(100, 300);
                    c.add(add);

                    tadd = new JTextArea();
                    tadd.setFont(new Font("Arial", Font.PLAIN, 15));
                    tadd.setSize(200, 75);
                    tadd.setLocation(200, 300);
                    tadd.setLineWrap(true);
                    c.add(tadd);

                    term = new JCheckBox("Accept Terms And Conditions.");
                    term.setFont(new Font("Arial", Font.PLAIN, 15));
                    term.setSize(250, 20);
                    term.setLocation(150, 400);
                    c.add(term);

                    sub = new JButton("Submit");
                    sub.setFont(new Font("Arial", Font.PLAIN, 15));
                    sub.setSize(100, 20);
                    sub.setLocation(150, 450);
                    sub.addActionListener(this);
                    c.add(sub);

                    reset = new JButton("Reset");
                    reset.setFont(new Font("Arial", Font.PLAIN, 15));
                    reset.setSize(100, 20);
                    reset.setLocation(270, 450);
                    reset.addActionListener(this);
                    c.add(reset);

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
                    c.add(resadd);





                }



            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == sub) {
                    if (term.isSelected()) {
                        String data1;
                        String data
                                = "Name : "
                                + tname.getText() + "\n"
                                + "Mobile : "
                                + tmno.getText() + "\n";
                        if (male.isSelected())
                            data1 = "Gender : Male"
                                    + "\n";
                        else
                            data1 = "Gender : Female"
                                    + "\n";
                        String data2
                                = "DOB : "
                                + (String)date.getSelectedItem()
                                + "/" + (String)month.getSelectedItem()
                                + "/" + (String)year.getSelectedItem()
                                + "\n";

                        String data3 = "Address : " + tadd.getText();
                        tout.setText(data + data1 + data2 + data3);
                        tout.setEditable(false);
                        res.setText("Registration Successfully..");
                    }
                    else {
                        tout.setText("");
                        resadd.setText("");
                        res.setText("Please accept the"
                                + " terms & conditions..");
                    }
                }

                else if (e.getSource() == reset) {
                    String def = "";
                    tname.setText(def);
                    tadd.setText(def);
                    tmno.setText(def);
                    res.setText(def);
                    tout.setText(def);
                    term.setSelected(false);
                    date.setSelectedIndex(0);
                    month.setSelectedIndex(0);
                    year.setSelectedIndex(0);
                    resadd.setText(def);
                }


            }
        }




            class MyFrame extends JFrame implements ActionListener {
                private Container c;
                private Container r;
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
                private JButton reset;
                ArrayList<String> names_for_user = new ArrayList<>();
                ArrayList<String> passwords_for_user = new ArrayList<>();
                ArrayList<String> names_for_edit = new ArrayList<>();
                ArrayList<String> passwords_for_edit = new ArrayList<>();
                ArrayList<String> names_for_adm = new ArrayList<>();
                ArrayList<String> passwords_for_adm = new ArrayList<>();
                static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydb";
                static final String USERNAME = "root";
                static final String PASSWORD = "root";
                static final String QUERY = "SELECT * FROM people";








                public MyFrame()
                {
                    setTitle("Registration Form");
                    setBounds(300, 90, 900, 600);
                    setDefaultCloseOperation(EXIT_ON_CLOSE);
                    setResizable(false);

                    c = getContentPane();
                    c.setLayout(null);

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

                    sub = new JButton("Submit");
                    sub.setFont(new Font("Arial", Font.PLAIN, 15));
                    sub.setSize(100, 20);
                    sub.setLocation(300, 450);
                    sub.addActionListener(this);
                    c.add(sub);

                    reset = new JButton("Reset");
                    reset.setFont(new Font("Arial", Font.PLAIN, 15));
                    reset.setSize(100, 20);
                    reset.setLocation(450, 450);
                    reset.addActionListener(this);
                    c.add(reset);

                    setVisible(true);
                }

                public void actionPerformed(ActionEvent e) {


                    try (

                            Connection conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

                            Statement stmt = conn.createStatement();

                            ResultSet rs = stmt.executeQuery(QUERY);){

                    int choice=0;
                    int num;
                    int id_change;
                    int brt;
                    String name_delete_where;
                    String name_delete_what;
                    String name1;
                    String where_change;
                    String what_change;
                    names_for_user.add("John");
                    passwords_for_user.add("123");
                    names_for_adm.add("Boo");
                    passwords_for_adm.add("1234");
                    names_for_edit.add("Max");
                    passwords_for_edit.add("321");
                    Scanner scanner = new Scanner(System.in);

                    if (user.isSelected() == true) {


                        if (names_for_user.contains(tname.getText()) & passwords_for_user.contains(pass_wr.getText())) {











                            while (choice != -1) {
                                System.out.println("\nSelect an option:\n 1 - Find an employee by id \n 2 - Find an employee by birthday \n 3 - Find an employee by name " +
                                        "\n 4 - sum of salary");
                                choice = scanner.nextInt();
                                switch (choice) {

                                    case 1 -> {
                                        System.out.print("Write id worker:\n");
                                        num = scanner.nextInt();
                                        while (rs.next()) {
                                            if (rs.getInt("id") == num) {
                                                int id = rs.getInt(1);
                                                String name = rs.getString(2);
                                                String surname = rs.getString(3);
                                                String address = rs.getString(4);
                                                int birth = rs.getInt(5);
                                                int salary = rs.getInt(6);
                                                String family = rs.getString(7);
                                                System.out.printf("id: %d, name: %s, surname: %s, address: %s, birth: %d, salary: %d,family: %s", id, name, surname, address, birth, salary, family);
                                                System.out.print("Successful\n");
                                            }
                                        }
                                    }
                                    case 2 -> {

                                        System.out.print("Write birthday worker:\n");
                                        brt = scanner.nextInt();
                                        while (rs.next()) {
                                            if (rs.getInt("birth") == brt) {
                                                int id = rs.getInt(1);
                                                String name = rs.getString(2);
                                                String surname = rs.getString(3);
                                                String address = rs.getString(4);
                                                int birth = rs.getInt(5);
                                                int salary = rs.getInt(6);
                                                String family = rs.getString(7);
                                                System.out.printf("id: %d, name: %s, surname: %s, address: %s, birth: %d, salary: %d,family: %s", id, name, surname, address, birth, salary, family);
                                                System.out.print("Successful\n");

                                            }
                                        }
                                    }
                                    case 3 -> {
                                        System.out.print("Write name worker:\n");
                                        name1 = scanner.next();
                                        while (rs.next()) {
                                            if (Objects.equals(rs.getString("firstname"), name1)) {
                                                int id = rs.getInt(1);
                                                String name = rs.getString(2);
                                                String surname = rs.getString(3);
                                                String address = rs.getString(4);
                                                int birth = rs.getInt(5);
                                                int salary = rs.getInt(6);
                                                String family = rs.getString(7);
                                                System.out.printf("id: %d, name: %s, surname: %s, address: %s, birth: %d, salary: %d,family: %s", id, name, surname, address, birth, salary, family);
                                                System.out.print("Successful\n");
                                            }
                                        }
                                    }
                                    case 4 -> {
                                        int sum = 0;
                                        while (rs.next()) {
                                            int salary = rs.getInt(6);
                                            sum = sum + salary;
                                        }
                                        System.out.println(sum);
                                    }
                                }
                            }
                        }else {System.out.println("Error,input again");}
                        } else if (adm.isSelected() == true) {
                            if (names_for_adm.contains(tname.getText()) & passwords_for_adm.contains(pass_wr.getText())){
                                while (choice !=-1) {
                                    System.out.println("\nSelect an option:\n 1 - Add worker \n 2 - Find an employee by id \n 3 - Find an employee by birthday \n 4 - Find an employee by name " +
                                            "\n 5 - sum of salary \n 6 - Delete rows \n 7 - Change value");
                                    choice = scanner.nextInt();
                                    switch (choice) {
                                        case 1 -> {
                                            System.out.println("Write name:");
                                            String firstname = scanner.next();
                                            System.out.print("Write surname:\n");
                                            String surname1 = scanner.next();
                                            System.out.print("Write address:\n");
                                            String address1 = scanner.next();
                                            System.out.print("Write date birthday:\n");
                                            int birth1 = scanner.nextInt();
                                            System.out.print("Write salary:\n");
                                            int salary1 = scanner.nextInt();
                                            System.out.print("Famaly status:\n");
                                            String family1 = scanner.next();
                                            String string = String.format("INSERT INTO People(firstname,surname,address,birth,salary,famaly)" +
                                                            "VALUES ('%s','%s','%s','%d','%d','%s')",
                                                    firstname, surname1, address1, birth1, salary1, family1);
                                            stmt.executeUpdate(string);
                                            System.out.print("Successful\n");
                                        }
                                        case 2 -> {
                                            System.out.print("Write id worker:\n");
                                            num = scanner.nextInt();
                                            while (rs.next()) {
                                                if (rs.getInt("id") == num) {
                                                    int id = rs.getInt(1);
                                                    String name = rs.getString(2);
                                                    String surname = rs.getString(3);
                                                    String address = rs.getString(4);
                                                    int birth = rs.getInt(5);
                                                    int salary = rs.getInt(6);
                                                    String family = rs.getString(7);
                                                    System.out.printf("id: %d, name: %s, surname: %s, address: %s, birth: %d, salary: %d,family: %s", id, name, surname, address, birth, salary, family);
                                                    System.out.print("Successful\n");
                                                }
                                            }
                                        }case 3 -> {
                                            System.out.print("Write birthday worker:\n");
                                            brt = scanner.nextInt();
                                            while (rs.next()) {
                                                if (rs.getInt("birth") == brt) {
                                                    int id = rs.getInt(1);
                                                    String name = rs.getString(2);
                                                    String surname = rs.getString(3);
                                                    String address = rs.getString(4);
                                                    int birth = rs.getInt(5);
                                                    int salary = rs.getInt(6);
                                                    String family = rs.getString(7);
                                                    System.out.printf("id: %d, name: %s, surname: %s, address: %s, birth: %d, salary: %d,family: %s", id, name, surname, address, birth, salary, family);
                                                    System.out.print("Successful\n");
                                                }
                                            }
                                        }
                                        case 4-> {
                                            System.out.print("Write name worker:\n");
                                            name1 = scanner.next();
                                            while (rs.next()) {
                                                if (Objects.equals(rs.getString("firstname"), name1)) {
                                                    int id = rs.getInt(1);
                                                    String name = rs.getString(2);
                                                    String surname = rs.getString(3);
                                                    String address = rs.getString(4);
                                                    int birth = rs.getInt(5);
                                                    int salary = rs.getInt(6);
                                                    String family = rs.getString(7);
                                                    System.out.printf("id: %d, name: %s, surname: %s, address: %s, birth: %d, salary: %d,family: %s", id, name, surname, address, birth, salary, family);
                                                    System.out.print("Successful\n");
                                                }
                                            }
                                        }
                                        case 5-> {
                                            int sum = 0;
                                            while (rs.next()) {
                                                int salary = rs.getInt(6);
                                                sum = sum + salary;
                                            }
                                            System.out.println(sum);
                                        }

                                        case 6-> {
                                            System.out.print("Write where need del:\n");
                                            name_delete_where = scanner.next();
                                            System.out.print("Write what need del:\n");
                                            name_delete_what = scanner.next();
                                            String string1 = String.format("DELETE FROM mydb.people WHERE %s = '%s';", name_delete_where, name_delete_what);
                                            stmt.executeUpdate(string1);
                                            System.out.print("Successful\n");
                                        }

                                        case 7-> {
                                            System.out.print("Write where need change:\n");
                                            where_change = scanner.next();
                                            System.out.print("Write what need change:\n");
                                            what_change = scanner.next();
                                            System.out.print("Write id:\n");
                                            id_change = scanner.nextInt();
                                            String string2 = String.format("UPDATE mydb.people SET %s = '%s' WHERE id = %d", where_change, what_change, id_change);
                                            stmt.executeUpdate(string2);
                                            System.out.print("Successful\n");
                                        }
                                    }


                                }

                            }
                            else {System.out.println("Error,input again");}

                        }else if (edit.isSelected() == true) {
                            if (names_for_edit.contains(tname.getText()) & passwords_for_edit.contains(pass_wr.getText())){
                                while (choice !=-1) {
                                    System.out.println("\nSelect an option: \n 1 - Find an employee by id \n 2 - Find an employee by birthday \n 3 - Find an employee by name " +
                                            "\n 4 - sum of salary \n 5 - Delete rows \n 6 - Change value");
                                    choice = scanner.nextInt();
                                    switch (choice) {
                                        case 1 -> {
                                            System.out.print("Write id worker:\n");
                                            num = scanner.nextInt();
                                            while (rs.next()) {
                                                if (rs.getInt("id") == num) {
                                                    int id = rs.getInt(1);
                                                    String name = rs.getString(2);
                                                    String surname = rs.getString(3);
                                                    String address = rs.getString(4);
                                                    int birth = rs.getInt(5);
                                                    int salary = rs.getInt(6);
                                                    String family = rs.getString(7);

                                                    System.out.printf("id: %d, name: %s, surname: %s, address: %s, birth: %d, salary: %d,family: %s", id, name, surname, address, birth, salary, family);
                                                    System.out.print("Successful\n");


                                                }

                                            }
                                        }case 2 -> {
                                            System.out.print("Write birthday worker:\n");
                                            brt = scanner.nextInt();
                                            while (rs.next()) {
                                                if (rs.getInt("birth") == brt) {
                                                    int id = rs.getInt(1);
                                                    String name = rs.getString(2);
                                                    String surname = rs.getString(3);
                                                    String address = rs.getString(4);
                                                    int birth = rs.getInt(5);
                                                    int salary = rs.getInt(6);
                                                    String family = rs.getString(7);
                                                    System.out.printf("id: %d, name: %s, surname: %s, address: %s, birth: %d, salary: %d,family: %s", id, name, surname, address, birth, salary, family);
                                                    System.out.print("Successful\n");
                                                }
                                            }
                                        }

                                        case 3-> {
                                            System.out.print("Write name worker:\n");
                                            name1 = scanner.next();
                                            while (rs.next()) {
                                                if (Objects.equals(rs.getString("firstname"), name1)) {
                                                    int id = rs.getInt(1);
                                                    String name = rs.getString(2);
                                                    String surname = rs.getString(3);
                                                    String address = rs.getString(4);
                                                    int birth = rs.getInt(5);
                                                    int salary = rs.getInt(6);
                                                    String family = rs.getString(7);
                                                    System.out.printf("id: %d, name: %s, surname: %s, address: %s, birth: %d, salary: %d,family: %s", id, name, surname, address, birth, salary, family);
                                                    System.out.print("Successful\n");
                                                }
                                            }
                                        }
                                        case 4-> {
                                            int sum = 0;
                                            while (rs.next()) {
                                                int salary = rs.getInt(6);
                                                sum = sum + salary;
                                            }
                                            System.out.println(sum);
                                        }

                                        case 5-> {
                                            System.out.print("Write where need del:\n");
                                            name_delete_where = scanner.next();
                                            System.out.print("Write what need del:\n");
                                            name_delete_what = scanner.next();
                                            String string1 = String.format("DELETE FROM mydb.people WHERE %s = '%s';", name_delete_where, name_delete_what);
                                            stmt.executeUpdate(string1);
                                            System.out.print("Successful\n");
                                        }

                                        case 6-> {
                                            System.out.print("Write where need change:\n");
                                            where_change = scanner.next();
                                            System.out.print("Write what need change:\n");
                                            what_change = scanner.next();
                                            System.out.print("Write id:\n");
                                            id_change = scanner.nextInt();
                                            String string2 = String.format("UPDATE mydb.people SET %s = '%s' WHERE id = %d", where_change, what_change, id_change);
                                            stmt.executeUpdate(string2);
                                            System.out.print("Successful\n");
                                        }
                                    }
                                }

                            }
                            else {System.out.println("Error,input again");}


                        }


                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                }

        }
        MyFrame f = new MyFrame();

        new java.util.Timer().schedule(new TimerTask(){
            @Override
            public void run() {
                f.dispose();
                form2 form2 = new form2();
                form2.setVisible(true);

            }
        },1000*3);
        ;






    }
}