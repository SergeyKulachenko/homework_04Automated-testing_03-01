package ru.netology;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exactTextCaseSensitive;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    @Test
    void selTestForm() {   //я знаю что заомиченный код это мусор, оставил как учебный материал!
//        driver.get("http://localhost:9999");
        open("http://localhost:9999");
//        WebElement form = driver.findElement(By.cssSelector("[class='form form_size_m form_theme_alfa-on-white']"));
        SelenideElement form = $("[class='form form_size_m form_theme_alfa-on-white']");
//        form.findElement(By.cssSelector("[type='text']")).sendKeys("Николай");
        form.$("[type=text]").setValue("Николай");
        form.$("[type=tel]").setValue("+79882223345");
//        form.findElement(By.className("checkbox__box")).click();
        form.$("[class=checkbox__box]").click();
        form.$("[type=button]").click();
//        String text = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText();
//        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
        $("[data-test-id='order-success']").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void selTestSelenideTry() {
        open("http://localhost:9999");
        $("[type='text']").setValue("Николай");
        $("[type='tel']").setValue("+79882223345");
        $("[class='checkbox__box']").click();
        $("[type='button']").click();
        $("[data-test-id='order-success']").shouldHave
                (exactTextCaseSensitive(" Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

}
