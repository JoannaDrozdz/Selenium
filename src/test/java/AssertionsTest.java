import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
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
    public void CloseAndQuit(){
        driver.close();
        driver.quit();
    }

    @Test
    public void TestIfLanguageChanged(){
        //1. Przejdź na stronę http://www.wikicytaty.pl
        driver.navigate().to("http://www.wikicytaty.pl");
        //2. Porównaj tytuł strony z oczekiwanym;
        String ExpectedPolishTitle = "Wikicytaty";
        Assertions.assertEquals(ExpectedPolishTitle, driver.getTitle(), "The title of the page is not: " + ExpectedPolishTitle);
        //3. Porównaj URL strony z oczekiwanym;
        String ExpectedPolishUrl = "https://pl.wikiquote.org/wiki/Strona_g%C5%82%C3%B3wna";
        Assertions.assertEquals(ExpectedPolishUrl, driver.getCurrentUrl(), "Current URL is not: " + ExpectedPolishUrl);
        //4. Znajdź w konsoli deweloperskiej w zakładce "Elements" fragment źródła strony, który mówi o tym w jakiej wersji językowej jest strona i użyj go do asercji;
        String PolishLanguage = "lang=\"pl\"";
        Assertions.assertTrue(driver.getPageSource().contains(PolishLanguage), "Page source does not contain: " + PolishLanguage);
        //5. Zmień język strony na niemiecki;
        driver.findElement(By.cssSelector("a[title='Hauptseite – niemiecki']")).click();
        //6. Porównaj tytuł strony z oczekiwanym;
        String ExpectedGermanTitle = "Wikiquote";
        Assertions.assertEquals(ExpectedGermanTitle, driver.getTitle(), "The title of the page is not: " + ExpectedGermanTitle);
        //7. Porównaj URL strony z oczekiwanym;
        String ExpectedGermanUrl = "https://de.wikiquote.org/wiki/Hauptseite";
        Assertions.assertEquals(ExpectedGermanUrl, driver.getCurrentUrl(), "Current URL is not: " + ExpectedGermanUrl);
        //8. Znajdź w konsoli deweloperskiej w zakładce "Elements" fragment źródła strony, który mówi o tym w jakiej wersji językowej jest strona i użyj go do asercji;
        String GermanLanguage = "lang=\"de\"";
        Assertions.assertTrue(driver.getPageSource().contains(GermanLanguage), "Page source does not contain: " + GermanLanguage);

    }
}
