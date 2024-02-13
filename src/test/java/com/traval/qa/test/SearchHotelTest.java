package com.traval.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.traval.qa.base.TestBaseGD;
import com.traval.qa.confiq.ConfigureProperties;
import com.traval.qa.pages.SearchHotels;

public class SearchHotelTest extends TestBaseGD
{
	public SearchHotels searchhotels;
	

	public SearchHotelTest()

	{
		super();

		// The 'super' keyword allows referencing the parent class or superclass
	}

//To open the browser and URL
	
	public void setup() throws Exception 
	{

		initialization1();
		searchhotels = new SearchHotels();
	}

//To verify the Title and Accept Policy
	
	public void Validate_HomePage_Title() throws Exception {

		String Title = searchhotels.ValidateHomeTitle();
		Assert.assertEquals(Title, "GoDo Travel - Get up to 30% cash back after you check out");
		searchhotels.acceptpolicy();
		searchhotels.policybuttonclick();
		System.out.println(Title);
	}

//To validate by adding requirement and store the entered details
	
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

//To verify and Edit the details in Listing Page

	public void Edit_Requirments_InListingPage() throws Exception {
		implicitewait();
		searchhotels.StoreListingPagesDetails();
		// Matching Location,Date,Adult and Child
		 Assert.assertEquals(searchhotels.HomePageLocation, searchhotels.HomePageLocation,"Location not Match");
		
		searchhotels.EditListingPagesLocation();
		Assert.assertEquals(searchhotels.HomePageDate, searchhotels.SearchpageDate, "Date are not match");
		searchhotels.EditListingPagesDate();

		Assert.assertEquals(searchhotels.HomePageAdultcount, searchhotels.SearchpageAdults,
				"Adult count are not match");
		searchhotels.EditListingPagesAdult();

		Assert.assertEquals(searchhotels.HomePageChildcount, searchhotels.SearchpageChild, "Child count are not match");
		searchhotels.EditListingPagesChild();

		// After Edit and click on search
		searchhotels.ClickOnSearchListingpage();
		implicitewait();

		// After verify then click on hotel
		searchhotels.Waitinhotellist();
		searchhotels.ClickOnResultHotel();
	}
//To verify by apply filter in edit listing page
	
	public void verify_Multiple_Filter_ListingPage() throws Exception 
	{
//Verify Price filter 
		implicitewait();
		searchhotels.StoreListingPagesDetails();
		implicitewait();
		searchhotels.AddPriceFilterLocation();
		searchhotels.ClickOnSearchListingpage();
		searchhotels.Waitinhotellist();
		implicitewait();
		searchhotels.selectPriceRange100();
		searchhotels.WaitinhotellistFirst();
		implicitewait();
		searchhotels.selectPriceRange150();
		searchhotels.WaitinhotellistFirst();
		searchhotels.StoreHotelPrice();
		implicitewait();
		Double Actualprice=searchhotels.Hotelprice;
		Double Minprice=searchhotels.MinHotelprice;
		Double Maxprice=searchhotels.MaxHotelprice;
		//To check the price
		 Assert.assertTrue(isValueInRange(Actualprice, Minprice, Maxprice),
	              "The result does not fall within the expected range (100-150).");
//To verify Amneties
		//To verify by Pet Friendly
		 implicitewait();
		 searchhotels.AddAmnetiesFilterLocation1();
		 searchhotels.ClickOnSearchListingpage();
		 searchhotels.Waitinhotellist();
		 searchhotels.ClikingOnPetFriendly();
		 searchhotels.WaitinhotellistFirst();
		 implicitewait();
		 searchhotels.StoreThePetAmnetiesinHotel();
		 Assert.assertEquals(searchhotels.DetailsofAmnetiesPets, "pet friendly");
		 System.out.println("Pet Frendly Amneties are  matched");
		//To verify by pool
		 implicitewait();
		 searchhotels.AddAmnetiesFilterLocation1();
		 searchhotels.ClickOnSearchListingpage();
		 searchhotels.Waitinhotellist();
		 searchhotels.ClikingOnPool();
		 searchhotels.WaitinhotellistFirst();
		 implicitewait();
		 searchhotels.StoreThePoolAmnetiesinHotel();
		 Assert.assertEquals(searchhotels.DetailsofAmnetiesPool, "pool");
		 System.out.println("Pool Amneties are  matched");
//To Verify By Stars-
		 implicitewait();
		 searchhotels.AddStarsFilterLocation1();
		 searchhotels.ClickOnSearchListingpage();
		 searchhotels.Waitinhotellist();
		 searchhotels.ClickOn3Star();
		 searchhotels.WaitinhotellistFirst();
		 searchhotels.starDetailsinHotel();
		 int Requredstars= 3;
		 Assert.assertEquals(Requredstars,searchhotels.ActualStars, "Required stars do not match"); 

//To verify distance
		 implicitewait();
		 searchhotels.AddDistanceFilterLocation1();
		 searchhotels.ClickOnSearchListingpage();
		 searchhotels.Waitinhotellist();
		 searchhotels.selectDistanceRange2();
		 searchhotels.WaitinhotellistFirst();
		 searchhotels.selectDistanceRange3();
		 searchhotels.StoreHotelDistance();
		 Double ActualDistance=searchhotels.HotelDistance; 
		 Double MinDistance=2.00; 
		 Double MaxDistance=3.00; 
		 //To check the price
		 Assert.assertTrue(isDistanceInRange(ActualDistance, MinDistance,
			  MaxDistance), "The result does not fall within the expected range (2-3).");
		//If all filter work proper then Click on first Hotel
		 searchhotels.ClickOnResultHotel();
	 }

    private boolean isValueInRange(double Actualprice, double Minprice, double Maxprice) 
    {
        return Actualprice >= Minprice && Actualprice <= Maxprice;
        
    }
    private boolean isDistanceInRange(double ActualDistance, double MinDistance, double MaxDistance) 
    {
        return ActualDistance >= MinDistance && ActualDistance <= MaxDistance;
        
    }	

//This is to verify the details Match with Home Page and Hotel Page
	

// This is to verify requirement match SearchPage Details and Hotel Page Details or not in book page

	public void Validate_Hotelpage_bycheckingrequirment_FromListingPage() throws Exception
	{
		implicitewait();
		searchhotels.checkrequirmentmatchinhotelPage();
		searchhotels.WaitUntilRateChange();
		implicitewait();
		Assert.assertEquals(searchhotels.SearchpageDate, searchhotels.HotelpageDatedate, "Date are not match");
		Assert.assertEquals(searchhotels.SearchpageChild, searchhotels.HotelPagechild, "Child count are not match");
		Assert.assertEquals(searchhotels.SearchpageAdults, searchhotels.HotelPageadult, "Adult count are not match");
		Assert.assertEquals(searchhotels.SelectedHotelNameInSearchPage, searchhotels.SelectedHotelNameHotelPage,
				"Hotel Names are not match");
		
		// After verify then click on booking
		searchhotels.Bookhotel();

	}

	// This is to verify requirement match Edited SearchPage Details and Hotel Page
	// Details or not in book page
	@Test(priority = 8)
	public void Validate_Hotelpageby_checkingrequirment_From_EditedListingPage() throws Exception
	{
		implicitewait();
		searchhotels.checkrequirmentmatchinhotelPage();
		searchhotels.WaitUntilRateChange();
		implicitewait();
		Assert.assertEquals(searchhotels.EditSearchpageDate, searchhotels.HotelpageDatedate, "Date are not match");
		Assert.assertEquals(searchhotels.EditSearchpageChild, searchhotels.HotelPagechild, "Child count are not match");
		Assert.assertEquals(searchhotels.EditSearchpageAdults, searchhotels.HotelPageadult,
				"Adult count are not match");
		Assert.assertEquals(searchhotels.SelectedHotelNameInSearchPage, searchhotels.SelectedHotelNameHotelPage,
				"Hotel Names are not match");

		// After verify then click on booking
		searchhotels.Bookhotel();

	}

//This is to verify by Hotel page the details from Home page and Edit IN Hotel Page
	
	public void Edit_the_HotelPage_Details_byMatchingDetails_withHomePage() throws Exception

	{
		implicitewait();
		searchhotels.checkrequirmentmatchinhotelPage();
		searchhotels.WaitUntilRateChange();
		Assert.assertEquals(searchhotels.HomePageDate, searchhotels.HotelpageDatedate, "Date are not match");
		Assert.assertEquals(searchhotels.HomePageAdultcount, searchhotels.HotelPageadult, "Adult count are not match");
		Assert.assertEquals(searchhotels.HomePageChildcount, searchhotels.HotelPagechild, "Child count are not match");
		Assert.assertEquals(searchhotels.SelectedHotelNameInSearchPage, searchhotels.SelectedHotelNameHotelPage,
				"Hotel Names are not match");

		searchhotels.EditHotelPagesNewDate();
		searchhotels.WaitUntilRateChange();
		searchhotels.EditHotelPagesNewAdult();
		searchhotels.WaitUntilRateChange();
		searchhotels.EditHotelNewPagesChild();
		searchhotels.WaitUntilRateChange();

		searchhotels.Bookhotel2();

	}

//This is to verify By Hotel Page details from Listing page and Edit in Hotel Page
	
	public void Edit_the_HotelPage_Details_byMatchingDetails_withListingPage() throws Exception
	{
		implicitewait();
		searchhotels.checkrequirmentmatchinhotelPage();
		searchhotels.WaitUntilRateChange();
		Assert.assertEquals(searchhotels.SearchpageDate, searchhotels.HotelpageDatedate, "Date are not match");
		Assert.assertEquals(searchhotels.SelectedHotelNameInSearchPage, searchhotels.SelectedHotelNameHotelPage,
				"Hotel Names are not match");
		Assert.assertEquals(searchhotels.SearchpageAdults, searchhotels.HotelPageadult, "Adult count are not match");
		Assert.assertEquals(searchhotels.SearchpageChild, searchhotels.HotelPagechild, "Child count are not match");

		searchhotels.EditHotelPagesNewDate();
		searchhotels.WaitUntilRateChange();
		searchhotels.EditHotelPagesNewAdult();
		searchhotels.WaitUntilRateChange();
		searchhotels.EditHotelNewPagesChild();
		searchhotels.WaitUntilRateChange();

		searchhotels.Bookhotel2();
	}

	// This is to verify by Hotel page details from Edited Listing page and Edit IN
	// Hotel Page
	
	public void Edit_the_Hotel_Details_ByMatchingDetails_with_EditedListingPage() throws Exception
	{
		implicitewait();
		searchhotels.checkrequirmentmatchinhotelPage();
		searchhotels.WaitUntilRateChange();
		Assert.assertEquals(searchhotels.SelectedHotelNameInSearchPage, searchhotels.SelectedHotelNameHotelPage,
				"Hotel Names are not match");
		Assert.assertEquals(searchhotels.EditSearchpageDate, searchhotels.HotelpageDatedate, "Date are not match");
		Assert.assertEquals(searchhotels.EditSearchpageAdults, searchhotels.HotelPageadult,
				"Adult count are not match");
		Assert.assertEquals(searchhotels.EditSearchpageChild, searchhotels.HotelPagechild, "Child count are not match");
		searchhotels.EditHotelPagesNewDate();
		searchhotels.WaitUntilRateChange();

		implicitewait();
		searchhotels.EditHotelPagesNewAdult();
		searchhotels.WaitUntilRateChange();
		implicitewait();
		searchhotels.EditHotelNewPagesChild();
		searchhotels.WaitUntilRateChange();

		searchhotels.Bookhotel2();
	}

// Checkout page
	//Validate by requirements come from home page
	
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
	//Validate by requirements come from Edited listing page
	
	public void Validate_CheckoutPagerequirment_From_EditedLisngPage() throws Exception {
		implicitewait();
		searchhotels.DetailsRequirmentInCheckoutPage();
		implicitewait();
		Assert.assertEquals(searchhotels.EditedCheckInSearch, searchhotels.CheckINpageDatedate, "CheckIn Date are not match");
		Assert.assertEquals(searchhotels.EditedCheckOutSearch, searchhotels.CheckOutpageDatedate, "CheckIn Date are not match");
		Assert.assertEquals(searchhotels.EditSearchpageChildCount, searchhotels.CheckoutPagechild, "Child count are not match");
		Assert.assertEquals(searchhotels.EditSearchpageAdultsCount, searchhotels.CheckoutPageadult,"Adult count are not match");
		
		searchhotels.FinaliBookingAddingPersonalDetails();
		searchhotels.FinalBookingClick();
	}
	
	//Validate by requirements come from Edited listing page
	
	public void Validate_CheckoutPagerequirment_From_EditedHotelPage() throws Exception {
		implicitewait();
		searchhotels.DetailsRequirmentInCheckoutPage();
		implicitewait();
		Assert.assertEquals(searchhotels.EditedCheckInHotel, searchhotels.CheckINpageDatedate, "CheckIn Date are not match");
		Assert.assertEquals(searchhotels.EditedCheckOutHotel, searchhotels.CheckOutpageDatedate, "CheckIn Date are not match");
		Assert.assertEquals(searchhotels.EditHotelPagechildCount, searchhotels.CheckoutPagechild, "Child count are not match");
		Assert.assertEquals(searchhotels.EditHotelPageadultCount, searchhotels.CheckoutPageadult,"Adult count are not match");
		
		searchhotels.FinaliBookingAddingPersonalDetails();
		searchhotels.FinalBookingClick();
	}
	

	// This is to verify the successful Massage
	
	public void SucessFul_MassageConfirmation() 
	{
		implicitewait();
		searchhotels.SucessMassageTitle();
		Assert.assertEquals(searchhotels.SuceesMassage, "Success! Booking has been completed");
	}

	
	  @AfterClass 
	  public void CloseBrowser()
	  { 
		  driver.quit();
	  }
	 

}
