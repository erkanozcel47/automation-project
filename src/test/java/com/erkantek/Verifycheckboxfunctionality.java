package com.erkantek;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verifycheckboxfunctionality {

	public static void main(String[] args) {

		/**
		 * TC 2: Verify checkbox functionality 
		 * 1. Open browser 
		 * 2. Go to http://the-internet.herokuapp.com/checkboxes 
		 * 3. Verify that the first checkbox is not selected 
		 * 4. Verify that the second checkbox is selected 
		 * 5. Click on the first checkbox 
		 * 6. Verify that the first checkbox is selected 
		 * 7. Verify that the second checkbox is selected 
		 * 8. Click on the second checkbox
		 * 9. Verify that the first checkbox is selected 
		 * 10. Verify that the second checkbox is not selected
		 */

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver =new ChromeDriver();
		
	 driver.get("https://www.w3schools.com/bootstrap/default.asp");
	 
	 driver.findElement(By.xpath("//a[@id='topnavbtn_references']")).click();
	 
	 List<WebElement> list = driver.findElements(By.xpath("//div[@class='w3-col m4\']"));
		
		
	 for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			  
	 }
				 
		
		
		
		
		
		
		
		
		
		
		
		
 
		
	}

}
