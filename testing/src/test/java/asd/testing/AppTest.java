package asd.testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://maxgood.work");
        
        WebElement Heading = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/main/form/h1"));
        String HeadingText = Heading.getText();
        
        assertEquals(HeadingText,"Please sign in");
        
        driver.quit();
    }
}
