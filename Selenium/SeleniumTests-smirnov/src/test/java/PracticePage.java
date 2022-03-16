import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticePage {
    protected static Chrome chrome = new Chrome();
    public static WebDriver driver = chrome.getChromeDriver();
    Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

    public static Chrome getChrome() {
        return chrome;
    }

    public void submit() {
        WebElement button = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", button);

        button.click();
    }

    //этого не должно быть
    private void specialSubmit() {
        WebElement button = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", button);

        button.click();//костыль чтобы увеличить время смены цвета
        button.click();button.click();button.click();button.click();button.click();button.click();button.click();button.click();button.click();button.click();button.click();
    }


    private final By firstNameBy = By.id("firstName");
    private final By lastNameBy = By.id("lastName");
    private final By userEmailBy = By.id("userEmail");
    private final By userNumberBy = By.id("userNumber");
    private final By userGenderBy = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label");
    private final By userBirthdayBy = By.id("dateOfBirthInput");


    private final By nameTable = By.xpath("//td[text()='Student Name']//following-sibling::td");
    private final By genderTable = By.xpath("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[3]/td[2]");
    private final By phoneTable = By.xpath("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[4]/td[2]");
    private final By birthdayTable = By.xpath("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[5]/td[2]");


    public void fillRequiredFields() {
        driver.findElement(firstNameBy).sendKeys("Alex");
        driver.findElement(lastNameBy).sendKeys("Smirnov");
        driver.findElement(userNumberBy).sendKeys("9991112223");
        driver.findElement(userGenderBy).click();
    }

    public void checkRequiredFields() {
        Assert.assertEquals("Alex Smirnov", driver.findElement(nameTable).getText());
        Assert.assertEquals("Male", driver.findElement(genderTable).getText());
        Assert.assertEquals("9991112223", driver.findElement(phoneTable).getText());
    }


    public void fillInvalidBirthday() {
        driver.findElement(userBirthdayBy).sendKeys("eeee");
    }

    public void checkBirthday() {
        Assert.assertEquals("12 March,2021", driver.findElement(birthdayTable).getText());
    }

    public void testEmails(Boolean validity, String[] validEmails) {

        String validColor;
        if(validity){validColor =  "rgb(40, 167, 69)";}else {validColor =  "rgb(220, 53, 69)";}

        String userEmailColor;
        WebElement emailField = driver.findElement(userEmailBy);

        for(String email: validEmails){
            emailField.sendKeys(email);
            specialSubmit();
            userEmailColor = wait.until(ExpectedConditions.visibilityOf(emailField)).getCssValue("border-color");
            Assert.assertEquals(validColor, userEmailColor);
            emailField.clear();
        }
    }

}
