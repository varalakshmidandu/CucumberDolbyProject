package pageObjects;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreationPage extends BasePage {
	
public AccountCreationPage(WebDriver driver)
{
	super(driver);
}

//for elements

@FindBy(xpath="//a[@href='https://dashboard.staging.dolbyio.com/signup/']//span]")
WebElement btnsignup;

@FindBy(xpath="//button[@id='emailOption']")
WebElement btnSignUpEmail;

@FindBy(xpath = "//input[@id='firstName']")
WebElement txtfirstName;

@FindBy(xpath = "//input[@id='lastName']")
WebElement txtlastName;

@FindBy(xpath = "//input[@id='email']")
WebElement txtEmail;

@FindBy(xpath = "//input[@id='password']")
WebElement txtpassword;

@FindBy(xpath = "//input[@id='password-confirm']")
WebElement txtconfirmPassword;

@FindBy(xpath = "//div[@class='contact-form-checkbox']")
WebElement chkConfirmbox;

@FindBy(xpath= "//*[@id=\"kc-register-form\"]/div[5]/div/div/div/iframe")
WebElement chkcaptchabox; //captcha box

@FindBy(xpath= "//input[@class='btn']") WebElement btncreateAccount;




@FindBy(css = "input[type='checkbox']") WebElement
 checkbox_Element; //For terms and condition check box



//For Action Methods

public void clickSignUp() throws InterruptedException 
{
	btnsignup.click();
	Thread.sleep(2000);
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

public void enterfirstName(String fName) {
    txtfirstName.sendKeys(fName);
}

public void enterlastName(String lName) {

    txtlastName.sendKeys(lName);
}
public void validate_EmailId(String email) {
	
	txtEmail.sendKeys(email);
}


public boolean passwordvalidate(String passd) { 
String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).(?=.*[@#$%^+=]).{8,20}$";
Pattern p = Pattern.compile(regex);
Matcher m = p.matcher(passd);
txtpassword.sendKeys(passd);
System.out.println("Valid Password");

return m.matches();
}
	    	
public void confirmPassword(String confirmPwd)
{
	WebElement confirmError = driver.findElement(By.xpath("//span[@id='password-confirm-error']"));
	String password_Elementfiled = txtpassword.getText();
	String confirm_Password = txtconfirmPassword.getText();
	if (password_Elementfiled.equals(confirm_Password))
	{
	txtconfirmPassword.sendKeys(confirmPwd);
	System.out.println("Password Match");
	} 
	else {
	confirmError.getText();
	System.out.println("Password doesnot match");
	}
	//txtconfirmPassword.sendKeys(confirmPwd);
}

public void clickAccountcreateButton()
{

    btncreateAccount.click();
}

//For Captcha box
public void validate_Captcha_Chechbox() {
    // driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"kc-register-form\"]/div[5]/div/div/div/iframe")));
    driver.switchTo().frame(chkcaptchabox);
    WebElement checkele = driver.findElement(By.id("recaptcha-anchor"));
    checkele.click();
   // System.out.println("Captcha check box is selected");

    driver.switchTo().defaultContent();
}

//For Terms & condition checkbox
public void terms_conditionBox()
{
	//WebElement termsElement = driver.findElement(By.xpath("//input[@id='terms_and_conditions']"));
	driver.switchTo().frame(0);
	WebElement termsElement = driver.findElement(By.xpath("//input[@id='terms_and_conditions']"));
	   termsElement.click();
	  driver.switchTo().defaultContent();
	
}

//for terms & condition check box
	  public void terms_and_condition_checkbox()
	 { 
		  JavascriptExecutor jse = (JavascriptExecutor) driver;
	 jse.executeScript("arguments[0].click();", checkbox_Element); 
	 boolean b = checkbox_Element.isSelected();
	 if (!b)
	 {
	 System.out.println("Checkbox is not checked"); 
	 }
	 else {
	  System.out.println("Checkbox is checked"); 
	  }
	 }

//Reusable methods

public String randomeNumber()
{
	String generatedString=RandomStringUtils.randomNumeric(99);
	return generatedString;
}

public  int generateRandomNumber(int boundaryNum)
{
    Random r=new Random();
    return r.nextInt(boundaryNum);
}
}
