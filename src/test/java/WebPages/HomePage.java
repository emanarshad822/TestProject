package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;

    //Locators
    @FindBy(how = How.LINK_TEXT, using = "Chapter1")
    private WebElement Chapter1Link;

    @FindBy(how = How.LINK_TEXT, using = "Home Page")
    private WebElement Home;

    //Constructor
    public HomePage(WebDriver driver){
        this.driver=driver;
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void clickChapter1(){
        Chapter1Link.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}

