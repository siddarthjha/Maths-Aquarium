package nit;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MulLevels extends JFrame implements ActionListener 
{
	JButton b1,b2,b3,b4;
	static Dimension screenSize ;
	static int width, height ;
	JLabel f1,f2,f3,f4;
	Random r ;
	Thread t1,t2,t3,t4;
	public MulLevels()
	{
		setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("/levels2.jpg"))));
		this.setLayout(null);
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = screenSize.width;
		height = screenSize.height ;
		this.setSize(width,height);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
		
		r = new Random();
		
		b1 = new JButton(new ImageIcon(this.getClass().getResource("/level1.png")));
		b2 = new JButton(new ImageIcon(this.getClass().getResource("/level2.png")));
		b3 = new JButton(new ImageIcon(this.getClass().getResource("/level3.png")));
		b4 = new JButton(new ImageIcon(this.getClass().getResource("/menu1.png")));
		
		b1.setBounds(width/2-300,100,120,120);		
		b2.setBounds(width/2-100,250,120,120);		
		b3.setBounds(width/2+100,400,120,120);
		b4.setBounds(width/2+250,550,70,70);
		
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(true);
		
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(true);
		
		b3.setOpaque(false);
		b3.setContentAreaFilled(false);
		b3.setBorderPainted(true);
		
		f1 = new JLabel();
		f2 = new JLabel();
		f3 = new JLabel();
		f4 = new JLabel();
		
		add(f1);
		add(f2);
		add(f3);
		add(f4);
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		t1 = new Thread(new Runnable()
		{
			public void run()
			{
				int x = r.nextInt(1200) ;
				int y = r.nextInt(760) ;
				for(int i=x ;  ; i++)
				{
					if(i>1200)
					{
						i=0;
					}
					f1.setText("");
					f1.setIcon(new ImageIcon(this.getClass().getResource("/l3.png")));
					f1.setBounds(i,y,150,80);
					try
					{
						Thread.sleep(10);
					}
					catch(Exception e){}
				}
			}
		}
		);
		t1.start();
		
		t2 = new Thread(new Runnable()
		{
			public void run()
			{
				int x = r.nextInt(1200) ;
				int y = r.nextInt(760) ;
				for(int i=x ;  ; i++)
				{
					if(i>1200)
					{
						i=0;
					}
					f2.setText("");
					f2.setIcon(new ImageIcon(this.getClass().getResource("/l4.png")));
					f2.setBounds(i,y,150,80);
					try
					{
						Thread.sleep(10);
					}
					catch(Exception e){}
				}
			}
		}
		);
		t2.start();
		
		t3 = new Thread(new Runnable()
		{
			public void run()
			{
				int x = r.nextInt(1200) ;
				int y = r.nextInt(760) ;
				for(int i=x ; ; i--)
				{
					if(i<0)
					{
						i=1200;
					}
					f3.setText("");
					f3.setIcon(new ImageIcon(this.getClass().getResource("/r3.png")));
					f3.setBounds(i,y,150,80);
					try
					{
						Thread.sleep(10);
					}
					catch(Exception e){}
				}
			}
		}
		);
		t3.start();
		
		t4 = new Thread(new Runnable()
		{
			public void run()
			{
				int x = r.nextInt(1200) ;
				int y = r.nextInt(760) ;
				for(int i=x ;  ; i--)
				{
					if(i<0)
					{
						i=1200;
					}
					f4.setText("");
					f4.setIcon(new ImageIcon(this.getClass().getResource("/r4.png")));
					f4.setBounds(i,y,150,80);
					try
					{
						Thread.sleep(10);
					}
					catch(Exception e){}
				}
			}
		}
		);
		t4.start();
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() ==  b1)
		{
			new Multiplications(40);
			dispose();
		}
		else if(ae.getSource() ==  b2)
		{
			new Multiplications(60);
			dispose();
		}
		else if(ae.getSource() ==  b3)
		{
			new Multiplications(80);
			dispose();
		}
		else
		{
			new Options();
			dispose();
		}
	}
}