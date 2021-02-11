package seleniumautopages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;

public class webTablePage {
	
	String url = "http://demo.automationtesting.in/WebTable.html";
	 WebDriver driver;
	 WebDriverWait wait;

	 By itemsPerPage = By.cssSelector("[ng-model='grid.options.paginationPageSize']");
	 By firstnameItems = By.cssSelector("[role='row']>div[role='gridcell']:nth-child(2)>div");
	 By emailItems = By.cssSelector("[role='row']>div[role='gridcell']:nth-child(1)>div");
	 By nextbtn = By.className("next-triangle");
	 By maxpages = By.className("ui-grid-pager-max-pages-number");
	 By actionItems = By.cssSelector("[role='row']>div[role='gridcell']:nth-child(6)>user-click-select");
	 By editBtn = By.className("fa-pencil");
	 By editSave = By.cssSelector("save-click>button");
	 By editCancel = By.cssSelector("cancel-click>button");
	 By deleteBtn = By.className("fa-trash-o");
	 By delDelete = By.cssSelector("div.contextshw:not([style*='display']) .btn-danger");
	 By delCancel = By.cssSelector("div.contextshw:not([style*='display']) .btn-custom");

	 public webTablePage(WebDriver driver) {
			this.driver = driver;
			
		}
	public String geturl() {
		return url;
		
	}
	
	public webTablePage load() {
		driver.get(url);
		return new webTablePage(driver);
	}
	public void selectitemsperpage(String noofitems) {
		selectValueByText(itemsPerPage, noofitems);
		
	}

	void selectValueByText(By locator, String value) {
		Select dropdown = new Select(driver.findElement(locator));
	        dropdown.selectByVisibleText(value);
		
	}
	
	 public int isFirstnameAvailable(String fname) {
		List<WebElement> firstNameElements = driver.findElements(firstnameItems);
		
              int flag = 0;
              int row=1;
              for(WebElement firstnameElement: firstNameElements) {
            	  if(firstnameElement.getText().equals(fname)){
				
			flag= row;
			break;
			}
            	  row++;
		}
              return flag;
	} 
	
	void clickNextbtn() {
		driver.findElement(nextbtn).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}

	public int findRowByUserFname(String fname) {
		boolean isNameAvailable = false;
		int pages = 0;
		int row = 0;
		while (!isNameAvailable) {
			row = isFirstnameAvailable(fname);
			isNameAvailable= row>0 ? true: false;
			if(!isNameAvailable) {
				clickNextbtn();
			}
			pages++;
			if(pages == Integer.parseInt(driver.findElement(maxpages).getText().replace("/ ", ""))) {
				break;
			}	
		}
		
		System.out.println(isNameAvailable+" "+pages+" " + row);
		return row;
	}
	
	public boolean deleteItemByUserName(String fname, boolean confirm) {
		int row = findRowByUserFname(fname);
		boolean isDeleted = false;
		if(row > 0) {

			List<WebElement> allActionBtnRows = driver.findElements(actionItems);
			WebElement actionBtns = allActionBtnRows.get(row - 1);

			Actions actions = new Actions(driver);
			actions.contextClick(actionBtns.findElement(deleteBtn)).build().perform();

			if (confirm) {
				wait.until(ExpectedConditions.elementToBeClickable(delDelete)).click();
				driver.switchTo().alert().accept();
				isDeleted = true;
			} else {
				wait.until(ExpectedConditions.elementToBeClickable(delCancel)).click();
			}
		}
		else {
			System.out.println("No row found for the given use name "+fname);
		}
		
		return isDeleted;
	}
	private int isemailAvailable(String email) {
		
		List<WebElement> emailElements = driver.findElements(emailItems);
		
        int flag = 0;
        int row=1;
        for(WebElement emailElement: emailElements) {
      	  if(emailElement.getText().equals(email)){
			
		flag= row;
		break;
		}
      	  row++;
	}
        return flag;
        
} 
	void clickNextBtn() {
		driver.findElement(nextbtn).click();
		}
	
	public int findRowByUserEmail(String email) {
		boolean isemailAvailable = false;
		int pages = 0;
		int row = 0;
		
		while (!isemailAvailable) {
			row = isemailAvailable(email);
			isemailAvailable = row > 0 ? true: false;
			if(!isemailAvailable) {
				clickNextbtn();
			}
			pages++;
			if(pages == Integer.parseInt(driver.findElement(maxpages).getText().replace("/ ", ""))) {
				break;
			}	
		}
		
		System.out.println(isemailAvailable+" "+pages+" " + row);
		return row;
	}
	

	
	
	public void actionItemByUserEmail(String email, boolean confirm) {
		
		int row =findRowByUserEmail(email);
				
		if(row > 0) {
			
			List<WebElement> allActionBtnRows = driver.findElements(actionItems);
			WebElement actionBtns = allActionBtnRows.get(row - 1);

			Actions actions = new Actions(driver);
			
			actions.doubleClick(actionBtns.findElement(editBtn)).click().perform();
			actions.moveToElement(actionBtns.findElement(editCancel)).click().build().perform();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
		
				
		
		
	}
	
		
	}

	
	
	
	
	

