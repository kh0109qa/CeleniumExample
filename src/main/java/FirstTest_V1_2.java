import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstTest_V1_2 {
    String Money_Transfer_URL = "https://next.privat24.ua/payments/dashboard";
    String USER_IBAN = "UA333510050000026005325079000";
    String First_Name = "Slava";
    String Resipient = "Bocharov";
    String Ipn = "12345678";
    String Summ = "100";
    String CardNumber = "4552331448138217";
    String Exp = "12/25";
    String CVV = "123";
    String FirstName = "Slava";
    String LastName = "Bocharov";
    By ibanNumber = By.xpath("//input[@data-qa-node='query']");
    By submit_1 = By.xpath("//button[contains(text(),'За реквізитами')]");
    By firstName = By.xpath("//textarea[@data-qa-node='FIO']");
    By recipient = By.xpath("//textarea[@data-qa-node='CUSTOM_COMPANY']");
    By ipn = By.xpath("//textarea[@data-qa-node='CUSTOM_OKPO']");
    By sum = By.xpath("//input[@data-qa-node='SUM']");
    By cardNumber = By.xpath("//input[@data-qa-node='numberdebitSource']");
    By exp = By.xpath("//input[@data-qa-node='expiredebitSource']");
    By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
    By fistname = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
    By lastname = By.xpath("//input[@data-qa-node='lastNamedebitSource']");
    By submit_2 = By.xpath("//button[contains(text(),'Далі')]");
    By submit_3 = By.xpath("//button[contains(text(),'Додати в кошик')]");


    @Test
    public void checkCardOne() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //TODO: add wait for elements

        driver.get(Money_Transfer_URL);
        WebElement ibanElement = wait.until(ExpectedConditions.visibilityOfElementLocated(ibanNumber));
        ibanElement.sendKeys(USER_IBAN);
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submit_1));
        submitButton.click();

        wait.until(ExpectedConditions.urlContains("https://next.privat24.ua/payments/form"));

        WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
        nameElement.sendKeys(First_Name);

        driver.findElement(recipient).sendKeys(Resipient);
        driver.findElement(ipn).sendKeys(Ipn);
        driver.findElement(sum).sendKeys(Summ);
        driver.findElement(cardNumber).sendKeys(CardNumber);
        driver.findElement(exp).sendKeys(Exp);
        driver.findElement(cvv).sendKeys(CVV);

        WebElement fistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(fistname));
        nameElement.sendKeys(FirstName);

        driver.findElement(fistname).sendKeys(FirstName);
        driver.findElement(lastname).sendKeys(LastName);
        driver.findElement(submit_2).click();

        WebElement button3Element = wait.until(ExpectedConditions.visibilityOfElementLocated(submit_3));
        driver.findElement(submit_3).click();

        //TODO add assertion


    }
}