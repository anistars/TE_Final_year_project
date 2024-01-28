import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class Login1 extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6;
	JButton b1,b2;
	JTextField t1,t2;
	JPasswordField pf,pf1;
	JDialog d1;
	Connection ob;
	ResultSet rs;
	Statement st;
	PreparedStatement ps;
	Login1()
	{	
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			ob=DriverManager.getConnection("jdbc:mysql://localhost/admin","root","1999");
			ps=ob.prepareStatement("INSERT INTO form1(ID,Username,password) VALUES (NULL,?,?)");
			st=ob.createStatement();
			setSize(650,400);
			setLocation(540,320);
			setLayout(null);
			getContentPane().setBackground(new Color(162,255,162));
			setTitle("Sign-Up Page");
			l1=new JLabel("Username");
			l1.setBounds(80, 70, 200, 30);
			l6=new JLabel("Characters Should be in between 8 and 15");
			l6.setBounds(250, 90, 250, 30);
			l2=new JLabel("Password");
			l2.setBounds(80, 120, 200, 30);
			t1=new JTextField();
			t1.setBounds(250, 70, 200, 30);
			pf=new JPasswordField();
			pf.setBounds(250, 120, 200, 30);
			d1=new JDialog();
			b1=new JButton("Submit");
			b1.setBounds(150,250,100,30);
			b2=new JButton("Cancel");
			b2.setBounds(300,250,100,30);
			l3=new JLabel("First letter capital,special char followed by digits");
			l3.setBounds(250,150,500,30);
			l4=new JLabel("Re-Enter Password");
			l4.setBounds(80,180,500,30);
			pf1=new JPasswordField();
			pf1.setBounds(250, 180, 200, 30);
			add(l1);
			add(l2);
			add(l6);
			add(t1);
			add(pf);
			add(b1);
			add(b2);
			add(l3);
			add(l4);
			add(pf1);
			b1.addActionListener(this);
			b2.addActionListener(this);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String z1=t1.getText();
		String a = pf.getText();
		String b = pf1.getText();
		int ax=0;
		
		if(ae.getSource()==b1)    		 	
		{
			if(z1.length()>8 && z1.length()<15)
			{
				ax=1;
			}
			if(a.equals(b) && ax==1)
			{
				if(validps(b))
				{
					JOptionPane.showMessageDialog(null,"Login Successfully");
					try{
						ps.setString(1,z1);
						ps.setString(2,b);
						ps.executeUpdate();
						ob.close();
						dispose();
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
					F a1=new F(a);
					a1.show();
				}
				else
				{
	
					JOptionPane.showMessageDialog(this,"WRONG DETAILS ENTERED","error",JOptionPane.WARNING_MESSAGE);
					t1.setText("");
					pf.setText("");
					pf1.setText("");
				}
			}
			else
			{
	
				JOptionPane.showMessageDialog(this,"WRONG PASSWORD","error",JOptionPane.WARNING_MESSAGE);	
				
			}
		}
		if(ae.getSource()==b2)
		{
			Login a1=new Login();
			a1.show();
			dispose();
			/*t1.setText("");
			pf.setText("");
			pf1.setText("");*/
		}
		
	}
	boolean validps(String ps)
	{
		int j;
		boolean x=false;
		if(ps.length()>8 && ps.length()<15)
		{
			if(Character.isUpperCase(ps.charAt(0)))
			{
				for(j=1;j<ps.length();j++)
				{
					if(ps.charAt(j)=='#'||ps.charAt(j)=='.'||ps.charAt(j)=='@'||ps.charAt(j)=='$'||ps.charAt(j)=='%'||ps.charAt(j)=='!')
					{
						break;
					}
				}
				for(int k=j;k<ps.length();k++)
				{
					if(ps.charAt(k)>=0||ps.charAt(k)<=9)
					{
						x=true;
					}
				}
			}
			
		}
		return(x);
		
	}
/*	public static void main(String ar[])	 
	{
		Login1 a1=new Login1();
		a1.show();
	}*/
}
