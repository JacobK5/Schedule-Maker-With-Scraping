package sm;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.Container;
import java.awt.Color;
import java.awt.Dimension;

public class ClassAdder extends JPanel {
	JLabel cnLbl;
	JTextArea cnArea;
	JLabel locLbl;
	JTextArea locArea;
	JLabel blocksLbl;
	JTextArea blocksArea;
	JButton colorChooser;
	JButton searchBtn;


	public ClassAdder() {
		cnLbl = new JLabel("Class name:");
		cnArea = new JTextArea(1, 9);
		cnArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		locLbl = new JLabel("Class Location:");
		locArea = new JTextArea(1, 9);
		locArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		blocksLbl = new JLabel("Time Blocks:");
		blocksArea = new JTextArea(1, 9);
		blocksArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		colorChooser = new JButton("Class Color");
		colorChooser.addActionListener(new CCListener());
		colorChooser.setBackground(Color.GRAY);
		searchBtn = new JButton("Search");
		searchBtn.addActionListener(new SBListener());
		searchBtn.setBackground(Color.GRAY);
		//cnArea.setBackground(Color.GRAY);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setBackground(Color.WHITE);
		this.add(cnLbl);
		this.add(cnArea);
		this.add(locLbl);
		this.add(locArea);
		this.add(blocksLbl);
		this.add(blocksArea);
		this.add(colorChooser);
		this.add(searchBtn);
		//this.setPreferredSize(new Dimension(500, 100));
		disableTabbingInTextAreas(this);
   	}

   	public String getName() {
   		return cnArea.getText();
   	}

   	public String getLoc() {
   		return locArea.getText();
   	}

   	public String getBlocks() {
   		return blocksArea.getText();
   	}

   	public Color getColor() {
   		return colorChooser.getBackground();
   	}

   	//from Abel M. on https://stackoverflow.com/questions/5042429/how-can-i-modify-the-behavior-of-the-tab-key-in-a-jtextarea
   	public static void disableTabbingInTextAreas(Component component){
	    if(component instanceof Container && !(component instanceof JTextArea)){
	        for(final Component c : ((Container) component).getComponents() ){
	            disableTabbingInTextAreas(c);
	        }
	    }else if(component instanceof JTextArea){
	        final Component c = component;
	        c.addKeyListener(new KeyListener() {
	            //@Override
	            public void keyTyped(KeyEvent e) {}

	            //@Override
	            public void keyPressed(KeyEvent e) {
	                if(e.getKeyChar() == '\t'){
	                    c.transferFocus();
	                    e.consume();
	                }
	            }

	            //@Override
	            public void keyReleased(KeyEvent e) {}
	        });
	    }
	}

	public void buttonPressed() {
		Color initialcolor=Color.GRAY;    
		Color color=JColorChooser.showDialog(this,"Select a color",initialcolor);    
		colorChooser.setBackground(color);  
	}


	public class CCListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {    
			  buttonPressed();
		}    
	}
	
	public class SBListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {    
			  System.out.println("Searching");
			  ScrapingManager smgr = new ScrapingManager(getName());
			  String[] info = smgr.getInfo();
			  blocksArea.setText(info[0]);
			  locArea.setText(info[1]);
		}    
	}
}