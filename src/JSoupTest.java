import java.io.IOException;

/**
 * @author Graham
 *
 */
public class JSoupTest {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TestCase oTest = new TestCase();
		
		oTest.setURL("http://www.amazon.co.uk/gp/product/B005KELQEU/ref=s9_simh_gw_p400_d0_i6?pf_rd_m=A3P5ROKL5A1OLE&pf_rd_s=center-3&pf_rd_r=148Q2GMG2GXJBQ7W17X0&pf_rd_t=101&pf_rd_p=455345967&pf_rd_i=468294");
		oTest.setSiblingURL("http://www.amazon.co.uk/Philips-LivingColors-70018-31-PU/dp/B008B4DCCU/ref=sr_1_4?ie=UTF8&qid=1388687269&sr=8-4&keywords=philips+hue");

		// TODO Auto-generated method stub
		try {
			if(oTest.loadDoc()) {
				//Do stuff
				oTest.findImages();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}


}
