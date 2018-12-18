package com.webelement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElements {
	Faker data = new Faker();
	WebDriver driver;
	@BeforeClass
	public void setUp() {
		System.out.println("Setting up Webdriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}
	
	@Test
	public void myLinks() {
		driver.get("https://github.com");
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		int NumberLinks = links.size();
		System.out.println(NumberLinks);
		 
		for(WebElement link:links) {
			if(!link.getText().isEmpty()) {
				System.out.println(link.getText());
			}
			
		}
		
		List<String> linkNames= new ArrayList<>();
		
		for(WebElement lin: links) {
			if(!lin.getText().isEmpty()) {
				linkNames.add(lin.getText());
			}
		}
		System.out.println(linkNames.toString());
		
		
		
	}
	
	@Test
	public void countingStars() throws InterruptedException {
		driver.navigate().to("https://forms.zohopublic.com/murodil/form/SeleniumWebElements/formperma/eCecYgX4WMcmjxvXVq6UdhA2ABXIoqPAxnAF8H8CCJg");
		
		List<WebElement> textBox =driver.findElements(By.xpath("//input[@type='text']"));
		List<WebElement> dropdown =driver.findElements(By.xpath("//select"));
		List<WebElement> checkBoxes =driver.findElements(By.xpath("//input[@type='checkbox']"));
		List<WebElement> radioButton =driver.findElements(By.xpath("//input[@type='radio']"));
		List<WebElement> button=driver.findElements(By.xpath("//em[.='Submit']"));
	
		Assert.assertEquals(textBox.size(), 2);
		Assert.assertEquals(dropdown.size(), 3);
		Assert.assertEquals(checkBoxes.size(), 9);
		Assert.assertEquals(radioButton.size(), 9);
		Assert.assertEquals(button.size(), 1);
		//Loop through each inputbox and enter random names
		for(WebElement list1: textBox) {
		 
			list1.sendKeys("Erkannnnnnnnnnnn");
		}
		//Loop through each dropDown and randomly select by index
		for(WebElement list2: dropdown) {
			Thread.sleep(1000);
			list2.click();
		}
		//Loop through each checkBoxes and select each one
		for(WebElement list3: checkBoxes ) {
		
			Thread.sleep(1000);
			list3.click();
		}
		//Loop through each radioButton and click one by one by waiting one second intervals
		for(WebElement list4: radioButton) {
			Thread.sleep(1000);
			list4.click();
		}
		// click all buttons
		for(WebElement list5: button) {
			Thread.sleep(1000);
			list5.click();
		}
		
	}
	
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
}
