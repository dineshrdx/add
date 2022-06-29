package pageobjectmodel.org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotel {
	public static WebDriver driver;
	
	@FindBy(name="radiobutton_0")
	private WebElement button;
	
	@FindBy(id="continue")
	private WebElement book;

	public SelectHotel(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public WebElement getButton() {
		return button;
	}

	public WebElement getBook() {
		return book;
	}
}
