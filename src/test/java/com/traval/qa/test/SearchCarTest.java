package com.traval.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.traval.qa.base.TestBaseGD;
import com.traval.qa.pages.SearchCar;
import com.traval.qa.pages.SearchHotels;
@Test
public class SearchCarTest extends TestBaseGD
{
	public SearchHotels searchhotels;
	public SearchCar searchcar;
	
	public SearchCarTest()

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
	}
	@Test(priority = 1)
	public void Validate_HomePage_ForCar() throws Exception 
	{
		String Title = searchhotels.ValidateHomeTitle();
		Assert.assertEquals(Title, "GoDo Travel - Get up to 30% cash back after you check out");
		searchhotels.acceptpolicy();
		searchhotels.policybuttonclick();
		System.out.println(Title);
	
	}
	@Test(priority = 2)
	public void adding_Car_Requirment_In_HomePage() throws Exception 
	{
		searchcar.addingCarRequirmentForCar();
		implicitewait();
		searchcar.StoreaddedCarRequirmentHome();
		searchcar.ClickOnSearchCar();
	}
	@Test(priority = 3)
	public void Matching_Requirment_inListingPage_With_HomePageCar() 
	{
		searchcar.StoreListingPageDetailsCar();
		searchcar.waitToLoadFirstCarResult();
		//Assert.assertEquals(searchcar.HomePageLocationCar, searchcar.ListPageLocationCar,"Location not Match");
		Assert.assertEquals(searchcar.HomePagePicUPDateCar, searchcar.ListPagePicUPDateCar,"PickUp date not Match");
		Assert.assertEquals(searchcar.HomePageDropOffDateCar, searchcar.ListPageDropOffDateCar,"Drop off Date not Match");
		Assert.assertEquals(searchcar.HomePagePicUPTimeCar, searchcar.ListPagePicUPTimeCar,"PickUp Time not Match");
		Assert.assertEquals(searchcar.HomePageDropOffTimeCar, searchcar.ListPageDropOffTimeCar,"PickUp date not Match");
		searchcar.ClickonFirstcar();
	}
	@Test(priority = 4)
	public void Matching_Requirment_InCheckoutPage_With_HomePageCar() throws Exception 
	{
	searchcar.StoreDetailsOfCheckoutPage();
	//Assert.assertEquals(searchcar.HomePageLocationCar, searchcar.CheckOutPageLocationCar,"Location not Match");
	Assert.assertEquals(searchcar.HomePagePicUPDateCar, searchcar.CheckOutPicUPDateCar,"PickUp date not Match");
	Assert.assertEquals(searchcar.HomePageDropOffDateCar, searchcar.CheckOutDropOffDateCar,"Drop off Date not Match");
	Assert.assertEquals(searchcar.HomePagePicUPTimeCar, searchcar.CheckOutPicUPTimeCar,"PickUp Time not Match");
	Assert.assertEquals(searchcar.HomePageDropOffTimeCar, searchcar.CheckOutDropOffTimeCar,"PickUp date not Match");
	searchcar.EnterDetailsinCheckOutPage();
	searchcar.ClickOnBook();
	
	}
	@Test(priority = 5)
	public void Matching_SucessFul_Massage() 
	{
		searchcar.WaitUptoCompleteChecking();
		searchcar.getSucessMassage();
		Assert.assertEquals(searchcar.SuccessMassageBooking, "Success! Booking has been completed");
		
	} 
	  @AfterClass public void CloseBrowser()
	  { 
		  driver.quit();
		  
	  }
}
