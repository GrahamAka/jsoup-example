import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 
 */

/**
 * @author Graham
 *
 */
class TestCase {

	public String getSiblingURL() {
		return sURL;
	}

	public void setSiblingURL(String URL) {
		this.sURL = URL;
	}

	public String getURL() {
		return pURL;
	}

	public void setURL(String URL) {
		this.pURL = URL;
	}

	private Document pDoc; //Product Page document
	private Document sDoc; //Sibling Page document
	
	private String pURL; //Product Page URL 
	private String sURL; //Sibling Page URL
	
	public boolean loadDoc() throws IOException {
		pDoc = Jsoup.connect(pURL).get();
		sDoc = Jsoup.connect(sURL).get();
		
		if(pDoc.hasText() && sDoc.hasText())
			return true;
		else
			return false;
	}
	
	public void findImages() {
		
		//Extract all the image elements from the "target" product page
		Elements img = pDoc.select("img[src~=(?i)\\.(png|jpe?g)]");	
		
		//Get the sibling image elements to eliminate Framework
		Elements sImg = sDoc.select("img[src~=(?i)\\.(png|jpe?g)]");	
		
		//Extract the image elements from a sibling product page
		Elements rImg = new Elements();
		
		for(int n=0; n<img.size();n++) {
			boolean Matched = false;
			Element tElement = img.get(n);
			
			for(int m=0; m<sImg.size(); m++) {
				Element sElement = sImg.get(m);
				String sElementHtml = sElement.toString();
				String tElementHtml = tElement.toString();
				
				if(sElementHtml.equalsIgnoreCase(tElementHtml)) 
					Matched = true;
			}
			
			if(!Matched)
				rImg.add(tElement);
		}
	}

}
