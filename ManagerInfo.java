package hostel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
        
public class ManagerInfo extends JFrame implements ActionListener {
    
    JTable t1;
    JButton b1,b2;
    
    ManagerInfo() {
        
        t1 = new JTable();
        t1.setBounds(5,20,975,400);
        add(t1);
        
        b1 = new JButton("Show Data");
        b1.setBackground(Color.black);
        b1.setForeground(Color.WHITE);
        b1.setBounds(500,440,120,30);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.black);
        b2.setForeground(Color.WHITE);
        b2.setBounds(320,440,120,30);
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.addActionListener(this);
        add(b2);
        
        JLabel l1 = new JLabel("NAME");
        l1.setBounds(50,5,60,10);
        add(l1);
        
        JLabel l2 = new JLabel("AGE");
        l2.setBounds(170,5,60,10);
        add(l2);
        
        JLabel l3 = new JLabel("GENDER");
        l3.setBounds(285,5,60,10);
        add(l3);
        
        JLabel l4 = new JLabel("JOB");
        l4.setBounds(415,5,60,10);
        add(l4);
        
        JLabel l5 = new JLabel("SALARY");
        l5.setBounds(530,5,60,10);
        add(l5);
        
        JLabel l6 = new JLabel("CONTACT NO.");
        l6.setBounds(635,5,90,10);
        add(l6);
        
        JLabel l7 = new JLabel("AADHAR NO.");
        l7.setBounds(760,5,90,10);
        add(l7);
        
        JLabel l8 = new JLabel("EMAIL");
        l8.setBounds(900,5,60,10);
        add(l8);
        
        getContentPane().setBackground(Color.white);
        
        setBounds(200,120,1000,540);
        setLayout(null);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == b1) {
            try {
                  
                conn c = new conn();
                String str = "select * from AddEmployee where job = 'Manager'";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else if(ae.getSource() == b2) {
            setVisible(false);
            new Reception().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        
        new ManagerInfo();
    } 
    
}


