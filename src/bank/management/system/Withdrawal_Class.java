package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawal_Class extends JFrame implements ActionListener {

    String pin;

    TextField enterAmtTextField;

    JButton depositBtn, backBtn;

    Withdrawal_Class(String pinNum) {

        this.pin = pinNum;

        // setting up layout of ATM
        ImageIcon atmLayout = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image atm = atmLayout.getImage().getScaledInstance(1550, 800, Image.SCALE_DEFAULT);
        ImageIcon atmIcon = new ImageIcon(atm);
        JLabel image = new JLabel(atmIcon);
        image.setBounds(0, 0, 1550, 800);
        add(image);

        JLabel depositAmtLabel = new JLabel("MAXIMUM WITHDRAWAL LIMIT IS RS. 10000");
        depositAmtLabel.setFont(new Font("System", Font.BOLD, 16));
        depositAmtLabel.setBounds(460, 180, 700, 35);
        depositAmtLabel.setForeground(Color.WHITE);
        image.add(depositAmtLabel); // adding font above the image

        JLabel amountField = new JLabel("ENTER YOUR AMOUNT");
        amountField.setFont(new Font("System", Font.BOLD, 16));
        amountField.setBounds(520, 220, 400, 35);
        amountField.setForeground(Color.WHITE);
        image.add(amountField);

        // Text Field
        enterAmtTextField = new TextField();
        enterAmtTextField.setBounds(460, 260, 320, 30);
        enterAmtTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        enterAmtTextField.setBackground(new Color(65, 125, 128));
        enterAmtTextField.setForeground(Color.WHITE);
        image.add(enterAmtTextField);

        // Buttons
        depositBtn = new JButton("CASH WITHDRAWAL");
        depositBtn.setBounds(700, 350, 150, 35);
        depositBtn.setBackground(new Color(65, 125, 128));
        depositBtn.setForeground(Color.WHITE);
        depositBtn.addActionListener(this);
        image.add(depositBtn);

        backBtn = new JButton("BACK");
        backBtn.setBounds(700, 390, 150, 35);
        backBtn.setBackground(new Color(65, 125, 128));
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        image.add(backBtn);


        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        getContentPane().setBackground(new Color(100, 149, 237));
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            if (e.getSource() == backBtn) {
                setVisible(false);

                new Transactions_MainClass(pin);
                return;
            }

            if (e.getSource() == depositBtn) {

                String amountText = enterAmtTextField.getText().trim();
                Date date = new Date();

                if (amountText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter amount you want to withdrawal");
                    return;
                }

                int amount = Integer.parseInt(amountText);

                if (amount <= 100 || amount >= 10000) {
                    JOptionPane.showMessageDialog(null, "Invalid amount. Amount must be between 100 and 10000");
                    return;
                }

                DBConnection dbConnect = new DBConnection();

                String retrievingPin = "select * from bank where pin = ?";

                PreparedStatement preStatement;

                try {

                    preStatement = dbConnect.preparedStatement(retrievingPin);

                    preStatement.setString(1, pin);

                    ResultSet resultSet = preStatement.executeQuery();

                    int balance = 0;

                    while (resultSet.next()) {

                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount")); // Converting string to int and adding value to balance
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }

                    if (balance < amount) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    } else {
                        String insertWithdrawalQuery = "insert into bank(pin, date, type, amount) values (?,?,?,?)";

                        PreparedStatement insertStatement = dbConnect.preparedStatement(insertWithdrawalQuery);

                        insertStatement.setString(1, pin);
                        insertStatement.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
                        insertStatement.setString(3, "Withdrawal");
                        insertStatement.setString(4, amountText);

                        insertStatement.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Rs. " + amount + "Debited Successfully");

                        setVisible(false);
                        new Transactions_MainClass(pin);

                        insertStatement.close();
                    }

                    preStatement.close();
                    dbConnect.close();
                } catch (Exception err) {
                    err.printStackTrace();
                }

            }

        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    static void main() {

        new Withdrawal_Class("");
    }
}
