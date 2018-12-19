package com.webelement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	WebDriver driver;
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	
	@Test
	public void amazonPrice() {
		driver.get("https://www.amazon.com/s/ref=nb_sb_ss_c_1_7?url=search-alias%3Daps&field-keywords=wooden+spoons&sprefix=wooden+%2Caps%2C177&crid=1UI4VKV9WTYC9");
		List<WebElement> spoon =driver.findElements(By.xpath("//h2"));
		List<String> listOfDescription = new ArrayList<>();
		for (WebElement wood : spoon) {
			listOfDescription.add(wood.getAttribute("data-attribute"));
			
		}
		for (String list : listOfDescription) {
			System.out.println(list.toString()+"\n");
		}
		List<WebElement> price =driver.findElements(By.xpath("//span[@class='a-color-base sx-zero-spacing']"));
		for (WebElement prc : price) {
			System.out.println(prc.getText());
		}
		for (int i = 0; i <spoon.size(); i++) {
			System.out.println(spoon.get(i).getText());
			System.out.println(price.get(i).getText());
			System.out.println("============");
		}
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
