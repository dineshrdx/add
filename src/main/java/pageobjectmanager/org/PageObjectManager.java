package pageobjectmanager.org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageobjectmodel.org.BookHotel;
import pageobjectmodel.org.LogOut;
import pageobjectmodel.org.LoginPage;
import pageobjectmodel.org.SearchHotel;
import pageobjectmodel.org.SelectHotel;

public class PageObjectManager {
	public static WebDriver driver;
	private LoginPage lp;
	
	private SearchHotel sh;
	
	private SelectHotel shl;
	
	private BookHotel bh ;
	
	private LogOut lo ;

	public PageObjectManager(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public LoginPage getLp() {
		 lp = new LoginPage(driver);
		return lp;
	}

	public SearchHotel getSh() {
		sh = new SearchHotel(driver);
		return sh;
	}

	public SelectHotel getShl() {
		 shl = new SelectHotel(driver);
		return shl;
	}

	public BookHotel getBh() {
		 bh = new BookHotel(driver);
		return bh;
	}

	public LogOut getLo() {
		 lo = new LogOut(driver);
		return lo;
	}
	
	
}
