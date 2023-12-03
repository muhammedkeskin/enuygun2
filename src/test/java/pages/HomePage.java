package pages;

import utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "input[name='origin']")
    public WebElement originInput;

    @FindBy(css = "input[name='destination']")
    public WebElement destinationInput;

    @FindBy(css = "input[name='departureDate']")
    public WebElement departDate;

    @FindBy(xpath = "//div[text()='Dönüş Ekle']")
    public WebElement returnDate;

    @FindBy(css = "button[data-testid*='month-forward-button']")
    public WebElement monthForwardButton;

    @FindBy(xpath = "//*[text()='Aktarmasız']")
    public WebElement transitCheckbox;

    @FindBy(css = "[value='1 Yolcu / Ekonomi']")
    public WebElement passengerAndClassTypes;

    @FindBy(css = "[data-testid='flight-adult-counter-plus-button']")
    public WebElement increaseAdultCountButton;

    @FindBy(css = "[data-testid='flight-child-counter-plus-button']")
    public WebElement increaseChildCountButton;

    @FindBy(css = "[data-testid='flight-infant-counter-plus-button']")
    public WebElement increaseInfantCountButton;

    @FindBy(xpath = "//div[text()='Tamam']")
    public WebElement OkButtonForCabinType;

    @FindBy(xpath = "//div[text()='Ucuz bilet bul']")
    public WebElement searchButton;

}


