import org.junit.Before;
import org.junit.Test;


public class SeleniumTestSuite {

    String[] validEmails = {
            "email@example.com",
            "firstname.lastname@example.com",
            "email@subdomain.example.com",
            "1234567890@example.com",
            "email@example-one.com",
            "_______@example.com",
            "email@example.name",
            "email@example.museum",
            "email@example.co.jp",
            "firstname-lastname@example.com",
            "firstname+lastname@example.com",
            "email@123.123.123.123",
            "\"email\"@example.com",
    };

    String[] invalidEmails = {
            "plainaddress",
            "#@%^%#$@#$@#.com",
            "@example.com",
            "Joe Smith <email@example.com>",
            "email.example.com",
            "email@example@example.com",
            ".email@example.com",
            "email.@example.com",
            "email..email@example.com",
            "あいうえお@example.com",
            "email@example.com (Joe Smith)",
            "email@example",
            "email@-example.com",
            "email@111.222.333.44444",
            "email@example..com",
            "Abc..123@example.com",
    };


    @Before
    public void setUp() {
        PracticePage.getChrome().openURL("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void fillRequiredFieldsAndSubmit() {
        PracticePage practicePage = new PracticePage();
        practicePage.fillRequiredFields();
        practicePage.submit();
        practicePage.checkRequiredFields();
    }

    //а если я хочу проверить несколько неправльных вводов сразу?
    @Test
    public void invalidBirthday() {
        PracticePage practicePage = new PracticePage();
        practicePage.fillRequiredFields();
        practicePage.fillInvalidBirthday();
        practicePage.submit();
        practicePage.checkBirthday();
    }

    //думаю так не должно быть
    @Test
    public void validEmail() {
        PracticePage practicePage = new PracticePage();
        practicePage.testEmails(true,validEmails);
    }

    @Test
    public void invalidEmail() {
        PracticePage practicePage = new PracticePage();
        practicePage.testEmails(false,invalidEmails);
    }

    //не работает (текст не берется)
//    @Test
//    public void checkBirthday() {
//        String green = "rgb(40, 167, 69)";
//        String red = "rgb(220, 53, 69)";
//
//        WebElement birthField = driver.findElement(By.id("dateOfBirthInput"));
//
//        birthField.sendKeys("wewewewewe");
//        submit();
//        Assert.assertEquals("11 Mar 2021", birthField.getText());
//        birthField.clear();
//
//        birthField.sendKeys("00");
//        submit();
//        Assert.assertEquals("11 Mar 2021", birthField.getText());
//        birthField.clear();
//    }
//
//    @Test
//    public void checkInvalidName() {
//        String green = "rgb(40, 167, 69)";
//        String red = "rgb(220, 53, 69)";
//
//        String userNameColor;
//        WebElement nameField = driver.findElement(By.id("firstName"));
//
//        nameField.sendKeys("!@#$%^&*()");
//        submit();
//        userNameColor = wait.until(ExpectedConditions.visibilityOf(nameField)).getCssValue("border-color");
//        Assert.assertEquals(red, userNameColor);
//        nameField.clear();
//
//        nameField.sendKeys("123456789");
//        submit();
//        userNameColor = wait.until(ExpectedConditions.visibilityOf(nameField)).getCssValue("border-color");
//        Assert.assertEquals(red, userNameColor);
//        nameField.clear();
//    }
//
//    @Test
//    public void checkValidLastName() {
//        String green = "rgb(40, 167, 69)";
//        String red = "rgb(220, 53, 69)";
//
//        String userLastNameColor;
//        WebElement lastNameField = driver.findElement(By.id("lastName"));
//
//        lastNameField.sendKeys("Smirnov-Konovalov");
//        submit();
//        userLastNameColor = wait.until(ExpectedConditions.visibilityOf(lastNameField)).getCssValue("border-color");
//        Assert.assertEquals(green, userLastNameColor);
//        lastNameField.clear();
//
//        lastNameField.sendKeys("Smirnov");
//        submit();
//        userLastNameColor = wait.until(ExpectedConditions.visibilityOf(lastNameField)).getCssValue("border-color");
//        Assert.assertEquals(green, userLastNameColor);
//        lastNameField.clear();
//    }
//    @Test
//    public void checkInvalidLastName() {
//        String green = "rgb(40, 167, 69)";
//        String red = "rgb(220, 53, 69)";
//
//        String userLastNameColor;
//        WebElement lastNameField = driver.findElement(By.id("lastName"));
//
//        lastNameField.sendKeys("!@#$%^&*()");
//        submit();
//        userLastNameColor = wait.until(ExpectedConditions.visibilityOf(lastNameField)).getCssValue("border-color");
//        Assert.assertEquals(red, userLastNameColor);
//        lastNameField.clear();
//
//        lastNameField.sendKeys("123456789");
//        submit();
//        userLastNameColor = wait.until(ExpectedConditions.visibilityOf(lastNameField)).getCssValue("border-color");
//        Assert.assertEquals(red, userLastNameColor);
//        lastNameField.clear();
//
//        lastNameField.sendKeys("Smirnov-");
//        submit();
//        userLastNameColor = wait.until(ExpectedConditions.visibilityOf(lastNameField)).getCssValue("border-color");
//        Assert.assertEquals(red, userLastNameColor);
//        lastNameField.clear();
//
//        lastNameField.sendKeys("-Smirnov");
//        submit();
//        userLastNameColor = wait.until(ExpectedConditions.visibilityOf(lastNameField)).getCssValue("border-color");
//        Assert.assertEquals(red, userLastNameColor);
//        lastNameField.clear();
//    }
//



}
