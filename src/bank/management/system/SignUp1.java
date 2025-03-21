package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUp1 extends JFrame implements ActionListener{
    long random;
    JTextField namefield,fnamefield,emailfield,addressfield,cityfield,statefield,pinfield;
    JButton next; 
    JRadioButton male,female,married,unmarried,other;
    JDateChooser datechooser;
    
    SignUp1(){
        
        setSize(850,800);
        setVisible(true);
        setLocation(200,10);
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong()%9000L)+1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO. "+random); 
        formno.setBounds(140, 20, 600, 40);
        formno.setFont(new Font("RALEWAY",Font.BOLD,38));
        add(formno);
        
        JLabel personDetails = new JLabel("Page 1: Personal Details"); 
        personDetails.setBounds(290, 80, 400, 30);
        personDetails.setFont(new Font("RALEWAY",Font.BOLD,22));
        add(personDetails);
        
        JLabel name = new JLabel("Name:"); 
        name.setFont(new Font("RALEWAY",Font.BOLD,20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        namefield = new JTextField();
        namefield.setFont(new Font("ARIAL",Font.BOLD,14));
        namefield.setBounds(300, 140, 400, 30);
        add(namefield);
                
        JLabel fname = new JLabel("Father's Name:"); 
        fname.setFont(new Font("RALEWAY",Font.BOLD,20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        fnamefield = new JTextField();
        fnamefield.setFont(new Font("ARIAL",Font.BOLD,14));
        fnamefield.setBounds(300, 190, 400, 30);
        add(fnamefield);
        
        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("RALWAY",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        datechooser = new JDateChooser();
        datechooser.setBounds(300, 240, 400, 30);
        datechooser.setBackground(Color.WHITE);
        add(datechooser);
        
        JLabel gender = new JLabel("Gender:"); 
        gender.setFont(new Font("RALEWAY",Font.BOLD,20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup btn = new ButtonGroup();
        btn.add(male);
        btn.add(female);
        
        JLabel email = new JLabel("Email Address:"); 
        email.setFont(new Font("RALEWAY",Font.BOLD,20));
        email.setBounds(100, 340, 200, 30);
        add(email);
        
        emailfield = new JTextField();
        emailfield.setFont(new Font("ARIAL",Font.BOLD,14));
        emailfield.setBounds(300, 340, 400, 30);
        add(emailfield);
        
        JLabel marital = new JLabel("Marriage Status:"); 
        marital.setFont(new Font("RALEWAY",Font.BOLD,20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBounds(630, 390, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup btn2 = new ButtonGroup();
        btn2.add(married);
        btn2.add(unmarried);
        btn2.add(other);
        
        JLabel address = new JLabel("Address:"); 
        address.setFont(new Font("RALEWAY",Font.BOLD,20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        addressfield = new JTextField();
        addressfield.setFont(new Font("ARIAL",Font.BOLD,14));
        addressfield.setBounds(300, 440, 400, 30);
        add(addressfield);
        
        JLabel city = new JLabel("City:"); 
        city.setFont(new Font("RALEWAY",Font.BOLD,20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        cityfield = new JTextField();
        cityfield.setFont(new Font("ARIAL",Font.BOLD,14));
        cityfield.setBounds(300, 490, 400, 30);
        add(cityfield);
        
        JLabel state = new JLabel("State:"); 
        state.setFont(new Font("RALEWAY",Font.BOLD,20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        statefield = new JTextField();
        statefield.setFont(new Font("ARIAL",Font.BOLD,14));
        statefield.setBounds(300, 540, 400, 30);
        add(statefield);
        
        JLabel pin = new JLabel("Pin Code:"); 
        pin.setFont(new Font("RALEWAY",Font.BOLD,20));
        pin.setBounds(100, 590, 200, 30);
        add(pin);
        
        pinfield = new JTextField();
        pinfield.setFont(new Font("ARIAL",Font.BOLD,14));
        pinfield.setBounds(300, 590, 400, 30);
        add(pinfield);
        
        next = new JButton("Next");
        next.setFont(new Font("RALWAY",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(600, 630, 80, 30);
        add(next);
        next.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String formno = " "+random;
        String name = namefield.getText();
        String fname = fnamefield.getText();
        String email = emailfield.getText();
        String address = addressfield.getText();
        String city = cityfield.getText();
        String state = statefield.getText();
        String pin = pinfield.getText();
        
        String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
        
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }
        else if(female.isSelected()){
            gender = "Female";
        }
        
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        }
        else if(unmarried.isSelected()){
            marital = "Unmarried";
        }
        else if(other.isSelected()){
            marital = "Other";
        }
        
        // hit the query
        try{
            if(name.isEmpty()){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+email+"','"+address+"','"+city+"','"+state+"','"+pin+"','"+dob+"','"+gender+"','"+marital+"')";
                c.s.executeUpdate(query); // execure query
                
                setVisible(false);
                new SignUp2(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        
    }
    
    public static void main(String []args){
        new SignUp1();
    }
}
