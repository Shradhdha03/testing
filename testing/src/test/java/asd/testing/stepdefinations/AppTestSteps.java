package asd.testing.stepdefinations;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AppTestSteps {

	ChromeDriver  driver;

	@Given("I open Chrome Browser")
	public void i_open_chrome_browser() {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
	}

	@Given("I visit {string}")
	public void i_visit(String url) {
		driver.get(url);
	}

	@Given("I enter email {string}")
	public void i_enter_email(String email) {
		WebElement UsernameTextBox = driver.findElement(By.name("email"));
		UsernameTextBox.sendKeys(email);

	}

	@Given("I enter password {string}")
	public void i_enter_password(String password) {
		WebElement PasswordTextBox = driver.findElement(By.name("password"));
		PasswordTextBox.sendKeys(password);
	}

	@When("I click submit button")
	public void i_click_submit_button() {
		WebElement SigninButton = driver.findElement(By.id("submit-signin"));
		SigninButton.click();
	}

	@Then("I get error message {string}")
	public void i_get_error_message(String errorMessage) {
		WebDriverWait Wait = new WebDriverWait(driver, 3);
		Wait.until(ExpectedConditions.presenceOfElementLocated(By.id("alert")));
		WebElement ResultSpan = driver.findElement(By.id("alert"));
		String Message = ResultSpan.getText();
		driver.close();
		assertEquals(Message, errorMessage);
	}

}
