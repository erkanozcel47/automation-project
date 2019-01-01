package iFrame.Tabs.Windows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class PopUpExamples extends TestBase {
	
	@Test 
	public void jsAlertTest() {
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("(//button)[1]")).click();
		Alert alert = driver.switchTo().alert();
		
		System.out.println(alert.getText());
		 //Click on okay in alert.
		alert.accept();
		
		driver.findElement(By.xpath("(//button)[2]")).click();
        alert.dismiss();
		
	
    	driver.findElement(By.xpath("(//button)[3]")).click();
        alert.sendKeys("Chattt");
        System.out.println(alert.getText());
        alert.accept();
		
	}
	
	@Test
	public void htmlPopUp() {
		String url="https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml";
		driver.get(url);
		driver.findElement(By.xpath("//span[.='Destroy the World']")).click();
		driver.findElement(By.xpath("//span[.='No']")).click();
		 
	}
	
	
	
	
	
	
	
	
	
	
	

}
