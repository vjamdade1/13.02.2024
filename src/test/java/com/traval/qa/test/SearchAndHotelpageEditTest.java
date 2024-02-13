package com.traval.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.traval.qa.base.TestBaseGD;
import com.traval.qa.confiq.ConfigureProperties;
import com.traval.qa.pages.SearchHotels;
@Test
public class SearchAndHotelpageEditTest extends TestBaseGD
{
	public SearchHotels searchhotels;
	

	public SearchAndHotelpageEditTest()

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



//To verify and Edit the details in Listing Page
	@Test(priority = 3)
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



	// This is to verify by Hotel page details from Edited Listing page and Edit IN
	// Hotel Page
	@Test(priority = 4)
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


	
	//Validate by requirements come from Edited listing page
	@Test(priority = 5)
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
