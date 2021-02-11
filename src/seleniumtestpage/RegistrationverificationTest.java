package seleniumtestpage;

import seleniumautopages.RegisterPage;
import seleniumautopages.webTablePage;


public class RegistrationverificationTest  extends BaseTest{
public static void main(String[] args) throws InterruptedException {
		
		try {
			startUp("Chrome");
			//RegisterPage register = new RegisterPage(driver).load();
			RegisterPage rp = new RegisterPage(driver).load();
			String fname = "nithyakalyani";
			webTablePage wtPage = rp.register(fname);
			wtPage.selectitemsperpage("20");
			wtPage.findRowByUserFname(fname);
			driver.wait(3000);
		}
		finally {
			tearDown();
		}
	}
	
}
