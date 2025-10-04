package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Date;

public class DepositMoney extends JFrame implements ActionListener {

    String pin;

    TextField enterAmtTextField;

    JButton depositBtn, backBtn;

    DepositMoney(String pinNum) {

        this.pin = pinNum;

        // setting up layout of ATM
        ImageIcon atmLayout = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image atm = atmLayout.getImage().getScaledInstance(1550, 800, Image.SCALE_DEFAULT);
        ImageIcon atmIcon = new ImageIcon(atm);
        JLabel image = new JLabel(atmIcon);
        image.setBounds(0, 0, 1550, 800);
        add(image);

        JLabel depositAmtLabel = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        depositAmtLabel.setFont(new Font("System", Font.BOLD, 16));
        depositAmtLabel.setBounds(460, 180, 400, 35);
        depositAmtLabel.setForeground(Color.WHITE);
        image.add(depositAmtLabel); // adding font above the image

        // Text Field
        enterAmtTextField = new TextField();
        enterAmtTextField.setBounds(460, 250, 320, 30);
        enterAmtTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        enterAmtTextField.setBackground(new Color(65, 125, 128));
        enterAmtTextField.setForeground(Color.WHITE);
        image.add(enterAmtTextField);

        // Buttons
        depositBtn = new JButton("DEPOSIT");
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

            String amount = enterAmtTextField.getText();
            Date date = new Date();

            if (e.getSource() == depositBtn) {
                if (amount.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the valid amount");
                    return;
                } else {

                    DBConnection dbConnect = new DBConnection();

                    PreparedStatement preStatement;

                    preStatement = dbConnect.preparedStatement("insert into bank(pin, date, type, amount) values (?, ?,?,?)");

                    preStatement.setString(1, pin);
                    preStatement.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
                    preStatement.setString(3, "Deposit");
                    preStatement.setString(4, amount);

                    int rowInserted = preStatement.executeUpdate();

                    if (rowInserted > 0) {
                        JOptionPane.showMessageDialog(null, "Rs. " + amount + " Deposited Successfully");
                        setVisible(false);

                        new Transaction(pin);
                    }

                    preStatement.close();
                    dbConnect.close();
                }
            } else if (e.getSource() == backBtn) {
                setVisible(false);

                new Transaction(pin);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    static void main() {

        new DepositMoney("");
    }
}
