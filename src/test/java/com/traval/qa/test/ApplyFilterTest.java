package com.traval.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.traval.qa.base.TestBaseGD;
import com.traval.qa.confiq.ConfigureProperties;
import com.traval.qa.pages.SearchHotels;
@Test
public class ApplyFilterTest extends TestBaseGD
{
	public SearchHotels searchhotels;
	

	public ApplyFilterTest()

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



//To verify by apply filter in edit listing page
	@Test(priority = 3)
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
    
    @Test(priority = 4)
	public void Validate_Hotelpage_booking() throws Exception 
	{
		implicitewait();
		searchhotels.checkrequirmentmatchinhotelPage();
		searchhotels.WaitUntilRateChange();
		// After verify then click on booking
		searchhotels.Bookhotel();
	}


	//Validate by requirements come from Edited listing page
	@Test(priority = 5)
	public void Validate_CheckoutPagerequirment_From_EditedHotelPage() throws Exception {
		implicitewait();
		searchhotels.DetailsRequirmentInCheckoutPage();
		searchhotels.FinaliBookingAddingPersonalDetails();
		searchhotels.FinalBookingClick();
	}
	

	// This is to verify the successful Massage
	@Test(priority = 6)
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
