package job.application;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static org.testng.Assert.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PersonalInfoTests {
	WebDriver driver;
	String firstName;
	String lastName;
	int gender;
	String dateOfBirth;
	String email;
	String phoneNumber;
	String city;
	String state;
	String country;
	int annualSalary;
	List<String> tecnologies;
	int yearOfExperience;
	String education;
	String gitHub;
	List<String> certifications;
	String additionalSkills;
	Random random = new Random();
	Faker data = new Faker();

	@BeforeClass
	public void setUp() {
		System.out.println("Setting up Webdriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.manage().window().fullscreen();
	}

	@BeforeMethod
	public void navigateToHomePage() {
		System.out.println("Navigate to home page in @BeforeMEthod");
		driver.get("https://forms.zohopublic.com/murodil/form/Jo" + "bApplicationForm/formperma/kOqgtfkv1dMJ4Df6k4"
				+ "_mekBNfNLIconAHvfdIk3CJSQ");
		firstName = data.name().firstName();
		lastName = data.name().lastName();
		gender = data.number().numberBetween(1, 3);
		dateOfBirth = data.date().birthday().toString();
		email = "erk@gmail.com";
		phoneNumber = data.phoneNumber().cellPhone();
		city = data.address().cityName();
		state = data.address().state();
		country = data.address().country();
		annualSalary = data.number().numberBetween(60000, 150000);
		tecnologies = new ArrayList<>();
		tecnologies.add("Java-" + data.number().numberBetween(1, 4));
		tecnologies.add("HTML-" + data.number().numberBetween(1, 4));
		tecnologies.add("Selenium WebDriver-" + data.number().numberBetween(1, 4));
		tecnologies.add("TestNG-" + data.number().numberBetween(1, 4));
		tecnologies.add("Maven-" + data.number().numberBetween(1, 4));
		tecnologies.add("JUnit-" + data.number().numberBetween(1, 4));
		tecnologies.add("Cucumber-" + data.number().numberBetween(1, 4));
		tecnologies.add("API Automation-" + data.number().numberBetween(1, 4));
		tecnologies.add("JDBC-" + data.number().numberBetween(1, 4));
		tecnologies.add("SQL-" + data.number().numberBetween(1, 4));
		yearOfExperience = data.number().numberBetween(1, 11);
		education = data.number().numberBetween(1, 4) + "";
		gitHub = "https://github.com/erkanozcel47/automation-project.git";
		certifications = new ArrayList<>();
		certifications.add("Java OCA");
		certifications.add("AWS");
		additionalSkills = data.job().keySkills();

	}

	@Test
	public void submitFullApplication() {
		driver.findElement(By.xpath("//input[@name='Name_First']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(lastName);
        setGender(gender);
        setDateOfbirth(dateOfBirth);
        driver.findElement(By.xpath("//input[@name='Email']")).clear();
		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='countrycode']")).sendKeys(phoneNumber);
		driver.findElement(By.xpath("//input[@name='Address_City']")).sendKeys(city);
		driver.findElement(By.xpath("//input[@name='Address_Region']")).sendKeys(state);
		Select countryElemnet = new Select(driver.findElement(By.xpath("//select[@id='Address_Country']")));
		countryElemnet.selectByVisibleText(country);
		countryElemnet.selectByIndex(data.number().numberBetween(1, countryElemnet.getOptions().size()));
	    driver.findElement(By.xpath(" //input[@name='Number']")).sendKeys(String.valueOf(annualSalary)+Keys.TAB);
	    verifySalaryCalculations(annualSalary);
	    driver.findElement(By.xpath("//em[.=' Next ']")).click();
	    
	}
	public void verifySalaryCalculations(int annual) {
	
		String monthly=driver.findElement(By.xpath("//input[@name='Formula']")).getAttribute("value");
		String weekly=driver.findElement(By.xpath("//input[@name='Formula1']")).getAttribute("value");
		String hourly=driver.findElement(By.xpath("//input[@name='Formula2']")).getAttribute("value");
		
		System.out.println(monthly);
		System.out.println( weekly);
		System.out.println(hourly);
		DecimalFormat formatter = new DecimalFormat("#.##");
		Assert.assertEquals(Double.parseDouble(monthly), Double.parseDouble(formatter.format((double)annual/(double)12)));
		Assert.assertEquals(Double.parseDouble(weekly), Double.parseDouble(formatter.format((double)annual/(double)52)));
		Assert.assertEquals(Double.parseDouble(hourly), Double.parseDouble(formatter.format((double)annual/(double)52.0/40.0)));
		
	}
	
	
	
	public void setDateOfbirth(String bday) {
		String[] pieces = bday.split(" ");
		String birthDay = pieces[2]+"-"+pieces[1]+"-"+pieces[5];
	    driver.findElement(By.xpath("//input[@id='Date-date']")).sendKeys(birthDay);
	}

	public void setGender(int n) {
		if(gender==1) {
			driver.findElement(By.xpath("//input[@value='Male']")).click(); 
		}else {
			driver.findElement(By.xpath("//input[@value='Female']")).click();
		}
	}
	
	@Test
	public void fullNameEmptyTest() {
		// Firstly assert that you are on correct page
		String expected = "SDET Job Application";
		Assert.assertEquals(driver.getTitle(), expected);
		driver.findElement(By.xpath("//input[@name='Name_First']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//em[.=' Next ']")).click();

	}

}
