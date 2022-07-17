package Tests;

import com.gmail.cage7676.model.MainPage;
import com.gmail.cage7676.model.Order;
import com.gmail.cage7676.model.OrderDetailsFormPage;
import org.junit.Test;
import com.gmail.cage7676.model.BaseUITest;


public class OrderPageScooterTest extends BaseUITest {


    @Test
    public void orderScooterButtonUp() {
        // Проверки уведомления с окном об успешном выполнении заказа нет, т.к. не работает кнопка подтверждения в принципе, на стенде никак не увидеть это уведомлени.
        Order order = new Order("Тест", "Юзер", "Тестовый адрес", "Автозаводская", "89607779485", "18.07.2022", "четверо суток", "black", "Оставьте у подъезда");

        OrderDetailsFormPage isInputDataBlockDisplayed = new MainPage(driver)
                .open()
                .acceptCookie()
                .clickOrderTopButton()
                .fillOrderDetailsForm(order);
    }
    @Test
    public void orderScooterButtonDown() {

        Order order = new Order("Павел", "Викторович", "Город Тверь", "Автозаводская", "89607044248", "20.07.2022", "двое суток", "grey", "Без комментариев");

        OrderDetailsFormPage isInputDataBlockDisplayed = new MainPage(driver)
                .open()
                .acceptCookie()
                .clickOrderButtonDown()
                .fillOrderDetailsForm(order);
    }
}