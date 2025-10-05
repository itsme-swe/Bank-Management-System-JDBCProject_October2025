package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BalanceEnquiry_Class extends JFrame implements ActionListener {

    JLabel label2;

    JButton btn1;

    String pin;

    BalanceEnquiry_Class(String pin) {

        this.pin = pin;

        ImageIcon atmLayout = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image atm = atmLayout.getImage().getScaledInstance(1550, 800, Image.SCALE_DEFAULT);
        ImageIcon atmIcon = new ImageIcon(atm);
        JLabel image = new JLabel(atmIcon);
        image.setBounds(0, 0, 1550, 800);
        add(image);

        JLabel depositAmtLabel = new JLabel("Your Account Balance is Rs. ");
        depositAmtLabel.setFont(new Font("System", Font.BOLD, 16));
        depositAmtLabel.setBounds(430, 180, 700, 35);
        depositAmtLabel.setForeground(Color.WHITE);
        image.add(depositAmtLabel); // adding font above the image

        label2 = new JLabel();
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(430, 220, 400, 35);
        label2.setForeground(Color.WHITE);
        image.add(label2);

        btn1 = new JButton("Back");
        btn1.setBounds(700, 395, 150, 35);
        btn1.setBackground(new Color(65, 125, 128));
        btn1.setForeground(Color.WHITE);
        btn1.addActionListener(this);
        image.add(btn1);

        int balance = 0;

        try {

            DBConnection dbConnect = new DBConnection();

            PreparedStatement preStatement = dbConnect.preparedStatement("select * from bank where pin = ?");

            preStatement.setString(1, pin);

            ResultSet resultSet = preStatement.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount")); // Converting string to int and adding value to balance
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        label2.setText("" + balance);


        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        getContentPane().setBackground(new Color(100, 149, 237));
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        setVisible(false);
        new Transactions_MainClass(pin);
    }

    static void main() {

        new BalanceEnquiry_Class("");
    }
}
