package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

public class SignUp1 extends JFrame implements ActionListener {

    JTextField applicantNameField, applicantFatherName, applicantEmailField, applicantAddress, applicantCity, applicantState;

    JDateChooser dateChooser;   // used to add calendar

    JRadioButton maleBtn, femaleBtn;

    JButton nextBtn;

    Random randomNum = new Random();

    long ran4DigitNum = randomNum.nextInt(9000) + 1000;   // generating random 4-digit number between 1000 and 9999.

    SignUp1() {

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

        JLabel addressLabel = new JLabel("Address :");
        addressLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        addressLabel.setForeground(Color.BLACK);
        addressLabel.setBounds(100, 450, 200, 30);
        add(addressLabel);

        applicantAddress = new JTextField();
        applicantAddress.setFont(new Font("Raleway", Font.BOLD, 16));
        applicantAddress.setForeground(Color.BLACK);
        applicantAddress.setBounds(300, 450, 350, 30);
        add(applicantAddress);

        JLabel cityLabel = new JLabel("City : ");
        cityLabel.setBounds(100, 500, 200, 30);
        cityLabel.setForeground(Color.BLACK);
        cityLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        add(cityLabel);

        applicantCity = new JTextField();
        applicantCity.setBounds(300, 500, 350, 30);
        applicantCity.setForeground(Color.BLACK);
        applicantCity.setFont(new Font("Raleway", Font.BOLD, 18));
        add(applicantCity);

        JLabel stateLabel = new JLabel("State : ");
        stateLabel.setBounds(100, 550, 200, 30);
        stateLabel.setForeground(Color.BLACK);
        stateLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        add(stateLabel);

        applicantState = new JTextField();
        applicantState.setBounds(300, 550, 350, 30);
        applicantState.setForeground(Color.BLACK);
        applicantState.setFont(new Font("Raleway", Font.BOLD, 18));
        add(applicantState);

        nextBtn = new JButton("Next");
        nextBtn.setBounds(400, 710, 80, 30);
        nextBtn.setForeground(Color.WHITE);
        nextBtn.setBackground(Color.BLACK);
        nextBtn.setFont(new Font("Raleway", Font.BOLD, 14));
        nextBtn.addActionListener(this);
        add(nextBtn);


        // Setting up frame for application form
        getContentPane().setBackground(new Color(100, 149, 237));   // setting up frame color
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String formNum = String.valueOf(ran4DigitNum);
        String nameOfApplicant = applicantNameField.getText();
        String fatherName = applicantFatherName.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (maleBtn.isSelected()) {
            gender = "Male";
        } else if (femaleBtn.isSelected()) {
            gender = "Female";
        }

        String email = applicantEmailField.getText();
        String address = applicantAddress.getText();
        String city = applicantCity.getText();
        String state = applicantState.getText();

        PreparedStatement ps;

        try {

            if (applicantNameField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            } else {

                DBConnection dbConnect = new DBConnection();


                String insertQuery = "insert into signup(form_num, applicant_name, father_name, dob,  gender, email, address, city, state ) values(?,?,?,?,?,?,?,?,?)";

                ps = dbConnect.preparedStatement(insertQuery);

                ps.setString(1, formNum);
                ps.setString(2, nameOfApplicant);
                ps.setString(3, fatherName);
                ps.setString(4, dob);
                ps.setString(5, gender);
                ps.setString(6, email);
                ps.setString(7, address);
                ps.setString(8, city);
                ps.setString(9, state);

                ps.executeUpdate();

                new SignUp2(formNum);
                setVisible(false);

                System.out.println("Data Inserted Successfully");

                ps.close();
                dbConnect.close();

            }

        } catch (Exception E) {
            System.out.println(E.getMessage());
        }

    }

    public static void main() {

        new SignUp1();
    }
}
