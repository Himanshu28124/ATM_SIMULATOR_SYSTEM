package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUp2 extends JFrame implements ActionListener{
    
    JTextField panfield,adharfield;
    JButton next; 
    JRadioButton yes,no,yes2,no2;
    JComboBox religion,category,income,education,occupation;
    String formno;
    
    SignUp2(String formno){
        
        this.formno = formno;
        
        setSize(850,800);
        setVisible(true);
        setLocation(200,10);
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
                
        JLabel additonalDetails = new JLabel("Page 2: Additional Details"); 
        additonalDetails.setBounds(290, 80, 400, 30);
        additonalDetails.setFont(new Font("RALEWAY",Font.BOLD,22));
        add(additonalDetails);
        
        JLabel name = new JLabel("Religion:"); 
        name.setFont(new Font("RALEWAY",Font.BOLD,20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        String valReligion[] = {"Hindu","Muslim","Christan","Sikh","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
                
        JLabel categ = new JLabel("Category:"); 
        categ.setFont(new Font("RALEWAY",Font.BOLD,20));
        categ.setBounds(100, 190, 200, 30);
        add(categ);
        
        String valCategory[] = {"General","OBC","ST","SC","OTHER"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel inc = new JLabel("Income:");
        inc.setFont(new Font("RALEWAY",Font.BOLD,20));
        inc.setBounds(100,240,200,30);
        add(inc);
        
        String incomeCategory[] = {"NULL","<1,50,000","<2,50,000","<5,00,000","UPTO 10,00,000"};
        income = new JComboBox(incomeCategory); 
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel edu = new JLabel("Education"); 
        edu.setFont(new Font("RALEWAY",Font.BOLD,20));
        edu.setBounds(100, 290, 200, 30);
        add(edu);
        JLabel qualification = new JLabel("Qualification: "); 
        qualification.setFont(new Font("RALEWAY",Font.BOLD,20));
        qualification.setBounds(100, 310, 200, 30);
        add(qualification);
        
        String educationCategory[] = {"Non-Gradute","Graduate","Pst-Gradute","Doctrate","Other"};
        education = new JComboBox(educationCategory); 
        education.setBackground(Color.WHITE);
        education.setBounds(300, 290, 400, 30);
        add(education);
        
        JLabel occup = new JLabel("Occupation:"); 
        occup.setFont(new Font("RALEWAY",Font.BOLD,20));
        occup.setBounds(100, 360, 200, 30);
        add(occup);
        
        String occupationVal[] = {"Salaried","Self-Employed","Bussiness","Retierde","Student","Other"};
        occupation = new JComboBox(occupationVal);
        occupation.setBackground(Color.WHITE);
        occupation.setBounds(300, 360, 400, 30);
        add(occupation);
       
        JLabel panNo = new JLabel("Pan Number:"); 
        panNo.setFont(new Font("RALEWAY",Font.BOLD,20));
        panNo.setBounds(100, 410, 200, 30);
        add(panNo);
        
        panfield = new JTextField();
        panfield.setFont(new Font("ARIAL",Font.BOLD,14));
        panfield.setBounds(300, 410, 400, 30);
        add(panfield);
        
        JLabel adhar = new JLabel("Adhar Number:"); 
        adhar.setFont(new Font("RALEWAY",Font.BOLD,20));
        adhar.setBounds(100, 460, 200, 30);
        add(adhar);
        
        adharfield = new JTextField();
        adharfield.setFont(new Font("ARIAL",Font.BOLD,14));
        adharfield.setBounds(300, 460, 400, 30);
        add(adharfield);
        
        JLabel citizen = new JLabel("Senior Citizen:"); 
        citizen.setFont(new Font("RALEWAY",Font.BOLD,20));
        citizen.setBounds(100, 510, 200, 30);
        add(citizen);
        
        yes = new JRadioButton("Yes");
        yes.setBounds(300, 510, 60, 30);
        yes.setBackground(Color.WHITE);
        add(yes);
        
        no = new JRadioButton("No");
        no.setBounds(450, 510, 120, 30);
        no.setBackground(Color.WHITE);
        add(no);
        
        ButtonGroup btn = new ButtonGroup();
        btn.add(yes);
        btn.add(no);
        
        JLabel account = new JLabel("Exixsting Account:"); 
        account.setFont(new Font("RALEWAY",Font.BOLD,20));
        account.setBounds(100, 560, 200, 30);
        add(account);
        
        yes2 = new JRadioButton("Yes");
        yes2.setBounds(300, 560, 100, 30);
        yes2.setBackground(Color.WHITE);
        add(yes2);
        
        no2 = new JRadioButton("No");
        no2.setBounds(450, 560, 100, 30);
        no2.setBackground(Color.WHITE);
        add(no2);
        
        ButtonGroup btn2 = new ButtonGroup();
        btn2.add(yes2);
        btn2.add(no2);
        
        next = new JButton("Next");
        next.setFont(new Font("RALWAY",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(600, 610, 80, 30);
        add(next);
        next.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
        String sreligion    =  (String)religion.getSelectedItem();
        String scategory    =  (String)category.getSelectedItem();
        String sincome      =  (String)income.getSelectedItem();
        String seducation   =  (String)education.getSelectedItem();
        String soccupation  =  (String)occupation.getSelectedItem();
        String pan = panfield.getText();
        String adhar = adharfield.getText();

        
        String citizen = null;
        if(yes.isSelected()){
            citizen = "Yes";
        }
        else if(no.isSelected()){
            citizen = "No";
        }
        
        String saccount = null;
        if(yes2.isSelected()){
            saccount = "Yes";
        }
        else if(no2.isSelected()){
            saccount = "No";
        }
       
        
        // hit the query
        try{
            Conn c = new Conn();
            String query = "insert into signup2 values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+pan+"','"+adhar+"','"+citizen+"','"+saccount+"')";
            c.s.executeUpdate(query); // execute query
            
            setVisible(false);
            new SignUp3(formno).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String []args){
        new SignUp2("");
    }
}

