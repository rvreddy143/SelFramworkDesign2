package rsacademy.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rsacademy.AbstractComponents.AbstractComponent;

public class catPage2 extends AbstractComponent{
	
	WebDriver driver;
	
	public catPage2(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
//	
//	List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));

//	
//	WebElement prod = products.stream().filter(product->
//        product.findElement(By.cssSelector("b")).getText().equals("adidas original")).findFirst().orElse(null);
	
	By productsBy=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	

	
	public List<WebElement> getProductList() throws InterruptedException
	{
		waitforElementtoAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName) throws InterruptedException
	{
		WebElement prod = getProductList().stream().filter(product->
        product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod=getProductByName(productName);
		prod.findElement(addToCart).click();
		waitforElementtoAppear(toastMessage);
		waitforElementToDisapper(spinner);
		
	}
	
	

}
