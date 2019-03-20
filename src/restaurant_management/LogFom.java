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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class LogFom extends JFrame implements ActionListener
{
 JLabel lnl,pwl,ch,ch1,nusr;
 JTextField lnt;
 JPasswordField pwt;
 JButton ok,can,btnr;
 Container c;
 String ln,psw;
  
 Connection conn;
 PreparedStatement pstmt;

	public void setup()
	{
	c=getContentPane();
	resize(350,230);
	Dimension d=size();
	setLocation(d.width,d.height);
	setTitle("Restaurant");
        c.setBackground(Color.lightGray);
      	c.setLayout(null);
	 
  	lnl=new JLabel("LOGIN EMAIL");
	lnt=new JTextField();
  	lnl.setBounds(20,20,80,30);
  	lnt.setBounds(150,20,180,30);

  	pwl=new JLabel("PASSWORD");
	pwt=new JPasswordField();
  	
  	pwl.setBounds(20,70,80,30);
  	pwt.setBounds(150,70,180,30);

  	ok=new JButton("OK");
  	ok.setBounds(50,120,100,30);

  	can=new JButton("CANCEL");
  	can.setBounds(180,120,100,30);

	nusr=new JLabel("For new user please ");
	nusr.setBounds(140,165,150,30);

	btnr=new JButton("Sign up");
  	btnr.setBounds(255,169,77,20);
  	
	c.add(lnl);
  	c.add(lnt);
  	c.add(pwl);
  	c.add(pwt);
  	c.add(ok);
  	c.add(can);
	c.add(nusr);
	c.add(btnr);
		
  	ok.addActionListener(this);
  	can.addActionListener(this);
	btnr.addActionListener(this);
	setVisible(true); 	
	}

	public void actionPerformed(ActionEvent ae)
	{
 	 String s=ae.getActionCommand();
		
	  if(s.equals("OK"))
	   {			     	  
	     try
      		{
    		  pstmt=conn.prepareStatement("select * from signup");
  		  ln=lnt.getText();   		  
    		  psw=pwt.getText();         	 
    		  ResultSet rs=pstmt.executeQuery(); 
		  int flag=0; 
    		  while(rs.next())
        	  {
        	    String one=rs.getString("Email");
     		    String two=rs.getString("Password");    
		    if(ln.equals(one) && psw.equals(two))
		     {	
			flag=1;
			
			new Hotel_1();
			setVisible(false);
			dispose();
		     }
		   }
		   if(flag==0)
         	    {
		      JOptionPane.showMessageDialog(this, "Invalid Username or Password.","Signup", JOptionPane.PLAIN_MESSAGE);
		      lnt.setText("");
		      pwt.setText(""); 
		    }
		}catch(SQLException e)
  		 {
  		   System.out.println("sql exception"+e.getMessage());
  	     }
            		
	  }
	   if(s.equals("CANCEL"))
	   {
	    System.exit(0);
	   }
  	   if(s.equals("Sign up"))
	   {
	     new SignUp();
	     setVisible(false);
	   }
    }          
       
     LogFom()
     {
	 try
  	 {
  	   Class.forName("com.mysql.jdbc.Driver");
         conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "root");
        
  	 }catch(ClassNotFoundException e)
  	  {
  	    System.out.println("class not exception");
  	  }
  	   catch(SQLException e)
  	  {
  	   System.out.println("sql exception"+e.getMessage());
  	  }	
 	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
	
         
      public static void main(String args[])
      {
   	LogFom lf=new LogFom();
  	lf.setup();
      }
}
