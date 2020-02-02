package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartProdsListPage {
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='_3wU53n']")
	private WebElement prodLink;
	
	@FindBy(xpath="//div[text()='Relevance']")
	private WebElement sortByRelevance;
	
	@FindBy(xpath="//div[text()='Popularity']")
	private WebElement sortByPopularity;
	
	@FindBy(xpath="//div[text()='Price -- Low to High']")
	private WebElement lowestFirst;
	
	@FindBy(xpath="//div[text()='Price -- High to Low']")
	private WebElement highestFirst;
	
	@FindBy(xpath="//div[text()='Newest First']")
	private WebElement newestFirst;
	
	public FlipkartProdsListPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public FlipkartProdDescPage selectTheProd()
	{
		prodLink.click();
		return new FlipkartProdDescPage(driver);
	}
	}


