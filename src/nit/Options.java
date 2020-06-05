package nit;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Options extends JFrame implements ActionListener 
{
	JButton b1,b2,b3,b4;
	JLabel f1,f2,f3,f4;
	JButton back ;
	static Dimension screenSize ;
	static int width,height ;
	Random r ;
	Thread t1,t2,t3,t4;
	public Options()
	{
		setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("/options.jpg"))));
		this.setLayout(null);
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = screenSize.width;
		height = screenSize.height ;
		this.setSize(width,height);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
		
		r = new Random();
		
		b1 = new JButton(new ImageIcon(this.getClass().getResource("/add.png")));
		b2 = new JButton(new ImageIcon(this.getClass().getResource("/sub.png")));
		b3 = new JButton(new ImageIcon(this.getClass().getResource("/mul.png")));
		b4 = new JButton(new ImageIcon(this.getClass().getResource("/div.png")));
		
		f1 = new JLabel();
		f2 = new JLabel();
		f3 = new JLabel();
		f4 = new JLabel();
		
		b1.setBounds(width/2-150,height/2-200,300,45);		
		b2.setBounds(width/2-150,height/2-130,300,45);		
		b3.setBounds(width/2-150,height/2-60,300,45);		
		b4.setBounds(width/2-150,height/2+10,300,45);
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		
		add(f1);
		add(f2);
		add(f3);
		add(f4);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
			
		back = new JButton(new ImageIcon(this.getClass().getResource("/home.png")));
		back.setBounds(width/2-50,height/2+100,100,40);
		back.addActionListener(this);
		this.add(back);
		
		t1 = new Thread(new Runnable()
		{
			public void run()
			{
				int x = r.nextInt(width) ;
				int y = r.nextInt(height) ;
				for(int i=x ;  ; i++)
				{
					if(i>width)
					{
						i=0;
					}
					f1.setText("");
					f1.setIcon(new ImageIcon(this.getClass().getResource("/l1.png")));
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
				int x = r.nextInt(width) ;
				int y = r.nextInt(height) ;
				for(int i=x ;  ; i++)
				{
					if(i>width)
					{
						i=0;
					}
					f2.setText("");
					f2.setIcon(new ImageIcon(this.getClass().getResource("/l2.png")));
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
				int x = r.nextInt(width) ;
				int y = r.nextInt(height) ;
				for(int i=x ; ; i--)
				{
					if(i<0)
					{
						i=width;
					}
					f3.setText("");
					f3.setIcon(new ImageIcon(this.getClass().getResource("/r1.png")));
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
				int x = r.nextInt(width) ;
				int y = r.nextInt(height) ;
				for(int i=x ;  ; i--)
				{
					if(i<0)
					{
						i=width;
					}
					f4.setText("");
					f4.setIcon(new ImageIcon(this.getClass().getResource("/r2.png")));
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
		t1.stop();
		t2.stop();
		t3.stop();
		t4.stop();
		if(ae.getSource() ==  b1)
		{
			new AddLevels();
			dispose();
		}
		else if(ae.getSource() ==  b2)
		{
			new SubLevels();
			dispose();
		}
		else if(ae.getSource() ==  b3)
		{
			new MulLevels();
			dispose();
		}
		else if(ae.getSource() ==  b4)
		{
			new DivLevels();
			dispose();
		}
		else
		{
			new Welcome();
			dispose();
		}
	}
}