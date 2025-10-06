package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangePIN_Class extends JFrame implements ActionListener {

    String pin;

    JButton btn1, btn2;

    JPasswordField pass1, pass2;

    ChangePIN_Class(String pin) {

        this.pin = pin;

        ImageIcon atmLayout = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image atm = atmLayout.getImage().getScaledInstance(1550, 800, Image.SCALE_DEFAULT);
        ImageIcon atmIcon = new ImageIcon(atm);
        JLabel image = new JLabel(atmIcon);
        image.setBounds(0, 0, 1550, 800);
        add(image);

        JLabel changePinLabel1 = new JLabel("CHANGE YOUR PIN");
        changePinLabel1.setFont(new Font("System", Font.BOLD, 18));
        changePinLabel1.setBounds(430, 180, 400, 35);
        changePinLabel1.setForeground(Color.WHITE);
        image.add(changePinLabel1); // adding font above the image

        JLabel newPinLabel2 = new JLabel("ENTER NEW PIN : ");
        newPinLabel2.setFont(new Font("System", Font.BOLD, 18));
        newPinLabel2.setBounds(430, 230, 400, 35);
        newPinLabel2.setForeground(Color.WHITE);
        image.add(newPinLabel2); // adding font above the image

        pass1 = new JPasswordField();
        pass1.setBounds(650, 230, 150, 30);
        pass1.setFont(new Font("Raleway", Font.BOLD, 18));
        pass1.setBackground(new Color(65, 125, 128));
        pass1.setForeground(Color.BLACK);
        image.add(pass1);

        JLabel newPinLabel3 = new JLabel("RE-ENTER NEW PIN : ");
        newPinLabel3.setFont(new Font("System", Font.BOLD, 18));
        newPinLabel3.setBounds(430, 280, 400, 35);
        newPinLabel3.setForeground(Color.WHITE);
        image.add(newPinLabel3); // adding font above the image

        pass2 = new JPasswordField();
        pass2.setBounds(650, 280, 150, 30);
        pass2.setFont(new Font("Raleway", Font.BOLD, 18));
        pass2.setBackground(new Color(65, 125, 128));
        pass2.setForeground(Color.BLACK);
        image.add(pass2);

        // Buttons
        btn1 = new JButton("CHANGE");
        btn1.setBounds(700, 350, 150, 35);
        btn1.setBackground(new Color(65, 125, 128));
        btn1.setForeground(Color.WHITE);
        btn1.addActionListener(this);
        image.add(btn1);

        btn2 = new JButton("BACK");
        btn2.setBounds(700, 390, 150, 35);
        btn2.setBackground(new Color(65, 125, 128));
        btn2.setForeground(Color.WHITE);
        btn2.addActionListener(this);
        image.add(btn2);


        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        getContentPane().setBackground(new Color(100, 149, 237));
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btn2) {
            setVisible(false);
            new Transactions_MainClass(pin);
        }

        try {

            String pin1 = new String(pass1.getPassword());
            String pin2 = new String(pass2.getPassword());

            if (!pin1.equals(pin2)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not matched");
                pass1.setText("");
                pass2.setText("");

                pass1.requestFocus();   // Bringing cursor back to pin1

                return;
            }

            if (e.getSource() == btn1) {

                if (pin1.isBlank() || pin2.isBlank()) {
                    JOptionPane.showMessageDialog(null, "Please enter and confirm your new PIN");
                    return;
                }

                DBConnection dbConnect = new DBConnection();

                String updatePinQuery1 = "update bank set pin = ? where pin = ?";
                String updatePinQuery2 = "update login set pin_number = ? where pin_number = ?";
                String updatePinQuery3 = "update signupthree set pin_number = ? where pin_number = ?";

                PreparedStatement updateStatement1, updateStatement2, updateStatement3;

                try {

                    updateStatement1 = dbConnect.preparedStatement(updatePinQuery1);

                    updateStatement1.setString(1, pin1);
                    updateStatement1.setString(2, pin);

                    updateStatement1.executeUpdate();

                    updateStatement2 = dbConnect.preparedStatement(updatePinQuery2);

                    updateStatement2.setString(1, pin1);
                    updateStatement2.setString(2, pin);

                    updateStatement2.executeUpdate();

                    updateStatement3 = dbConnect.preparedStatement(updatePinQuery3);

                    updateStatement3.setString(1, pin1);
                    updateStatement3.setString(2, pin);

                    updateStatement3.executeUpdate();

                    JOptionPane.showMessageDialog(null, "PIN Changed Successfully");

                    setVisible(false);
                    new Transactions_MainClass(pin1);

                    updateStatement1.close();
                    updateStatement2.close();
                    updateStatement3.close();
                    dbConnect.close();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }

        } catch (Exception E) {
            E.printStackTrace();
        }

    }

    static void main() {

        new ChangePIN_Class("");
    }
}
