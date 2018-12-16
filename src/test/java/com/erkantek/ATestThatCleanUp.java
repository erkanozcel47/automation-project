package com.erkantek;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ATestThatCleanUp {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void searchAmazon() {
		driver.get("http://amazon.com");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Father day gifts" + Keys.ENTER);
		Assert.assertTrue(driver.getTitle().contains("Father day gifts"));
	}

	@Test
	public void searchGoogle() {

		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Father day gifts" + Keys.ENTER);
		Assert.assertTrue(driver.getTitle().contains("Father day gifts"));
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
/*
 * Test case 1 go to amazon searchfor something
 */
/*
 * test case 2 go to google search for something
 */