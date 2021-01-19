package sm;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.io.File;


public class ScheduleMaker /*implements ActionListener*/ {
	JFrame frame;
	PanelClass schedulePanel;
	BufferedImage image;
	ArrayList<Course> courses;
	boolean done = false;
	//ArrayList<Slot> slots;

	public ScheduleMaker(ArrayList<Course> courses_, String saveName) {
		loadImage();
		courses = new ArrayList<Course>(courses_);
		updatePaint();
		saveImage(saveName);
		frame = new JFrame();
		schedulePanel = new PanelClass();
		frame.getContentPane().add(schedulePanel);
		frame.setSize(817, 888);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		// Timer timer = new Timer(20, this);
		// timer.start();
	}

	public void loadImage() {
		try {
			image = ImageIO.read(getClass().getResource("BlankSchedule.png"));
		} catch(Exception e) {e.printStackTrace();}
	}

	public void saveImage(String sn) {
		if(sn.equals("")) {
			sn = "save";
		}
		try {
		    // retrieve image
		    //BufferedImage bi = getMyImage();
		    File outputfile = new File("bin/sm/saves/" + sn + ".png");
		    ImageIO.write(image, "png", outputfile);
		} catch (Exception e) {}
	}

	// public static void main(String[] args) {
	// 	ScheduleMaker sm = new ScheduleMaker();
	// }

	public void updatePaint() {
		Graphics g = image.createGraphics();
		for(Course c : courses) {
				c.draw(g);
		}
	}

	// @Override
	// public void actionPerformed(ActionEvent e) {
	// 	schedulePanel.repaint();
	// 	if(!done) {
	// 		saveImage();
	// 		done = true;
	// 	}
	// }

	public class PanelClass extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
			// for(Course c : courses) {
			// 	c.draw(g);
			// }
		}
	}
}