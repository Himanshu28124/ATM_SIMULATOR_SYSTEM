package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignUp3 extends JFrame implements ActionListener{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox b1,b2,b3,b4,b5,b6,b7;
    JButton submit,cancel;
    String formno;
    
    SignUp3(String formno){
        
        this.formno = formno;
        
        setSize(850,820);
        setVisible(true);
        setLocation(350,0);
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
                
        JLabel additonalDetails = new JLabel("Page 3: Account Details"); 
        additonalDetails.setBounds(280, 40, 400, 40);
        additonalDetails.setFont(new Font("RALEWAY",Font.BOLD,22));
        add(additonalDetails);
        
        JLabel type = new JLabel("Account Type");
        type.setBounds(100,140,200,30);
        type.setFont(new Font("RALEWAY",Font.BOLD,22));
        add(type);
        
        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font("RALEWAY",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,180,20);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("RALEWAY",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,200,20);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("RALEWAY",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,180,20);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("RALEWAY",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,250,20);
        add(r4);
        
        ButtonGroup btn1 = new ButtonGroup();
        btn1.add(r1);
        btn1.add(r2);
        btn1.add(r3);
        btn1.add(r4);
        
        JLabel card = new JLabel("Card Number"); 
        card.setFont(new Font("RALEWAY",Font.BOLD,22));
        card.setBounds(100, 300, 200, 40);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184"); 
        number.setFont(new Font("RALEWAY",Font.BOLD,22));
        number.setBounds(330, 310, 300, 30);
        add(number);
        
        JLabel data = new JLabel("Your 16 Digit Card Number"); 
        data.setFont(new Font("RALEWAY",Font.BOLD,10));
        data.setBounds(100, 320, 300, 40);
        add(data);
        
        JLabel pin = new JLabel("PIN:"); 
        pin.setFont(new Font("RALEWAY",Font.BOLD,22));
        pin.setBounds(100, 380, 200, 40);
        add(pin);
        
        JLabel pdata = new JLabel("Your 4 Digit Password"); 
        pdata.setFont(new Font("RALEWAY",Font.BOLD,10));
        pdata.setBounds(100, 400, 300, 40);
        add(pdata);
        
        JLabel pnumber = new JLabel("XXXX"); 
        pnumber.setFont(new Font("RALEWAY",Font.BOLD,22));
        pnumber.setBounds(330, 390, 300, 30);
        add(pnumber);
        
        JLabel service = new JLabel("Service Required:"); 
        service.setFont(new Font("RALEWAY",Font.BOLD,22));
        service.setBounds(100, 450, 200, 40);
        add(service);
        
        b1 = new JCheckBox("ATM CARD");
        b1.setFont(new Font("RALEWAY",Font.BOLD,16));
        b1.setBounds(100,480,180,40);
        b1.setBackground(Color.WHITE);
        add(b1);
        
        b2 = new JCheckBox("Internet Banking");
        b2.setFont(new Font("RALEWAY",Font.BOLD,16));
        b2.setBounds(350,480,180,40);
        b2.setBackground(Color.WHITE);
        add(b2);
        
        b3 = new JCheckBox("Mobile Banking");
        b3.setFont(new Font("RALEWAY",Font.BOLD,16));
        b3.setBounds(100,510,180,40);
        b3.setBackground(Color.WHITE);
        add(b3);
        
        b4 = new JCheckBox("EMAIL & SMS Alerts");
        b4.setFont(new Font("RALEWAY",Font.BOLD,16));
        b4.setBounds(350,510,200,40);
        b4.setBackground(Color.WHITE);
        add(b4);
        
        b5 = new JCheckBox("Cheque Book");
        b5.setFont(new Font("RALEWAY",Font.BOLD,16));
        b5.setBounds(100,540,180,40);
        b5.setBackground(Color.WHITE);
        add(b5);
        
        b6 = new JCheckBox("E-Statement");
        b6.setFont(new Font("RALEWAY",Font.BOLD,16));
        b6.setBounds(350,540,180,40);
        b6.setBackground(Color.WHITE);
        add(b6);
              
        b7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        b7.setFont(new Font("RALEWAY",Font.BOLD,12));
        b7.setBounds(100,600,600,30);
        b7.setBackground(Color.WHITE);
        add(b7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250,620,80,40);
        add(submit);
        submit.addActionListener(this);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(380,620,80,40);
        add(cancel);
        cancel.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==submit){
            String type = null;
            if(r1.isSelected()){
                type = "Savings Account";
            }
            else if(r2.isSelected()){
                type = "Fixed Deposit Account";
            }
            else if(r3.isSelected()){
                type = "Current Account";
            }
            else if(r4.isSelected()){
                type = "Recurring Deposit Account";
            }
        
            Random random = new Random();
            String card = "" + Math.abs((random.nextLong() % 90000000L)+5040936000000000L);
            
            String pin = ""+Math.abs((random.nextLong() % 9000L)+1000L);
            
            String service="";
            if(b1.isSelected()){
                service = service+"ATM CARD ";
            }
            if(b2.isSelected()){
                service = service+"Internet Banking ";
            }
            if(b3.isSelected()){
                service = service+"Mobile Banking ";
            }
            if(b4.isSelected()){
                service = service+"EMAIL & SMS Alerts ";
            }
            if(b5.isSelected()){
                service = service+"Cheque Book ";
            }
            if(b6.isSelected()){
                service =service+ "E-Statemen ";
            }
       
            try{
                Conn c = new Conn();
                String query1 = "insert into signup3 values('"+formno+"','"+type+"','"+card+"','"+pin+"','"+service+"')";
                c.s.executeUpdate(query1);
                
                String query2 = "insert into login values('"+formno+"','"+card+"','"+pin+"')";
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"Card Number:"+card+"\nPIN:"+pin);
                
                setVisible(false);
                new Deposit(pin).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
        
        
    }
    
    public static void main(String []args){
        new SignUp3("");
    }
}


