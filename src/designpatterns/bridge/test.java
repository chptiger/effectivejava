package designpatterns.bridge;

import java.net.URLEncoder;

import org.junit.Test;

/**
 * https://www.geeksforgeeks.org/builder-pattern-in-java/
 */
public class test {

	@Test
	public void test_bridge() {
//		Shape redCircle = new Circle(1, 2, 3, new DrawRed());
//		Shape greenCircle = new Circle(4, 5, 6, new DrawGreen());
//		redCircle.draw();
//		greenCircle.draw();
//		String realFrom = "12321";
//		String text = "test";
//		boolean isBuyer = false;
//		Integer requestId = null;
//		String s = "http://29bf524a.ngrok.io/re/plivoSmsCallback?realFrom="+realFrom+"&text="+ URLEncoder.encode(text)+"&isBuyer="+isBuyer + requestId == null ? "" : "&requestId="+requestId;
//		System.out.println(s);
//		
//		String fileName = "2132142324.pdf";
//		fileName = fileName.substring(0, fileName.length() - 4) + "_1_" + fileName.substring(fileName.length() - 4, fileName.length());
//		String testUrl = "www.upnest.com";
//		String testName = "23432r32_sell.pdf";
//		fileName =  "<br>Listing Documentation: <a target=\"_blank\" href=\"" + testUrl+"\">"+ testName+"</a>";
//System.out.println(fileName);
//
//String  name = "Listing agent added escrow info: <br>EscrowEmail: dfad43@ddfgf.com<br>ListingComm: 1.86 -> 1.85<br>TotalComm: 5.0<br>SoldPrice: 200000 -> 200000<br>SoldDate: 2019-08-04 00:00:00.0 -> <br>Property Address: 1635+California+St+%2351%2C+SAN+FRANCISCO%2C+CA+94109<br>Request URL: http://xins-mbp:8080/re/listRequest?requestId=980054444<br>Agent Name: Craig Ackerman<br><br>Closing Documentation: <a target=\"_blank\" href=\"https://storage.googleapis.com/upnest/upload/escrow/1184666090_e833b6f0-7163-49a5-a5e1-c28019d99000.png\">Screen Shot 2019-08-16 at 1.09.00 PM.png</a> <br>Listing Documentation: <a target=\"_blank\" href=\"https://storage.googleapis.com/upnest/docs/manualUpload/980054444_sell.pdf\">980054444_sell.pdf</a>";
//System.out.println(name);
//name = name.replaceAll("<br>", "\n");
//System.out.println(name);

String test = "123123,123123";
System.out.println(test.substring(0, test.length()/2));
	}
}
