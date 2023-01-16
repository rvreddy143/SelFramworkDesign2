package rsacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rsacademy.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
	
	
WebDriver driver;

public CheckOutPage(WebDriver driver)
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}
@FindBy(css="[placeholder='Select Country']")
WebElement country;

@FindBy(css=".ta-item:nth-of-type(2)")
WebElement selectCountry;

@FindBy(css=".action__submit")
WebElement submit;

By results=By.cssSelector(".ta-results");
//driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
//driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
//driver.findElement(By.cssSelector(".action__submit")).click();

public void selectCountry(String countryName) throws InterruptedException
{
	
	Actions a= new Actions(driver);
	a.sendKeys(country,countryName ).build().perform();
	waitforElementtoAppear(By.cssSelector(".ta-results"));
	selectCountry.click();
	//driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
//	driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
//	driver.findElement(By.cssSelector(".action__submit")).click();
}

public ConfirmationPage submitOrder()
{
	submit.click();
	return new ConfirmationPage(driver);
}


}
