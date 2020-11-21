package WebPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Chapter1Page {
    private WebDriver driver;

    //Locators
    @FindBy(how = How.LINK_TEXT, using = "Chapter1")
    private WebElement Chapter1Link;

    @FindBy(how = How.LINK_TEXT, using = "Home Page")
    private WebElement Home;

    //Constructor
    public Chapter1Page(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToHome(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Home.click();
        }
    }

