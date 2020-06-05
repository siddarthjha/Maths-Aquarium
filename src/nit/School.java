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

public class School extends JFrame 
{
		JLabel name, place, city, state ;
		static Dimension screenSize ;
		static int width, height ;
		public School() 
		{
			setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("/school_back.png"))));
			this.setLayout(null);
			screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			width = screenSize.width;
			height =  screenSize.height ;
			this.setSize(width, height);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
			this.setUndecorated(true);
			
			name = new JLabel("School Name Here...");
			name.setBounds(width/2-150, height/2-150, 550, 60);
			name.setOpaque(false);
			name.setForeground(Color.RED);
			name.setFont(new Font("Candara",Font.BOLD,60));
			add(name);
			
			place = new JLabel("LandMark");
			place.setBounds(width/2+30, height/2-50, 200, 30);
			place.setOpaque(false);
			place.setForeground(Color.BLUE);
			place.setFont(new Font("Candara",Font.BOLD,30));
			add(place);
						
			city = new JLabel("Address");
			city.setBounds(width/2+30, height/2, 200, 30);
			city.setOpaque(false);
			city.setForeground(Color.BLUE);
			city.setFont(new Font("Candara",Font.BOLD,30));
			add(city);
			
			this.setVisible(true);
		}

		public static void main(String[] args) 
		{
			School s = new School();
			try 
			{
				Thread.sleep(3000);
				new Welcome();
				s.dispose();
			}
			catch(Exception e){}
		}
}


