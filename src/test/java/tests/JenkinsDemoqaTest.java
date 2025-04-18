package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class JenkinsDemoqaTest extends TestBase {

    @Test
    @Tag("demoqa")
    void registrationDemoqaTest() {

        step("Open form", () -> {
            open("/");
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
        });
        step("Fill form", () -> {
            $("#firstName").setValue("Alina");
            $("#lastName").setValue("Kovrigina");
            $("#userEmail").setValue("alina885@mail.ru");
            $("label[for='gender-radio-2']").click();
            $("#userNumber").setValue("1122334455");
            $("#dateOfBirthInput").click();
            $("select.react-datepicker__year-select").selectOption("1905");
            $("select.react-datepicker__month-select").selectOption("April");
            $("div.react-datepicker__day--005").click();
            $("#subjectsInput").setValue("Math").pressEnter();
            $("label[for='hobbies-checkbox-1']").click();
            $("#uploadPicture").uploadFromClasspath(("picture.png"));
            $("#currentAddress").setValue("Moscow55");
            $("#react-select-3-input").setValue("Haryana").pressEnter();
            $("#react-select-4-input").setValue("Karnal").pressEnter();
            $("#submit").click();
        });
        step("Verify results", () -> {
            $("div.table-responsive").shouldHave(text("Alina Kovrigina"));
            $("div.table-responsive").shouldHave(text("alina885@mail.ru"));
            $("div.table-responsive").shouldHave(text("Female"));
            $("div.table-responsive").shouldHave(text("1122334455"));
            $("div.table-responsive").shouldHave(text("05 April,1905"));
            $("div.table-responsive").shouldHave(text("Maths"));
            $("div.table-responsive").shouldHave(text("Sports"));
            $("div.table-responsive").shouldHave(text("picture.png"));
            $("div.table-responsive").shouldHave(text("Moscow55"));
            $("div.table-responsive").shouldHave(text("Haryana Karnal"));
        });
    }

}

