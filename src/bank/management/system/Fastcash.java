package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class Fastcash extends JFrame implements ActionListener{
    
    JButton hundred,five,thoushand,twothousand,fivethousand,tenthousand,back;
    String pinnumber;
    
    Fastcash(String pinnumber){
        
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
        
        JLabel text = new JLabel("Please Select the amount to wihdraw");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("SYSTEM",Font.BOLD,16));
        img.add(text);
               
        hundred = new JButton("Rs 100");
        hundred.setBounds(170, 415, 150, 30);
        img.add(hundred);
        hundred.addActionListener(this);
        
        five = new JButton("Rs 500");
        five.setBounds(355, 415, 150, 30);
        img.add(five);
        five.addActionListener(this);
        
        thoushand = new JButton("Rs 1000");
        thoushand.setBounds(170, 450, 150, 30);
        img.add(thoushand);
        thoushand.addActionListener(this);
        
        twothousand = new JButton("Rs 2000");
        twothousand.setBounds(355, 450, 150, 30);
        img.add(twothousand);
        twothousand.addActionListener(this);
        
        fivethousand = new JButton("Rs 5000");
        fivethousand.setBounds(170, 485, 150, 30);
        img.add(fivethousand);
        fivethousand.addActionListener(this);
        
        tenthousand = new JButton("Rs 10000");
        tenthousand.setBounds(355, 485, 150, 30);
        img.add(tenthousand);
        tenthousand.addActionListener(this);
        
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        img.add(back);
        back.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                
                ResultSet rs = c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
                int balance = 0;
                
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(ae.getSource()!=back && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"insufficient Balance");
                    return;
                }
                
                Date date  = new Date(); 
                String query = "insert into bank values('"+pinnumber+"','"+date+"','withdraw','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited succesfully");
                
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String[]args){
        new Fastcash("");
    }
}



