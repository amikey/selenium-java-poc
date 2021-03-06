import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GoogleClickTest {

	WebDriver driver;
	boolean phantomJS = true;

	@Before
	public void setup() {
		
		if(phantomJS){
			DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
			capabilities.setJavascriptEnabled(true); 
			capabilities.setCapability("phantomjs.binary.path", System.getProperty("phantomjs.binary"));

			//former try to set to system properties
			System.setProperty("webdriver.phantomjs.driver", System.getProperty("phantomjs.binary"));
			
			driver = new PhantomJSDriver(capabilities);
		}else{
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
		}
		
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void simpleGoogleTest() {

		// And now use this to visit Google
		driver.get("http://www.google.com");

		// Find the text input element by its name
		WebElement element = driver.findElement(By.name("q"));

		// Enter something to search for
		element.sendKeys("Cheese!");

		// Now submit the form. WebDriver will find the form for us from the
		// element
		element.submit();

		// Check the title of the page
		System.out.println("Page title is: " + driver.getTitle());

	}

}
