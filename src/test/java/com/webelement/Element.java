package com.webelement;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Element {
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
	public void webElementExamples() {
		driver.get("https://forms.zohopublic.com/murodil/form/Jo" + "bApplicationForm/formperma/kOqgtfkv1dMJ4Df6k4"
				+ "_mekBNfNLIconAHvfdIk3CJSQ");
		WebElement email = driver.findElement(By.name("Email"));
		String value =email.getAttribute("value");
		String maxLength=email.getAttribute("maxlength");
		String tag = email.getTagName();
		boolean b = email.isEnabled();
		System.out.println("Value: "+value+"\n"+
				           "MaxLength: "+ maxLength+"\n"+
				            "TagName: "+ tag +"\n"+
				             "isEnabled:"+b);
	assertEquals(value, "youremail@mail.com");
	email.clear();
	email.sendKeys("anotheremail@mail.com");
	
	WebElement country = driver.findElement(By.id("Address_Country"));
	Select selectcountry = new Select(country);
	String d=selectcountry.getFirstSelectedOption().getText();
	System.out.println(d);
	selectcountry.selectByIndex(69);
	 
	WebElement cSalary =driver.findElement(By.name("Number"));
	assertEquals(cSalary.isDisplayed(), true);
	driver.get("http://google.com");
	driver.findElement(By.id("Address_Country"));
	cSalary.sendKeys("1234567");
	}
	
	

}
