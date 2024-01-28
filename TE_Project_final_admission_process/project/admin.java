import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
class Login2 extends JFrame implements ActionListener
{
	JLabel l1,l2;
	JButton b1,b2,b3;
	JTextField t1;
	JPasswordField pf;
	JDialog d1;
	Connection ob;
	ResultSet rs;
	Statement st;
	PreparedStatement ps;
	Login2()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			ob=DriverManager.getConnection("jdbc:mysql://localhost/admin1","root","1999");
			st=ob.createStatement();
			setSize(700,500);
			setLocation(540,320);
			setLayout(null);
			getContentPane().setBackground(new Color(248,201,143));
			setTitle("Admin Page");
			l1=new JLabel("Username");
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
			b2=new JButton("Clear");
			b2.setBounds(300,170,100,30);
			b3=new JButton("HOMEPAGE");
			b3.setBounds(450,170,100,30);
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
				ps=ob.prepareStatement("Select * from root where Username=? and password=?");
				ps.setString(1,a);
				ps.setString(2,b);
				rs=ps.executeQuery();
				if(rs.next())
				{
					JOptionPane.showMessageDialog(null,"Login Successfully");
					MenuExample a1=new MenuExample();
					a1.show();
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
		if(ae.getSource()==b2)
		{
			t1.setText("");
			pf.setText("");
		}
		if(ae.getSource()==b3)
		{
			Homepage hp=new Homepage();
			hp.show();
			dispose();
		}
}
}