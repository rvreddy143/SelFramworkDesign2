package rsacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rsacademy.AbstractComponents.AbstractComponent;

public class LandPage extends AbstractComponent{
	
	WebDriver driver;
	
	public LandPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
//	driver.findElement(By.id("userEmail")).sendKeys("vishnu999@gmail.com");
//	driver.findElement(By.id("userPassword")).sendKeys("Vishnu@999");
//	driver.findElement(By.id("login")).click();
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement submit;
	
	public catPage loginApplication(String Email,String Password)
	{
		userEmail.sendKeys(Email);
		userPassword.sendKeys(Password);
		submit.click();
		catPage CP=new catPage(driver);
		return CP;
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
}
