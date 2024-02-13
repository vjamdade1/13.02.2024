package com.traval.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.traval.qa.base.TestBaseGD;

public class ResentViewHotel extends TestBaseGD
{
	
	public String SelectedFirstHotelName;
	public String SelectedSecondHotelName;
	public String SelectedThirdHotelName;
	
	public String HomepageFirstHotel;
	public String HomepageSecondHotel;
	public String HomePageThirdHotel;
	
	public String containerTextRecentviewHotel;
	
	
	@FindBy(xpath = ("//*[@data-rank=\"0\"]"))
    WebElement ClickFirstHotel;
	
	@FindBy(xpath = ("//*[@data-rank=\"1\"]"))
    WebElement ClickSecondHotel;
	
	@FindBy(xpath = ("//*[@data-rank=\"2\"]"))
    WebElement ClickThirdHotel;
	
	@FindBy(xpath=("//div[@class='cardContainer']"))
	WebElement RecentviewContainer;
	
	@FindBy(xpath=("//*[@id=\"recentlyViewedContainer\"]/div[2]/a[1]"))
	WebElement ResentTabFirstHotel;
	
	@FindBy(xpath=("//*[@id=\"recentlyViewedContainer\"]/div[2]/a[2]"))
	WebElement ResentTabSecondHotel;
	
	@FindBy(xpath=("//*[@id=\"recentlyViewedContainer\"]/div[2]/a[3]"))
	WebElement ResentTabThirdHotel;
	
	@FindBy(xpath="//img[@id='navBarLogo']")
	WebElement HomepageLogo;
	
	
	public ResentViewHotel() 
	{

		PageFactory.initElements(driver, this);
		// he this keyword can be used to refer current class instance variable.
		
	}
	
	
	public void WaitinhotellistFirstandStoreName() 
	{
		WebDriverWait wait231 = new WebDriverWait(driver, Duration.ofSeconds(30));
		// Wait for an element to be present and invisible
		WebElement loadingResult1 = driver.findElement(By.xpath("//*[@data-rank=\"0\"]"));
		wait231.until(ExpectedConditions.visibilityOf(loadingResult1));
		

		SelectedFirstHotelName=driver.findElement(By.className("srHotelName")).getText();	
		System.out.println("1.Selected Hotel Is"+"="+SelectedFirstHotelName);	
		ClickFirstHotel.click();
	}
	
	
	
	public void WaitinhotellistSecondandStoreName() 
	{
		WebDriverWait wait232 = new WebDriverWait(driver, Duration.ofSeconds(30));
		// Wait for an element to be present and invisible
		WebElement loadingResult2 = driver.findElement(By.xpath("//*[@data-rank=\"1\"]"));
		wait232.until(ExpectedConditions.visibilityOf(loadingResult2));
		SelectedSecondHotelName=driver.findElement(By.xpath("//*[@data-rank=\"1\"]/div[2]/div[1]/div")).getText();	
		System.out.println("2.Selected Hotel Is"+"="+SelectedSecondHotelName);
		ClickSecondHotel.click();
	}
	
	public void WaitinhotellistThirdandStoreName() 
	{
		WebDriverWait wait233 = new WebDriverWait(driver, Duration.ofSeconds(30));
		// Wait for an element to be present and invisible
		WebElement loadingResult3 = driver.findElement(By.xpath("//*[@data-rank=\"2\"]"));
		wait233.until(ExpectedConditions.visibilityOf(loadingResult3));
		SelectedThirdHotelName=driver.findElement(By.xpath("//*[@data-rank=\"2\"]/div[2]/div[1]/div")).getText();	
		System.out.println("3.Selected Hotel Is "+"="+SelectedThirdHotelName);	
		ClickThirdHotel.click();
	}
	
	public void GotoHomePage() 
	{
		HomepageLogo.click();
	}
	
	public void RecentViewHotelNames() throws Exception 
	
	{
		WebDriverWait wait234 = new WebDriverWait(driver, Duration.ofSeconds(30));
		// Wait for an element to be present and invisible
		WebElement loadingResult4 = RecentviewContainer;
		wait234.until(ExpectedConditions.visibilityOf(loadingResult4));
		Thread.sleep(1000);
	        HomepageFirstHotel=ResentTabFirstHotel.getText();
	        System.out.println("1."+HomepageFirstHotel);
	        HomepageSecondHotel=ResentTabSecondHotel.getText();
	        System.out.println("2."+HomepageSecondHotel);
	        HomePageThirdHotel=ResentTabThirdHotel.getText();
	        System.out.println("3."+HomePageThirdHotel);

		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
