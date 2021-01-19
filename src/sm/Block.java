package sm;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;

public class Block {

	int width;
	int height;
	String name;
	String courseName;
	String location;
	Slot slot;
	Color color;

	public static ArrayList<String> allNames;
	
	public Block(String name, Color c, String cn, String loc) {
		allNames = new ArrayList<String>();
		fillNames();

		courseName = cn;
		location = loc;
		color = c;
		slot = new Slot(name);
	}

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(color);
		g.fillRect(slot.x, slot.y, slot.width, slot.height);
		g.setColor(Color.BLACK);
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 12));
		if(courseName.length() > 8) {
			g2d.drawString(courseName.substring(0, 9), slot.x + 2, slot.y + 10);
		} else {
			g2d.drawString(courseName, slot.x + 2, slot.y + 10);
		}
		
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 10));
		g2d.drawString(location, slot.x + 2, slot.y + 24);
		//System.out.println("Drawn");
	}













	public void fillNames() {
		allNames.add("A1");
		allNames.add("B1");
		allNames.add("C1");
		allNames.add("A4");
		allNames.add("B4");
		allNames.add("C4");
		allNames.add("A7");
		allNames.add("B7");
		allNames.add("C7");
		allNames.add("D1");
		allNames.add("E1");
		allNames.add("F1");
		allNames.add("R1");
		allNames.add("U1");
		allNames.add("W1");
		allNames.add("U4");
		allNames.add("W4");
		allNames.add("U7");
		allNames.add("W7");
		allNames.add("I1");
		allNames.add("J1");
		allNames.add("G1");
		allNames.add("K1");
		allNames.add("L1");
		allNames.add("A2");
		allNames.add("K4");
		allNames.add("L4");
		allNames.add("A5");
		allNames.add("K7");
		allNames.add("L7");
		allNames.add("A8");
		allNames.add("H1");
		allNames.add("D2");
		allNames.add("G3");
		allNames.add("X1");
		allNames.add("Z1");
		allNames.add("X4");
		allNames.add("Z4");	
		allNames.add("X7");
		allNames.add("Z7");
		allNames.add("M1");
		allNames.add("B2");
		allNames.add("C2");
		allNames.add("K2");
		allNames.add("B5");
		allNames.add("C5");
		allNames.add("K5");
		allNames.add("B8");
		allNames.add("C8");
		allNames.add("K8");
		allNames.add("E2");
		allNames.add("F2");
		allNames.add("H2");
		allNames.add("R2");
		allNames.add("W2");
		allNames.add("O1");
		allNames.add("W5");
		allNames.add("O4");
		allNames.add("W8");
		allNames.add("O7");
		allNames.add("J2");
		allNames.add("N1");
		allNames.add("G2");
		allNames.add("L2");
		allNames.add("A3");
		allNames.add("B3");
		allNames.add("L5");
		allNames.add("A6");
		allNames.add("B6");
		allNames.add("L8");
		allNames.add("A9");
		allNames.add("B9");
		allNames.add("D3");
		allNames.add("E3");
		allNames.add("R3");
		allNames.add("Z2");
		allNames.add("U2");
		allNames.add("Z5");
		allNames.add("U5");
		allNames.add("Z8");
		allNames.add("U8");
		allNames.add("M2");
		allNames.add("I2");
		allNames.add("G4");
		allNames.add("C3");
		allNames.add("K3");
		allNames.add("L3");
		allNames.add("C6");
		allNames.add("K6");
		allNames.add("L6");
		allNames.add("C9");
		allNames.add("K9");
		allNames.add("L9");
		allNames.add("F3");
		allNames.add("H3");
		allNames.add("O2");
		allNames.add("X2");
		allNames.add("O5");
		allNames.add("X5");
		allNames.add("O8");
		allNames.add("X8");
		allNames.add("N2");
	}


}