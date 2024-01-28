import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
class Loption extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4;
	JButton b1,b2,b3,b4;
	Font font;
	Connection ob;
	ResultSet rs;
	Statement st;
	String a;
	Loption(String a)
	{	
			this.a=a;
			setSize(600,400);	
			setLayout(null);
			setTitle("Option");
			setLocation(600,300);
			getContentPane().setBackground(new Color(149,238,242));
			l2=new JLabel("Select Your Type:");
			l2.setBounds(200,50,200,40);
			font=new Font("Times New Roman",Font.BOLD,15);
			l2.setFont(font);
			b1=new JButton("Form");
			b1.setBounds(30,150,150,50);
			
			b2=new JButton("Reset Password");
			b2.setBounds(410,150,150,50);
			b3=new JButton("Update");
			b3.setBounds(220,150,150,50);
			b4=new JButton("LOG OUT");
			b4.setBounds(220,220,150,50);
			add(b4);
			add(l2);
			add(b1);	
			add(b2);
			add(b3);
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}	
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			display L1=new display(a);
			L1.show();		
			dispose();
		}
	
		if(ae.getSource()==b2)
		{
			Reset a1=new Reset(a);
			a1.show();
			dispose();
		}
		if(ae.getSource()==b3)
		{
			Update a1=new Update(a);
			a1.show();
			dispose();
		}
		if(ae.getSource()==b4)
		{
			Login a2=new Login();
			a2.show();
			dispose();
		}
	}
 
	/*public static void main(String ar[])
	{
		Loption hp=new Loption("Harry@1234");
		hp.show();
	}*/
}

