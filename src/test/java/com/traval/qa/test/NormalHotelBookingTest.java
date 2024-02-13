package com.traval.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.traval.qa.base.TestBaseGD;
import com.traval.qa.confiq.ConfigureProperties;
import com.traval.qa.pages.SearchHotels;
@Test
public class NormalHotelBookingTest extends TestBaseGD
{
	public SearchHotels searchhotels;
	

	public NormalHotelBookingTest()

	{
		super();

		// The 'super' keyword allows referencing the parent class or superclass
	}

//To open the browser and URL
	@BeforeClass
	public void setup() throws Exception 
	{

		initialization1();
		searchhotels = new SearchHotels();
	}

//To verify the Title and Accept Policy
	@Test(priority = 1)
	public void Validate_HomePage_Title() throws Exception {

		String Title = searchhotels.ValidateHomeTitle();
		Assert.assertEquals(Title, "GoDo Travel - Get up to 30% cash back after you check out");
		searchhotels.acceptpolicy();
		searchhotels.policybuttonclick();
		System.out.println(Title);
	}

//To validate by adding requirement and store the entered details
	@Test(priority = 2)
	public void ValidataBy_AddingRequirment_InHomePage() throws Exception {
		implicitewait();
		searchhotels.AddingRequirment(ConfigureProperties.Location);
		implicitewait();
		searchhotels.storeHomePageDetails();
		searchhotels.HomePageserchClick();
		implicitewait();
	}

//This is created to load listing page
	// This is to verify the HomePage Details and Search Page Details
	@Test(priority = 3)
	public void Validateby_Requirments_Matchingin_ListingPage_FromHomePage() throws Exception {
		implicitewait();
		searchhotels.StoreListingPagesDetails();
		// Matching Location,Date,Adult and Child
		implicitewait();
		Assert.assertEquals(searchhotels.SearchpageLocation, searchhotels.HomePageLocation,"Location not Match");
		Assert.assertEquals(searchhotels.HomePageDate, searchhotels.SearchpageDate, "Date are not match");
		Assert.assertEquals(searchhotels.HomePageAdultcount, searchhotels.SearchpageAdults,
				"Adult count are not match");
		Assert.assertEquals(searchhotels.HomePageChildcount, searchhotels.SearchpageChild, "Child count are not match");

		// After verify then click on hotel
		searchhotels.Waitinhotellist();
		searchhotels.ClickOnResultHotel();
	}



	
//This is to verify the details Match with Home Page and Hotel Page
	@Test(priority = 6)
	public void Validate_Hotelpage_bycheckingrequirment_FromHomePage() throws Exception 
	{
		implicitewait();
		searchhotels.checkrequirmentmatchinhotelPage();
		searchhotels.WaitUntilRateChange();
		Assert.assertEquals(searchhotels.HomePageDate, searchhotels.HotelpageDatedate, "Date are not match");
		Assert.assertEquals(searchhotels.HomePageAdultcount, searchhotels.HotelPageadult, "Adult count are not match");
		Assert.assertEquals(searchhotels.HomePageChildcount, searchhotels.HotelPagechild, "Child count are not match");
		Assert.assertEquals(searchhotels.SelectedHotelNameInSearchPage, searchhotels.SelectedHotelNameHotelPage,
				"Hotel Names are not match");
		// After verify then click on booking
		searchhotels.Bookhotel();
	}

	@Test(priority = 12)
	public void Validate_CheckoutPagerequirment_From_HomePage() throws Exception {
		implicitewait();
		//searchhotels.ifRateIsChange();
		searchhotels.DetailsRequirmentInCheckoutPage();
		implicitewait();
		Assert.assertEquals(searchhotels.CheckINHome, searchhotels.CheckINpageDatedate, "CheckIn Date are not match");
		Assert.assertEquals(searchhotels.CheckOutHome, searchhotels.CheckOutpageDatedate, "CheckIn Date are not match");
		Assert.assertEquals(searchhotels.ChildcountHome, searchhotels.CheckoutPagechild, "Child count are not match");
		Assert.assertEquals(searchhotels.AdultcountHome, searchhotels.CheckoutPageadult,"Adult count are not match");
		
		searchhotels.FinaliBookingAddingPersonalDetails();
		searchhotels.FinalBookingClick();
	}
		// This is to verify the successful Massage
	@Test(priority = 15)
	public void SucessFul_MassageConfirmation() 
	{
		implicitewait();
		searchhotels.SucessMassageTitle();
		Assert.assertEquals(searchhotels.SuceesMassage, "Success! Booking has been completed");
	}

	
	  @AfterClass public void CloseBrowser()
	  { 
		  driver.quit();
	  }
	 

}
