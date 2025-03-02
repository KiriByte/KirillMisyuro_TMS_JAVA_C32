import com.kiribyte.fastfood.services.impl.*;
import com.kiribyte.fastfood.services.interfaces.*;

import javax.sound.midi.Receiver;

public class Main {
    public static void main(String[] args) {

        String name = "Kirill Misyuro";
        String deliveryAddress;

        ILoggerService loggerService = new LoggerConsoleImpl();

        IOrderReceiver orderPhoneReceiver = new ReceiverOrderPhoneImpl(loggerService);
        IOrderReceiver orderOnlineReceiver = new ReceiverOrderOnlineImpl(loggerService);
        IOrderStorage orderStorage = new StorageOrderImpl(loggerService);
        ICookingProcessor cookingProcessor = new SimpleCookingProcessorImpl(loggerService);
        IOrderDelivery orderPickupDelivery = new DeliveryPickupImpl(loggerService);
        IOrderDelivery orderCourierDelivery = new DeliveryCourierImpl(loggerService);

        //Заказ по телефону - самовывоз
        IFastFoodService service1 = new FastFoodService(orderPhoneReceiver,
                orderStorage,
                cookingProcessor,
                orderPickupDelivery);
        deliveryAddress = "window";
        service1.handleOrder(name, deliveryAddress);

        System.out.println("\r\n-------------------------\r\n");

        //Заказ онлайн - доставка курьером
        IFastFoodService service2 = new FastFoodService(orderOnlineReceiver,
                orderStorage,
                cookingProcessor,
                orderCourierDelivery);
        deliveryAddress = "Hrodna";
        service2.handleOrder(name, deliveryAddress);


    }
}