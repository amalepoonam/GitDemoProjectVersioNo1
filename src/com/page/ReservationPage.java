package com.page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReservationPage {
	WebDriver driver = null;
	ChromeOptions option = null;
	WebDriverWait wait = null;

	@BeforeMethod
	public void setUp() {
		option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// wait = new WebDriverWait(driver, 60);
		driver.get("https://www.yosemitewestgate.com/reservations");
		

	}

	@Test
	public void verify_Title() {
		String title = driver.getTitle();
		System.out.println("Title:" + title);
		System.out.println("title");
	
	}

	@Test
	public void Check_RoomType() {
		List<WebElement> allRow = driver.findElements(By.xpath("//strong[@class='F24']"));
		System.out.println(allRow);
		int actual = allRow.size();
		Assert.assertEquals(actual, 5);
	}

	@Test
	public void numOfLinkPresent() {
		List<WebElement> link = driver.findElements(By.tagName("a"));
		int actual_link = link.size();
		System.out.println("total link present:" + actual_link);
		int explink = actual_link;
		Assert.assertEquals(actual_link, explink);

	}
	

	@Test
	public void verifyModifyButton() {
		String act = driver.findElement(By.xpath("//a[@class='modify']")).getText();
		System.out.println("Title:" + act);
		String exp = act;
		Assert.assertEquals(act, exp);

	}
	@Test
	public void verifyAccessibilityButton() {
		String act = driver.findElement(By.xpath("//span[@class='white textacc F17']")).getText();
		System.out.println("Title:" + act);
		String exp = act;
		Assert.assertEquals(act, exp);
		
	} 

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
