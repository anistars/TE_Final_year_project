import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
class Login extends JFrame implements ActionListener
{
	JLabel l1,l2,l3;
	JButton b1,b2,b3,b4;
	JTextField t1;
	JPasswordField pf;
	JDialog d1;
	Connection ob;
	ResultSet rs;
	Statement st;
	PreparedStatement ps;
	Login()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			ob=DriverManager.getConnection("jdbc:mysql://localhost/admin","root","1999");
			st=ob.createStatement();
			setSize(600,500);
			setLocation(540,320);
			setLayout(null);
			getContentPane().setBackground(new Color(244,196,243));
			ImageIcon i1=new ImageIcon("key.png");
			setTitle("Login Page");
			l1=new JLabel("Studname");
			l1.setBounds(80, 70, 200, 30);
			l2=new JLabel("Password");
			l2.setBounds(80, 110, 200, 30);
			t1=new JTextField();
			t1.setBounds(250, 70, 200, 30);
			pf=new JPasswordField();
			pf.setBounds(250, 110, 200, 30);
			d1=new JDialog();
			b1=new JButton("Login");
			b1.setBounds(150,170,100,30);
			b2=new JButton("Sign up");
			b2.setBounds(300,170,100,30);
			JLabel l3=new JLabel(i1);
			l3.setBounds(340,100,250,390);
			b3=new JButton("Forget Password");
			b3.setBounds(200,230,150,30);
			b4=new JButton("Home Page");
			b4.setBounds(200,270,150,30);
			add(b4);
			add(l3);
			add(l1);
			add(l2);
			add(t1);
			add(pf);
			add(b1);
			add(b2);
			add(b3);
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String a = t1.getText();
		String b = pf.getText();
		if(ae.getSource()==b1)    		 	
		{
			try{
				ps=ob.prepareStatement("Select * from form1 where Username=? and password=?");
				ps.setString(1,a);
				ps.setString(2,b);
				rs=ps.executeQuery();
				if(rs.next())
				{
					String id=rs.getString(1);
					JOptionPane.showMessageDialog(null,"Login Successfully");
					Loption hp=new Loption(id);
					hp.show();
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(this,"WRONG PASSWORD","error",JOptionPane.WARNING_MESSAGE);
					t1.setText("");
					pf.setText("");
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
/*		if(ae.getSource()==b1)
		{
			display d=new display(b);
			d.show();
			dispose();
		}*/
		if(ae.getSource()==b2)
		{
			Login1 l=new Login1();
			l.show();
			dispose();
		}
		if(ae.getSource()==b3)
		{
			Forget a1=new Forget();
			a1.show();
			dispose();
		}
		if(ae.getSource()==b4)
		{
			Homepage hp=new Homepage();
			hp.show();
			dispose();
		}
	}
/*	public static void main(String ar[])	 
	{
		Login a1=new Login();
		a1.show();
	}*/
}
