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

public class Welcome extends JFrame implements ActionListener 
{
		JButton b , exit;
		JLabel l,l1,l2,f1,f2;
		static Dimension screenSize ;
		static int width, height ;
		Thread th1,th2 ;
		static int fx1,fx2,fy1,fy2 ;
		Random r ;
		public Welcome() 
		{
			r = new Random();
			setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("/welcome.jpg"))));
			this.setLayout(null);
			screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			width = screenSize.width;
			height =  screenSize.height ;
			this.setSize(width, height);
			this.setLocationRelativeTo(null);
			this.setUndecorated(true);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
			
			b = new JButton(new ImageIcon(this.getClass().getResource("/Start1.png")));
			b.setBounds(width/2-155, height/2+150, 145, 80);
			b.setOpaque(false);
			b.setContentAreaFilled(false);
			b.setBorderPainted(true);
			
			exit = new JButton(new ImageIcon(this.getClass().getResource("/End1.png")));
			exit.setBounds(width/2+5, height/2+150, 145, 80);
			exit.setOpaque(false);
			exit.setContentAreaFilled(false);
			exit.setBorderPainted(true);
			
			fx1 = r.nextInt(width) ;
			fy1 = r.nextInt(height/2) ;
			fx2 = r.nextInt(width) ;
			fy2 = r.nextInt(height/2) ;
			
			l1= new JLabel(new ImageIcon(this.getClass().getResource("/maths.png")));
			l1.setBounds(width/2-430,80,428,124);
			
			l2= new JLabel(new ImageIcon(this.getClass().getResource("/aquarium.png")));
			l2.setBounds(width/2+20,80,327,124);
			
			l = new JLabel();
			
			f1 = new JLabel();
			f2 = new JLabel();
			
			add(f1);
			add(f2);
			
			this.add(l1);
			this.add(l2);
			this.add(l);
			this.add(b);
			this.add(exit);
			
			b.addActionListener(this);
			exit.addActionListener(this);
			this.setVisible(true);
			
			th1 = new Thread(new Runnable()
			{
				public void run()
				{
					for(int i=fx1 ;  ; i++)
					{
						if(i>width)
						{
							i=0;
						}
						f1.setText("");
						f1.setIcon(new ImageIcon(this.getClass().getResource("/m1.png")));
						f1.setBounds(i,fy1,90,50);
						try
						{
							Thread.sleep(10);
						}
						catch(Exception e){}
					}
				}
			}
			);
			th1.start();
			
			th2 = new Thread(new Runnable()
			{
				public void run()
				{
					for(int i=fx2 ;  ; i++)
					{
						if(i>width)
						{
							i=0;
						}
						f2.setText("");
						f2.setIcon(new ImageIcon(this.getClass().getResource("/m2.png")));
						f2.setBounds(i,fy2,90,50);
						try
						{
							Thread.sleep(10);
						}
						catch(Exception e){}
					}
				}
			}
			);
			th2.start();
		}

		public void actionPerformed(ActionEvent ae) 
		{
			th1.stop();
			th2.stop();
			if(ae.getSource()==b)
			{
				Thread t = new Thread(new Runnable()
				{
					public void run()
					{
						int x = width/2-155 ;
						for(int i=x ; i<=width ; i++)
						{
							l.setText("");
							l.setIcon(new ImageIcon(this.getClass().getResource("/Start1.png")));
							l.setBounds(i,height/2+150,150,80);
							try
							{
								Thread.sleep(3);
							}
							catch(Exception e){}
						}
						new Options();
						dispose();
					}
				}
				);
				t.start();
			}
			else
			{
				System.exit(1);
			}
		}
}


