package baseclass.org;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdactinBaseclass {
	public static WebDriver driver;
	public static String value;
	
	public static WebDriver  getBrowser(String type) {			//1
		if (type.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
			 driver = new ChromeDriver();
			
		}
		else if (type.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
			 driver = new FirefoxDriver();
			}
		driver.manage().window().maximize();
		return driver;
	}
	public static  WebDriver geturl(String url) {		//2
		driver.get(url);
		return driver;
		}
	
	public static void clickonButton(WebElement element) {		//3
		element.click();

	}
	public static void valueEnterElement(WebElement element,String value ) {		//4
		element.sendKeys(value);
	}
	public static  WebDriver close() {			//5
		driver.close();
		return driver;
	}
	public static void quit() {					//6
		driver.quit();
		}
	public static WebDriver navigateto(String url) {			//7
		driver.navigate().to(url);
		return driver;
}
	public static  WebDriver navigateback() {			//8
		driver.navigate().back();
		return driver;
}
	public static WebDriver navigateforward() {			//9
		driver.navigate().forward();
		return driver;
}
	public static  WebDriver navigaterefresh() {				//10
		driver.navigate().refresh();
		return driver;

	}
	public static void dropdown(WebElement element,String type,String value) {			//11
		Select s = new Select(element);
		if (type.equalsIgnoreCase("byvalue")) {
			s.selectByValue(value);
			}
		else if (type.equalsIgnoreCase("byindex")) {
			int data = Integer.parseInt(value);
			s.selectByIndex(data); 
		}
		else if (type.equalsIgnoreCase("byvisibletext")) {
			s.selectByVisibleText(value);
		}	
		}
	
	public static void actions(String type,WebElement element,WebElement element2) {			//12
		Actions xy = new Actions(driver);
		if (type.equalsIgnoreCase("click")) {
			xy.click().build().perform();
			}
		else if (type.equalsIgnoreCase("doubleclick")) {
			xy.doubleClick().build().perform();
			}
		else if (type.equalsIgnoreCase("movetoelement")) {
			xy.moveToElement(element).build().perform();
			xy.moveToElement(element2).click().build().perform();
			}
		else if (type.equalsIgnoreCase("draganddrop")) {
			xy.dragAndDrop(element, element2).build().perform();
			}
		else if (type.equalsIgnoreCase("clickandhold")) {
			xy.clickAndHold(element).build().perform();
			xy.moveToElement(element2).build().perform();
			}
		}
	public static void alert(String acceptordismiss,String senkkeys) {		//13
		Alert alt =driver.switchTo().alert();
		if (acceptordismiss.equalsIgnoreCase("accept")) {
			alt.accept();
			}
		else if (acceptordismiss.equalsIgnoreCase("dismiss")) {
			alt.dismiss();
			}
		else if (acceptordismiss.equalsIgnoreCase("sendkeys")) {
			alt.sendKeys(senkkeys);
			alt.accept();
			}
	}
	public static void checkbox(WebElement element) {		//14
		element.click();

	}
	public static void radiobutton(WebElement element) {		//15
		element.click();
	}
	public static void isselected(WebElement element) {		//16
		if (element.isSelected()) {
			System.out.println("this button is selected");
			}
		else {
			System.out.println("this button is not selected");
		}
		}
	public static void isenabled(WebElement element) {			//17
		if (element.isEnabled()) {
			System.out.println("this button is enabled");
		} else {
			System.out.println("this button is not enabled");
		}
		}
	public static void isdisplayed(WebElement element) {			//18
		if (element.isDisplayed()) {
			System.out.println("this column is displayed");
		} else {
			System.out.println("this column is not displayed");
		}
	}
	public static void takesscreenshot(String name) throws IOException {			//19
		TakesScreenshot order = (TakesScreenshot)driver;
		File source= order.getScreenshotAs(OutputType.FILE);
		File destinstion = new File("C:\\Users\\HP\\Desktop\\screenshot\\" + name +".png");
		FileHandler.copy(source, destinstion);

	}
	public static void frame(String type,int index) {			//20
		if (type.equalsIgnoreCase("enter")) {
			driver.switchTo().frame(index);
		}
		else if (type.equalsIgnoreCase("exit")) {
			driver.switchTo().defaultContent();
		}
	}
	public static void robot(int button) throws AWTException {		//21
		Robot rdx = new Robot();
		rdx.keyPress(button);
		rdx.keyRelease(button);
	}
	public static void gettitle( ) {			//22
		 String title = driver.getTitle(); 
		System.out.println(title);

	}
	public static void getcurrenturl() {			//23
		 String currentUrl = driver.getCurrentUrl();
		 System.out.println(currentUrl);

	}
	public static void gettext(WebElement element) {		//24
		 String text = element.getText();
		System.out.println(text);
	}
	public static void getattribute(WebElement element ,String name) {			//25
		 String attribute = element.getAttribute(name);
		 System.out.println(attribute);
	}
	
	
	public static void getoptions(WebElement element) {			//26
	Select s1 = new Select(element);
	 List<WebElement> options = s1.getOptions();
	 for (WebElement option : options) {
		System.out.println(option.getText());
	}
	}
	public static void getfirstselectedoption(WebElement element) {		//27
		Select s2 = new Select(element);
		 WebElement firstSelectedOption = s2.getFirstSelectedOption() ;
		 System.out.println(firstSelectedOption.getText());
	}
	public static void getallselectedoption(WebElement element) {			//28
		Select s3 = new Select(element);
		 List<WebElement> allSelectedOptions = s3.getAllSelectedOptions();
		 for (WebElement allSelectedOption : allSelectedOptions) {
			System.out.println(allSelectedOption.getText());
		}
		}
	public static void ismultiple(WebElement element) {			//29
		Select s4 = new Select(element);
		boolean multiple = s4.isMultiple(); 
		if (multiple) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
	public static void windowhandles(String type) {				//30
		Set<String> windowHandles = driver.getWindowHandles();
		if (type.equalsIgnoreCase("first")) {
			for (String newwindow : windowHandles) {
				driver.switchTo().window(newwindow);
			}
		}
		 else if (type.equalsIgnoreCase("second")) {
			for (String secondwindow : windowHandles) {
				driver.switchTo().window(secondwindow);
			}
		}
	
	}
	
	public static void scroll (String x ,String y) {			//31
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(x+y);

	}
	public static void implicitytime(int sec,TimeUnit timeunit) {			//32
		driver.manage().timeouts().implicitlyWait(sec, timeunit);

	}
	public static void explicitytime(int sec,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,sec);
		wait.until(ExpectedConditions.visibilityOf(element));

	
}
}