/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant_management;

/**
 *
 * @author Presario
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class SignUp extends JFrame implements ActionListener
{
	
	JLabel jlb,jlfna,jllna,jldob,jlqu,jlph,jlpw,jlem;
	JTextField jtfna,jtlna,jtdob,jtqu,jtph,jtem;
	JPasswordField jtpw;
	JButton jbsav,jblog;
	Container c;
	Connection conn;
 	PreparedStatement pstmt;
	
	SignUp()
	{
	 try
  	 {
  	 Class.forName("com.mysql.jdbc.Driver");
  	 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "root");
  	 }
  	 catch(ClassNotFoundException e)
  	 {
  	 System.out.println("class not exception");
  	 }
  	 catch(SQLException e)
  	 {
  	 System.out.println("sql exception"+e.getMessage());
  	 }	  
	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		c=getContentPane();
		setSize(470,600);
		setTitle("Signup");
		c.setBackground(Color.lightGray);
		c.setLayout(null);

		
//		
		
				
		jlfna=new JLabel("First Name");
		jlfna.setBounds(75,75,120,30);

		jtfna=new JTextField();
		jtfna.setBounds(255,75,120,30);

				
		jllna=new JLabel("Last Name");
		jllna.setBounds(75,135,120,30);

		jtlna=new JTextField();
		jtlna.setBounds(255,135,120,30);

		jldob=new JLabel("Date of Birth");
		jldob.setBounds(75,195,120,30);

		jtdob=new JTextField();
		jtdob.setBounds(255,195,120,30);

		jlqu=new JLabel("Qualification");
		jlqu.setBounds(75,255,120,30);
		
		jtqu=new JTextField();
		jtqu.setBounds(255,255,120,30);
	
		
		jlph=new JLabel("Phone No.");
		jlph.setBounds(75,315,120,30);
		
		jtph=new JTextField();
		jtph.setBounds(255,315,120,30);

		jlem=new JLabel("E mail");
		jlem.setBounds(75,375,120,30);
		
		jtem=new JTextField();
		jtem.setBounds(255,375,120,30);

		jlpw=new JLabel("Password");
		jlpw.setBounds(75,435,120,30);
		
		jtpw=new JPasswordField();
		jtpw.setBounds(255,435,120,30);
		
   		
		jbsav=new JButton("Save");	
		jbsav.setBounds(65,495,100,30);

		jblog=new JButton("Go to Login");	
		jblog.setBounds(265,495,100,30);


				
		
		c.add(jlfna);
		c.add(jtfna);
		c.add(jllna);
		c.add(jtlna);	
		c.add(jldob);
		c.add(jtdob);
		c.add(jlqu);
		c.add(jtqu);
		c.add(jlph);
		c.add(jtph);
		c.add(jlem);
		c.add(jtem);
		c.add(jlpw);
		c.add(jtpw);

		c.add(jbsav);
		c.add(jblog);
			

		jbsav.addActionListener(this);
		jblog.addActionListener(this);
		
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent ae)
	{
 	 String s=ae.getActionCommand();
	 Object obj=ae.getSource();
	String email=new String(" ");
		if(s.equals("Save"))
		{
			try
			{
			pstmt=conn.prepareStatement("insert into signup values(?,?,?,?,?,?,?)");

			String fname=jtfna.getText();
			pstmt.setString(1,fname);
			String lname=jtlna.getText();
			pstmt.setString(2,lname);
			String d_o_b=jtdob.getText();
			pstmt.setString(3,d_o_b);
			String qual=jtqu.getText();
			pstmt.setString(4,qual);
			Long ph=Long.parseLong(jtph.getText());
			pstmt.setLong(5,ph);
			email=jtem.getText();
			pstmt.setString(6,email);
			String pw=jtpw.getText();
			pstmt.setString(7,pw);

			pstmt.executeUpdate();
			}
			catch(SQLException se)
			{
				JOptionPane.showMessageDialog (this, "Error in saving the file",
						"Restaurant - SQL Error", JOptionPane.PLAIN_MESSAGE);
							

			}
		
			JOptionPane.showMessageDialog (this, "Successful Registration ",
						"Restaurant ", JOptionPane.PLAIN_MESSAGE);
							jtfna.setText("");
							jtlna.setText("");
							jtdob.setText("");
							jtqu.setText("");
							jtph.setText("");
							jtem.setText("");
							jtpw.setText(""); 

		}
		
		if(s.equals("Go to Login"))
		{
		new LogFom().setup();
		setVisible(false);
		}		
        }
       	
		
	
}
