import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
class Forget extends JFrame implements ActionListener
{
	JLabel l1,l2,l3;
	JButton b1,b2,b3,b4;
	JTextField t1,t2,t3;
	JPasswordField pf;
	JDialog d1;
	Connection ob;
	ResultSet rs;
	Statement st;
	PreparedStatement ps;
	Forget()
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
			setTitle("Forget Password");
			l1=new JLabel("Studname");
			l1.setBounds(80, 70, 200, 30);
			l2=new JLabel("phno");
			l2.setBounds(80, 110, 200, 30);
			t1=new JTextField();
			t1.setBounds(250, 70, 200, 30);
			t2=new JTextField();
			t2.setBounds(250, 110, 200, 30);
			d1=new JDialog();
			b1=new JButton("Get Password");
			b1.setBounds(200,170,150,30);
			b4=new JButton("Main Page");
			b4.setBounds(200,230,150,30);
			add(l1);
			add(l2);
			add(t1);
			add(t2);
			add(b1);
			add(b4);
//			add(b3);
			b1.addActionListener(this);
			b4.addActionListener(this);
//			b3.addActionListener(this);
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
		String b = t2.getText();
		if(ae.getSource()==b1)    		 	
		{
			try{
				ps=ob.prepareStatement("Select * from form1 where Username=? and phno=?");
				ps.setString(1,a);
				ps.setString(2,b);
				rs=ps.executeQuery();
				if(rs.next())
				{
//					t3.setText(rs.getString(3));
					JOptionPane.showMessageDialog(null,"Password is "+rs.getString(3));
					Login a1=new Login();
					a1.show();
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Wrong contents entered","error",JOptionPane.WARNING_MESSAGE);
					t1.setText("");
					t2.setText("");
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		if(ae.getSource()==b4)
		{
			Login a1=new Login();
			a1.show();
			dispose();
		}
	}
/*	public static void main(String ar[])	 
	{
		Forget a1=new Forget();
		a1.show();
	}*/
}
