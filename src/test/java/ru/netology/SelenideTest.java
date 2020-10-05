package ru.netology;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exactTextCaseSensitive;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelenideTest {

    @Test
    void getTrueInputValidForm() {
        open("http://localhost:9999");
        SelenideElement form = $("[class='form form_size_m form_theme_alfa-on-white']");
        form.$("[type=text]").setValue("Николай");
        form.$("[type=tel]").setValue("+79882223345");
        form.$("[class=checkbox__box]").click();
        form.$("[type=button]").click();
        $("[data-test-id='order-success']").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void getTrueInputValidFormMethod2() {
        open("http://localhost:9999");
        $("[type='text']").setValue("Николай");
        $("[type='tel']").setValue("+79882223345");
        $("[class='checkbox__box']").click();
        $("[type='button']").click();
        $("[data-test-id='order-success']").shouldHave
                (exactTextCaseSensitive(" Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void errorExpectedWhenEmptyFieldName() {
        open("http://localhost:9999");
        $("[type='text']").setValue("");
        $("[type='tel']").setValue("+79882223345");
        $("[class='checkbox__box']").click();
        $("[type='button']").click();
        $("[class=input__sub]").shouldHave
                (exactTextCaseSensitive("Поле обязательно для заполнения"));

    }

    @Test
    void errorExpectedWhenInputIncorrectName() {
        open("http://localhost:9999");
        $("[type='text']").setValue("Nikolay");
        $("[type='tel']").setValue("+79882223345");
        $("[class='checkbox__box']").click();
        $("[type='button']").click();
        $("[class='input__sub']").shouldHave
                (exactTextCaseSensitive("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

}
