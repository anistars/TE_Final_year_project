import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
class Homepage extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4;
	JButton b1,b2;
	Font font;
	Homepage()
	{	
			setSize(600,500);	
			setLayout(null);
			setTitle("HOMEPAGE");
			setLocation(600,300);
			ImageIcon i1=new ImageIcon("download.png");
			getContentPane().setBackground(new Color(149,238,242));
			l1=new JLabel("WELCOME TO ADMISSION PROCESS");
			font=new Font("Times New Roman",Font.BOLD,20);
			l1.setOpaque(true);
			l1.setBackground(Color.YELLOW);
			l1.setFont(font);
			l1.setBounds(100,10,360,40);
			l2=new JLabel("Select Your Type:");
			l2.setBounds(200,50,200,40);
			font=new Font("Times New Roman",Font.BOLD,15);
			l2.setFont(font);
			b1=new JButton("Admin Account");
			b1.setBounds(100,150,150,50);
			
			b2=new JButton("Student Account");
			b2.setBounds(300,150,150,50);
			JLabel ll=new JLabel(i1);
			ll.setBounds(340,210,250,250);
			add(ll);
			add(l1);
			add(l2);
			add(b1);	
			add(b2);
			b1.addActionListener(this);
			b2.addActionListener(this);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			Login2 L1=new Login2();
			L1.show();		
			dispose();
		}
	
		if(ae.getSource()==b2)
		{
			Login L=new Login();
			L.show();
			dispose();			
		}
	}
 
/*	public static void main(String ar[])
	{
		Homepage hp=new Homepage();
		hp.show();
	}*/
}

