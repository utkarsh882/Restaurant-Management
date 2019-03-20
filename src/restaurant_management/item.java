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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Presario
 */
public class item extends JFrame implements ActionListener{
    JLabel ilbname,ilbid,ilbprice;
    JTextField itfname,itfid,itfprice;
    JButton add,cancel,clear;
    Container d;
    item(){
        d=getContentPane();
		setSize(400,400);
		setTitle("Item");
		d.setBackground(Color.lightGray);
		d.setLayout(null);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
        
         ilbname= new JLabel("Item name :");
        ilbname.setBounds(75, 75, 100, 30);
        
        
         itfname = new JTextField();
        itfname.setBounds(175, 75, 90, 30);
        
        ilbid= new JLabel("Item id :");
        ilbid.setBounds(75, 135, 100, 30);
        
        itfid = new JTextField();
        itfid.setBounds(175, 135, 90, 30);
        
        ilbprice= new JLabel("Price :");
         ilbprice.setBounds(75, 195, 100, 30);
        
        itfprice = new JTextField();
        itfprice.setBounds(175, 195, 90, 30);
        
        add = new JButton("Add");
        add.setBounds(65, 255, 80, 30);
        
        cancel = new JButton("Back");
        cancel.setBounds(150, 255, 80, 30);
        
        clear = new JButton("Clear");
        clear.setBounds(235, 255, 80, 30);
        
        d.add(ilbname);
        d.add(itfname);
        d.add(ilbid);
        d.add(itfid);
        d.add(ilbprice);
        d.add(itfprice);
        d.add(add);
        d.add(cancel);
        d.add(clear);
        
        add.addActionListener(this);
        cancel.addActionListener(this);
        clear.addActionListener(this);
        setVisible(true);
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== add)
        {
            String iname = new String(itfname.getText());
            int iid = new Integer(itfid.getText());
            int iprice = new Integer(itfprice.getText());

            try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "root");
                    PreparedStatement pis = conn.prepareStatement("insert into item values(?,?,?)");
                    pis.setInt(1, iid);
                    pis.setString(2, iname);
                    pis.setInt(3, iprice);
                    pis.execute();
                    JOptionPane.showMessageDialog(this, "Data Saved Successfully");
                    itfname.setText("");
                    itfid.setText("");
                    itfprice.setText("");
            }catch(Exception c){c.printStackTrace();}
        }
        if(e.getSource()== clear)
        {
            itfname.setText("");
            itfprice.setText("");
            itfid.setText("");
        }
        if(e.getSource()==cancel){
            new Dish_1();
            setVisible(false);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
//   

    
}
