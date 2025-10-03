package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp3 extends JFrame implements ActionListener {

    JRadioButton savingAc, fdAccount, currentAc, rcAccount;

    JCheckBox atmBtn, netBankingBtn, mobBankingBtn, emailBankingBtn, cheqBookBtn, smsBtn;

    JButton submitBtn, cancelBtn;

    SignUp3() {

        super("APPLICATION FORM");

        ImageIcon bankLogo = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image bLogo = bankLogo.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon bankLogo1 = new ImageIcon(bLogo);
        JLabel image = new JLabel(bankLogo1);
        image.setBounds(25, 10, 100, 100);
        add(image);

        JLabel pageNumLabel = new JLabel("Page 3");
        pageNumLabel.setFont(new Font("Raleway", Font.BOLD, 15));
        pageNumLabel.setBounds(420, 30, 600, 30);
        pageNumLabel.setForeground(Color.BLACK);
        add(pageNumLabel);

        JLabel accountDetails = new JLabel("Account Details");
        accountDetails.setForeground(Color.BLACK);
        accountDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        accountDetails.setBounds(360, 60, 600, 30);
        add(accountDetails);

        JLabel accountType = new JLabel("Account Type :");
        accountType.setForeground(Color.BLACK);
        accountType.setFont(new Font("Raleway", Font.BOLD, 18));
        accountType.setBounds(100, 150, 200, 30);
        add(accountType);

        savingAc = new JRadioButton("Saving Account");
        savingAc.setForeground(Color.BLACK);
        savingAc.setFont(new Font("Raleway", Font.BOLD, 16));
        savingAc.setBounds(110, 190, 200, 30);
        savingAc.setBackground(new Color(100, 149, 237));
        add(savingAc);

        fdAccount = new JRadioButton("Fixed Deposit Account");
        fdAccount.setForeground(Color.BLACK);
        fdAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        fdAccount.setBounds(310, 190, 250, 30);
        fdAccount.setBackground(new Color(100, 149, 237));
        add(fdAccount);

        currentAc = new JRadioButton("Current Account");
        currentAc.setForeground(Color.BLACK);
        currentAc.setFont(new Font("Raleway", Font.BOLD, 16));
        currentAc.setBounds(110, 230, 200, 30);
        currentAc.setBackground(new Color(100, 149, 237));
        add(currentAc);

        rcAccount = new JRadioButton("Recurring Deposit Account");
        rcAccount.setForeground(Color.BLACK);
        rcAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        rcAccount.setBounds(310, 230, 250, 30);
        rcAccount.setBackground(new Color(100, 149, 237));
        add(rcAccount);

        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(savingAc);
        btnGroup.add(fdAccount);
        btnGroup.add(currentAc);
        btnGroup.add(rcAccount);

        JLabel cardNumLabel = new JLabel("Card Number : ");
        cardNumLabel.setForeground(Color.BLACK);
        cardNumLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        cardNumLabel.setBounds(100, 280, 200, 30);
        add(cardNumLabel);

        JLabel cardNumLength = new JLabel("(Enter your 16-digit card number)");
        cardNumLength.setForeground(Color.BLACK);
        cardNumLength.setFont(new Font("Raleway", Font.BOLD, 12));
        cardNumLength.setBounds(100, 310, 200, 20);
        add(cardNumLength);

        JLabel cardNumDemo = new JLabel("XXXX-XXXX-XXXX-0510");
        cardNumDemo.setForeground(Color.BLACK);
        cardNumDemo.setFont(new Font("Raleway", Font.BOLD, 18));
        cardNumDemo.setBounds(350, 280, 200, 30);
        add(cardNumDemo);

        JLabel cardNumInfo = new JLabel("(It would appear on ATM card/Cheque Book)");
        cardNumInfo.setForeground(Color.BLACK);
        cardNumInfo.setFont(new Font("Raleway", Font.BOLD, 12));
        cardNumInfo.setBounds(330, 310, 500, 20);
        add(cardNumInfo);

        JLabel pinLabel = new JLabel("PIN :");
        pinLabel.setForeground(Color.BLACK);
        pinLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        pinLabel.setBounds(100, 350, 200, 30);
        add(pinLabel);

        JLabel pinDemo = new JLabel("XXXX");
        pinDemo.setForeground(Color.BLACK);
        pinDemo.setFont(new Font("Raleway", Font.BOLD, 18));
        pinDemo.setBounds(350, 350, 200, 30);
        add(pinDemo);

        JLabel pinInfo = new JLabel("(4-digit password/PIN)");
        pinInfo.setForeground(Color.BLACK);
        pinInfo.setFont(new Font("Raleway", Font.BOLD, 12));
        pinInfo.setBounds(100, 380, 250, 20);
        add(pinInfo);

        JLabel servicesLabel = new JLabel("Services Required :");
        servicesLabel.setForeground(Color.BLACK);
        servicesLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        servicesLabel.setBounds(100, 420, 250, 30);
        add(servicesLabel);

        atmBtn = new JCheckBox("ATM Card");
        atmBtn.setForeground(Color.BLACK);
        atmBtn.setBackground(new Color(100, 149, 237));
        atmBtn.setFont(new Font("Raleway", Font.BOLD, 16));
        atmBtn.setBounds(110, 450, 200, 30);
        add(atmBtn);

        netBankingBtn = new JCheckBox("Net Banking");
        netBankingBtn.setForeground(Color.BLACK);
        netBankingBtn.setBackground(new Color(100, 149, 237));
        netBankingBtn.setFont(new Font("Raleway", Font.BOLD, 16));
        netBankingBtn.setBounds(310, 450, 200, 30);
        add(netBankingBtn);

        mobBankingBtn = new JCheckBox("Mobile Banking");
        mobBankingBtn.setForeground(Color.BLACK);
        mobBankingBtn.setBackground(new Color(100, 149, 237));
        mobBankingBtn.setFont(new Font("Raleway", Font.BOLD, 16));
        mobBankingBtn.setBounds(110, 490, 200, 30);
        add(mobBankingBtn);

        emailBankingBtn = new JCheckBox("Email Alert");
        emailBankingBtn.setForeground(Color.BLACK);
        emailBankingBtn.setBackground(new Color(100, 149, 237));
        emailBankingBtn.setFont(new Font("Raleway", Font.BOLD, 16));
        emailBankingBtn.setBounds(310, 490, 200, 30);
        add(emailBankingBtn);

        cheqBookBtn = new JCheckBox("Cheque Book");
        cheqBookBtn.setForeground(Color.BLACK);
        cheqBookBtn.setBackground(new Color(100, 149, 237));
        cheqBookBtn.setFont(new Font("Raleway", Font.BOLD, 16));
        cheqBookBtn.setBounds(110, 530, 200, 30);
        add(cheqBookBtn);

        smsBtn = new JCheckBox("SMS Alert");
        smsBtn.setForeground(Color.BLACK);
        smsBtn.setBackground(new Color(100, 149, 237));
        smsBtn.setFont(new Font("Raleway", Font.BOLD, 16));
        smsBtn.setBounds(310, 530, 200, 30);
        add(smsBtn);

        JCheckBox acknowledgeBox = new JCheckBox("I here by declare that above entered details are true to my knowledge.", true);
        acknowledgeBox.setForeground(Color.BLACK);
        acknowledgeBox.setBackground(new Color(100, 149, 237));
        acknowledgeBox.setFont(new Font("Raleway", Font.BOLD, 14));
        acknowledgeBox.setBounds(100, 580, 700, 30);
        add(acknowledgeBox);

        JLabel formLabel = new JLabel("Form Number : ");
        formLabel.setForeground(Color.BLACK);
        formLabel.setFont(new Font("Raleway", Font.BOLD, 14));
        formLabel.setBounds(600, 10, 150, 30);
        add(formLabel);

        JLabel formNumLabel = new JLabel();
        formNumLabel.setForeground(Color.BLACK);
        formNumLabel.setFont(new Font("Raleway", Font.BOLD, 14));
        formNumLabel.setBounds(700, 10, 100, 30);
        add(formNumLabel);

        submitBtn = new JButton("Submit");
        submitBtn.setFont(new Font("Raleway", Font.BOLD, 14));
        submitBtn.setBackground(Color.WHITE);
        submitBtn.setForeground(Color.BLACK);
        submitBtn.setBounds(250, 650, 100, 30);
        submitBtn.addActionListener(this);
        add(submitBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setFont(new Font("Raleway", Font.BOLD, 14));
        cancelBtn.setBackground(Color.WHITE);
        cancelBtn.setForeground(Color.BLACK);
        cancelBtn.setBounds(500, 650, 100, 30);
        cancelBtn.addActionListener(this);
        add(cancelBtn);


        setLayout(null);
        setSize(850, 750);
        setLocation(450, 80);
        getContentPane().setBackground(new Color(100, 149, 237));
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    static void main() {

        new SignUp3();
    }
}
