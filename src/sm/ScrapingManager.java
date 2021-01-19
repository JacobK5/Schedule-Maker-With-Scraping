package sm;

import org.jsoup.Jsoup;
//import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapingManager {
	
	String courseName;
	String courseType;
	String site;

	public ScrapingManager(String name) {
		courseName = name;
		courseType = name.substring(0, 4);
		//getInfo(searchFirstPage());
	}
	
	public String searchFirstPage() {
		Document page;
		String result = "error";
		try {
			page = Jsoup.connect("https://app.stfx.ca/web/Forms/shared/Registrar_website_Timetable.htm").get();
			Element link = page.getElementsContainingOwnText(courseType).first();
			//System.out.println(link.attr("href"));
			result = link.attr("href");
		} catch(Exception e) {e.printStackTrace();}
		return result;
	}
	
	public String[] getInfo() { //will add in lab stuff later
		Document doc;
		String slots = "Error";
		String location = "Error";
		try {
			doc = Jsoup.connect(searchFirstPage()).get();
			Element row = doc.getElementsContainingOwnText(courseName).first().parent();
			slots = row.child(8).text();
			location = row.child(9).text();
			//System.out.println(slots + " " + location);
		} catch(Exception e) {e.printStackTrace();}
		
		return new String[] {slots, location};
	}
}
