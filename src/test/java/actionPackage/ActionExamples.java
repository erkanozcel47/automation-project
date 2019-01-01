package actionPackage;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionExamples {

	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	String url="https://www.primefaces.org/showcase/ui/misc/effect.xhtml";
	@Test
	public void doubleClickTest() {
		String url="https://www.primefaces.org/showcase/ui/misc/effect.xhtml";
		driver.get(url);
		WebElement slide =driver.findElement(By.id("slide_header"));
		Actions action = new Actions(driver);
		action.doubleClick(slide).perform();
	}
	
	@Test 
	public void hoverTest1() throws InterruptedException {
		driver.get("https://www.amazon.com/");
		WebElement hello = driver.findElement(By.xpath("//span[.='Hello. Sign in']"));
		Actions act = new Actions(driver);
		act.moveToElement(hello).perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Your Garage")).click();
		
		
	}
	@Test 
	public void hoverTest2()  {
		driver.get("https://www.amazon.com/");
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		actions.sendKeys(Keys.ARROW_DOWN).perform();
		actions.sendKeys(Keys.ARROW_DOWN).perform();
		 
	}
	@Test 
	public void draganddrop() throws InterruptedException {
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        //drag and drop operation involves 2 elements.
		//source and target.
		//source: element which we will move
		//target: element where we drop the sourc
	    WebElement source = driver.findElement(By.id("draggable"));
	    WebElement target = driver.findElement(By.id("droptarget"));
	    Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
		Thread.sleep(2000);
		action.moveToElement(source).clickAndHold().moveToElement(target).release().perform();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

