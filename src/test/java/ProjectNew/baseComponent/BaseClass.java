package ProjectNew.baseComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import vinay.pageObject.LandinPage;

public class BaseClass {

	public WebDriver driver;
	public LandinPage landingPage;
	

	
	public WebDriver initializeDriver() throws IOException
	{
		String path = System.getProperty("user.dir");
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(path+"\\src\\main\\java\\vinay\\resources\\GlobalData.properties");
		prop.load(fis);
		
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		
		//String browserName = prop.getProperty("browser");
		
		if(browserName.contains("chrome")) {
		
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		}
		else if(browserName.contains("firefox")) {
			
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Vinay\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		else if(browserName.contains("edge")) {
			//edge
		}
	   
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	
	public LandinPage launchApplication() throws IOException {
		
		driver = initializeDriver();
		 landingPage = new LandinPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		//driver.close();
	}

    public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"\\reports\\"+ testCaseName +".png");
		FileUtils.copyFile(source, file);
		
		return System.getProperty("user.dir")+"\\reports\\"+ testCaseName +".png";
	}
	
	
	
}
