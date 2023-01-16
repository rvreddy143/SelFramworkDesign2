package rsacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rsacademy.AbstractComponents.AbstractComponent;

public class cartPage extends AbstractComponent {

	@FindBy(css=".cartSection h3")
	List<WebElement> cartproducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkOut;

	WebDriver driver;
	public cartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean verifyProductDisplay(String productName)
	{
		Boolean match=cartproducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		return match;
				
	}
	
	public CheckOutPage goToCheckout()
	{
		checkOut.click();
		return new CheckOutPage(driver);
	}
	
//	List<WebElement> cartproducts=driver.findElements(By.cssSelector(".cartSection h3"));
//	Boolean match=cartproducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase("adidas original"));
//	Assert.assertTrue(match);
//	driver.findElement(By.cssSelector(".totalRow button")).click();

}
