package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cases {

	/**
	 * Test Case 1: Amazon search results 1. Go to amazon.com 2. Enter search term
	 * Selenium book 3. Verify that a result with “Selenium Testing Tools Cookbook”
	 * is displayed anywhere in the results 4. Enter search term Java OCA book 5.
	 * Verify that a result with “Selenium Testing Tools Cookbook” is not displayed
	 * anywhere in the results
	 **/

	WebDriver driver;

	@Test
	public void amazonSearch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		String selenium = "Selenium book";
		String expected = "Selenium Testing Tools Cookbook";
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(selenium + Keys.ENTER);
		String xpath="//h2[@class='a-size-medium s-inline  s-access-title  a-text-normal'and .='Selenium Testing Tools Cookbook']";
		Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());

		driver.close();
//		driver.findElement(By.id("twotabsearchtextbox")).clear();
//		String ocaBook = "Java OCA book";
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(ocaBook + Keys.ENTER);
//		driver.findElement(By.id("twotabsearchtextbox")).clear();
//      
		
		
	}

	/**
	 * <h2 data-attribute="Selenium Testing Tools Cookbook - Second Edition"
	 * data-max-rows="0" class="a-size-medium s-inline s-access-title a-text-normal">Selenium Testing Tools Cookbook - Second Edition</h2>
	 */
	

}
