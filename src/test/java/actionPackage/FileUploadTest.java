package actionPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadTest {
	WebDriver driver;
	@BeforeClass
	public void setUp() {
		System.out.println("Setting up Webdriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	//	driver.manage().window().fullscreen();
	}
	@Test 
	public void testingfileUpload() {
		driver.get("https://the-internet.herokuapp.com/upload");
		WebElement input = driver.findElement(By.id("file-upload"));
		String filePath="C://Users//erkan//OneDrive//Masaüstü//My Notes//XPath.txt";
		input.sendKeys(filePath);
		WebElement upload = driver.findElement(By.id("file-submit"));
		upload.click();
		
	}
















}
