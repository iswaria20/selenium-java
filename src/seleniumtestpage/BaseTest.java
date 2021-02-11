package seleniumtestpage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseTest {
	
	protected static WebDriver driver;
	
	public static void startUp(String browser) {
		String projectPath = System.getProperty("user.dir");
		
		if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", projectPath+"/drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public static void tearDown() {
		driver.quit();
	}
	
	public static void getResult(boolean condition) {
		if(condition)
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
	}

}
