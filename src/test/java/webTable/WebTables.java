package webTable;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {
	String url="file:///C:/Users/erkan/OneDrive/Masa%FCst%FC/Eclipse/automation-project/src/test/java/webTable/webtable.html";
WebDriver driver;
	@BeforeClass
	public void setUp() {
		System.out.println("Setting up Webdriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// driver.manage().window().fullscreen();
	}
	
	@Test
	public void readScores() {
		
		driver.get(url);
		//Read whole table data
//		WebElement table =driver.findElement(By.tagName("table"));
//		System.out.println(table.getText());
		
		//Find out how many rows in the table
    //    List <WebElement> rows=driver.findElements(By.xpath("//table[@id='worldcup']/tbody/tr"));		
	//	System.out.println(rows.size()-1);
		
		//Print all table headers one by one
//		List<WebElement> header = driver.findElements(By.xpath("//table[@id='worldcup']/tbody/tr[1]/th"));
//		List<String> expHeader = Arrays.asList("Team1","Score","Team2");
//		List<String> printHeader = new ArrayList<>();
//		for (WebElement head : header) {
//			printHeader.add(head.getText());
//			}
//
//		for (String str : printHeader) {
//			System.out.println(str.toString());
//		}
	//assertEquals(printHeader, expHeader) ;
	
//		SoftAssert soft = new SoftAssert();
//		soft.assertEquals(printHeader, expHeader);
//		soft.assertAll();
	//Write xpath and findelemt gettext needs to print egypt
//		
//		String srty=driver.findElement(By.xpath("//table[@id='worldcup']/tbody/tr[4]/td[3]")).getText();
//		System.out.println(srty);
//		String egypt= "Egypt";
//		SoftAssert soft2 = new SoftAssert();
//		soft2.assertEquals(srty, egypt);
//		soft2.assertAll();
		int rowsCount=driver.findElements(By.xpath("//table[@id='worldcup']/tbody/tr")).size();
		int colsCount=driver.findElements(By.xpath("//table[id='worldcup']/tbody/tr/th")).size();
		
		for(int tr=1; tr<=rowsCount; tr++) {
			for(int col=1; col<=colsCount; col++) {
				String xpath="//table[@id='worldcup']/tbody/tr["+tr+"]/td["+col+"]";
				String tdData=driver.findElement(By.xpath(xpath)).getText();
				System.out.println(tdData+"\t");
			}
			System.out.println();
		}
		
	}
	
	
}
