package com.traval.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.traval.qa.base.TestBaseGD;
import com.traval.qa.confiq.ConfigureProperties;
import com.traval.qa.pages.LoginLogoutValidation;
import com.traval.qa.pages.ResentViewHotel;
import com.traval.qa.pages.SearchCar;
import com.traval.qa.pages.SearchHotels;

public class ResentViewHotelTest extends TestBaseGD
{

	public SearchHotels searchhotels;
	public SearchCar searchcar;
	public LoginLogoutValidation loginLogoutvalidation;
	public ResentViewHotel recentviewhotel;
	
	
	public ResentViewHotelTest()

	{
		super();

		// The 'super' keyword allows referencing the parent class or superclass
	}
	
	@BeforeClass
	public void setup1() throws Exception 
	{
		
		initialization1();
		searchhotels = new SearchHotels();
		searchcar=new SearchCar();
		loginLogoutvalidation=new LoginLogoutValidation();
		recentviewhotel=new ResentViewHotel();
	}
     
	@Test(priority = 1)
	public void Validate_HomePage() throws Exception 
	{
		String Title = searchhotels.ValidateHomeTitle();
		Assert.assertEquals(Title, "GoDo Travel - Get up to 30% cash back after you check out");
		searchhotels.acceptpolicy();
		searchhotels.policybuttonclick();
		System.out.println(Title);
	
	}
	@Test(priority = 2)
	public void ValidataBy_AddingRequirment_InHomePage() throws Exception {
		implicitewait();
		searchhotels.AddingRequirment(ConfigureProperties.Location);
		implicitewait();
		searchhotels.storeHomePageDetails();
		searchhotels.HomePageserchClick();
		implicitewait();
	}


	@Test(priority = 3)
	public void Validateby_Selecting_The_Recent_Three_Hotel() throws Exception {
		implicitewait();
		recentviewhotel.WaitinhotellistFirstandStoreName();	
        driver.navigate().back();
		implicitewait();
		recentviewhotel.WaitinhotellistSecondandStoreName();
		driver.navigate().back();
		implicitewait();
		recentviewhotel.WaitinhotellistThirdandStoreName();
		recentviewhotel.GotoHomePage();
		implicitewait();
		recentviewhotel.RecentViewHotelNames();
	}
	
	@Test(priority =4 )
	public void Validate_Selected_HotelIn_HomePage_RecentTab()
	{
		
		Assert.assertEquals(recentviewhotel.HomepageFirstHotel, recentviewhotel.SelectedThirdHotelName,
				"Selected First Hotel are not match");
		Assert.assertEquals(recentviewhotel.HomepageSecondHotel, recentviewhotel.SelectedSecondHotelName,
				"Selected First Hotel are not match");
		Assert.assertEquals(recentviewhotel.HomePageThirdHotel, recentviewhotel.SelectedFirstHotelName,
				"Selected First Hotel are not match");		
	}
	
	@AfterClass 
	  public void CloseBrowser()
	  { 
		  driver.quit();
	  }
	

}
