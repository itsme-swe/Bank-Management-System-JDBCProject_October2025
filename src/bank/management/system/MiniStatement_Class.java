package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MiniStatement_Class extends JFrame implements ActionListener {

    String pin;

    JButton btn1;

    MiniStatement_Class(String pin) {

        setLayout(null);
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(new Color(100, 149, 237));
        setVisible(true);

        this.pin = pin;

        JLabel label1 = new JLabel();
        label1.setBounds(20, 140, 400, 200);
        add(label1);

        JLabel label2 = new JLabel("HAWK EYE BANK");
        label2.setFont(new Font("System", Font.BOLD, 15));
        label2.setBounds(120, 20, 200, 20);
        label2.setForeground(Color.BLACK);
        add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(20, 100, 300, 20);
        add(label3);

        JLabel label4 = new JLabel();
        label4.setBounds(20, 400, 300, 20);
        add(label4);

        DBConnection dbConnect = new DBConnection();

        try {

            String fetchCardNumQuery = "select * from login where pin_number = ?";

            PreparedStatement fetchCardStatement = dbConnect.preparedStatement(fetchCardNumQuery);

            fetchCardStatement.setString(1, pin);

            ResultSet resultSet = fetchCardStatement.executeQuery();

            while (resultSet.next()) {

                label3.setText("Card Number: " + resultSet.getString("card_number").substring(0, 4) + "XXXXXXXX" + resultSet.getString("card_number").substring(12));

            }

            resultSet.close();
            fetchCardStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {

            int balance = 0;

            String fetchBalanceQuery = "select * from bank where pin = ?";

            PreparedStatement fetchBalanceStatement = dbConnect.preparedStatement(fetchBalanceQuery);

            fetchBalanceStatement.setString(1, pin);

            ResultSet resultSet = fetchBalanceStatement.executeQuery();

            while (resultSet.next()) {

                label1.setText(label1.getText() + "<html>" + resultSet.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("amount") + "<br><br><html>");

                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }

            label4.setText("Your Total Balance is Rs. " + balance);
            label4.setFont(new Font("Raleway", Font.BOLD, 16));

            resultSet.close();
            fetchBalanceStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        btn1 = new JButton("Exit");
        btn1.setBounds(20, 500, 100, 25);
        btn1.setForeground(Color.BLACK);
        btn1.setBackground(new Color(100, 149, 237));
        btn1.addActionListener(this);
        add(btn1);

        dbConnect.close();


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        setVisible(false);

    }

    static void main() {

        new MiniStatement_Class("");
    }
}
