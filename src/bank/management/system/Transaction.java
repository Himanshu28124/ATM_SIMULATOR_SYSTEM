package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Transaction extends JFrame implements ActionListener{
    
    JButton deposit,withdraw,fastcash,ministatement,pinchange,balance,exit;
    String pinnumber;
    
    Transaction(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        setSize(900,900);
        setLocation(200,0);
        //setUndecorated(true);
        setVisible(true);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3  = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,900,900);
        add(img);
        
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("SYSTEM",Font.BOLD,16));
        img.add(text);
               
        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        img.add(deposit);
        deposit.addActionListener(this);
        
        withdraw = new JButton("Cash Withdraw");
        withdraw.setBounds(355, 415, 150, 30);
        img.add(withdraw);
        withdraw.addActionListener(this);
        
        fastcash = new JButton("FastCash");
        fastcash.setBounds(170, 450, 150, 30);
        img.add(fastcash);
        fastcash.addActionListener(this);
        
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355, 450, 150, 30);
        img.add(ministatement);
        ministatement.addActionListener(this);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170, 485, 150, 30);
        img.add(pinchange);
        pinchange.addActionListener(this);
        
        balance = new JButton("Balance Enqiry");
        balance.setBounds(355, 485, 150, 30);
        img.add(balance);
        balance.addActionListener(this);
        
        exit = new JButton("Exit");
        exit.setBounds(355, 520, 150, 30);
        img.add(exit);
        exit.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }
        else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdraw){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash){
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pinchange){
            setVisible(false);
            new Pinchange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balance){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==ministatement){
            
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[]args){
        new Transaction("");
    }
}


