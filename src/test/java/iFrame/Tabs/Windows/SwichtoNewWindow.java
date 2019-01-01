package iFrame.Tabs.Windows;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SwichtoNewWindow extends TestBase{

	@Test
	public void tabs() {
		driver.get("http://the-internet.herokuapp.com/windows");
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Click Here")).click();
		
		String firstWnindow =driver.getWindowHandle();
		
		System.out.println("Curent"+firstWnindow );
		Set<String> windowhandles = driver.getWindowHandles();
		for ( String string : windowhandles) {
			System.out.println(string );
		    if(firstWnindow.equals(string))  
		    	driver.switchTo().window(string);
		     
			
		}
		
	}
	
	@Test
	public void switchbytitle() {
		driver.get("http://the-internet.herokuapp.com/windows");
		driver.findElement(By.linkText("Click Here")).click();
		String expectedTitle= "New Window";
		
		switcToMethod(expectedTitle);
		assertEquals(driver.getTitle(), expectedTitle, "Title did not match");
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
