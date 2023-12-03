package steps;

import pages.HomePage;
import utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import static utilities.PageUtils.*;

import java.util.List;

public class HomePageSteps extends HomePage {

    List<WebElement> date;

    public void selectOrigin(String origin) {
        typeToInput(originInput, origin);
        originInput.sendKeys(Keys.ENTER);
    }

    public void selectDestination(String destination) {
        typeToInput(destinationInput, destination);
        destinationInput.sendKeys(Keys.ENTER);
    }

    public void selectDepartDate(String day, String month, String year) {
        clickElement(departDate);
        selectingDateProcess(day, month, year);
    }

    public void selectReturnDate(String day, String month, String year) {
        clickElement(returnDate);
        selectingDateProcess(day, month, year);
    }

    private void selectingDateProcess(String day, String month, String year) {
        var SPECIFIC_DATE_TEXT = By.xpath("//h3[contains(text(),'" + month + " " + year + "')]/../../div[3]//button[@data-day='" + day + "']");
        date = Driver.getDriver().findElements(SPECIFIC_DATE_TEXT);

        var counter = 0;
        while (date.isEmpty() && counter<6) {
            clickNextMountButton();
            date = Driver.getDriver().findElements(SPECIFIC_DATE_TEXT);
            counter++;
        }

        var message = "1 yıldan daha uzun bir tarih seçildi";
        Assert.assertTrue(message,counter<6);

        date.get(0).click();
    }

    private void clickNextMountButton() {
        clickElement(monthForwardButton);
    }

    public void chooseNonStopFlight(String type) {
        if (type.equals("true")) {
            clickElement(transitCheckbox);
        }
    }

    public HomePageSteps selectPassengersCounts(int adultsCount, int childrenCount, int infantsCount) {
        clickElement(passengerAndClassTypes);

        for (int i = 0;i<adultsCount-1;i++) {
            clickElement(increaseAdultCountButton);
        }

        for (int i = 0;i<childrenCount;i++) {
            clickElement(increaseChildCountButton);
        }

        for (int i = 0;i<infantsCount;i++) {
            clickElement(increaseInfantCountButton);
        }

        return this;
    }

    public void selectCabinType(String cabinType) {
        Driver.getDriver().findElements(By.xpath("//div[text()=' "+ cabinType +" ']"));
        clickElement(OkButtonForCabinType);
    }

    public void searchForResults() {
        clickElement(searchButton);
    }

    public void verifyThatNavigatedToResultsPage() {
        var title = Driver.getDriver().getTitle();
        var message = "Results Page geçilemedi";
        Assert.assertTrue(message, title.contains("uçak bileti fiyatları - ENUYGUN"));
    }

    public void resultsShouldBeOnlyNonStopFlights() {
        var nonStop = "Direkt Uçuş";
        var results = Driver.getDriver().findElements(By.cssSelector(".summary-transit"));
        var message = "uçuşlar sadece aktarmasızları içermiyor";
        Assert.assertTrue(message, results.stream().map(WebElement::getText).allMatch(n -> n.equals(nonStop)));
    }

}