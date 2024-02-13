package com.traval.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.traval.qa.base.TestBaseGD;
import com.traval.qa.confiq.ConfigureProperties;
import com.traval.qa.pages.SearchHotels;
@Test
public class EditInSearchPageTest extends TestBaseGD
{
	public SearchHotels searchhotels;
	

	public EditInSearchPageTest()

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
	// This is to verify requirement match Edited SearchPage Details and Hotel Page
	// Details or not in book page
	@Test(priority = 5)
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


	//Validate by requirements come from Edited listing page
	@Test(priority = 6)
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
	
	
// This is to verify the successful Massage
	@Test(priority = 7)
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
