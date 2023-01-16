package rsacademy.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rsacademy.pageobjects.LandPage;
import rsacademy.pageobjects.catPage;

public class StandaloneTest3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String email="vishnu999@gmail.com";
		String password="Vishnu@999";
		String productName="zara coat 3";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	//	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5)); 
		LandPage landingpage=new LandPage(driver);
		landingpage.goTo();
		landingpage.loginApplication(email, password);
		
	//	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	//Thread.sleep(5000);
		catPage productcatalogue=new catPage(driver);
		List<WebElement> products= productcatalogue.getProductList();
		//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		//products.stream().filter(product->product.getText().equals("zara coat 3"));
		productcatalogue.getProductByName(productName);
		
//  	WebElement prod = products.stream().filter(product->
//	        product.findElement(By.cssSelector("b")).getText().equals("adidas original")).findFirst().orElse(null);
		//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		//or
		//.card-body button:first-of-type
		//.card-body button:last-of-type
		
		driver.findElement(By.xpath("(//div[@class='card-body']/button[2])[2]")).click();
		
		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[routerlink*='/dashboard/cart']")).click();
		
		List<WebElement> cartproducts=driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match=cartproducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase("adidas original"));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		///Using actions as it has static drop down and mandatory to use build & perform at last
		Actions a= new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		Thread.sleep(2000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-bottom-right toast-container")));
		String finalnote=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(finalnote.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		Thread.sleep(2000);
		driver.close();
		

	}

}
