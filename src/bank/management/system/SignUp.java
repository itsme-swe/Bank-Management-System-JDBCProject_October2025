package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SignUp extends JFrame {

    JTextField applicantNameField, applicantFatherName, applicantEmailField;

    JDateChooser dateChooser;   // used to add calendar

    JRadioButton maleBtn, femaleBtn;

    Random randomNum = new Random();

    long ran4DigitNum = randomNum.nextInt(9000) + 1000;   // generating random 4-digit number between 1000 and 9999.

    SignUp() {

        super("APPLICATION FORM");

        ImageIcon bankLogo = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image bLogo = bankLogo.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon bankLogo1 = new ImageIcon(bLogo);
        JLabel image = new JLabel(bankLogo1);
        image.setBounds(25, 10, 100, 100);
        add(image);

        // Application Form Number text added to frame
        JLabel label1 = new JLabel("APPLICATION FORM NUMBER-" + ran4DigitNum);
        label1.setBounds(220, 25, 600, 35);
        label1.setFont(new Font("Raleway", Font.BOLD, 30));
        label1.setForeground(new Color(245, 245, 245));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Raleway", Font.BOLD, 15));
        label2.setBounds(430, 70, 600, 30);
        add(label2);

        JLabel label3 = new JLabel("PERSONAL DETAILS");
        label3.setFont(new Font("Raleway", Font.BOLD, 22));
        label3.setBounds(350, 100, 600, 30);
        add(label3);

        JLabel nameLabel = new JLabel("Applicant Name : ");
        nameLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        nameLabel.setBounds(100, 200, 200, 30);
        nameLabel.setForeground(Color.BLACK);
        add(nameLabel);

        applicantNameField = new JTextField();
        applicantNameField.setFont(new Font("Raleway", Font.BOLD, 16));
        applicantNameField.setBounds(300, 200, 350, 30);
        add(applicantNameField);

        JLabel fatherNameLabel = new JLabel("Father's Name : ");
        fatherNameLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        fatherNameLabel.setBounds(100, 250, 200, 30);
        fatherNameLabel.setForeground(Color.black);
        add(fatherNameLabel);

        applicantFatherName = new JTextField();
        applicantFatherName.setFont(new Font("Raleway", Font.BOLD, 16));
        applicantFatherName.setBounds(300, 250, 350, 30);
        applicantFatherName.setForeground(Color.BLACK);
        add(applicantFatherName);

        JLabel dobLabel = new JLabel("Date Of Birth : ");
        dobLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        dobLabel.setBounds(100, 300, 200, 30);
        dobLabel.setForeground(Color.BLACK);
        add(dobLabel);

        // Adding calender for adding DOB
        dateChooser = new JDateChooser();
        dateChooser.setFont(new Font("Raleway", Font.BOLD, 12));
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300, 300, 350, 30);
        add(dateChooser);

        JLabel genderLabel = new JLabel("Gender : ");
        genderLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        genderLabel.setBounds(100, 350, 200, 30);
        genderLabel.setForeground(Color.BLACK);
        add(genderLabel);

        maleBtn = new JRadioButton("Male");
        maleBtn.setFont(new Font("Raleway", Font.BOLD, 14));
        maleBtn.setBounds(300, 350, 60, 30);
        maleBtn.setBackground(new Color(100, 149, 237));
        maleBtn.setForeground(Color.BLACK);
        add(maleBtn);

        femaleBtn = new JRadioButton("Female");
        femaleBtn.setFont(new Font("Raleway", Font.BOLD, 14));
        femaleBtn.setBounds(380, 350, 90, 30);
        femaleBtn.setBackground(new Color(100, 149, 237));
        femaleBtn.setForeground(Color.BLACK);
        add(femaleBtn);

        // ButtonGroup helps to select one btn at a time
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(maleBtn);
        btnGroup.add(femaleBtn);

        JLabel emailLabel = new JLabel("Email Address : ");
        emailLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        emailLabel.setBounds(100, 400, 200, 30);
        emailLabel.setForeground(Color.BLACK);
        add(emailLabel);

        applicantEmailField = new JTextField();
        applicantEmailField.setBounds(300, 400, 350, 30);
        applicantEmailField.setFont(new Font("Raleway", Font.BOLD, 16));
        applicantEmailField.setForeground(Color.BLACK);
        add(applicantEmailField);


        // Setting up frame for application form
        getContentPane().setBackground(new Color(100, 149, 237));   // setting up frame color
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);
        setVisible(true);
    }

    static void main() {

        new SignUp();
    }
}
