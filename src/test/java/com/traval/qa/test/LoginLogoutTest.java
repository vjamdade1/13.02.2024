package com.traval.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.traval.qa.base.TestBaseGD;
import com.traval.qa.confiq.ConfigureProperties;
import com.traval.qa.pages.LoginLogoutValidation;
import com.traval.qa.pages.SearchCar;
import com.traval.qa.pages.SearchHotels;
@Test
public class LoginLogoutTest extends TestBaseGD 
{
	public SearchHotels searchhotels;
	public SearchCar searchcar;
	public LoginLogoutValidation loginLogoutvalidation;
	
	
	
	public LoginLogoutTest()

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
	public void Validate_UnsucessfulLogin() throws Exception 
	
	{
		loginLogoutvalidation.AddingUsernameAndWrongPassword();
		loginLogoutvalidation.AfterEnterDetailsLoginClick();
		loginLogoutvalidation.ErrorTextPrint();
		Assert.assertEquals(loginLogoutvalidation.ErrorTextMatch , "Please enter valid email address and password");
		Assert.assertEquals(loginLogoutvalidation.LoginTitle , "Log In: GoDo Travel");
		loginLogoutvalidation.CloseValidationPopUp();
		
	}
	
	@Test(priority =3)
	public void Validate_SucessFullLogin_ClickMultiplePage() throws Exception 
	{
		
		loginLogoutvalidation.AddingUsernameAndCorrectPassword();
		implicitewait();
		loginLogoutvalidation.waitToLoadSucessMassage();
		loginLogoutvalidation.SucessTextPrint();
		Assert.assertEquals(loginLogoutvalidation.SucessTextMatch , "You have successfully logged in");
		loginLogoutvalidation.AfterloginName();
		Assert.assertEquals(loginLogoutvalidation.UserName ,ConfigureProperties.Name );
		loginLogoutvalidation.ClickingMultiplePage();
		Assert.assertEquals(loginLogoutvalidation.UserName ,ConfigureProperties.Name );
		
	}
	
	
	@Test(priority =4)
	public void Validate_AfterClicking_SignOut() throws Exception 
	{
		
	  loginLogoutvalidation.ClickingSignout();
	  Assert.assertEquals(loginLogoutvalidation.SignOutText ,"You have successfully signed out." );
	  loginLogoutvalidation.SignupNameandLoginName();
	  Assert.assertEquals(loginLogoutvalidation.LoginText ,"Log In" );
	  Assert.assertEquals(loginLogoutvalidation.SignUpButtonText ,"Sign Up" );
	  System.out.println("Sign In Sign Out Flow Working Fine");
		
	}

	@AfterClass 
	  public void CloseBrowser()
	  { 
		  driver.quit();
	  }

	
	
	
}

