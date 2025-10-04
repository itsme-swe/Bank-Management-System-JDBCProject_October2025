package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class SignUp2 extends JFrame implements ActionListener {

    JComboBox religionList, categoryList, incomeList, educationList; // used to create drop down menu

    JTextField panDetailsField, aadharField;

    JRadioButton yes, no, y, n;

    JButton next;

    String formNum;

    SignUp2(String formNum) {

        super("APPLICATION FORM");

        ImageIcon bankLogo = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image bLogo = bankLogo.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon bankLogo1 = new ImageIcon(bLogo);
        JLabel image = new JLabel(bankLogo1);
        image.setBounds(25, 10, 100, 100);
        add(image);

        // storing form num from Page1 to this new page
        this.formNum = formNum;

        JLabel pageNumLabel = new JLabel("Page 2");
        pageNumLabel.setFont(new Font("Raleway", Font.BOLD, 15));
        pageNumLabel.setBounds(430, 30, 600, 30);
        pageNumLabel.setForeground(Color.BLACK);
        add(pageNumLabel);

        JLabel additionalInfo = new JLabel("Additional Details");
        additionalInfo.setForeground(Color.BLACK);
        additionalInfo.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalInfo.setBounds(360, 60, 600, 30);
        add(additionalInfo);

        JLabel religionLabel = new JLabel("Religion :");
        religionLabel.setForeground(Color.BLACK);
        religionLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        religionLabel.setBounds(100, 150, 100, 30);
        add(religionLabel);

        // creating dropdown menu for selecting religion
        String[] religion = {"Hindu", "Muslim", "Sikh", "Christian", "other"};
        religionList = new JComboBox(religion);
        religionList.setBackground(new Color(100, 149, 237));
        religionList.setFont(new Font("Raleway", Font.BOLD, 14));
        religionList.setBounds(350, 150, 320, 30);
        add(religionList);

        JLabel categoryLabel = new JLabel("Category : ");
        categoryLabel.setForeground(Color.BLACK);
        categoryLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        categoryLabel.setBounds(100, 200, 100, 30);
        add(categoryLabel);

        String[] category = {"General", "OBC", "SC", "ST", "other"};
        categoryList = new JComboBox(category);
        categoryList.setBackground(new Color(100, 149, 237));
        categoryList.setFont(new Font("Raleway", Font.BOLD, 14));
        categoryList.setBounds(350, 200, 320, 30);
        add(categoryList);

        JLabel incomeLabel = new JLabel("Income : ");
        incomeLabel.setForeground(Color.BLACK);
        incomeLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        incomeLabel.setBounds(100, 250, 100, 30);
        add(incomeLabel);

        String[] income = {"No income", "< 1,50,000", "< 5,00,000", "Upto 10,00,000", "Above 10,00,000"};
        incomeList = new JComboBox(income);
        incomeList.setBackground(new Color(100, 149, 237));
        incomeList.setFont(new Font("Raleway", Font.BOLD, 14));
        incomeList.setBounds(350, 250, 320, 30);
        add(incomeList);

        JLabel educationLabel = new JLabel("Education : ");
        educationLabel.setForeground(Color.BLACK);
        educationLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        educationLabel.setBounds(100, 300, 150, 30);
        add(educationLabel);

        String[] education = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Other"};
        educationList = new JComboBox(education);
        educationList.setBackground(new Color(100, 149, 237));
        educationList.setFont(new Font("Raleway", Font.BOLD, 14));
        educationList.setBounds(350, 300, 320, 30);
        add(educationList);

        JLabel panLabel = new JLabel("PAN Number : ");
        panLabel.setForeground(Color.BLACK);
        panLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        panLabel.setBounds(100, 350, 150, 30);
        add(panLabel);

        panDetailsField = new JTextField();
        panDetailsField.setFont(new Font("Raleway", Font.BOLD, 16));
        panDetailsField.setForeground(Color.BLACK);
        panDetailsField.setBounds(350, 350, 300, 30);
        add(panDetailsField);

        JLabel aadharLabel = new JLabel("Aadhar Number : ");
        aadharLabel.setForeground(Color.BLACK);
        aadharLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        aadharLabel.setBounds(100, 400, 200, 30);
        add(aadharLabel);

        aadharField = new JTextField();
        aadharField.setFont(new Font("Raleway", Font.BOLD, 16));
        aadharField.setForeground(Color.BLACK);
        aadharField.setBounds(350, 400, 300, 30);
        add(aadharField);

        JLabel seniorCitizenLabel = new JLabel("Senior Citizen : ");
        seniorCitizenLabel.setForeground(Color.BLACK);
        seniorCitizenLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        seniorCitizenLabel.setBounds(100, 450, 200, 30);
        add(seniorCitizenLabel);

        yes = new JRadioButton("Yes");
        yes.setForeground(Color.BLACK);
        yes.setBackground(new Color(100, 149, 237));
        yes.setFont(new Font("Raleway", Font.BOLD, 16));
        yes.setBounds(350, 450, 100, 30);
        add(yes);

        no = new JRadioButton("No");
        no.setForeground(Color.BLACK);
        no.setBackground(new Color(100, 149, 237));
        no.setFont(new Font("Raleway", Font.BOLD, 16));
        no.setBounds(450, 450, 100, 30);
        add(no);

        ButtonGroup btnGroup1 = new ButtonGroup();
        btnGroup1.add(yes);
        btnGroup1.add(no);

        JLabel existingAccLabel = new JLabel("Existing Account : ");
        existingAccLabel.setForeground(Color.BLACK);
        existingAccLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        existingAccLabel.setBounds(100, 500, 200, 30);
        add(existingAccLabel);

        y = new JRadioButton("YES");
        y.setForeground(Color.BLACK);
        y.setBackground(new Color(100, 149, 237));
        y.setFont(new Font("Raleway", Font.BOLD, 16));
        y.setBounds(350, 500, 100, 30);
        add(y);

        n = new JRadioButton("NO");
        n.setForeground(Color.BLACK);
        n.setBackground(new Color(100, 149, 237));
        n.setFont(new Font("Raleway", Font.BOLD, 16));
        n.setBounds(450, 500, 100, 30);
        add(n);

        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(y);
        btnGroup.add(n);

        JLabel formLabel = new JLabel("Form Number : ");
        formLabel.setForeground(Color.BLACK);
        formLabel.setFont(new Font("Raleway", Font.BOLD, 14));
        formLabel.setBounds(600, 10, 150, 30);
        add(formLabel);

        JLabel formNumLabel = new JLabel(formNum);
        formNumLabel.setForeground(Color.BLACK);
        formNumLabel.setFont(new Font("Raleway", Font.BOLD, 14));
        formNumLabel.setBounds(700, 10, 200, 30);
        add(formNumLabel);

        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setBounds(380, 650, 100, 30);
        next.addActionListener(this);
        add(next);


        setLayout(null);
        setSize(850, 750);
        setLocation(450, 80);
        getContentPane().setBackground(new Color(100, 149, 237));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String religion = (String) religionList.getSelectedItem();
        String category = (String) categoryList.getSelectedItem();
        String income = (String) incomeList.getSelectedItem();
        String education = (String) educationList.getSelectedItem();

        String pan_num = panDetailsField.getText();
        String aadhar_num = aadharField.getText();

        String senCitizen = null;
        if (yes.isSelected()) {
            senCitizen = "Yes";
        } else if (no.isSelected()) {
            senCitizen = "No";
        }

        String accValidate = null;
        if (y.isSelected()) {
            accValidate = "YES";
        } else if (n.isSelected()) {
            accValidate = "NO";
        }

        PreparedStatement preStatement;

        try {

            if (panDetailsField.getText().equals("") || aadharField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            } else {

                DBConnection dbConnect = new DBConnection();

                String insertQuery = "insert into signuptwo(form_num, religion, category, income, education, pan_number, aadhar_number, senior_citizen, existing_account) values (?,?,?,?,?,?,?,?,?)";

                preStatement = dbConnect.preparedStatement(insertQuery);

                preStatement.setString(1, formNum);
                preStatement.setString(2, religion);
                preStatement.setString(3, category);
                preStatement.setString(4, income);
                preStatement.setString(5, education);
                preStatement.setString(6, pan_num);
                preStatement.setString(7, aadhar_num);
                preStatement.setString(8, senCitizen);
                preStatement.setString(9, accValidate);

                preStatement.executeUpdate();

                new SignUp3(formNum);
                setVisible(false);

                System.out.println("Data inserted successfully");

                preStatement.close();
                dbConnect.close();
            }


        } catch (Exception err) {
            System.out.println(err.getMessage());
        }


    }

    static void main() {


    }
}
