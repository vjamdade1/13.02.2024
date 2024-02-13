package com.traval.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.traval.qa.base.TestBaseGD;
import com.traval.qa.confiq.ConfigureProperties;

public class SearchCar extends TestBaseGD 

{
	public String HomePageLocationCar;
	public String HomePagePicUPDateCar;
	public String HomePageDropOffDateCar;
	public String HomePagePicUPTimeCar;
	public String HomePageDropOffTimeCar;
	
	public String ListPageLocationCar;
	public String ListPagePicUPDateCar;
	public String ListPageDropOffDateCar;
	public String ListPagePicUPTimeCar;
	public String ListPageDropOffTimeCar;
	
	public String CheckOutPageLocationCar;
	public String CheckOutPicUPDateCar;
	public String CheckOutDropOffDateCar;
	public String CheckOutPicUPTimeCar;
	public String CheckOutDropOffTimeCar;
	public String PickupDateandTime;
	public String DropOffDateandTime;
	
	public String SuccessMassageBooking;
	
	
//HomePage car
	@FindBy(xpath = ("//span[normalize-space()='Rental Cars']"))
	WebElement ClickonRentalCar;
	
	@FindBy(xpath =("//input[@id='pickupTypeAhead']"))
	WebElement PicUpAddresCar;
	
	@FindBy(xpath=("//div[@id='suggestResult0']"))
	WebElement PicUpSearchAddressCar;
	
	@FindBy(xpath=("//input[@id='pickupDateForm']"))
	WebElement PicupDateBoxCar ;
	
	
	@FindBy(xpath=("//input[@id='dropoffDateForm']"))
	WebElement DropOffDateBoxCar;
	
	@FindBy(xpath=("//select[@id='pickupTime']"))
	WebElement PicUpTimeCar;
	
	@FindBy(xpath=("//*[@id=\"pickupTime\"]/option[37]"))
	WebElement PicUpTimeCar1;
	
	
	@FindBy(xpath=("//select[@id='dropoffTimeSelect']"))
	WebElement DropOfTimeCar;
	
	@FindBy(xpath=("//span[@id='searchButtonCarText']"))
	WebElement SearhCarButtonCar;
//Listing Page car	
	@FindBy(xpath=("//input[@id='pickupTypeAhead']"))
	WebElement ListpageLocationBoxCar;
	
	@FindBy(xpath=("//input[@id='pickupDateForm']"))
	WebElement ListpagePickUpDateBoxCar;
	
	@FindBy(xpath=("//select[@id='pickupTime']"))
	WebElement ListpagePickUpTimeBoxCar;
	
	@FindBy(xpath=("//input[@id='dropoffDateForm']"))
	WebElement ListpageDropOffDateBoxCar;
	
	@FindBy(xpath=("//select[@id='dropoffTimeSelect']"))
	WebElement ListpageDropOffTimeBoxCar;
	
	
//Checkout pageCar
	@FindBy(xpath=("//input[@id='firstName']"))
	WebElement FirstName11;
	
	@FindBy(xpath=("//input[@id='lastName']"))
	WebElement LastName11;
	
	@FindBy(xpath=("//input[@id='emailAddress']"))
	WebElement EmailID11;
	
	@FindBy(xpath=("//input[@id='phoneNumber']"))
	WebElement PhoneNo11;
	
	//Payment Details-
	@FindBy(xpath=("//iframe[@title='Secure card payment input frame']"))
	WebElement CardDetails;
	
	@FindBy(xpath=("//input[@id='expirationMonth']"))
	WebElement MonthYear;
	
	@FindBy(xpath=("//*[@id=\"root\"]/form/div/div[2]/span[2]/span[2]/span/span/input"))
	WebElement Cvv;
	
	@FindBy(xpath=("//*[@id=\"root\"]/form/div/div[2]/span[2]/span[3]/span/span/input"))
	WebElement Postalcode;
	
	@FindBy(xpath=("//select[@id='countrySelect']"))
	WebElement Country1;
	
	@FindBy(xpath=("//input[@id='billingAddress1']"))
	WebElement Address1;
	
	@FindBy(xpath=("//input[@id='billingAddress2']"))
	WebElement Address2;
	
	@FindBy(xpath=("//input[@id='billingCity']"))
	WebElement Billingcity;	
	
	@FindBy(xpath=("//*[@id=\"bookbutton\"]"))
	WebElement BookACar;
	
	@FindBy(xpath=("(//div[@class='d-inline-block mr-3'])[1]"))
	WebElement CheckoutPagePickUpLocationCar;
	
	@FindBy(xpath=("//*[@id=\"bookingDetailsContainer\"]/div[1]/div[1]/div[3]"))
	WebElement CheckOutpagePickUpDateandTimeBoxCar;
		
	@FindBy(xpath=("//div[@class='row ml-0 pl-0']//div//div[@class='float-left bookingDetailData']"))
	WebElement CheckOutpageDropOffDateandTimeBoxCar;
	
	public SearchCar() 
	{

		PageFactory.initElements(driver, this);
		// he this keyword can be used to refer current class instance variable.
		
	}
	

	public void addingCarRequirmentForCar() throws Exception 
	{
		Thread.sleep(1000);
		ClickonRentalCar.click();
		Thread.sleep(1000);
		PicUpAddresCar.sendKeys(ConfigureProperties.LocationforCar);
		Thread.sleep(2000);
		PicUpSearchAddressCar.click();
		PicupDateBoxCar.click();
		Thread.sleep(1000);
		PicupDateBoxCar.sendKeys(Keys.ARROW_RIGHT);
		PicupDateBoxCar.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		DropOffDateBoxCar.click();
		Thread.sleep(1000);
		DropOffDateBoxCar.sendKeys(Keys.ARROW_RIGHT);
		DropOffDateBoxCar.sendKeys(Keys.ENTER);
		
		PicUpTimeCar.click();
		Thread.sleep(1000);
		PicUpTimeCar1.click();
		
		
		DropOfTimeCar.click();
		Thread.sleep(1000);
		DropOfTimeCar.sendKeys(Keys.ARROW_UP);
		DropOfTimeCar.sendKeys(Keys.ENTER);
			

	}	
	
	public void StoreaddedCarRequirmentHome() throws Exception
	{
		HomePageLocationCar=PicUpAddresCar.getAttribute("value");
		System.out.println("Home Page Address"+"="+HomePageLocationCar);
		HomePagePicUPDateCar=PicupDateBoxCar.getAttribute("value");
		System.out.println("Home Page Pic Up Date"+"="+HomePagePicUPDateCar);
		HomePageDropOffDateCar=DropOffDateBoxCar.getAttribute("value");
		System.out.println("Home Page Drop Off Date"+"="+HomePageDropOffDateCar);
		HomePagePicUPTimeCar=PicUpTimeCar.getAttribute("value");
		System.out.println("Home Page Pic Up time"+"="+HomePagePicUPTimeCar);
		HomePageDropOffTimeCar=DropOfTimeCar.getAttribute("value");
		System.out.println("Home Page Drop of time"+"="+HomePageDropOffTimeCar);
		
	} 
	public void ClickOnSearchCar() 
	{
		SearhCarButtonCar.click();
	}
	
	public void StoreListingPageDetailsCar() 
	{
		//Taken From Hidden location
		ListPageLocationCar=ListpageLocationBoxCar.getAttribute("value");
		System.out.println("Listing Page Location"+"="+ListPageLocationCar);
		ListPagePicUPDateCar=ListpagePickUpDateBoxCar.getAttribute("value");
		System.out.println("Listing Page Pic Up date"+"="+ListPagePicUPDateCar);
		ListPageDropOffDateCar=ListpageDropOffDateBoxCar.getAttribute("value");	
		System.out.println("Listing Page Drop off date"+"="+ListPageDropOffDateCar);
		ListPagePicUPTimeCar=ListpagePickUpTimeBoxCar.getAttribute("value");
		System.out.println("Listing Page Pic Up time"+"="+ListPagePicUPTimeCar);
		ListPageDropOffTimeCar=ListpageDropOffTimeBoxCar.getAttribute("value");
		System.out.println("Listing Page Drop of time"+"="+ListPageDropOffTimeCar);
	}
	
	public void waitToLoadFirstCarResult() 
	{
		WebDriverWait wait35 = new WebDriverWait(driver, Duration.ofSeconds(30));
		// Wait for an element to be present and invisible
		WebElement loadingImage35 = driver.findElement(By.xpath("//img[@alt='loading image']"));
		wait35.until(ExpectedConditions.invisibilityOf(loadingImage35));
	}
	
	public void ClickonFirstcar() 
	{
		driver.findElement(By.xpath("(//div[@class='row ml-0'])[1]")).click();
	}
	
	public void EnterDetailsinCheckOutPage() throws Exception 
	{
		FirstName11.sendKeys(ConfigureProperties.firstName1);	
		LastName11.sendKeys(ConfigureProperties.LastName1);
		EmailID11.sendKeys(ConfigureProperties.EmailID1);
		PhoneNo11.sendKeys(ConfigureProperties.Phone_Number1);
        CardDetails.sendKeys(ConfigureProperties.Credit_Card_Number2);
        Thread.sleep(1000);
        CardDetails.sendKeys(Keys.TAB);
        CardDetails.click();
        CardDetails.sendKeys(ConfigureProperties.MonthYear1);
        Thread.sleep(1000);
        CardDetails.sendKeys(Keys.TAB);
        CardDetails.click();
        CardDetails.sendKeys(ConfigureProperties.Security_Code1);
        Thread.sleep(1000);
        CardDetails.sendKeys(Keys.TAB);
        CardDetails.click();
        CardDetails.sendKeys(ConfigureProperties.Postal_Code1);
		Country1.click();
		Country1.sendKeys(Keys.ARROW_DOWN);
		Country1.sendKeys(Keys.ENTER);
		Address1.sendKeys(ConfigureProperties.Address_11);
		Address2.sendKeys(ConfigureProperties.Address_22);
		Billingcity.sendKeys(ConfigureProperties.City1);	
	}
	
	public void StoreDetailsOfCheckoutPage() 
	{
		CheckOutPageLocationCar=driver.findElement(By.xpath("//*[@id=\"bkHotelDetailsContainer d-flex\"]/div[2]/div/div[2]/div[1]")).getText();
		System.out.println(CheckOutPageLocationCar);
		PickupDateandTime= CheckOutpagePickUpDateandTimeBoxCar.getText();;
		System.out.println("Pick UP Details is "+"="+PickupDateandTime);
		String inputString12 =PickupDateandTime;
		String[] parts = inputString12.split(" ");
		CheckOutPicUPDateCar = parts[0];
		System.out.println("Checkout Page Pic Up Date"+"="+CheckOutPicUPDateCar);
		CheckOutPicUPTimeCar = parts[1] + " " + parts[2];
		System.out.println("Checkout Page Pic Up Time"+"="+CheckOutPicUPTimeCar);
		 
		DropOffDateandTime=CheckOutpageDropOffDateandTimeBoxCar.getText();;
		System.out.println("Drop Off Details is "+"="+DropOffDateandTime);
		String inputString13 =DropOffDateandTime;
		String[] parts1 = inputString13.split(" ");
		CheckOutDropOffDateCar = parts1[0];
		System.out.println("Checkout Page Drop off Date"+"="+CheckOutDropOffDateCar);
		CheckOutDropOffTimeCar = parts1[1] + " " + parts1[2];
		System.out.println("Checkout Page Drop off Time"+"="+CheckOutDropOffTimeCar);
	}
	
	public void ClickOnBook() 
	{
		
		BookACar.click();
	}
	
	public void WaitUptoCompleteChecking() 
	{
		
		WebDriverWait wait121 = new WebDriverWait(driver, Duration.ofSeconds(60));
		// Wait for an element to be present and invisible
		WebElement loadingImage = driver.findElement(By.id("bookingInProgressModal"));
		wait121.until(ExpectedConditions.invisibilityOf(loadingImage));
	
	}
	
	public void getSucessMassage() 
	{
		SuccessMassageBooking=driver.findElement(By.xpath("//*[@id=\"bodyContainerThin\"]/div[2]")).getText();
		System.out.println(SuccessMassageBooking);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
