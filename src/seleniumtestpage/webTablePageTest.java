package seleniumtestpage;

import seleniumautopages.webTablePage;

public class webTablePageTest  extends BaseTest{

	public static void main(String[] args) {
		try {
		  startUp("Chrome");
		  webTablePage wtPage= new webTablePage(driver).load();
		  getResult(driver.getTitle().equals("Web Table"));
		  wtPage.selectitemsperpage("20");
		 // wtPage.findRowByUserFname("Nithyakalyani");
		  wtPage.actionItemByUserEmail("vo@generce.lk",false);
	
		}
		finally {
			tearDown();
		}
		  
		  
		  
	}

}
