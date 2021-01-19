package sm;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Font;
// import java.awt.Graphics;
// import java.awt.Color;

public class App {

	JFrame frame;
	JPanel panel;
	JPanel numPanel;
	JPanel classesPanel;
	JPanel startPanel;
	JLabel numClassesLbl;
	JSpinner numClassesSpn;
	JButton makeSchedule;
	JLabel saveName;
	JTextArea saveNameArea;
	ArrayList<ClassAdder> adders;

	public App() {
		setUpFrame();
	}

	public void setUpFrame() {

		// try { 
		//     UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		// } catch (Exception e) {
		//     e.printStackTrace();
		// }

		frame = new JFrame();
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		numPanel = new JPanel();
		//numPanel.setPreferredSize(new Dimension(100, 10));
		classesPanel = new JPanel();
		//classesPanel.setLayout(new BoxLayout(classesPanel, BoxLayout.Y_AXIS));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);

		numClassesLbl = new JLabel("Number of classes:");
		SpinnerModel spm = new SpinnerNumberModel(5, 1, 10, 1);
		numClassesSpn = new JSpinner(spm);
		//numClassesSpn.setValue(Integer.valueOf(5));
		numClassesSpn.addChangeListener(new ChngListener());

		numPanel.add(numClassesLbl);
		numPanel.add(numClassesSpn);
		panel.add(numPanel, BorderLayout.NORTH);

		panel.add(classesPanel, BorderLayout.CENTER);

		adders = new ArrayList<ClassAdder>();
		for(int i = 0; i < (int) numClassesSpn.getValue(); i++) {
			adders.add(new ClassAdder());
		}
		
		for(ClassAdder adder : adders) {
			classesPanel.add(adder);
		}
		JPanel extraPanel = new JPanel();
		JPanel testPanel = new JPanel();
		JPanel oneMorePanel = new JPanel();
		testPanel.setLayout(new BorderLayout());
		saveName = new JLabel("Save name:");
		saveNameArea = new JTextArea(1, 10);
		extraPanel.add(saveName);
		extraPanel.add(saveNameArea);
		testPanel.add(extraPanel, BorderLayout.NORTH);

		JButton makeSchedule = new JButton("Make Schedule");
		makeSchedule.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		makeSchedule.setPreferredSize(new Dimension(200, 100));
		makeSchedule.addActionListener(new MakeScheduleListener());
		oneMorePanel.add(makeSchedule);
		testPanel.add(oneMorePanel, BorderLayout.SOUTH);
		panel.add(testPanel, BorderLayout.SOUTH);

		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		App myApp = new App();
	}


	public class ChngListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			int num = (int) numClassesSpn.getValue();
			while(num != adders.size()) {
				if(num > adders.size()) {
					adders.add(new ClassAdder());
					classesPanel.add(adders.get(adders.size() - 1));
				} else if (num < adders.size()) {
					classesPanel.remove(adders.get(adders.size() - 1));
					adders.remove(adders.size() - 1);
				}
				classesPanel.revalidate();
				classesPanel.repaint();
				num = (int) numClassesSpn.getValue();
			}
			
		}
	}

	public class MakeScheduleListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//System.out.println("Button pressed");
			ArrayList<Course> courses = new ArrayList<Course>();
			for(ClassAdder ca : adders) {
				courses.add(new Course(ca.getName(), ca.getLoc(), ca.getBlocks(), ca.getColor()));
			}
			ScheduleMaker sm = new ScheduleMaker(courses, saveNameArea.getText());
		}
	}
}