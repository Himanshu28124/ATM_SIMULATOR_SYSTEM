package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame{
    
    String pinnumber;
    
    MiniStatement(String pinnumber){
        
        this.pinnumber= pinnumber;
        setTitle("Mini Statement");
        
        
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pinNumber='"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number = "+rs.getString("cardNumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardNumber").substring(12));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        JLabel balance = new JLabel();
        balance.setBounds(20,300,300,20);
        add(balance);
        
        JLabel mini = new JLabel();
        mini.setBounds(20,120,400,200);
        add(mini);
        
        try{
            int bal = 0;
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
            while(rs.next()){
               mini.setText(mini.getText() + "<html>" + rs.getString("date") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs.getString("amount")+ "<br><br><html>");
            
               if(rs.getString("type").equals("Deposit")){
                   bal += Integer.parseInt(rs.getString("amount"));
               }
               else{
                   bal -= Integer.parseInt(rs.getString("amount"));
               }
            }
            balance.setText("Your Balance is Rs "+bal);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        setLayout(null);
        setSize(400,500);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
    }
    
    public static void main(String []args){
        new MiniStatement("").setVisible(true);
    }
}
