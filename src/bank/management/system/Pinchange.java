package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pinchange extends JFrame implements ActionListener{
    
    JButton change,back;
    JPasswordField  repin,pin;
    String pinnumber;
    
    Pinchange(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        setSize(900,900);
        setLocation(200,0);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setBounds(250,280,500,35);
        text.setFont(new Font("RALEWAY",Font.BOLD,16));
        image.add(text);
        
        JLabel pintext = new JLabel("NEW PIN:");
        pintext.setForeground(Color.WHITE);
        pintext.setBounds(165,320,180,25);
        pintext.setFont(new Font("System",Font.BOLD,16));
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("RALEWAY",Font.BOLD,25));
        pin.setBounds(330,320,180,25);
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-Enter New PIN:");
        repintext.setForeground(Color.WHITE);
        repintext.setBounds(165,360,180,25);
        repintext.setFont(new Font("System",Font.BOLD,16));
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("RALEWAY",Font.BOLD,25));
        repin.setBounds(330,360,180,25);
        image.add(repin);
        
        change = new JButton("Change");
        change.setBounds(355,485,150,30);
        image.add(change);
        change.addActionListener(this);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        image.add(back);
        back.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            String npin = pin.getText();
            String rpin = repin.getText();
            
            if(ae.getSource()==change){
                
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"Enterd PIN does not match");
                return;
            }
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"Enterd enter PIN");
                return;
            }
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null,"Enterd Re-Enter PIN");
                return;
            }
            
            Conn c = new Conn();
            String query1 = "update bank set pin = '"+npin+"' where pin = '"+pinnumber+"'";
            String query2 = "update login set pinNumber = '"+npin+"' where pinNumber = '"+pinnumber+"'";
            String query3 = "update signup3 set pinNumber = '"+npin+"' where pinNumber = '"+pinnumber+"'";
            
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            c.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null, "PIN change sucessfully");
            setVisible(false);
            new Transaction(npin).setVisible(true);
        }
        }catch(Exception e){
            System.out.println(e);
        }
       
    }
    public static void main(String args[]){
        new Pinchange("").setVisible(true);
    }
}
