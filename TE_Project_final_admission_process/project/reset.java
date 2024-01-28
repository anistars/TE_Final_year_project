import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class Reset extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5;
	JButton b1,b2;
	JTextField t1,t2;
	JPasswordField pf,pf1;
	JDialog d1;
	Connection ob;
	ResultSet rs;
	Statement st;
	String a;
	PreparedStatement ps;
	Reset(String a)
	{	
		try
		{
			this.a=a;
			Class.forName("com.mysql.jdbc.Driver");
			ob=DriverManager.getConnection("jdbc:mysql://localhost/admin","root","1999");
			st=ob.createStatement();
			setSize(650,400);
			setLocation(540,320);
			setLayout(null);
			getContentPane().setBackground(new Color(162,255,162));
			setTitle("Reset Password");
			l1=new JLabel("New Password");
			l1.setBounds(80, 70, 200, 30);
			l2=new JLabel("Enter Again");
			l2.setBounds(80, 120, 200, 30);
			pf1=new JPasswordField();
			pf1.setBounds(250, 70, 200, 30);
			pf=new JPasswordField();
			pf.setBounds(250, 120, 200, 30);
			d1=new JDialog();
			b1=new JButton("Submit");
			b1.setBounds(150,250,100,30);
			b2=new JButton("Cancel");
			b2.setBounds(300,250,100,30);
			l3=new JLabel("First letter capital,special char followed by digits");
			l3.setBounds(250,150,500,30);
			add(l1);
			add(l2);
			add(pf);
			add(b1);
			add(b2);
			add(l3);
			add(pf1);
			b1.addActionListener(this);
			b2.addActionListener(this);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
//		String z1=t1.getText();
		String a1 = pf.getText();
		String b = pf1.getText();
		if(ae.getSource()==b1)    		 	
		{
			
			if(a1.equals(b))
			{
				if(validps(b))
				{
					System.out.println(a1);
					System.out.println(b);
//					JOptionPane.showMessageDialog(null,"Login Successfully");
					try{
						ps=ob.prepareStatement("update form1 set password=? where id='"+a+"'");
						ps.setString(1,a1);
//						ps.setString(2,b);
						ps.executeUpdate();
						ob.close();
//						dispose();
						JOptionPane.showMessageDialog(null,"Updated Succesfully");
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
					Login l1=new Login();
					l1.show();
					dispose();
				}
				else
				{
	
					JOptionPane.showMessageDialog(this,"Condition not fullfilled","error",JOptionPane.WARNING_MESSAGE);

				}
			}
			else
			{
	
				JOptionPane.showMessageDialog(this,"WRONG PASSWORD","error",JOptionPane.WARNING_MESSAGE);	
			}
		}
		if(ae.getSource()==b2)
		{
			t1.setText("");
			pf.setText("");
			pf1.setText("");
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
		Reset a1=new Reset("Harry@123");
		a1.show();
	}*/
}
