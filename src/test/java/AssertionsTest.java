import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssertionsTest {

    WebDriver driver;

    @BeforeEach
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280, 720));
    }
    @AfterEach
    public void DriverQuit(){
        driver.close();
        driver.quit();
    }

    @Test
    public void getTitleExample(){
    driver.navigate().to("http://wikipedia.pl");
    String WikiTitle = "Wikipedia, wolna encyklopedia";
        Assertions.assertEquals(WikiTitle, driver.getTitle(), "The title of the page is not: " + WikiTitle);
    }
    @Test
    public void getCurrentURL(){
        driver.navigate().to("http://wikipedia.pl");
        String WikiUrl = "https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna";
        Assertions.assertEquals(WikiUrl, driver.getCurrentUrl(), "The URL of the page is not: " + WikiUrl);
    }
    @Test
    public void getPageSourceExample(){
        driver.navigate().to("http://wikipedia.pl");
        String WikiLang = "/w/load.php?lang=pl&amp;modules=startup&amp;only=scripts&amp;raw=1&amp;skin=vector";
        Assertions.assertTrue(driver.getPageSource().contains(WikiLang), "Page source does not contain: " + WikiLang);
    }
}
