package seleniumautopages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

	  String url="http://demo.automationtesting.in/Register.html";
	 public    WebDriver driver;
	 	 
	   public final By pageHeader = By.tagName("h1");
	   public final By fnameTbox = By.cssSelector("[ng-model='FirstName']");
	   public final By lnameTbox = By.cssSelector("[ng-model='LastName']");
	   public final By addressTarea = By.cssSelector("[ng-model='Adress']");
	   public final By emailTbox = By.cssSelector("[ng-model='EmailAdress']");
	   public final By phonetbox= By.cssSelector("[ng-model='Phone']");
	   public final By langMsDropDown = By.id("msdd");
	   public final By skillDropDown = By.cssSelector("[ng-model='Skill']");
	   public final By countryDropDown = By.id("countries");
		
		public final By countrySelect = By.className("select2-selection--single");
		public final By countryOptions = By.cssSelector("[role='treeitem']");
		public final By yearDropDown = By.id("yearbox");
		public final By monthDropDown = By.cssSelector("[ng-model='monthbox']");
		public final By dayDropDown = By.id("daybox");
		public final By passwordTxtBox = By.id("firstpassword");
		public final By confirmPassTxtBox = By.id("secondpassword");
		public final By submitBtn = By.id("submitbtn");
		 
		 public RegisterPage load() {
			 driver.get(url);
			 return new RegisterPage(driver);
			 
		 }
	 
	 By dynamicLocator(String value) {
			return By.cssSelector("[value ='"+value+"']");
			
				}
	 public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	 

	 public String getPageHeader() {
			return driver.findElement(pageHeader).getText();
	}
	 public void inputName(String fname,String lname) {
			driver.findElement(fnameTbox).sendKeys(fname);
			driver.findElement(lnameTbox).sendKeys(lname);
		}
	 
	
	public void inputAddress(String Address) {
		 driver.findElement(addressTarea).sendKeys(Address);
	 }
	 
	public void inputEmail(String Email) {
		 driver.findElement(emailTbox).sendKeys(Email);
	 }
	 
	public void inputphone(String phone) {
		 driver.findElement(phonetbox).sendKeys(phone);
	 }
	
    

	public void selectGender(String gender) {
		//driver.findElement(dynamicLocator(gender)).click();
		WebElement element = driver.findElement(dynamicLocator(gender));
		System.out.println("Before "+element.isSelected());
		element.click();
		System.out.println("After "+element.isSelected());
	}


	public void selectHobbies(String[] hobbies) {
		for(String hobby:hobbies) {
			WebElement element = driver.findElement(dynamicLocator(hobby));
			System.out.println("Before "+element.isSelected());
			element.click();
			System.out.println("After "+element.isSelected());
	         }
	}
	public void selectLanguages(String[] languages) {
		driver.findElement(langMsDropDown).click();
		for(String lang: languages) {
			WebElement element = driver.findElement(By.linkText(lang));
			element.click();
		}
	}
	
	public void selectSkills(String skill) {
		selectValueByText(skillDropDown, skill);
	}
	
	public void selectcountry(String country) {
		selectValueByText(countryDropDown, country);
	}
	
	public void selectDate(String month, String day, String year) {
		selectValueByText(yearDropDown,year);
		selectValueByText(monthDropDown,month);
		selectValueByText(dayDropDown,day);
		
	}
	
	
	public void selectCountry2(String country) {
		driver.findElement(countrySelect).click();
		List<WebElement> countries = driver.findElements(countryOptions);
		for(WebElement countryElement: countries) {
			if(countryElement.getText().equals(country)) {
				countryElement.click();
				break;
			}
		}
		
	}
	
	public void inputPassword(String password) {
		driver.findElement(passwordTxtBox).sendKeys(password);
	}
	
	public void inputConfirmPassword(String confirmPassword) {
		driver.findElement(confirmPassTxtBox).sendKeys(confirmPassword);
	}
	
	public  webTablePage submit() {
		driver.findElement(submitBtn).click();
		return new webTablePage(driver);
	}	
	
	
	 void selectValueByText(By locator, String value) {
			Select dropdown = new Select(driver.findElement(locator));
			dropdown.selectByVisibleText(value);
		}

		
		
		  public webTablePage register(String fname) {
		  
		  return null ;
		  }
		 
		 
	  
	 
}
