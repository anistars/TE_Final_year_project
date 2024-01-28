import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
class Update extends JFrame implements ItemListener,ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6;
	JButton b1,b2,b3;
	JTextField t1,t2,t3,t4;
	JPasswordField pf;
	JComboBox j1,j2;
	JPanel p1,p2,p3,p4,p5;
	JDialog d1;
	Connection ob;	
	ResultSet rs;
	Statement st;
	PreparedStatement ps;
	String a;
	Update(String a)
	{
		try
		{
			this.a=a;
			Class.forName("com.mysql.jdbc.Driver");
			ob=DriverManager.getConnection("jdbc:mysql://localhost/admin","root","1999");
			st=ob.createStatement();
			setSize(600,500);
			setLocation(540,320);
			setLayout(null);
//			getContentPane().setBackground(new Color(244,196,243));
			setTitle("Update Profile");
			l4=new JLabel("Current Year ");
			l4.setBounds(120,200,150,50);
			add(l4);
			String ch[]={"","SE","TE","BE"};
			j1=new JComboBox(ch);
			j1.setBounds(230,200,150,50);
			add(j1);
			l5=new JLabel("Previous Result ");
			l5.setBounds(120,50,150,50);
			add(l5);
			l6=new JLabel("No of Backlogs ");
			l6.setBounds(120,130,150,50);
			add(l6);
			t4=new JTextField(10);
			t4.setBounds(230,130,150,50);
			add(t4);
			String c[]={"","Passed","Passed with ATKT"};
			j2=new JComboBox(c);
			j2.setBounds(230,50,150,50);
			add(j2);
			p1=new JPanel();
			p1.setBounds(150,270,200,150);
			l1=new JLabel("FE MARKS");
			p1.add(l1);
			t1=new JTextField(10);
			p1.add(t1);
			p2=new JPanel();
			p2.setBounds(150,270,200,150);
			l2=new JLabel("SE MARKS");
			p2.add(l2);
			t2=new JTextField(10);
			p2.add(t2);
			p3=new JPanel();
			p3.setBounds(150,270,200,150);
			l3=new JLabel("TE MARKS");
			p3.add(l3);
			t3=new JTextField(10);
			p3.add(t3);
			b1=new JButton("Update");
			b1.setBounds(200,360,150,50);
			add(b1);
			j1.addItemListener(this);
			b1.addActionListener(this);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getSource()==j1)
		{
			if(j1.getSelectedItem()=="SE")
			{
				remove(p2);
				remove(p3);
				add(p1);
				setVisible(false);
				setVisible(true);
			}
			if(j1.getSelectedItem()=="TE")
			{
				remove(p1);
				remove(p3);
				add(p2);
				setVisible(false);
				setVisible(true);
			}	
			if(j1.getSelectedItem()=="BE")
			{
				remove(p1);
				remove(p2);
				add(p3);
				setVisible(false);
				setVisible(true);
			}
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			if(ae.getSource()==b1)
			{		
					ps=ob.prepareStatement("update form1 set prre=?,back=? where id='"+a+"'");
					ps.setString(1,j2.getSelectedItem().toString());
					ps.setString(2,(t4.getText()));
					ps.executeUpdate();
					if(j1.getSelectedItem().toString()=="SE")
					{
						ps=ob.prepareStatement("update form1 set FE=? where id='"+a+"'");
						ps.setString(1,(t1.getText()));
					}
					if(j1.getSelectedItem().toString()=="TE")
					{		
						ps=ob.prepareStatement("update form1 set SE=? where id='"+a+"'");
						ps.setString(1,(t2.getText()));
					}
					if(j1.getSelectedItem().toString()=="BE")
					{
						ps=ob.prepareStatement("update form1 set TE=? where id='"+a+"'");
						ps.setString(1,(t3.getText()));
					}
				ps.executeUpdate();
				ob.close();
				JOptionPane.showMessageDialog(null,"Updated Successfully");
				Loption hp=new Loption(a);
				hp.show();
				dispose();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
/*	public static void main(String ar[])	 
	{
		Update a1=new Update("Eight@123");
		a1.show();
	}*/
}
