import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
public class SplashScreen extends JFrame
{
	Image img=Toolkit.getDefaultToolkit().getImage("imh.jpg");
	ImageIcon imgicon=new ImageIcon(img);
	public SplashScreen()
	{
		try
		{
			setSize(640,390);
			setLocationRelativeTo(null);
			show();
			JLabel l1=new JLabel(imgicon);
			add(l1);
			Thread.sleep(5000);
			dispose();
		}
		catch(Exception exception)
		{
			System.out.println(exception);
		}
	}


	public static void main(String[]args)
	{
		SplashScreen sp=new SplashScreen();
		Homepage hp=new Homepage();
		hp.show();
		//sp.setSize(1000,1000);
		//sp.show();
	}
}
