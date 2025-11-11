package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utility.BrowserDriver.driver;

public class signup {
    @Given("Launch browser")
    public void user_launches_browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("Navigate to url")
    public void navigateToUrl() {
        driver.get("http://www.automationexercise.com/");
    }

    //Verify that home page is visible successfully
    @Then("Verify that home page is visible successfully")
    public void verifyThatHomePageIsVisibleSuccessfully() {
        String pageTitle = driver.getTitle();
        if (pageTitle.contains("Automation Exercise")) {
            System.out.println("Home page is visible successfully");
        } else {
            System.out.println("Home page not visible");
        }
    }

    //Click on Signup button
    @When("Click on {string} button")
    public void click_on_button(String buttonName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(),'" + buttonName + "')]")
        ));
        button.click();
    }

    //Verify 'New User Signup!' is visible
    @Then("Verify {string} is visible")
    public void verifyNewUserSignupIsVisible(String newuser) {
        WebElement newUserSignup = driver.findElement(By.xpath("//h2[contains(text(),'" + newuser + "')]"));
        if (newUserSignup.isDisplayed()) {
            System.out.println("'New User Signup!' is visible");
        }
    }

    //Enter name and email address
    @When("Enter name and email address")
    public void enterNameAndEmailAddress() {
        WebElement nameField = driver.findElement(By.name("name"));
        nameField.sendKeys("Test User");

        WebElement emailFeild = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        emailFeild.sendKeys("poonam95@gmail.com");
    }

    @And("Click Signup button")
    public void clickSignupButton() {
        WebElement signButton = driver.findElement(By.xpath("//button[contains(text(), 'Signup')]"));
        signButton.click();
        System.out.println("Signup button clicked successfully");

    }

    //Verify that 'ENTER ACCOUNT INFORMATION' is visible
    @Then("Verify that {string} is visible")
    public void verifyThatENTERACCOUNTINFORMATIONIsVisible(String enterInfo) {
        WebElement accountInfo = driver.findElement(By.xpath("//h2[contains(text(),'" + enterInfo + "')]"));
        if (accountInfo.isDisplayed()) {
            System.out.println("'Enter Account Information' is visible");
        }

    }

    //Fill details: Title, Name, Email, Password, Date of birth
    @When("Fill details: Title, Name, Email, Password, Date of birth")
    public void fillDetailsTitleNameEmailPasswordDateOfBirth() {
        WebElement titleRadioButton = driver.findElement(By.id("id_gender2"));
        titleRadioButton.click();
        System.out.println("Radio button clicked successfully");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("poonam@123");

        Select day = new Select(driver.findElement(By.id("days")));
        day.selectByValue("10");

        Select month = new Select(driver.findElement(By.id("months")));
        month.selectByValue("5");

        Select year = new Select(driver.findElement(By.id("years")));
        year.selectByValue("1980");
    }

    //Select checkbox 'Sign up for our newsletter!'

    @Then("Select checkbox {string}")
    public void select_checkbox(String checkboxName) {
        WebElement checkbox = switch (checkboxName.toLowerCase()) {
            case "sign up for our newsletter!" -> driver.findElement(By.id("newsletter"));
            case "receive special offers from our partners!" -> driver.findElement(By.id("optin"));
            default -> throw new IllegalArgumentException("Unknown checkbox: " + checkboxName);
        };

        if (checkbox != null && !checkbox.isSelected()) {
            checkbox.click();
            System.out.println("Checkbox selected: " + checkboxName);
        } else {
            System.out.println("Checkbox already selected or not found: " + checkboxName);
        }
    }

    @When("Fill details: First name, Last name, Company, Address, Country, State, City, Zipcode, Mobile Number")
    public void fillDetailsFirstNameLastNameCompanyAddressAddressCountryStateCityZipcodeMobileNumber() {
        WebElement firstName = driver.findElement(By.id("first_name"));
        firstName.sendKeys("Poonam");

        WebElement lastName = driver.findElement(By.id("last_name"));
        lastName.sendKeys("Kumari");

        WebElement company = driver.findElement(By.id("company"));
        company.sendKeys("abc");

        WebElement address = driver.findElement(By.id("address1"));
        address.sendKeys("123 long drive");

        Select country = new Select(driver.findElement(By.id("country")));
        country.selectByVisibleText("United States");

        WebElement state = driver.findElement(By.id("state"));
        state.sendKeys("PA");

        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("Malvern");

        WebElement zipcode = driver.findElement(By.id("zipcode"));
        zipcode.sendKeys("12345");

        WebElement phone = driver.findElement(By.id("mobile_number"));
        phone.sendKeys("1234567890");
    }

    @And("Click Create Account button")
    public void clickCreateAccountButton() {
        WebElement createAccountButton = driver.findElement(By.xpath("//button[contains(text(),'Create Account')]"));
        createAccountButton.click();
        System.out.println("Created Account successfully");

    }


    @Then("Verify that ACCOUNT CREATED! is visible")
    public void verifyThatACCOUNTCREATEDIsVisible() {
        WebElement accountCreated = driver.findElement(By.xpath("//b[contains(text(),'Account Created!')]"));
        if (accountCreated.isDisplayed()) {
            System.out.println("'ACCOUNT CREATED!' is visible");
        }

    }

    @When("Click Continue button")
    public void clickContinueButton() {
        WebElement clickContinueButton = driver.findElement(By.xpath("//a[contains(text(),'Continue')]"));
        clickContinueButton.click();
        System.out.println("Click continue button successfully");
    }

    @Then("Verify that Logged in as username is visible")
    public void verifyThatLoggedInAsUsernameIsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loggedInText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Logged in as')]"))
        );
        Assert.assertTrue(loggedInText.isDisplayed());
        System.out.println(" Verified: Logged in as username is visible");
    }

    @When("Click Delete Account button")
    public void clickDeleteAccountButton() {
        WebElement clickDeleteButton = driver.findElement(By.xpath("//a[contains(text(),'Delete Account')]"));
        clickDeleteButton.click();
        System.out.println("Click Delete button successfully");
    }

    @Then("Verify that ACCOUNT DELETED! is visible and click Continue button")
    public void verifyThatACCOUNTDELETEDIsVisibleAndClickContinueButton() {
        WebElement accountDeleted = driver.findElement(By.xpath("//b[contains(text(),'Account Deleted!')]"));
        if (accountDeleted.isDisplayed()) {
            System.out.println("'ACCOUNT Deleted!' is visible");
        }
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement clickContinueButton = driver.findElement(By.xpath("//a[contains(text(),'Continue')]"));
        clickContinueButton.click();
        System.out.println("Click continue button successfully");
    }
}


