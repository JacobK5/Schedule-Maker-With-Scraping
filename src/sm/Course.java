package sm;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

public class Course {
	
	// String name;
	// String location;
	//String slotNames;
	//Color color;
	//ArrayList<String> names;
	ArrayList<Block> blocks;


	public Course(String name_, String loc, String sn, Color c) {
		blocks = new ArrayList<Block>();
		//name = name_;
		//location = loc;
		String[] slotNames = sn.split("/");
		//names = Arrays.asList(slotNames);
		for(String n : slotNames) {
			blocks.add(new Block(n, c, name_, loc));
		}
	}

	public void draw(Graphics g) {
		for(Block b : blocks) {
			b.draw(g);
		}
	}
}