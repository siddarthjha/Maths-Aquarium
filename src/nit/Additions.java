package nit;
import java.awt.Color;
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

public class Additions extends JFrame implements ActionListener 
{
	static JLabel l1,l2,l3,l4,result,sign;
	JButton next,home;
	static Dimension screenSize ;
	static int width,height ;
	static Random r ;
	static JFrame f ;
	static int x ,n;
	static Thread t1 ;
	static JButton b1,b2,b3,b4 ;
	String str[] ;
	int buttons[], count, q1,q2,q3,q4,n1,n2 ;
	JLabel f1,f2,f3,f4 ,f5 , f6;
	Thread th1,th2,th3,th4,th5,th6;
	static int fx1,fx2,fx3,fx4,fx5,fx6,fy1,fy2,fy3,fy4,fy5,fy6;
	public Additions(int n)
	{
		this.n = n ;
		r = new Random();
		int bg = r.nextInt(7);
		setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("/back"+bg+".jpg"))));
		this.setLayout(null);
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = screenSize.width;
		height = screenSize.height ;
		this.setSize(width,height);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		buttons = new int[4];
		str = new String[4];
		
		l1 = new JLabel();
		l2 = new JLabel(new ImageIcon(this.getClass().getResource("/plus.png")));
		l3 = new JLabel();
		l4 = new JLabel(new ImageIcon(this.getClass().getResource("/arrow.png")));
		result = new JLabel();
		
		f1 = new JLabel();
		f2 = new JLabel();
		f3 = new JLabel();
		f4 = new JLabel();
		f5 = new JLabel();
		f6 = new JLabel();
		
		add(f1);
		add(f2);
		add(f3);
		add(f4);
		add(f5);
		add(f6);
		
		sign = new JLabel();
		sign.setBounds(width/2-65,260,130,130);
		sign.setVisible(false);
		add(sign);
		
		l1.setBounds(x,100,200,150);		
		l2.setBounds(width/2-220,190,80,80);		
		l3.setBounds(x,100,200,150);
		l4.setBounds(width/2+100,205,80,60);
		result.setBounds(width/2+250,160,200,150);	
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(result);
		
		b1 = new JButton();
		b1.setBounds(width/2-275, 400, 100, 50);
		b1.setFont(new Font("Arial",Font.BOLD,35));
		b1.setEnabled(false);
		
		b2 = new JButton();
		b2.setBounds(width/2-125, 400, 100, 50);
		b2.setFont(new Font("Arial",Font.BOLD,35));
		b2.setEnabled(false);
		
		b3 = new JButton();
		b3.setBounds(width/2+25, 400, 100, 50);
		b3.setFont(new Font("Arial",Font.BOLD,35));
		b3.setEnabled(false);
		
		b4 = new JButton();
		b4.setBounds(width/2+175, 400, 100, 50);
		b4.setFont(new Font("Arial",Font.BOLD,35));
		b4.setEnabled(false);
		
		initialize();
		
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		
		next = new JButton(new ImageIcon(this.getClass().getResource("/next.png")));
		next.setBounds(width/2-100,550,100,40);
		next.addActionListener(this);
		this.add(next);
		
		home = new JButton(new ImageIcon(this.getClass().getResource("/home.png")));
		home.setBounds(width/2,550,100,40);
		home.addActionListener(this);
		this.add(home);
		
		f = this ;
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
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
		
		th3 = new Thread(new Runnable()
		{
			public void run()
			{
				for(int i=fx3 ; ; i--)
				{
					if(i<0)
					{
						i=width;
					}
					f3.setText("");
					f3.setIcon(new ImageIcon(this.getClass().getResource("/m3.png")));
					f3.setBounds(i,fy3,90,50);
					try
					{
						Thread.sleep(10);
					}
					catch(Exception e){}
				}
			}
		}
		);
		th3.start();
		
		th4 = new Thread(new Runnable()
		{
			public void run()
			{
				for(int i=fx4 ;  ; i--)
				{
					if(i<0)
					{
						i=width;
					}
					f4.setText("");
					f4.setIcon(new ImageIcon(this.getClass().getResource("/m4.png")));
					f4.setBounds(i,fy4,90,50);
					try
					{
						Thread.sleep(10);
					}
					catch(Exception e){}
				}
			}
		}
		);
		th4.start();
		
		th5 = new Thread(new Runnable()
		{
			public void run()
			{
				for(int i=fx5 ; ; i--)
				{
					if(i<0)
					{
						i=width;
					}
					f5.setText("");
					f5.setIcon(new ImageIcon(this.getClass().getResource("/m5.png")));
					f5.setBounds(i,fy5,90,50);
					try
					{
						Thread.sleep(10);
					}
					catch(Exception e){}
				}
			}
		}
		);
		th5.start();
		
		th6 = new Thread(new Runnable()
		{
			public void run()
			{
				for(int i=fx6 ;  ; i--)
				{
					if(i<0)
					{
						i=width;
					}
					f6.setText("");
					f6.setIcon(new ImageIcon(this.getClass().getResource("/m6.png")));
					f6.setBounds(i,fy6,90,50);
					try
					{
						Thread.sleep(10);
					}
					catch(Exception e){}
				}
			}
		}
		);
		th6.start();
		
		this.setVisible(true);
	}
	
	void initialize()
	{
		l1.setVisible(false);
		l3.setVisible(false);
		result.setVisible(false);
		n1 = r.nextInt(n/2);
		if(n1==0)
		{
			n1=1;
		}
		n2 = r.nextInt(n/2);
		if(n2==0)
		{
			n2=1;
		}
		
		t1 = new Thread(new Runnable()
		{
			public void run()
			{
				for(int i=0 ; i<=150 ; i++)
				{
					l1.setIcon(new ImageIcon(this.getClass().getResource("/fish_"+n1+".png")));
					l1.setBounds(width/2-430,x+i,200,150);
					l1.setVisible(true);
					try
					{
						Thread.sleep(8);
					}
					catch(Exception e){}
				}
				for(int i=0 ; i<=150 ; i++)
				{
					l3.setIcon(new ImageIcon(this.getClass().getResource("/fish_"+n2+".png")));
					l3.setBounds(width/2-100,x+i,200,150);
					l3.setVisible(true);
					
					try
					{
						Thread.sleep(8);
					}
					catch(Exception e){}
				}
				b1.setEnabled(true);
				b2.setEnabled(true);
				b3.setEnabled(true);
				b4.setEnabled(true);
			}
		}
		);
		t1.start();
		
		q1 = n1+n2;
		if(q1>n-5)
		{
			q2 = q1-1;
			q3 = q2-1;
			q4 = q3-1;
		}
		else
		{
			q2 = q1+1;
			q3 = q2+1;
			q4 = q3+1;
		}
		
		str[0] = ""+q1;
		str[1] = ""+q2;
		str[2] = ""+q3;
		str[3] = ""+q4;
		
		count = r.nextInt(4);
		
		if(count==0)
		{
			buttons[0] = 3 ;
			buttons[1] = 2 ;
			buttons[2] = 0 ;
			buttons[3] = 1 ;
		}
		if(count==1)
		{
			buttons[0] = 3 ;
			buttons[1] = 0 ;
			buttons[2] = 1 ;
			buttons[3] = 2 ;
		}
		if(count==2)
		{
			buttons[0] = 1 ;
			buttons[1] = 2 ;
			buttons[2] = 3 ;
			buttons[3] = 0 ;
		}
		if(count==3)
		{
			buttons[0] = 0 ;
			buttons[1] = 3 ;
			buttons[2] = 1 ;
			buttons[3] = 2 ;
		}
		b1.setText(str[buttons[0]]);
		b2.setText(str[buttons[1]]);
		b3.setText(str[buttons[2]]);
		b4.setText(str[buttons[3]]);
		
		fx1 = r.nextInt(width) ;
		fy1 = r.nextInt(height) ;
		fx2 = r.nextInt(width) ;
		fy2 = r.nextInt(height) ;
		fx3 = r.nextInt(width) ;
		fy3 = r.nextInt(height) ;
		fx4 = r.nextInt(width) ;
		fy4 = r.nextInt(height) ;
		fx5 = r.nextInt(width) ;
		fy5 = r.nextInt(height) ;
		fx6 = r.nextInt(width) ;
		fy6 = r.nextInt(height) ;
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		sign.setVisible(false);
		result.setVisible(false);
		if(ae.getSource()==b1)
		{
			if(count==3)
			{
				Thread t = new Thread(new Runnable()
				{
					public void run()
					{
						result.setIcon(new ImageIcon(this.getClass().getResource("/fish_"+q1+".png")));
						result.setVisible(true);
						sign.setIcon(new ImageIcon(this.getClass().getResource("/correct.png")));
						sign.setVisible(true);
						b1.setEnabled(false);
						b2.setEnabled(false);
						b3.setEnabled(false);
						b4.setEnabled(false);
						try 
						{
							Thread.sleep(2000);
						}
						catch(Exception e){ }
					}
				});
				t.start();
			}
			else
			{
				Thread t = new Thread(new Runnable()
				{
					public void run()
					{
						sign.setIcon(new ImageIcon(this.getClass().getResource("/incorrect.png")));
						sign.setVisible(true);
						try 
						{
							Thread.sleep(2000);
						}
						catch(Exception e){ }
					}
				});
				t.start();
			}
		}
		else if(ae.getSource()==b2)
		{
			if(count==1)
			{
				Thread t = new Thread(new Runnable()
				{
					public void run()
					{
						result.setIcon(new ImageIcon(this.getClass().getResource("/fish_"+q1+".png")));
						result.setVisible(true);
						
						sign.setIcon(new ImageIcon(this.getClass().getResource("/correct.png")));
						sign.setVisible(true);
						b1.setEnabled(false);
						b2.setEnabled(false);
						b3.setEnabled(false);
						b4.setEnabled(false);
						try 
						{
							Thread.sleep(2000);
						}
						catch(Exception e){ }
					}
				});
				t.start();
			}
			else
			{
				Thread t = new Thread(new Runnable()
				{
					public void run()
					{
						
						sign.setIcon(new ImageIcon(this.getClass().getResource("/incorrect.png")));
						sign.setVisible(true);
						try 
						{
							Thread.sleep(2000);
						}
						catch(Exception e){ }
					}
				});
				t.start();
			}
		}
		else if(ae.getSource()==b3)
		{
			if(count==0)
			{
				Thread t = new Thread(new Runnable()
				{
					public void run()
					{
						result.setIcon(new ImageIcon(this.getClass().getResource("/fish_"+q1+".png")));
						result.setVisible(true);
						
						sign.setIcon(new ImageIcon(this.getClass().getResource("/correct.png")));
						sign.setVisible(true);
						b1.setEnabled(false);
						b2.setEnabled(false);
						b3.setEnabled(false);
						b4.setEnabled(false);
						try 
						{
							Thread.sleep(2000);
						}
						catch(Exception e){ }
					}
				});
				t.start();
			}
			else
			{
				Thread t = new Thread(new Runnable()
				{
					public void run()
					{
						sign.setIcon(new ImageIcon(this.getClass().getResource("/incorrect.png")));
						sign.setVisible(true);
						try 
						{
							Thread.sleep(2000);
						}
						catch(Exception e){ }
					}
				});
				t.start();
			}
		}
		else if(ae.getSource()==b4)
		{
			if(count==2)
			{
				Thread t = new Thread(new Runnable()
				{
					public void run()
					{
						result.setIcon(new ImageIcon(this.getClass().getResource("/fish_"+q1+".png")));
						result.setVisible(true);
						
						sign.setIcon(new ImageIcon(this.getClass().getResource("/correct.png")));
						sign.setVisible(true);
						b1.setEnabled(false);
						b2.setEnabled(false);
						b3.setEnabled(false);
						b4.setEnabled(false);
						try 
						{
							Thread.sleep(2000);
						}
						catch(Exception e){ }
					}
				});
				t.start();
			}
			else
			{
				Thread t = new Thread(new Runnable()
				{
					public void run()
					{
						sign.setIcon(new ImageIcon(this.getClass().getResource("/incorrect.png")));
						sign.setVisible(true);
						try 
						{
							Thread.sleep(2000);
						}
						catch(Exception e){ }
					}
				});
				t.start();
			}
		}
		else if(ae.getSource()==next)
		{
			t1.stop();
			initialize();
		}
		else
		{
			th1.stop();
			th2.stop();
			th3.stop();
			th4.stop();
			th5.stop();
			th6.stop();
			new Options();
			dispose();
		}
	}
}