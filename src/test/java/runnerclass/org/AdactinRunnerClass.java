package runnerclass.org;


import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import baseclass.org.AdactinBaseclass;
import pageobjectmanager.org.PageObjectManager;

public class AdactinRunnerClass extends AdactinBaseclass {
	public static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		
		driver=getBrowser("chrome");
		geturl("https://adactinhotelapp.com/");
		PageObjectManager pom = new PageObjectManager(driver);
		
		valueEnterElement(pom.getLp().getEmail(), "dineshbabu10");
		valueEnterElement(pom.getLp().getPassword(),"dineshrdx");
		clickonButton(pom.getLp().getSubmit());
		System.out.println("login completed");
		
		dropdown(pom.getSh().getLocation(), "byvisibletext", "London");
		dropdown(pom.getSh().getHotel(), "byvisibletext", "Hotel Sunshine");
		dropdown(pom.getSh().getRoomtype(), "byvisibletext", "Super Deluxe");
		dropdown(pom.getSh().getRoomno(), "byindex", "2");
		pom.getSh().getCheckin().clear();
		valueEnterElement(pom.getSh().getCheckin(), "06/06/2022");
		pom.getSh().getCheckout().clear();
		valueEnterElement(pom.getSh().getCheckout(), "07/06/2022");
		dropdown(pom.getSh().getAdult(), "byindex", "2");
		dropdown(pom.getSh().getChild(), "byvalue", "0");
		clickonButton(pom.getSh().getSubmit());
		System.out.println("details completed");
		
		clickonButton(pom.getShl().getButton());
		clickonButton(pom.getShl().getBook());
		System.out.println(" hotel selected");
		
		valueEnterElement(pom.getBh().getFirstname(), "dinesh");
		valueEnterElement(pom.getBh().getLastname(),"babu");
		valueEnterElement(pom.getBh().getAddress(), "street:  49 rose street\"\r\n" + 
								"  city:  birmingham");
		valueEnterElement(pom.getBh().getCcnum(), "4567432356004321");
		dropdown(pom.getBh().getCctype(), "byvisibletext", "VISA");
		dropdown(pom.getBh().getExpmonth(), "byvisibletext", "May");
		dropdown(pom.getBh().getExpyear(), "byvisibletext", "2022");
		valueEnterElement(pom.getBh().getCcv(), "446");
		clickonButton(pom.getBh().getBooked());
		System.out.println("hotel booked");
		
		Thread.sleep(20000);
		
		scroll("window.scrollBy(0,400)", "");
		
		takesscreenshot("adactinhotelbooked");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)", "");
		
		clickonButton(pom.getLo().getLogout());
		System.out.println("logout ");
		
		driver.close();
		
	}
}


