package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions_MainClass extends JFrame implements ActionListener {

    String pin;

    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7;

    Transactions_MainClass(String pin) {

        this.pin = pin;

        ImageIcon atmLayout = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image atm = atmLayout.getImage().getScaledInstance(1550, 800, Image.SCALE_DEFAULT);
        ImageIcon atmIcon = new ImageIcon(atm);
        JLabel image = new JLabel(atmIcon);
        image.setBounds(0, 0, 1550, 800);
        add(image);

        JLabel transInfo = new JLabel("Please select your transaction");
        transInfo.setBounds(430, 180, 700, 35);
        transInfo.setFont(new Font("System", Font.BOLD, 28));
        transInfo.setForeground(Color.WHITE);
        image.add(transInfo);

        // Buttons
        btn1 = new JButton("DEPOSIT");
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(new Color(65, 125, 128));
        btn1.setBounds(405, 260, 150, 35);
        btn1.addActionListener(this);
        image.add(btn1);

        btn2 = new JButton("CASH WITHDRAWAL");
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(new Color(65, 125, 128));
        btn2.setBounds(700, 260, 150, 35);
        btn2.addActionListener(this);
        image.add(btn2);

        btn3 = new JButton("FAST CASH");
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(new Color(65, 125, 128));
        btn3.setBounds(405, 305, 150, 35);
        btn3.addActionListener(this);
        image.add(btn3);

        btn4 = new JButton("MINI STATEMENT");
        btn4.setForeground(Color.WHITE);
        btn4.setBackground(new Color(65, 125, 128));
        btn4.setBounds(700, 305, 150, 35);
        btn4.addActionListener(this);
        image.add(btn4);

        btn5 = new JButton("PIN CHANGE");
        btn5.setForeground(Color.WHITE);
        btn5.setBackground(new Color(65, 125, 128));
        btn5.setBounds(405, 350, 150, 35);
        btn5.addActionListener(this);
        image.add(btn5);

        btn6 = new JButton("BALANCE ENQUIRY");
        btn6.setForeground(Color.WHITE);
        btn6.setBackground(new Color(65, 125, 128));
        btn6.setBounds(700, 350, 150, 35);
        btn6.addActionListener(this);
        image.add(btn6);

        btn7 = new JButton("EXIT");
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

        if (e.getSource() == btn1) {
            new Deposit_Class(pin);
            setVisible(false);
        } else if (e.getSource() == btn7) {
            System.exit(0);
        } else if (e.getSource() == btn2) {
            new Withdrawal_Class(pin);
            setVisible(false);
        } else if (e.getSource() == btn6) {
            new BalanceEnquiry_Class(pin);
            setVisible(false);
        } else if (e.getSource() == btn3) {
            new FastCash_Class(pin);
            setVisible(false);
        } else if (e.getSource() == btn5) {
            new ChangePIN_Class(pin);
            setVisible(false);
        }
    }

    static void main() {

        new Transactions_MainClass("");
    }
}
