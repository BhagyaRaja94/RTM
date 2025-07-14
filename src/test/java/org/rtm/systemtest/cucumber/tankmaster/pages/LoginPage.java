package org.rtm.systemtest.cucumber.tankmaster.pages;

import org.openqa.selenium.By;
import org.rtm.systemtest.cucumber.tankmaster.managers.WaitManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LoginPage {
    private  WebDriver driver;
    private final WaitManager waitManager;
    public static FileReader fileReader;
    public static Properties globalProperties = new Properties();
    private final String configFolderPath = System.getProperty("user.dir") + "/src/test/resources/config/GlobalProperties.properties";

    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement emailTextBox;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordTextBox;

    @FindBy(xpath = "//button[@value='login']")
    WebElement signInButton;


    public LoginPage(WebDriver driver, WaitManager waitManager) {
        this.driver = driver;
        this.waitManager = waitManager;
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage() throws IOException {
        fileReader= new FileReader(configFolderPath);
        globalProperties.load(fileReader);
        driver.get(globalProperties.getProperty("testUrl"));
        isPageLoaded();
    }
    public void performLogin(String email, String password) {

        emailTextBox.clear();
        emailTextBox.sendKeys(email);

        passwordTextBox.clear();
        passwordTextBox.sendKeys(password);

        signInButton.click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    private void isPageLoaded() throws Error {
        // Initial loading, called when creating the page object to make sure that the page is loaded to a state where it is ready to
        // interact with us, in our case it means that button is present in DOM and visible.
        waitManager.waitForVisibility(emailTextBox);
        waitManager.waitForVisibility(passwordTextBox);
        waitManager.waitForVisibility(signInButton);
    }

    public WebElement getLoginErrorMessage() {
        return waitManager.setupFluentWait().until(x -> driver.findElement( By.id("PasswordIncorrectTextAId")));
    }
}
