package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash_Class extends JFrame implements ActionListener {

    String pin;

    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7;

    FastCash_Class(String pin) {

        this.pin = pin;

        ImageIcon atmLayout = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image atm = atmLayout.getImage().getScaledInstance(1550, 800, Image.SCALE_DEFAULT);
        ImageIcon atmIcon = new ImageIcon(atm);
        JLabel image = new JLabel(atmIcon);
        image.setBounds(0, 0, 1550, 800);
        add(image);

        JLabel transInfo = new JLabel("SELECT WITHDRAWAL AMOUNT");
        transInfo.setBounds(430, 180, 700, 35);
        transInfo.setFont(new Font("System", Font.BOLD, 24));
        transInfo.setForeground(Color.WHITE);
        image.add(transInfo);

        // Buttons
        btn1 = new JButton("Rs. 200");
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(new Color(65, 125, 128));
        btn1.setBounds(405, 260, 150, 35);
        btn1.addActionListener(this);
        image.add(btn1);

        btn2 = new JButton("Rs. 500");
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(new Color(65, 125, 128));
        btn2.setBounds(700, 260, 150, 35);
        btn2.addActionListener(this);
        image.add(btn2);

        btn3 = new JButton("Rs. 1000");
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(new Color(65, 125, 128));
        btn3.setBounds(405, 305, 150, 35);
        btn3.addActionListener(this);
        image.add(btn3);

        btn4 = new JButton("Rs. 2000");
        btn4.setForeground(Color.WHITE);
        btn4.setBackground(new Color(65, 125, 128));
        btn4.setBounds(700, 305, 150, 35);
        btn4.addActionListener(this);
        image.add(btn4);

        btn5 = new JButton("Rs. 5000");
        btn5.setForeground(Color.WHITE);
        btn5.setBackground(new Color(65, 125, 128));
        btn5.setBounds(405, 350, 150, 35);
        btn5.addActionListener(this);
        image.add(btn5);

        btn6 = new JButton("Rs. 10000");
        btn6.setForeground(Color.WHITE);
        btn6.setBackground(new Color(65, 125, 128));
        btn6.setBounds(700, 350, 150, 35);
        btn6.addActionListener(this);
        image.add(btn6);

        btn7 = new JButton("Back");
        btn7.setForeground(Color.WHITE);
        btn7.setBackground(new Color(65, 125, 128));
        btn7.setBounds(700, 395, 150, 35);
        btn7.addActionListener(this);
        image.add(btn7);


        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        getContentPane().setBackground(new Color(100, 149, 237));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            if (e.getSource() == btn7) {
                setVisible(false);
                new Transactions_MainClass(pin);

            } else {

                String amount = ((JButton) e.getSource()).getText().substring(4);

                DBConnection dbConnect = new DBConnection();
                Date date = new Date();

                String retrievingData = "select * from bank where pin = ?";

                PreparedStatement preStatement;

                try {

                    preStatement = dbConnect.preparedStatement(retrievingData);

                    preStatement.setString(1, pin);

                    ResultSet resultSet = preStatement.executeQuery();

                    int balance = 0;

                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }

                    resultSet.close();
                    preStatement.close();

                    if (e.getSource() != btn7 && balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient balance");
                        dbConnect.close();
                        return;

                    }

                    String insertQuery = "insert into bank(pin, date, type, amount) values (?, ?, ?, ?)";
                    PreparedStatement insertStatement = dbConnect.preparedStatement(insertQuery);

                    insertStatement.setString(1, pin);
                    insertStatement.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
                    insertStatement.setString(3, "Withdrawal");
                    insertStatement.setString(4, amount);

                    insertStatement.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Rs. " + amount + "Debited Successfully");

                    insertStatement.close();
                    dbConnect.close();

                    setVisible(false);
                    new Transactions_MainClass(pin);

                } catch (Exception err) {
                    err.printStackTrace();
                }
            }

        } catch (Exception E) {
            E.printStackTrace();
        }

    }

    static void main() {

        new FastCash_Class("");
    }
}
