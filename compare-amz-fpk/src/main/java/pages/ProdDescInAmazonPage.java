package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProdDescInAmazonPage {
	WebDriver driver;
	
	@FindBy(id="priceblock_ourprice")
	private WebElement productPrice;
	
	@FindBy(id="add-to-cart-button")
	private WebElement addToCartBTN;
	
	@FindBy(id="buy-now-button")
	private WebElement buyNowBTN;
	
	@FindBy(id="acrCustomerReviewLink")
	private WebElement customerReviews;
	
	
	public ProdDescInAmazonPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public String getProductPrice()
	{
		String price = productPrice.getText();
		return price;
	}
	
}
