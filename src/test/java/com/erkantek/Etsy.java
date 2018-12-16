package com.erkantek;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Etsy {

	public static void main(String[] args) {

		/*
		 * TC 1: Verify Search term 
		 * 1. Open browser 
		 * 2. Open Etsy homepage 
		 * 3. Enter search term 
		 * 4. Verify the results page title contains the search term 
		 * 5. Verify search entry is still saved in the search bar
		 */

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.etsy.com/ca/");
	
		
		
		String searchTerm="wooden spoon";

		//		driver.findElement(By.id("search-query")).sendKeys(searchTerm);
		//WebElemnt class represent element from page. find element method returns a webelement object
		
		WebElement input =driver.findElement(By.id("search-query"));
	    input.sendKeys(searchTerm+Keys.ENTER);
		
	    input=driver.findElement(By.id("search-query"));
	    //To hit the enter you have to import Keys class.
	    String actual = input.getAttribute("value");
	    System.out.println(actual);
		
		if(actual.equals(searchTerm)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
			System.out.println("Expected:\t"+ searchTerm);
			System.out.println("Actual:\t"+ actual);
		}
		System.out.println(input.getAttribute("outerHTML"));
	 
		driver.findElement(By.linkText("Sell on Etsy")).click();
		
		 input=driver.findElement(By.id("search-query"));
		    //To hit the enter you have to import Keys class.
		    String actual2 = input.getAttribute("id");
		    System.out.println(actual2);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
