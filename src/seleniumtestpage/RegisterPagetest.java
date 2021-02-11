package seleniumtestpage;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import seleniumautopages.RegisterPage;
import seleniumautopages.webTablePage;

public class RegisterPagetest  extends BaseTest {
 	 
	
		public static void main(String[]args) throws InterruptedException {
	      startUp("Chrome");
		  RegisterPage register = new RegisterPage(driver).load();
		  getResult(register.getPageHeader().contains("Automation Demo Site"));
     	  verifyUserRegistration();
		 Thread.sleep(5000);
		  tearDown();
		
	}		 
	
	

	public static  void verifyUserRegistration() {
		String fname = "nithyakalyani";
		String lname = "Arun";		
		String Address = "Dallas\nUSA";
		String Email = "nithya20@gmail.com";
		String phone = "9789868900";
		String gender = "FeMale";
		String[] hobbies = {"Movies","Hockey"};
		String[] languages = {"English", "French", "Hindi"};
		String skill = "Java";
		String country1 = "United States";
		String country2 = "United States of America";
		String year = "1982";
		String month = "May";
		String day = "28";
		String password = "Apple123@";
		String confirmPassword = "Apple123@";
		
		 RegisterPage register = new RegisterPage(driver);
		 
		register.inputName(fname,lname);
		register.inputAddress(Address);
		register.inputEmail(Email);
		register.inputphone(phone);
		register.selectGender(gender);
		register.selectHobbies(hobbies);
		register.selectLanguages(languages);
		register.selectSkills(skill);
		register.selectcountry(country1);
		register.selectCountry2(country2);
		register.selectDate(month, day, year);
		register.inputPassword(password);
		register.inputConfirmPassword(confirmPassword);
	    register.submit();
	    
	    
	   System.out.println(" Test passed");
	   
	   webTablePage webtp = register.submit();
	  WebDriverWait wdwait = new WebDriverWait(driver,6);
	 wdwait.until(ExpectedConditions.urlToBe("http://demo.automationtesting.in/WebTable.html"));
	  System.out.println(driver.getCurrentUrl());
	   getResult(driver.getCurrentUrl().equals(webtp.geturl()));
	   
	}	

}
