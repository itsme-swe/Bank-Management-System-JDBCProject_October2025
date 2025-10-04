package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    JLabel label1;
    JLabel label2;
    JLabel label3;

    JTextField textField1;
    JPasswordField passwordField2;

    JButton signUpBtn;
    JButton signInBtn;
    JButton clearBtn;


    Login() {
        super("Bank Management System");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(350, 10, 100, 100);
        add(image1);

        ImageIcon ig1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ig2 = ig1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ig3 = new ImageIcon(ig2);
        JLabel image2 = new JLabel(ig3);
        image2.setBounds(630, 350, 100, 100);
        add(image2);

        // label1 is about welcome msg
        label1 = new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 38));
        label1.setBounds(230, 125, 450, 40);
        add(label1);

        // label2 is about Card Details
        label2 = new JLabel("Card No: ");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Ralway", Font.BOLD, 25));
        label2.setBounds(150, 190, 375, 30);
        add(label2);

        // textField to take an input of Card No. from user
        textField1 = new JTextField(15);
        textField1.setBounds(280, 190, 230, 30);
        textField1.setFont(new Font("Arial", Font.BOLD, 14));
        add(textField1);

        // passwordField to take an input of password from user
        passwordField2 = new JPasswordField(15);
        passwordField2.setBounds(280, 250, 230, 30);
        passwordField2.setFont(new Font("Arial", Font.BOLD, 14));
        add(passwordField2);

        // Adding Sign In Button on frame
        signInBtn = new JButton("SIGN IN");
        signInBtn.setFont(new Font("Arial", Font.BOLD, 14));
        signInBtn.setForeground(Color.WHITE);
        signInBtn.setBackground(Color.BLUE);
        signInBtn.setBounds(290, 300, 100, 30);
        signInBtn.addActionListener(this);
        add(signInBtn);

        // Adding SignUp Btn on frame
        signUpBtn = new JButton("SIGN UP");
        signUpBtn.setFont(new Font("Arial", Font.BOLD, 14));
        signUpBtn.setForeground(Color.WHITE);
        signUpBtn.setBackground(Color.BLUE);
        signUpBtn.setBounds(400, 300, 100, 30);
        signUpBtn.addActionListener(this);
        add(signUpBtn);

        // Adding Clear Btn on frame
        clearBtn = new JButton("CLEAR");
        clearBtn.setFont(new Font("Arial", Font.BOLD, 14));
        clearBtn.setForeground(Color.WHITE);
        clearBtn.setBackground(Color.BLUE);
        clearBtn.setBounds(345, 345, 100, 30);
        clearBtn.addActionListener(this);
        add(clearBtn);


        // label3 is about PIN 
        label3 = new JLabel("PIN No. ");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("Ralway", Font.BOLD, 25));
        label3.setBounds(150, 250, 375, 30);
        add(label3);


        // Code for Background image
        ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image bg1 = bg.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon bg2 = new ImageIcon(bg1);
        JLabel image3 = new JLabel(bg2);
        image3.setBounds(0, 0, 850, 480);
        add(image3);

        setLayout(null);
        setSize(850, 480);  // frame dimensions.
        setLocation(400, 200);
        setVisible(true);   // frame visibility by default it is false to make it visible pass true.
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            if (e.getSource() == signInBtn) {

            } else if (e.getSource() == signUpBtn) {

                new SignUp1();
                setVisible(false);

            } else if (e.getSource() == clearBtn) {
                textField1.setText("");
                passwordField2.setText("");
            }

        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new Login();
    }

}
