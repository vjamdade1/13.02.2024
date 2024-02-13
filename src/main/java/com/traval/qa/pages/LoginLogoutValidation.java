package com.traval.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.traval.qa.base.TestBaseGD;
import com.traval.qa.confiq.ConfigureProperties;

public class LoginLogoutValidation extends TestBaseGD 
{
	public String LoginText;
	public String SignUpButtonText;
	public String AfterLoginText;
	public String ErrorTextMatch;
	public String LoginTitle;
	public String SucessTextMatch;
	public String UserName;
	public String SignOutText;
	
	
	
	@FindBy(xpath = ("//li[@class='nav-item']//a[@aria-label='login']"))
	WebElement LoginButton;
	
	@FindBy(xpath =("//*[@id=\"navBarContainer\"]/nav/div/span/ul/li[8]/a/span[2]"))
	WebElement SignUpButton;
	
	@FindBy(xpath = ("//input[@id='emailAddress']"))
	WebElement EmailAddressBox;
	
	@FindBy(xpath = ("//input[@id='password']"))
	WebElement PasswordBox;
	
	@FindBy(xpath = ("//button[@id='loginbuttonPrivate']"))
	WebElement LoginButtonPrivate;
	
	@FindBy(xpath =("//*[@id=\"errorText\"]"))
	WebElement ErrorText;
	

	 @FindBy(xpath = ("//div[@id='createAccountErrorModal']"))
	 WebElement SignOutMassage;
	 
	 @FindBy(xpath=("//*[@id=\"createAccountErrorModal\"]/div"))
	 WebElement SucessText;
	 
	 @FindBy(xpath=("//*[@id=\"navBarContainer\"]/nav/div/span/ul/li[10]/a"))
	 WebElement AfterLoginName;
	 
	 @FindBy(xpath=("//a[@href='/MyBookings']"))
	 WebElement MyBookingButton;
	 
	 @FindBy(xpath=("(//a[@aria-label='my account'])[1]"))
	 WebElement MyAccount;
	 
	 @FindBy(xpath=("(//a[@aria-label='sign out'])[2]"))
	 WebElement SignOutButton;
	 
	 @FindBy(xpath=("//*[@id=\"createAccountErrorModal\"]/div"))
     WebElement SignOutTextMassage;
	 
	 
	 public LoginLogoutValidation() 
		{

			PageFactory.initElements(driver, this);
			// he this keyword can be used to refer current class instance variable.
			
		}
	 
	 public void AddingUsernameAndWrongPassword() throws Exception 
	 {
		 Thread.sleep(1000);
		 LoginButton.click();
		 Thread.sleep(1000);
		 EmailAddressBox.sendKeys(ConfigureProperties.Username);
		 Thread.sleep(1000);
		 PasswordBox.sendKeys(ConfigureProperties.WrongPassword);
		 Thread.sleep(1000);
		 LoginButtonPrivate.click();		 
	 }
	 
	 public void AfterEnterDetailsLoginClick() throws Exception 
	 {
		 
		 LoginButtonPrivate.click();
		 Thread.sleep(1000);
		 LoginTitle= driver.getTitle();
		 System.out.println(LoginTitle );
		 
	 }
	 
	 public void CloseValidationPopUp() 
	 {
		 WebDriverWait Wait25= new WebDriverWait(driver,Duration.ofSeconds(20));
		 WebElement ClosePopUp= driver.findElement(By.xpath("//span[@aria-hidden='true']"));
		 Wait25.until(ExpectedConditions.visibilityOf(ClosePopUp));
		 ClosePopUp.click();
		 
	 }
	 
	 public void ErrorTextPrint() 
	 {
		 ErrorTextMatch= ErrorText.getText();
		 System.out.println("Error Text Is" +"="+ErrorTextMatch );
		 
		 
	 }
	 
	 public void AddingUsernameAndCorrectPassword() throws Exception 
	 {
		 Thread.sleep(1000);
		 Thread.sleep(1000);
		 EmailAddressBox.clear();
		 EmailAddressBox.sendKeys(ConfigureProperties.Username);
		
		 Thread.sleep(1000);
		 PasswordBox.clear();
		 PasswordBox.sendKeys(ConfigureProperties.OriginalPassword);
		 Thread.sleep(1000);
		 LoginButtonPrivate.click();
		 Thread.sleep(1000);
	 }
	 
	 public void waitToLoadSucessMassage() 
		{
			WebDriverWait wait36 = new WebDriverWait(driver, Duration.ofSeconds(30));
			// Wait for an element to be present and invisible
			WebElement loadingImage36 = SucessText;
			wait36.until(ExpectedConditions.visibilityOf(loadingImage36));
		}
	 public void SucessTextPrint() 
	 {
		 SucessTextMatch= SucessText.getText();
		 System.out.println("Sucess Text Is" +"="+SucessTextMatch );
		
		 
	 }
	 
	 public void AfterloginName() 
	 {
		 UserName=AfterLoginName.getText();
		 System.out.println("After login name is"+"="+UserName); 
		 
	 }
	 
	 public void ClickingMultiplePage() throws Exception
	 {
		 MyBookingButton.click();
		 Thread.sleep(2000);
		 MyAccount.click();
		 Thread.sleep(1000);
		 
	 }
	 
	 public void ClickingSignout() throws Exception 
	 {
		 SignOutButton.click();
		 Thread.sleep(1000);
		 SignOutText=SignOutTextMassage.getText();
		 System.out.println("Sign Out Massage "+"="+SignOutText);
		 
		 
	 }
	 
	 public void SignupNameandLoginName() 
	 {
		 
		 String Login= LoginButton.getText();
		 String inputString = Login;
	     int indexOfParenthesis = inputString.indexOf("(");
	     LoginText = inputString.substring(0, indexOfParenthesis).trim();
	     SignUpButtonText=SignUpButton.getText();
	     
	 }
	 
	 
	 
	 
	
	
	
	

	
	
	
	

}
