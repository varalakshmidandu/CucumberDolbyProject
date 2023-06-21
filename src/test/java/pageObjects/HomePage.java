package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{

	public HomePage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	// for elements
	//@FindBy(xpath="//a[@href='https://dashboard.staging.dolbyio.com/signup/']") WebElement btnsignup;
	
	@FindBy(xpath="//a[@href='https://dashboard.staging.dolbyio.com/signup/']//span") WebElement btnsignup;
	@FindBy(xpath="//button[@id='emailOption']")WebElement btnSignUpEmail;
	
	
	//Action Methods
	public void clickSignUp() 
	{
		btnsignup.click();
		
		 String actualPage = driver.findElement(By.xpath("//h1[normalize-space()='Create an account']")).getText(); 
		 String expectedPage = "Create an account";
		 
		  if(actualPage.equals(expectedPage)) {
		  System.out.println("User is on Registration page"); } else {
		  System.out.println("page not displayed");
		  } 
	}
	
	public void clickSignUp_Email()
	{
		btnSignUpEmail.click();
	}
	
	
}
