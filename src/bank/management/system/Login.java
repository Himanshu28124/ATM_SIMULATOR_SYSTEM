package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinPasswordField;
    
    Login(){
        
        setLayout(null);
        setTitle("Automate Teller Machine");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
       
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("OSWARD",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel card = new JLabel("Card No.");
        card.setFont(new Font("RALEWAT",Font.BOLD,28));
        card.setBounds(120,150,150,30);
        add(card);
        
        cardTextField = new JTextField();
        cardTextField.setFont(new Font("ARIAL",Font.BOLD,14));
        cardTextField.setBounds(300,150,230,30);
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("RALEWAY",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);
        
        pinPasswordField = new JPasswordField();
        pinPasswordField.setFont(new Font("ARIAL",Font.BOLD,14));
        pinPasswordField.setBounds(300,220,230,30);
        add(pinPasswordField);
        
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
        
        clear.addActionListener(this);
        login.addActionListener(this);
        signup.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinPasswordField.setText("");
            
        }
        else if(ae.getSource()==login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinPasswordField.getText();
            String query = "select * from login where cardNumber= '"+cardnumber+"' and pinNumber='"+pinnumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect card number or pin");
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
            
        }
        else if(ae.getSource()== signup){
            setVisible(false);
            
            new SignUp1().setVisible(true);
        }
    }
    public static void main(String[]a){
        new Login();
    }
}
