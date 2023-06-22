package stepDefinitions;

import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountCreationPage;

import pageObjects.HomePage;
import testBase.BaseClass;

public class Steps{
	 WebDriver driver;
     HomePage hp;// = new HomePage(driver);
     AccountCreationPage acp;// = new AccountCreationPage(driver);
	
     Logger logger; //for logging
     ResourceBundle rb; // for reading properties file
     String br; //to store browser name


     @Before // we called as Hook, it will executes only once before starting test methods
     public void setup()    
     {
         //for logging
         logger= LogManager.getLogger(this.getClass());
         
         //Reading config.properties (for browser)
         rb=ResourceBundle.getBundle("config");
         br=rb.getString("browser");
      
     }
     
     @After 
     public void tearDown(Scenario scenario) {
         System.out.println("Scenario status ======>"+scenario.getStatus());
         if(scenario.isFailed()) {
         	
         	TakesScreenshot ts=(TakesScreenshot) driver;
         	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
         	scenario.attach(screenshot, "image/png",scenario.getName());
         	            
         }
        driver.quit();
     }
     
	@Given("User launch browser")
	public void user_launch_browser() {
		 if(br.equals("chrome"))
	     {
	        driver=new ChromeDriver();
	     }
	     else if (br.equals("firefox")) {
	         driver = new FirefoxDriver();
	     }
	     else if (br.equals("edge")) {
	         driver = new EdgeDriver();
	     }
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@And("Opens URL {string}")
	public void opens_url(String url) {
	    driver.get(url);
	    driver.manage().window().maximize();
	}

	
	@And("user hits on SignUp and Navigate to signupwith email")
	public void user_hits_on_sign_up_and_navigate_to_signupwith_email() throws InterruptedException {
		hp=new HomePage(driver);
		Thread.sleep(2000);
	   hp.clickSignUp();
	}

	@When("user hits on SignUpwithEmail")
	public void user_hits_on_sign_upwith_email() {
		hp=new HomePage(driver);
	   hp.clickSignUp_Email();
	}

	@When("user enters firstname as {string} lastname as {string} email as {string} password as {string} and confirmpassword as {string}")
	public void user_enters_firstname_as_lastname_as_email_as_password_as_and_confirmpassword_as(String fname, String lname, String email, String pwd, String cpwd) {
		
		acp = new AccountCreationPage(driver);
		String randomString1 = "Spari"; 
		String randomString2 = "randomstring";
		    String randomString3 = "@dolby.com";
		  
		    String randomStringResult = randomString1 + "+" + randomString2 +
		    acp.generateRandomNumber(21) + randomString3;
		  
		    email = randomStringResult;
		
		acp.enterfirstName(fname);
	    acp.enterlastName(lname);
	    acp.validate_EmailId(email);
	    acp.passwordvalidate(pwd);
	    acp.confirmPassword(cpwd);
	}

	@And("user select terms and conditions checkbox")
	public void user_select_terms_and_conditions_checkbox() {
	    acp = new AccountCreationPage(driver);
		acp.terms_and_condition_checkbox();
	}

	@And("user select Captcha check box")
	public void user_select_captcha_check_box() throws InterruptedException {
		 acp = new AccountCreationPage(driver);
		 Thread.sleep(2000);
	   acp.validate_Captcha_Chechbox();
	}

	@And("user hits on submit")
	public void user_hits_on_submit() throws InterruptedException {
		// acp = new AccountCreationPage(driver);
		Thread.sleep(2000);
	    acp.clickAccountcreateButton();
	}
	

@Then("user is able to dashboard page")
public void user_is_able_to_dashboard_page() {
    System.out.println("User is on dash board page");
}



}
