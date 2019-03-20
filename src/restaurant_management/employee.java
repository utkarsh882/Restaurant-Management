/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant_management;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Presario
 */
public class employee extends JFrame implements ActionListener{
    JLabel lbname,lbaddress,lbid,lbpost,lbphone,jlpw,lbsalary;
	JTextField tfname,tfid,tfpost,tfphone,tfsalary;
	JButton jbsave,jbcancel,jbclear;
        JTextArea taaddress;
	Container c;
	Connection conn;
 	PreparedStatement pstmt;
    employee(){
        c=getContentPane();
		setSize(470,600);
		setTitle("Employee");
		c.setBackground(Color.lightGray);
		c.setLayout(null);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                
		javax.swing.border.Border border = BorderFactory.createLineBorder(Color.BLACK);
				
		lbname=new JLabel("Full Name :");
		lbname.setBounds(75,75,120,30);

		tfname=new JTextField();
		tfname.setBounds(255,75,120,30);
                tfname.setBorder(border);

				
		lbaddress=new JLabel("Address :");
		lbaddress.setBounds(75,135,120,30);

		taaddress=new JTextArea();
		taaddress.setBounds(255,135,120,80);
                taaddress.setBorder(border);

		lbid=new JLabel("Employee ID :");
		lbid.setBounds(75,245,120,30);

		tfid=new JTextField();
		tfid.setBounds(255,245,120,30);
                tfid.setBorder(border);

		lbpost=new JLabel("Post :");
		lbpost.setBounds(75,305,120,30);
		
		tfpost=new JTextField();
		tfpost.setBounds(255,305,120,30);
                tfpost.setBorder(border);
	
		
		lbphone=new JLabel("Phone No. :");
		lbphone.setBounds(75,365,120,30);
		
		tfphone=new JTextField();
		tfphone.setBounds(255,365,120,30);
                tfphone.setBorder(border);

		lbsalary=new JLabel("Salary :");
		lbsalary.setBounds(75,425,120,30);
		
		tfsalary=new JTextField();
		tfsalary.setBounds(255,425,120,30);
                tfsalary.setBorder(border);

		
   		
		jbsave=new JButton("Save");	
		jbsave.setBounds(65,500,100,30);

		jbcancel=new JButton("Back");	
		jbcancel.setBounds(185,500,100,30);

                jbclear = new JButton("Clear");
        jbclear.setBounds(305, 500, 100, 30);
				
		
		c.add(lbname);
		c.add(tfname);
		c.add(lbaddress);
		c.add(taaddress);	
		c.add(lbid);
		c.add(tfid);
		c.add(lbpost);
		c.add(tfpost);
		c.add(lbphone);
		c.add(tfphone);
		c.add(lbsalary);
		c.add(tfsalary);		
		c.add(jbsave);
		c.add(jbcancel);
                c.add(jbclear);
			
		jbsave.addActionListener(this);
		jbcancel.addActionListener(this);
		jbclear.addActionListener(this);
		setVisible(true);
		
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jbsave)
        {
            String name = tfname.getText();
            String address = taaddress.getText();
            Integer id = Integer.parseInt(tfid.getText());
            String post = tfpost.getText();
            String ph = tfphone.getText().trim();
            Long phone = Long.parseLong(ph);
            Integer salary = Integer.parseInt(tfsalary.getText());
            try{
                
                Class.forName("com.mysql.jdbc.Driver");
            
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "root");
                    PreparedStatement ps = conn.prepareStatement("insert into employee values(?,?,?,?,?,?)");
                    ps.setInt(1, id);
                    ps.setString(2, name);
                    ps.setString(3, address);
                    ps.setLong(4, phone);
                    ps.setString(5, post);
                    ps.setInt(6, salary);
                    ps.execute();
                    JOptionPane.showMessageDialog(this, "Data Saved Successfully");
                    tfname.setText("");
                    tfid.setText("");
                    tfpost.setText("");
                    tfphone.setText("");
                    tfsalary.setText("");
                    taaddress.setText("");
            }catch(Exception x){x.printStackTrace();}
 
            }
        if(e.getSource()== jbcancel){
                new Employee_1();
                setVisible(false);
        }
        if(e.getSource()== jbclear){
                tfname.setText("");
                tfid.setText("");
                tfpost.setText("");
                tfphone.setText("");
                tfsalary.setText("");
                taaddress.setText("");
        }
    }
   
    
}
