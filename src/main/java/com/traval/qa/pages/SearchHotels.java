package com.traval.qa.pages;

import java.time.Duration;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.traval.qa.base.TestBaseGD;
import com.traval.qa.confiq.ConfigureProperties;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchHotels extends TestBaseGD 

{
	
	public String HomePageDate;
	public String CheckINHome;
	public String CheckOutHome;
	public String HomePageLocation;
	public String HomePageAdultcount;
	public String HomePageChildcount;
	public String AdultcountHome;
	public String ChildcountHome;

	public String SearchpageChild;
	public String SearchpageDate;
	public String SearchpageAdults;
	public String SearchpageLocation;
	
	public String EditSearchpageChild;
	public String EditSearchpageChildCount;
	public String EditSearchpageDate;
	public String EditedCheckInSearch;
	public String EditedCheckOutSearch;
	public String EditSearchpageAdults;
	public String EditSearchpageAdultsCount;
	public String EditSearchpageLocation;
	public String SelectedHotelNameInSearchPage;
	public String SelectedHotelPriceInSearchPage;
	public double Hotelprice;
	public double MinHotelprice;
	public double MaxHotelprice;
	public String EditSearchpageLocationAmneties;
	public String EditSearchpageLocationDistance;
	public String EditSearchpageLocationStars;
	public String EditSearchpageLocationPrice;
	public String DetailsofAmnetiesPets;
	public String DetailsofAmnetiesPool;
	public String Hotelstardetails;
	public int ActualStars;
	public String SelectedHotelDistanceInSearchPage;
	public double HotelDistance;
	
	public String HotelPageadult;
	public String HotelPagechild;
	public String HotelpageDatedate;
	public String HotelpageLocation;
	public String SelectedHotelNameHotelPage;
	
	public String EditHotelPageadult;
	public String EditHotelPageadultCount;
	public String EditHotelPagechild;
	public String EditHotelPagechildCount;
	public String EditHotelpageDatedate;
	public String EditedCheckInHotel;
	public String EditedCheckOutHotel;
	public String EditHotelpageLocation;
	public String EditChilpageAgeSecond;
	

	public String CheckoutPageadult;
	public String CheckoutPagechild;
	public String CheckINpageDatedate;
	public String CheckOutpageDatedate;
	
	
	public String SuceesMassage;

	@FindBy(xpath = ("//div[@class='cky-consent-bar']"))
	WebElement policy;

	@FindBy(xpath = ("//button[@data-cky-tag=\"accept-button\"]"))
	WebElement Acceptpolicybutton;

	// To Enter Address
	@FindBy(xpath = ("//input[@id='cityTypeAhead']"))
	
	WebElement EnterAddress;

//To Enter searched result address
	@FindBy(xpath = ("//div[@id='suggestResult1']"))
	WebElement EntersearcheResult;

//To open the date calendar
	@FindBy(id = ("checkinForm"))
	WebElement EnterDate;

//To Enter first date
	
	@FindBy(xpath = ("(//td[contains(text(),'19')])[1]"))
	WebElement EnterFirstDate;

//To Enter second date
	@FindBy(xpath = ("(//td[contains(text(),'22')])[1]"))
	WebElement EnterSecondDate;

//To increase Adult first count
	@FindBy(xpath = ("//div[@id='numAdultsPlus']//i[@role='presentation']"))
	WebElement PlusAdultcount;

//To increase Child count
	@FindBy(xpath = ("//div[@id='numChildrenPlus']//i[@role='presentation']"))
	WebElement PlusChildcount;

//Click on search in home page
	@FindBy(xpath = ("//span[@id='searchButtonText']"))
	WebElement SearchBtn;

//Click on search in listing page
	@FindBy(xpath=("//div[@id='searchButtonText']"))
	WebElement SearchBtninListing;
		
	
//Click book first hotel in searched
	@FindBy(xpath = ("//*[@data-rank=\"0\"]"))
    WebElement ClickFirstHotel;

//click on book
	@FindBy(id=("bookButton2"))
	WebElement BookFirstHotel;
	////button[@id='bookButton1']

//Personal Details fields
	@FindBy(xpath = ("//input[@id='firstName']"))
	WebElement FirstName;

	@FindBy(xpath = ("//input[@id='lastName']"))
	WebElement LastName;

	@FindBy(xpath = ("//input[@id='phoneNumber']"))
	WebElement PhoneNumber;

	@FindBy(xpath = ("//input[@id='emailAddress']"))
	WebElement EmailAddress;

//payment page details
	@FindBy(xpath = ("//input[@id='firstNamePayment']"))
	WebElement FirstNamePayment;

	@FindBy(xpath = ("//input[@id='creditCardNumber']"))
	WebElement CreditCardNumber;

	@FindBy(xpath = ("//input[@id='expirationMonth']"))
	WebElement ExpirationMonth;

	@FindBy(xpath = ("//input[@id='expirationYear']"))
	WebElement ExpirationYear;

	@FindBy(xpath = ("//input[@id='securityCode']"))
	WebElement SecurityCode;

//For  billing address details	
	@FindBy(id = ("countrySelect"))
	WebElement countrySelect;

	@FindBy(xpath = ("//*[@id=\"countrySelect\"]/option[2]"))
	WebElement countrySelectfromlist;

	@FindBy(id = ("billingAddress1"))
	WebElement BillingAddress1;

	@FindBy(id = ("billingAddress2"))
	WebElement billingAddress2;

	@FindBy(id = ("billingCity"))
	WebElement billingCity;

	@FindBy(id = ("provinceSelect"))
	WebElement provinceSelect;

	@FindBy(xpath = ("//*[@id=\"provinceSelect\"]/option[3]"))
	WebElement provinceSelectfromlist;

	@FindBy(id = ("postalCode"))
	WebElement PostalCode;

	@FindBy(xpath = ("//*[@id=\"bookbutton\"]"))
	WebElement FinalBookingButton;

	public SearchHotels() 
	{

		PageFactory.initElements(driver, this);
		// he this keyword can be used to refer current class instance variable.
		
	}

	// Actions on page
	public String ValidateHomeTitle() throws Exception

	{

		return driver.getTitle();
	}

	public void acceptpolicy() 
	{
		// https://www.seleniumeasy.com/selenium-tutorials/waits-and-timeout-selenium-4
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for an element to be present and visible privacy policy
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cky-consent-bar']")));
	}
	
	public void policybuttonclick() throws Exception
	{
		Thread.sleep(1000);
		Acceptpolicybutton.click();
	}


	public void AddingRequirment(String ad) throws Exception 
	{
		// Enter the address and store
		EnterAddress.sendKeys(ad);
		Thread.sleep(2000);
		EntersearcheResult.click();
		Thread.sleep(1000);
		
		// Enter the date and store(Commented due to dates issue)
		EnterDate.click();
		Thread.sleep(1000);
		EnterFirstDate.click();
		EnterSecondDate.click();
		
		// Add the adult count and get text
		PlusAdultcount.click();
		Thread.sleep(500);
	
		// Add the child count and get text
		PlusChildcount.click();
			
	}
	public void storeHomePageDetails() throws Exception 
	{
		
 		HomePageDate = driver.findElement(By.xpath("(//input[@id='checkinForm'])[1]")).getAttribute("value");
 		System.out.println("Entered Date" + "=" + HomePageDate);
 		//Taken from Hidden
 		CheckINHome=driver.findElement(By.xpath("//input[@id='checkin']")).getAttribute("Value");
 		System.out.println("Check In Date in HomePage" + "="+CheckINHome);
 		//Taken from Hidden
 		CheckOutHome=driver.findElement(By.xpath("//input[@id='checkout']")).getAttribute("Value");
 		System.out.println("Check Out Date in HomePage" + "="+CheckOutHome);
 		
 		//taken from Hidden
 		HomePageLocation = driver.findElement(By.xpath("//input[@id='locationID']")).getAttribute("value");	
 		System.out.println("Entered Location Id" + "=" + HomePageLocation);
 		
		WebElement textElementadult = driver.findElement(By.xpath("//div[@id='numAdultsDisplay']"));
		HomePageAdultcount = textElementadult.getText();
		Thread.sleep(500);
		String inputString =HomePageAdultcount;
		String[] parts = inputString.split(" ", 2);
		AdultcountHome = parts[0];
		System.out.println("Home page Adult count"+"="+AdultcountHome);
		 Thread.sleep(500);
		System.out.println("Entered Adults count " + "=" + HomePageAdultcount);
		WebElement textElementChild = driver.findElement(By.xpath("//div[@id='numChildrenDisplay']"));
		HomePageChildcount = textElementChild.getText();
		System.out.println("Entered Child count " + "=" + HomePageChildcount);
		Thread.sleep(500);
		String inputString1 =HomePageChildcount;
		String[] parts1 = inputString1.split(" ", 2);
		ChildcountHome = parts1[0];
		System.out.println("Home page Child count"+"="+ChildcountHome);
		
	}
	
     public void HomePageserchClick() 
     {
    	
		// After filling click on search
		SearchBtn.click();
	 }

// This is for Storelisting page only
    public void StoreListingPagesDetails() throws Exception
                 
	{

		Thread.sleep(2000);
		
		// Storedate
		SearchpageDate = driver.findElement(By.xpath("(//input[@id='checkinInput'])[1]")).getAttribute("value");
		System.out.println("Search page date" +"="+SearchpageDate);
		Thread.sleep(1000);
		// Store Location from Hidden
		SearchpageLocation = driver.findElement(By.xpath("//input[@id='locationID']")).getAttribute("value");
		System.out.println("Search Page location Id " +"="+ SearchpageLocation);
		Thread.sleep(1000);
		// storeadult
		SearchpageAdults = driver.findElement(By.xpath("//div[@id='numAdultsDisplay']")).getText();
		System.out.println("Search page Adult" +"="+SearchpageAdults);
		Thread.sleep(500);
		// Storechild
		SearchpageChild = driver.findElement(By.xpath("//div[@id='numChildrenDisplay']")).getText();
		System.out.println("Search page Child" +"="+SearchpageChild);
	}
 //Edit the location
	
	public void EditListingPagesLocation() throws Exception
	{
		driver.findElement(By.xpath("//input[@id='cityTypeAhead']")).clear();
		driver.findElement(By.xpath("//input[@id='cityTypeAhead']")).sendKeys("Florida");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='suggestResult1']")).click();
		EditSearchpageLocation= driver.findElement(By.xpath("//input[@id='cityTypeAhead']")).getAttribute("value");		
	}
//Edit the Date
	public void EditListingPagesDate() throws Exception
	{
		driver.findElement(By.id("checkinInput")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[contains(text(),'26')])[1]")).click();
		driver.findElement(By.xpath("(//td[contains(text(),'28')])[2]")).click();
		Thread.sleep(1000);
		EditSearchpageDate= driver.findElement(By.id("checkinInput")).getAttribute("value");
		EditedCheckInSearch= driver.findElement(By.xpath("//input[@id='checkin']")).getAttribute("Value");
		//System.out.println("Update Check In date in listing Page" + "="+EditedCheckInSearch);
		EditedCheckOutSearch=driver.findElement(By.xpath("//input[@id='checkout']")).getAttribute("Value");
		System.out.println("Update Check Out date in listing Page" + "="+EditedCheckOutSearch);
		
	}
//Edit the adult count	
	public void EditListingPagesAdult() throws Exception
	{
		driver.findElement(By.xpath("//div[@id='numAdultsMinus']//i[@class='bi bi-dash-square']")).click();
		Thread.sleep(1000);
		EditSearchpageAdults= driver.findElement(By.xpath("//div[@id='numAdultsDisplay']")).getText();
		Thread.sleep(500);
		 String inputString4 =EditSearchpageAdults;
		 String[] parts = inputString4.split(" ", 2);
		 EditSearchpageAdultsCount = parts[0];
		 System.out.println("Search(Edited) page Adult count"+"="+EditSearchpageAdultsCount);
		 Thread.sleep(500);
	}
//Edit the Child  count		
	public void EditListingPagesChild() throws Exception
	{
		driver.findElement(By.xpath("//div[@id='numChildrenPlus']//i[@class='bi bi-plus-square']")).click();
		Thread.sleep(1000);
		EditSearchpageChild= driver.findElement(By.xpath("//div[@id='numChildrenDisplay']")).getText();
		Thread.sleep(500);
		String inputString3 =EditSearchpageChild;
		String[] parts = inputString3.split(" ", 2);
		EditSearchpageChildCount = parts[0];
		System.out.println("Search(Edited) page child count"+"="+EditSearchpageChildCount);
		Thread.sleep(500);
		WebElement Age=driver.findElement(By.xpath("//select[@id='childAge2']"));
		Age.click();
		Age.sendKeys(Keys.ARROW_DOWN);
		Age.sendKeys(Keys.ENTER);
		EditChilpageAgeSecond= driver.findElement(By.xpath("//select[@id='childAge2']")).getAttribute("value");
		
	}
//For filter verification this is added-
	//1.Adding new location for Price-
	public void AddPriceFilterLocation() throws Exception 
	{
		driver.findElement(By.xpath("//input[@id='cityTypeAhead']")).clear();
		driver.findElement(By.xpath("//input[@id='cityTypeAhead']")).sendKeys("Dallas");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='suggestResult0']")).click();
		EditSearchpageLocationPrice= driver.findElement(By.xpath("//input[@id='cityTypeAhead']")).getAttribute("value");	
	}
	//1.a.Addit Price Filter 100
	public void selectPriceRange100() throws Exception 
	{
		WebElement slider1 = driver.findElement(By.xpath("(//div[@class='noUi-touch-area'])[1]"));
		Thread.sleep(1000);
		 Actions actions1 = new Actions(driver);
		 actions1.dragAndDropBy(slider1, 80, 0).build().perform();
	     
	}
	//1.b.Addit Price Filter 150
		public void selectPriceRange150() throws Exception 
		{
			WebElement slider2 = driver.findElement(By.xpath("(//div[@class='noUi-touch-area'])[2]"));
			Thread.sleep(1000);
			 Actions actions2 = new Actions(driver);
			 actions2.dragAndDropBy(slider2, -120, 0).build().perform();
			 Thread.sleep(1000);
		}
		//Store First hotel Price only
		public void StoreHotelPrice() throws InterruptedException
		
	   {
			Thread.sleep(1000);
			MinHotelprice= 100.00;
			MaxHotelprice= 150.00;
			SelectedHotelPriceInSearchPage= driver.findElement(By.xpath("(//div[@class='priceLarge'])[1]")).getText();
			System.out.println("Hotel Price is " +"="+SelectedHotelPriceInSearchPage);
			Thread.sleep(1000);
			 String inputString = SelectedHotelPriceInSearchPage;
			 String numericString = inputString.replaceAll("[^0-9.]", "");
			 Hotelprice = Double.parseDouble(numericString);
	         System.out.println("Extracted Price from list: " + Hotelprice);
			 
		}						
		
//1.Adding new location for Amneties-
		public void AddAmnetiesFilterLocation1() throws Exception 
		{
			driver.findElement(By.xpath("//input[@id='cityTypeAhead']")).clear();
			driver.findElement(By.xpath("//input[@id='cityTypeAhead']")).sendKeys("Austin");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@id='suggestResult0']")).click();
			EditSearchpageLocationAmneties= driver.findElement(By.xpath("//input[@id='cityTypeAhead']")).getAttribute("value");	
		}
	//	To click PetFriendly
		
		public void ClikingOnPetFriendly() throws Exception 
		{
			driver.findElement(By.xpath("//label[@id='petFriendlyLabel']")).click();
			 Thread.sleep(1000);
		}
   // To get the Petfriendly text from Hotel
		public void StoreThePetAmnetiesinHotel() throws Exception 
		{
			DetailsofAmnetiesPets= driver.findElement(By.xpath("(//div[@class='search-tagSelected search-tag-1'])[1]")).getText();
		}
				
   //To click Pool
		public void ClikingOnPool() throws Exception 
		{
			driver.findElement(By.xpath("//label[@id='poolLabel']")).click();
			Thread.sleep(1000);
		}
		
		public void StoreThePoolAmnetiesinHotel() throws Exception 
		{
			DetailsofAmnetiesPool= driver.findElement(By.xpath("(//div[@class='search-tagSelected search-tag-1'])[1]")).getText();
		}
		
////1.Adding new location for Stars-
		public void AddStarsFilterLocation1() throws Exception 
		{
			driver.findElement(By.xpath("//input[@id='cityTypeAhead']")).clear();
			driver.findElement(By.xpath("//input[@id='cityTypeAhead']")).sendKeys("Miami");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@id='suggestResult0']")).click();
			EditSearchpageLocationStars= driver.findElement(By.xpath("//input[@id='cityTypeAhead']")).getAttribute("value");	
		}
	//To click Star
		public void ClickOn3Star() 
		{
			driver.findElement(By.xpath("(//div[@id='star3'])[1]")).click();
		}
		
	//To take details of star
		public void starDetailsinHotel() 
		{
			WebElement container = driver.findElement(By.xpath("(//div[@class='col-12 col-sm-8 pt-2'])[1]"));
	        Collection<WebElement> filledElements = container.findElements(By.className("filled"));
	        // Get the count of filled elements
	        ActualStars = filledElements.size();

	        // Print or use the count as needed
	        System.out.println("Number of elements with class 'filled': " + ActualStars);
			
			
		}
	////1.Adding new location for Distance-
			public void AddDistanceFilterLocation1() throws Exception 
			{
				driver.findElement(By.xpath("//input[@id='cityTypeAhead']")).clear();
				driver.findElement(By.xpath("//input[@id='cityTypeAhead']")).sendKeys("New York");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[@id='suggestResult0']")).click();
				EditSearchpageLocationDistance= driver.findElement(By.xpath("//input[@id='cityTypeAhead']")).getAttribute("value");	
			}
			//1.a.Addit Distance Filter 2
			public void selectDistanceRange2() throws Exception 
			{
				WebElement slider3 = driver.findElement(By.xpath("(//div[@role='slider'])[3]"));
				Thread.sleep(1000);
				 Actions actions3 = new Actions(driver);
				 actions3.dragAndDropBy(slider3, 20, 0).build().perform();
			     
			}
			//1.b.Addit Distance Filter 3
				public void selectDistanceRange3() throws Exception 
				{
					WebElement slider4 = driver.findElement(By.xpath("(//div[@class='noUi-touch-area'])[4]"));
					Thread.sleep(1000);
					 Actions actions4 = new Actions(driver);
					 actions4.dragAndDropBy(slider4, -220, 0).build().perform();
				}
				//Store First hotel Distance only
				public void StoreHotelDistance() throws InterruptedException
				
			   {
					
					 // Locate the container using the provided XPath
			        WebElement container = driver.findElement(By.xpath("(//div[@class='col-12 col-sm-8 pt-2'])[1]"));

			        // Locate the element with specific classes within the container
			        WebElement elementWithClasses = container.findElement(By.xpath("/html[1]/body[1]/div[4]/div[2]/div[2]/div[4]/div[1]/div[2]/div[1]/div[2]/div[2]"));

			        // Get the text content of the element
			        SelectedHotelDistanceInSearchPage = elementWithClasses.getText();

			        // Print or use the extracted text as needed
			        System.out.println("Text content: " + SelectedHotelDistanceInSearchPage);
			        Thread.sleep(1000);
			        String inputString = SelectedHotelDistanceInSearchPage;
			        String numericString =inputString.replaceAll("[^0-9.]", "");
			        HotelDistance = Double.parseDouble(numericString);
			        System.out.println("Extracted Distance from list: " + HotelDistance);
					 
				}		
		
	
	
//After Edit Click on the Search to refresh
	public void ClickOnSearchListingpage() 
	{
		SearchBtninListing.click();
	}
	
//Wait  on First  Hotel and store name by invisible GIF
	public void Waitinhotellist()
	{
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(25));
		// Wait for an element to be present and invisible
		WebElement loadingImage = driver.findElement(By.xpath("(//img[@alt='loading image'])[1]"));
		wait1.until(ExpectedConditions.invisibilityOf(loadingImage));
		//Store Hotel Name-
		SelectedHotelNameInSearchPage=driver.findElement(By.className("srHotelName")).getText();
		
		System.out.println("Selected Hotel Is"+"="+SelectedHotelNameInSearchPage);
	}
//Wait on first Resultcome
	public void WaitinhotellistFirst() 
	{
		WebDriverWait wait23 = new WebDriverWait(driver, Duration.ofSeconds(20));
		// Wait for an element to be present and invisible
		WebElement loadingResult = driver.findElement(By.xpath("//*[@data-rank=\"0\"]"));
		wait23.until(ExpectedConditions.visibilityOf(loadingResult));
		
	}
	
//Click on serched result firsthotel
	
	public void ClickOnResultHotel() 
	{	
		ClickFirstHotel.click();
	}

// This is for Hotel page page only
	public void checkrequirmentmatchinhotelPage() throws Exception

	{
		HotelpageDatedate = driver.findElement(By.xpath("//input[@id='travelDates']")).getAttribute("value");//08.02.204
		System.out.println("Output Date on Hotel book page" + "=" + HotelpageDatedate);
		// StoreAdult
		HotelPageadult = driver.findElement(By.xpath("//div[@id='numAdultsDisplay']")).getText();
		System.out.println("Output Adult on Hotel book page" + "=" + HotelPageadult);
		// StoreChil HotelPagechild=
		HotelPagechild=driver.findElement(By.xpath("//div[@id='numChildrenDisplay']")).getText();
		System.out.println("Output page hotel count " + "=" + HotelPagechild);
		//To Store the Hotel Name-
		SelectedHotelNameHotelPage=driver.findElement(By.xpath("//*[@id=\"sticyHeaderHotelHeadline\"]/h1")).getText();//08.02.2024
		System.out.println("Hotel Page Name is" +"="+SelectedHotelNameHotelPage );
		
	}
// Added wait for image
	public void WaitInHotelPage() throws InterruptedException
	{
		WebDriverWait wait21 = new WebDriverWait(driver, Duration.ofSeconds(20));
		// Wait for an element to be present and visible
		wait21.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt=\"Primary image\"]")));
		
	}
// Added wait for Rate change
	public void WaitUntilRateChange() throws InterruptedException
	{
		//div[@id='targetDiv']
		WebDriverWait wait23 = new WebDriverWait(driver, Duration.ofSeconds(20));
		// Wait for an element to be present and visible
		wait23.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='licencePlacePrice']")));
		
		
	}
//Edit the dates
	public void EditHotelPagesNewDate() throws Exception //need to change
	{
		driver.findElement(By.xpath("//input[@id='travelDates']")).click();//08.02.2024
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[contains(text(),'26')])[1]")).click();
		driver.findElement(By.xpath("(//td[contains(text(),'28')])[2]")).click();
		Thread.sleep(500);
		EditHotelpageDatedate= driver.findElement(By.xpath("//*[@id=\"travelDates\"]")).getAttribute("value");
		System.out.println("Edit hotel page date is "+ EditHotelpageDatedate);
		EditedCheckInHotel= driver.findElement(By.xpath("//input[@id='checkin']")).getAttribute("Value");
		System.out.println("Updated CheckIn date in Hotel Page"+"="+EditedCheckInHotel);
		EditedCheckOutHotel=driver.findElement(By.xpath("//input[@id='checkout']")).getAttribute("Value");
		System.out.println("Updated Check Out date in Hotel Page"+"="+EditedCheckOutHotel);
		
		
	}
//Edit the Adult count
	public void EditHotelPagesNewAdult() throws Exception //need to change
	{
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@id='numAdultsMinus']//i[@class='bi bi-dash-square']")).click();
		Thread.sleep(500);
		EditHotelPageadult= driver.findElement(By.xpath("//div[@id='numAdultsDisplay']")).getText();
		String inputString5 =EditHotelPageadult;
		String[] parts = inputString5.split(" ", 2);
		EditHotelPageadultCount = parts[0];
		System.out.println("Hotel(Edited) page adult count"+"="+EditHotelPageadultCount);
		System.out.println("Edit hotel page Adult is "+ EditHotelPageadult);
	}
//Edit the Child count
	public void EditHotelNewPagesChild() throws Exception // need to change
	{
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@id='numChildrenMinus']//i[@class='bi bi-dash-square']")).click();
		Thread.sleep(500);
		EditHotelPagechild= driver.findElement(By.xpath("//div[@id='numChildrenDisplay']")).getText();
		String inputString6 =EditHotelPagechild;
		String[] parts = inputString6.split(" ", 2);
		EditHotelPagechildCount = parts[0];
		System.out.println("Hotel(Edited) page child count"+"="+EditHotelPagechildCount);	
		System.out.println("Edit hotel page child is "+ EditHotelPagechild);
	}	
		
		
//Click on Book Hotel for normal flow		
	public void Bookhotel() 
	{
		BookFirstHotel.click();
	}
	public void Bookhotel2() 
	{
	
		driver.findElement(By.id("bookButton1")).click();
	}	
	
		
//To verify requirement Match or not in checkout page
	public void ifRateIsChange() 
	
	{
		
	
		 By elementLocator= By.xpath("//*[@id=\"bookButton2\"]");
		 
		 if (isElementPresent(elementLocator)) 
		 {
	            System.out.println("Rate is Changed on the page.");

	            // Perform click action on the element
	            WebElement element = driver.findElement(elementLocator);
	            element.click();

	            // Add additional actions after clicking the element, if needed
	      }
		 else
		 {
	            System.out.println("Element is NOT present on the page. Rate is not changed.");
	    
	     }}
	
		 private boolean isElementPresent(By locator) 
		 {
		        try {
		            driver.findElement(locator);
		            return true; // Element found
		        }
		        catch (org.openqa.selenium.NoSuchElementException e)
		        {
		            return false; // Element not found
		        }
		  }
		 
//To verify requirement Match or not in checkout page
		public void DetailsRequirmentInCheckoutPage() 
		{	
		WebElement Check_In= driver.findElement(By.xpath("(//div)[200]"));//08.02.2024
		CheckINpageDatedate=Check_In.getText();	
		System.out.println("Check In date is "+"="+CheckINpageDatedate);
		
		WebElement Chech_Out=driver.findElement(By.xpath("(//div)[203]"));//08.02.2024
		CheckOutpageDatedate=Chech_Out.getText();
		System.out.println("Check Out date is"+"="+CheckOutpageDatedate);
		
		WebElement Adult_Count= driver.findElement(By.xpath("//*[@id=\"bookingDetailsContainer\"]/div[3]/div[2]"));
		CheckoutPageadult=Adult_Count.getText();
		System.out.println("Adult count is "+"="+CheckoutPageadult);
		
		WebElement Child_Count= driver.findElement(By.xpath("//*[@id=\"bookingDetailsContainer\"]/div[3]/div[4]"));
		CheckoutPagechild=Child_Count.getText();
		System.out.println("Child count is "+"="+CheckoutPagechild);		
	}	

//Fill the Details and Final Booking	
	public void FinaliBookingAddingPersonalDetails() throws Exception
	{
		Thread.sleep(1000);
		FirstName.sendKeys(ConfigureProperties.firstName1);
		LastName.sendKeys(ConfigureProperties.LastName1);
		PhoneNumber.sendKeys(ConfigureProperties.Phone_Number1);
		EmailAddress.sendKeys(ConfigureProperties.EmailID1);
		FirstNamePayment.sendKeys(ConfigureProperties.firstName1);
		CreditCardNumber.sendKeys(ConfigureProperties.Credit_Card_Number1);
		ExpirationMonth.sendKeys(ConfigureProperties.Month1);
		ExpirationYear.sendKeys(ConfigureProperties.Year1);
		SecurityCode.sendKeys(ConfigureProperties.Security_Code1);
		countrySelect.click();
		countrySelectfromlist.click();
		BillingAddress1.sendKeys(ConfigureProperties.Address_11);
		billingAddress2.sendKeys(ConfigureProperties.Address_22);
		billingCity.sendKeys(ConfigureProperties.City1);
		provinceSelect.click();
		provinceSelect.sendKeys(Keys.ARROW_DOWN);
		provinceSelect.sendKeys(Keys.ENTER);
		PostalCode.sendKeys(ConfigureProperties.Postal_Code1);
	}
//For Final Booking
	
		public void FinalBookingClick()
		{
		FinalBookingButton.click();

	    }
//For varification of successful massage		
		public void SucessMassageTitle() 
		{
			SuceesMassage=driver.findElement(By.xpath("//*[@id=\"bodyContainerThin\"]/div[2]/div")).getText();
			System.out.println(SuceesMassage);
			
		}

}
